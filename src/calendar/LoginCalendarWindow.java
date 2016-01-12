package calendar;

import java.util.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Window;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import java.awt.Component;

public class LoginCalendarWindow {

	private JFrame frame = new JFrame();
	private JPanel monthYear = new JPanel();
	
	private Calendar _calendar = new GregorianCalendar();
	private int currentDay = _calendar.get(Calendar.DAY_OF_MONTH); //Indicates current day
	private int currentMonth = _calendar.get(Calendar.MONTH); //Indicates current day
	private int currentYear = _calendar.get(Calendar.YEAR); //Indicates current year
	
	private ArrayList<JPanel> listJPanel = new ArrayList<JPanel>();
	
	private Client loginPerson;
	
	private int start;	

	/**
	 * Create the application
	 */
	public LoginCalendarWindow(Client loginPerson) {
		this.loginPerson = loginPerson;
		initialize();
	}

	/**
	 * Initialize Frame
	 */
	private void initialize(){
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setForeground(Color.RED);
		frame.setBounds(300, 0, 800, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{200, 200, 200, 200, 200, 200, 200, 0};
		gridBagLayout.rowHeights = new int[] {20, 0, 0, 30, 30, 30, 30, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0};
		frame.getContentPane().setLayout(gridBagLayout);
		
		initializeMonthView();
	}
	
	/**
	 * Initialize month view
	 */
	private void initializeMonthView(){

		/**
		 * JButton before
		 */
		JButton before = new JButton("<<");
		before.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				_calendar.set(_calendar.get(Calendar.YEAR), _calendar.get(Calendar.MONTH)-1, _calendar.get(Calendar.DATE));
				dayInitializeMonth(1);
				frame.validate();
			}
		});
		GridBagConstraints gbc_before = new GridBagConstraints();
		gbc_before.insets = new Insets(0, 0, 5, 5);
		gbc_before.gridx = 0;
		gbc_before.gridy = 0;
		frame.getContentPane().add(before, gbc_before);
		
		/**
		 * JPanel Month + Year
		 */
		monthYear.setForeground(new Color(0, 0, 0));
		monthYear.setBackground(Color.WHITE);
		GridBagConstraints gbc_monthYear = new GridBagConstraints();
		gbc_monthYear.gridwidth = 3;
		gbc_monthYear.insets = new Insets(0, 0, 5, 5);
		gbc_monthYear.fill = GridBagConstraints.VERTICAL;
		gbc_monthYear.gridx = 2;
		gbc_monthYear.gridy = 0;
		frame.getContentPane().add(monthYear, gbc_monthYear);
		
		/**
		 * JButton after
		 */
		JButton after = new JButton(">>");
		after.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				_calendar.set(_calendar.get(Calendar.YEAR), _calendar.get(Calendar.MONTH)+1, _calendar.get(Calendar.DATE));
				dayInitializeMonth(1);
				frame.validate();
			}
		});
		GridBagConstraints gbc_after = new GridBagConstraints();
		gbc_after.insets = new Insets(0, 0, 5, 0);
		gbc_after.gridx = 6;
		gbc_after.gridy = 0;
		frame.getContentPane().add(after, gbc_after);
		
		/**
		 * JPanel days(name)
		 */	
		JLabel lblMonday = new JLabel("Monday");
		lblMonday.setBackground(Color.WHITE);
		lblMonday.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonday.setFont( new Font("Fira Sans ExtraLight", Font.PLAIN, 18));
		lblMonday.setForeground(new Color(53, 65, 98));
		GridBagConstraints gbc_lblMonday = new GridBagConstraints();
		gbc_lblMonday.insets = new Insets(4, 4, 6, 6);
		gbc_lblMonday.gridx = 0;
		gbc_lblMonday.gridy = 2;
		frame.getContentPane().add(lblMonday, gbc_lblMonday);
		
		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.setBackground(Color.WHITE);
		lblTuesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblTuesday.setFont( new Font("Fira Sans ExtraLight", Font.PLAIN, 18));
		lblTuesday.setForeground(new Color(53, 65, 98));
		GridBagConstraints gbc_lblTuesday = new GridBagConstraints();
		gbc_lblTuesday.insets = new Insets(4, 4, 6, 6);
		gbc_lblTuesday.gridx = 1;
		gbc_lblTuesday.gridy = 2;
		frame.getContentPane().add(lblTuesday, gbc_lblTuesday);
		
		JLabel lblWednesday = new JLabel("Wednesday");
		lblWednesday.setBackground(Color.WHITE);
		lblWednesday.setHorizontalAlignment(SwingConstants.CENTER);
		lblWednesday.setFont( new Font("Fira Sans ExtraLight", Font.PLAIN, 18));
		lblWednesday.setForeground(new Color(53, 65, 98));
		GridBagConstraints gbc_lblWednesday = new GridBagConstraints();
		gbc_lblWednesday.insets = new Insets(4, 4, 6, 6);
		gbc_lblWednesday.gridx = 2;
		gbc_lblWednesday.gridy = 2;
		frame.getContentPane().add(lblWednesday, gbc_lblWednesday);
		
		JLabel lblThursday = new JLabel("Thursday");
		lblThursday.setBackground(Color.WHITE);
		lblThursday.setHorizontalAlignment(SwingConstants.CENTER);
		lblThursday.setFont( new Font("Fira Sans ExtraLight", Font.PLAIN, 18));
		lblThursday.setForeground(new Color(53, 65, 98));
		GridBagConstraints gbc_lblThursday= new GridBagConstraints();
		gbc_lblThursday.insets = new Insets(4, 4, 6, 6);
		gbc_lblThursday.gridx = 3;
		gbc_lblThursday.gridy = 2;
		frame.getContentPane().add(lblThursday, gbc_lblThursday);
		
		JLabel lblFriday = new JLabel("Friday");
		lblFriday.setBackground(Color.WHITE);
		lblFriday.setHorizontalAlignment(SwingConstants.CENTER);
		lblFriday.setFont( new Font("Fira Sans ExtraLight", Font.PLAIN, 18));
		lblFriday.setForeground(new Color(53, 65, 98));
		GridBagConstraints gbc_lblFirday = new GridBagConstraints();
		gbc_lblFirday.insets = new Insets(4, 4, 6, 6);
		gbc_lblFirday.gridx = 4;
		gbc_lblFirday.gridy = 2;
		frame.getContentPane().add(lblFriday, gbc_lblFirday);
		
		JLabel lblSaturday = new JLabel("Saturday");
		lblSaturday.setBackground(Color.WHITE);
		lblSaturday.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaturday.setFont( new Font("Fira Sans ExtraLight", Font.PLAIN, 18));
		lblSaturday.setForeground(new Color(53, 65, 98));
		GridBagConstraints gbc_lblSaturday = new GridBagConstraints();
		gbc_lblSaturday.anchor = GridBagConstraints.NORTH;
		gbc_lblSaturday.insets = new Insets(4, 4, 6, 6);
		gbc_lblSaturday.gridx = 5;
		gbc_lblSaturday.gridy = 2;
		frame.getContentPane().add(lblSaturday, gbc_lblSaturday);
		
		JLabel lblSunday = new JLabel("Sunday");
		lblSunday.setBackground(Color.WHITE);
		lblSunday.setHorizontalAlignment(SwingConstants.CENTER);
		lblSunday.setFont( new Font("Fira Sans ExtraLight", Font.PLAIN, 18));
		lblSunday.setForeground(new Color(53, 65, 98));
		GridBagConstraints gbc_lblSunday = new GridBagConstraints();
		gbc_lblSunday.insets = new Insets(0, 0, 5, 0);
		gbc_lblSunday.gridx = 6;
		gbc_lblSunday.gridy = 2;
		frame.getContentPane().add(lblSunday, gbc_lblSunday);
		
		/**
		 * JPanel days
		 */
		JPanel panel_0 = new JPanel();
		panel_0.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_0 = new GridBagConstraints();
		gbc_panel_0.insets = new Insets(4, 4, 6, 6);
		gbc_panel_0.fill = GridBagConstraints.BOTH;
		gbc_panel_0.gridx = 0;
		gbc_panel_0.gridy = 3;
		frame.getContentPane().add(panel_0, gbc_panel_0);
		panel_0.setLayout(new BoxLayout(panel_0, BoxLayout.Y_AXIS));
		listJPanel.add(panel_0);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(4, 4, 6, 6);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 3;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		listJPanel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(4, 4, 6, 6);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 2;
		gbc_panel_2.gridy = 3;
		frame.getContentPane().add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		listJPanel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(4, 4, 6, 6);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 3;
		gbc_panel_3.gridy = 3;
		frame.getContentPane().add(panel_3, gbc_panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		listJPanel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(4, 4, 6, 6);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 4;
		gbc_panel_4.gridy = 3;
		frame.getContentPane().add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		listJPanel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(4, 4, 6, 6);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 5;
		gbc_panel_5.gridy = 3;
		frame.getContentPane().add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		listJPanel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 6;
		gbc_panel_6.gridy = 3;
		frame.getContentPane().add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));
		listJPanel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(4, 4, 6, 6);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 4;
		frame.getContentPane().add(panel_7, gbc_panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.Y_AXIS));
		listJPanel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(4, 4, 6, 6);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 1;
		gbc_panel_8.gridy = 4;
		frame.getContentPane().add(panel_8, gbc_panel_8);
		panel_8.setLayout(new BoxLayout(panel_8, BoxLayout.Y_AXIS));
		listJPanel.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(4, 4, 6, 6);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 2;
		gbc_panel_9.gridy = 4;
		frame.getContentPane().add(panel_9, gbc_panel_9);
		panel_9.setLayout(new BoxLayout(panel_9, BoxLayout.Y_AXIS));
		listJPanel.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(4, 4, 6, 6);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 3;
		gbc_panel_10.gridy = 4;
		frame.getContentPane().add(panel_10, gbc_panel_10);
		panel_10.setLayout(new BoxLayout(panel_10, BoxLayout.Y_AXIS));
		listJPanel.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(4, 4, 6, 6);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 4;
		gbc_panel_11.gridy = 4;
		frame.getContentPane().add(panel_11, gbc_panel_11);
		panel_11.setLayout(new BoxLayout(panel_11, BoxLayout.Y_AXIS));
		listJPanel.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.insets = new Insets(4, 4, 6, 6);
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 5;
		gbc_panel_12.gridy = 4;
		frame.getContentPane().add(panel_12, gbc_panel_12);
		panel_12.setLayout(new BoxLayout(panel_12, BoxLayout.Y_AXIS));
		listJPanel.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.insets = new Insets(0, 0, 5, 0);
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.gridx = 6;
		gbc_panel_13.gridy = 4;
		frame.getContentPane().add(panel_13, gbc_panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.Y_AXIS));
		listJPanel.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_14 = new GridBagConstraints();
		gbc_panel_14.insets = new Insets(4, 4, 6, 6);
		gbc_panel_14.fill = GridBagConstraints.BOTH;
		gbc_panel_14.gridx = 0;
		gbc_panel_14.gridy = 5;
		frame.getContentPane().add(panel_14, gbc_panel_14);
		panel_14.setLayout(new BoxLayout(panel_14, BoxLayout.Y_AXIS));
		listJPanel.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_15 = new GridBagConstraints();
		gbc_panel_15.insets = new Insets(4, 4, 6, 6);
		gbc_panel_15.fill = GridBagConstraints.BOTH;
		gbc_panel_15.gridx = 1;
		gbc_panel_15.gridy = 5;
		frame.getContentPane().add(panel_15, gbc_panel_15);
		panel_15.setLayout(new BoxLayout(panel_15, BoxLayout.Y_AXIS));
		listJPanel.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.insets = new Insets(4, 4, 6, 6);
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.gridx = 2;
		gbc_panel_16.gridy = 5;
		frame.getContentPane().add(panel_16, gbc_panel_16);
		panel_16.setLayout(new BoxLayout(panel_16, BoxLayout.Y_AXIS));
		listJPanel.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_17 = new GridBagConstraints();
		gbc_panel_17.insets = new Insets(4, 4, 6, 6);
		gbc_panel_17.fill = GridBagConstraints.BOTH;
		gbc_panel_17.gridx = 3;
		gbc_panel_17.gridy = 5;
		frame.getContentPane().add(panel_17, gbc_panel_17);
		panel_17.setLayout(new BoxLayout(panel_17, BoxLayout.Y_AXIS));
		listJPanel.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_18 = new GridBagConstraints();
		gbc_panel_18.insets = new Insets(4, 4, 6, 6);
		gbc_panel_18.fill = GridBagConstraints.BOTH;
		gbc_panel_18.gridx = 4;
		gbc_panel_18.gridy = 5;
		frame.getContentPane().add(panel_18, gbc_panel_18);
		panel_18.setLayout(new BoxLayout(panel_18, BoxLayout.Y_AXIS));
		listJPanel.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_19 = new GridBagConstraints();
		gbc_panel_19.insets = new Insets(4, 4, 6, 6);
		gbc_panel_19.fill = GridBagConstraints.BOTH;
		gbc_panel_19.gridx = 5;
		gbc_panel_19.gridy = 5;
		frame.getContentPane().add(panel_19, gbc_panel_19);
		panel_19.setLayout(new BoxLayout(panel_19, BoxLayout.Y_AXIS));
		listJPanel.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_20 = new GridBagConstraints();
		gbc_panel_20.insets = new Insets(0, 0, 5, 0);
		gbc_panel_20.fill = GridBagConstraints.BOTH;
		gbc_panel_20.gridx = 6;
		gbc_panel_20.gridy = 5;
		frame.getContentPane().add(panel_20, gbc_panel_20);
		panel_20.setLayout(new BoxLayout(panel_20, BoxLayout.Y_AXIS));
		listJPanel.add(panel_20);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_21 = new GridBagConstraints();
		gbc_panel_21.insets = new Insets(4, 4, 6, 6);
		gbc_panel_21.fill = GridBagConstraints.BOTH;
		gbc_panel_21.gridx = 0;
		gbc_panel_21.gridy = 6;
		frame.getContentPane().add(panel_21, gbc_panel_21);
		panel_21.setLayout(new BoxLayout(panel_21, BoxLayout.Y_AXIS));
		listJPanel.add(panel_21);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_22 = new GridBagConstraints();
		gbc_panel_22.insets = new Insets(4, 4, 6, 6);
		gbc_panel_22.fill = GridBagConstraints.BOTH;
		gbc_panel_22.gridx = 1;
		gbc_panel_22.gridy = 6;
		frame.getContentPane().add(panel_22, gbc_panel_22);
		panel_22.setLayout(new BoxLayout(panel_22, BoxLayout.Y_AXIS));
		listJPanel.add(panel_22);
		
		JPanel panel_23 = new JPanel();
		panel_23.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_23 = new GridBagConstraints();
		gbc_panel_23.insets = new Insets(4, 4, 6, 6);
		gbc_panel_23.fill = GridBagConstraints.BOTH;
		gbc_panel_23.gridx = 2;
		gbc_panel_23.gridy = 6;
		frame.getContentPane().add(panel_23, gbc_panel_23);
		panel_23.setLayout(new BoxLayout(panel_23, BoxLayout.Y_AXIS));
		listJPanel.add(panel_23);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_24 = new GridBagConstraints();
		gbc_panel_24.insets = new Insets(4, 4, 6, 6);
		gbc_panel_24.fill = GridBagConstraints.BOTH;
		gbc_panel_24.gridx = 3;
		gbc_panel_24.gridy = 6;
		frame.getContentPane().add(panel_24, gbc_panel_24);
		panel_24.setLayout(new BoxLayout(panel_24, BoxLayout.Y_AXIS));
		listJPanel.add(panel_24);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_25 = new GridBagConstraints();
		gbc_panel_25.insets = new Insets(4, 4, 6, 6);
		gbc_panel_25.fill = GridBagConstraints.BOTH;
		gbc_panel_25.gridx = 4;
		gbc_panel_25.gridy = 6;
		frame.getContentPane().add(panel_25, gbc_panel_25);
		panel_25.setLayout(new BoxLayout(panel_25, BoxLayout.Y_AXIS));
		listJPanel.add(panel_25);
		
		JPanel panel_26 = new JPanel();
		panel_26.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_26 = new GridBagConstraints();
		gbc_panel_26.insets = new Insets(4, 4, 6, 6);
		gbc_panel_26.fill = GridBagConstraints.BOTH;
		gbc_panel_26.gridx = 5;
		gbc_panel_26.gridy = 6;
		frame.getContentPane().add(panel_26, gbc_panel_26);
		panel_26.setLayout(new BoxLayout(panel_26, BoxLayout.Y_AXIS));
		listJPanel.add(panel_26);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_27 = new GridBagConstraints();
		gbc_panel_27.insets = new Insets(0, 0, 5, 0);
		gbc_panel_27.fill = GridBagConstraints.BOTH;
		gbc_panel_27.gridx = 6;
		gbc_panel_27.gridy = 6;
		frame.getContentPane().add(panel_27, gbc_panel_27);
		panel_27.setLayout(new BoxLayout(panel_27, BoxLayout.Y_AXIS));
		listJPanel.add(panel_27);
		
		JPanel panel_28 = new JPanel();
		panel_28.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_28 = new GridBagConstraints();
		gbc_panel_28.insets = new Insets(4, 4, 6, 6);
		gbc_panel_28.fill = GridBagConstraints.BOTH;
		gbc_panel_28.gridx = 0;
		gbc_panel_28.gridy = 7;
		frame.getContentPane().add(panel_28, gbc_panel_28);
		panel_28.setLayout(new BoxLayout(panel_28, BoxLayout.Y_AXIS));
		listJPanel.add(panel_28);
		
		JPanel panel_29 = new JPanel();
		panel_29.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_29 = new GridBagConstraints();
		gbc_panel_29.insets = new Insets(4, 4, 6, 6);
		gbc_panel_29.fill = GridBagConstraints.BOTH;
		gbc_panel_29.gridx = 1;
		gbc_panel_29.gridy = 7;
		frame.getContentPane().add(panel_29, gbc_panel_29);
		panel_29.setLayout(new BoxLayout(panel_29, BoxLayout.Y_AXIS));
		listJPanel.add(panel_29);
		
		JPanel panel_30 = new JPanel();
		panel_30.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_30 = new GridBagConstraints();
		gbc_panel_30.insets = new Insets(4, 4, 6, 6);
		gbc_panel_30.fill = GridBagConstraints.BOTH;
		gbc_panel_30.gridx = 2;
		gbc_panel_30.gridy = 7;
		frame.getContentPane().add(panel_30, gbc_panel_30);
		panel_30.setLayout(new BoxLayout(panel_30, BoxLayout.Y_AXIS));
		listJPanel.add(panel_30);
		
		JPanel panel_31 = new JPanel();
		panel_31.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_31 = new GridBagConstraints();
		gbc_panel_31.insets = new Insets(4, 4, 6, 6);
		gbc_panel_31.fill = GridBagConstraints.BOTH;
		gbc_panel_31.gridx = 3;
		gbc_panel_31.gridy = 7;
		frame.getContentPane().add(panel_31, gbc_panel_31);
		panel_31.setLayout(new BoxLayout(panel_31, BoxLayout.Y_AXIS));
		listJPanel.add(panel_31);
		
		JPanel panel_32 = new JPanel();
		panel_32.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_32 = new GridBagConstraints();
		gbc_panel_32.insets = new Insets(4, 4, 6, 6);
		gbc_panel_32.fill = GridBagConstraints.BOTH;
		gbc_panel_32.gridx = 4;
		gbc_panel_32.gridy = 7;
		frame.getContentPane().add(panel_32, gbc_panel_32);
		panel_32.setLayout(new BoxLayout(panel_32, BoxLayout.Y_AXIS));
		listJPanel.add(panel_32);
		
		JPanel panel_33 = new JPanel();
		panel_33.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_33 = new GridBagConstraints();
		gbc_panel_33.insets = new Insets(4, 4, 6, 6);
		gbc_panel_33.fill = GridBagConstraints.BOTH;
		gbc_panel_33.gridx = 5;
		gbc_panel_33.gridy = 7;
		frame.getContentPane().add(panel_33, gbc_panel_33);
		panel_33.setLayout(new BoxLayout(panel_33, BoxLayout.Y_AXIS));
		listJPanel.add(panel_33);
		
		JPanel panel_34 = new JPanel();
		panel_34.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_34 = new GridBagConstraints();
		gbc_panel_34.insets = new Insets(0, 0, 5, 0);
		gbc_panel_34.fill = GridBagConstraints.BOTH;
		gbc_panel_34.gridx = 6;
		gbc_panel_34.gridy = 7;
		frame.getContentPane().add(panel_34, gbc_panel_34);
		panel_34.setLayout(new BoxLayout(panel_34, BoxLayout.Y_AXIS));
		listJPanel.add(panel_34);
		
		JPanel panel_35 = new JPanel();
		panel_35.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_35 = new GridBagConstraints();
		gbc_panel_35.insets = new Insets(4, 4, 6, 6);
		gbc_panel_35.fill = GridBagConstraints.BOTH;
		gbc_panel_35.gridx = 0;
		gbc_panel_35.gridy = 8;
		frame.getContentPane().add(panel_35, gbc_panel_35);
		panel_35.setLayout(new BoxLayout(panel_35, BoxLayout.Y_AXIS));
		listJPanel.add(panel_35);
		
		JPanel panel_36 = new JPanel();
		panel_36.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_36 = new GridBagConstraints();
		gbc_panel_36.insets = new Insets(4, 4, 6, 6);
		gbc_panel_36.fill = GridBagConstraints.BOTH;
		gbc_panel_36.gridx = 1;
		gbc_panel_36.gridy = 8;
		frame.getContentPane().add(panel_36, gbc_panel_36);
		panel_36.setLayout(new BoxLayout(panel_36, BoxLayout.Y_AXIS));
		listJPanel.add(panel_36);
		
		JPanel panel_37 = new JPanel();
		panel_37.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_37 = new GridBagConstraints();
		gbc_panel_37.insets = new Insets(4, 4, 6, 6);
		gbc_panel_37.fill = GridBagConstraints.BOTH;
		gbc_panel_37.gridx = 2;
		gbc_panel_37.gridy = 8;
		frame.getContentPane().add(panel_37, gbc_panel_37);
		panel_37.setLayout(new BoxLayout(panel_37, BoxLayout.Y_AXIS));
		listJPanel.add(panel_37);
		
		/**
		 * JMenuBar: Items Login + Exit
		 */
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		JMenu mnMen = new JMenu("Menu");
		menuBar.add(mnMen);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				CalendarWindow fen = new CalendarWindow();
				fen.getFrame().setVisible(true);
			}
		});
		mnMen.add(mntmLogout);
		
		JMenuItem mntmActualDate = new JMenuItem("Actual Date");
		mntmActualDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dayInitializeMonth(0);
				frame.validate();
			}
		});
		mnMen.add(mntmActualDate);
		
		JMenuItem mntmManageUserData = new JMenuItem("Manage User Data");
		mntmManageUserData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame.getContentPane(), "Work in progress!");
			}
		});
		mnMen.add(mntmManageUserData);
		
		JMenuItem mntmCreateEvent = new JMenuItem("Create Event");
		mntmCreateEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentMonth = "" + _calendar.get(Calendar.MONTH)+1;
				String date = currentDay + "." + currentMonth + "." + currentYear;
				System.out.println(date);
				NewEventWindow win = new NewEventWindow(loginPerson, date);
				win.setVisible(true);
			}
		});
		mnMen.add(mntmCreateEvent);
		
		JMenuItem mntmCreateCalendar = new JMenuItem("Create Calendar");
		mntmCreateCalendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewCalendar nCWindow = new NewCalendar(loginPerson);
				nCWindow.setVisible(true);
			}
		});
		mnMen.add(mntmCreateCalendar);
		
		JMenuItem mntmBackup = new JMenuItem("Backup");
		mntmBackup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame.getContentPane(), "Work in progress!");
			}
		});
		mnMen.add(mntmBackup);
		
		JMenuItem mntmOnlineSynchronization = new JMenuItem("Online Synchronization");
		mntmOnlineSynchronization.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame.getContentPane(), "Work in progress!");
			}
		});
		mnMen.add(mntmOnlineSynchronization);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnMen.add(mntmExit);
		
		dayInitializeMonth(0);
		
	}
	
