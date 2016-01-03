package project;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

public class Kalender{
	
	public static void main(String[] args) {
		KalenderWindow kalender = new KalenderWindow();
		kalender.setBounds(10, 10, 420, 180);
		kalender.show();
		final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
		try {
			Person per = new Person("Test","","pass","Test","","");
			Person per2 = new Person("Test","","pass1","Test2","","");
			per2.personLoeschen("Test", "pass");
			per.persoenlicheDatenAendern(1, "Hans", "Mueller", "", "", "dd", "d");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
