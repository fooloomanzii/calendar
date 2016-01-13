package calendar;

import java.awt.EventQueue;

import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChangePasswordWindow extends JDialog {
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePasswordWindow dialog = new ChangePasswordWindow();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	**
	 * Create the dialog.
	 */
	public ChangePasswordWindow(final Client loginPerson) {
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][5px:n:5px][][5px:n:5px][][][5px:n:5px][]"));
		
		JLabel lblOldPassword = new JLabel("Old Password:");
		getContentPane().add(lblOldPassword, "cell 0 0,alignx trailing");
		
		passwordField = new JPasswordField();
		getContentPane().add(passwordField, "cell 1 0,growx");
		
		JLabel lblNewPassword = new JLabel("New Password:");
		getContentPane().add(lblNewPassword, "cell 0 2,alignx trailing");
		
		passwordField_1 = new JPasswordField();
		getContentPane().add(passwordField_1, "cell 1 2,growx");
		
		JLabel lblNewLabel = new JLabel("Repeat Password:");
		getContentPane().add(lblNewLabel, "cell 0 4,alignx trailing");
		
		passwordField_2 = new JPasswordField();
		getContentPane().add(passwordField_2, "cell 1 4,growx");
		
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String oldPassword = passwordField.getText();
				String newPassword = passwordField_1.getText();
				String repeatPassword = passwordField_2.getText();
				if (!newPassword.equals(repeatPassword)){
					JOptionPane.showMessageDialog(getContentPane(), "The new entered passwords do not match","",JOptionPane.ERROR_MESSAGE);
				}else if(!Client.checkDataPerson(loginPerson.getid(), oldPassword)){
					JOptionPane.showMessageDialog(getContentPane(), "The old password is wrong!","",JOptionPane.ERROR_MESSAGE);
				}else if(newPassword.length()<5){
					JOptionPane.showMessageDialog(getContentPane(), "The password must have five characters at least.","",JOptionPane.ERROR_MESSAGE);
				}else{
					loginPerson.changeDataPerson(loginPerson.getFirstName(), loginPerson.getSurname(), newPassword, loginPerson.getid(), loginPerson.getSecurityQuestion(), loginPerson.getAnswer());
					setVisible(false);
					LoginCalendarWindow win = new LoginCalendarWindow(loginPerson);
					win.getFrame().setVisible(true);
				}
				
			}
		});
		getContentPane().add(btnChange, "cell 0 7");
		
		JButton btnCancle = new JButton("Cancle");
		btnCancle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				LoginCalendarWindow win = new LoginCalendarWindow(loginPerson);
				win.getFrame().setVisible(true);
			}
		});
		getContentPane().add(btnCancle, "cell 1 7,alignx right");

	}

}
