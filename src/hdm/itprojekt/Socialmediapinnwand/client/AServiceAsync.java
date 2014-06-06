package hdm.itprojekt.Socialmediapinnwand.client;

import java.util.ArrayList;
import java.util.Vector;

import com.google.gwt.user.client.rpc.AsyncCallback;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.*;

public interface AServiceAsync {

	void insertUser(User u, AsyncCallback<Void> callback);
	
	void insertPost(Post p, int userPostId, AsyncCallback<Void> callback);

	void getAllUsers(AsyncCallback<ArrayList<User>> callback)
			throws IllegalArgumentException;

	void checkLogin(String nicknameBoxUser, String pwBoxUser,
			AsyncCallback<User> asyncCallback);

	void getAllPostsByUser(int pUserId, AsyncCallback<Vector<Post>> callback);

	void getAllPostsByUserNickname(String UserNickname,
			AsyncCallback<Vector<Post>> callback);

	void addSubscribe(Subscription s, AsyncCallback<Void> callback);

	void getUserIdByUserNickname(User user,
			AsyncCallback<User> asyncCallback);

	void addComment(Comment c, AsyncCallback<Void> callback);

	

	void GetCommentsByPostId(Comment c,
			AsyncCallback<Vector<Comment>> asyncCallback);
	
	
}
