package calendar;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseCalendar{
	
	public static void createDatabase(String calendarName, String id){
		Connection c = null;
	    Statement stmt = null;
	    try {
	    	  String databaseName = calendarName + id;
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
	
	public static boolean checkDatabase(String calendarName, String id){
		String pathDb ="./src/calendar/database/databaseNames.db";
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			String sql = "select CalendarName, id from COMPANY where calendarName = '" + calendarName + "' and id='" + id+ "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				return false;
			} else {
				if (rs.getString("CalendarName").equals(calendarName) && rs.getString("id").equals(id)) {
					return true;
				} else {
					return false;
				}
			}
		}catch(SQLException e){
			return false;
		}
	}
	
    /**
     * create Event for the Person Owner
     */
    public static void createEvent(String calendarName, String id, String title, String dateFrom, String dateTo, String timeFrom, 
    		String timeTo, String location, String description, String repeat, String repeatTo, 
    		String visibility){
    	String database = calendarName + id;
    	String pathDb = System.getProperty("user.dir") + "/src/calendar/database/" + database + ".db";
		try{
			Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
			String sql;
			if (visibility.equals("public")){
				sql = "insert into company Values ('"+id+"', '"+title+"','"+dateFrom+"','"+dateTo+"','"+timeFrom+"','"+timeTo+"', '"+location+"', '"+description+"', '"+repeat+"', '"+repeatTo+"', '"+visibility+"')";
			}else{
				sql = "insert into company Values ('"+id+"', '"+title+"','"+dateFrom+"','"+dateTo+"','"+timeFrom+"','"+timeTo+"', '"+location+"', '"+description+"', '"+repeat+"', '"+repeatTo+"', '"+visibility+"')";
			}
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
	
	public ArrayList<String> getEntrie(String mail){
		ArrayList<String> list = new ArrayList<>();
    	String pathDb = System.getProperty("user.dir") + "/src/calendar/database/databaseNames.db";
		try{
			Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
			String sql = "select CalendarName from COMPANY where id = '"+mail+"'";
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