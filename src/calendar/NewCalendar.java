package calendar;

import java.awt.Color;
import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewCalendar extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private JTextField textFieldName;
	private Color color = Color.WHITE;

	/**
	 * Create the dialog.
	 */
	public NewCalendar(final Client client) {
		setModal(true);
		setAlwaysOnTop(true);
		setTitle("New Calendar");
		setBounds(450, 0, 540, 300);
		getContentPane().setLayout(new MigLayout("", "[134px:n][174.00][20px:n,grow][134px:n]", "[][20px:n][40px:n][]"));
		
		JLabel Name = new JLabel("Calendar name:");
		getContentPane().add(Name, "cell 0 0,alignx center");
		
		textFieldName = new JTextField();
		getContentPane().add(textFieldName, "cell 1 0 3 1,growx");
		textFieldName.setColumns(10);
		
		final JLabel lblActaulSelectedColor = new JLabel("actual selected Color:");
		getContentPane().add(lblActaulSelectedColor, "cell 1 1,alignx center");
		
		final JPanel panel = new JPanel();
		getContentPane().add(panel, "cell 2 1,grow");
		panel.setLayout(new MigLayout("", "[]", "[]"));
		panel.setBackground(color);
		JButton btnChooseColor = new JButton("choose Color");
		btnChooseColor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				color = JColorChooser.showDialog(getContentPane(), "Colors", Color.WHITE);
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
				String calendarName = textFieldName.getText();
				if (calendarName.equals("")){
					JOptionPane.showMessageDialog(getContentPane(), "Please, insert an name for your calendar!","",JOptionPane.ERROR_MESSAGE);
				}else{
					if (DatabaseCalendar.checkDatabase(calendarName,client.getid())){
						JOptionPane.showMessageDialog(getContentPane(), "Name allready used!","",JOptionPane.ERROR_MESSAGE);
					}else{
						DatabaseNames.setEntries(textFieldName.getText(), client.getid(), color.getRed(), color.getGreen(), color.getBlue());
						DatabaseCalendar.createDatabase(calendarName,client.getid());
						dispose();
					}
				}
			}
		});
		getContentPane().add(btnOkay, "cell 0 3,growx");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		getContentPane().add(btnCancel, "cell 3 3,growx");
		
		
		
	}
}
