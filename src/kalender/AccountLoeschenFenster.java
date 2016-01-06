package kalender;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class AccountLoeschenFenster extends JDialog {

	private JPasswordField passwordField;
	private JPasswordField passwordFieldWieder;

	public AccountLoeschenFenster(final Person personAngemeldet) {
		setModal(true);
		setAlwaysOnTop(true);
		setTitle("Registrierung");
		//setDefaultCloseOperation(RegistrierungsFenster.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 329);
		getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][bottom]"));
		
		JLabel lblNewLabel_3 = new JLabel("Passwort:");
		getContentPane().add(lblNewLabel_3, "cell 0 3,alignx trailing");
		
		passwordField = new JPasswordField();
		getContentPane().add(passwordField, "cell 1 3,growx");
		
		JLabel lblNewLabel_4 = new JLabel("Passwort wiederholen:");
		getContentPane().add(lblNewLabel_4, "cell 0 4,alignx trailing");
		
		passwordFieldWieder = new JPasswordField();
		getContentPane().add(passwordFieldWieder, "cell 1 4,growx");
		
		JButton btnErstellen = new JButton("ok");
		btnErstellen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (passwordFieldWieder.getText().equals(personAngemeldet.getPasswort()) && passwordField.getText().equals(personAngemeldet.getPasswort())){
					try {
						personAngemeldet.personLoeschen(personAngemeldet.getEmail(), personAngemeldet.getPasswort());
						System.out.println("Account wurde erfolgreich geloescht");
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					
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
}

