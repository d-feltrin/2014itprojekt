package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.client.LoginPanels.LoginDasboard;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CreateUser extends VerticalPanel {

	// Definieren von ben�tigten Widgets
	private final Button userRegister = new Button("Registrieren");
	private final TextBox userfirstname = new TextBox();
 
	private final TextBox userlastname = new TextBox();
	private final TextBox userNickname = new TextBox();
	private final TextBox userEmail = new TextBox();
	private final TextBox userPassword = new PasswordTextBox();
	private final Button backBtn = new Button("zurück zum Login");
	private final VerticalPanel vertPanel1 = new VerticalPanel();
	private final VerticalPanel vertPanel2 = new VerticalPanel();
	private final VerticalPanel vertPanel3 = new VerticalPanel();
	final Label CrUserHeadline = new Label("Regestrieren Sie sich als neuer User ");
    final Image image = new Image();

	// Wie kann man das hier bezeichnen?
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
private  User  u = new User ();

	public CreateUser() {
	}

	public void onLoad() {
		/*Style Sets*/
		super.onLoad();
		CrUserHeadline.setStylePrimaryName("CrUserHeadline");
 
		backBtn.setStylePrimaryName("BackLoginButton1");
		vertPanel2.setStylePrimaryName("CrUserLoginPanel2");
		vertPanel1.setStylePrimaryName("CrUserLoginPanel1");

		image.setUrl("http://pressespecial.de/itpimg/create-User.jpg");
		image.setPixelSize(960, 570);
		
		vertPanel1.add(image);
		
		// Widgets mit vordefiniertem Text bef�llen
		userfirstname.setText("firstname");
	 
		userlastname.setText("lastname");
		userNickname.setText("Nickname");
		userEmail.setText("E-Mail Adresse");
		userPassword.setText("Passwort");
		
		FlexTable fT = new FlexTable();
		fT.setWidget(0,0,userfirstname);
		fT.setWidget(0,1,userlastname);
		fT.setWidget(1,0,userNickname);
		fT.setWidget(1,1,userEmail);
		fT.setWidget(2,0,userPassword);
		fT.setWidget(2,1,userRegister);
 		
		// Widgets dem Panel zuordnen
		/*
		vertPanel2.add(userfirstname);
		vertPanel2.add(userlastname);
		vertPanel2.add(userNickname);
		vertPanel2.add(userEmail);
		vertPanel2.add(userPassword);
		vertPanel2.add(userRegister);*/
		vertPanel2.add(CrUserHeadline);
		vertPanel2.add(fT);
		
		vertPanel3.add(vertPanel1);
		vertPanel3.add(vertPanel2);
		// Dem RootPanel ein Panel und einen Button zuordnen
		// (Muss noch angepasst werden, da wir am Schluss noch mehr Funktionen
		// haben)
		 
		this.add(vertPanel3);
 		RootPanel.get("head_wrap_right").clear();
		RootPanel.get("head_wrap_right").add(backBtn);
		//  ?
		//vertPanel.setStylePrimaryName("content_wrap");
		userRegister.setStylePrimaryName("registerButton");
 		
		backBtn.addClickHandler(new ClickHandler() {
			//  ?
			//  ?
			public void onClick(ClickEvent event) {

				RootPanel.get("head_wrap_middle").clear();
				RootPanel.get("content_wrap").clear();
				LoginPanels a = new LoginPanels();
				LoginDasboard b = a.new LoginDasboard(); 
				RootPanel.get("head_wrap_middle").add(b);
				 
			}
			});
		
		// Dem Benutzerbutton einen ClickHandler zuordnen
		userRegister.addClickHandler(new ClickHandler() {
			
			// Der ClickHandler erstellt ein neues User-Objekt mit
			// entsprechenden Werten aus den Widgets
			public void onClick(ClickEvent event) {
				if(userfirstname.getValue().isEmpty() ||
						userlastname.getValue().isEmpty() ||
						userNickname.getValue().isEmpty() ||
						userEmail.getValue().isEmpty() ||
						userPassword.getValue().isEmpty()) { 
					Window.alert("Bitte Felder ausfüllen");
				} 
				else {
			
				u.setfirstname(userfirstname.getValue());
				u.setlastname(userlastname.getValue());
				u.setNickname(userNickname.getValue());
				u.setEMailAdress(userEmail.getValue());
				u.setPassword(userPassword.getValue());

				// Implementierung der Asynchronit�t des Callbacks f�r den
				// insert-Befehl
							
				AsyncObj.checkUserDuplicate(u, new AsyncCallback<Boolean>() {
					@Override
					// Anzeige bei fehlerhaftem insert-Befehl
					public void onFailure(Throwable caught) {

					}

					@Override
					// Anzeige bei erfolgreichem insert-Befehl
					public void onSuccess(Boolean result) {
					 
						if(result==true){
							
							Window.alert("Der Nickname ist bereits vorhanden");
						}else if(result==false){
 
						AsyncObj.insertUser(u, new AsyncCallback<Void>() {
							@Override
							// Anzeige bei fehlerhaftem insert-Befehl
							public void onFailure(Throwable caught) {

							}

							@Override
							// Anzeige bei erfolgreichem insert-Befehl
							public void onSuccess(Void result) {
								Window.alert("Benutzer erfolgreich registriert");
								RootPanel.get("head_wrap_middle").clear();
								RootPanel.get("content_wrap").clear();
								LoginPanels a = new LoginPanels();
								LoginDasboard b = a.new LoginDasboard(); 
								RootPanel.get("content_wrap").add(b);

							}
						});
						
						}
						else{Window.alert("aaaaaaaaaaasdasdsa");}
			
					}
				});
	
			}
			}
		});
	}
}