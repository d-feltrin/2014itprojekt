package hdm.itprojekt.Socialmediapinnwand.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.google.gwt.user.client.Window;
import hdm.itprojekt.Socialmediapinnwand.server.db.DBConnection;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.*;

// TODO: Auto-generated Javadoc
/**
 * The Class UserMapper.
 */
public class UserMapper {

/** The user mapper. */
private static UserMapper userMapper = null;

/** The con. */
public Connection con = DBConnection.connection();

/**
 * Instantiates a new user mapper.
 */
protected UserMapper() {
}

/**
 * User mapper.
 *
 * @return the user mapper
 */
public static UserMapper userMapper() {
	if (userMapper == null) {
		userMapper = new UserMapper(); 
	}
	return userMapper;
}

/**
 * Insert user.
 *
 * @param u the u
 */
public void insertUser(User u) {
	Connection con = DBConnection.connection();
	try {
		Statement state = con.createStatement();
		String sqlquery = "INSERT INTO User (firstname, lastname, nickname, email, password) VALUES ("
				+ "'"
				+ u.getfirstname()
				+ "','"
				+ u.getlastname()
				+ "','"
				+ u.getNickname()
				+ "', '"
				+ u.getEMailAdress()
				+ "','"
				+ u.getPassword() +
				"') ;";
		state.executeUpdate(sqlquery);
		//Window.alert(""+ sqlquery);
 

	} catch (Exception e) {
		e.printStackTrace();
	}
}

/**
 * Update user.
 *
 * @param u the u
 */
public void updateUser(User u) {
	
	Connection con = DBConnection.connection();
	try {
		Statement state = con.createStatement();
		
		String sqlquery ="UPDATE `User` SET `firstname`= '" +
		u.getfirstname() + "', " +
		"`lastname`= '" +
		u.getlastname() + "', " +
	    "`nickname`= '" + 
		u.getNickname() + "', "  + 
	    "`email`= '" +
		u.getEMailAdress() + "', "  + 
	    "`password`= '" +
		u.getPassword() +  "' " +
	    "WHERE `nickname` = '" + u.getNickname()+"';";
		
		state.executeUpdate(sqlquery );
 
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}

/**
 * Check user duplicate.
 *
 * @param u the u
 * @return the boolean
 */
public Boolean checkUserDuplicate(User u) {
	Connection con = DBConnection.connection();
	Boolean  result = false;

	try {
		Statement state = con.createStatement();
		ResultSet rs = state
				.executeQuery("SELECT `nickname` FROM `User`  WHERE `nickname` = '"  + u.getNickname() + "';");
		while (rs.next()) {
				int i =1;
				if(rs.getString(i).toUpperCase().equals(u.getNickname().toUpperCase())){
				result = true;	
 				} 
					i++;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
}

/**
 * Gets the all users.
 *
 * @return the all users
 */
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

/**
 * Gets the all posts by one user id.
 *
 * @param selectedNickname2 the selected nickname2
 * @return the all posts by one user id
 */
public User getAllPostsByOneUserId(String selectedNickname2) {
	Connection con = DBConnection.connection();
	User u = new User(); // Cr
	try {
		Statement state = con.createStatement();
		 ResultSet result = state.executeQuery("SELECT * FROM `User`  WHERE `nickname` = '" + selectedNickname2  + "';");
 
		while (result.next()) {
 										// with values from database
			u.setUserId(result.getInt("id"));
			u.setNickname(result.getString("nickname"));
			u.setfirstname(result.getString("firstname"));
			u.setlastname(result.getString("lastname"));
			u.setEMailAdress(result.getString("email"));
			u.setPassword(result.getString("password"));
 		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return u;
}

/**
 * Delete user.
 *
 * @param u the u
 */
public void deleteUser(User u) {
	//Hier Methode, um einen User zu löschen
	Connection con = DBConnection.connection();
	try {
		Statement state = con.createStatement();
		state.executeUpdate("DELETE   FROM `User` WHERE `id` = '" + u.getId()+"';" );
 

	} catch (Exception e) {
		e.printStackTrace();
	}
}

/**
 * Gets the one nickname from user id.
 *
 * @param authorID the author id
 * @return the one nickname from user id
 */
public User getOneNicknameFromUserId (int authorID) {
	
	User u = new User () ;
	try {
	Statement state = con.createStatement();
	ResultSet result = state.executeQuery("SELECT `nickname` FROM `User`  WHERE `id` ='"  + authorID + "' ;");
	
	while (result.next()) {
		u.setNickname(result.getString("nickname"));
	}
   
			//u= result.getString("nickname") ;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	return u;
	
}

/**
 * Gets the user id by user nickname.
 *
 * @param user the user
 * @return the user id by user nickname
 */
public User getUserIdByUserNickname(User user) {
	Connection con = DBConnection.connection();
	User u = new User();
	try {

		Statement state = con.createStatement();
		ResultSet rs = state
				.executeQuery("SELECT * FROM User WHERE nickname='"
						+ user.getNickname() + "'");

		while (rs.next()) {

			u.setUserId(rs.getInt("id"));
			u.setfirstname(rs.getString("firstname"));
			u.setlastname(rs.getString("lastname"));
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