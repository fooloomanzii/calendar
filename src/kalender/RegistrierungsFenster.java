package kalender;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class RegistrierungsFenster extends JDialog {
	private JTextField textVorname;
	private JTextField textNachname;
	private JTextField textEMail;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldWieder;
	private JTextField textAntwort;
	private Person angemeldet;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegistrierungsFenster dialog = new RegistrierungsFenster();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegistrierungsFenster() {
		setModal(true);
		setAlwaysOnTop(true);
		setTitle("Registrierung");
		// setDefaultCloseOperation(RegistrierungsFenster.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 329);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][bottom]"));

		JLabel lblNewLabel = new JLabel("Vorname:");
		getContentPane().add(lblNewLabel, "cell 0 0,alignx trailing");

		textVorname = new JTextField();
		getContentPane().add(textVorname, "cell 1 0,growx");
		textVorname.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nachname:");
		getContentPane().add(lblNewLabel_1, "cell 0 1,alignx trailing");

		textNachname = new JTextField();
		getContentPane().add(textNachname, "cell 1 1,growx");
		textNachname.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("E-Mail:");
		getContentPane().add(lblNewLabel_2, "cell 0 2,alignx trailing");

		textEMail = new JTextField();
		getContentPane().add(textEMail, "cell 1 2,growx");
		textEMail.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Passwort:");
		getContentPane().add(lblNewLabel_3, "cell 0 3,alignx trailing");

		passwordField = new JPasswordField();
		getContentPane().add(passwordField, "cell 1 3,growx");

		JLabel lblNewLabel_4 = new JLabel("Passwort wiederholen:");
		getContentPane().add(lblNewLabel_4, "cell 0 4,alignx trailing");

		passwordFieldWieder = new JPasswordField();
		getContentPane().add(passwordFieldWieder, "cell 1 4,growx");

		JLabel lblNewLabel_5 = new JLabel("Sicherheitsfrage auswählen:");
		getContentPane().add(lblNewLabel_5, "cell 0 5,alignx trailing");

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Wo bist du geboren?",
				"Wie lautet der Name deines Haustieres?", "Geburtsname der Mutter?" }));
		getContentPane().add(comboBox, "cell 1 5,growx");

		JLabel lblNewLabel_6 = new JLabel("Antwort:");
		getContentPane().add(lblNewLabel_6, "cell 0 6,alignx trailing");

		textAntwort = new JTextField();
		getContentPane().add(textAntwort, "cell 1 6,growx");
		textAntwort.setColumns(10);

		JButton btnErstellen = new JButton("Erstellen");
		btnErstellen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String vorname = textVorname.getText();
				String nachname = textNachname.getText();
				String email = textEMail.getText();
				String passwort = passwordField.getText();
				String passwortwieder = passwordFieldWieder.getText();
				String frage = comboBox.getSelectedItem().toString();
				String antwort = textAntwort.getText();
				if (vorname.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "Kein Vorname angegeben!");
				} else if (nachname.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "Kein Nachname angegeben!");
				} else if (email.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "Keine Email angegeben!");
				} else if (passwort.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "Kein Passwort angegeben! Das Passwort muss mind. 5 Zeilen lang sein");
				} else if (antwort.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "Die Sicherheitsfrage wurde nicht Beantwortet");
				} else if (passwort.length() < 5) {
					JOptionPane.showMessageDialog(getContentPane(), "Das Passwort muss mind. 5 Zeichen besitzen.");
				} else if (!passwort.equals(passwortwieder)) {
					JOptionPane.showMessageDialog(getContentPane(), "Die eingegebenen Passwörter stimmen nicht überein");
				} else if (Person.emailSchonDa(email)) {
					JOptionPane.showMessageDialog(getContentPane(), "Die E-Mailadresse wird bereits verwendet!");
				} else {
						Person.insertNewPerson(nachname, vorname, passwort, email, frage, antwort);
						JOptionPane.showMessageDialog(getContentPane(), "Account wurde erfolgreich erstellt!");
						dispose();
				}
			}
		});
		getContentPane().add(btnErstellen, "cell 0 7,alignx center,aligny bottom");
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnAbbrechen, "cell 1 7,alignx center,aligny bottom");
	}
	public Person getAngemeldet(){
		return this.angemeldet;
	}
}
