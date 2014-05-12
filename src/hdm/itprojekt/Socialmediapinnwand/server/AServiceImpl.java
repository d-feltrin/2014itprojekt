package hdm.itprojekt.Socialmediapinnwand.server;

import java.util.ArrayList;

import hdm.itprojekt.Socialmediapinnwand.server.db.*;
import hdm.itprojekt.Socialmediapinnwand.shared.AService;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Post;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;



public class AServiceImpl extends RemoteServiceServlet implements AService
{

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
	
	public void insertUser(User u)
	{
		init();
		uMapper.insertUser(u);
	}

	@Override
	public void insertPost(Post p) {
		init();
		pMapper.insertPost(p);
		
	}

	@Override
	public ArrayList<User> getAllUsers() throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User checkLogin(String userNamelogin, String userPasswordLogin) {
		init();
		User u = lMapper.checkLogin(userNamelogin, userPasswordLogin);

		if (u != null) {
			return u;
		} else {
			return null;
		}
	}
	}
