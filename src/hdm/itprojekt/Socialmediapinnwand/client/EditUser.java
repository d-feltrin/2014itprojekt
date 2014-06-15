package hdm.itprojekt.Socialmediapinnwand.client;	
	 
import hdm.itprojekt.Socialmediapinnwand.client.BoardPanel.createOwnBoardByNicknamePanel;
import hdm.itprojekt.Socialmediapinnwand.client.LoginEntry.SocialmediapinnwandEditor;
import hdm.itprojekt.Socialmediapinnwand.client.LoginPanels.LoginDasboard;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
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

	public class EditUser extends VerticalPanel {
 
		//GUI-Elemente für das Ändern der Account-Daten
		private final Button saveEdit = new Button("Daten Speichern");
		
		//GUI für das Löschen
		private final Button deleteButton = new Button("Account löschen");
		private final Label deleteHeadline = new Label("Um den Account unwiderruflich zu löschen, bitte hier bestätigen:");
		
		//private final Button backBtn = new Button("zurück zum Login");
		private final TextBox editFirstname = new TextBox();
		private final TextBox editLastname = new TextBox();
		private final TextBox editNickname = new TextBox();
		private final TextBox editEmail = new TextBox();
		private final PasswordTextBox editPassword = new PasswordTextBox();
		private final VerticalPanel vertPanel1 = new VerticalPanel();
		private final VerticalPanel vertPanel2 = new VerticalPanel();
		private final VerticalPanel vertPanel3 = new VerticalPanel();
		
		//Panel 4, welches die Löschen-GUI aufnimmt
		private final HorizontalPanel horPanel4 = new HorizontalPanel();
		
		final Label CrUserHeadline = new Label("Beearbeiten oder löschen Sie Ihren Account");
	    final Image image = new Image();
 
		//Ein neues AsyncObject wird instantiiert
		private final AServiceAsync AsyncObj = GWT.create(AService.class);
		
		//Ein Objekt vom Typ User wird erstellt
		private User u;

		public EditUser() {
		}

		//Elemente/Methoden, die beim Start der Klasse erstellt werden sollen
		public void onLoad() {
			/*Style Sets*/
			CrUserHeadline.setStylePrimaryName("CrUserHeadline");
			vertPanel2.setStylePrimaryName("CrUserLoginPanel2");
			vertPanel1.setStylePrimaryName("CrUserLoginPanel1");
			//Hintergrundbild laden
			image.setUrl("http://pressespecial.de/itpimg/create-User.jpg");
			image.setPixelSize(960, 570);
			vertPanel1.add(image);			
	 
			//Hier bekommen die Textboxen einen Default-Wert, der innerhalb der Box angezeigt wird
			editFirstname.setText("lastname");
			editLastname.setText("lastname");
			editNickname.setText("Nickname");
			editEmail.setText("E-Mail Adresse");
			editPassword.setText("Passwort");			
			
			//Nickname aus dem Cookie auslesen
			final String cookieNickname = Cookies.getCookie("SessionUserNicknameEditor");
		
			//User-Objekt über Nickname-String aus Cookie aus Datenbank verlangen
		
			//Eine Flextable, die die Textboxen aufnimmt
			FlexTable editTable = new FlexTable();
			editTable.setWidget(0,0,editFirstname);
			editTable.setWidget(0,1,editLastname);
			editTable.setWidget(1,0,editNickname);
			editTable.setWidget(1,1,editEmail);
			editTable.setWidget(2,0,editPassword);
			editTable.setWidget(2,1,saveEdit);	 
				
				//Window.alert("ownBoard" + cookieNickname);
				 AsyncObj.selectUserbyNickname(cookieNickname, new AsyncCallback<User>(){
						@Override
						public void onFailure(Throwable caught) {
						}
						@Override
						public void onSuccess( User u) {
 					/*		 
							 
							Cookies.removeCookie("SessionUserNickname" );
							Cookies.removeCookie("SessionUserID" );
							Cookies.setCookie("SessionUserNickname", u.getNickname());
							Cookies.setCookie("SessionUserID", String.valueOf(u.getUserId()));
*/
 							final User uTemp   = u; 

							editFirstname.setText(u.getfirstname());
							editLastname.setText(u.getlastname());
							editNickname.setText(u.getNickname());
							editEmail.setText(u.getEMailAdress());
							editPassword.setText(u.getPassword() );
					 //	Window.alert(""+cookieNickname+""+u.getPassword());
							// Create Async Insert wie create Befehl
							// Dem Benutzerbutton einen ClickHandler zuordnen
							saveEdit.addClickHandler(new ClickHandler() {
								
								// Der ClickHandler erstellt ein neues User-Objekt mit
								// entsprechenden Werten aus den Widgets
								public void onClick(ClickEvent event) {
									if(editFirstname.getValue().isEmpty() ||
											editLastname.getValue().isEmpty() ||
											editNickname.getValue().isEmpty() ||
											editEmail.getValue().isEmpty() ||
											editPassword.getValue().isEmpty()) { 
										Window.alert("Bitte alle Felder ausfüllen");
									} 
											
									else {
									  final User u = new User();
														
 									u.setfirstname(editFirstname.getValue());
									u.setlastname(editLastname.getValue());
									u.setNickname(editNickname.getValue());
									u.setEMailAdress(editEmail.getValue());
									u.setPassword(editPassword.getValue());

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
												//--arraylist abfrage alle Nicknames außer meinen 
												// Cookies 
																						
												Window.alert("Der Nickname ist bereits vorhanden");
											}else if(result==false){
					 									
											 Window.alert("Nicknameeeee  "+ u.getNickname() );
												
											AsyncObj.updateUser(u, new AsyncCallback<Void>() {
												@Override
												// Anzeige bei fehlerhaftem insert-Befehl
												public void onFailure(Throwable caught) {

												}

												@Override
												// Anzeige bei erfolgreichem insert-Befehl
												public void onSuccess(Void result) {
													
												
													// Fehler U THEMP IST LEER 
										//			Cookies.setCookie("SessionUserNicknameEditor",
											//				u.getNickname());
													 												
												Window.alert("hallop");
 													RootPanel.get("content_wrap").clear();
 													RootPanel.get("head_wrap_right").clear();

														//Was muss ich hier reinschreiben, wenn ich mich anschließend nicht einloggen will, sondern zurück auf meine Pinnwand möchte?
 													LoginEntry a = new LoginEntry();
 													SocialmediapinnwandEditor b = a.new SocialmediapinnwandEditor(); 
													RootPanel.get("content_wrap").add(b);
		
												}
											});
											 		
											}
											else{Window.alert("Fehler 2");}
								
										}
									});
											
								}
								}
							});   
							 						
							deleteButton.addClickHandler(new ClickHandler() {
								
								public void onClick(ClickEvent event) {
									final Integer cookieNicknameId =  Integer.parseInt(Cookies.getCookie("SessionUserIDEditor"));
									   User ua = new User();
									   ua.setId(cookieNicknameId);
										ua.setfirstname(editFirstname.getValue());
										ua.setfirstname(editFirstname.getValue());
										ua.setlastname(editLastname.getValue());
										ua.setNickname(editNickname.getValue());
										ua.setEMailAdress(editEmail.getValue());
										ua.setPassword(editPassword.getValue());
									
									 AsyncObj.deleteUser(ua, new AsyncCallback<Void>(){
											@Override
											public void onFailure(Throwable caught) {
											}
											@Override
											public void onSuccess( Void Result) {
											
												Window.alert("Der Benutzer wurde gelöscht");

												// Remove Cookies
												Cookies.removeCookie("SessionUserNicknameReport");
												Cookies.removeCookie("SessionUserIdEditor");
												LoginPanels a = new LoginPanels();
												LoginDasboard b = a.new LoginDasboard(); 
												RootPanel.get("content_wrap").add(b);
									 						 
									 }});	
																			
								}
								
							});
											
						}
					 });
					
	/*		//Eine Instanz der Klasse EditUser wird erstellt und dem RootPanel über das content_wrap zugeordnet
			EditUser editUser = new EditUser();
			RootPanel.get("content_wrap").add(editUser);
			saveEdit.setStylePrimaryName("saveButton");			
			*/
				 	
					//GUI-Elemente für das Löschen eines Accounts zuordnen
					horPanel4.add(deleteHeadline);
					horPanel4.add(deleteButton);
					
					//Panel 2 die Beschriftung (Label) und die Tabelle zuordnen
					vertPanel2.add(CrUserHeadline);
					vertPanel2.add(editTable);
					
					//Panel 3 das Panel 1 und Panel 2 zuordnen
					 vertPanel3.add(vertPanel1);
					 vertPanel3.add(vertPanel2);
					 vertPanel3.add(horPanel4);
					//Den content_wrap und das head_wrap_right clearen
					//Zusätzlich dem content_wrap das Panel 3 und den Zurück-Button zuordnen
 					this.add(vertPanel3);
			 		//RootPanel.get("head_wrap_right").clear();
					//RootPanel.get("head_wrap_right").add(backBtn);
					 			
					/*Style Sets*/
					vertPanel3.setStylePrimaryName("content_wrap");
					saveEdit.setStylePrimaryName("registerButton");
			
				}
		
}