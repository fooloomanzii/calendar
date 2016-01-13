package calendar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;

public class MainWindow {

	public static JFrame MainFrame;
	private static JPanel UserPanel;

	public static void main(String[] args) {
		// Construct frame
		MainFrame = new JFrame();
		MainFrame.getContentPane().setBackground(SystemColor.window);
		MainFrame.setResizable(false);
		MainFrame.setBackground(Color.WHITE);
		MainFrame.setTitle("Calender User Login");
		MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.getContentPane().setLayout(new MigLayout("", "[300px:n,grow]", "[grow][bottom]"));

		// Add button
		JButton addButton = new JButton("+ add User");
		addButton.setBackground(SystemColor.activeCaption);
		addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		addButton.setMargin(new Insets(8, 14, 8, 14));
		addButton.addActionListener(addRegisterListener());
		JPanel AddPanel = new JPanel();
		AddPanel.setLayout(new GridLayout(0, 1, 0, 0));
		AddPanel.add(addButton);
		MainFrame.getContentPane().add(AddPanel, "cell 0 1,alignx center,aligny bottom");

		// UserButton Field
		UserPanel = new JPanel();
		UserPanel.setBackground(Color.WHITE);
		MainFrame.getContentPane().add(UserPanel, "cell 0 0,grow");
		MigLayout migUserLayout = new MigLayout("", "[grow 90,fill]", "[][]");
		UserPanel.setLayout(migUserLayout);
		
		updateAllUserButtons();
		migUserLayout.invalidateLayout(UserPanel);
		
		// Pack frame
		MainFrame.pack();

		// Make frame visible
		MainFrame.setVisible(true);
	}

	public static void updateAllUserButtons() {
		UserPanel.removeAll();
		MigLayout migUserLayout = new MigLayout("", "[grow 90,fill]", "[][]");
		UserPanel.setLayout(migUserLayout);
		ArrayList<String> userIDs = DatabaseNames.getUserIds();
		ArrayList<JButton> userIDButtons = new ArrayList<JButton>();

		for (String userID : userIDs) {
			userIDButtons.add(addUserButton(userID));
		}
		JLabel userLabel = new JLabel("active Users");
		userLabel.setHorizontalAlignment(SwingConstants.LEFT);
		userLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		UserPanel.add(userLabel, "wrap");
		
		for (JButton c : userIDButtons) {
			UserPanel.add(c, "wrap");
		}
		migUserLayout.invalidateLayout(UserPanel);
		MainFrame.getContentPane().repaint();
	}

	private static JButton addUserButton(String id) {
		JButton button = new JButton(id);
		button.setFont(new Font("Tahoma", Font.PLAIN, 11));
		button.setMargin(new Insets(12, 12, 12, 12));
		button.addActionListener(addLoginListener(id));
		return button;
	}

	private static ActionListener addLoginListener(String id) {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.setVisible(false);
				UserLoginDialog win = new UserLoginDialog(id);
				win.setVisible(true);
				
			}
		};
	}

	private static ActionListener addRegisterListener() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.setVisible(false);
				RegistrationWindow win = new RegistrationWindow();
				win.setVisible(true);
			}
		};
	}
}