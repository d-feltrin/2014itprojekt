package hdm.itprojekt.Socialmediapinnwand.server.db;

import java.sql.*;
import com.google.appengine.api.rdbms.AppEngineDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class DBConnection.
 */
public class DBConnection {
		
	/** The con. */
	private static Connection con = null;

	/**
	 * Connection.
	 *
	 * @return the connection
	 */
	public static Connection connection() {
		
		//Falls die DB-Connection noch nicht besteht, f�hre nachfolgende Befehle aus
		if (con == null) {
			
			//Der Treiber f�r die DB-Verbindung wird erstellt
			 
			try {
				DriverManager.registerDriver(new AppEngineDriver());
			   con = DriverManager.getConnection("jdbc:mysql://81.169.219.51:3306/it_projekt_bj2", "it_projekt_bj2", "it_projekt_bj2");
				//con = DriverManager.getConnection("jdbc:google:rdbms://sm4shdm:hdmit3/sm4s", "sm4s", "root");
				
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