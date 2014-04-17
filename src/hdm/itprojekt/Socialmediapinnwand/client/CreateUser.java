package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.shared.AService;
import hdm.itprojekt.Socialmediapinnwand.shared.AServiceAsync;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CreateUser extends VerticalPanel {
	
	private final Button userRegister = new Button("Registrieren");

	private final TextBox userVorname = new TextBox();
	private final TextBox userNachname = new TextBox();
	private final TextBox userNickname = new TextBox();
	private final TextBox userEmail = new TextBox();
	private final TextBox userPassword = new PasswordTextBox();
	
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	private User u;
	
	private final VerticalPanel vertPanel = new VerticalPanel(); 
	
	public void onLoad() {
		userVorname.setText("Vorname");
		userNachname.setText("Nachname");
		userNickname.setText("Nickname");
		userEmail.setText("E-Mail Adresse");
		userPassword.setText("Passwort");
		
		vertPanel.add(userVorname);
		vertPanel.add(userNachname);
		vertPanel.add(userNickname);
		vertPanel.add(userEmail);
		vertPanel.add(userPassword);
		
		this.add(vertPanel);
		this.add(userRegister);
		
		//Dem Benutzerbutton eine Funktion geben
		userRegister.addClickHandler(new ClickHandler() {

			  public void onClick(ClickEvent event) {
				  u = new User();
				  u.setVorname(userVorname.getValue());
				  u.setNachname(userNachname.getValue());
				  u.setNickname(userNickname.getValue());
				  u.setEMailAdress(userEmail.getValue());
				  u.setPassword(userPassword.getValue());
				  
				  AsyncObj.insertUser(u,
							new AsyncCallback<Void>() {
								@Override
								public void onFailure(Throwable caught) {
									
								}

								@Override
								public void onSuccess(Void result) {
									Window.alert("Benutzer erfolgreich registriert");

								}
						  });
								  }
						  });
	}
}
	
	
	
	
	
	//?
	//private final Sm4sAdministrationAsync ServiceObj = GWT.create(Sm4sAdministration.class);
	//private User u;
	
	
	

