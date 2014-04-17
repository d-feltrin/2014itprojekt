package hdm.itprojekt.Socialmediapinnwand.server.db;

import java.sql.*;
import com.google.appengine.api.rdbms.AppEngineDriver;

public class DBConnection {
		
		private static Connection con = null;

		public static Connection connection() {
			if (con == null) { // If on init no connection established, create one
				try {
					DriverManager.registerDriver(new AppEngineDriver()); // Create driver from GWT-Package
					
					con = DriverManager.getConnection("jdbc:mysql://85.214.149.12:3306/sm4s", "sm4s", "blablubb");
					//con = DriverManager.getConnection("jdbc:google:rdbms://hdm1337:hdmsql/hotelverwaltung", "root", ""); // Create connection with user-credentials
				} 
				catch (SQLException e1) { // If an exception appears, ...
					con = null; // Leave "con" null
				
					e1.printStackTrace();
				}
			}

			return con; // If connection was created successfully, return the database-connection
		}
}
