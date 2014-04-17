package hdm.itprojekt.Socialmediapinnwand.server.db;

import java.sql.Connection;
import java.sql.Statement;



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
}