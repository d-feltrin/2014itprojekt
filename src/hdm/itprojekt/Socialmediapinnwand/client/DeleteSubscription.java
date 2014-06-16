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

// TODO: Auto-generated Javadoc
/**
 * The Class DeleteSubscription.
 */
public class DeleteSubscription extends VerticalPanel {
	
	/** The Async obj. */
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	
	/** The s. */
	private Subscription s;
	
	/** The u. */
	private User u;
	
	/** The Del abo btn. */
	final Button DelAboBtn = new Button("Abonnement Löschen");
	
	/** The Delete abonnement. */
	final VerticalPanel DeleteAbonnement = new VerticalPanel();
	
	/** The user session pinboard id. */
	final int userSessionPinboardId = Integer.parseInt(Cookies
			.getCookie("SessionUserIDEditor"));
	
	/** The user session pinboard nickname. */
	final String userSessionPinboardNickname = Cookies
			.getCookie("SessionUserNicknameEditor");
	
	/** The user sub nickname cookie. */
	final String userSubNicknameCookie = Cookies.getCookie("SelectedListItem");

	/**
	 * Instantiates a new delete subscription.
	 *
	 * @param s the s
	 */
	public DeleteSubscription(Subscription s) {
		this.s = s;

	}

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.Widget#onLoad()
	 */
	public void onLoad() {
		deleteSubscriptionBySubscriptionID(s);

	}

	/**
	 * Gets the user id by user nickname.
	 *
	 * @param u the u
	 * @return the user id by user nickname
	 */
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

	/**
	 * Delete subscription by subscription id.
	 *
	 * @param s the s
	 */
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