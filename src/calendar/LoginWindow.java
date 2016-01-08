package calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;

public class LoginWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JTextField textEmail;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public LoginWindow() {
		getContentPane().setBackground(new Color(0, 102, 0));
		getContentPane().setForeground(new Color(0, 0, 0));
		setModal(true);
		setAlwaysOnTop(true);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 0, 400, 250);
		getContentPane().setLayout(new MigLayout("", "[172.00px][28.00][172.00px]", "[19px][19px][19px][19px][19px][25px][19px][25px]"));
		
		JLabel lblEmail = new JLabel("E-Mail: ");
		lblEmail.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblEmail.setForeground(Color.RED);
		getContentPane().add(lblEmail, "cell 0 1,alignx left,aligny center");
		textEmail = new JTextField();
		getContentPane().add(textEmail, "cell 2 1,growx,alignx left,aligny top");
		textEmail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblPassword.setForeground(Color.RED);
		getContentPane().add(lblPassword, "cell 0 3,alignx left");
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		getContentPane().add(passwordField, "cell 2 3,growx,aligny center");
		
		JButton btnForgotPassword = new JButton("Forgot Password ?");
		btnForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgotPasswordWindow fens = new ForgotPasswordWindow();
				fens.setVisible(true);
			}
		});
		getContentPane().add(btnForgotPassword, "cell 0 5,growx,aligny center");
		
		JButton btnRegistration = new JButton("Registration");
		btnRegistration.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrationWindow fenster = new RegistrationWindow();
				fenster.setVisible(true);
			}
		});
		getContentPane().add(btnRegistration, "cell 2 5,growx");
		
		JButton btnOkay = new JButton("Okay");
		btnOkay.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String email = textEmail.getText();
				String password = passwordField.getText();
				if (!Person.checkDataPerson(email,password)){
					JOptionPane.showMessageDialog(getContentPane(), "Wrong Password or Wrong Username!");
				}else{
					ArrayList<String> data = Person.getPersonData(email);
					dispose();
					Person per = new Person(data.get(0),data.get(1),data.get(2),data.get(3),data.get(4),data.get(5));
					LoginCalendarWindow win = new LoginCalendarWindow(per);
					win.getFrame().setVisible(true);
				}
			}
		});
		getContentPane().add(btnOkay, "cell 0 7,growx");
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				LogoutCalendarWindow win = new LogoutCalendarWindow();
				win.getFrame().setVisible(true);
			}
		});
		getContentPane().add(btnExit, "cell 2 7,growx");
		
	}

}