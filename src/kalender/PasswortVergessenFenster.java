package kalender;

import java.awt.EventQueue;

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

public class PasswortVergessenFenster extends JDialog {
	private JTextField textEMail;
	private JTextField textAntwort;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PasswortVergessenFenster dialog = new PasswortVergessenFenster();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public PasswortVergessenFenster() {
		setTitle("Passwort Vergessen");
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(100, 100, 471, 300);
		getContentPane().setLayout(new MigLayout("", "[153.00][grow]", "[25px][25px][25px][25px][25px]"));
		
		JLabel lblEmail = new JLabel("E-Mail:");
		getContentPane().add(lblEmail, "cell 0 0,alignx trailing");
		
		textEMail = new JTextField();
		getContentPane().add(textEMail, "cell 1 0,grow");
		textEMail.setColumns(10);
		
		JLabel lblSicherheitsfrage = new JLabel("Sicherheitsfrage:");
		getContentPane().add(lblSicherheitsfrage, "cell 0 1,alignx trailing");
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Wo bist du geboren?", "Wie lautet der Name deines Haustieres?", "Geburtsname der Mutter?"}));
		getContentPane().add(comboBox, "cell 1 1,growx");
		
		JLabel lblAntwort = new JLabel("Antwort:");
		getContentPane().add(lblAntwort, "cell 0 2,alignx trailing");
		
		textAntwort = new JTextField();
		getContentPane().add(textAntwort, "cell 1 2,grow");
		textAntwort.setColumns(10);
		
		JButton btnNewButton = new JButton("    Okay    ");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String email=textEMail.getText();
				String antwort=textAntwort.getText();
				String frage=comboBox.getSelectedItem().toString();
				String passwort = Person.passwortDaten(email,frage,antwort);
				if (passwort.equals("")){
					JOptionPane.showMessageDialog(getContentPane(), "Daten nicht in Ordnung. Passwort konnte nicht wieder hergestellt werden!");
				}else{
					JOptionPane.showMessageDialog(getContentPane(), passwort);
					dispose();
				}
					
				
			}
		});
		getContentPane().add(btnNewButton, "cell 0 4,alignx center");
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		getContentPane().add(btnAbbrechen, "cell 1 4,alignx center");
		

	}

}
