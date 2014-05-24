package hdm.itprojekt.Socialmediapinnwand.client;

import java.util.ArrayList;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;

public class Socialmediapinnwand_entry extends AbsolutePanel {
	private User user = new User();
	final VerticalPanel contentPanel = new VerticalPanel();
	final Button TestButton = new Button("Test");
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	final ListBox ListOfNicknames = new ListBox();
	
	//Cookies.setCookie("SM4S",result.getNickname());
	Label NicknameLabel = new Label ("Hier Nickname");

	final MenuBar UserMainMenu = new MenuBar();

	public Socialmediapinnwand_entry() {
	}

	public void setUserObject(User user) {
		this.user = user;
	}

	void loadUsers() {
		// Dropdown aller vorhandenen User anzeigen
		ListOfNicknames.addItem("User auswählen");
		ListOfNicknames.setSize("500px", "35px");
		ListOfNicknames.addStyleName("mainmenu-dropdown");

		// Dropdown dem RootPanel zuordnen
		RootPanel.get("head_wrap_middle").add(ListOfNicknames);

		AsyncObj.getAllUsers(new AsyncCallback<ArrayList<User>>() {

			@Override
			public void onSuccess(ArrayList<User> result) {

				for (int i = 0; i < result.size(); i++) {

					ListOfNicknames.addItem(result.get(i).getNickname());

				}
			}

			@Override
			public void onFailure(Throwable caught) {

				Window.alert("Konnte keine User finden");

			}
		});

	}

	public void onLoad() {
		loadUsers();

		// OwnWall-Command für Menubar-Unterpunkt "Eigene Pinnwand" erstellen
		Command ownWall = new Command() {
			public void execute() {
				Window.alert("Denise own wall jaja");
			}
		};

		/*
		 * Bearbeiten-Command für Menubar-Unterpunkt "Account bearbeiten"
		 * erstellen
		 */
		Command editUser = new Command() {
			public void execute() {
				Window.alert("Denise edit USer");
			}
		};

		// Logout-Command für Menubar-Unterpunkt "Logout" erstellen
		Command logout = new Command() {
			public void execute() {
				Cookies.removeCookie("SM4S");
				RootPanel.get("content_wrap_right").clear();
				RootPanel.get("head_wrap_middle").clear();
				RootPanel.get("head_wrap_right").clear();
				RootPanel.get("head_wrap_middle").add(new Login());
			}
		};
		
		//NicknameLabel dem head_wrap_right zuordnen
		RootPanel.get("head_wrap_right").add(NicknameLabel);
		
		// Die "Unterpunkt-Menubar" erstellen, erkennbar durch "true" in der Klammer
		MenuBar UserMainMenuBtn = new MenuBar(true);

		// Der Menubar folgende Unterpunkte zuordnen
		UserMainMenuBtn.addItem("Eigene Pinnwand", ownWall);
		UserMainMenuBtn.addItem("Account bearbeiten", editUser);
		UserMainMenuBtn.addItem("Logout", logout);

		// Die "Root-Menubar" erstellen, erkennbar durch fehlendes "true" in der Klammer
		MenuBar UserMainMenu = new MenuBar();
		UserMainMenu.addItem("x", UserMainMenuBtn);

		// Dem RootPanel die Menubar zuordnen
		RootPanel.get("head_wrap_right").add(UserMainMenu);

		TestButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				CreateUser newUser = new CreateUser();
				RootPanel.get("content_wrap_right").clear();
				RootPanel.get("content_wrap_right").add(newUser);
			}
		});

		RootPanel.get("content_wrap_right").add(contentPanel);
		RootPanel.get("content_wrap_right").add(TestButton);

		CreatePost CrPost = new CreatePost();
		RootPanel.get("content_wrap_right").clear();
		RootPanel.get("content_wrap_right").add(CrPost);

	}
}