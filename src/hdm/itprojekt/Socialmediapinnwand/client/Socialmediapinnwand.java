package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.client.CreateUser;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Socialmediapinnwand implements EntryPoint {
	
	final VerticalPanel contentPanel = new VerticalPanel();
	final Button TestButton = new Button ("Test");
	
	 
	final MenuBar 	UserMainMenu = new MenuBar();

	public void onModuleLoad() {

		//Dropdown aller vorhandenen User anzeigen
		ListBox  ListOfNicknames = new ListBox();
		ListOfNicknames.addItem("Test");
		ListOfNicknames.addItem("One");
		ListOfNicknames.addItem("Two");
		ListOfNicknames.addItem("Three");
		ListOfNicknames.setSize("500px", "35px");
		ListOfNicknames.addStyleName("mainmenu-dropdown");
		// dropdown box
		RootPanel.get("head_wrap_middle").add(ListOfNicknames);
		 
		
		// Menubar erstellen + Commandfunktion
			   Command ownWall = new Command() {
				      public void execute() {
				        Window.alert("Denise own wall jaja");
				      }
				    };
			    
			    Command editUser = new Command() {
				      public void execute() {
				        Window.alert("Denise edit USer");
				      }
				    };
				    
				    Command logout = new Command() {
					      public void execute() {
					        Window.alert("log dich ned weg");
					      }
					    };
		
				MenuBar UserMainMenuBtn = new MenuBar(true);
				
				UserMainMenuBtn.addItem("Eigene Pinnwand", ownWall);
				UserMainMenuBtn.addItem("Account bearbeiten", editUser);
				UserMainMenuBtn.addItem("Logout", logout);
				
				
				
				MenuBar UserMainMenu = new MenuBar();
				UserMainMenu.addItem("x", UserMainMenuBtn );

				RootPanel.get("head_wrap_right").add(UserMainMenu);
		 
		
		
/* Test Button
			TestButton.addClickHandler(new ClickHandler(){
				public void onClick(ClickEvent event){
							CreateUser newUser = new CreateUser();
							RootPanel.get("content_wrap_right").clear();
							RootPanel.get("content_wrap_right").add(newUser);
				}
			});

			RootPanel.get("content_wrap_right").add(contentPanel);
			RootPanel.get("content_wrap_right").add(TestButton);
			*/
		
			}
}
