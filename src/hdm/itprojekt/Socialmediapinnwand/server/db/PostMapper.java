package hdm.itprojekt.Socialmediapinnwand.server.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.sql.ResultSet;
import com.google.gwt.user.client.Window;
import hdm.itprojekt.Socialmediapinnwand.server.db.DBConnection;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.*;

public class PostMapper {
private static PostMapper postMapper = null;
public Connection con = DBConnection.connection();

protected PostMapper() {
}

public static PostMapper postMapper() {
	if (postMapper == null) {
		postMapper = new PostMapper();
	}
	return postMapper;
}

public void insertPost(Post p ) {
	Connection con = DBConnection.connection();
	try {
 		
		Statement state = con.createStatement();
		String sqlquery = "  INSERT INTO Post (message, user_id, poster_id) VALUES ("
				+ "'"
				+  p.getPost()
				+ "', '"
				+  p.getUser_id()
				+ "', '"
				+  p.getPosr_id()
				+ "') ;" ;
				
		/*
		String sqlquery = "INSERT INTO Post (message, user_id, poster_id) VALUES ("
				+ "'"
				+ p.getPost()
				+ "'" 
				+ ", '"
				+ UserId 
				+"' );";
		*/
		
		state.executeUpdate(sqlquery);

	} catch (Exception e) {
		e.printStackTrace();
	}
}

public Vector<Post> getReportPostsByUserId(int pUserId) {
	Connection con = DBConnection.connection();
	Vector<Post> result = new Vector<Post>();
	try {
		Statement state = con.createStatement();
		String sqlquery = "SELECT * FROM Post LEFT JOIN User on Post.user_id = User.id";
		ResultSet rs = state.executeQuery(sqlquery);
		
		while (rs.next()) {
			Post p = new Post(); // Create new person-object to fill
										// with values from database
			p.setId(rs.getInt("id"));
			p.setPost(rs.getString("post"));
			//p.setUsername(rs.getString("nickname"));
			
			result.addElement(p);
		}
		
	} catch (Exception e) {
		e.printStackTrace();
		
	}
	return result;
}

public ArrayList<Post> getAllPostsObjectsByOneUserId(int id) {
	Connection con = DBConnection.connection();
	ArrayList<Post> resultList = new ArrayList<>();
	
	try {
		Statement state = con.createStatement();
		//ResultSet result = state.executeQuery("SELECT  *  FROM `Post` WHERE `user_id` = "+ id  ); 
		ResultSet result = state.executeQuery("SELECT  *  FROM `Post` WHERE `user_id` = '"+ id  +"';" ); 
		
	//	"DELETE   FROM `User` WHERE `id` = '" + u.getId()+"';"
		 /* `user_id`*/
		
		while (result.next()) {
			Post u = new Post();		
			u.setPId(result.getInt("id"));
			u.setUser_id(result.getInt("user_id"));
 			u.setPosr_id(result.getInt("poster_id"));
 	 		u.setTimestamp(result.getString("date"));
			u.setPost(result.getString("message"));
			u.setLike(result.getInt("like"));
			resultList.add(u);
			//u.setlastname(result.getString("lastname"));
  			
 		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
 
	return resultList;
}

	public void setLikePostIterator(int couterlike, int  postIdTemp) {
	 
		Connection con = DBConnection.connection();

		try {
			Statement state = con.createStatement();
			String sqlquery ="UPDATE `Post` SET `like`= '"+ couterlike   +"' WHERE `id` = '" + postIdTemp+"';";
			state.executeUpdate(sqlquery);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
	}
	
	public void deletePostByPostid(int  postIdTemp) {
 
		Connection con = DBConnection.connection();
 	   
		try {
			Statement state = con.createStatement();
 			state.executeUpdate("DELETE   FROM `Post` WHERE `id` = '" + postIdTemp + "';" );
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
	}

public ArrayList<Comment> getAllCommentsByOnePostId(int postid) {
	Connection con = DBConnection.connection();
	ArrayList<Comment> resultList = new ArrayList<>();
	try {
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery("SELECT * FROM `Comment` WHERE `post_id` = '" + postid +"';" );  

		while (result.next()) {
			Comment u = new Comment();						// with values from database
			u.setId(result.getInt("id"));
			u.setPost_id(result.getInt("post_id"));
			u.setUser_id(result.getInt("user_id"));
 			u.setTimestamp(result.getString("date"));
			u.setText(result.getString("message"));
			resultList.add(u);
			//u.setlastname(result.getString("lastname"));
  			
 		}

	} catch (SQLException e) {
		e.printStackTrace();
	}

	return resultList;
}

public int getPostCountByUserId(int user_id) {

	Connection con = DBConnection.connection();
	int postCounter = 0;
	try {
		Statement state = con.createStatement();
		ResultSet rs = state
				.executeQuery("SELECT COUNT(`id`) FROM `Post` WHERE `poster_id` = "
						+ user_id); // User Npro Zeile �bergeben;
		//user_id
		while (rs.next()) {

			postCounter = rs.getInt(1);

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return postCounter;
 
}

public int getSubscriptionCountByUserId(int user_id) {

	Connection con = DBConnection.connection();
	int subCounter = 0;
	try {
		Statement state = con.createStatement();
		ResultSet rs = state
				.executeQuery("SELECT COUNT(`from_id`) FROM `Subscription` WHERE `to_id` = "
						+ user_id); // User Npro Zeile �bergeben;
		//user_id
		while (rs.next()) {

			subCounter = rs.getInt(1);

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return subCounter;
 
}

public int getCommentsCountByUserId(int user_id) {

	Connection con = DBConnection.connection();
	int subCounter = 0;
	try {
		Statement state = con.createStatement();
		ResultSet rs = state
				.executeQuery("SELECT COUNT(`from_id`) FROM `Subscription` WHERE `to_id` = "
						+ user_id); // User Npro Zeile �bergeben;
		//user_id
		while (rs.next()) {

			subCounter = rs.getInt(1);

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return subCounter;
 
}

public int getLikesCountByUserId(int user_id) {

	Connection con = DBConnection.connection();
	int subCounter = 0;
	try {
		Statement state = con.createStatement();
		ResultSet rs = state
				.executeQuery("SELECT COUNT(`from_id`) FROM `Subscription` WHERE `to_id` = "
						+ user_id); // User Npro Zeile �bergeben;
		//user_id
		while (rs.next()) {

			subCounter = rs.getInt(1);

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return subCounter;
 
}
 
 public Post loadPostForEdit (int postId) {
		
		Post p = new Post () ;
		try {
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery("SELECT * FROM `Post`  WHERE `id` ='"  + postId + "' ;");
		
		while (result.next()) {
			p.setPost(result.getString("message"));
			p.setPosr_id(result.getInt("poster_id"));
			p.setPId(result.getInt("id"));
		}
	   
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return p;
		
	}

public void savePostForEdit (Post p) {
	 
	
	int id = p.getPId();
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

public User  getOneUserIdByNicknameMapper(String selectedNickname) {
 
	Connection con = DBConnection.connection();
 	User u = new  User();
 ;
	try {
				
		Statement state = con.createStatement();
		String sqlquery = "SELECT `id` FROM `User`  WHERE `nickname` = '"  + selectedNickname + "'" ;
		ResultSet rs = state.executeQuery(sqlquery); 
		
		//user_id
	  	while (rs.next()) {
 			u.setUserId(rs.getInt("id"));
  
	 	}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return u;
 
}

public int getAllPostsByOneUserId(int user_id) {

	Connection con = DBConnection.connection();
	int subCounter = 0;
	try {
		Statement state = con.createStatement();
		ResultSet rs = state
				.executeQuery("SELECT COUNT(`user_id`) FROM `Post` WHERE `user_id`= " + user_id); // User Npro Zeile �bergeben;
 
		//user_id
		while (rs.next()) {

			subCounter = rs.getInt(1);

		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return subCounter;
 
}




// showBoardByOwnUserId - createBoardByUserID
public void createBoardByUserID(int userID){
	
	Connection con = DBConnection.connection();
	Board  a = new Board();
	try {
		Statement state = con.createStatement();
	 
		String sqlquery = "INSERT INTO Board (user_id ) VALUES (" + "'" + userID+ "') ;";
		state.executeUpdate(sqlquery);
 
	} catch (Exception e) {
		e.printStackTrace();
		}

	}

}