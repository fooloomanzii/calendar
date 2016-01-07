package kalender;

import java.util.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AngemeldetMonatFenster {

	private JFrame frame;
	private ArrayList<JPanel> liste = new ArrayList<JPanel>();
	private ArrayList<JPanel> listeMonatsname = new ArrayList<JPanel>();
	private Calendar _kalender = new GregorianCalendar();
	private ArrayList<Termin> termine;
	private ArrayList<Termin> privateTermin;
	private Person angemeldet;
	private int start;
	private String aktuellerMonat;
	private int aktuellesJahr;
	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AngemeldetMonatFenster window = new AngemeldetMonatFenster();
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
	public AngemeldetMonatFenster(Person angemeldet) {
		//TODO
		this.angemeldet=angemeldet;
		initialize(angemeldet);
		;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(final Person angemeldet) {
		frame = new JFrame();
		frame.setAlwaysOnTop(true);
		frame.setBounds(100, 100, 703, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		termine = Termin.getTermine("oeffentlich");
		privateTermin = Termin.getTermine(angemeldet.getEmail());
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 80, 80, 80, 80, 80, 80, 80, 0};
		gridBagLayout.rowHeights = new int[] {30, 0, 30, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JButton zurueck = new JButton("<<");
		zurueck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				_kalender.set(_kalender.get(Calendar.YEAR), _kalender.get(Calendar.MONTH)-1, _kalender.get(Calendar.DATE));
				tageErstellen();
				frame.validate();
			}
		});
		GridBagConstraints gbc_zurueck = new GridBagConstraints();
		gbc_zurueck.insets = new Insets(0, 0, 5, 5);
		gbc_zurueck.gridx = 2;
		gbc_zurueck.gridy = 0;
		frame.getContentPane().add(zurueck, gbc_zurueck);
		
		JButton vor = new JButton(">>");
		vor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				_kalender.set(_kalender.get(Calendar.YEAR), _kalender.get(Calendar.MONTH)+1, _kalender.get(Calendar.DATE));
				tageErstellen();
				frame.validate();
			}
		});
		
		JPanel Monatsname = new JPanel();
		GridBagConstraints gbc_Monatsname = new GridBagConstraints();
		gbc_Monatsname.insets = new Insets(0, 0, 5, 5);
		gbc_Monatsname.fill = GridBagConstraints.BOTH;
		gbc_Monatsname.gridx = 5;
		gbc_Monatsname.gridy = 0;
		frame.getContentPane().add(Monatsname, gbc_Monatsname);
		GridBagConstraints gbc_vor = new GridBagConstraints();
		gbc_vor.insets = new Insets(0, 0, 5, 0);
		gbc_vor.gridx = 8;
		gbc_vor.gridy = 0;
		frame.getContentPane().add(vor, gbc_vor);
		listeMonatsname.add(Monatsname);
		
		JLabel lblMontag = new JLabel("Montag");
		GridBagConstraints gbc_lblMontag = new GridBagConstraints();
		gbc_lblMontag.insets = new Insets(0, 0, 5, 5);
		gbc_lblMontag.gridx = 2;
		gbc_lblMontag.gridy = 1;
		frame.getContentPane().add(lblMontag, gbc_lblMontag);
		
		JLabel lblDienstag = new JLabel("Dienstag");
		GridBagConstraints gbc_lblDienstag = new GridBagConstraints();
		gbc_lblDienstag.insets = new Insets(0, 0, 5, 5);
		gbc_lblDienstag.gridx = 3;
		gbc_lblDienstag.gridy = 1;
		frame.getContentPane().add(lblDienstag, gbc_lblDienstag);
		
		JLabel lblMittwoch = new JLabel("Mittwoch");
		GridBagConstraints gbc_lblMittwoch = new GridBagConstraints();
		gbc_lblMittwoch.insets = new Insets(0, 0, 5, 5);
		gbc_lblMittwoch.gridx = 4;
		gbc_lblMittwoch.gridy = 1;
		frame.getContentPane().add(lblMittwoch, gbc_lblMittwoch);
		
		JLabel lblDonnerstag = new JLabel("Donnerstag");
		GridBagConstraints gbc_lblDonnerstag = new GridBagConstraints();
		gbc_lblDonnerstag.insets = new Insets(0, 0, 5, 5);
		gbc_lblDonnerstag.gridx = 5;
		gbc_lblDonnerstag.gridy = 1;
		frame.getContentPane().add(lblDonnerstag, gbc_lblDonnerstag);
		
		JLabel lblFreitag = new JLabel("Freitag");
		GridBagConstraints gbc_lblFreitag = new GridBagConstraints();
		gbc_lblFreitag.insets = new Insets(0, 0, 5, 5);
		gbc_lblFreitag.gridx = 6;
		gbc_lblFreitag.gridy = 1;
		frame.getContentPane().add(lblFreitag, gbc_lblFreitag);
		
		JLabel lblSamstag = new JLabel("Samstag");
		GridBagConstraints gbc_lblSamstag = new GridBagConstraints();
		gbc_lblSamstag.anchor = GridBagConstraints.NORTH;
		gbc_lblSamstag.insets = new Insets(0, 0, 5, 5);
		gbc_lblSamstag.gridx = 7;
		gbc_lblSamstag.gridy = 1;
		frame.getContentPane().add(lblSamstag, gbc_lblSamstag);
		
		JLabel lblSonntag = new JLabel("Sonntag");
		GridBagConstraints gbc_lblSonntag = new GridBagConstraints();
		gbc_lblSonntag.insets = new Insets(0, 0, 5, 0);
		gbc_lblSonntag.gridx = 8;
		gbc_lblSonntag.gridy = 1;
		frame.getContentPane().add(lblSonntag, gbc_lblSonntag);
		
		JPanel panel_0 = new JPanel();
		GridBagConstraints gbc_panel_0 = new GridBagConstraints();
		gbc_panel_0.insets = new Insets(0, 0, 5, 5);
		gbc_panel_0.fill = GridBagConstraints.BOTH;
		gbc_panel_0.gridx = 2;
		gbc_panel_0.gridy = 2;
		frame.getContentPane().add(panel_0, gbc_panel_0);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 3;
		gbc_panel_1.gridy = 2;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 4;
		gbc_panel_2.gridy = 2;
		frame.getContentPane().add(panel_2, gbc_panel_2);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 5;
		gbc_panel_3.gridy = 2;
		frame.getContentPane().add(panel_3, gbc_panel_3);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 6;
		gbc_panel_4.gridy = 2;
		frame.getContentPane().add(panel_4, gbc_panel_4);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 5, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 7;
		gbc_panel_5.gridy = 2;
		frame.getContentPane().add(panel_5, gbc_panel_5);
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 8;
		gbc_panel_6.gridy = 2;
		frame.getContentPane().add(panel_6, gbc_panel_6);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 5, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 2;
		gbc_panel_7.gridy = 3;
		frame.getContentPane().add(panel_7, gbc_panel_7);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 3;
		gbc_panel_8.gridy = 3;
		frame.getContentPane().add(panel_8, gbc_panel_8);
		
		JPanel panel_9 = new JPanel();
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 5, 5);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 4;
		gbc_panel_9.gridy = 3;
		frame.getContentPane().add(panel_9, gbc_panel_9);
		
		JPanel panel_10 = new JPanel();
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(0, 0, 5, 5);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 5;
		gbc_panel_10.gridy = 3;
		frame.getContentPane().add(panel_10, gbc_panel_10);
		
		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 6;
		gbc_panel_11.gridy = 3;
		frame.getContentPane().add(panel_11, gbc_panel_11);
		
		JPanel panel_12 = new JPanel();
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.insets = new Insets(0, 0, 5, 5);
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 7;
		gbc_panel_12.gridy = 3;
		frame.getContentPane().add(panel_12, gbc_panel_12);
		
		JPanel panel_13 = new JPanel();
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.insets = new Insets(0, 0, 5, 0);
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.gridx = 8;
		gbc_panel_13.gridy = 3;
		frame.getContentPane().add(panel_13, gbc_panel_13);
		
		JPanel panel_14 = new JPanel();
		GridBagConstraints gbc_panel_14 = new GridBagConstraints();
		gbc_panel_14.insets = new Insets(0, 0, 5, 5);
		gbc_panel_14.fill = GridBagConstraints.BOTH;
		gbc_panel_14.gridx = 2;
		gbc_panel_14.gridy = 4;
		frame.getContentPane().add(panel_14, gbc_panel_14);
		
		JPanel panel_15 = new JPanel();
		GridBagConstraints gbc_panel_15 = new GridBagConstraints();
		gbc_panel_15.insets = new Insets(0, 0, 5, 5);
		gbc_panel_15.fill = GridBagConstraints.BOTH;
		gbc_panel_15.gridx = 3;
		gbc_panel_15.gridy = 4;
		frame.getContentPane().add(panel_15, gbc_panel_15);
		
		JPanel panel_16 = new JPanel();
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.insets = new Insets(0, 0, 5, 5);
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.gridx = 4;
		gbc_panel_16.gridy = 4;
		frame.getContentPane().add(panel_16, gbc_panel_16);
		
		JPanel panel_17 = new JPanel();
		GridBagConstraints gbc_panel_17 = new GridBagConstraints();
		gbc_panel_17.insets = new Insets(0, 0, 5, 5);
		gbc_panel_17.fill = GridBagConstraints.BOTH;
		gbc_panel_17.gridx = 5;
		gbc_panel_17.gridy = 4;
		frame.getContentPane().add(panel_17, gbc_panel_17);
		
		JPanel panel_18 = new JPanel();
		GridBagConstraints gbc_panel_18 = new GridBagConstraints();
		gbc_panel_18.insets = new Insets(0, 0, 5, 5);
		gbc_panel_18.fill = GridBagConstraints.BOTH;
		gbc_panel_18.gridx = 6;
		gbc_panel_18.gridy = 4;
		frame.getContentPane().add(panel_18, gbc_panel_18);
		
		JPanel panel_19 = new JPanel();
		GridBagConstraints gbc_panel_19 = new GridBagConstraints();
		gbc_panel_19.insets = new Insets(0, 0, 5, 5);
		gbc_panel_19.fill = GridBagConstraints.BOTH;
		gbc_panel_19.gridx = 7;
		gbc_panel_19.gridy = 4;
		frame.getContentPane().add(panel_19, gbc_panel_19);
		
		JPanel panel_20 = new JPanel();
		GridBagConstraints gbc_panel_20 = new GridBagConstraints();
		gbc_panel_20.insets = new Insets(0, 0, 5, 0);
		gbc_panel_20.fill = GridBagConstraints.BOTH;
		gbc_panel_20.gridx = 8;
		gbc_panel_20.gridy = 4;
		frame.getContentPane().add(panel_20, gbc_panel_20);
		
		JPanel panel_21 = new JPanel();
		GridBagConstraints gbc_panel_21 = new GridBagConstraints();
		gbc_panel_21.insets = new Insets(0, 0, 5, 5);
		gbc_panel_21.fill = GridBagConstraints.BOTH;
		gbc_panel_21.gridx = 2;
		gbc_panel_21.gridy = 5;
		frame.getContentPane().add(panel_21, gbc_panel_21);
		
		JPanel panel_22 = new JPanel();
		GridBagConstraints gbc_panel_22 = new GridBagConstraints();
		gbc_panel_22.insets = new Insets(0, 0, 5, 5);
		gbc_panel_22.fill = GridBagConstraints.BOTH;
		gbc_panel_22.gridx = 3;
		gbc_panel_22.gridy = 5;
		frame.getContentPane().add(panel_22, gbc_panel_22);
		
		JPanel panel_23 = new JPanel();
		GridBagConstraints gbc_panel_23 = new GridBagConstraints();
		gbc_panel_23.insets = new Insets(0, 0, 5, 5);
		gbc_panel_23.fill = GridBagConstraints.BOTH;
		gbc_panel_23.gridx = 4;
		gbc_panel_23.gridy = 5;
		frame.getContentPane().add(panel_23, gbc_panel_23);
		
		JPanel panel_24 = new JPanel();
		GridBagConstraints gbc_panel_24 = new GridBagConstraints();
		gbc_panel_24.insets = new Insets(0, 0, 5, 5);
		gbc_panel_24.fill = GridBagConstraints.BOTH;
		gbc_panel_24.gridx = 5;
		gbc_panel_24.gridy = 5;
		frame.getContentPane().add(panel_24, gbc_panel_24);
		
		JPanel panel_25 = new JPanel();
		GridBagConstraints gbc_panel_25 = new GridBagConstraints();
		gbc_panel_25.insets = new Insets(0, 0, 5, 5);
		gbc_panel_25.fill = GridBagConstraints.BOTH;
		gbc_panel_25.gridx = 6;
		gbc_panel_25.gridy = 5;
		frame.getContentPane().add(panel_25, gbc_panel_25);
		
		JPanel panel_26 = new JPanel();
		GridBagConstraints gbc_panel_26 = new GridBagConstraints();
		gbc_panel_26.insets = new Insets(0, 0, 5, 5);
		gbc_panel_26.fill = GridBagConstraints.BOTH;
		gbc_panel_26.gridx = 7;
		gbc_panel_26.gridy = 5;
		frame.getContentPane().add(panel_26, gbc_panel_26);
		
		JPanel panel_27 = new JPanel();
		GridBagConstraints gbc_panel_27 = new GridBagConstraints();
		gbc_panel_27.insets = new Insets(0, 0, 5, 0);
		gbc_panel_27.fill = GridBagConstraints.BOTH;
		gbc_panel_27.gridx = 8;
		gbc_panel_27.gridy = 5;
		frame.getContentPane().add(panel_27, gbc_panel_27);
		
		JPanel panel_28 = new JPanel();
		GridBagConstraints gbc_panel_28 = new GridBagConstraints();
		gbc_panel_28.insets = new Insets(0, 0, 5, 5);
		gbc_panel_28.fill = GridBagConstraints.BOTH;
		gbc_panel_28.gridx = 2;
		gbc_panel_28.gridy = 6;
		frame.getContentPane().add(panel_28, gbc_panel_28);
		
		JPanel panel_29 = new JPanel();
		GridBagConstraints gbc_panel_29 = new GridBagConstraints();
		gbc_panel_29.insets = new Insets(0, 0, 5, 5);
		gbc_panel_29.fill = GridBagConstraints.BOTH;
		gbc_panel_29.gridx = 3;
		gbc_panel_29.gridy = 6;
		frame.getContentPane().add(panel_29, gbc_panel_29);
		
		JPanel panel_30 = new JPanel();
		GridBagConstraints gbc_panel_30 = new GridBagConstraints();
		gbc_panel_30.insets = new Insets(0, 0, 5, 5);
		gbc_panel_30.fill = GridBagConstraints.BOTH;
		gbc_panel_30.gridx = 4;
		gbc_panel_30.gridy = 6;
		frame.getContentPane().add(panel_30, gbc_panel_30);
		
		JPanel panel_31 = new JPanel();
		GridBagConstraints gbc_panel_31 = new GridBagConstraints();
		gbc_panel_31.insets = new Insets(0, 0, 5, 5);
		gbc_panel_31.fill = GridBagConstraints.BOTH;
		gbc_panel_31.gridx = 5;
		gbc_panel_31.gridy = 6;
		frame.getContentPane().add(panel_31, gbc_panel_31);
		
		JPanel panel_32 = new JPanel();
		GridBagConstraints gbc_panel_32 = new GridBagConstraints();
		gbc_panel_32.insets = new Insets(0, 0, 5, 5);
		gbc_panel_32.fill = GridBagConstraints.BOTH;
		gbc_panel_32.gridx = 6;
		gbc_panel_32.gridy = 6;
		frame.getContentPane().add(panel_32, gbc_panel_32);
		
		JPanel panel_33 = new JPanel();
		GridBagConstraints gbc_panel_33 = new GridBagConstraints();
		gbc_panel_33.insets = new Insets(0, 0, 5, 5);
		gbc_panel_33.fill = GridBagConstraints.BOTH;
		gbc_panel_33.gridx = 7;
		gbc_panel_33.gridy = 6;
		frame.getContentPane().add(panel_33, gbc_panel_33);
		
		JPanel panel_34 = new JPanel();
		GridBagConstraints gbc_panel_34 = new GridBagConstraints();
		gbc_panel_34.insets = new Insets(0, 0, 5, 0);
		gbc_panel_34.fill = GridBagConstraints.BOTH;
		gbc_panel_34.gridx = 8;
		gbc_panel_34.gridy = 6;
		frame.getContentPane().add(panel_34, gbc_panel_34);
		
		JPanel panel_35 = new JPanel();
		GridBagConstraints gbc_panel_35 = new GridBagConstraints();
		gbc_panel_35.insets = new Insets(0, 0, 0, 5);
		gbc_panel_35.fill = GridBagConstraints.BOTH;
		gbc_panel_35.gridx = 2;
		gbc_panel_35.gridy = 7;
		frame.getContentPane().add(panel_35, gbc_panel_35);
		
		JPanel panel_36 = new JPanel();
		GridBagConstraints gbc_panel_36 = new GridBagConstraints();
		gbc_panel_36.insets = new Insets(0, 0, 0, 5);
		gbc_panel_36.fill = GridBagConstraints.BOTH;
		gbc_panel_36.gridx = 3;
		gbc_panel_36.gridy = 7;
		frame.getContentPane().add(panel_36, gbc_panel_36);
		
		JPanel panel_37 = new JPanel();
		GridBagConstraints gbc_panel_37 = new GridBagConstraints();
		gbc_panel_37.insets = new Insets(0, 0, 0, 5);
		gbc_panel_37.fill = GridBagConstraints.BOTH;
		gbc_panel_37.gridx = 4;
		gbc_panel_37.gridy = 7;
		frame.getContentPane().add(panel_37, gbc_panel_37);
		
		liste.add(panel_0);
		panel_0.setLayout(new BoxLayout(panel_0, BoxLayout.Y_AXIS));
		liste.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		liste.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		liste.add(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		liste.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		liste.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		liste.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		liste.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
		liste.add(panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
		liste.add(panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));
		liste.add(panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.Y_AXIS));
		liste.add(panel_11);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.Y_AXIS));
		liste.add(panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.Y_AXIS));
		liste.add(panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.Y_AXIS));
		liste.add(panel_14);
		panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.Y_AXIS));
		liste.add(panel_15);
		panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.Y_AXIS));
		liste.add(panel_16);
		panel_16.setLayout(new BoxLayout(panel_16, BoxLayout.Y_AXIS));
		liste.add(panel_17);
		panel_17.setLayout(new BoxLayout(panel_17, BoxLayout.Y_AXIS));
		liste.add(panel_18);
		panel_18.setLayout(new BoxLayout(panel_18, BoxLayout.Y_AXIS));
		liste.add(panel_19);
		panel_19.setLayout(new BoxLayout(panel_19, BoxLayout.Y_AXIS));
		liste.add(panel_20);
		panel_20.setLayout(new BoxLayout(panel_20, BoxLayout.Y_AXIS));
		liste.add(panel_21);
		panel_21.setLayout(new BoxLayout(panel_21, BoxLayout.Y_AXIS));
		liste.add(panel_22);
		panel_22.setLayout(new BoxLayout(panel_22, BoxLayout.Y_AXIS));
		liste.add(panel_23);
		panel_23.setLayout(new BoxLayout(panel_23, BoxLayout.Y_AXIS));
		liste.add(panel_24);
		panel_24.setLayout(new BoxLayout(panel_24, BoxLayout.Y_AXIS));
		liste.add(panel_25);
		panel_25.setLayout(new BoxLayout(panel_25, BoxLayout.Y_AXIS));
		liste.add(panel_26);
		panel_26.setLayout(new BoxLayout(panel_26, BoxLayout.Y_AXIS));
		liste.add(panel_27);
		panel_27.setLayout(new BoxLayout(panel_27, BoxLayout.Y_AXIS));
		liste.add(panel_28);
		panel_28.setLayout(new BoxLayout(panel_28, BoxLayout.Y_AXIS));
		liste.add(panel_29);
		panel_29.setLayout(new BoxLayout(panel_29, BoxLayout.Y_AXIS));
		liste.add(panel_30);
		panel_30.setLayout(new BoxLayout(panel_30, BoxLayout.Y_AXIS));
		liste.add(panel_31);
		panel_31.setLayout(new BoxLayout(panel_31, BoxLayout.Y_AXIS));
		liste.add(panel_32);
		panel_32.setLayout(new BoxLayout(panel_32, BoxLayout.Y_AXIS));
		liste.add(panel_33);
		panel_33.setLayout(new BoxLayout(panel_33, BoxLayout.Y_AXIS));
		liste.add(panel_34);
		panel_34.setLayout(new BoxLayout(panel_34, BoxLayout.Y_AXIS));
		liste.add(panel_35);
		panel_35.setLayout(new BoxLayout(panel_35, BoxLayout.Y_AXIS));
		liste.add(panel_36);
		panel_36.setLayout(new BoxLayout(panel_36, BoxLayout.Y_AXIS));
		liste.add(panel_37);
		panel_37.setLayout(new BoxLayout(panel_37, BoxLayout.Y_AXIS));
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnMen = new JMenu("Menü");
		menuBar.add(mnMen);
		
		JMenuItem mntmAbmelden = new JMenuItem("Abmelden");
		mntmAbmelden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				AbgemeldetMonatFenster fen = new AbgemeldetMonatFenster();
				fen.getFrame().setVisible(true);
			}
		});
		mnMen.add(mntmAbmelden);
		
		JMenuItem mntmBeenden = new JMenuItem("Beenden");
		mntmBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmBenutzerdatenVerwalten = new JMenuItem("Benutzerdaten verwalten");
		mntmBenutzerdatenVerwalten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame.getContentPane(), "Work in progress!");
				
				// TODO: 
			}
		});
		
		JMenuItem mntmTerminErstellen = new JMenuItem("Termin erstellen");
		mntmTerminErstellen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TerminErstellenFenster fen = new TerminErstellenFenster(angemeldet);
				fen.setVisible(true);
				termine = Termin.getTermine("oeffentlich");
				privateTermin = Termin.getTermine(angemeldet.getEmail());
				tageErstellen();
				frame.validate();
			}
		});
		mnMen.add(mntmTerminErstellen);
		mnMen.add(mntmBenutzerdatenVerwalten);
		
		JMenuItem mntmBackupAnlegen = new JMenuItem("Backup anlegen");
		mntmBackupAnlegen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame.getContentPane(), "Work in progress!");
			}
		});
		mnMen.add(mntmBackupAnlegen);
		
		JMenuItem mntmOnlinesynchronistation = new JMenuItem("Onlinesynchronistation");
		mntmOnlinesynchronistation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame.getContentPane(), "Work in progress!");
			}
		});
		mnMen.add(mntmOnlinesynchronistation);
		mnMen.add(mntmBeenden);
		
		tageInitialisieren();
	}
	
	private void tageInitialisieren(){
		int aktuellerTag = _kalender.get(Calendar.DAY_OF_MONTH);
		_kalender.set(Calendar.DAY_OF_MONTH, 1);
		int aktuellerWochentag = _kalender.get(Calendar.DAY_OF_WEEK);
		int anzahlTageMonat = _kalender.getActualMaximum(Calendar.DATE);
		int aktuellesJahr1 = _kalender.get(Calendar.YEAR);
		
		switch (aktuellerWochentag) {
	    	case 1:  start = 6; break;
	        case 2:  start = 0; break;
	        case 3:  start = 1; break;
	        case 4:  start = 2; break;
	        case 5:  start = 3; break;
	        case 6:  start = 4; break;
	        case 7:  start = 5; break;
	        default: start = 10; break;
	    }
	
		int tag=1;
		for(int i = start; i<anzahlTageMonat+start; i++){
			String t = tag + "";
			if(tag == aktuellerTag){
				JLabel hallo = new JLabel(t);
				hallo.setAlignmentX(Component.CENTER_ALIGNMENT);
				liste.get(i).setBackground(Color.RED);
				liste.get(i).add(hallo);
				
			}else{
				JLabel hallo = new JLabel(t);
				hallo.setAlignmentX(Component.CENTER_ALIGNMENT);
				liste.get(i).add(hallo);
			}
			tag++;
		}
		
		String monat = _kalender.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " + aktuellesJahr1;
		listeMonatsname.get(0).add(new JLabel(monat));
		aktuellerMonat = monat;
		aktuellesJahr = aktuellesJahr1;
		
		terminDarstellen();
		
	}
	
	private void tageErstellen(){
		_kalender.set(Calendar.DAY_OF_MONTH, 1);
		int aktuellerWochentag = _kalender.get(Calendar.DAY_OF_WEEK);
		int anzahlTageMonat = _kalender.getActualMaximum(Calendar.DATE);
		int aktuellesJahr1 = _kalender.get(Calendar.YEAR);
		String m = _kalender.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		
		String monat = m + " " + aktuellesJahr1;
		listeMonatsname.get(0).removeAll();
		listeMonatsname.get(0).add(new JLabel(monat));
		
		switch (aktuellerWochentag) {
	    	case 1:  start = 6; break;
	        case 2:  start = 0; break;
	        case 3:  start = 1; break;
	        case 4:  start = 2; break;
	        case 5:  start = 3; break;
	        case 6:  start = 4; break;
	        case 7:  start = 5; break;
	        default: start = 10; break;
	    }
	
		int tag=1;
		int counter = 0;
		for(int i = 0; i<liste.size(); i++){
			String t = tag + "";
			if(i<start){
				liste.get(i).removeAll();
				liste.get(i).setBackground(Color.getHSBColor(0.0f, 0.0f, 0.93f));
				counter ++;
			}else if(i>anzahlTageMonat+start-1){
				liste.get(i).removeAll();
				liste.get(i).setBackground(Color.getHSBColor(0.0f, 0.0f, 0.93f));
			}else{
				liste.get(i).removeAll();
				liste.get(i).setBackground(Color.getHSBColor(0.0f, 0.0f, 0.93f));
				JLabel hallo = new JLabel(t);
				hallo.setAlignmentX(Component.CENTER_ALIGNMENT);
				liste.get(i).add(hallo);
				tag++;
			}
		}
		
		_kalender.set(Calendar.DAY_OF_MONTH, 1);
		int aktuellerTag = new GregorianCalendar().get(Calendar.DAY_OF_MONTH);
		int aktuellesJahr2 = new GregorianCalendar().get(Calendar.YEAR);
		String monat2 = new GregorianCalendar().getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
		
		if(m.equals(monat2) && aktuellesJahr2 == aktuellesJahr1){
			liste.get(aktuellerTag+counter-1).setBackground(Color.RED);
		}
		
		aktuellerMonat = m;
		aktuellesJahr = aktuellesJahr2;
		
		terminDarstellen();
		
	}
	private void terminDarstellen(){
		int monat;
		aktuellerMonat = aktuellerMonat.split(" ")[0];
		switch (aktuellerMonat) {
	    	case "January":  monat = 1; break;
	        case "February":  monat = 2; break;
	        case "March":  monat = 3; break;
	        case "April":  monat = 4; break;
	        case "May":  monat = 5; break;
	        case "June":  monat = 6; break;
	        case "July":  monat = 7; break;
	        case "August":  monat = 8; break;
	        case "September":  monat = 9; break;
	        case "October":  monat = 10; break;
	        case "November":  monat = 11; break;
	        case "December":  monat = 12; break;
	        default: monat = 0; break;
		}
			for(int eins=1; eins<=31; eins++){
			String aktuellesDatum = eins + "." + monat + "." + aktuellesJahr;
			//System.out.println(aktuellesDatum);
			for(int i=0; i<termine.size(); i++){
				if(aktuellesDatum.equals(termine.get(i).getDatumVon())){
					final Termin termin = termine.get(i);
					JLabel hallo = new JLabel(termine.get(i).getTitel());
					hallo.setAlignmentX(Component.CENTER_ALIGNMENT);
					liste.get(start).add(hallo);
					hallo.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent e){
							TerminAendernLoeschenFenster fen = new TerminAendernLoeschenFenster(termin);
							fen.setVisible(true);
							termine = Termin.getTermine("oeffentlich");
							privateTermin = Termin.getTermine(angemeldet.getEmail());
							tageErstellen();
							frame.validate();
						}
					});
				}
			}for(int i=0; i<privateTermin.size(); i++){
				if(aktuellesDatum.equals(privateTermin.get(i).getDatumVon())){
					final Termin termin = privateTermin.get(i);
					JLabel hallo = new JLabel(privateTermin.get(i).getTitel());
					hallo.setAlignmentX(Component.CENTER_ALIGNMENT);
					liste.get(start).add(hallo);
					hallo.addMouseListener(new MouseAdapter(){
						public void mouseClicked(MouseEvent e){
							TerminAendernLoeschenFenster fen = new TerminAendernLoeschenFenster(termin);
							fen.setVisible(true);
							termine = Termin.getTermine("oeffentlich");
							privateTermin = Termin.getTermine(angemeldet.getEmail());
							tageErstellen();
							frame.validate();
						}
					});
				}
			}
			start++;
		}
	}
	public Window getFrame() {
		return frame;
	}
	
}




