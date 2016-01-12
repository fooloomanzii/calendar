package calendar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.api.services.calendar.model.CalendarListEntry;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteUserWindow extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			DeleteUserWindow dialog = new DeleteUserWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Create the dialog.
	 */
	public DeleteUserWindow(final Client loginPerson) {
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(100, 100, 516, 169);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[307px]", "[20px:n,center]"));
		{
			JLabel lblDoYouReally = new JLabel("Do you really want to delete your account !");
			lblDoYouReally.setFont(new Font("Dialog", Font.BOLD, 20));
			lblDoYouReally.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblDoYouReally, "cell 0 0,grow");
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new MigLayout("", "[148.00px][167.00][141.00px]", "[25px]"));
			{
				JButton okButton = new JButton("OK");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false);
						Client.deletePerson(loginPerson.getEmail(), loginPerson.getPassword());
						JOptionPane.showMessageDialog(getContentPane(), "Account has been deleted successfully!");
						CalendarWindow win = new CalendarWindow();
						win.getFrame().setVisible(true);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton, "cell 0 0,alignx left,aligny top");
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						setVisible(false);
						LoginCalendarWindow win = new LoginCalendarWindow(loginPerson);
						win.getFrame().setVisible(true);
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton, "cell 2 0,alignx right,aligny top");
			}
		}
	}

}
