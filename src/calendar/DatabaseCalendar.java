package calendar;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import java.io.*;

public class DatabaseCalendar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static File f = new File("DatabaseNames.txt");

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
	
	public static void createDatabase(String calendarName, Client client){
		Connection c = null;
	    Statement stmt = null;
	    try {
	    	  String databaseName = calendarName + client.getEmail();
	    	  FileWriter fw = new FileWriter(f);
	    	  fw.write(databaseName+".db");
		      Class.forName("org.sqlite.JDBC");
		      c = DriverManager.getConnection("jdbc:sqlite:"+databaseName+".db");
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
	    } catch (IOException e) {
	        e.printStackTrace();
	    }catch ( Exception e ) {
		      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		      System.exit(0);
	   }
	}
	
	public boolean checkDatabase(String calendarName, Client client){
		try{
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();
			String name = calendarName + client.getEmail() + ".db";
			while(line != null){
				if(line.equals(name)){
					br.close();
					return true;
				}else{
					br.readLine();
				}
			}
			br.close();
			return false;
		}catch(IOException e){
			System.out.println(e.getMessage());
			return true;
		}
	}
	
}