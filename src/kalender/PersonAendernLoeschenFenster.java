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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class PersonAendernLoeschenFenster extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textVorname;
	private JTextField textNachname;
	private JTextField textAntwort;

	/**
	 * Create the dialog.
	 */
	public PersonAendernLoeschenFenster(final Person personAngemeldet) {
		setModal(true);
		setAlwaysOnTop(true);
		setTitle("Registrierung");
		//setDefaultCloseOperation(RegistrierungsFenster.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 329);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][bottom][][]"));
		
		JLabel lblNewLabel = new JLabel("Vorname:");
		getContentPane().add(lblNewLabel, "cell 0 0,alignx trailing");
		
		textVorname = new JTextField();
		getContentPane().add(textVorname, "cell 1 0,growx");
		textVorname.setText(personAngemeldet.getVorname());
		textVorname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nachname:");
		getContentPane().add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		textNachname = new JTextField();
		getContentPane().add(textNachname, "cell 1 1,growx");
		textNachname.setText(personAngemeldet.getNachname());
		textNachname.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Sicherheitsfrage auswählen:");
		getContentPane().add(lblNewLabel_5, "cell 0 5,alignx trailing");
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Wo bist du geboren?", "Wie lautet der Name deines Haustieres?", "Geburtsname der Mutter?"}));
		int i = 2;
		if(personAngemeldet.getSicherheitsfrage().equals(comboBox.getModel().getElementAt(0))){
			i = 0;
		}else if(personAngemeldet.getSicherheitsfrage().equals(comboBox.getModel().getElementAt(1))){
			i = 1;
		}
		comboBox.setSelectedIndex(i);
		getContentPane().add(comboBox, "cell 1 5,growx");
		
		JLabel lblNewLabel_6 = new JLabel("Antwort:");
		getContentPane().add(lblNewLabel_6, "cell 0 6,alignx trailing");
		
		textAntwort = new JTextField();
		getContentPane().add(textAntwort, "cell 1 6,growx");
		textAntwort.setText(personAngemeldet.getAntwort());
		textAntwort.setColumns(10);
		
		JButton btnErstellen = new JButton("Aendern");
		btnErstellen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String vorname = textVorname.getText();
				String nachname = textNachname.getText();
				String frage = comboBox.getSelectedItem().toString();
				String antwort = textAntwort.getText();
				if (vorname.equals("")){
					System.out.println("Kein Vorname angegeben!");
				}
				else if (nachname.equals("")){
					System.out.println("Kein Nachname angegeben!");
				}else{
						personAngemeldet.persoenlicheDatenAendern(nachname, vorname, personAngemeldet.getPasswort(), personAngemeldet.getEmail(), frage, antwort);
						System.out.println("Account wurde erfolgreich geaendert");
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
		
		JButton btnLoeschen = new JButton("Account Loeschen");
		getContentPane().add(btnLoeschen, "cell 0 8,alignx center");
		
		JButton btnPasswortAendern = new JButton("Passwort aendern");
		getContentPane().add(btnPasswortAendern, "cell 0 9,alignx center");
	}



}