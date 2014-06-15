package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.shared.bo.Board;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;
import hdm.itprojekt.Socialmediapinnwand.client.CreateUser;
import hdm.itprojekt.Socialmediapinnwand.client.LoginEntry.SocialmediapinnwandEditor;
import hdm.itprojekt.Socialmediapinnwand.client.LoginEntry.SocialmediapinnwandReport;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class LoginPanels extends HorizontalPanel {

public class LoginEditor extends HorizontalPanel {
	final TextBox nicknameBox = new TextBox();
	final PasswordTextBox pwBox = new PasswordTextBox();
	final Button LoginButton = new Button("Login Editor");
	private final AServiceAsync AsyncObj = GWT.create(AService.class);

	private final HorizontalPanel loginBox = new HorizontalPanel();
 
	public LoginEditor() {
	}

	public void onLoad() {
	 
		LoginButton.setStylePrimaryName("LoginButtonEditor");
		nicknameBox.setText("NicknameEDDD");
		pwBox.setText("Password");
		loginBox.add(nicknameBox);
		loginBox.add(pwBox);
		loginBox.add(LoginButton);
		this.add(loginBox);

		LoginButton.addClickHandler(new ClickHandler() {

			
			
			
			public void onClick(ClickEvent event) {
				if (nicknameBox.getValue().isEmpty()
						|  pwBox.getValue().isEmpty()) {
					Window.alert("Bitte Nickname und Passwort ausfüllen");
				} else {
					AsyncObj.checkLogin(nicknameBox.getValue(),
							pwBox.getValue(), new AsyncCallback<User>() {
								@Override
								public void onSuccess(User result) {

									if (result.getUserId() != 0) {
										Cookies.removeCookie("SessionUserNicknameEditor");
										Cookies.removeCookie("SessionUserIDEditor");
										Cookies.setCookie("SessionUserNicknameEditor",
												result.getNickname());
										 Cookies.setCookie("SessionUserIDEditor",
										 		String.valueOf(result.getUserId()));
										LoginEntry a = new LoginEntry();
										SocialmediapinnwandEditor b = a.new SocialmediapinnwandEditor(); 							 
									   
								 		b.setUserObject(result);
										RootPanel.get("content_wrap").clear();
										RootPanel.get("head_wrap_middle")
												.clear();
										RootPanel.get("head_wrap_right")
												.clear();
										RootPanel.get("content_wrap").add(
								 			b);
																			
								/*--		
										
										AsyncObj.getBoardIdFromUserID(result.getUserId(),
												pwBox.getValue(), new AsyncCallback<Board>() {
													@Override
													public void onSuccess(Board result) {

														if (result.getBoardId() != 0) {
															
															 
														  Cookies.setCookie("SessionBoardID",
																  String.valueOf(result.getBoardId()));
																  
													 		//b.setBoardObject(result);
													 		
															 Window.alert("-->>  "+result.getBoardId());
															
														}

													}

													@Override
													public void onFailure(Throwable caught) {
														Window.alert("Fehler");
													}

												});
										*/
																									
									}

								}

								@Override
								public void onFailure(Throwable caught) {
									Window.alert("Fehler");
								}

							});
				}
			}
		});
	}
}

public class LoginReport extends HorizontalPanel {

	private final AServiceAsync AsyncObj = GWT.create(AService.class);

	private final HorizontalPanel loginBox = new HorizontalPanel();
	
	public LoginReport() {
	}

	public void onLoad() {
		final TextBox nicknameBox = new TextBox();
		final PasswordTextBox pwBox = new PasswordTextBox();
		final Button LoginButton = new Button("Login Report");
		LoginButton.setStylePrimaryName("LoginButtonReport");
		nicknameBox.setText("Nickname");
		pwBox.setText("Password");
		loginBox.add(nicknameBox);
		loginBox.add(pwBox);
		loginBox.add(LoginButton);
		this.add(loginBox);

		LoginButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				if (nicknameBox.getValue().isEmpty()
						 | pwBox.getValue().isEmpty()) {
					Window.alert("Bitte Nickname und Passwort ausfüllen");
				} else {
					AsyncObj.checkLogin(nicknameBox.getValue(),
							pwBox.getValue(), new AsyncCallback<User>() {
								@Override
								public void onSuccess(User result) {
		
									if (result.getUserId() != 0  ) {
														
										LoginEntry a = new LoginEntry();
										SocialmediapinnwandReport b = a.new SocialmediapinnwandReport(); 
										 
										Cookies.removeCookie("SessionUserNicknameReport");
										Cookies.removeCookie("SessionUserIDReport");
										Cookies.setCookie("SessionUserNicknameReport",
												result.getNickname());
										Cookies.setCookie("SessionUserIDReport",
												String.valueOf(result.getUserId()));
										b.setUserObject(result);
										RootPanel.get("content_wrap").clear();
										RootPanel.get("head_wrap_middle")
												.clear();
										RootPanel.get("head_wrap_right")
												.clear();
										RootPanel.get("content_wrap").add(
												b);
									}
								 
								}
								@Override
								public void onFailure(Throwable caught) {
									Window.alert("Fehler");
								}
							});
				}
			}
		});
	}
}

