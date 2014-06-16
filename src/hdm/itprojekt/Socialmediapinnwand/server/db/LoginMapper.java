package hdm.itprojekt.Socialmediapinnwand.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import hdm.itprojekt.Socialmediapinnwand.server.db.DBConnection;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.*;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginMapper.
 */
public class LoginMapper {
	
/** The login mapper. */
private static LoginMapper loginMapper = null;

/** The con. */
public Connection con = DBConnection.connection();

/**
 * Instantiates a new login mapper.
 */
protected LoginMapper() {
}

/**
 * Login mapper.
 *
 * @return the login mapper
 */
public static LoginMapper loginMapper() {
	if (loginMapper == null) {
		loginMapper = new LoginMapper();
	}
	return loginMapper;
}

/**
 * Check login.
 *
 * @param nicknameBoxUser the nickname box user
 * @param pwBoxUser the pw box user
 * @return the user
 */
public User checkLogin (String nicknameBoxUser, String pwBoxUser) {
	Connection con = DBConnection.connection();
	User u = new User();
	try {
		
		Statement state = con.createStatement();		
		ResultSet rs = state.executeQuery("SELECT * FROM User WHERE nickname='"+ nicknameBoxUser +"' AND password='"+pwBoxUser+"'");
		
		while(rs.next()) {
		
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