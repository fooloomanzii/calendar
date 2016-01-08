package calendar;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Meeting{
	
	private String title;
	private String dateFrom;
	private String dateTo;
	private String timeFrom;
	private String timeTo;
	private String location;
	private String description;
	private String repeat;
	private String repeatTo;
	private String visibility;
	private String owner;
	
	public String getTitle() {
		return title;
	}

	public String getDateFrom() {
		return dateFrom;
	}

	public String getDateTo() {
		return dateTo;
	}

	public String getTimeFrom() {
		return timeFrom;
	}

	public String getTimeTo() {
		return timeTo;
	}

	public String getLocation() {
		return location;
	}

	public String getDescription() {
		return description;
	}

	public String getRepeat() {
		return repeat;
	}

	public String getRepeatTo() {
		return repeatTo;
	}

	public String getVisibility() {
		return visibility;
	}
	
	public String getOwner() {
		return owner;
	}
	
	/**
	 * Konstruktor
	 */
    public Meeting(String owner, String title, String dateFrom, String dateTo, String timeFrom, String timeTo, 
    		String location, String description, String repeat, String repeatTo, String visibility){ 	
    	this.owner = owner;
       	this.title = title;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.location = location;
		this.description = description;
		this.repeat = repeat;
		this.repeatTo = repeatTo;
		this.visibility = visibility;
	}

    /**
     * create Meeting for the Person Owner
     */
    public static void createMeeting(Person owner, String title, String dateFrom, String dateTo, String timeFrom, 
    		String timeTo, String location, String description, String repeat, String repeatTo, 
    		String visibility){
    	String pathDb = System.getProperty("user.dir") + "/src/calendar/meetingCalendar.db";
		try{
			Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
			String sql;
			if (visibility.equals("public")){
				sql = "insert into meetingTable Values ('"+owner.getEmail()+"', '"+title+"','"+dateFrom+"','"+dateTo+"','"+timeFrom+"','"+timeTo+"', '"+location+"', '"+description+"', '"+repeat+"', '"+repeatTo+"', '"+visibility+"')";
			}else{
				sql = "insert into meetingTable Values ('"+owner.getEmail()+"', '"+title+"','"+dateFrom+"','"+dateTo+"','"+timeFrom+"','"+timeTo+"', '"+location+"', '"+description+"', '"+repeat+"', '"+repeatTo+"', '"+visibility+"')";
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
    
    /**
     * change Meeting for the Person Owner
     */
    public static void changeMeeting(Meeting termin, String title, String dateFrom, String dateTo, 
    		String timeFrom, String timeTo, String location, String description, String repeat, 
    		String repeatTo, String visibility){
    	String pathDb = System.getProperty("user.dir") + "/src/calendar/meetingCalendar.db";
    	
		try{
			Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
		    String sql = "update meetingTable set title = '"+title+"', dateFrom = '"+dateFrom+"', dateTo = '"+dateTo+"', timeFrom = '"+timeFrom+"', timeTo ='"+timeTo+"', location = '"+location+"', description = '"+description+"', repeat = '"+repeat+"', repeatTo = '"+repeatTo+"', visibility = '"+visibility+"' "
		    		+ "where title = '"+ termin.getTitle() + "'and dateFrom = '"+ termin.getDateFrom()+ "'and dateTo = '"+ termin.getDateTo()+ "'and timeFrom = '"+ termin.getTimeFrom()+ "'and timeTo = '"+ termin.getTimeTo()+ "'and location = '"+ termin.getLocation()+ "'and description = '"+ termin.getDescription()+ "'and repeat = '"+ termin.getRepeat()+ "'and repeatTo = '"+ termin.getRepeatTo()+ "'and visibility = '"+ termin.getVisibility()+"'";
		    Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			if(conn != null){
			    try{ 
			    	conn.close(); 
			    }catch(SQLException e){ 
			    	e.printStackTrace(); 
			    }
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
    }

    /**
     * create MeetingList where the Meeting is "a"
     */
	public static ArrayList<Meeting> getMeetingList(String a){
    	ArrayList<Meeting> meetingList = new ArrayList<>();
    	String pathDb = System.getProperty("user.dir") + "/src/calendar/meetingCalendar.db";
		try{
			Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
			String sql = "select owner, title, dateFrom, dateTo, timeFrom, timeTo, location, repeat, repeatTo, description, visibility from meetingTable where visibility = '"+a+"'";
			Statement stmt = conn.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				Meeting me = new Meeting(rs.getString("owner"), rs.getString("title"),rs.getString("dateFrom"),
						rs.getString("dateTo"),rs.getString("timeFrom"),rs.getString("timeTo"),
						rs.getString("location"),rs.getString("description"), rs.getString("repeat"),
						rs.getString("repeatTo"), rs.getString("visibility"));
				meetingList.add(me);
			}
			if ( conn != null )
			    try { conn.close(); } catch ( SQLException e ) { e.printStackTrace(); }
			return meetingList;
		}catch (SQLException e){
			e.printStackTrace();
		}
		return meetingList;
    }

}