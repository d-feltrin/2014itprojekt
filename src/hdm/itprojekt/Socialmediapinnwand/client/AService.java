package hdm.itprojekt.Socialmediapinnwand.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import hdm.itprojekt.Socialmediapinnwand.shared.bo.Post;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;


@RemoteServiceRelativePath("asyncservice")
public interface AService extends RemoteService {

	void insertUser(User u);

	void insertPost(Post p, int userPostId);
	
	ArrayList<User> getAllUsers() throws IllegalArgumentException;

	User checkLogin(String nicknameBoxUser, String pwBoxUser);
	
}
