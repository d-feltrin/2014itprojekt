package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.appengine.api.images.ImagesServicePb.ImagesCompositeRequest.Builder;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
 
// TODO: Auto-generated Javadoc
/**
 * The Class GetPostBarAuthor.
 */
public class GetPostBarAuthor extends Composite  {
	
	/** The Async obj. */
	private final AServiceAsync AsyncObj = GWT.create(AService.class);

	/** The author id. */
	private int authorID; 
	
	/** The author nickname. */
	String authorNickname;
 	
	 /** The author panel. */
	 Label authorPanel = new Label();
 	
	 /** The author panel1. */
	 private FlowPanel authorPanel1 = new FlowPanel();
 	
 	/**
	  * Instantiates a new gets the post bar author.
	  *
	  * @param authorID the author id
	  */
	 public GetPostBarAuthor(int authorID) {
		 
		AsyncObj.getOneNicknameFromUserId(authorID, new  AsyncCallback<User>(){
			
			// count all einträge select
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Fehler aufgetreten");
			}
		 
			@Override
			public void onSuccess(User result) {
				//Window.alert(authorNickname);
			 
			 //authorNickname = result;
				
				result.getNickname();
				//User u = new User ();
				String a = result.getNickname();
				//u.getNickname();
				//Window.alert(authorNickname);
					//Label authorLabel = new Label(authorNickname);
					
				authorPanel.setText(a);
				authorPanel1.add(authorPanel);
			
			}
			});
	  
		initWidget(authorPanel1);
 	     
	}
 
}