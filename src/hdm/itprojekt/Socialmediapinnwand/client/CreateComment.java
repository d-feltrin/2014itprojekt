package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.client.BoardPanel.createOwnBoardByNicknamePanel;
import hdm.itprojekt.Socialmediapinnwand.client.LoginPanels.LoginDasboard;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Comment;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Post;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

// TODO: Auto-generated Javadoc
/**
 * The Class CreateComment.
 */
public class CreateComment extends DialogBox{
	
	/** The Async obj. */
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	
	/** The post id. */
	private int postId;
 
 /** The p. */
 private Comment p = new Comment();
 
//	int left = Window.getClientWidth() /2;
//	int top = Window.getClientHeight() /2;
	
	/** The selected nickname3. */
private  String selectedNickname3 = Cookies.getCookie("SelectedListItem");

	/** The a. */
	DialogBox a = new DialogBox(true); 
	
	/** The save btn. */
	Button saveBtn = new Button("Speichern");
	
	/** The close btn. */
	Button closeBtn = new Button("Abbrechen");
	
	/** The edit post. */
	TextArea editPost = new TextArea();

	/** The headline. */
	Label headline = new Label("Kommentar schreiben  ");
	
	/** The content panel. */
	VerticalPanel contentPanel = new VerticalPanel();
	
	/** The wrap panel. */
	private final VerticalPanel wrapPanel = new VerticalPanel();
	
	/** The Button panel. */
	FlowPanel ButtonPanel = new FlowPanel();
//	Cookies.getCookie("SessionBoardID", String.valueOf(result.getBoardId()));
			  
	 
	
	 
	 
	 /** The foo. */
int foo;
	 
	/**
	 * Instantiates a new creates the comment.
	 *
	 * @param postID the post id
	 */
	public CreateComment(int postID   ){
		 
		a.setGlassEnabled(true);
		a.show();
		a.center();
		this.postId=postID;
		
		showCreateCommentPanel(postId, foo);
	} 

 

/**
 * Save comment for panel.
 *
 * @param postId the post id
 * @param foo the foo
 */
public void saveCommentForPanel(int postId, int foo) {
		
	 

	 final String a2  ; 

 
	a2 = Cookies.getCookie("SessionUserIDEditor" ); 
	 foo=Integer.parseInt(a2);
	 
	 	p.setText(editPost.getText());
	 	p.setPost_id(postId);
	 	p.setUser_id(foo);
	  
 
	 	

		AsyncObj.createCommentByPostID(p , new  AsyncCallback<Void>(){
			
			// count all einträge select
			 
			public void onFailure(Throwable caught) {
				Window.alert("Fehler aufgetreten");
			}
		 
			public void onSuccess(Void result) {
				
				
				Window.alert("Der Kommentar wurde erstellt.");
				BoardPanel  np= new BoardPanel();
			        createOwnBoardByNicknamePanel bD =  np.new createOwnBoardByNicknamePanel(selectedNickname3); 
			       RootPanel.get("content_wrap").clear();
								RootPanel.get("content_wrap").add(bD);	
	 
				}
			});
		
	}
	
	
	


/**
 * Show create comment panel.
 *
 * @param postId the post id
 * @param foo the foo
 * @return the dialog box
 */
public DialogBox showCreateCommentPanel( final int postId, final int foo) {
	
	
	saveBtn.setStylePrimaryName("LoginButtonEditor");
	closeBtn.setStylePrimaryName("LoginButtonEditor");
	headline.setStylePrimaryName("Post_bar_headline");
	contentPanel.setStylePrimaryName("Post_bar_contentPanel");
	wrapPanel.setStylePrimaryName("Post_bar_wrapPanel");
	ButtonPanel.setStylePrimaryName("Post_bar_ButtonPanel");
	a.setStylePrimaryName("Post_bar_a");
	editPost.setStylePrimaryName("Post_bar_edit_textbox");
 
		ButtonPanel.add(saveBtn);
		ButtonPanel.add(closeBtn);
		wrapPanel.add(headline);
		contentPanel.add(editPost);	
		wrapPanel.add(contentPanel);
		wrapPanel.add(ButtonPanel);
		a.setWidget(wrapPanel); 
		
		closeBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				a.hide();
			}
			});
		

		saveBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				  saveCommentForPanel(postId,foo);
				
				a.hide();
				BoardPanel  np= new BoardPanel();
			        createOwnBoardByNicknamePanel bD =  np.new createOwnBoardByNicknamePanel(selectedNickname3); 
			       RootPanel.get("content_wrap").clear();
								RootPanel.get("content_wrap").add(bD);		
			}
			});
		return a;	
		
 
 
 
	
}		

 
 

}