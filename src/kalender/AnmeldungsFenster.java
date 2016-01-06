package kalender;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class AnmeldungsFenster extends JDialog {

	private JTextField textEmail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnmeldungsFenster frame = new AnmeldungsFenster();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AnmeldungsFenster() {
		setModal(true);
		setAlwaysOnTop(true);
		setTitle("Anmeldung Kalender");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new MigLayout("", "[172.00px][28.00][172.00px]", "[19px][19px][19px][19px][19px][25px][19px][25px]"));
		
		JLabel lblEmail = new JLabel("Emailadresse: ");
		getContentPane().add(lblEmail, "cell 0 1,alignx left,aligny center");
		
		textEmail = new JTextField();
		getContentPane().add(textEmail, "cell 2 1,growx,alignx left,aligny top");
		textEmail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Passwort:           ");
		getContentPane().add(lblNewLabel, "cell 0 3,alignx left");
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		getContentPane().add(passwordField, "cell 2 3,growx,aligny center");
		
		JButton btnPasswortVergessen = new JButton("Passwort vergessen");
		btnPasswortVergessen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PasswortVergessenFenster fens = new PasswortVergessenFenster();
				fens.setVisible(true);
			}
		});
		getContentPane().add(btnPasswortVergessen, "cell 0 5,growx,aligny center");
		
		JButton btnRegistrierung = new JButton("Registrierung");
		btnRegistrierung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrierungsFenster fenster = new RegistrierungsFenster();
				fenster.setVisible(true);
			}
		});
		getContentPane().add(btnRegistrierung, "cell 2 5,growx");
		
		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String email = textEmail.getText();
				String passwort = passwordField.getText();
				if (!Person.ueberpruefeDaten(email,passwort)){
					JOptionPane.showMessageDialog(getContentPane(), "Falsches Passwort oder falscher Benutzername!");
				}else{
					ArrayList<String> daten = Person.getPersonenDaten(email);
					dispose();
					Person per = new Person(daten.get(0),daten.get(1),daten.get(2),daten.get(3),daten.get(4),daten.get(5));
					AngemeldetMonatFenster fen = new AngemeldetMonatFenster(per);
					fen.getFrame().setVisible(true);
				}
			}
		});
		getContentPane().add(btnOk, "cell 0 7,growx");
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//AbgemeldetMonatFenster kk = new AbgemeldetMonatFenster();
				dispose();
			}
		});
		getContentPane().add(btnAbbrechen, "cell 2 7,growx");
	}

}
