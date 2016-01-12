package calendar;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseCalendar {

	public static void createDatabase(String calendarName, String id) {
		Connection c = null;
		Statement stmt = null;
		try {
			String databaseName = calendarName + id;
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./src/calendar/database/" + databaseName + ".db");
			stmt = c.createStatement();
			String sql = "CREATE TABLE COMPANY " + " (User           TEXT    NOT NULL, " 
					+ " title          TEXT    NOT NULL,"
					+ " dateFrom       TEXT    NOT NULL, " + " dateTo         TEXT    NOT NULL,"
					+ " timeFrom       TEXT    NOT NULL, " + " timeTo         TEXT    NOT NULL,"
					+ " location       TEXT    NOT NULL, " + " description    TEXT    NOT NULL, "
					+ " repeat         TEXT    NOT NULL, " + " repeatTo       TEXT    NOT NULL, "
					+ " visibility     TEXT    NOT NULL)";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
			
			// Register Name in DatabaseNames
			int r = (int) Math.random() * 256;
			int g = (int) Math.random() * 256;
			int b = (int) Math.random() * 256;
			DatabaseNames.setEntry(calendarName, id, r, g, b);
			
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public static boolean checkDatabase(String calendarName, String id) {
		String pathDb = "./src/calendar/database/databaseNames.db";
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			String sql = "select calendarName, id from databaseNames where calendarName = '" + calendarName
					+ "' and id='" + id + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				return false;
			} else {
				if (rs.getString("calendarName").equals(calendarName) && rs.getString("id").equals(id)) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			return false;
		}
	}

	/**
	 * create Event for the Person Owner
	 */
	public static void createEvent(String calendarName, String id, String title, String dateFrom, String dateTo,
			String timeFrom, String timeTo, String location, String description, String repeat, String repeatTo,
			String visibility) {
		String database = calendarName + id;
		System.out.println(database);
		System.out.println(visibility);
		String pathDb = System.getProperty("user.dir") + "/src/calendar/database/" + database + ".db";
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			String sql;
			if (visibility.equals("public")) {
				sql = "insert into COMPANY Values ('" + id + "', '" + title + "','" + dateFrom + "','" + dateTo + "','"
						+ timeFrom + "','" + timeTo + "', '" + location + "', '" + description + "', '" + repeat
						+ "', '" + repeatTo + "', '" + visibility + "')";
			} else {
				sql = "insert into COMPANY Values ('" + id + "', '" + title + "','" + dateFrom + "','" + dateTo + "','"
						+ timeFrom + "','" + timeTo + "', '" + location + "', '" + description + "', '" + repeat
						+ "', '" + repeatTo + "', '" + visibility + "')";
			}
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Event> getEntries(String calendarName, String id) {
		ArrayList<Event> list = new ArrayList<>();
		String database = calendarName + id;
		String pathDb = System.getProperty("user.dir") + "/src/calendar/database/" + database + ".db";
		try {
			Connection connn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			System.out.println(id);
			String sql = "select title,dateFrom,dateTo,timeFrom,timeTo,location,description,repeat,repeatTo,visibility from COMPANY where user = '" + id + "'";
			Statement stmmt = connn.createStatement();
			ResultSet rss = stmmt.executeQuery(sql);
			while (rss.next()) {
				Event e2 = new Event(rss.getString("title"), rss.getString("dateFrom"), rss.getString("dateTo"),
						rss.getString("timeFrom"), rss.getString("timeTo"), rss.getString("location"),
						rss.getString("description"), rss.getString("repeat"), rss.getString("repeatTo"),
						rss.getString("visibility"));
				list.add(e2);
			}
			if (connn != null)
				try {
					connn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}