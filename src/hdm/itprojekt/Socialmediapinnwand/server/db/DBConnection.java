package hdm.itprojekt.Socialmediapinnwand.server.db;

import java.sql.*;
import com.google.appengine.api.rdbms.AppEngineDriver;

public class DBConnection {
		
	private static Connection con = null;

	public static Connection connection() {
		
		//Falls die DB-Connection noch nicht besteht, f�hre nachfolgende Befehle aus
		if (con == null) {
			
			//Der Treiber f�r die DB-Verbindung wird erstellt
			//(Wieso wird jedesmal ein neuer Treiber erstellt? Muss doch eigentlich nur darauf
			//referenzieren oder?)
			try {
				DriverManager.registerDriver(new AppEngineDriver());
				//-1- con = DriverManager.getConnection("jdbc:mysql://85.214.149.12:3306/sm4s", "sm4s", "blablubb");
				//-2- con = DriverManager.getConnection("jdbc:mysql://85.214.149.12:3306/sm4sbjfuckingversion", "sm4sbjfuckingver", "sm4sbjfuckingver");
				
				 con = DriverManager.getConnection("jdbc:mysql://81.169.219.51:3306/itprojekt_bj", "itprojekt_bj", "itprojekt_bj");
				//con = DriverManager.getConnection("jdbc:google:rdbms://sm4shdm:hdmit3/sm4s", "sm4s", "root");
				
				//con = DriverManager.getConnection("jdbc:google:rdbms://hdm1337:hdmsql/hotelverwaltung", "root", ""); // Create connection with user-credentials
			} 
			
			//Bei fehlerhafter Verbindung wird keine Verbindung aufgebaut (con=null)
			catch (SQLException e1) {
				con = null;
			
				e1.printStackTrace();
			}
		}
		
		//Bei erfolgreicher Verbindung wird die Connection zur�ckgegeben
		return con;
	}
}