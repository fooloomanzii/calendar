package calendar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;

public class CreateMeetingWindow extends JDialog {

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
	public CreateMeetingWindow(final Person loginPerson) {
		getContentPane().setBackground(new Color(0, 102, 0));
		setTitle("Create Meeting");
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(500, 0, 600, 400);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblTitle.setForeground(Color.RED);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 2;
		gbc_lblTitle.gridy = 1;
		getContentPane().add(lblTitle, gbc_lblTitle);
		
		titleText = new JTextField();
		GridBagConstraints gbc_titleText = new GridBagConstraints();
		gbc_titleText.insets = new Insets(0, 0, 5, 0);
		gbc_titleText.fill = GridBagConstraints.HORIZONTAL;
		gbc_titleText.gridx = 6;
		gbc_titleText.gridy = 1;
		getContentPane().add(titleText, gbc_titleText);
		titleText.setColumns(10);
		
		JLabel lblDateFromText = new JLabel("Date (from)");
		lblDateFromText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblDateFromText.setForeground(Color.RED);
		GridBagConstraints gbc_DateFromText = new GridBagConstraints();
		gbc_DateFromText.insets = new Insets(0, 0, 5, 5);
		gbc_DateFromText.gridx = 2;
		gbc_DateFromText.gridy = 2;
		getContentPane().add(lblDateFromText, gbc_DateFromText);
		
		dateFromText = new JTextField();
		dateFromText.setToolTipText("");
		GridBagConstraints gbc_dateFromText = new GridBagConstraints();
		gbc_dateFromText.insets = new Insets(0, 0, 5, 0);
		gbc_dateFromText.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateFromText.gridx = 6;
		gbc_dateFromText.gridy = 2;
		getContentPane().add(dateFromText, gbc_dateFromText);
		dateFromText.setColumns(10);
		
		JLabel lbldateToText = new JLabel("Date (to)");
		lbldateToText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lbldateToText.setForeground(Color.RED);
		GridBagConstraints gbc_lbldateToText = new GridBagConstraints();
		gbc_lbldateToText.insets = new Insets(0, 0, 5, 5);
		gbc_lbldateToText.gridx = 2;
		gbc_lbldateToText.gridy = 3;
		getContentPane().add(lbldateToText, gbc_lbldateToText);
		
		dateToText = new JTextField();
		GridBagConstraints gbc_dateToText = new GridBagConstraints();
		gbc_dateToText.insets = new Insets(0, 0, 5, 0);
		gbc_dateToText.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateToText.gridx = 6;
		gbc_dateToText.gridy = 3;
		getContentPane().add(dateToText, gbc_dateToText);
		dateToText.setColumns(10);
		
		JLabel lbltimeFromText = new JLabel("Time (from)");
		lbltimeFromText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lbltimeFromText.setForeground(Color.RED);
		GridBagConstraints gbc_lbltimeFromText = new GridBagConstraints();
		gbc_lbltimeFromText.insets = new Insets(0, 0, 5, 5);
		gbc_lbltimeFromText.gridx = 2;
		gbc_lbltimeFromText.gridy = 4;
		getContentPane().add(lbltimeFromText, gbc_lbltimeFromText);
		
		timeFromText = new JTextField();
		GridBagConstraints gbc_timeFromText = new GridBagConstraints();
		gbc_timeFromText.insets = new Insets(0, 0, 5, 0);
		gbc_timeFromText.fill = GridBagConstraints.HORIZONTAL;
		gbc_timeFromText.gridx = 6;
		gbc_timeFromText.gridy = 4;
		getContentPane().add(timeFromText, gbc_timeFromText);
		timeFromText.setColumns(10);
		
		JLabel lbltimeToText = new JLabel("Time (to)");
		lbltimeToText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lbltimeToText.setForeground(Color.RED);
		GridBagConstraints gbc_lbltimeToText = new GridBagConstraints();
		gbc_lbltimeToText.insets = new Insets(0, 0, 5, 5);
		gbc_lbltimeToText.gridx = 2;
		gbc_lbltimeToText.gridy = 5;
		getContentPane().add(lbltimeToText, gbc_lbltimeToText);
		
		timeToText = new JTextField();
		GridBagConstraints gbc_timeToText = new GridBagConstraints();
		gbc_timeToText.insets = new Insets(0, 0, 5, 0);
		gbc_timeToText.fill = GridBagConstraints.HORIZONTAL;
		gbc_timeToText.gridx = 6;
		gbc_timeToText.gridy = 5;
		getContentPane().add(timeToText, gbc_timeToText);
		timeToText.setColumns(10);
		
		JLabel lbllocationText = new JLabel("Location");
		lbllocationText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lbllocationText.setForeground(Color.RED);
		GridBagConstraints gbc_lbllocationText = new GridBagConstraints();
		gbc_lbllocationText.insets = new Insets(0, 0, 5, 5);
		gbc_lbllocationText.gridx = 2;
		gbc_lbllocationText.gridy = 6;
		getContentPane().add(lbllocationText, gbc_lbllocationText);
		
		locationText = new JTextField();
		GridBagConstraints gbc_locationText = new GridBagConstraints();
		gbc_locationText.insets = new Insets(0, 0, 5, 0);
		gbc_locationText.fill = GridBagConstraints.HORIZONTAL;
		gbc_locationText.gridx = 6;
		gbc_locationText.gridy = 6;
		getContentPane().add(locationText, gbc_locationText);
		locationText.setColumns(10);
		
		JLabel lblrepeatTextBox = new JLabel("Repeat");
		lblrepeatTextBox.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblrepeatTextBox.setForeground(Color.RED);
		GridBagConstraints gbc_lblrepeatTextBox = new GridBagConstraints();
		gbc_lblrepeatTextBox.insets = new Insets(0, 0, 5, 5);
		gbc_lblrepeatTextBox.gridx = 2;
		gbc_lblrepeatTextBox.gridy = 7;
		getContentPane().add(lblrepeatTextBox, gbc_lblrepeatTextBox);
		
		final JComboBox repeatTextBox = new JComboBox();
		repeatTextBox.setModel(new DefaultComboBoxModel(new String[] {"Unique", "Daily", "Weekly", "Monthly", "Yearly"}));
		GridBagConstraints gbc_repeatTextBox = new GridBagConstraints();
		gbc_repeatTextBox.insets = new Insets(0, 0, 5, 0);
		gbc_repeatTextBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_repeatTextBox.gridx = 6;
		gbc_repeatTextBox.gridy = 7;
		getContentPane().add(repeatTextBox, gbc_repeatTextBox);
		
		JLabel lblrepeatToText = new JLabel("Repeat (to)");
		lblrepeatToText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblrepeatToText.setForeground(Color.RED);
		GridBagConstraints gbc_lblrepeatToText = new GridBagConstraints();
		gbc_lblrepeatToText.insets = new Insets(0, 0, 5, 5);
		gbc_lblrepeatToText.gridx = 2;
		gbc_lblrepeatToText.gridy = 8;
		getContentPane().add(lblrepeatToText, gbc_lblrepeatToText);
		
		repeatToText = new JTextField();
		GridBagConstraints gbc_repeatToText = new GridBagConstraints();
		gbc_repeatToText.insets = new Insets(0, 0, 5, 0);
		gbc_repeatToText.fill = GridBagConstraints.HORIZONTAL;
		gbc_repeatToText.gridx = 6;
		gbc_repeatToText.gridy = 8;
		getContentPane().add(repeatToText, gbc_repeatToText);
		repeatToText.setColumns(10);
		
		JLabel lbldescriptionText = new JLabel("Description");
		lbldescriptionText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lbldescriptionText.setForeground(Color.RED);
		GridBagConstraints gbc_lbldescriptionText = new GridBagConstraints();
		gbc_lbldescriptionText.insets = new Insets(0, 0, 5, 5);
		gbc_lbldescriptionText.gridx = 2;
		gbc_lbldescriptionText.gridy = 9;
		getContentPane().add(lbldescriptionText, gbc_lbldescriptionText);
		
		descriptionText = new JTextField();
		GridBagConstraints gbc_descriptionText = new GridBagConstraints();
		gbc_descriptionText.insets = new Insets(0, 0, 5, 0);
		gbc_descriptionText.fill = GridBagConstraints.HORIZONTAL;
		gbc_descriptionText.gridx = 6;
		gbc_descriptionText.gridy = 9;
		getContentPane().add(descriptionText, gbc_descriptionText);
		descriptionText.setColumns(10);
		
		JLabel lblvisibilityBox = new JLabel("Visibility");
		lblvisibilityBox.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblvisibilityBox.setForeground(Color.RED);
		GridBagConstraints gbc_lblvisibilityBox = new GridBagConstraints();
		gbc_lblvisibilityBox.insets = new Insets(0, 0, 5, 5);
		gbc_lblvisibilityBox.gridx = 2;
		gbc_lblvisibilityBox.gridy = 10;
		getContentPane().add(lblvisibilityBox, gbc_lblvisibilityBox);
		
		final JComboBox visibilityBox = new JComboBox();
		visibilityBox.setModel(new DefaultComboBoxModel(new String[] {"public", "privat"}));
		GridBagConstraints gbc_visibilityBox = new GridBagConstraints();
		gbc_visibilityBox.insets = new Insets(0, 0, 5, 0);
		gbc_visibilityBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_visibilityBox.gridx = 6;
		gbc_visibilityBox.gridy = 10;
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
				
				if(title.equals("") || dateFrom.equals("") || dateTo.equals("") || timeFrom.equals("") || timeTo.equals("")){
					new JFrame("Please fill out the necessary window!").setVisible(true);
					JOptionPane.showMessageDialog(frame, "Please fill out the necessary window!");
				}else{
					if (repeat.equals("Unique")){
						Meeting.createMeeting(loginPerson, title, dateFrom, dateTo, timeFrom, timeTo, location, description, repeat, repeatTo, visibility);
						dispose();
					}
					if (repeat.equals("Daily")){
						Meeting.createMeeting(loginPerson, title, dateFrom, dateTo, timeFrom, timeTo, location, description, repeat, repeatTo, visibility);
						dispose();
					}
					if (repeat.equals("Weekly")){
						Meeting.createMeeting(loginPerson, title, dateFrom, dateTo, timeFrom, timeTo, location, description, repeat, repeatTo, visibility);
						dispose();
					}
					if (repeat.equals("Monthly")){
						Meeting.createMeeting(loginPerson, title, dateFrom, dateTo, timeFrom, timeTo, location, description, repeat, repeatTo, visibility);
						dispose();
					}
					if (repeat.equals("Yearly")){
						Meeting.createMeeting(loginPerson, title, dateFrom, dateTo, timeFrom, timeTo, location, description, repeat, repeatTo, visibility);
						dispose();
					}
				}
			}
		});
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.insets = new Insets(0, 0, 0, 5);
		gbc_btnCreate.gridx = 4;
		gbc_btnCreate.gridy = 11;
		getContentPane().add(btnCreate, gbc_btnCreate);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.gridx = 6;
		gbc_btnExit.gridy = 11;
		getContentPane().add(btnExit, gbc_btnExit);
	}
	
}