public class LoginDasboard extends HorizontalPanel {
	HorizontalPanel vP2 = new HorizontalPanel();
	HorizontalPanel vP = new HorizontalPanel();
	
	VerticalPanel vEditor = new VerticalPanel();
	final Label vEditorHeadline = new Label("Login Editor-Client");
	final Label vEditorSubline = new Label("Mit dem Editor-Client können Sie unter anderem Freunde abbnonieren, Beitr�ge schreiben und diese komentieren ");
	
	VerticalPanel vReport = new VerticalPanel();
	final Label vReportHeadline = new Label("Login Report-Client");
	final Label vReportSubline = new Label("Mit dem Report-Client können Sie unter anderem Statistiken anzeigen lassen, zum Beispiel wie viele Abboneten Sie haben. ");
	
    final Image image = new Image();
    final Label welcome = new Label( "Willkommen");
	
 	final Button RegisterButton = new Button("User Registrieren");

	public void onLoad(){
		
	    image.setUrl("http://pressespecial.de/itpimg/PeteA.jpg");
	    image.setPixelSize(960, 570);
	    
	    image.setStylePrimaryName("BgImage");
	    welcome.setStylePrimaryName("BgWelcome");
	    
	    vEditor.setStylePrimaryName("LoginPanelLeft");
	    vReport.setStylePrimaryName("LoginPanelRight");
	    
	    vEditorHeadline.addStyleName("LoginHeadlineEditor");
	    vReportHeadline.addStyleName("LoginHeadlineReport");
	    
	    vEditorSubline.addStyleName("LoginSublineEditor");
	    vReportSubline.addStyleName("LoginSublineReport");
	    
	 	RegisterButton.setStylePrimaryName("RegisterButton1");
		
	 	vEditor.add(vEditorHeadline);
	 	vEditor.add(vEditorSubline);
	 	vEditor.add(new LoginReport());
	 		
		vReport.add(vReportHeadline);
		vReport.add(vReportSubline);
		vReport.add(new LoginEditor());
	 	
	vP2.add(image);
	vP2.add(welcome);
	
	vP.add(vEditor);
	 vP.add(vReport);	
		
	// hP.add(new LoginReport());
	// hP.add(new LoginEditor());

		RootPanel.get("content_wrap").add(vP2);
	RootPanel.get("content_wrap").add(vP);

	RootPanel.get("head_wrap_right").clear();
	RootPanel.get("head_wrap_right").add(RegisterButton);
 	 
	RegisterButton.addClickHandler(new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
			RootPanel.get("content_wrap").clear();

			RootPanel.get("head_wrap_right").clear();
			CreateUser CrUser = new CreateUser();
			RootPanel.get("content_wrap").add(CrUser);

		}

	});
	
	}
	
}

}