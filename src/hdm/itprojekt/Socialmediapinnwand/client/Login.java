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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;



public class Login extends HorizontalPanel  {
  
 private final AServiceAsync AsyncObj = GWT.create(AService.class);


	
  private final HorizontalPanel loginBox = new HorizontalPanel();
  
  public void onLoad()  {
  
  final TextBox nicknameBox = new TextBox();
  final PasswordTextBox pwBox = new PasswordTextBox();
  ListBox  ListOfSystems = new ListBox();
  ListOfSystems.addItem("Editor");
  ListOfSystems.addItem("Login");
 // ListOfSystems.setSize("70px", "35px");
  Button editorLogin = new Button("Login");
 
  loginBox.add(nicknameBox);
  loginBox.add(pwBox);
 
  loginBox.add(ListOfSystems);
  loginBox.add(editorLogin);
  
	this.add(loginBox);

	
	
	editorLogin.addClickHandler(new ClickHandler() {

		 public void onClick(ClickEvent event) {
			 
			       AsyncObj.checkLogin(nicknameBox.getValue(), pwBox.getValue(),
		    		   new AsyncCallback<User>() {
							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Fehler");
							}
 

							@Override
							public void onSuccess(User result) {
								
								if (result.getUserId() != 0) {
									Window.alert("FUT");
								}
					 
								 
								
							}
					  });
			  
							  }
					  });
}
 
}


 
	
	
	
	
	 
 
	
   


