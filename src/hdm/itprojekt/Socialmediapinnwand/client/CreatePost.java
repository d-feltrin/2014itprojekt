package hdm.itprojekt.Socialmediapinnwand.client;

import java.util.ArrayList;

import hdm.itprojekt.Socialmediapinnwand.client.BoardPanel.createOwnBoardByNicknamePanel;
import hdm.itprojekt.Socialmediapinnwand.client.HeadlineBar.HeadlinesAllUserAllInfoO;
import hdm.itprojekt.Socialmediapinnwand.client.gui.BoardOverview;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Post;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class CreatePost.
 */
public class CreatePost extends VerticalPanel {

	// Definieren von ben�tigten Widgets
	/** The submit post. */
	private final Button submitPost = new Button("Absenden");
	
	/** The post. */
	private final TextArea post = new TextArea();
 	
	 /** The New insert post. */
	 final Post NewInsertPost = new Post();
	
	/** The selected nickname3. */
	private  String selectedNickname3 = Cookies.getCookie("SelectedListItem");
		 
	/** The user_post_id. */
	private int  user_post_id ;
	// Wie kann man das hier bezeichnen?
	/** The Async obj. */
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	
	/** The p. */
	private Post p;
	//private String getCookieUser;

	/** The vert panel. */
	private final VerticalPanel vertPanel = new VerticalPanel();

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.Widget#onLoad()
	 */
	public void onLoad() {
		//getCookieUser = Cookies.getCookie("SessionUserNickname");

		// Widgets mit vordefiniertem Text bef�llen
		post.setCharacterWidth(80);
		post.setVisibleLines(10);
		post.setStylePrimaryName("postnowbox_content");
		vertPanel.setStylePrimaryName("boardBeitragPostenBox");
		//post.setText(getCookieUser);
		HeadlineBar hB2 = new HeadlineBar();
		hB2.setHeadlineInHeadlineBar("Einen Neuen Beitrag posten:");
		HeadlinesAllUserAllInfoO HeadlineAllAll2 = hB2.new HeadlinesAllUserAllInfoO();				vertPanel.add(HeadlineAllAll2);
		String headline = "Posten Sie einen neuen Beitrag";
		HeadlineAllAll2.setText(headline);
		// Widgets dem Panel zuordnen
		vertPanel.add(post);
 
		
		submitPost.setStylePrimaryName("postnowbox_submit_button");
		
 		vertPanel.add(submitPost);
		// Dem Benutzerbutton einen ClickHandler zuordnen
		submitPost.addClickHandler(new ClickHandler() {

			// Der ClickHandler erstellt ein neues User-Objekt mit
			// entsprechenden Werten aus den Widgets
			public void onClick(ClickEvent event) {
			
				String   np=   new BoardOverview().getSelectedNickname();
 				
				if (post.getValue().isEmpty()) {
					Window.alert("Bitte gebe deinen Post ein");

				} else {
				  
					NewInsertPost.setPost(post.getValue());
					
					// Implementierung der Asynchronit�t des Callbacks f�r den
					// insert-Befehl
					final int from_author_cookie_id = Integer.parseInt(Cookies.getCookie("SessionUserIDEditor"));
				 
					final String SelectedListItem = Cookies.getCookie("SelectedListItem"); 

					NewInsertPost.setPosr_id(from_author_cookie_id);
					
					//Window.alert( "Cookie ID     "+ from_author_cookie_id);
	  
				//	selectedNickname3 =	np.getSelectedListBoxIndex(ListOfNicknamesIN, np.getListBoxIndex());

					//Window.alert("SelecteID ----- " +SelectedListItem   );
					
					AsyncObj.getOneUserIdByNickname(  SelectedListItem, new AsyncCallback<User>() {
						 
						@Override
						 public void onSuccess(User result) {
 							int tempSelectID = result.getUserId();

							//int tempSelectID= result.getUserId();
							NewInsertPost.setUser_id(tempSelectID);
 						 						 
						//Window.alert(""+NewInsertPost.getUser_id() + "+++  " + NewInsertPost.getPosr_id()+"++" + NewInsertPost.getPost()  );
			
						AsyncObj.insertPost(NewInsertPost,   new AsyncCallback<Void>() {
							@Override
							// Anzeige bei fehlerhaftem insert-Befehl
							public void onFailure(Throwable caught) {
								Window.alert("Fehler beim Posten!");
							}

							@Override
							// Anzeige bei erfolgreichem insert-Befehl
							public void onSuccess(Void result) {
								Window.alert("Erfolgreich gepostet!");
								BoardPanel  np= new BoardPanel();
	 						        createOwnBoardByNicknamePanel bD =  np.new createOwnBoardByNicknamePanel(selectedNickname3); 
	 						       RootPanel.get("content_wrap").clear();
	 											RootPanel.get("content_wrap").add(bD);				

							}
						});		
						
						}
						 	 
						 				@Override
										public void onFailure(Throwable caught) {
											Window.alert("Erfolgreich sadt!");

										}
	 
							});  
					
				}
			}
		});
		
		this.add(vertPanel);
	}
}