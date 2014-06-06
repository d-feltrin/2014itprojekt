package hdm.itprojekt.Socialmediapinnwand.server.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;



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


public void insertPost(Post p, int userPostId) {
	Connection con = DBConnection.connection();
	try {
		Statement state = con.createStatement();
		String sqlquery = "INSERT INTO Post (post, user_id) VALUES ("
				+ "'"
				+ p.getPost()
				+ "'" +
				","+userPostId+");";
		state.executeUpdate(sqlquery);

	} catch (Exception e) {
		e.printStackTrace();
	}
}

//SELECT * FROM `Post` LEFT JOIN User on Post.user_id = User.id WHERE User.id=19

public Vector<Post> getAllPostsByUser(int pUserId) {
	Connection con = DBConnection.connection();
	Vector<Post> result = new Vector<Post>();
	try {
		Statement state = con.createStatement();
		String sqlquery = "SELECT * FROM Post LEFT JOIN User on Post.user_id = User.id WHERE User.id="+pUserId;
		ResultSet rs = state.executeQuery(sqlquery);
		
		

		while (rs.next()) {
			Post p = new Post(); // Create new person-object to fill
										// with values from database
			p.setId(rs.getInt("id"));
			p.setPost(rs.getString("post"));
			
			result.addElement(p);
		}
		
		

	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
}

public Vector<Post> getAllPostsByUserNickname(String userNickname) {
	Connection con = DBConnection.connection();
	Vector<Post> result = new Vector<Post>();
	try {
		Statement state = con.createStatement();
		String sqlquery = "SELECT * FROM `User` INNER JOIN `Post` on User.id = Post.user_id WHERE User.nickname='"+userNickname+"'";
		ResultSet rs = state.executeQuery(sqlquery);
		
		

		while (rs.next()) {
			Post p = new Post(); // Create new person-object to fill
										// with values from database
			p.setId(rs.getInt("post.id"));
			p.setPost(rs.getString("post"));
			
			result.addElement(p);
		}
		
		

	} catch (Exception e) {
		e.printStackTrace();
	}
	return result;
}


}