package calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import net.miginfocom.swing.MigLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class UserLoginDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private JTextField textid;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public UserLoginDialog(String userID) {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(new Color(0, 0, 0));
		setModal(true);

		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 0, 300, 180);
		getContentPane().setLayout(new MigLayout("", "[172.00px,grow]", "[grow][19px]"));

		JPanel typePanel = new JPanel();
		typePanel.setBackground(SystemColor.window);
		getContentPane().add(typePanel, "cell 0 0,growx,aligny top");
		GridBagLayout gbl_typePanel = new GridBagLayout();
		gbl_typePanel.columnWidths = new int[] { 0 };
		gbl_typePanel.rowHeights = new int[] { 0 };
		gbl_typePanel.columnWeights = new double[] { 1.0 };
		gbl_typePanel.rowWeights = new double[] { 0.0, 0.0 };
		typePanel.setLayout(gbl_typePanel);
		textid = new JTextField(userID);
		textid.setHorizontalAlignment(SwingConstants.CENTER);
		textid.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textid.setMargin(new Insets(5, 5, 5, 5));
		textid.setEditable(false);
		textid.setFocusable(false);
		GridBagConstraints gbc_textid = new GridBagConstraints();
		gbc_textid.fill = GridBagConstraints.BOTH;
		gbc_textid.insets = new Insets(5, 5, 5, 5);
		gbc_textid.gridx = 0;
		gbc_textid.gridy = 0;
		typePanel.add(textid, gbc_textid);
		textid.setColumns(10);
		passwordField = new JPasswordField();
		passwordField.setMargin(new Insets(5, 5, 5, 5));
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 5, 0, 5);
		gbc_passwordField.gridx = 0;
		gbc_passwordField.gridy = 1;
		typePanel.add(passwordField, gbc_passwordField);
		passwordField.setColumns(10);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(SystemColor.window);
		getContentPane().add(buttonPanel, "cell 0 1,growx,aligny baseline");
		buttonPanel.setLayout(new MigLayout("", "[grow][grow][grow]", "[]"));

		JButton btnOkay = new JButton("\u2713");
		btnOkay.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnOkay.setMargin(new Insets(8, 12, 8, 12));
		buttonPanel.add(btnOkay, "cell 0 0,grow");
		btnOkay.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String id = textid.getText();
				String password = passwordField.getText();
				if (!Client.checkDataPerson(id, password)) {
					JOptionPane.showMessageDialog(getContentPane(), "Wrong Password or Wrong Username!", "",
							JOptionPane.ERROR_MESSAGE);
				} else {
					ArrayList<String> data = Client.getPersonData(id);
					dispose();
					Client per = new Client(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4),
							data.get(5));
					LoginCalendarWindow win = new LoginCalendarWindow(per);
					win.getFrame().setVisible(true);
				}
			}
		});

		JButton btnCancel = new JButton("\u2717");
		btnCancel.setMargin(new Insets(8, 12, 8, 12));
		btnCancel.setFont(new Font("Dialog", Font.PLAIN, 12));
		buttonPanel.add(btnCancel, "cell 1 0,grow");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				MainWindow.MainFrame.setVisible(true);
				
			}
		});

		JButton btnForgotPassword = new JButton("Reset Password");
		btnForgotPassword.setMargin(new Insets(8, 12, 8, 12));
		btnForgotPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		buttonPanel.add(btnForgotPassword, "cell 2 0,grow");
		btnForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgotPasswordWindow fens = new ForgotPasswordWindow();
				fens.setVisible(true);
			}
		});

	}

}
