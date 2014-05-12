package hdm.itprojekt.Socialmediapinnwand.server.db;

import java.sql.Connection;
import java.sql.Statement;



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


public void insertPost(Post p) {
	Connection con = DBConnection.connection();
	try {
		Statement state = con.createStatement();
		String sqlquery = "INSERT INTO Post (post) VALUES ("
				+ "'"
				+ p.getPost()
				+ "') ;";
		state.executeUpdate(sqlquery);

	} catch (Exception e) {
		e.printStackTrace();
	}
}


}