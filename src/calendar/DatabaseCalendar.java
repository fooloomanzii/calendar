package calendar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.util.ArrayList;
import java.io.*;

public class DatabaseCalendar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DatabaseCalendar dialog = new DatabaseCalendar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DatabaseCalendar() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public static void createDatabase(String calendarName, String email){
		Connection c = null;
	    Statement stmt = null;
	    try {
	    	  String databaseName = calendarName + email;
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:./src/calendar/database/"+databaseName+".db");
		      stmt = c.createStatement();
		      String sql = "CREATE TABLE COMPANY " +
		                   "(ID INT PRIMARY KEY     NOT NULL," +
		                   " Color          TEXT    NOT NULL, " +
		                   " User           TEXT    NOT NULL, " +
		                   " title           TEXT    NOT NULL,"  +
		                   " dateFrom           TEXT    NOT NULL, " +
		                   " dateTo           TEXT    NOT NULL,"  +
		                   " timeFrom           TEXT    NOT NULL, " +
		                   " timeTo           TEXT    NOT NULL,"  +
		                   " location           TEXT    NOT NULL, " +
		                   " description          TEXT    NOT NULL, "+
		                   " repeat          TEXT    NOT NULL, " +
		                   " repeatTo          TEXT    NOT NULL, " +
		                   " visibility          TEXT    NOT NULL)";
		      stmt.executeUpdate(sql);
		      stmt.close();
		      c.close();
	    }catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
	   }
	}
	
	public static boolean checkDatabase(String calendarName, String email){
		String pathDb ="./src/calendar/database/databaseNames.db";
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			String sql = "select CalendarName, EMail from COMPANY where calendarName = '" + calendarName + "' and email='" + email+ "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				return false;
			} else {
				if (rs.getString("CalendarName").equals(calendarName) && rs.getString("email").equals(email)) {
					return true;
				} else {
					return false;
				}
			}
		}catch(SQLException e){
			return false;
		}
	}
	public ArrayList<String> getEntrie(String mail){
		ArrayList<String> list = new ArrayList<>();
    	String pathDb = System.getProperty("user.dir") + "/src/calendar/database/databaseNames.db";
		try{
			Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
			String sql = "select CalendarName from COMPANY where EMail = '"+mail+"'";
			Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				list.add(rs.getString("CalendarName"));
			}
			if ( conn != null )
			    try{ 
			    	conn.close(); 
			    }catch(SQLException e){ 
			    	e.printStackTrace(); 
			    }
		}catch (SQLException e){
			e.printStackTrace();
		}
		return list;
	}
}
	
