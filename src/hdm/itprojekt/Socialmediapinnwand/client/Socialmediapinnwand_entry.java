package hdm.itprojekt.Socialmediapinnwand.client;

import java.util.ArrayList;
import java.util.Vector;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import hdm.itprojekt.Socialmediapinnwand.shared.bo.*;

public class Socialmediapinnwand_entry extends AbsolutePanel {
	private User user = new User();

	final VerticalPanel postPanel = new VerticalPanel();
	final VerticalPanel postPanelPostsByUser = new VerticalPanel();
	final VerticalPanel commentPanelx = new VerticalPanel();
	final HorizontalPanel endPanel = new HorizontalPanel();
	final HorizontalPanel endPanelPostsByUser = new HorizontalPanel();
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	final ListBox ListOfNicknames = new ListBox();

	final MenuBar UserMainMenu = new MenuBar();

	public Socialmediapinnwand_entry() {
	}

	public void setUserObject(User user) {
		this.user = user;
	}

	void loadUsers() {
		// Dropdown aller vorhandenen User anzeigen
		ListOfNicknames.addItem("User ausw�hlen");
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

	Widget getAllPinboardPostsByUser(String UserNickname) {
		RootPanel.get("content_wrap").clear();
		User u = new User();
		u.setNickname(UserNickname);
		RootPanel.get("content_wrap").add(new CreateSubscription(u));
		AsyncObj.getAllPostsByUserNickname(UserNickname,
				new AsyncCallback<Vector<Post>>() {

					@Override
					public void onFailure(Throwable caught) {

						Window.alert("Aufruf der Post fehlgeschlagen "
								+ caught.getMessage());
						System.out.println("Postaufruf hat nicht geklappt");
					}

					@Override
					public void onSuccess(Vector<Post> result) {

						if (result.equals(null)) {
							System.out.println("Result leer");
						}
						for (Post p : result) {

							final TextArea postList = new TextArea(); // TODO
																		// textarea
																		// in lb
							// ändern
							final HorizontalPanel postPanelPostsByUser = new HorizontalPanel();
							postList.setText(p.getPost());
							postPanelPostsByUser.add(postList);

							Comment c = new Comment();
							c.setCommentPostId(p.getId());
							RootPanel.get("content_wrap").add(new GetAllCommentsByPostId(
									c));
							RootPanel.get("content_wrap").add(new CreateComment(c));
							RootPanel.get("content_wrap").add(postPanelPostsByUser);
						}

						

					}
				});
		
		

		return endPanelPostsByUser;
	}

	Widget getAllPinboardPostsById() {
		RootPanel.get("content_wrap").clear();

		final int pUserId = Integer
				.parseInt(Cookies.getCookie("SessionUserID"));

		AsyncObj.getAllPostsByUser(pUserId, new AsyncCallback<Vector<Post>>() {

			@Override
			public void onFailure(Throwable caught) {

				Window.alert("Aufruf der Post fehlgeschlagen "
						+ caught.getMessage());
				System.out.println("Postaufruf hat nicht geklappt");
			}

			@Override
			public void onSuccess(Vector<Post> result) {

				System.out.println("Async erfolgt");
				if (result.equals(null)) {
					System.out.println("Result leer");
				}
				for (Post p : result) {
					final TextArea postList = new TextArea(); // TODO textarea
																// in lb ändern
					postList.setText(p.getPost());
					postPanel.add(postList);

				}
				endPanel.add(postPanel);

			}
		});
		RootPanel.get("content_wrap").clear();
		return endPanel;

	}

	public void onLoad() {
		RootPanel.get("content_wrap").clear();
	
		ListOfNicknames.addChangeHandler(new ChangeHandler() {
			
			@Override
			public void onChange(ChangeEvent event) {

				int itemSelected = ListOfNicknames.getSelectedIndex();
				String itemStringSelected = ListOfNicknames
						.getValue(itemSelected);
				RootPanel.get("content_wrap").clear();

				RootPanel.get("content_wrap").add(getAllPinboardPostsByUser(itemStringSelected));
			}
		});
		loadUsers();

		// OwnWall-Command f�r Menubar-Unterpunkt "Eigene Pinnwand" erstellen
		Command ownWall = new Command() {
			public void execute() {
				Window.alert("Denise own wall jaja");
			}
		};

		// Bearbeiten-Command f�r Menubar-Unterpunkt "Account bearbeiten"
		// erstellen
		Command editUser = new Command() {
			public void execute() {
				Window.alert("Denise edit USer");
			}
		};

		// Logout-Command f�r Menubar-Unterpunkt "Logout" erstellen
		Command logout = new Command() {
			public void execute() {
				Cookies.removeCookie("SessionUserNickname");
				Cookies.removeCookie("SessionUserId");
				RootPanel.get("content_wrap").clear();
				RootPanel.get("head_wrap_middle").clear();
				RootPanel.get("head_wrap_right").clear();
				RootPanel.get("head_wrap_middle").add(new Login());
			}
		};

		// Die "Unterpunkt-Menubar" erstellen, erkennbar durch "true" in der
		// Klammer
		MenuBar UserMainMenuBtn = new MenuBar(true);

		// Der Menubar folgende Unterpunkte zuordnen
		UserMainMenuBtn.addItem("Eigene Pinnwand", ownWall);
		UserMainMenuBtn.addItem("Account bearbeiten", editUser);
		UserMainMenuBtn.addItem("Logout", logout);

		// Die "Root-Menubar" erstellen, erkennbar durch fehlendes "true" in der
		// Klammer
		MenuBar UserMainMenu = new MenuBar();
		UserMainMenu.addItem("x", UserMainMenuBtn);

		// Dem RootPanel die Menubar zuordnen
		RootPanel.get("head_wrap_right").add(UserMainMenu);

		CreatePost CrPost = new CreatePost();
		RootPanel.get("content_wrap").clear();
		RootPanel.get("content_wrap").add(CrPost);

		RootPanel.get("content_wrap").add(getAllPinboardPostsById());

	}
}
