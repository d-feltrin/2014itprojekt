package hdm.itprojekt.Socialmediapinnwand.client;

import java.util.ArrayList;
import java.util.Vector;

import com.google.gwt.user.client.rpc.RemoteService;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import hdm.itprojekt.Socialmediapinnwand.shared.bo.Comment;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Post;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Subscription;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;


@RemoteServiceRelativePath("asyncservice")
public interface AService extends RemoteService {

	void insertUser(User u);

	void insertPost(Post p, int userPostId);
	
	ArrayList<User> getAllUsers() throws IllegalArgumentException;

	User checkLogin(String nicknameBoxUser, String pwBoxUser);
	
	Vector<Post> getAllPostsByUser(int pUserId) throws IllegalArgumentException;
	
	Vector<Post> getAllPostsByUserNickname(String UserNickname) throws IllegalArgumentException;

	void addSubscribe(Subscription s);

	User getUserIdByUserNickname(User user);

	void addComment(Comment c);



	Vector<Comment> GetCommentsByPostId(Comment c);
	
}
