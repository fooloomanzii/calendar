package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnmeldungsFenster extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
		setTitle("Anmeldung Kalender");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[207.00px][][165.00px]", "[19px][19px][19px][19px][19px][25px][19px][25px]"));
		
		JLabel lblBenutzername = new JLabel("Benutzername: ");
		contentPane.add(lblBenutzername, "cell 0 1,alignx left,aligny center");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 2 1,growx,alignx left,aligny top");
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Passwort:           ");
		contentPane.add(lblNewLabel, "cell 0 3,alignx left");
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		contentPane.add(passwordField, "cell 2 3,growx,aligny center");
		
		JButton btnPasswortVergessen = new JButton("Passwort vergessen");
		btnPasswortVergessen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		contentPane.add(btnPasswortVergessen, "cell 0 5,alignx center,aligny center");
		
		JButton btnRegistrierung = new JButton("Registrierung");
		btnRegistrierung.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistrierungsFenster fenster = new RegistrierungsFenster();
				fenster.setVisible(true);
			}
		});
		contentPane.add(btnRegistrierung, "cell 2 5");
		
		JButton btnNewButton = new JButton("Ok");
		contentPane.add(btnNewButton, "cell 0 7,alignx center");
		
		JButton btnAbbruch = new JButton("Abbruch");
		contentPane.add(btnAbbruch, "cell 2 7");
	}

}
