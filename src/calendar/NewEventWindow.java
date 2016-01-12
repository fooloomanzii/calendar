package calendar;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

public class NewEventWindow extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JTextField titleText;
	private JTextField dateFromText;
	private JTextField dateToText;
	private JTextField timeFromText;
	private JTextField timeToText;
	private JTextField locationText;
	private JTextField descriptionText;
	private JTextField repeatToText;

	/**
	 * Create the dialog.
	 */
	public NewEventWindow(final Client loginPerson, String date) {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Create Meeting");
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(300, 0, 800, 700);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblTitle.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 1;
		getContentPane().add(lblTitle, gbc_lblTitle);
		
		titleText = new JTextField();
		GridBagConstraints gbc_titleText = new GridBagConstraints();
		gbc_titleText.insets = new Insets(0, 0, 5, 0);
		gbc_titleText.fill = GridBagConstraints.HORIZONTAL;
		gbc_titleText.gridx = 5;
		gbc_titleText.gridy = 1;
		getContentPane().add(titleText, gbc_titleText);
		titleText.setColumns(10);
		
		JLabel lblDateFromText = new JLabel("Date (from)");
		lblDateFromText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblDateFromText.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_DateFromText = new GridBagConstraints();
		gbc_DateFromText.insets = new Insets(0, 0, 5, 5);
		gbc_DateFromText.gridx = 1;
		gbc_DateFromText.gridy = 2;
		getContentPane().add(lblDateFromText, gbc_DateFromText);
		
		JButton dateFrom = new JButton("Date");
		dateFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				GregorianCalendar gc = new GregorianCalendar();
				try{
					DateObject d = new DateObject(DateFormat.getDateInstance(DateFormat.MEDIUM)+"", DateFormat.getTimeInstance(DateFormat.SHORT)+"");
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_dateFrom = new GridBagConstraints();
		gbc_dateFrom.insets = new Insets(0, 0, 5, 0);
		gbc_dateFrom.gridx = 5;
		gbc_dateFrom.gridy = 2;
		getContentPane().add(dateFrom, gbc_dateFrom);
			
		
	
		JLabel lblDateFromText1 = new JLabel();
		lblDateFromText1.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblDateFromText1.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lblDateFromText1 = new GridBagConstraints();
		gbc_lblDateFromText1.insets = new Insets(0, 0, 5, 0);
		gbc_lblDateFromText1.gridx = 5;
		gbc_lblDateFromText1.gridy = 2;
		getContentPane().add(lblDateFromText1, gbc_lblDateFromText1);
		
		JLabel lbldateToText = new JLabel("Date (to)");
		lbldateToText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lbldateToText.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lbldateToText = new GridBagConstraints();
		gbc_lbldateToText.insets = new Insets(0, 0, 5, 5);
		gbc_lbldateToText.gridx = 1;
		gbc_lbldateToText.gridy = 3;
		getContentPane().add(lbldateToText, gbc_lbldateToText);
		
		dateToText = new JTextField();
		GridBagConstraints gbc_dateToText = new GridBagConstraints();
		gbc_dateToText.insets = new Insets(0, 0, 5, 0);
		gbc_dateToText.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateToText.gridx = 5;
		gbc_dateToText.gridy = 3;
		getContentPane().add(dateToText, gbc_dateToText);
		dateToText.setColumns(10);
		
		JLabel lbltimeFromText = new JLabel("Time (from)");
		lbltimeFromText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lbltimeFromText.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lbltimeFromText = new GridBagConstraints();
		gbc_lbltimeFromText.insets = new Insets(0, 0, 5, 5);
		gbc_lbltimeFromText.gridx = 1;
		gbc_lbltimeFromText.gridy = 4;
		getContentPane().add(lbltimeFromText, gbc_lbltimeFromText);
		
		timeFromText = new JTextField();
		GridBagConstraints gbc_timeFromText = new GridBagConstraints();
		gbc_timeFromText.insets = new Insets(0, 0, 5, 0);
		gbc_timeFromText.fill = GridBagConstraints.HORIZONTAL;
		gbc_timeFromText.gridx = 5;
		gbc_timeFromText.gridy = 4;
		getContentPane().add(timeFromText, gbc_timeFromText);
		timeFromText.setColumns(10);
		
		JLabel lbltimeToText = new JLabel("Time (to)");
		lbltimeToText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lbltimeToText.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lbltimeToText = new GridBagConstraints();
		gbc_lbltimeToText.insets = new Insets(0, 0, 5, 5);
		gbc_lbltimeToText.gridx = 1;
		gbc_lbltimeToText.gridy = 5;
		getContentPane().add(lbltimeToText, gbc_lbltimeToText);
		
		timeToText = new JTextField();
		GridBagConstraints gbc_timeToText = new GridBagConstraints();
		gbc_timeToText.insets = new Insets(0, 0, 5, 0);
		gbc_timeToText.fill = GridBagConstraints.HORIZONTAL;
		gbc_timeToText.gridx = 5;
		gbc_timeToText.gridy = 5;
		getContentPane().add(timeToText, gbc_timeToText);
		timeToText.setColumns(10);
		
		JLabel lbllocationText = new JLabel("Location");
		lbllocationText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lbllocationText.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lbllocationText = new GridBagConstraints();
		gbc_lbllocationText.insets = new Insets(0, 0, 5, 5);
		gbc_lbllocationText.gridx = 1;
		gbc_lbllocationText.gridy = 6;
		getContentPane().add(lbllocationText, gbc_lbllocationText);
		
		locationText = new JTextField();
		GridBagConstraints gbc_locationText = new GridBagConstraints();
		gbc_locationText.insets = new Insets(0, 0, 5, 0);
		gbc_locationText.fill = GridBagConstraints.HORIZONTAL;
		gbc_locationText.gridx = 5;
		gbc_locationText.gridy = 6;
		getContentPane().add(locationText, gbc_locationText);
		locationText.setColumns(10);
		
		JLabel lblrepeatTextBox = new JLabel("Repeat");
		lblrepeatTextBox.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblrepeatTextBox.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lblrepeatTextBox = new GridBagConstraints();
		gbc_lblrepeatTextBox.insets = new Insets(0, 0, 5, 5);
		gbc_lblrepeatTextBox.gridx = 1;
		gbc_lblrepeatTextBox.gridy = 7;
		getContentPane().add(lblrepeatTextBox, gbc_lblrepeatTextBox);
		
		final JComboBox repeatTextBox = new JComboBox();
		repeatTextBox.setModel(new DefaultComboBoxModel(new String[] {"Unique", "Daily", "Weekly", "Monthly", "Yearly"}));
		GridBagConstraints gbc_repeatTextBox = new GridBagConstraints();
		gbc_repeatTextBox.insets = new Insets(0, 0, 5, 0);
		gbc_repeatTextBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_repeatTextBox.gridx = 5;
		gbc_repeatTextBox.gridy = 7;
		getContentPane().add(repeatTextBox, gbc_repeatTextBox);
		
		JLabel lblrepeatToText = new JLabel("Repeat (to)");
		lblrepeatToText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblrepeatToText.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lblrepeatToText = new GridBagConstraints();
		gbc_lblrepeatToText.insets = new Insets(0, 0, 5, 5);
		gbc_lblrepeatToText.gridx = 1;
		gbc_lblrepeatToText.gridy = 8;
		getContentPane().add(lblrepeatToText, gbc_lblrepeatToText);
		
		repeatToText = new JTextField();
		GridBagConstraints gbc_repeatToText = new GridBagConstraints();
		gbc_repeatToText.insets = new Insets(0, 0, 5, 0);
		gbc_repeatToText.fill = GridBagConstraints.HORIZONTAL;
		gbc_repeatToText.gridx = 5;
		gbc_repeatToText.gridy = 8;
		getContentPane().add(repeatToText, gbc_repeatToText);
		repeatToText.setColumns(10);
		
		JLabel lblCalendarName = new JLabel("Calendar name");
		GridBagConstraints gbc_lblCalendarName = new GridBagConstraints();
		gbc_lblCalendarName.insets = new Insets(0, 0, 5, 5);
		gbc_lblCalendarName.gridx = 1;
		gbc_lblCalendarName.gridy = 9;
		getContentPane().add(lblCalendarName, gbc_lblCalendarName);
		
		final JComboBox <String> databaseBox = new JComboBox <String>();
		ArrayList<String> names = DatabaseNames.getEntries(loginPerson.getEmail());
		for(int i=0; i<names.size() ;i++){
			databaseBox.addItem(names.get(i));
		}
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 5;
		gbc_comboBox_1.gridy = 9;
		getContentPane().add(databaseBox, gbc_comboBox_1);
		
		JLabel lbldescriptionText = new JLabel("Description");
		lbldescriptionText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lbldescriptionText.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lbldescriptionText = new GridBagConstraints();
		gbc_lbldescriptionText.insets = new Insets(0, 0, 5, 5);
		gbc_lbldescriptionText.gridx = 1;
		gbc_lbldescriptionText.gridy = 10;
		getContentPane().add(lbldescriptionText, gbc_lbldescriptionText);
		
		descriptionText = new JTextField();
		GridBagConstraints gbc_descriptionText = new GridBagConstraints();
		gbc_descriptionText.insets = new Insets(0, 0, 5, 0);
		gbc_descriptionText.fill = GridBagConstraints.HORIZONTAL;
		gbc_descriptionText.gridx = 5;
		gbc_descriptionText.gridy = 10;
		getContentPane().add(descriptionText, gbc_descriptionText);
		descriptionText.setColumns(10);
		
		JLabel lblvisibilityBox = new JLabel("Visibility");
		lblvisibilityBox.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblvisibilityBox.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lblvisibilityBox = new GridBagConstraints();
		gbc_lblvisibilityBox.insets = new Insets(0, 0, 5, 5);
		gbc_lblvisibilityBox.gridx = 1;
		gbc_lblvisibilityBox.gridy = 11;
		getContentPane().add(lblvisibilityBox, gbc_lblvisibilityBox);
		
		final JComboBox visibilityBox = new JComboBox();
		visibilityBox.setModel(new DefaultComboBoxModel(new String[] {"public", "privat"}));
		GridBagConstraints gbc_visibilityBox = new GridBagConstraints();
		gbc_visibilityBox.insets = new Insets(0, 0, 5, 0);
		gbc_visibilityBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_visibilityBox.gridx = 5;
		gbc_visibilityBox.gridy = 11;
		getContentPane().add(visibilityBox, gbc_visibilityBox);

		JButton btnCreate = new JButton("Create");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String title = titleText.getText();
				String dateFrom = dateFromText.getText();
				String dateTo = dateToText.getText();
				String timeFrom = timeFromText.getText();
				String timeTo = timeToText.getText();
				String location = locationText.getText();
				String description = descriptionText.getText();
				String repeat= repeatTextBox.getSelectedItem().toString();
				String repeatTo = repeatToText.getText();
				String visibility = visibilityBox.getSelectedItem().toString();
				String databasename = databaseBox.getSelectedItem().toString();
				
				if(title.equals("") || dateFrom.equals("") || dateTo.equals("") || timeFrom.equals("") || timeTo.equals("")){
					new JFrame("Please fill out the necessary window!").setVisible(true);
					JOptionPane.showMessageDialog(frame, "Please fill out the necessary window!");
				}else{
					if (repeat.equals("Unique")){
						DatabaseCalendar.createEvent(databasename, loginPerson.getEmail(), title, dateFrom, dateTo, timeFrom, timeTo, location, description, repeat, repeatTo, visibility);
						dispose();
					}
					if (repeat.equals("Daily")){
						DatabaseCalendar.createEvent(databasename, loginPerson.getEmail(), title, dateFrom, dateTo, timeFrom, timeTo, location, description, repeat, repeatTo, visibility);
						dispose();
					}
					if (repeat.equals("Weekly")){
						DatabaseCalendar.createEvent(databasename, loginPerson.getEmail(), title, dateFrom, dateTo, timeFrom, timeTo, location, description, repeat, repeatTo, visibility);
						dispose();
					}
					if (repeat.equals("Monthly")){
						DatabaseCalendar.createEvent(databasename, loginPerson.getEmail(), title, dateFrom, dateTo, timeFrom, timeTo, location, description, repeat, repeatTo, visibility);
						dispose();
					}
					if (repeat.equals("Yearly")){
						DatabaseCalendar.createEvent(databasename, loginPerson.getEmail(), title, dateFrom, dateTo, timeFrom, timeTo, location, description, repeat, repeatTo, visibility);
						dispose();
					}
				}
			}
		});
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.insets = new Insets(0, 0, 0, 5);
		gbc_btnCreate.gridx = 3;
		gbc_btnCreate.gridy = 12;
		getContentPane().add(btnCreate, gbc_btnCreate);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.gridx = 5;
		gbc_btnExit.gridy = 12;
		getContentPane().add(btnExit, gbc_btnExit);
	}
	
}