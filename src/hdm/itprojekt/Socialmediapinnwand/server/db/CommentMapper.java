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

public class CommentMapper {
	
	private static CommentMapper commentMapper = null;
	public Connection con = DBConnection.connection();

	protected CommentMapper() {
	}

	public static CommentMapper commentMapper() {
		if (commentMapper == null) {
			commentMapper = new CommentMapper();
		}
		return commentMapper;
	}
	
	
	
	
 
	public void savePostForEdit (Post p) {
		 
		
		int id = p.getId();
		 String ad = p.getPost() ;
		try {
		Statement state = con.createStatement();
		//ResultSet result = state.executeQuery("SELECT * FROM `Post`  WHERE `id` ='"  + id + "' ;");
		
				
		String sqlquery ="UPDATE `Post` SET `message`= '" + ad + "' " +  "WHERE `id` = '" + id+"';";
	 
				state.executeUpdate(sqlquery );
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
	

	
	public void saveCommentsForEdit (Comment c  ) {
		 
		
		int id = c.getId();
		 String ad = c.getText() ;
		 String ad2 = "FRIKADELLLE" ;
		try {
		Statement state = con.createStatement();
		//ResultSet result = state.executeQuery("SELECT * FROM `Post`  WHERE `id` ='"  + id + "' ;");
		
				
		String sqlquery ="UPDATE `Comment` SET `message`= '" + ad + "' " +  "WHERE `id` = '" + id+"';";
	 
				state.executeUpdate(sqlquery );
		
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}	
	
	
	
	 
	
 public Comment loadCommentsForEdit (int commentId) {
		
	 Comment c = new Comment(); 
		try {
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery("SELECT * FROM `Comment`  WHERE `id` ='"  + commentId + "' ;");
		
		while (result.next()) {
			c.setText(result.getString("message"));
			c.setPost_id(result.getInt("poster_id"));
			c.setId(result.getInt("id"));
			c.setUser_id(result.getInt("user_id"));
		}
	   
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return c;
		
	}
	
	public void deleteCommentsByCommentID(int commentId  ) {
		
		Connection con = DBConnection.connection();
	 	   
		try {
			Statement state = con.createStatement();
 			state.executeUpdate("DELETE  FROM `Comment` WHERE `id` = '" + commentId + "';" );
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void createCommentByPostID (Comment c){
		Connection con = DBConnection.connection();

		try {
			Statement state = con.createStatement();
		 
			String sqlquery = "INSERT INTO Comment ( message, post_id, user_id) VALUES ("
					+ "'"
					+ c.getText()
					+ "', '"
					+ c.getPost_id()
					+ "','"
					+ c.getUser_id() +
					"') ;";
			state.executeUpdate(sqlquery);
	 
		} catch (Exception e) {
			e.printStackTrace();
			}

		}
		
}