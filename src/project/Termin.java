package project;

import java.sql.Time;
import java.util.Date;



public class Termin{
	private String titel;
	private Date datum;
	private Time uhrzeit;
	private Time zeitspanne;
	private String ort;
	private String besitzer;
	private String wiederholung;
	private String beschreibung;
	private String sichtbarkeit;
	
    public Termin(String titel, Date datum, Time uhrzeit, Time zeitspanne, String ort, String besitzer, String wiederholung,
    String beschreibung, String sichtbarkeit){
        this.titel = titel;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.zeitspanne = zeitspanne;
        this.ort = ort;
        this.besitzer = besitzer;
        this.wiederholung = wiederholung;
        this.beschreibung = beschreibung;
        this.sichtbarkeit = sichtbarkeit;
        
    }

    public void terminLoesches(){

    }

    public void terminAendern(String titel, Date datum, Time uhrzeit, Time zeitspanne, String ort, String besitzer, String wiederholung,
    String beschreibung, String sichtbarkeit){
        this.titel = titel;
        this.datum = datum;
        this.uhrzeit = uhrzeit;
        this.zeitspanne = zeitspanne;
        this.ort = ort;
        this.besitzer = besitzer;
        this.wiederholung = wiederholung;
        this.beschreibung = beschreibung;
        this.sichtbarkeit = sichtbarkeit;
    }

}
