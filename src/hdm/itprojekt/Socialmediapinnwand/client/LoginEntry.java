package hdm.itprojekt.Socialmediapinnwand.client;

import java.util.ArrayList;
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
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import hdm.itprojekt.Socialmediapinnwand.client.BoardPanel.createOwnBoardByNicknamePanel;
import hdm.itprojekt.Socialmediapinnwand.client.HeadlineBar.HeadlinesBarEditor;
import hdm.itprojekt.Socialmediapinnwand.client.HeadlineBar.HeadlinesBarReport;
import hdm.itprojekt.Socialmediapinnwand.client.LoginPanels.LoginDasboard;
import hdm.itprojekt.Socialmediapinnwand.client.gui.AllUsersbByAllInfoObject;
import hdm.itprojekt.Socialmediapinnwand.client.gui.BoardOverview;
import hdm.itprojekt.Socialmediapinnwand.client.gui.OneUserByOneInfoObjects;
import hdm.itprojekt.Socialmediapinnwand.client.gui.ReportOverview;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;

public class LoginEntry extends AbsolutePanel {
	
	private  User user = new User();
 
	final VerticalPanel contentPanel = new VerticalPanel();
 	private final AServiceAsync AsyncObj = GWT.create(AService.class);

	final MenuBar UserMainMenu = new MenuBar();

	public class SocialmediapinnwandEditor extends VerticalPanel {
			
		private User user2;

			public SocialmediapinnwandEditor() {
			}

	public void setUserObject(User user2) {
		this.user2 = user2;
	}

	MenuBar UserMainMenuBtn = new MenuBar(true);
	MenuBar UserMainMenu = new MenuBar();

	Command logout = new Command() {
		public void execute() {
			Cookies.removeCookie("SessionUserNicknameEditor");
			Cookies.removeCookie("SessionUserIdEditor");
			RootPanel.get("content_wrap").clear();
			RootPanel.get("head_wrap_middle").clear();
			RootPanel.get("head_wrap_right").clear();
			LoginPanels a = new LoginPanels();
			LoginDasboard b = a.new LoginDasboard(); 
			RootPanel.get("content_wrap").add(b);
		 
		}
	};
	
	// OwnWall-Command f�r Menubar-Unterpunkt "Eigene Pinnwand" erstellen
			Command ownWall = new Command() {
				public void execute() {
					RootPanel.get("content_wrap").clear();
	   				
					final String cookieNickname = Cookies.getCookie("SessionUserNicknameEditor"); 
					HeadlineBar hB2 = new HeadlineBar();
						hB2.setHeadlineInHeadlineBar("Eigene Pinnwand");
						HeadlinesBarEditor HeadlineAllAll2 = hB2.new HeadlinesBarEditor();
						RootPanel.get("content_wrap").add(HeadlineAllAll2);
				    BoardPanel bP = new BoardPanel(); 
				    createOwnBoardByNicknamePanel bD =  bP.new createOwnBoardByNicknamePanel(cookieNickname);			
				 
								RootPanel.get("content_wrap").add(bD);

			//    final String cookieNickname = Cookies.getCookie("SessionUserNickname");
		 	//	BoardPanel bP = new BoardPanel(); 

			 //	createBoardByNicknamePanel bD =  bP.new createBoardByNicknamePanel(cookieNickname); 
	 
		  	//	RootPanel.get("content_wrap").add(bD);

	 			}
			};

			// Bearbeiten-Command für Menubar-Unterpunkt "Account bearbeiten"
			// erstellen
			Command editUser = new Command() {
				public void execute() {
					RootPanel.get("content_wrap").clear();
					EditUser a = new EditUser();
					RootPanel.get("content_wrap").add(a);
				}
			};
			
			public void setUserMenuItems(){
				// Der Menubar folgende Unterpunkte zuordnen
				UserMainMenuBtn.addItem("Eigene Pinnwand", ownWall);
				UserMainMenuBtn.addItem("Account bearbeiten", editUser);
				UserMainMenuBtn.addItem("Logout", logout);
				UserMainMenu.addItem("x", UserMainMenuBtn);
				UserMainMenu.addStyleName("mainmenu-UserMainMenu");
				RootPanel.get("head_wrap_right").add(UserMainMenu);

			}

