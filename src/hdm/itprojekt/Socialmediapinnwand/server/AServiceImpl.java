package hdm.itprojekt.Socialmediapinnwand.server;

import java.util.ArrayList;

import hdm.itprojekt.Socialmediapinnwand.client.AService;
import hdm.itprojekt.Socialmediapinnwand.server.db.*;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Post;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class AServiceImpl extends RemoteServiceServlet implements AService {

	private UserMapper uMapper = null;
	private PostMapper pMapper = null;
	private LoginMapper lMapper = null;

	/**
	 * Initialize all database-mapper and extends service-servlet
	 */
	public void init() throws IllegalArgumentException {
		this.uMapper = UserMapper.userMapper();
		this.pMapper = PostMapper.postMapper();
		this.lMapper = LoginMapper.loginMapper();

	}

	private static final long serialVersionUID = 1L;

	public void insertUser(User u) {
		init();
		uMapper.insertUser(u);
	}

	@Override
	public void insertPost(Post p, int userPostId) {
		init();
		System.out.println("insertPost in Imple... p: "+p+" userPostid: "+userPostId);
		pMapper.insertPost(p, userPostId);

	}

	@Override
	public ArrayList<User> getAllUsers() throws IllegalArgumentException {
		init();
		ArrayList<User> listit = uMapper.getAllUsers();
		if (!listit.isEmpty()) {
			return listit;
		} else {
			return null;
		}
	}

	public User checkLogin(String nicknameBoxUser, String pwBoxUser) {
		init();
		User u = new User();
		u = lMapper.checkLogin(nicknameBoxUser, pwBoxUser);

		if (u != null) {
			return u;
		} else {
			return null;
		}
	}
}
