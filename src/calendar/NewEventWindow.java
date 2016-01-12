package calendar;

import javax.swing.*;
import java.awt.*;

import net.sourceforge.jdatepicker.impl.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewEventWindow extends JDialog {

	private static final long serialVersionUID = 1L;

	private JLabel titleLabel;
	private JTextField titleTextField;
	private JLabel startDateLabel;
	private JLabel endDateLabel;
	private JLabel locationLabel;
	private JTextField locationTextField;
	private JLabel descriptionLabel;
	private JSlider startTimeSlider;
	private JPanel startTimePanel;
	private JPanel placeholder_1;
	private JPanel placeholder_2;
	private JPanel endTimePanel;
	private JSlider endTimeSlider;
	private JTextArea descriptionTextArea;
	private JLabel repeatLabel;

	SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	private JScrollPane scrollPane;

	/**
	 * Create the dialog.
	 */
	public NewEventWindow(final Client client, String date) {
		setResizable(false);
		
		setBackground(Color.WHITE);
		setBounds(500, 0, 332, 600);

		// Set Actual Date to DatePicker
		ZonedDateTime today = ZonedDateTime.now();
		Date day = new Date(today.toEpochSecond() * 1000);

		UtilDateModel startDateModel = new UtilDateModel(day);
		startDateModel.setSelected(true);
		JDatePanelImpl startDatePanel = new JDatePanelImpl(startDateModel);

		UtilDateModel endDateModel = new UtilDateModel(day);
		endDateModel.setSelected(true);
		JDatePanelImpl endDatePanel = new JDatePanelImpl(endDateModel);

		// GUI
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) buttonPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		flowLayout.setVgap(12);
		flowLayout.setHgap(12);

		JButton btnCreate = new JButton("Create");
		buttonPanel.add(btnCreate);

		JButton btnExit = new JButton("Exit");
		buttonPanel.add(btnExit);

		getContentPane().setBackground(Color.WHITE);
		setTitle("New Event");
		setModal(true);
		
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel contentPanel = new JPanel();
		contentPanel.setBackground(UIManager.getColor("window"));
		contentPanel.setBorder(new EmptyBorder(8, 8, 0, 8));
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 30 };
		gbl_contentPanel.rowHeights = new int[] { 30, 0, 30, 30, 30, 30, 30, 30, 0, 30 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0 };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0 };
		contentPanel.setLayout(gbl_contentPanel);

		titleLabel = new JLabel("title");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.ipady = 8;
		gbc_titleLabel.ipadx = 8;
		gbc_titleLabel.fill = GridBagConstraints.BOTH;
		gbc_titleLabel.insets = new Insets(5, 5, 5, 5);
		gbc_titleLabel.gridx = 0;
		gbc_titleLabel.gridy = 0;
		contentPanel.add(titleLabel, gbc_titleLabel);
		titleTextField = new JTextField();
		titleTextField.setText("unknown");
		titleTextField.setBackground(SystemColor.control);
		titleTextField.setMargin(new Insets(5, 5, 5, 5));
		GridBagConstraints gbc_titleTextField = new GridBagConstraints();
		gbc_titleTextField.weightx = 0.5;
		gbc_titleTextField.fill = GridBagConstraints.BOTH;
		gbc_titleTextField.insets = new Insets(5, 5, 5, 0);
		gbc_titleTextField.gridx = 1;
		gbc_titleTextField.gridy = 0;
		contentPanel.add(titleTextField, gbc_titleTextField);
		
		JLabel calendarLabel = new JLabel("calendar");
		calendarLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		calendarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		calendarLabel.setBackground(Color.WHITE);
		GridBagConstraints gbc_calendarLabel = new GridBagConstraints();
		gbc_calendarLabel.ipady = 8;
		gbc_calendarLabel.ipadx = 8;
		gbc_calendarLabel.insets = new Insets(5, 5, 5, 5);
		gbc_calendarLabel.gridx = 0;
		gbc_calendarLabel.gridy = 1;
		contentPanel.add(calendarLabel, gbc_calendarLabel);

		ArrayList<String> calendarNames = DatabaseNames.getCalenderNames(client.getid());
		System.out.println(calendarNames);
		
		JComboBox calendarComboBox = new JComboBox(calendarNames.toArray());
		GridBagConstraints gbc_calendarComboBox = new GridBagConstraints();
		gbc_calendarComboBox.ipady = 8;
		gbc_calendarComboBox.ipadx = 8;
		gbc_calendarComboBox.insets = new Insets(5, 5, 5, 0);
		gbc_calendarComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_calendarComboBox.gridx = 1;
		gbc_calendarComboBox.gridy = 1;
		contentPanel.add(calendarComboBox, gbc_calendarComboBox);

		startDateLabel = new JLabel("start date");
		startDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_startDateLabel = new GridBagConstraints();
		gbc_startDateLabel.ipady = 8;
		gbc_startDateLabel.ipadx = 8;
		gbc_startDateLabel.fill = GridBagConstraints.BOTH;
		gbc_startDateLabel.insets = new Insets(5, 5, 5, 5);
		gbc_startDateLabel.gridx = 0;
		gbc_startDateLabel.gridy = 2;
		contentPanel.add(startDateLabel, gbc_startDateLabel);
		JDatePickerImpl startDatePicker = new JDatePickerImpl(startDatePanel);
		startDatePicker.setMaximumSize(new Dimension(32813, 30));
		startDatePicker.setMinimumSize(new Dimension(52, 30));
		startDatePicker.setPreferredSize(new Dimension(202, 30));
		startDatePicker.getJFormattedTextField().setPreferredSize(new Dimension(178, 30));
		startDatePicker.setShowYearButtons(true);
		startDatePicker.getJFormattedTextField().setBackground(SystemColor.control);
		startDatePicker.getJFormattedTextField().setMargin(new Insets(5, 12, 5, 5));
		startDatePicker.setBackground(Color.WHITE);
		startDatePicker.getJFormattedTextField().setEditable(true);
		GridBagConstraints gbc_startDatePicker = new GridBagConstraints();
		gbc_startDatePicker.fill = GridBagConstraints.BOTH;
		gbc_startDatePicker.insets = new Insets(5, 5, 5, 0);
		gbc_startDatePicker.gridx = 1;
		gbc_startDatePicker.gridy = 2;
		contentPanel.add(startDatePicker, gbc_startDatePicker);

		placeholder_1 = new JPanel();
		placeholder_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_placeholder_1 = new GridBagConstraints();
		gbc_placeholder_1.fill = GridBagConstraints.BOTH;
		gbc_placeholder_1.insets = new Insets(5, 5, 5, 5);
		gbc_placeholder_1.gridx = 0;
		gbc_placeholder_1.gridy = 3;
		contentPanel.add(placeholder_1, gbc_placeholder_1);

		startTimePanel = new JPanel();
		startTimePanel.setBackground(Color.WHITE);
		GridBagConstraints gbc_startTimePanel = new GridBagConstraints();
		gbc_startTimePanel.fill = GridBagConstraints.BOTH;
		gbc_startTimePanel.insets = new Insets(5, 5, 5, 0);
		gbc_startTimePanel.gridx = 1;
		gbc_startTimePanel.gridy = 3;
		contentPanel.add(startTimePanel, gbc_startTimePanel);
		GridBagLayout gbl_startTimePanel = new GridBagLayout();
		gbl_startTimePanel.columnWidths = new int[] { 195, 70, 0 };
		gbl_startTimePanel.rowHeights = new int[] { 23, 0 };
		gbl_startTimePanel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_startTimePanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		startTimePanel.setLayout(gbl_startTimePanel);

		startTimeSlider = new JSlider();
		startTimeSlider.setMaximum(1439);
		startTimeSlider.setForeground(Color.WHITE);
		startTimeSlider.setBackground(SystemColor.window);
		GridBagConstraints gbc_startTimeSlider = new GridBagConstraints();
		gbc_startTimeSlider.weightx = 0.5;
		gbc_startTimeSlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_startTimeSlider.gridx = 0;
		gbc_startTimeSlider.gridy = 0;
		startTimePanel.add(startTimeSlider, gbc_startTimeSlider);

		JFormattedTextField startTimeTextField = new JFormattedTextField(timeFormat);
		startTimeTextField.setBackground(SystemColor.control);
		startTimeTextField.setMargin(new Insets(4, 4, 4, 4));
		startTimeTextField.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_startTimeTextField = new GridBagConstraints();
		gbc_startTimeTextField.ipady = 8;
		gbc_startTimeTextField.ipadx = 8;
		gbc_startTimeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_startTimeTextField.gridx = 1;
		gbc_startTimeTextField.gridy = 0;
		startTimePanel.add(startTimeTextField, gbc_startTimeTextField);

		endDateLabel = new JLabel("end date");
		endDateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_endDateLabel = new GridBagConstraints();
		gbc_endDateLabel.ipady = 8;
		gbc_endDateLabel.ipadx = 8;
		gbc_endDateLabel.fill = GridBagConstraints.BOTH;
		gbc_endDateLabel.insets = new Insets(5, 5, 5, 5);
		gbc_endDateLabel.gridx = 0;
		gbc_endDateLabel.gridy = 4;
		contentPanel.add(endDateLabel, gbc_endDateLabel);
		JDatePickerImpl endDatePicker = new JDatePickerImpl(endDatePanel);
		endDatePicker.setMinimumSize(new Dimension(52, 30));
		endDatePicker.setMaximumSize(new Dimension(32813, 30));
		endDatePicker.setPreferredSize(new Dimension(202, 30));
		endDatePicker.getJFormattedTextField().setPreferredSize(new Dimension(178, 30));
		endDatePicker.getJFormattedTextField().setBackground(SystemColor.control);
		endDatePicker.setBackground(Color.WHITE);
		endDatePicker.getJFormattedTextField().setEditable(true);
		endDatePicker.getJFormattedTextField().setMargin(new Insets(5, 12, 5, 5));
		GridBagConstraints gbc_endDatePicker = new GridBagConstraints();
		gbc_endDatePicker.fill = GridBagConstraints.BOTH;
		gbc_endDatePicker.insets = new Insets(5, 5, 5, 0);
		gbc_endDatePicker.gridx = 1;
		gbc_endDatePicker.gridy = 4;
		contentPanel.add(endDatePicker, gbc_endDatePicker);

		placeholder_2 = new JPanel();
		placeholder_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_placeholder_2 = new GridBagConstraints();
		gbc_placeholder_2.fill = GridBagConstraints.BOTH;
		gbc_placeholder_2.insets = new Insets(5, 5, 5, 5);
		gbc_placeholder_2.gridx = 0;
		gbc_placeholder_2.gridy = 5;
		contentPanel.add(placeholder_2, gbc_placeholder_2);

		endTimePanel = new JPanel();
		endTimePanel.setBackground(Color.WHITE);
		GridBagConstraints gbc_endTimePanel = new GridBagConstraints();
		gbc_endTimePanel.fill = GridBagConstraints.BOTH;
		gbc_endTimePanel.insets = new Insets(5, 5, 5, 0);
		gbc_endTimePanel.gridx = 1;
		gbc_endTimePanel.gridy = 5;
		contentPanel.add(endTimePanel, gbc_endTimePanel);
		GridBagLayout gbl_endTimePanel = new GridBagLayout();
		gbl_endTimePanel.columnWidths = new int[] { 195, 70, 0 };
		gbl_endTimePanel.rowHeights = new int[] { 23, 0 };
		gbl_endTimePanel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_endTimePanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		endTimePanel.setLayout(gbl_endTimePanel);

		endTimeSlider = new JSlider();
		endTimeSlider.setForeground(Color.WHITE);
		endTimeSlider.setMaximum(1439);
		endTimeSlider.setBackground(SystemColor.window);
		GridBagConstraints gbc_endTimeSlider = new GridBagConstraints();
		gbc_endTimeSlider.weightx = 0.5;
		gbc_endTimeSlider.fill = GridBagConstraints.HORIZONTAL;
		gbc_endTimeSlider.gridx = 0;
		gbc_endTimeSlider.gridy = 0;
		endTimePanel.add(endTimeSlider, gbc_endTimeSlider);

		JFormattedTextField endTimeTextField = new JFormattedTextField(timeFormat);
		endTimeTextField.setBackground(SystemColor.control);
		endTimeTextField.setMargin(new Insets(4, 4, 4, 4));
		endTimeTextField.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_endTimeTextField = new GridBagConstraints();
		gbc_endTimeTextField.ipadx = 8;
		gbc_endTimeTextField.ipady = 8;
		gbc_endTimeTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_endTimeTextField.gridx = 1;
		gbc_endTimeTextField.gridy = 0;
		endTimePanel.add(endTimeTextField, gbc_endTimeTextField);

		descriptionTextArea = new JTextArea();
		descriptionTextArea.setBackground(SystemColor.control);
		descriptionTextArea.setLineWrap(true);
		descriptionTextArea.setMargin(new Insets(8, 8, 8, 8));

		scrollPane = new JScrollPane(descriptionTextArea);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weighty = 0.5;
		gbc_scrollPane.ipady = 8;
		gbc_scrollPane.ipadx = 8;
		gbc_scrollPane.insets = new Insets(5, 5, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 6;

		contentPanel.add(scrollPane, gbc_scrollPane);

		descriptionLabel = new JLabel("description");
		descriptionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_descriptionLabel = new GridBagConstraints();
		gbc_descriptionLabel.anchor = GridBagConstraints.NORTH;
		gbc_descriptionLabel.ipady = 8;
		gbc_descriptionLabel.ipadx = 8;
		gbc_descriptionLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_descriptionLabel.insets = new Insets(5, 5, 5, 5);
		gbc_descriptionLabel.gridx = 0;
		gbc_descriptionLabel.gridy = 6;
		contentPanel.add(descriptionLabel, gbc_descriptionLabel);

		locationLabel = new JLabel("location");
		locationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_locationLabel = new GridBagConstraints();
		gbc_locationLabel.ipadx = 8;
		gbc_locationLabel.ipady = 8;
		gbc_locationLabel.fill = GridBagConstraints.BOTH;
		gbc_locationLabel.insets = new Insets(5, 5, 5, 5);
		gbc_locationLabel.gridx = 0;
		gbc_locationLabel.gridy = 7;
		contentPanel.add(locationLabel, gbc_locationLabel);

		locationTextField = new JTextField();
		locationTextField.setBackground(SystemColor.control);
		locationTextField.setMargin(new Insets(5, 5, 5, 5));
		GridBagConstraints gbc_locationTextField = new GridBagConstraints();
		gbc_locationTextField.insets = new Insets(5, 5, 5, 0);
		gbc_locationTextField.fill = GridBagConstraints.BOTH;
		gbc_locationTextField.gridx = 1;
		gbc_locationTextField.gridy = 7;
		contentPanel.add(locationTextField, gbc_locationTextField);

		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JLabel publicLabel = new JLabel("public");
		publicLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_publicLabel = new GridBagConstraints();
		gbc_publicLabel.ipady = 8;
		gbc_publicLabel.ipadx = 8;
		gbc_publicLabel.insets = new Insets(5, 5, 5, 5);
		gbc_publicLabel.gridx = 0;
		gbc_publicLabel.gridy = 8;
		contentPanel.add(publicLabel, gbc_publicLabel);

		JRadioButton publicRadioButton = new JRadioButton("");
		publicRadioButton.setBackground(new Color(255, 255, 255));
		publicRadioButton.setMargin(new Insets(5, 5, 5, 5));
		publicRadioButton.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_publicRadioButton = new GridBagConstraints();
		gbc_publicRadioButton.ipadx = 8;
		gbc_publicRadioButton.anchor = GridBagConstraints.WEST;
		gbc_publicRadioButton.insets = new Insets(5, 5, 5, 0);
		gbc_publicRadioButton.gridx = 1;
		gbc_publicRadioButton.gridy = 8;
		contentPanel.add(publicRadioButton, gbc_publicRadioButton);

		repeatLabel = new JLabel("repeat");
		repeatLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		repeatLabel.setHorizontalAlignment(SwingConstants.CENTER);
		repeatLabel.setBackground(Color.WHITE);
		GridBagConstraints gbc_repeatLabel = new GridBagConstraints();
		gbc_repeatLabel.ipady = 8;
		gbc_repeatLabel.ipadx = 8;
		gbc_repeatLabel.insets = new Insets(5, 5, 0, 5);
		gbc_repeatLabel.gridx = 0;
		gbc_repeatLabel.gridy = 9;
		contentPanel.add(repeatLabel, gbc_repeatLabel);

		JComboBox repeatComboBox = new JComboBox(new String[] { "Unique", "Daily", "Weekly", "Monthly" , "Yearly"});
		GridBagConstraints gbc_repeatComboBox = new GridBagConstraints();
		gbc_repeatComboBox.ipady = 8;
		gbc_repeatComboBox.ipadx = 8;
		gbc_repeatComboBox.insets = new Insets(5, 5, 0, 0);
		gbc_repeatComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_repeatComboBox.gridx = 1;
		gbc_repeatComboBox.gridy = 9;
		contentPanel.add(repeatComboBox, gbc_repeatComboBox);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

		// Event Listener

		// EndTime Slider Changed
		endTimeSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				int endvalue = endTimeSlider.getValue();
				int startvalue = startTimeSlider.getValue();
				if (endvalue < startvalue && (endDateModel.getValue().compareTo(startDateModel.getValue()) <= 0)) {
					endTimeSlider.setValue(startvalue);
					endvalue = startvalue;
				}
				endTimeTextField.setText(
						String.format("%02d", endvalue / 60) + ":" + String.format("%02d", endvalue % 60) + " ");
			}
		});

		// StartTime Slider Changed
		startTimeSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				int startvalue = startTimeSlider.getValue();
				int endvalue = endTimeSlider.getValue();
				if (endvalue < startvalue && (endDateModel.getValue().compareTo(startDateModel.getValue()) <= 0)) {
					endTimeSlider.setValue(startvalue);

				}
				startTimeTextField.setText(
						String.format("%02d", startvalue / 60) + ":" + String.format("%02d", startvalue % 60) + " ");
			}
		});

		endDateModel.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				if (endDateModel.getValue().compareTo(startDateModel.getValue()) < 0) {
					endDateModel.setValue(startDateModel.getValue());
					int endvalue = endTimeSlider.getValue();
					int startvalue = startTimeSlider.getValue();
					if (endvalue < startvalue) {
						endTimeSlider.setValue(startvalue);
					}
				}
			}
		});
		startDateModel.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				if (endDateModel.getValue().compareTo(startDateModel.getValue()) < 0) {
					endDateModel.setValue(startDateModel.getValue());
					int endvalue = endTimeSlider.getValue();
					int startvalue = startTimeSlider.getValue();
					if (endvalue < startvalue) {
						endTimeSlider.setValue(startvalue);
					}
				}
			}
		});

		// Set StandardValue of TimeSliders to ActualTime
		if (today.getHour() < 20) {
			// if actual hour is lower then 20:00, set the the Slider to next
			// Hour
			startTimeSlider.setValue((today.getHour() + 1) * 60);
			endTimeSlider.setValue((today.getHour() + 1) * 60 + 30);
		} else {
			// else Set to next day 8:00
			startTimeSlider.setValue(480);
			endTimeSlider.setValue(510);
			startDateModel.setValue(new Date((today.toEpochSecond() + 86400) * 1000));
			startDateModel.setSelected(true);
		}

		// TextField Listeners for StartTime and EndTime
		ActionListener startTimeTextFieldActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JFormattedTextField source = (JFormattedTextField) actionEvent.getSource();
				Date time = (Date) source.getValue();
				int diff = endTimeSlider.getValue() - startTimeSlider.getValue();
				// Ensure that the input is lower than a day, to avoid parsing
				// conflicts for later usage
				if (time.getTime() < 86400000) {
					startTimeSlider.setValue(time.getHours() * 60 + time.getMinutes());
					endTimeSlider.setValue(time.getHours() * 60 + time.getMinutes() + diff);
				} else {
					startTimeSlider.setValue(endTimeSlider.getValue());
				}
			}

		};
		startTimeTextField.addActionListener(startTimeTextFieldActionListener);

		ActionListener endTimeTextFieldActionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				JFormattedTextField source = (JFormattedTextField) actionEvent.getSource();
				Date time = (Date) source.getValue();
				// Ensure that the input is lower than a day, to avoid parsing
				// conflicts for later usage
				if (time.getTime() < 86400000) {
					endTimeSlider.setValue(time.getHours() * 60 + time.getMinutes());
				} else {
					endTimeSlider.setValue(startTimeSlider.getValue());
				}
			}

		};
		endTimeTextField.addActionListener(endTimeTextFieldActionListener);
		// Create Button Events
		btnCreate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				// if title is Empty, the title input field is highlighted
				if (titleTextField.getText().isEmpty()) {
					titleTextField.setBackground(new Color(255, 210, 220));
				}
				// else, the event is saved
				else {
					String title = titleTextField.getText();
					String dateFrom = "" + startDateModel.getDay() +"."+startDateModel.getMonth() +"."+startDateModel.getYear();
					String dateTo = "" + endDateModel.getDay() +"."+endDateModel.getMonth() +"."+endDateModel.getYear();
					String timeFrom = startTimeTextField.getText();
					String timeTo = endTimeTextField.getText();
					String location = locationTextField.getText();
					String description = descriptionTextArea.getText();
					String repeat = (String) repeatComboBox.getSelectedItem();
					String repeatTo = (repeat.compareTo("Unique") != 0 ? "true" : "false");
					String visibility = (publicRadioButton.isSelected() ? "true" : "false");

					String calendarName = calendarComboBox.getSelectedItem().toString();
					String id = client.getid();
					DatabaseCalendar.createEvent(calendarName, id, title, dateFrom, dateTo, timeFrom, timeTo, location,
							description, repeat, repeatTo, visibility);
					dispose();
				}
			}
		});

		// Exit Button
		btnExit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});

	}
}