	public void onLoad() {
		
		// NEw BOARD PANEL 
		
		 //loadUsers();
		//RootPanel.get("content_wrap").clear(); 
		 setUserMenuItems();
	 	BoardOverview nop = new BoardOverview();
		 RootPanel.get("head_wrap_right").add(UserMainMenu);
	 	RootPanel.get("content_wrap").add(nop);
	 
	}
	 
	}
	
	public class SocialmediapinnwandReport extends VerticalPanel {
		private User user = new User();
		final VerticalPanel contentPanel = new VerticalPanel();
		final Button TestButton = new Button("Test");
		private final AServiceAsync AsyncObj = GWT.create(AService.class);
		final ListBox ListOfNicknames = new ListBox();
		final MenuBar UserMainMenu = new MenuBar();
		
	 	final HorizontalPanel allReportsPanel = new HorizontalPanel();	
		public SocialmediapinnwandReport() {
		}
		public void setUserObject(User user) {
			this.user = user;
		}

		public void onLoad() {

			RootPanel.get("content_wrap").add(new ReportOverview());
			
	 		Command allstat = new Command() {
				public void execute() {
					 
					RootPanel.get("content_wrap").clear();
					RootPanel.get("head_wrap_middle").clear();
					RootPanel.get("content_wrap").add(new ReportOverview());
				  	
				}
			};
			
			Command rankstat = new Command() {
				public void execute() {
	 				RootPanel.get("content_wrap").clear();
	 				HeadlineBar hB1 = new HeadlineBar();
					hB1.setHeadlineInHeadlineBar("Toplisten");
					HeadlinesBarReport HeadlinesBarEditor1 =  hB1.new HeadlinesBarReport();
	 				RootPanel.get("content_wrap").add(HeadlinesBarEditor1);
	 			// 	RootPanel.get("content_wrap").add(new AllUsersbByAllInfoObject());
	 				//Window.alert("aas");
					
				}
			};
			Command  userstat  = new Command() {
				public void execute() {
	 				RootPanel.get("content_wrap").clear();
	 				
					HeadlineBar hB3 = new HeadlineBar();
					hB3.setHeadlineInHeadlineBar("User Statistiken");
					HeadlinesBarReport HeadlinesBarEditor2 =  hB3.new HeadlinesBarReport();
	 				RootPanel.get("content_wrap").add(HeadlinesBarEditor2);
	 		//	 	RootPanel.get("content_wrap").add(new OneUserByOneInfoObjects());
	 				//Window.alert("ttttaass");
	 	
				}
			};
			Command logout = new Command() {
				public void execute() {
					Cookies.removeCookie("SessionUserNicknameReport");
					Cookies.removeCookie("SessionUserIdEditor");
					RootPanel.get("content_wrap").clear();
					RootPanel.get("head_wrap_middle").clear();
					RootPanel.get("head_wrap_right").clear();
					LoginPanels a = new LoginPanels();
					LoginDasboard b = a.new LoginDasboard(); 
					RootPanel.get("content_wrap").add(b);
				 
				}
			};
			 
			MenuBar UserMainMenuBtnShowAll = new MenuBar(true);
			 
			MenuBar UserMainMenuBtn = new MenuBar(true);
			UserMainMenuBtn.addItem("Alle Statistiken", allstat);
			UserMainMenuBtn.addItem("View 1: Rankinglisten", rankstat);
			UserMainMenuBtn.addItem("View 1: Rankinglisten", userstat);
			UserMainMenuBtn.addItem("Logout", logout);

			MenuBar UserMainMenu = new MenuBar();
			UserMainMenu.addItem("Navigation", UserMainMenuBtn);
			UserMainMenu.setStylePrimaryName("mainmenu");
			
			UserMainMenuBtn.setStylePrimaryName("UserMainMenuBtn");
			
			RootPanel.get("head_wrap_right").add(UserMainMenu);

		}
	}
	
}