package hdm.itprojekt.Socialmediapinnwand.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import hdm.itprojekt.Socialmediapinnwand.server.db.DBConnection;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.*;

public class SubscriptionMapper {
	private static SubscriptionMapper subMapper = null;
	public Connection con = DBConnection.connection();

	protected SubscriptionMapper() {
		
	}

	public static SubscriptionMapper subMapper() {
		if (subMapper == null) {
			subMapper = new SubscriptionMapper();
		}
		return subMapper;
	}

	public void insertPost(Post p, int userPostId) {
		Connection con = DBConnection.connection();
		try {
			Statement state = con.createStatement();
			String sqlquery = "INSERT INTO Post (post, user_id) VALUES (" + "'"
					+ p.getPost() + "'" + "," + userPostId + ");";
			state.executeUpdate(sqlquery);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void createSubscriptionByUserId(Subscription s) {
		Connection con = DBConnection.connection();
		try {
			Statement state = con.createStatement();
			String sqlquery = "INSERT INTO `Subscription` (from_user_id, to_user_id) VALUES ("
					+ "'" + s.getFromUser() + "'" + "," + s.getToUser() + ");";
			state.executeUpdate(sqlquery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Subscription CheckSubscription(Subscription s) {

		Subscription sp = new Subscription();
		Connection con = DBConnection.connection();
		try {
			Statement state = con.createStatement();
			ResultSet rs = state
					.executeQuery("SELECT * FROM `Subscription` WHERE `from_user_id` = '"
							+ s.getFromUser()
							+ "' AND WHERE `to_user_id`='"
							+ s.getToUser() + "';");

			while (rs.next()) {
				s.setId(rs.getInt("id"));
				s.setFromUser(rs.getInt("from_user_id"));
				s.setToUser(rs.getInt("to_user_id"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;

	}

	public ArrayList<Subscription> getAllSubscriptionsById(Subscription sub) {
		Connection con = DBConnection.connection();
		ArrayList<Subscription> result = new ArrayList<>();

		try {
			Statement state = con.createStatement();
			ResultSet rs = state
					.executeQuery("SELECT * FROM Subscription WHERE `to_user_id`='"
							+ sub.getToUser() + "';");

			while (rs.next()) {
				Subscription s = new Subscription(); // Create new person-object
														// to fill
				// with values from database
				s.setId(rs.getInt("id"));
				s.setFromUser(rs.getInt("from_user_id"));
				s.setToUser(rs.getInt("to_user_id"));
				
				System.out.println(s.getId());

				result.add(s); // Add person-object to Arraylist
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Subscription deleteSubscriptionBySubscriptionID(Subscription s) {

		Connection con = DBConnection.connection();
		try {
			Statement state = con.createStatement();
			state.executeUpdate("DELETE FROM `Subscription` WHERE `id` = '"
					+ s.getId() + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
return s;
	}


}