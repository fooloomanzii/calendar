package calendar;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DatabaseNames {

	public static void main(String args[]) {
	}

	public static void createClientDatabase() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./src/calendar/database/clients.db");
			stmt = c.createStatement();
			String sql = "CREATE TABLE personTable " + " (firstName TEXT NOT NULL, "
					+ " surName TEXT NULL, password TEXT NOT NULL, "
					+ " id TEXT PRIMARY KEY NOT NULL, securityQuestion TEXT NOT NULL, answer TEXT NOT NULL)  ";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void createCalendarNameDatabase() {
		Connection c = null;
		Statement stmt = null;
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./src/calendar/database/databaseNames.db");
			stmt = c.createStatement();
			String sql = "CREATE TABLE databaseNames " + " (calendarName TEXT NOT NULL, "
					+ " id TEXT PRIMARY KEY NOT NULL, Red Int NOT NULL, " + " Green Int NOT NULL, Blue Int NOT NULL)  ";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setEntry(String database, String id, int r, int g, int b) {
		String pathDb = System.getProperty("user.dir") + "/src/calendar/database/databaseNames.db";
		File file = new File(pathDb);
		if (!file.exists()) {
			createCalendarNameDatabase();
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);

			String sql = "insert into databaseNames Values ('" + database + "', '" + id + "', '" + r + "', '" + g + "', '" + b
					+ "')";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<String> getEntries(String id) {
		ArrayList<String> list = new ArrayList<>();
		String pathDb = System.getProperty("user.dir") + "/src/calendar/database/databaseNames.db";
		File file = new File(pathDb);
		if (!file.exists()) {
			createCalendarNameDatabase();
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);			
			Statement stmt = conn.createStatement();
			String sql = "select calendarName from databaseNames where id = '" + id + "'";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(rs.getString("calendarName"));
			}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}