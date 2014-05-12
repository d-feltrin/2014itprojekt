package hdm.itprojekt.Socialmediapinnwand.shared;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import hdm.itprojekt.Socialmediapinnwand.shared.bo.Post;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;


@RemoteServiceRelativePath("asyncservice")
public interface AService extends RemoteService {

	void insertUser(User u);

	void insertPost(Post p);
	
	ArrayList<User> getAllUsers() throws IllegalArgumentException;

	User checkLogin(String userNamelogin, String userPasswordLogin);
	
}
