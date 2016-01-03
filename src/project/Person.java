package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Person {
	//private final int nummer;
	private String nachname;
	private String vorname;
	private String passwort;
	private String email;
	private String sicherheitsfrage;
	private String antwort;
	public static int nummer = 0;

	public Person(String nachname, String vorname, String passwort, String email, String sicherheitsfrage,
			String antwort) throws SQLException {
		
		String pathDb = System.getProperty("user.dir") + "/src/project/anmeldungKalender.db";
		// Connection zur Datenbank herstellen besteht die Moeglichkit zwei weitere Parameter 
		// anzugeben für Benutzername und Passwort
		// throwes sql Exception wenn kein Zugriff auf die Datenbank moeglich ist
		Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
		Statement stmt1 = conn.createStatement();
		String sql1 = "select count(*) from anmeldung";
		ResultSet rs = stmt1.executeQuery(sql1);
		nummer=rs.getInt(1)+1;
		this.nachname = nachname;
		this.vorname = vorname;
		this.passwort = passwort;
		this.email = email;
		this.sicherheitsfrage = sicherheitsfrage;
		this.antwort = antwort;
		Statement stmt = conn.createStatement();
		String sql = "INSERT INTO anmeldung VALUES ("+nummer+",'"+nachname+"', '"+vorname+"', '"+passwort+"', '"+email+"', '"+sicherheitsfrage+"', '"+antwort+"')";
		//System.out.println(sql);
		stmt.executeUpdate(sql);
		if ( conn != null )
		    try { conn.close(); } catch ( SQLException e ) { e.printStackTrace(); }
		
	}

	public void personLoeschen(String email, String passwort) throws Exception {
		String pathDb = System.getProperty("user.dir") + "/src/project/anmeldungKalender.db";
		try{
			Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
			String sql = "select nummer,passwort,email from anmeldung where email = '"+email+"' and passwort = '"+ passwort+"'";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int id;
				id = rs.getInt("nummer");
				sql = "delete from anmeldung where nummer = "+id;
				stmt.executeUpdate(sql);
				sql = "update anmeldung set nummer = (select nummer-1 from anmeldung)"
						+ "where nummer > "+id;
				stmt.executeUpdate(sql);
				sql = "select nummer,passwort,email from anmeldung";
				rs = stmt.executeQuery(sql);
				System.out.println(rs.getInt(1) + rs.getString("email"));
		}catch (SQLException e){
			e.printStackTrace();
			return;
		}
	}

	public void persoenlicheDatenAendern(int nummer, String nachname, String vorname, String passwort, String email,
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
	    String sql = "update anmeldung set nachname = '"+this.nachname+"', vorname = '"+this.vorname+"', passwort = '"+this.passwort+"', email = '"+this.email+"', sicherheitsfrage ='"+this.sicherheitsfrage+"', antwort = '"+this.antwort+"' where nummer = "+ nummer;
	    Statement stmt = conn.createStatement();
	    System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println(rs.getString("nachname"));
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
