package calendar;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;

public class ForgotPasswordWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JTextField textid;
	private JTextField textAnswer;

	/**
	 * Create the dialog.
	 */
	public ForgotPasswordWindow() {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Forgot Password");
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(450, 0, 530, 200);
		getContentPane().setLayout(new MigLayout("", "[153.00][grow]", "[25px][25px][25px][25px][25px]"));
		
		JLabel lblid = new JLabel("Username:");
		lblid.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblid.setForeground(Color.DARK_GRAY);
		getContentPane().add(lblid, "cell 0 0,alignx trailing");
		textid = new JTextField();
		getContentPane().add(textid, "cell 1 0,grow");
		textid.setColumns(10);
		
		JLabel lblSecurityQuestion = new JLabel("Security Question:");
		lblSecurityQuestion.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblSecurityQuestion.setForeground(Color.DARK_GRAY);
		getContentPane().add(lblSecurityQuestion, "cell 0 1,alignx trailing");
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Where were you born?", "What is the name of your pet?", "What is your mother's maiden name?"}));
		getContentPane().add(comboBox, "cell 1 1,growx");
		
		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblAnswer.setForeground(Color.DARK_GRAY);
		getContentPane().add(lblAnswer, "cell 0 2,alignx trailing");
		textAnswer = new JTextField();
		getContentPane().add(textAnswer, "cell 1 2,grow");
		textAnswer.setColumns(10);
		
		JButton btnOkay = new JButton("Okay");
		btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id=textid.getText();
				String answer=textAnswer.getText();
				String question=comboBox.getSelectedItem().toString();
				String password = Client.passwordData(id,answer,question);
				if (password.equals("")){
					JOptionPane.showMessageDialog(getContentPane(), "Data not correct. Password could not be restored!","",JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(getContentPane(), "Password: " + password);
					dispose();
				}
			}
		});
		getContentPane().add(btnOkay, "cell 0 4,alignx center");
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnExit, "cell 1 4,alignx center");
		
	}

}