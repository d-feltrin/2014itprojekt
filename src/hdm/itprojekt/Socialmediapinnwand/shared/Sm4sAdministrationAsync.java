package hdm.itprojekt.Socialmediapinnwand.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import de.hdm.mario.versucheins.shared.bo.User;

public interface Sm4sAdministrationAsync {

	void createUser(String firstname, AsyncCallback<User> callback);
	
}
