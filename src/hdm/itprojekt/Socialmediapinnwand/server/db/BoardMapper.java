package hdm.itprojekt.Socialmediapinnwand.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import hdm.itprojekt.Socialmediapinnwand.server.db.DBConnection;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.google.gwt.user.client.Window;

// TODO: Auto-generated Javadoc
/**
 * The Class BoardMapper.
 */
public class BoardMapper {
	
	/** The board mapper. */
	private static BoardMapper boardMapper = null;
	
	/** The con. */
	public Connection con = DBConnection.connection();

	/**
	 * Instantiates a new board mapper.
	 */
	protected BoardMapper() {
	}

	/**
	 * Board mapper.
	 *
	 * @return the board mapper
	 */
	public static BoardMapper boardMapper() {
		if (boardMapper == null) {
			boardMapper = new BoardMapper();
		}
		return boardMapper;
	}
	
	/**
	 * Delete subscriber informations.
	 *
	 * @param id the id
	 */
	public void deleteSubscriberInformations(int id) {
		Connection con = DBConnection.connection();
 		try {
			Statement state = con.createStatement();
			  state.executeUpdate("DELETE   FROM `Subscription` WHERE `to_user_id` = " + id +";" );
	 		}
		  catch (SQLException e) {
			e.printStackTrace();
		}
 	}
	
	/**
	 * Gets the one user id by id.
	 *
	 * @param id the id
	 * @return the one user id by id
	 */
	public  ArrayList<User> getOneUserIdByID  (int id) {

		Connection con = DBConnection.connection();
		ArrayList<User> resultList = new ArrayList<>();
		try {
			Statement state = con.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM `User`  WHERE `id` = "  + id + ";");
	 
			while (result.next()) {
				User u = new User(); // Create new person-object to fill
				u.setUserId(result.getInt("id"));
				u.setNickname(result.getString("nickname"));
				resultList.add(u); // Add person-object to Arraylist
			}
	 
			//state.executeUpdate(sqlquery);
			//Window.alert(""+ sqlquery);	

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resultList;
	}
	
	/**
	 * Creates the subscriber informations.
	 *
	 * @param id the id
	 * @return the array list
	 */
	public ArrayList<User> createSubscriberInformations(int id) {
		Connection con = DBConnection.connection();
		ArrayList<User> resultUserList = new ArrayList<>();
	 
	//	int tempid = id; 
		try {
			Statement state = con.createStatement();
			ResultSet result = state.executeQuery("SELECT  `to_user_id`  FROM `Subscription` WHERE `from_user_id`  = " + 6 +";"); 

			 /* `user_id`*/
			
			while (result.next()) {
				User u = new User();						 
  	 			u.setUserId(result.getInt("to_user_id"));
  				resultUserList.add( u);
 					  
 				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return resultUserList;
	}
}