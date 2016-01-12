package calendar;

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
	private String email;
	private String securityQuestion;
	private String answer;

	/**
	 * Konstruktor
	 */
	public Client(String firstName, String surname, String password, String email, String securityQuestion, String answer){
		this.firstName = firstName;
		this.surname = surname;
		this.password = password;
		this.email = email;
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
	
	public String getEmail() {
		return email;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public static void insertNewPerson(String firstName, String surname, String password, String email, String securityQuestion, String answer){
		try{
			String pathDb = System.getProperty("user.dir") + "/src/calendar/clients.db";
			Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO personTable VALUES ('"+firstName+"', '"+surname+"', '"+password+"', '"+email+"', '"+securityQuestion+"', '"+answer+"')";
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

/*	public void deletePerson(String email, String password) throws Exception {
		String pathDb = System.getProperty("user.dir") + "/src/calendar/clients.db";
		try{
			Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
			Statement stmt = conn.createStatement();
			String sql = "delete from anmeldung where email = '"+email+"'";
			stmt.executeUpdate(sql);
			if ( conn != null )
			    try { conn.close(); } catch ( SQLException e ) { e.printStackTrace(); }
		}catch (SQLException e){
			e.printStackTrace();
			return;
		}
	}*/

/*	public void changeDataPerson(String firstName, String surname, String password, String email, String securityQuestion, String answer) {
		String pathDb = System.getProperty("user.dir") + "/src/calendar/clients.db";
		try{
		Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
		if(!firstName.equals("")){
	         this.firstName = firstName;
	    }
		if(!surname.equals("")){
	    	this.surname = surname;
	    }
		if(!password.equals("")){
	    	this.password = password;
	    }
		if(!email.equals("")){
	    	this.email = email;
	    }
		if(!securityQuestion.equals("")){
	    	this.securityQuestion = securityQuestion;
	    }
		if(!answer.equals("")){
	    	this.answer = answer;
	    }
	    String sql = "update personTable set email = '"+this.email+"', firstName = '"+this.firstName+"', surname = '"+this.surname+"', password = '"+this.password+"', securityQuestion ='"+this.securityQuestion+"', answer = '"+this.answer+"'";
	    Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    if ( conn != null )
		    try { 
		    	conn.close(); 
		    }catch(SQLException e){ 
		    	e.printStackTrace();
		    }
		}catch (SQLException e){
			e.printStackTrace();
		}
	}*/

	public static boolean checkDataPerson(String email, String password) {
		String pathDb = System.getProperty("user.dir") + "/src/calendar/clients.db";
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			String sql = "select email, password from personTable where email = '" + email + "' and password='" + password+ "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				return false;
			} else {
				if (rs.getString("password").equals(password) && rs.getString("email").equals(email)) {
					return true;
				} else {
					return false;
				}
			}
		}catch(SQLException e){
			return false;
		}
	}

	public static String passwordData(String email, String answer, String securityQuestion) {
		String pathDb = System.getProperty("user.dir") + "/src/calendar/clients.db";
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			String sql = "select email, password, securityQuestion, answer from personTable where email = '" + email + "' and securityQuestion='" + securityQuestion+ "' and answer = '"+answer+"'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				if ( conn != null )
				    try { 
				    	conn.close(); 
				    }catch(SQLException e ){ 
				    	e.printStackTrace(); 
				    }
				return "";
			} else {
				if (rs.getString("securityQuestion").equals(securityQuestion) && rs.getString("email").equals(email) && rs.getString("answer").equals(answer)) {
					return rs.getString("password");
				} else {
					if(conn != null){
						try { 
							conn.close(); 
						}catch(SQLException e){ 
							e.printStackTrace(); 
						}
					}
					return "";
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
			return "";
		}
	}

	public static boolean emailAlreadyExist(String email) {
		String pathDb = System.getProperty("user.dir") + "/src/calendar/clients.db";
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			String sql = "select email from personTable where email = '"+email+"'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()){
				if( conn != null)
				    try{ 
				    	conn.close(); 
				    }catch(SQLException e){ 
				    	e.printStackTrace(); 
				    }
				return true;
			}else{
				if(conn != null){
				    try { 
				    	conn.close(); 
				    }catch(SQLException e){ 
				    	e.printStackTrace();
				    }
				}
				return false;
			}
		}catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static ArrayList<String> getPersonData(String email){
		String sql = "select firstName, surname, password, email, securityQuestion, answer from personTable where email = '"+email+"'";
		String pathDb = System.getProperty("user.dir") + "/src/calendar/clients.db";
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String> personDataList = new ArrayList<>();
			personDataList.add(rs.getString("firstName"));
			personDataList.add(rs.getString("surname"));
			personDataList.add(rs.getString("password"));
			personDataList.add(rs.getString("email"));
			personDataList.add(rs.getString("securityQuestion"));
			personDataList.add(rs.getString("answer"));
			if(conn != null){
				try { 
					conn.close(); 	
				}catch(SQLException e){ 
					e.printStackTrace(); 
				}
			}
			return personDataList;
		}catch (SQLException e){
			e.printStackTrace();
		}
		return null;
	}
	
}