package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.shared.bo.Subscription;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;

import com.google.gwt.user.client.ui.VerticalPanel;

public class CreateSubscription extends VerticalPanel {
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	private Subscription s;
	private User u;
	final Button SubscribeButton = new Button("Abonnieren");
	final VerticalPanel Subscribe = new VerticalPanel();
	final int userSessionPinboardId = Integer.parseInt(Cookies
			.getCookie("SessionUserIDEditor"));
	final String userSessionPinboardNickname = Cookies
			.getCookie("SessionUserNicknameEditor");
	final String userSubNicknameCookie = Cookies.getCookie("SelectedListItem");

	public CreateSubscription() {

	}

	public void checkSubscription(Subscription sp) {
		this.s = sp;
		
		

	}

	public void getSubscribeByNickname() {
		u.setNickname(userSubNicknameCookie);
		AsyncObj.getUserIdByUserNickname(u, new AsyncCallback<User>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("hax");

			}

			@Override
			public void onSuccess(User result) {

				s.setToUser(result.getUserId());
				s.setFromUser(userSessionPinboardId);

				AsyncObj.createSubscriptionByUserId(s,
						new AsyncCallback<Void>() {

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Fehler " + caught.getMessage());

							}

							@Override
							public void onSuccess(Void result) {
								Window.alert("erfolgreich abonniert");

							}
						});

			}
		});

	}

	public void onLoad() {

	}

}
