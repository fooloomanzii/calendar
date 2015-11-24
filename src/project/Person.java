private String nachname;
private String vorname;
private String passwort;
private String email;
private String sicherheitsfrage;
private String antwort;

public Person{

  public Person(String nachname, String vorname, String passwort, String email,
  String sicherheitsfrage, String antwort){
      this.nachname = nachname;
      this.vorname = vorname;
      this.passwort = passwort;
      this.email = email;
      this.sicherheitsfrage = sicherheitsfrage;
      this.antwort = antwort;
  }

  public void personLoeschen(){

  }

  public void persoenlicheDatenAendern(String nachname, String vorname, String passwort, String email,
  String sicherheitsfrage, String antwort){
      this.nachname = nachname;
      this.vorname = vorname;
      this.passwort = passwort;
      this.email = email;
      this.sicherheitsfrage = sicherheitsfrage;
      this.antwort = antwort;
  }

}
