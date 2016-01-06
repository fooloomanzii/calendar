package kalender;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class Termin{
	private String titel;
	private String datumVon;
	private String datumBis;
	private String uhrzeitVon;
	private String uhrzeitBis;
	private String ort;
	private String beschreibung;
	private String wiederholung;
	private String sichtbarkeit;
	
    public Termin(String titel, String datumVon, String datumBis, String uhrzeitVon, String uhrzeitBis, String ort, String wiederholung,
    String beschreibung, String sichtbarkeit){
       	this.titel = titel;
		this.datumVon = datumVon;
		this.datumBis = datumBis;
		this.uhrzeitVon = uhrzeitVon;
		this.uhrzeitBis = uhrzeitBis;
		this.ort = ort;
		this.wiederholung = wiederholung;
		this.beschreibung = beschreibung;
		this.sichtbarkeit = sichtbarkeit;
	}


/**    public void terminLoesches()throws Exception {
		String pathDb = System.getProperty("user.dir") + "/src/project/terminKalender.db";
		try{
			Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
			String sql = "select titel from termin where titel = '"+titel;
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int id;
				id = rs.getInt("nummer");
				sql = "delete from titel where titel = "+titel;
				stmt.executeUpdate(sql);
				rs = stmt.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();
			return;
		}
	}
*/

    /*public void terminAendern(String titel, String datumVon, String datumBis, String uhrzeitVon, String uhrzeitBis, String ort, String wiederholung,
    	    String beschreibung, String sichtbarkeit){
    	String pathDb = System.getProperty("user.dir") + "/src/project/terminKalender.db";
		try{
		Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
		if(!titel.equals("")){
	          this.titel = titel;
	    }if(!datumVon.equals("")){
	    	this.datumVon = datumVon;
	    }if(!datumBis.equals("")){
	    	this.datumBis = datumBis;
	    }if(!uhrzeitVon.equals("")){
	    	this.uhrzeitVon = uhrzeitVon;
	    }if(!uhrzeitBis.equals("")){
	    	this.uhrzeitBis = uhrzeitBis;
	    }if(!wiederholung.equals("")){
	    	this.wiederholung = wiederholung;
	    }if(!ort.equals("")){
	    	this.ort = ort;
	    }if(!beschreibung.equals("")){
	    	this.beschreibung = beschreibung;
	    }if(!sichtbarkeit.equals("")){
	    	this.sichtbarkeit = sichtbarkeit;
	    }
	    String sql = "update termin set titel = '"+this.titel+"', datumVon = '"+this.datumVon+"', datumBis = '"+this.datumBis+"', uhrzeitVon = '"+this.uhrzeitVon+"', uhrzeitBis ='"+this.uhrzeitBis+"', wiederholung = '"+this.wiederholung+"', ort = '"+this.ort+"', beschreibung = '"+this.beschreibung+"', sichtbarkeit = '"+this.sichtbarkeit+"' where titel = "+ titel;
	    Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		}catch (SQLException e){
			e.printStackTrace();
		}
    } */
    public static void terminAendern(Termin termin, String titel, String datumVon, String datumBis, String uhrzeitVon, String uhrzeitBis, String ort, String wiederholung,
    	    String beschreibung, String sichtbarkeit){
    	String pathDb = System.getProperty("user.dir") + "/src/project/terminKalender.db";
		try{
			//System.out.println(sichtbarkeit);
		Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
	    String sql = "update termin set titel = '"+titel+"', datumVon = '"+datumVon+"', datumBis = '"+datumBis+"', uhrzeitVon = '"+uhrzeitVon+"', uhrzeitBis ='"+uhrzeitBis+"', wiederholung = '"+wiederholung+"', ort = '"+ort+"', beschreibung = '"+beschreibung+"', sichtbarkeit = '"+sichtbarkeit+"' "
	    		+ "where titel = '"+ termin.getTitel() + "'and datumVon = '"+ termin.getDatumVon()+ "'and datumBis = '"+ termin.getDatumBis()+ "'and uhrzeitVon = '"+ termin.getUhrzeitVon()+ "'and uhrzeitBis = '"+ termin.getUhrzeitBis()+ "'and wiederholung = '"+ termin.getWiederholung()+ "'and ort = '"+ termin.getOrt()+ "'and beschreibung = '"+ termin.getBeschreibung()+ "'and sichtbarkeit = '"+ termin.getSichtbarkeit()+"'";
	    Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		if ( conn != null )
		    try { conn.close(); } catch ( SQLException e ) { e.printStackTrace(); }
		}catch (SQLException e){
			e.printStackTrace();
		}
    }
    public String getDatumBis() {
	return datumBis;
}


public String getUhrzeitVon() {
	return uhrzeitVon;
}


public String getUhrzeitBis() {
	return uhrzeitBis;
}


public String getOrt() {
	return ort;
}


public String getBeschreibung() {
	return beschreibung;
}


public String getWiederholung() {
	return wiederholung;
}


public String getSichtbarkeit() {
	return sichtbarkeit;
}


	public static ArrayList<Termin> getTermine(String besitzer){
    	ArrayList<Termin> terminlist = new ArrayList<>();
    	String pathDb = System.getProperty("user.dir") + "/src/project/terminKalender.db";
		try{
		Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
		//System.out.println(besitzer);
		String sql = "select titel, datumVon, datumBis, uhrzeitVon, uhrzeitBis, ort, wiederholung, beschreibung, sichtbarkeit from termin where sichtbarkeit = '"+besitzer+"'";
	    Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		/*sql = "select * from termin";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);*/
		//System.out.println(rs.getString("titel"));
		while (rs.next()){
			//System.out.println("Hallors");
			Termin ter = new Termin(rs.getString("titel"),rs.getString("datumVon"),rs.getString("datumBis"),rs.getString("uhrzeitVon"),rs.getString("uhrzeitBis"),rs.getString("ort"),rs.getString("wiederholung"),rs.getString("beschreibung"),rs.getString("sichtbarkeit"));
			//System.out.println(ter.datumVon);
			terminlist.add(ter);
		}
		if ( conn != null )
		    try { conn.close(); } catch ( SQLException e ) { e.printStackTrace(); }
		return terminlist;
		}catch (SQLException e){
			e.printStackTrace();
		}
		return terminlist;
    }
    public static void terminAnlegen(String titel, String datumVon, String datumBis, String uhrzeitVon, String uhrzeitBis, String ort, String wiederholung,
    	    String beschreibung, String sichtbarkeit,Person besitzer){
    	String pathDb = System.getProperty("user.dir") + "/src/project/terminKalender.db";
		try{
			Connection conn = DriverManager.getConnection( "jdbc:sqlite:" + pathDb);
			String sql;
			if (sichtbarkeit.equals("Oeffentlich")){
				sql = "insert into termin Values ('"+titel+"','"+datumVon+"','"+datumBis+"','"+uhrzeitVon+"','"+uhrzeitBis+"', '"+wiederholung+"', '"+ort+"', '"+beschreibung+"', '"+sichtbarkeit+"')";
			}else{
				sql = "insert into termin Values ('"+titel+"', '"+datumVon+"', '"+datumBis+"', '"+uhrzeitVon+"', '"+uhrzeitBis+"', '"+wiederholung+"', '"+ort+"', '"+beschreibung+"', '"+besitzer.getEmail()+"')";
			}
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			if ( conn != null )
			    try { conn.close(); } catch ( SQLException e ) { e.printStackTrace(); }
		}catch (SQLException e){
			e.printStackTrace();
		}
    }


	public String getTitel() {
		return titel;
	}
	
	public String getDatumVon(){
		return datumVon;
	}

}