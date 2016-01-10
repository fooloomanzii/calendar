package calendar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Font;

public class RegistrationWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JTextField textFirstName;
	private JTextField textSurname;
	private JTextField textEMail;
	private JPasswordField passwordField;
	private JPasswordField repeatPasswordField;
	private JTextField textAnswer;

	/**
	 * Create the RegistrationWindow.
	 */
	public RegistrationWindow() {
		getContentPane().setBackground(Color.WHITE);
		setModal(true);
		setAlwaysOnTop(true);
		setTitle("Registration");
		setBounds(450, 0, 500, 300);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][grow 10][bottom]"));

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblFirstName.setForeground(Color.DARK_GRAY);
		getContentPane().add(lblFirstName, "cell 0 0,alignx trailing");
		textFirstName = new JTextField();
		getContentPane().add(textFirstName, "cell 1 0,growx");
		textFirstName.setColumns(10);

		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblSurname.setForeground(Color.DARK_GRAY);
		getContentPane().add(lblSurname, "cell 0 1,alignx trailing");
		textSurname = new JTextField();
		getContentPane().add(textSurname, "cell 1 1,growx");
		textSurname.setColumns(10);

		JLabel lblEMail = new JLabel("E-Mail:");
		lblEMail.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblEMail.setForeground(Color.DARK_GRAY);
		getContentPane().add(lblEMail, "cell 0 2,alignx trailing");
		textEMail = new JTextField();
		getContentPane().add(textEMail, "cell 1 2,growx");
		textEMail.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblPassword.setForeground(Color.DARK_GRAY);
		getContentPane().add(lblPassword, "cell 0 3,alignx trailing");
		passwordField = new JPasswordField();
		getContentPane().add(passwordField, "cell 1 3,growx");

		JLabel lblRepeatPassword = new JLabel("Password (Repeat):");
		lblRepeatPassword.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblRepeatPassword.setForeground(Color.DARK_GRAY);
		getContentPane().add(lblRepeatPassword, "cell 0 4,alignx trailing");
		repeatPasswordField = new JPasswordField();
		getContentPane().add(repeatPasswordField, "cell 1 4,growx");

		JLabel lblSecurityQuestion = new JLabel("Security Question:");
		lblSecurityQuestion.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblSecurityQuestion.setForeground(Color.DARK_GRAY);
		getContentPane().add(lblSecurityQuestion, "cell 0 5,alignx trailing");
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Where were you born?", "What is the name of your pet?", "What is your mothers maiden name?"}));
		getContentPane().add(comboBox, "cell 1 5,growx");

		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblAnswer.setForeground(Color.DARK_GRAY);
		getContentPane().add(lblAnswer, "cell 0 6,alignx trailing");
		textAnswer = new JTextField();
		getContentPane().add(textAnswer, "cell 1 6,growx");
		textAnswer.setColumns(10);

		JButton btnOkay = new JButton("Okay");
		btnOkay.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				String firstName = textFirstName.getText();
				String surname = textSurname.getText();
				String email = textEMail.getText();
				String password = passwordField.getText();
				String passwordRepeat = repeatPasswordField.getText();
				String question = comboBox.getSelectedItem().toString();
				String answer = textAnswer.getText();
				if (firstName.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "No First Name!");
				} else if (surname.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "No Surname!");
				} else if (email.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "No E-Mail!");
				} else if (password.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "No Passwort!");
				} else if (answer.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "No Answer");
				} else if (password.length() < 5) {
					JOptionPane.showMessageDialog(getContentPane(), "The password must have five characters at least.");
				} else if (!password.equals(passwordRepeat)) {
					JOptionPane.showMessageDialog(getContentPane(), "The entered passwords do not match");
				} else if (Client.emailAlreadyExist(email)) {
					JOptionPane.showMessageDialog(getContentPane(), "The E-Mail-Adress is already used!");
				} else {
					Client.insertNewPerson(firstName, surname, password, email, question, answer);
					JOptionPane.showMessageDialog(getContentPane(), "Account has been created successfully!");
					dispose();
				}
			}
		});
		getContentPane().add(btnOkay, "cell 0 8,alignx center,aligny bottom");
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnExit, "cell 1 8,alignx center,aligny bottom");
	}
	
}