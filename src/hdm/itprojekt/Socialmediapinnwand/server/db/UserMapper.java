package hdm.itprojekt.Socialmediapinnwand.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;





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
		ResultSet result = state.executeQuery("SELECT * FROM User");

		while (result.next()) {
			User u = new User(); // Create new person-object to fill
										// with values from database
			u.setUserId(result.getInt("id"));
			u.setNickname(result.getString("nickname"));
			
			resultList.add(u); // Add person-object to Arraylist
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}

	return resultList;
}

public User getUserIdByUserNickname(User user) {
	Connection con = DBConnection.connection();
	User u = new User();
	try {
		
		
		Statement state = con.createStatement();		
		ResultSet rs = state.executeQuery("SELECT * FROM User WHERE nickname='"+ user.getNickname() +"'");
		
		while(rs.next()) {
		
		u.setUserId(rs.getInt("id"));
		u.setVorname(rs.getString("vorname"));
		u.setNachname(rs.getString("nachname"));
		u.setEMailAdress(rs.getString("email"));
		u.setNickname(rs.getString("nickname"));
		u.setPassword(rs.getString("password"));
		
		
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
		
	}
	return u;
	}
	
}
