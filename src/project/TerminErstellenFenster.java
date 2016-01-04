package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class TerminErstellenFenster {

	private JFrame frame;
	private JTextField TitelText;
	private JTextField DatumVonText;
	private JTextField UhrzeitVonText;
	private JTextField UhrzeitBisText;
	private JTextField OrtText;
	private JTextField BeschreibungText;
	private JTextField DatumBisText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TerminErstellenFenster window = new TerminErstellenFenster();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TerminErstellenFenster() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblTitel = new JLabel("Titel");
		GridBagConstraints gbc_lblTitel = new GridBagConstraints();
		gbc_lblTitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitel.gridx = 2;
		gbc_lblTitel.gridy = 1;
		frame.getContentPane().add(lblTitel, gbc_lblTitel);
		
		TitelText = new JTextField();
		GridBagConstraints gbc_TitelText = new GridBagConstraints();
		gbc_TitelText.insets = new Insets(0, 0, 5, 0);
		gbc_TitelText.fill = GridBagConstraints.HORIZONTAL;
		gbc_TitelText.gridx = 6;
		gbc_TitelText.gridy = 1;
		frame.getContentPane().add(TitelText, gbc_TitelText);
		TitelText.setColumns(10);
		
		JLabel lblDatumVon = new JLabel("Datum (von)");
		GridBagConstraints gbc_lblDatumVon = new GridBagConstraints();
		gbc_lblDatumVon.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatumVon.gridx = 2;
		gbc_lblDatumVon.gridy = 2;
		frame.getContentPane().add(lblDatumVon, gbc_lblDatumVon);
		
		DatumVonText = new JTextField();
		GridBagConstraints gbc_DatumVonText = new GridBagConstraints();
		gbc_DatumVonText.insets = new Insets(0, 0, 5, 0);
		gbc_DatumVonText.fill = GridBagConstraints.HORIZONTAL;
		gbc_DatumVonText.gridx = 6;
		gbc_DatumVonText.gridy = 2;
		frame.getContentPane().add(DatumVonText, gbc_DatumVonText);
		DatumVonText.setColumns(10);
		
		JLabel lblDatumBis = new JLabel("Datum (bis)");
		GridBagConstraints gbc_lblDatumBis = new GridBagConstraints();
		gbc_lblDatumBis.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatumBis.gridx = 2;
		gbc_lblDatumBis.gridy = 3;
		frame.getContentPane().add(lblDatumBis, gbc_lblDatumBis);
		
		DatumBisText = new JTextField();
		GridBagConstraints gbc_DatumBisText = new GridBagConstraints();
		gbc_DatumBisText.insets = new Insets(0, 0, 5, 0);
		gbc_DatumBisText.fill = GridBagConstraints.HORIZONTAL;
		gbc_DatumBisText.gridx = 6;
		gbc_DatumBisText.gridy = 3;
		frame.getContentPane().add(DatumBisText, gbc_DatumBisText);
		DatumBisText.setColumns(10);
		
		JLabel lblUhrzeitVon = new JLabel("Uhrzeit (von)");
		GridBagConstraints gbc_lblUhrzeitVon = new GridBagConstraints();
		gbc_lblUhrzeitVon.insets = new Insets(0, 0, 5, 5);
		gbc_lblUhrzeitVon.gridx = 2;
		gbc_lblUhrzeitVon.gridy = 4;
		frame.getContentPane().add(lblUhrzeitVon, gbc_lblUhrzeitVon);
		
		UhrzeitVonText = new JTextField();
		GridBagConstraints gbc_UhrzeitVonText = new GridBagConstraints();
		gbc_UhrzeitVonText.insets = new Insets(0, 0, 5, 0);
		gbc_UhrzeitVonText.fill = GridBagConstraints.HORIZONTAL;
		gbc_UhrzeitVonText.gridx = 6;
		gbc_UhrzeitVonText.gridy = 4;
		frame.getContentPane().add(UhrzeitVonText, gbc_UhrzeitVonText);
		UhrzeitVonText.setColumns(10);
		
		JLabel lblUhrzeitBIs = new JLabel("Uhrzeit (bis)");
		GridBagConstraints gbc_lblUhrzeitBIs = new GridBagConstraints();
		gbc_lblUhrzeitBIs.insets = new Insets(0, 0, 5, 5);
		gbc_lblUhrzeitBIs.gridx = 2;
		gbc_lblUhrzeitBIs.gridy = 5;
		frame.getContentPane().add(lblUhrzeitBIs, gbc_lblUhrzeitBIs);
		
		UhrzeitBisText = new JTextField();
		GridBagConstraints gbc_UhrzeitBisText = new GridBagConstraints();
		gbc_UhrzeitBisText.insets = new Insets(0, 0, 5, 0);
		gbc_UhrzeitBisText.fill = GridBagConstraints.HORIZONTAL;
		gbc_UhrzeitBisText.gridx = 6;
		gbc_UhrzeitBisText.gridy = 5;
		frame.getContentPane().add(UhrzeitBisText, gbc_UhrzeitBisText);
		UhrzeitBisText.setColumns(10);
		
		JLabel lblOrt = new JLabel("Ort");
		GridBagConstraints gbc_lblOrt = new GridBagConstraints();
		gbc_lblOrt.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrt.gridx = 2;
		gbc_lblOrt.gridy = 6;
		frame.getContentPane().add(lblOrt, gbc_lblOrt);
		
		OrtText = new JTextField();
		GridBagConstraints gbc_OrtText = new GridBagConstraints();
		gbc_OrtText.insets = new Insets(0, 0, 5, 0);
		gbc_OrtText.fill = GridBagConstraints.HORIZONTAL;
		gbc_OrtText.gridx = 6;
		gbc_OrtText.gridy = 6;
		frame.getContentPane().add(OrtText, gbc_OrtText);
		OrtText.setColumns(10);
		
		JLabel lblWiederholung = new JLabel("Wiederholung");
		GridBagConstraints gbc_lblWiederholung = new GridBagConstraints();
		gbc_lblWiederholung.insets = new Insets(0, 0, 5, 5);
		gbc_lblWiederholung.gridx = 2;
		gbc_lblWiederholung.gridy = 7;
		frame.getContentPane().add(lblWiederholung, gbc_lblWiederholung);
		
		JComboBox WiederholungComboBox = new JComboBox();
		WiederholungComboBox.setModel(new DefaultComboBoxModel(new String[] {"T\u00E4glich", "W\u00F6chentlich", "Monatlich", "J\u00E4hrlich"}));
		GridBagConstraints gbc_WiederholungComboBox = new GridBagConstraints();
		gbc_WiederholungComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_WiederholungComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_WiederholungComboBox.gridx = 6;
		gbc_WiederholungComboBox.gridy = 7;
		frame.getContentPane().add(WiederholungComboBox, gbc_WiederholungComboBox);
		
		JLabel lblBeschreibung = new JLabel("Beschreibung");
		GridBagConstraints gbc_lblBeschreibung = new GridBagConstraints();
		gbc_lblBeschreibung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBeschreibung.gridx = 2;
		gbc_lblBeschreibung.gridy = 8;
		frame.getContentPane().add(lblBeschreibung, gbc_lblBeschreibung);
		
		BeschreibungText = new JTextField();
		GridBagConstraints gbc_BeschreibungText = new GridBagConstraints();
		gbc_BeschreibungText.insets = new Insets(0, 0, 5, 0);
		gbc_BeschreibungText.fill = GridBagConstraints.HORIZONTAL;
		gbc_BeschreibungText.gridx = 6;
		gbc_BeschreibungText.gridy = 8;
		frame.getContentPane().add(BeschreibungText, gbc_BeschreibungText);
		BeschreibungText.setColumns(10);
		
		JLabel lblSichtbarkeit = new JLabel("Sichtbarkeit");
		GridBagConstraints gbc_lblSichtbarkeit = new GridBagConstraints();
		gbc_lblSichtbarkeit.insets = new Insets(0, 0, 5, 5);
		gbc_lblSichtbarkeit.gridx = 2;
		gbc_lblSichtbarkeit.gridy = 9;
		frame.getContentPane().add(lblSichtbarkeit, gbc_lblSichtbarkeit);
		
		JButton btnErstellen = new JButton("Erstellen");
		btnErstellen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String titel = TitelText.getText();
			}
		});
		
		JComboBox SichtbarkeitComboBox = new JComboBox();
		SichtbarkeitComboBox.setModel(new DefaultComboBoxModel(new String[] {"Oeffentlich\t", "Privat"}));
		GridBagConstraints gbc_SichtbarkeitComboBox = new GridBagConstraints();
		gbc_SichtbarkeitComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_SichtbarkeitComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_SichtbarkeitComboBox.gridx = 6;
		gbc_SichtbarkeitComboBox.gridy = 9;
		frame.getContentPane().add(SichtbarkeitComboBox, gbc_SichtbarkeitComboBox);
		GridBagConstraints gbc_btnErstellen = new GridBagConstraints();
		gbc_btnErstellen.insets = new Insets(0, 0, 0, 5);
		gbc_btnErstellen.gridx = 4;
		gbc_btnErstellen.gridy = 11;
		frame.getContentPane().add(btnErstellen, gbc_btnErstellen);
		
		JButton btnAbbruch = new JButton("Abbruch");
		GridBagConstraints gbc_btnAbbruch = new GridBagConstraints();
		gbc_btnAbbruch.gridx = 6;
		gbc_btnAbbruch.gridy = 11;
		frame.getContentPane().add(btnAbbruch, gbc_btnAbbruch);
	}

}
