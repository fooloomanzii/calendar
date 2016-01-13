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
	 * 
	 * public static void main(String[] args) { try { DeleteUserWindow dialog =
	 * new DeleteUserWindow();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */
	/**
	 * Create the dialog.
	 */
	public DeleteUserWindow(final Client loginPerson) {
		setModal(true);

		setBounds(100, 100, 415, 169);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow]", "[20px:n,grow,center]"));
		{
			JLabel lblDoYouReally = new JLabel("Do you really want to delete your account !");
			lblDoYouReally.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblDoYouReally.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblDoYouReally, "cell 0 0,alignx center");
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new MigLayout("", "[grow]", "[25px]"));
			{
				{
					JButton okButton = new JButton("Yes");
					okButton.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							setVisible(false);
							Client.deletePerson(loginPerson.getid(), loginPerson.getPassword());
							JOptionPane.showMessageDialog(getContentPane(), "Account has been deleted successfully!");
							MainWindow.MainFrame.setVisible(true);
						}
					});
					okButton.setActionCommand("OK");
					buttonPane.add(okButton, "flowx,cell 0 0,alignx center,aligny top");
					getRootPane().setDefaultButton(okButton);
				}
			}
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
			buttonPane.add(cancelButton, "cell 0 0,alignx right,aligny top");
		}
	}

}
