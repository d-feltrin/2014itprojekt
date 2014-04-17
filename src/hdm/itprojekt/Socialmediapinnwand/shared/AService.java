package hdm.itprojekt.Socialmediapinnwand.shared;

import com.google.gwt.user.client.rpc.RemoteService;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;


@RemoteServiceRelativePath("asyncservice")
public interface AService extends RemoteService {

	void insertUser(User u);
	
}
