package hdm.itprojekt.Socialmediapinnwand.client;

import java.util.ArrayList;
import com.google.gwt.user.client.rpc.AsyncCallback;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.*;

public interface AServiceAsync {

	void insertUser(User u, AsyncCallback<Void> callback);
	
	void insertPost(Post p, int userPostId, AsyncCallback<Void> callback);

	void getAllUsers(AsyncCallback<ArrayList<User>> callback)
			throws IllegalArgumentException;

	void checkLogin(String nicknameBoxUser, String pwBoxUser,
			AsyncCallback<User> asyncCallback);
	
	
}
