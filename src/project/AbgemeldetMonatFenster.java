package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;

public class AbgemeldetMonatFenster {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbgemeldetMonatFenster window = new AbgemeldetMonatFenster();
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
	public AbgemeldetMonatFenster() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 689, 352);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {30, 0, 30, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
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
		gbc_panel_28.insets = new Insets(0, 0, 0, 5);
		gbc_panel_28.fill = GridBagConstraints.BOTH;
		gbc_panel_28.gridx = 2;
		gbc_panel_28.gridy = 6;
		frame.getContentPane().add(panel_28, gbc_panel_28);
		
		JPanel panel_29 = new JPanel();
		GridBagConstraints gbc_panel_29 = new GridBagConstraints();
		gbc_panel_29.insets = new Insets(0, 0, 0, 5);
		gbc_panel_29.fill = GridBagConstraints.BOTH;
		gbc_panel_29.gridx = 3;
		gbc_panel_29.gridy = 6;
		frame.getContentPane().add(panel_29, gbc_panel_29);
		
		JPanel panel_30 = new JPanel();
		GridBagConstraints gbc_panel_30 = new GridBagConstraints();
		gbc_panel_30.insets = new Insets(0, 0, 0, 5);
		gbc_panel_30.fill = GridBagConstraints.BOTH;
		gbc_panel_30.gridx = 4;
		gbc_panel_30.gridy = 6;
		frame.getContentPane().add(panel_30, gbc_panel_30);
		
		JPanel panel_31 = new JPanel();
		GridBagConstraints gbc_panel_31 = new GridBagConstraints();
		gbc_panel_31.insets = new Insets(0, 0, 0, 5);
		gbc_panel_31.fill = GridBagConstraints.BOTH;
		gbc_panel_31.gridx = 5;
		gbc_panel_31.gridy = 6;
		frame.getContentPane().add(panel_31, gbc_panel_31);
		
		JPanel panel_32 = new JPanel();
		GridBagConstraints gbc_panel_32 = new GridBagConstraints();
		gbc_panel_32.insets = new Insets(0, 0, 0, 5);
		gbc_panel_32.fill = GridBagConstraints.BOTH;
		gbc_panel_32.gridx = 6;
		gbc_panel_32.gridy = 6;
		frame.getContentPane().add(panel_32, gbc_panel_32);
		
		JPanel panel_33 = new JPanel();
		GridBagConstraints gbc_panel_33 = new GridBagConstraints();
		gbc_panel_33.insets = new Insets(0, 0, 0, 5);
		gbc_panel_33.fill = GridBagConstraints.BOTH;
		gbc_panel_33.gridx = 7;
		gbc_panel_33.gridy = 6;
		frame.getContentPane().add(panel_33, gbc_panel_33);
		
		JPanel panel_34 = new JPanel();
		GridBagConstraints gbc_panel_34 = new GridBagConstraints();
		gbc_panel_34.fill = GridBagConstraints.BOTH;
		gbc_panel_34.gridx = 8;
		gbc_panel_34.gridy = 6;
		frame.getContentPane().add(panel_34, gbc_panel_34);
	}

}
