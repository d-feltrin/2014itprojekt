package hdm.itprojekt.Socialmediapinnwand.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;

public interface AServiceAsync {

	void insertUser(User u, AsyncCallback<Void> callback);
	
}
