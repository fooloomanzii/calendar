package calendar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DatabaseNames {

	public static void main(String args []){
		createDatabase();
	}
	
	public static void createDatabase(){
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./src/calendar/database/databaseNames.db");
			stmt = c.createStatement();
			String sql = "CREATE TABLE COMPANY " +
			             "(ID INT PRIMARY KEY     NOT NULL," +
			             " CalendarName          TEXT    NOT NULL, " +
			             " EMail           TEXT    NOT NULL)";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		}catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
	
	public ArrayList<String> getEntries(Client client){
		ArrayList<String> list = new ArrayList<>();
    	String pathDb = System.getProperty("user.dir") + "/src/calendar/database/databaseNames.db";
		try{
			Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
			String sql = "select CalendarName from COMPANY where EMail = '"+client.getEmail()+"'";
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