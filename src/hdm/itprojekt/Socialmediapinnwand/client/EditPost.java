package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.client.BoardPanel.createOwnBoardByNicknamePanel;
import hdm.itprojekt.Socialmediapinnwand.client.LoginPanels.LoginDasboard;
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
 * The Class EditPost.
 */
public class EditPost extends DialogBox{
	
	/** The Async obj. */
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	
	/** The post id. */
	private int postId;
	
	/** The p. */
	private Post p = new Post();
	
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
	Label headline = new Label("Post bearbeiten");
	
	/** The content panel. */
	VerticalPanel contentPanel = new VerticalPanel();
	
	/** The wrap panel. */
	private final VerticalPanel wrapPanel = new VerticalPanel();
	
	/** The Button panel. */
	FlowPanel ButtonPanel = new FlowPanel();
	


	
	/**
	 * Instantiates a new edits the post.
	 *
	 * @param postID the post id
	 * @param counter the counter
	 * @param ownuserID the ownuser id
	 * @param authorID the author id
	 * @param message the message
	 */
	public EditPost(int postID, int counter, int ownuserID, int authorID, String message ){
  
		this.p.setPId(postID);
		this.p.setLike(counter);
		this.p.setPosr_id(authorID);
		this.p.setPost(message);
		this.p.setUser_id(ownuserID);
		this.postId = postID;

		a.setGlassEnabled(true);
		a.show();
		a.center();
	 
		
		loadPostForEditPanel(postId);
 
	//	initWidget(wrapPanel);
		setWidget(wrapPanel);
	}

/**
 * Save post for edit panel.
 *
 * @param p the p
 */
public void savePostForEditPanel(Post p) {
	
	Window.alert("  " + p.getPost() + "Post-Test");
 	Window.alert("  " + p.getPId() + "PostId-Test");
 
 	 
 	 
 
 	p.setPost(editPost.getText());
  
 
	AsyncObj.savePostForEdit(p , new  AsyncCallback<Void>(){
		
		// count all einträge select
		 
		public void onFailure(Throwable caught) {
			Window.alert("Fehler aufgetreten");
		}
	 
		public void onSuccess(Void result) {
			Window.alert("Der Beitrag wurde geändert.");
 
			}
		});
	
}
	
/**
 * Load post for edit panel.
 *
 * @param postId the post id
 * @return the post
 */
public Post loadPostForEditPanel( int postId) {
	
	
	saveBtn.setStylePrimaryName("LoginButtonEditor");
	closeBtn.setStylePrimaryName("LoginButtonEditor");
	headline.setStylePrimaryName("Post_bar_headline");
	contentPanel.setStylePrimaryName("Post_bar_contentPanel");
	wrapPanel.setStylePrimaryName("Post_bar_wrapPanel");
	ButtonPanel.setStylePrimaryName("Post_bar_ButtonPanel");
	a.setStylePrimaryName("Post_bar_a");
	editPost.setStylePrimaryName("Post_bar_edit_textbox");
	
	
AsyncObj.loadPostForEdit(postId, new  AsyncCallback<Post>(){
	
	// count all einträge select
	@Override
	public void onFailure(Throwable caught) {
		Window.alert("Fehler aufgetreten");
	}
 
	@Override
	public void onSuccess(Post result) {

		 
		 
		
		String b = result.getPost();
		editPost.setText(b);
		
	// 	Window.alert("loadPostForEdit wird geladen   " + b);
		
		ButtonPanel.add(saveBtn);
		ButtonPanel.add(closeBtn);
		
		
		wrapPanel.add(headline);
		
		contentPanel.add(editPost);	
		wrapPanel.add(contentPanel);
		wrapPanel.add(ButtonPanel);
		//a.center();
		a.setWidget(wrapPanel); 
	 
	//	a.setPopupPosition(left, top);



		
		closeBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				a.hide();
			}
			});
		
		

		saveBtn.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
				savePostForEditPanel(p);
				
				a.hide();
				BoardPanel  np= new BoardPanel();
			        createOwnBoardByNicknamePanel bD =  np.new createOwnBoardByNicknamePanel(selectedNickname3); 
			       RootPanel.get("content_wrap").clear();
								RootPanel.get("content_wrap").add(bD);		
				
			}
			});	
		
	}
	});
 
return p;
	
}		

 
 

}