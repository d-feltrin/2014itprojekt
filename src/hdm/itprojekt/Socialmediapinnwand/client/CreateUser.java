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
	
	//Definieren von benötigten Widgets
		private final Button userRegister = new Button("Registrieren");
		private final TextBox userVorname = new TextBox();
		private final TextBox userNachname = new TextBox();
		private final TextBox userNickname = new TextBox();
		private final TextBox userEmail = new TextBox();
		private final TextBox userPassword = new PasswordTextBox();
		
		//Wie kann man das hier bezeichnen?
		private final AServiceAsync AsyncObj = GWT.create(AService.class);
		private User u;
		
		private final VerticalPanel vertPanel = new VerticalPanel(); 
		
		public void onLoad() {
			
			//Widgets mit vordefiniertem Text befüllen
			userVorname.setText("Vorname");
			userNachname.setText("Nachname");
			userNickname.setText("Nickname");
			userEmail.setText("E-Mail Adresse");
			userPassword.setText("Passwort");
			
			//Widgets dem Panel zuordnen
			vertPanel.add(userVorname);
			vertPanel.add(userNachname);
			vertPanel.add(userNickname);
			vertPanel.add(userEmail);
			vertPanel.add(userPassword);
			
			//Dem RootPanel ein Panel und einen Button zuordnen
			//(Muss noch angepasst werden, da wir am Schluss noch mehr Funktionen haben)
			this.add(vertPanel);
			this.add(userRegister);
			
			//Dem Benutzerbutton einen ClickHandler zuordnen
			userRegister.addClickHandler(new ClickHandler() {

				//Der ClickHandler erstellt ein neues User-Objekt mit entsprechenden Werten aus den Widgets
				  public void onClick(ClickEvent event) {
					  u = new User();
					  u.setVorname(userVorname.getValue());
					  u.setNachname(userNachname.getValue());
					  u.setNickname(userNickname.getValue());
					  u.setEMailAdress(userEmail.getValue());
					  u.setPassword(userPassword.getValue());
					  
					  //Implementierung der Asynchronität des Callbacks für den insert-Befehl
					  AsyncObj.insertUser(u,
								new AsyncCallback<Void>() {
									@Override
									//Anzeige bei fehlerhaftem insert-Befehl
									public void onFailure(Throwable caught) {
										
									}

									@Override
									//Anzeige bei erfolgreichem insert-Befehl
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
		