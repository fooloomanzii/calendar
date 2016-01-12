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
			             " (CalendarName          TEXT    NOT NULL, " +
			             " EMail           TEXT    PRIMARY KEY NOT NULL," +
			             " Red         Int      NOT NULL, "+
			             " Green       Int      NOT NULL, "+
			             " Blue        Int      NOT NULL)  ";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		}catch ( Exception e ) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			System.exit(0);
		}
	}
	
	public static void setEntries(String databaseName, String email, int r, int g, int b){
    	String pathDb = System.getProperty("user.dir") + "/src/calendar/database/databaseNames.db";
		try{
			Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
			String sql;
			sql = "insert into company Values ('"+databaseName+"', '"+email+"', '"+r+"', '"+g+"', '"+b+"')";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			if ( conn != null )
			    try { 
			    	conn.close(); 
			    }catch(SQLException e){ 
			    	e.printStackTrace(); 
			    }
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static ArrayList<String> getEntries(String mail){
		ArrayList<String> list = new ArrayList<>();
    	String pathDb = System.getProperty("user.dir") + "/src/calendar/database/databaseNames.db";
		try{
			Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
			Statement stmt = conn.createStatement();
			String sql = "select CalendarName from COMPANY where EMail = '"+mail+"'";
		    ResultSet rs = stmt.executeQuery(sql);
		    list.add(rs.getString("CalendarName"));
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