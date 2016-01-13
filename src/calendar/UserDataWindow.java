package calendar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class UserDataWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFirstname;
	private JTextField textSurname;
	private JTextField textAnswer;

	/**
	 * Create the dialog.
	 */
	public UserDataWindow(final Client personAngemeldet) {
		setModal(true);

		setTitle("User Data");
		// setDefaultCloseOperation(RegistrierungsFenster.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 329);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][bottom][][]"));

		JLabel lblNewLabel = new JLabel("Firstname:");
		getContentPane().add(lblNewLabel, "cell 0 0,alignx trailing");

		textFirstname = new JTextField();
		getContentPane().add(textFirstname, "cell 1 0,growx");
		textFirstname.setText(personAngemeldet.getFirstName());
		textFirstname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Surname:");
		getContentPane().add(lblNewLabel_1, "cell 0 1,alignx trailing");

		textSurname = new JTextField();
		getContentPane().add(textSurname, "cell 1 1,growx");
		textSurname.setText(personAngemeldet.getSurname());
		textSurname.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Choose security question:");
		getContentPane().add(lblNewLabel_5, "cell 0 5,alignx trailing");

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Where were you born?",
				"What is the name of your pet?", "What is your mothers maiden name?" }));
		int i = 2;
		if (personAngemeldet.getSecurityQuestion().equals(comboBox.getModel().getElementAt(0))) {
			i = 0;
		} else if (personAngemeldet.getSecurityQuestion().equals(comboBox.getModel().getElementAt(1))) {
			i = 1;
		}
		comboBox.setSelectedIndex(i);
		getContentPane().add(comboBox, "cell 1 5,growx");

		JLabel lblNewLabel_6 = new JLabel("Answer:");
		getContentPane().add(lblNewLabel_6, "cell 0 6,alignx trailing");

		textAnswer = new JTextField();
		getContentPane().add(textAnswer, "cell 1 6,growx");
		textAnswer.setText(personAngemeldet.getAnswer());
		textAnswer.setColumns(10);

		JButton btnChange = new JButton("Change");
		btnChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String firstname = textFirstname.getText();
				String surname = textSurname.getText();
				String question = comboBox.getSelectedItem().toString();
				String answer = textAnswer.getText();
				if (firstname.equals("")) {
					System.out.println("Kein Vorname angegeben!");
				} else if (surname.equals("")) {
					System.out.println("Kein Nachname angegeben!");
				} else {
					personAngemeldet.changeDataPerson(firstname, surname, personAngemeldet.getPassword(),
							personAngemeldet.getid(), question, answer);
					System.out.println("Account wurde erfolgreich geaendert");
					dispose();
				}
			}
		});
		getContentPane().add(btnChange, "cell 0 7,alignx center,aligny bottom");
		JButton btnCancle = new JButton("Cancle");
		btnCancle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnCancle, "cell 1 7,alignx center,aligny bottom");

		JButton btnLoeschen = new JButton("delete account");
		btnLoeschen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				DeleteUserWindow dwin = new DeleteUserWindow(personAngemeldet);
				dwin.setVisible(true);

			}
		});
		getContentPane().add(btnLoeschen, "cell 0 8,alignx center");

		JButton btnPasswortAendern = new JButton("change password");
		getContentPane().add(btnPasswortAendern, "cell 0 9,alignx center");
		btnPasswortAendern.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				ChangePasswordWindow pwin = new ChangePasswordWindow(personAngemeldet);
				pwin.setVisible(true);
			}
		});
	}

}
