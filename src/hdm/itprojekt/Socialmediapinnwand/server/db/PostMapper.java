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

// TODO: Auto-generated Javadoc
/**
 * The Class PostMapper.
 */
public class PostMapper {

/** The post mapper. */
private static PostMapper postMapper = null;

/** The con. */
public Connection con = DBConnection.connection();

/**
 * Instantiates a new post mapper.
 */
protected PostMapper() {
}

/**
 * Post mapper.
 *
 * @return the post mapper
 */
public static PostMapper postMapper() {
	if (postMapper == null) {
		postMapper = new PostMapper();
	}
	return postMapper;
}

/**
 * Insert post.
 *
 * @param p the p
 */
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


		
		state.executeUpdate(sqlquery);

	} catch (Exception e) {
		e.printStackTrace();
	}
}




/**
 * Gets the all posts by date intervall.
 *
 * @param userid the userid
 * @param fromDate the from date
 * @param toDate the to date
 * @return the all posts by date intervall
 */
public ArrayList<Post> getAllPostsByDateIntervall(int userid,String fromDate,String  toDate ) {
	Connection con = DBConnection.connection();
	ArrayList<Post> resultList = new ArrayList<>();
	
	String a= "2006-05";

	String b= "2014-08";
	
	try {
		Statement state = con.createStatement();
		//ResultSet result = state.executeQuery("SELECT  *  FROM `Post` WHERE `user_id` = "+ id  ); 
 
		ResultSet result = state.executeQuery("SELECT  *  FROM `Post` WHERE `date` >= '"+ fromDate  +"' AND `date` <= '"+ toDate +"' ;"        ); 
		
		
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




 


















/**
 * Gets the report posts by user id.
 *
 * @param pUserId the user id
 * @return the report posts by user id
 */
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

/**
 * Gets the all posts objects by one user id.
 *
 * @param id the id
 * @return the all posts objects by one user id
 */
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

	/**
	 * Sets the like post iterator.
	 *
	 * @param couterlike the couterlike
	 * @param postIdTemp the post id temp
	 */
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
	
	/**
	 * Delete post by postid.
	 *
	 * @param postIdTemp the post id temp
	 */
	public void deletePostByPostid(int  postIdTemp) {
 
		Connection con = DBConnection.connection();
 	   
		try {
			Statement state = con.createStatement();
 			state.executeUpdate("DELETE   FROM `Post` WHERE `id` = '" + postIdTemp + "';" );
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
	 
	}

/**
 * Gets the all comments by one post id.
 *
 * @param postid the postid
 * @return the all comments by one post id
 */
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

/**
 * Gets the post count by user id.
 *
 * @param user_id the user_id
 * @return the post count by user id
 */
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
 
/**
 * Gets the like count by user id.
 *
 * @param user_id the user_id
 * @return the like count by user id
 */
public int getLikeCountByUserId(int user_id) {

	Connection con = DBConnection.connection();
	int postCounter = 0;
	try {
		Statement state = con.createStatement();
		ResultSet rs = state
				.executeQuery("SELECT COUNT(`like`) FROM `Post` WHERE `poster_id` = "
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

/**
 * Gets the subscriptions by user id.
 *
 * @param user_id the user_id
 * @return the subscriptions by user id
 */
public int getSubscriptionsByUserId(int user_id) {

	Connection con = DBConnection.connection();
	int postCounter = 0;
	try {
		Statement state = con.createStatement();
		ResultSet rs = state
				.executeQuery("SELECT COUNT(`id`) FROM `Subscription` WHERE `from_user_id` = "
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

/**
 * Gets the all comments count by user id.
 *
 * @param user_id the user_id
 * @return the all comments count by user id
 */
public int getAllCommentsCountByUserId(int user_id) {

	Connection con = DBConnection.connection();
	int postCounter = 0;
	try {
		Statement state = con.createStatement();
		ResultSet rs = state
				.executeQuery("SELECT COUNT(`id`) FROM `Comment` WHERE `post_id` = "
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


 




/**
 * Gets the subscription count by user id.
 *
 * @param user_id the user_id
 * @return the subscription count by user id
 */
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

/**
 * Gets the comments count by user id.
 *
 * @param user_id the user_id
 * @return the comments count by user id
 */
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

/**
 * Gets the likes count by user id.
 *
 * @param user_id the user_id
 * @return the likes count by user id
 */
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
 
 /**
  * Load post for edit.
  *
  * @param postId the post id
  * @return the post
  */
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

/**
 * Save post for edit.
 *
 * @param p the p
 */
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

/**
 * Gets the one user id by nickname mapper.
 *
 * @param selectedNickname the selected nickname
 * @return the one user id by nickname mapper
 */
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

/**
 * Gets the all posts by one user id.
 *
 * @param user_id the user_id
 * @return the all posts by one user id
 */
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
/**
 * Creates the board by user id.
 *
 * @param userID the user id
 */
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