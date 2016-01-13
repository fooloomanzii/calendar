package calendar;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.google.api.services.calendar.model.CalendarListEntry;

import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class NewCalendarWindow extends JDialog {
	private JTextField textField;
	private Color color = Color.WHITE;
	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client client = new Client ("", "", "", "", "", "");
					NewCalendarWindow dialog = new NewCalendarWindow(client);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*
	/**
	 * Create the dialog.
	 */
	public NewCalendarWindow(final Client client) {
		getContentPane().setBackground(SystemColor.window);
		setModal(true);

		setTitle("New Calendar");
		setBounds(100, 100, 331, 171);
		getContentPane().setLayout(new MigLayout("", "[fill][fill][30px:n,fill]", "[30px:n][30px:n][30px:n]"));

		JLabel lblNewLabel = new JLabel("Calendar name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, "cell 0 0,alignx center");

		textField = new JTextField();
		textField.setBackground(SystemColor.control);
		getContentPane().add(textField, "cell 1 0 2 1,growx");
		textField.setColumns(10);

		final JLabel lblActaulSelectedColor = new JLabel("actual selected Color:");
		lblActaulSelectedColor.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblActaulSelectedColor, "cell 1 1,alignx center");


		final JPanel panel = new JPanel();
		getContentPane().add(panel, "cell 2 1,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		panel.setBackground(color);
		JButton btnChooseColor = new JButton("choose Color");
		btnChooseColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				color = JColorChooser.showDialog(getContentPane(), "Colors",
						new Color(((int) (Math.random() * 100)) + 156,((int) (Math.random() * 100)) + 156,((int) (Math.random() * 100)) + 156));
				panel.setBackground(new Color(color.getRed(),color.getGreen(),color.getBlue()));
				setVisible(false);
				setVisible(true);
			}
		});
		getContentPane().add(btnChooseColor, "cell 0 1,growx");

		JButton btnOkay = new JButton("Okay");
		btnOkay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String calendarName = textField.getText();
				if (calendarName.equals("")){
					JOptionPane.showMessageDialog(getContentPane(), "Please, insert an name for your calendar!","",JOptionPane.ERROR_MESSAGE);
				}else{
					if (DatabaseCalendar.checkDatabase(calendarName,client.getid())){
						JOptionPane.showMessageDialog(getContentPane(), "Name allready used!","",JOptionPane.ERROR_MESSAGE);
					}else{
						DatabaseCalendar.createDatabase(calendarName,client.getid(),color.getRed(),color.getGreen(),color.getBlue());
						dispose();
					}
				}
			}
		});
		getContentPane().add(btnOkay, "flowx,cell 1 2");

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		getContentPane().add(btnCancel, "cell 1 2,growx");



	}
}
