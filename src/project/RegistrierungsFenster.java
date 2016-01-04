package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegistrierungsFenster extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrierungsFenster frame = new RegistrierungsFenster();
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
	public RegistrierungsFenster() {
		setTitle("Registrierung");
		//setDefaultCloseOperation(RegistrierungsFenster.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][bottom]"));
		
		JLabel lblNewLabel = new JLabel("Vorname:");
		contentPane.add(lblNewLabel, "cell 0 0,alignx trailing");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 1 0,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nachname:");
		contentPane.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 1 1,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("E-Mail:");
		contentPane.add(lblNewLabel_2, "cell 0 2,alignx trailing");
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 1 2,growx");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Passwort:");
		contentPane.add(lblNewLabel_3, "cell 0 3,alignx trailing");
		
		passwordField = new JPasswordField();
		contentPane.add(passwordField, "cell 1 3,growx");
		
		JLabel lblNewLabel_4 = new JLabel("Passwort wiederholen:");
		contentPane.add(lblNewLabel_4, "cell 0 4,alignx trailing");
		
		passwordField_1 = new JPasswordField();
		contentPane.add(passwordField_1, "cell 1 4,growx");
		
		JLabel lblNewLabel_5 = new JLabel("Sicherheitsfrage auswählen:");
		contentPane.add(lblNewLabel_5, "cell 0 5,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Wo bist du geboren?", "Wie lautet der Name deines Haustieres?", "Geburtsname der Mutter?"}));
		contentPane.add(comboBox, "cell 1 5,growx");
		
		JLabel lblNewLabel_6 = new JLabel("Antwort:");
		contentPane.add(lblNewLabel_6, "cell 0 6,alignx trailing");
		
		textField_3 = new JTextField();
		contentPane.add(textField_3, "cell 1 6,growx");
		textField_3.setColumns(10);
		
		JButton btnErstellen = new JButton("Erstellen");
		contentPane.add(btnErstellen, "cell 0 7,alignx center,aligny bottom");
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		contentPane.add(btnAbbrechen, "cell 1 7,alignx center,aligny bottom");
	}

}
