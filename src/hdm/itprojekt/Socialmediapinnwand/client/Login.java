package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;
import hdm.itprojekt.Socialmediapinnwand.client.CreateUser;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

public class Login extends HorizontalPanel {

	private final AServiceAsync AsyncObj = GWT.create(AService.class);

	private final HorizontalPanel loginBox = new HorizontalPanel();
	

	public Login() {
	}

	public void onLoad() {
		// ListBox ListOfSystems = new ListBox();
		// ListOfSystems.addItem("Editor");
		// ListOfSystems.addItem("Login");
		// ListOfSystems.setSize("70px", "35px");
		final TextBox nicknameBox = new TextBox();
		final PasswordTextBox pwBox = new PasswordTextBox();
		final Button RegisterButton = new Button("Registrieren");
		final Button LoginButton = new Button("Login");

		nicknameBox.setText("Nickname");
		nicknameBox.setStylePrimaryName("LoginNicknameBox");

		pwBox.setText("Password");
		pwBox.setStylePrimaryName("LoginPaswordBox");

		loginBox.add(nicknameBox);
		loginBox.add(pwBox);
		loginBox.setStylePrimaryName("head_wrap_middle");

		// loginBox.add(ListOfSystems);
		loginBox.add(LoginButton);
		loginBox.add(RegisterButton);
		// RegisterButton.setStylePrimaryName("RegisterButton");
		LoginButton.setStylePrimaryName("loginButton");

		RegisterButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				RootPanel.get("content_wrap").clear();

				RootPanel.get("head_wrap_right").clear();
				CreateUser CrUser = new CreateUser();
				RootPanel.get("content_wrap").add(CrUser);

			}

		});
		this.add(loginBox);

		LoginButton.addClickHandler(new ClickHandler() {

			public void onClick(ClickEvent event) {
				if (nicknameBox.getValue().isEmpty()
						|| pwBox.getValue().isEmpty()) {
					Window.alert("Bitte Nickname und Passwort ausf�llen");
				} else {
					AsyncObj.checkLogin(nicknameBox.getValue(),
							pwBox.getValue(), new AsyncCallback<User>() {
								@Override
								public void onSuccess(User result) {

									
									if (result.getUserId() != 0) {
										Socialmediapinnwand_entry dashboard = new Socialmediapinnwand_entry();
										Cookies.setCookie("SessionUserNickname",
												result.getNickname());
										Cookies.setCookie("SessionUserID",
												String.valueOf(result.getUserId()));
										dashboard.setUserObject(result);
										RootPanel.get("content_wrap").clear();
										RootPanel.get("head_wrap_middle")
												.clear();
										RootPanel.get("head_wrap_right")
												.clear();
										RootPanel.get("content_wrap").add(
												dashboard);
										

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
