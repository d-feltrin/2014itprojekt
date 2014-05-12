package hdm.itprojekt.Socialmediapinnwand.shared;

import java.util.ArrayList;
import com.google.gwt.user.client.rpc.AsyncCallback;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.*;

public interface AServiceAsync {

	void insertUser(User u, AsyncCallback<Void> callback);
	
	void insertPost(Post p, AsyncCallback<Void> callback);

	void getAllUsers(AsyncCallback<ArrayList<User>> callback)
			throws IllegalArgumentException;

	void checkLogin(String userNamelogin, String userPasswordLogin,
			AsyncCallback<User> asyncCallback);
	
	
}
