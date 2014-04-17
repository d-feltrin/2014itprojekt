package hdm.itprojekt.Socialmediapinnwand.server;

import hdm.itprojekt.Socialmediapinnwand.server.db.UserMapper;
import hdm.itprojekt.Socialmediapinnwand.shared.AService;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;



public class AServiceImpl extends RemoteServiceServlet implements AService
{

	private UserMapper uMapper = null;

	/**
	 * Initialize all database-mapper and extends service-servlet
	 */
	public void init() throws IllegalArgumentException {
		this.uMapper = UserMapper.userMapper();

	}
	private static final long serialVersionUID = 1L;
	
	public void insertUser(User u)
	{
		init();
		uMapper.insertUser(u);
	}
}