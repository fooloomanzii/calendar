package calendar;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Client {
	private String firstName;
	private String surname;
	private String password;
	private String id;
	private String securityQuestion;
	private String answer;

	/**
	 * Konstruktor
	 */
	public Client(String firstName, String surname, String password, String id, String securityQuestion,
			String answer) {
		this.firstName = firstName;
		this.surname = surname;
		this.password = password;
		this.id = id;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getSurname() {
		return surname;
	}

	public String getPassword() {
		return password;
	}

	public String getid() {
		return id;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public static void insertNewPerson(String firstName, String surname, String password, String id,
			String securityQuestion, String answer) {
		try {
			String pathDb = System.getProperty("user.dir") + "/src/calendar/database/clients.db";
			File file = new File(pathDb);
			if (!file.exists()) {
				DatabaseNames.createClientDatabase();
			}
			
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO personTable VALUES ('" + firstName + "', '" + surname + "', '" + password + "', '"
					+ id + "', '" + securityQuestion + "', '" + answer + "')";
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

	public static void deletePerson(String id, String password) {
		String pathDb = System.getProperty("user.dir") + "/src/calendar/database/clients.db";
		File file = new File(pathDb);
		if (!file.exists()) {
			DatabaseNames.createClientDatabase();
		}
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			Statement stmt = conn.createStatement();
			String sql = "delete from personTable where id = '" + id + "'";
			stmt.executeUpdate(sql);
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
	}

	public void changeDataPerson(String firstName, String surname, String password, String id, String securityQuestion,
			String answer) {
		String pathDb = System.getProperty("user.dir") + "/src/calendar/database/clients.db";
		File file = new File(pathDb);
		if (!file.exists()) {
			DatabaseNames.createClientDatabase();
		}
		
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			if (!firstName.equals("")) {
				this.firstName = firstName;
			}
			if (!surname.equals("")) {
				this.surname = surname;
			}
			if (!password.equals("")) {
				this.password = password;
			}
			if (!id.equals("")) {
				this.id = id;
				System.out.println(this.id);
			}
			if (!securityQuestion.equals("")) {
				this.securityQuestion = securityQuestion;
			}
			if (!answer.equals("")) {
				this.answer = answer;
			}
			String sql = "update personTable set id = '" + this.id + "', firstName = '" + this.firstName
					+ "', surname = '" + this.surname + "', password = '" + this.password + "', securityQuestion ='"
					+ this.securityQuestion + "', answer = '" + this.answer + "'";
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean checkDataPerson(String id, String password) {
		String pathDb = System.getProperty("user.dir") + "/src/calendar/database/clients.db";
		File file = new File(pathDb);
		if (!file.exists()) {
			DatabaseNames.createClientDatabase();
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			String sql = "select id, password from personTable where id = '" + id + "' and password='" + password + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				conn.close();
				return false;
			} else {
				if (rs.getString("password").equals(password) && rs.getString("id").equals(id)) {
					conn.close();
					return true;
				} else {
					conn.close();
					return false;
				}
			}
		} catch (SQLException e) {
			return false;
		}
	}

	public static String passwordData(String id, String answer, String securityQuestion) {
		String pathDb = System.getProperty("user.dir") + "/src/calendar/database/clients.db";
		File file = new File(pathDb);
		if (!file.exists()) {
			DatabaseNames.createClientDatabase();
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			String sql = "select id, password, securityQuestion, answer from personTable where id = '" + id
					+ "' and securityQuestion='" + securityQuestion + "' and answer = '" + answer + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				return "";
			} else {
				if (rs.getString("securityQuestion").equals(securityQuestion) && rs.getString("id").equals(id)
						&& rs.getString("answer").equals(answer)) {
					return rs.getString("password");
				} else {
					if (conn != null) {
						try {
							conn.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
					return "";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "";
		}
	}

	public static boolean isRegistered(String id) {
		String pathDb = System.getProperty("user.dir") + "/src/calendar/database/clients.db";
		File file = new File(pathDb);
		if (!file.exists()) {
			DatabaseNames.createClientDatabase();
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			String sql = "select id from personTable where id = '" + id + "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				if (conn != null)
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				return true;
			} else {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ArrayList<String> getPersonData(String id) {
		String sql = "select firstName, surname, password, id, securityQuestion, answer from personTable where id = '"
				+ id + "'";
		String pathDb = System.getProperty("user.dir") + "/src/calendar/database/clients.db";
		File file = new File(pathDb);
		if (!file.exists()) {
			DatabaseNames.createClientDatabase();
		}
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String> personDataList = new ArrayList<>();
			personDataList.add(rs.getString("firstName"));
			personDataList.add(rs.getString("surname"));
			personDataList.add(rs.getString("password"));
			personDataList.add(rs.getString("id"));
			personDataList.add(rs.getString("securityQuestion"));
			personDataList.add(rs.getString("answer"));
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return personDataList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}