private void dayInitializeMonth(int number){
		
		for(int i = 0; i<listJPanel.size(); i++){
			listJPanel.get(i).removeAll();
		}
		
		if(number == 0){
			_calendar.set(currentYear, currentMonth, currentDay);
		}
		
		_calendar.set(Calendar.DAY_OF_MONTH, 1);
		
		//Indicates Monday/Tuesday/Wednesday/Thursday/Friday/Saturday/Sunday
		switch (_calendar.get(Calendar.DAY_OF_WEEK)){
	    	case 1:  start = 6; break; //Saturday
	        case 2:  start = 0; break; //Sunday
	        case 3:  start = 1; break; //Monday
	        case 4:  start = 2; break; //Tuesday
	        case 5:  start = 3; break; //Wednesday
	        case 6:  start = 4; break; //Thursday
	        case 7:  start = 5; break; //Friday
	    }
	
		int day=1;
		for(int i = 0; i<listJPanel.size(); i++){
			if(i >= start && i < _calendar.getActualMaximum(Calendar.DATE)+start){
				String dayNumber = day + "";
				//currentDay characterize
				if(day == currentDay && currentMonth == _calendar.get(Calendar.MONTH) && currentYear == _calendar.get(Calendar.YEAR)){
					JLabel label = new JLabel(dayNumber);
					label.setAlignmentX(Component.CENTER_ALIGNMENT);
					label.setFont(new Font("FiraSans Book", Font.PLAIN, 16));
					label.setForeground(Color.RED);
					listJPanel.get(i).setBackground(new Color(240, 240, 240));
					listJPanel.get(i).add(label);
				}else{
					JLabel label = new JLabel(dayNumber);
					label.setAlignmentX(Component.CENTER_ALIGNMENT);
					label.setFont(new Font("FiraSans Book", Font.PLAIN, 16));
					listJPanel.get(i).setBackground(new Color(245, 245, 245));
					listJPanel.get(i).add(label);
				}
				day++;
			}else{
				listJPanel.get(i).setBackground(Color.WHITE);
			}
		}
		
		/**
		 * Output current year + month
		 */
		JLabel label = new JLabel(_calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " + _calendar.get(Calendar.YEAR));
		label.setBackground(Color.ORANGE);
		label.setFont(new Font("Fira Sans Hair", Font.PLAIN, 24));
		label.setForeground(Color.BLACK);
		monthYear.removeAll();
		monthYear.add(label);
		
	}
	
	/**
	 * Output Meeting
	 */
/*	private void showMeetingMonth(int day, int jpanelNumber){
		String currentDate = day + "." + (_calendar.get(Calendar.MONTH)+1) + "." + _calendar.get(Calendar.YEAR);
		
		for(int i=0; i<publicMeeting.size(); i++){
			final Event meeting = publicMeeting.get(i);
			final String email = publicMeeting.get(i).getOwner();
			if(currentDate.equals(publicMeeting.get(i).getDateFrom())){
				JLabel label = new JLabel(publicMeeting.get(i).getTitle());
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				label.setFont(new Font("Arial", Font.BOLD, 15));
				listJPanel.get(jpanelNumber).add(label, "alignx center");
				label.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						if(loginPerson.getEmail().equals(email)){
							ChangeEventWindow win = new ChangeEventWindow(meeting);
							win.setVisible(true);
						}else{
							ShowMeetingWindow win = new ShowMeetingWindow(meeting);
							win.setVisible(true);
						}
					}
				});
			}
		}
			
		for(int i=0; i<privatMeeting.size(); i++){
			final Event meeting = privatMeeting.get(i);
			if(currentDate.equals(privatMeeting.get(i).getDateFrom()) && loginPerson.getEmail().equals(privatMeeting.get(i).getOwner())){
				JLabel label = new JLabel(privatMeeting.get(i).getTitle());
				label.setAlignmentX(Component.CENTER_ALIGNMENT);
				label.setFont(new Font("Arial", Font.BOLD, 15));
				listJPanel.get(jpanelNumber).add(label, "alignx center");
				label.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						ChangeEventWindow win = new ChangeEventWindow(meeting);
						win.setVisible(true);
					}
				});
			}
		}
	}*/
	
	public Window getFrame() {
		return frame;
	}
	
}