package hdm.itprojekt.Socialmediapinnwand.shared;

import com.google.gwt.user.client.rpc.RemoteService;
import de.hdm.mario.versucheins.shared.bo.User;

public interface Sm4sAdministration extends RemoteService {

	public User createUser (String firstname)
		throws IllegalArgumentException;
	
}
