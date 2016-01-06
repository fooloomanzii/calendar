package kalender;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TerminAendernLoeschenFenster extends JDialog {

	private JFrame frame;
	private JTextField TitelText;
	private JTextField DatumVonText;
	private JTextField UhrzeitVonText;
	private JTextField UhrzeitBisText;
	private JTextField OrtText;
	private JTextField BeschreibungText;
	private JTextField DatumBisText; 

	/**
	 * Create the dialog.
	 */
	public TerminAendernLoeschenFenster( final Termin termin) {
		setTitle("Termin verwalten");
		setModal(true);
		setAlwaysOnTop(true);
		
		setBounds(100, 100, 450, 436);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblTitel = new JLabel("Titel");
		GridBagConstraints gbc_lblTitel = new GridBagConstraints();
		gbc_lblTitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitel.gridx = 2;
		gbc_lblTitel.gridy = 1;
		getContentPane().add(lblTitel, gbc_lblTitel);
		
		TitelText = new JTextField();
		GridBagConstraints gbc_TitelText = new GridBagConstraints();
		gbc_TitelText.insets = new Insets(0, 0, 5, 0);
		gbc_TitelText.fill = GridBagConstraints.HORIZONTAL;
		gbc_TitelText.gridx = 6;
		gbc_TitelText.gridy = 1;
		getContentPane().add(TitelText, gbc_TitelText);
		TitelText.setText(termin.getTitel());
		TitelText.setColumns(10);
		
		JLabel lblDatumVon = new JLabel("Datum (von)");
		GridBagConstraints gbc_lblDatumVon = new GridBagConstraints();
		gbc_lblDatumVon.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatumVon.gridx = 2;
		gbc_lblDatumVon.gridy = 2;
		getContentPane().add(lblDatumVon, gbc_lblDatumVon);
		
		DatumVonText = new JTextField();
		DatumVonText.setToolTipText("");
		GridBagConstraints gbc_DatumVonText = new GridBagConstraints();
		gbc_DatumVonText.insets = new Insets(0, 0, 5, 0);
		gbc_DatumVonText.fill = GridBagConstraints.HORIZONTAL;
		gbc_DatumVonText.gridx = 6;
		gbc_DatumVonText.gridy = 2;
		getContentPane().add(DatumVonText, gbc_DatumVonText);
		DatumVonText.setText(termin.getDatumVon());
		DatumVonText.setColumns(10);
		
		JLabel lblDatumBis = new JLabel("Datum (bis)");
		GridBagConstraints gbc_lblDatumBis = new GridBagConstraints();
		gbc_lblDatumBis.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatumBis.gridx = 2;
		gbc_lblDatumBis.gridy = 3;
		getContentPane().add(lblDatumBis, gbc_lblDatumBis);
		
		DatumBisText = new JTextField();
		GridBagConstraints gbc_DatumBisText = new GridBagConstraints();
		gbc_DatumBisText.insets = new Insets(0, 0, 5, 0);
		gbc_DatumBisText.fill = GridBagConstraints.HORIZONTAL;
		gbc_DatumBisText.gridx = 6;
		gbc_DatumBisText.gridy = 3;
		getContentPane().add(DatumBisText, gbc_DatumBisText);
		DatumBisText.setText(termin.getDatumBis());
		DatumBisText.setColumns(10);
		
		JLabel lblUhrzeitVon = new JLabel("Uhrzeit (von)");
		GridBagConstraints gbc_lblUhrzeitVon = new GridBagConstraints();
		gbc_lblUhrzeitVon.insets = new Insets(0, 0, 5, 5);
		gbc_lblUhrzeitVon.gridx = 2;
		gbc_lblUhrzeitVon.gridy = 4;
		getContentPane().add(lblUhrzeitVon, gbc_lblUhrzeitVon);
		
		UhrzeitVonText = new JTextField();
		GridBagConstraints gbc_UhrzeitVonText = new GridBagConstraints();
		gbc_UhrzeitVonText.insets = new Insets(0, 0, 5, 0);
		gbc_UhrzeitVonText.fill = GridBagConstraints.HORIZONTAL;
		gbc_UhrzeitVonText.gridx = 6;
		gbc_UhrzeitVonText.gridy = 4;
		getContentPane().add(UhrzeitVonText, gbc_UhrzeitVonText);
		UhrzeitVonText.setText(termin.getUhrzeitVon());
		UhrzeitVonText.setColumns(10);
		
		JLabel lblUhrzeitBIs = new JLabel("Uhrzeit (bis)");
		GridBagConstraints gbc_lblUhrzeitBIs = new GridBagConstraints();
		gbc_lblUhrzeitBIs.insets = new Insets(0, 0, 5, 5);
		gbc_lblUhrzeitBIs.gridx = 2;
		gbc_lblUhrzeitBIs.gridy = 5;
		getContentPane().add(lblUhrzeitBIs, gbc_lblUhrzeitBIs);
		
		UhrzeitBisText = new JTextField();
		GridBagConstraints gbc_UhrzeitBisText = new GridBagConstraints();
		gbc_UhrzeitBisText.insets = new Insets(0, 0, 5, 0);
		gbc_UhrzeitBisText.fill = GridBagConstraints.HORIZONTAL;
		gbc_UhrzeitBisText.gridx = 6;
		gbc_UhrzeitBisText.gridy = 5;
		getContentPane().add(UhrzeitBisText, gbc_UhrzeitBisText);
		UhrzeitBisText.setText(termin.getUhrzeitBis());
		UhrzeitBisText.setColumns(10);
		
		JLabel lblOrt = new JLabel("Ort");
		GridBagConstraints gbc_lblOrt = new GridBagConstraints();
		gbc_lblOrt.insets = new Insets(0, 0, 5, 5);
		gbc_lblOrt.gridx = 2;
		gbc_lblOrt.gridy = 6;
		getContentPane().add(lblOrt, gbc_lblOrt);
		
		OrtText = new JTextField();
		GridBagConstraints gbc_OrtText = new GridBagConstraints();
		gbc_OrtText.insets = new Insets(0, 0, 5, 0);
		gbc_OrtText.fill = GridBagConstraints.HORIZONTAL;
		gbc_OrtText.gridx = 6;
		gbc_OrtText.gridy = 6;
		getContentPane().add(OrtText, gbc_OrtText);
		OrtText.setText(termin.getOrt());
		OrtText.setColumns(10);
		
		JLabel lblWiederholung = new JLabel("Wiederholung");
		GridBagConstraints gbc_lblWiederholung = new GridBagConstraints();
		gbc_lblWiederholung.insets = new Insets(0, 0, 5, 5);
		gbc_lblWiederholung.gridx = 2;
		gbc_lblWiederholung.gridy = 7;
		getContentPane().add(lblWiederholung, gbc_lblWiederholung);
		
		final JComboBox WiederholungComboBox = new JComboBox();
		WiederholungComboBox.setModel(new DefaultComboBoxModel(new String[] {"Einmalig", "Täglich", "Wöchentlich", "Monatlich", "Jährlich"}));
		GridBagConstraints gbc_WiederholungComboBox = new GridBagConstraints();
		gbc_WiederholungComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_WiederholungComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_WiederholungComboBox.gridx = 6;
		gbc_WiederholungComboBox.gridy = 7;
		int k = 0;
		if (termin.getWiederholung().equals("Täglich")){
			k = 1;
		}if (termin.getWiederholung().equals("Wöchentlich")){
			k = 2;
		}if (termin.getWiederholung().equals("Monatlich")){
			k = 3;
		}if (termin.getWiederholung().equals("Jährlich")){
			k = 4;
		}
		WiederholungComboBox.setSelectedIndex(k);
		getContentPane().add(WiederholungComboBox, gbc_WiederholungComboBox);
		
		JLabel lblBeschreibung = new JLabel("Beschreibung");
		GridBagConstraints gbc_lblBeschreibung = new GridBagConstraints();
		gbc_lblBeschreibung.insets = new Insets(0, 0, 5, 5);
		gbc_lblBeschreibung.gridx = 2;
		gbc_lblBeschreibung.gridy = 8;
		getContentPane().add(lblBeschreibung, gbc_lblBeschreibung);
		
		BeschreibungText = new JTextField();
		GridBagConstraints gbc_BeschreibungText = new GridBagConstraints();
		gbc_BeschreibungText.insets = new Insets(0, 0, 5, 0);
		gbc_BeschreibungText.fill = GridBagConstraints.HORIZONTAL;
		gbc_BeschreibungText.gridx = 6;
		gbc_BeschreibungText.gridy = 8;
		getContentPane().add(BeschreibungText, gbc_BeschreibungText);
		BeschreibungText.setText(termin.getBeschreibung());
		BeschreibungText.setColumns(10);
		
		JLabel lblSichtbarkeit = new JLabel("Sichtbarkeit");
		GridBagConstraints gbc_lblSichtbarkeit = new GridBagConstraints();
		gbc_lblSichtbarkeit.insets = new Insets(0, 0, 5, 5);
		gbc_lblSichtbarkeit.gridx = 2;
		gbc_lblSichtbarkeit.gridy = 9;
		getContentPane().add(lblSichtbarkeit, gbc_lblSichtbarkeit);
		
		final JComboBox SichtbarkeitComboBox = new JComboBox();
		SichtbarkeitComboBox.setModel(new DefaultComboBoxModel(new String[] {"oeffentlich", "privat"}));
		GridBagConstraints gbc_SichtbarkeitComboBox = new GridBagConstraints();
		gbc_SichtbarkeitComboBox.insets = new Insets(0, 0, 5, 0);
		gbc_SichtbarkeitComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_SichtbarkeitComboBox.gridx = 6;
		gbc_SichtbarkeitComboBox.gridy = 9;
		int i = 1;
		if (termin.getSichtbarkeit().equals("oeffentlich")){
			i = 0;
		}
		SichtbarkeitComboBox.setSelectedIndex(i);
		getContentPane().add(SichtbarkeitComboBox, gbc_SichtbarkeitComboBox);
		
		JButton btnErstellen = new JButton("Aendern");
		btnErstellen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String titel = TitelText.getText();
				String datumVon = DatumVonText.getText();
				String datumBis = DatumBisText.getText();
				String uhrzeitVon = UhrzeitVonText.getText();
				String uhrzeitBis = UhrzeitBisText.getText();
				String ort = OrtText.getText();
				String beschreibung = BeschreibungText.getText();
				String wiederholung = WiederholungComboBox.getSelectedItem().toString();
				String sichtbarkeit = SichtbarkeitComboBox.getSelectedItem().toString();
				if(titel.equals("") || datumVon.equals("") || datumBis.equals("") || uhrzeitVon.equals("") || uhrzeitBis.equals("")){
					new JFrame("Bitte fuellen Sie die notwendigen Fenster aus").setVisible(true);
					JOptionPane.showMessageDialog(frame, "Bitte fuellen Sie die notwendigen Fenster aus!");
				}else{
					if (wiederholung.equals("Einmalig")){
						Termin termin1 = termin;
						termin.terminAendern(termin1, titel, datumVon, datumBis, uhrzeitVon, uhrzeitBis, ort, beschreibung, wiederholung, sichtbarkeit);
						dispose();
					}else{
						JOptionPane.showMessageDialog(frame,"Work in Progress");
					}
				}
			}
		});
		
		GridBagConstraints gbc_btnErstellen = new GridBagConstraints();
		gbc_btnErstellen.insets = new Insets(0, 0, 0, 5);
		gbc_btnErstellen.gridx = 4;
		gbc_btnErstellen.gridy = 11;
		getContentPane().add(btnErstellen, gbc_btnErstellen);
		
		JButton btnAbbruch = new JButton("Abbruch");
		btnAbbruch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnAbbruch = new GridBagConstraints();
		gbc_btnAbbruch.gridx = 6;
		gbc_btnAbbruch.gridy = 11;
		getContentPane().add(btnAbbruch, gbc_btnAbbruch);
	}
}