package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.shared.bo.Subscription;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;

import com.google.gwt.user.client.ui.VerticalPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateSubscription.
 */
public class CreateSubscription extends VerticalPanel {
	
	/** The Async obj. */
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	
	/** The s. */
	private Subscription s;
	
	/** The u. */
	private User u;
	
	/** The Subscribe button. */
	final Button SubscribeButton = new Button("Abonnieren");
	
	/** The Subscribe. */
	final VerticalPanel Subscribe = new VerticalPanel();
	
	/** The user session pinboard id. */
	final int userSessionPinboardId = Integer.parseInt(Cookies
			.getCookie("SessionUserIDEditor"));
	
	/** The user session pinboard nickname. */
	final String userSessionPinboardNickname = Cookies
			.getCookie("SessionUserNicknameEditor");
	
	/** The user sub nickname cookie. */
	final String userSubNicknameCookie = Cookies.getCookie("SelectedListItem");

	/**
	 * Instantiates a new creates the subscription.
	 */
	public CreateSubscription() {

	}

	/**
	 * Check subscription.
	 *
	 * @param sp the sp
	 */
	public void checkSubscription(Subscription sp) {
		this.s = sp;
		
		

	}

	/**
	 * Gets the subscribe by nickname.
	 *
	 * @return the subscribe by nickname
	 */
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

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.Widget#onLoad()
	 */
	public void onLoad() {

	}

}
