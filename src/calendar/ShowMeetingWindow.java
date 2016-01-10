package calendar;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class ShowMeetingWindow extends JDialog {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public ShowMeetingWindow(final Event meeting) {
		getContentPane().setBackground(Color.WHITE);
		setTitle("Meeting");
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(400, 0, 600, 400);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblOwner = new JLabel("Owner");
		lblOwner.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblOwner.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lblOwner = new GridBagConstraints();
		gbc_lblOwner.insets = new Insets(0, 0, 5, 5);
		gbc_lblOwner.gridx = 2;
		gbc_lblOwner.gridy = 2;
		getContentPane().add(lblOwner, gbc_lblOwner);
		
		JLabel ownerText = new JLabel(meeting.getOwner());
		ownerText.setFont( new Font("ARIAL", Font.BOLD, 20));
		ownerText.setForeground(Color.BLACK);
		GridBagConstraints gbc_ownerText = new GridBagConstraints();
		gbc_ownerText.insets = new Insets(0, 0, 5, 0);
		gbc_ownerText.gridx = 6;
		gbc_ownerText.gridy = 2;
		getContentPane().add(ownerText, gbc_ownerText);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblTitle.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 2;
		gbc_lblTitle.gridy = 3;
		getContentPane().add(lblTitle, gbc_lblTitle);
		
		JLabel titleText = new JLabel(meeting.getTitle());
		titleText.setFont( new Font("ARIAL", Font.BOLD, 20));
		titleText.setForeground(Color.BLACK);
		GridBagConstraints gbc_titleText = new GridBagConstraints();
		gbc_titleText.insets = new Insets(0, 0, 5, 0);
		gbc_titleText.gridx = 6;
		gbc_titleText.gridy = 3;
		getContentPane().add(titleText, gbc_titleText);
		
		JLabel lblDateFromText = new JLabel("Date (from)");
		lblDateFromText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblDateFromText.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_DateFromText = new GridBagConstraints();
		gbc_DateFromText.insets = new Insets(0, 0, 5, 5);
		gbc_DateFromText.gridx = 2;
		gbc_DateFromText.gridy = 4;
		getContentPane().add(lblDateFromText, gbc_DateFromText);
		
		JLabel dateFromText = new JLabel(meeting.getTitle());
		dateFromText.setFont( new Font("ARIAL", Font.BOLD, 20));
		dateFromText.setForeground(Color.BLACK);
		GridBagConstraints gbc_dateFromText = new GridBagConstraints();
		gbc_dateFromText.insets = new Insets(0, 0, 5, 0);
		gbc_dateFromText.gridx = 6;
		gbc_dateFromText.gridy = 4;
		getContentPane().add(dateFromText, gbc_dateFromText);
		
		JLabel lbldateToText = new JLabel("Date (to)");
		lbldateToText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lbldateToText.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lbldateToText = new GridBagConstraints();
		gbc_lbldateToText.insets = new Insets(0, 0, 5, 5);
		gbc_lbldateToText.gridx = 2;
		gbc_lbldateToText.gridy = 5;
		getContentPane().add(lbldateToText, gbc_lbldateToText);
		
		JLabel dateToText = new JLabel(meeting.getTitle());
		dateToText.setFont( new Font("ARIAL", Font.BOLD, 20));
		dateToText.setForeground(Color.BLACK);
		GridBagConstraints gbc_dateToText = new GridBagConstraints();
		gbc_dateToText.insets = new Insets(0, 0, 5, 0);
		gbc_dateToText.gridx = 6;
		gbc_dateToText.gridy = 5;
		getContentPane().add(dateToText, gbc_dateToText);
		
		JLabel lbltimeFromText = new JLabel("Time (from)");
		lbltimeFromText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lbltimeFromText.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lbltimeFromText = new GridBagConstraints();
		gbc_lbltimeFromText.insets = new Insets(0, 0, 5, 5);
		gbc_lbltimeFromText.gridx = 2;
		gbc_lbltimeFromText.gridy = 6;
		getContentPane().add(lbltimeFromText, gbc_lbltimeFromText);
		
		JLabel timeFromText = new JLabel(meeting.getTitle());
		timeFromText.setFont( new Font("ARIAL", Font.BOLD, 20));
		timeFromText.setForeground(Color.BLACK);
		GridBagConstraints gbc_timeFromText = new GridBagConstraints();
		gbc_timeFromText.insets = new Insets(0, 0, 5, 0);
		gbc_timeFromText.gridx = 6;
		gbc_timeFromText.gridy = 6;
		getContentPane().add(timeFromText, gbc_timeFromText);
		
		JLabel lbltimeToText = new JLabel("Time (to)");
		lbltimeToText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lbltimeToText.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lbltimeToText = new GridBagConstraints();
		gbc_lbltimeToText.insets = new Insets(0, 0, 5, 5);
		gbc_lbltimeToText.gridx = 2;
		gbc_lbltimeToText.gridy = 7;
		getContentPane().add(lbltimeToText, gbc_lbltimeToText);
		
		JLabel timeToText = new JLabel(meeting.getTitle());
		timeToText.setFont( new Font("ARIAL", Font.BOLD, 20));
		timeToText.setForeground(Color.BLACK);
		GridBagConstraints gbc_timeToText = new GridBagConstraints();
		gbc_timeToText.insets = new Insets(0, 0, 5, 0);
		gbc_timeToText.gridx = 6;
		gbc_timeToText.gridy = 7;
		getContentPane().add(timeToText, gbc_timeToText);
		
		JLabel lbllocationText = new JLabel("Location");
		lbllocationText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lbllocationText.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lbllocationText = new GridBagConstraints();
		gbc_lbllocationText.insets = new Insets(0, 0, 5, 5);
		gbc_lbllocationText.gridx = 2;
		gbc_lbllocationText.gridy = 8;
		getContentPane().add(lbllocationText, gbc_lbllocationText);
		
		JLabel locationText = new JLabel(meeting.getTitle());
		locationText.setFont( new Font("ARIAL", Font.BOLD, 20));
		locationText.setForeground(Color.BLACK);
		GridBagConstraints gbc_locationText = new GridBagConstraints();
		gbc_locationText.insets = new Insets(0, 0, 5, 0);
		gbc_locationText.gridx = 6;
		gbc_locationText.gridy = 8;
		getContentPane().add(locationText, gbc_locationText);
		
		JLabel lblrepeatTextBox = new JLabel("Repeat");
		lblrepeatTextBox.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblrepeatTextBox.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lblrepeatTextBox = new GridBagConstraints();
		gbc_lblrepeatTextBox.insets = new Insets(0, 0, 5, 5);
		gbc_lblrepeatTextBox.gridx = 2;
		gbc_lblrepeatTextBox.gridy = 9;
		getContentPane().add(lblrepeatTextBox, gbc_lblrepeatTextBox);
		
		JLabel repeatTextBox = new JLabel(meeting.getRepeat());
		repeatTextBox.setFont( new Font("ARIAL", Font.BOLD, 20));
		repeatTextBox.setForeground(Color.BLACK);
		GridBagConstraints gbc_repeatTextBox = new GridBagConstraints();
		gbc_repeatTextBox.insets = new Insets(0, 0, 5, 0);
		gbc_repeatTextBox.gridx = 6;
		gbc_repeatTextBox.gridy = 9;
		getContentPane().add(repeatTextBox, gbc_repeatTextBox);
		
		JLabel lblrepeatToText = new JLabel("Repeat (to)");
		lblrepeatToText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblrepeatToText.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lblrepeatToText = new GridBagConstraints();
		gbc_lblrepeatToText.insets = new Insets(0, 0, 5, 5);
		gbc_lblrepeatToText.gridx = 2;
		gbc_lblrepeatToText.gridy = 10;
		getContentPane().add(lblrepeatToText, gbc_lblrepeatToText);
		
		JLabel repeatToText = new JLabel(meeting.getTitle());
		repeatToText.setFont( new Font("ARIAL", Font.BOLD, 20));
		repeatToText.setForeground(Color.BLACK);
		GridBagConstraints gbc_repeatToText = new GridBagConstraints();
		gbc_repeatToText.insets = new Insets(0, 0, 5, 0);
		gbc_repeatToText.gridx = 6;
		gbc_repeatToText.gridy = 10;
		getContentPane().add(repeatToText, gbc_repeatToText);
		
		JLabel lbldescriptionText = new JLabel("Description");
		lbldescriptionText.setFont( new Font("ARIAL", Font.BOLD, 20));
		lbldescriptionText.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lbldescriptionText = new GridBagConstraints();
		gbc_lbldescriptionText.insets = new Insets(0, 0, 5, 5);
		gbc_lbldescriptionText.gridx = 2;
		gbc_lbldescriptionText.gridy = 11;
		getContentPane().add(lbldescriptionText, gbc_lbldescriptionText);
		
		JLabel descriptionText = new JLabel(meeting.getTitle());
		descriptionText.setFont( new Font("ARIAL", Font.BOLD, 20));
		descriptionText.setForeground(Color.BLACK);
		GridBagConstraints gbc_descriptionText = new GridBagConstraints();
		gbc_descriptionText.insets = new Insets(0, 0, 5, 0);
		gbc_descriptionText.gridx = 6;
		gbc_descriptionText.gridy = 11;
		getContentPane().add(descriptionText, gbc_descriptionText);
		
		JLabel lblvisibilityBox = new JLabel("Visibility");
		lblvisibilityBox.setFont( new Font("ARIAL", Font.BOLD, 20));
		lblvisibilityBox.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_lblvisibilityBox = new GridBagConstraints();
		gbc_lblvisibilityBox.insets = new Insets(0, 0, 5, 5);
		gbc_lblvisibilityBox.gridx = 2;
		gbc_lblvisibilityBox.gridy = 12;
		getContentPane().add(lblvisibilityBox, gbc_lblvisibilityBox);
		
		JLabel visibilityBox = new JLabel(meeting.getVisibility());
		visibilityBox.setFont( new Font("ARIAL", Font.BOLD, 20));
		visibilityBox.setForeground(Color.BLACK);
		GridBagConstraints gbc_visibilityBox = new GridBagConstraints();
		gbc_visibilityBox.insets = new Insets(0, 0, 5, 0);
		gbc_visibilityBox.gridx = 6;
		gbc_visibilityBox.gridy = 12;
		getContentPane().add(visibilityBox, gbc_visibilityBox);

		JButton btnOkay = new JButton("Okay");
		btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnOkay = new GridBagConstraints();
		gbc_btnOkay.insets = new Insets(0, 0, 5, 5);
		gbc_btnOkay.gridx = 4;
		gbc_btnOkay.gridy = 13;
		getContentPane().add(btnOkay, gbc_btnOkay);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.insets = new Insets(0, 0, 5, 0);
		gbc_btnExit.gridx = 6;
		gbc_btnExit.gridy = 13;
		getContentPane().add(btnExit, gbc_btnExit);
		
	}
	
}