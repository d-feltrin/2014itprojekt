package hdm.itprojekt.Socialmediapinnwand.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import hdm.itprojekt.Socialmediapinnwand.server.db.DBConnection;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.*;

public class LoginMapper {
	
private static LoginMapper loginMapper = null;
public Connection con = DBConnection.connection();

protected LoginMapper() {
}

public static LoginMapper loginMapper() {
	if (loginMapper == null) {
		loginMapper = new LoginMapper();
	}
	return loginMapper;
}

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