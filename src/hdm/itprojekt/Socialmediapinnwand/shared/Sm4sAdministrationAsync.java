package hdm.itprojekt.Socialmediapinnwand.shared;

import com.google.gwt.user.client.rpc.AsyncCallback;

import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;

public interface Sm4sAdministrationAsync {

	void createUser(
			String firstname,
			AsyncCallback<hdm.itprojekt.Socialmediapinnwand.shared.bo.User> callback);
	
}
