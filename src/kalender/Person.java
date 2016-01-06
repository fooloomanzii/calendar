package kalender;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class Person {
	//private final int nummer;
	private String nachname;
	private String vorname;
	private String passwort;
	private String email;
	private String sicherheitsfrage;
	private String antwort;

	public Person(String nachname, String vorname, String passwort, String email, String sicherheitsfrage,
			String antwort){
		this.nachname = nachname;
		this.vorname = vorname;
		this.passwort = passwort;
		this.email = email;
		this.sicherheitsfrage = sicherheitsfrage;
		this.antwort = antwort;
		
		
	}
	public static void insertNewPerson(String nachname, String vorname, String email, String passwort, String sicherheitsfrage,
			String antwort){
		try{
		String pathDb = System.getProperty("user.dir") + "/src/project/anmeldungKalender.db";
		// Connection zur Datenbank herstellen besteht die Moeglichkit zwei weitere Parameter 
		// anzugeben für Benutzername und Passwort
		// throwes sql Exception wenn kein Zugriff auf die Datenbank moeglich ist
		Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
		Statement stmt1 = conn.createStatement();
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO anmeldung VALUES ('"+nachname+"', '"+vorname+"', '"+email+"', '"+passwort+"', '"+sicherheitsfrage+"', '"+antwort+"')";
		//System.out.println(sql);
		stmt.executeUpdate(sql);
		if ( conn != null )
		    try { conn.close(); } catch ( SQLException e ) { e.printStackTrace(); }
		}catch (SQLException e){
			e.printStackTrace();
		}
	}
	public String getNachname() {
		return nachname;
	}
	public String getVorname() {
		return vorname;
	}
	public String getPasswort() {
		return passwort;
	}
	public String getSicherheitsfrage() {
		return sicherheitsfrage;
	}
	public String getAntwort() {
		return antwort;
	}
	public void personLoeschen(String email, String passwort) throws Exception {
		String pathDb = System.getProperty("user.dir") + "/src/project/anmeldungKalender.db";
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
	}

	public void persoenlicheDatenAendern(String nachname, String vorname, String passwort, String email,
			String sicherheitsfrage, String antwort) {
		String pathDb = System.getProperty("user.dir") + "/src/project/anmeldungKalender.db";
		try{
		Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
		if(!nachname.equals("")){
	         this.nachname = nachname;
	    }if(!vorname.equals(""))
	    {
	    	this.vorname = vorname;
	    }if(!passwort.equals("")){
	    	this.passwort = passwort;
	    }if(!email.equals("")){
	    	this.email = email;
	    }if(!sicherheitsfrage.equals("")){
	    	this.sicherheitsfrage = sicherheitsfrage;
	    }if(!antwort.equals("")){
	    	this.antwort = antwort;
	    }
	    String sql = "update anmeldung set nachname = '"+this.nachname+"', vorname = '"+this.vorname+"', passwort = '"+this.passwort+"', email = '"+this.email+"', sicherheitsfrage ='"+this.sicherheitsfrage+"', antwort = '"+this.antwort+"'";
	    Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    if ( conn != null )
		    try { conn.close(); } catch ( SQLException e ) { e.printStackTrace(); }
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

	public static boolean ueberpruefeDaten(String email, String passwort) {
		String pathDb = System.getProperty("user.dir") + "/src/project/anmeldungKalender.db";
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			String sql = "select email, passwort from anmeldung where email = '" + email + "' and passwort='" + passwort
					+ "'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				return false;
			} else {
				if (rs.getString("passwort").equals(passwort) && rs.getString("email").equals(email)) {
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			
			return false;
		}
	}

	public static String passwortDaten(String email, String frage, String antwort) {
		String pathDb = System.getProperty("user.dir") + "/src/project/anmeldungKalender.db";
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			String sql = "select email, passwort, sicherheitsfrage, antwort from anmeldung where email = '" + email + "' and sicherheitsfrage='" + 
			frage+ "' and antwort = '"+antwort+"'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				if ( conn != null )
				    try { conn.close(); } catch ( SQLException e ) { e.printStackTrace(); }
				return "";
			} else {
				if (rs.getString("sicherheitsfrage").equals(frage) && rs.getString("email").equals(email) && rs.getString("antwort").equals(antwort)) {
					return rs.getString("passwort");
				} else {
					if ( conn != null )
					    try { conn.close(); } catch ( SQLException e ) { e.printStackTrace(); }
					return "";
				}
			}
		} catch (SQLException e) {
			return "";
		}
	}

	public static boolean emailSchonDa(String email) {
		String pathDb = System.getProperty("user.dir") + "/src/project/anmeldungKalender.db";
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			String sql = "select email from anmeldung where email = '"+email+"'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()){
				if ( conn != null )
				    try { conn.close(); } catch ( SQLException e ) { e.printStackTrace(); }
				return true;
			}else{
				if ( conn != null )
				    try { conn.close(); } catch ( SQLException e ) { e.printStackTrace(); }
				return false;
			}
		}catch (SQLException e){
			return true;
		}
	}
	public String getEmail(){
		return this.email;
	}
	public static ArrayList<String> getPersonenDaten(String email){
		String sql = "select vorname,nachname,email,passwort,sicherheitsfrage,antwort from anmeldung where email = '"+email+"'";
		String pathDb = System.getProperty("user.dir") + "/src/project/anmeldungKalender.db";
		try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + pathDb);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<String> datenlist = new ArrayList<>();
			datenlist.add(rs.getString("vorname"));
			datenlist.add(rs.getString("nachname"));
			datenlist.add(rs.getString("email"));
			datenlist.add(rs.getString("passwort"));
			datenlist.add(rs.getString("sicherheitsfrage"));
			datenlist.add(rs.getString("antwort"));
			if ( conn != null )
			    try { conn.close(); } catch ( SQLException e ) { e.printStackTrace(); }
			return datenlist;
		}catch (SQLException e){
			e.printStackTrace();
		}
		return null;

	}
}
