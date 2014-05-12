package hdm.itprojekt.Socialmediapinnwand.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;





import hdm.itprojekt.Socialmediapinnwand.server.db.DBConnection;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.*;

public class UserMapper {
private static UserMapper userMapper = null;
public Connection con = DBConnection.connection();

protected UserMapper() {
}

public static UserMapper userMapper() {
	if (userMapper == null) {
		userMapper = new UserMapper();
	}
	return userMapper;
}


public void insertUser(User u) {
	Connection con = DBConnection.connection();
	try {
		Statement state = con.createStatement();
		String sqlquery = "INSERT INTO User (vorname, nachname, nickname, email, password) VALUES ("
				+ "'"
				+ u.getVorname()
				+ "','"
				+ u.getNachname()
				+ "','"
				+ u.getNickname()
				+ "', '"
				+ u.getEMailAdress()
				+ "','"
				+ u.getPassword() +
				"') ;";
		state.executeUpdate(sqlquery);

	} catch (Exception e) {
		e.printStackTrace();
	}
}
public ArrayList<User> getAllUsers() {
	Connection con = DBConnection.connection();
	ArrayList<User> resultList = new ArrayList<>();

	try {
		Statement state = con.createStatement();
		ResultSet ergebnis = state.executeQuery("SELECT * FROM User");

		while (ergebnis.next()) {
			User u = new User(); // Create new person-object to fill
										// with values from database
			u.setDozentID(ergebnis.getInt("DozentID"));
			u.setVorname(ergebnis.getString("Vorname"));
			u.setNachname(ergebnis.getString("Nachname"));
			resultList.add(u); // Add person-object to Arraylist
		}

	} catch (Exception e) {
		e.printStackTrace();
	}

	return resultList;
}
}