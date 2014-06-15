package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.shared.bo.Subscription;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class DeleteSubscription extends VerticalPanel {
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	private Subscription s;
	private User u;
	final Button DelAboBtn = new Button("Abonnement Löschen");
	final VerticalPanel DeleteAbonnement = new VerticalPanel();
	final int userSessionPinboardId = Integer.parseInt(Cookies
			.getCookie("SessionUserIDEditor"));
	final String userSessionPinboardNickname = Cookies
			.getCookie("SessionUserNicknameEditor");
	final String userSubNicknameCookie = Cookies.getCookie("SelectedListItem");

	public DeleteSubscription(Subscription s) {
		this.s = s;

	}

	public void onLoad() {
		deleteSubscriptionBySubscriptionID(s);

	}

	public void getUserIdByUserNickname(User u) {
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

			}
		});

	}

	public void deleteSubscriptionBySubscriptionID(Subscription s) {
		AsyncObj.deleteSubscriptionBySubscriptionID(s,
				new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onSuccess(Void result) {
						Window.alert("erfolgreich");

					}

				});

	}

}