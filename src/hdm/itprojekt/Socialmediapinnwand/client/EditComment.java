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
 * The Class EditComment.
 */
public class EditComment extends DialogBox{
	
	/** The Async obj. */
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	
	/** The comment id. */
	private int commentId;
	
	/** The c. */
	private Comment c = new Comment();
	
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
	Label headline = new Label("Kommentar bearbeiten");
	
	/** The content panel. */
	VerticalPanel contentPanel = new VerticalPanel();
	
	/** The wrap panel. */
	private final VerticalPanel wrapPanel = new VerticalPanel();
	
	/** The Button panel. */
	FlowPanel ButtonPanel = new FlowPanel();
	


	
	/**
	 * Instantiates a new edits the comment.
	 *
	 * @param commentId the comment id
	 */
	public EditComment(int commentId  ){
  
		this.commentId = commentId;  
		
		a.setGlassEnabled(true);
		a.show();
		a.center();
		this.c.setId(commentId);
		
		loadCommentsForEditPanel(commentId);
 		setWidget(wrapPanel);
	}

/**
 * Save comments for edit panel.
 *
 * @param c the c
 */
public void saveCommentsForEditPanel(Comment c) {
 
 	 
	//this.c.setId(commentId);
 	c.setText(editPost.getText());
  
 //	Window.alert("  " + c.getText() + "sadasda sd asd qa");
 //	Window.alert("  " + c.getId() + "id sd asd qa");
 	

	AsyncObj.saveCommentsForEdit(c , new  AsyncCallback<Void>(){
		
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
 * Load comments for edit panel.
 *
 * @param commentId the comment id
 * @return the comment
 */
public Comment loadCommentsForEditPanel( int commentId) {
	
	
	saveBtn.setStylePrimaryName("LoginButtonEditor");
	closeBtn.setStylePrimaryName("LoginButtonEditor");
	headline.setStylePrimaryName("Post_bar_headline");
	contentPanel.setStylePrimaryName("Post_bar_contentPanel");
	wrapPanel.setStylePrimaryName("Post_bar_wrapPanel");
	ButtonPanel.setStylePrimaryName("Post_bar_ButtonPanel");
	a.setStylePrimaryName("Post_bar_a");
	editPost.setStylePrimaryName("Post_bar_edit_textbox");
	
	
AsyncObj.loadCommentsForEdit(commentId, new  AsyncCallback<Comment>(){
	
	// count all einträge select
	@Override
	public void onFailure(Throwable caught) {
		Window.alert("Fehler aufgetreten");
	}
 
	@Override
	public void onSuccess(Comment result) {

		 
		 
		
		String b = result.getText();
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
				
				saveCommentsForEditPanel(c);
				
				a.hide();
				BoardPanel  np= new BoardPanel();
			        createOwnBoardByNicknamePanel bD =  np.new createOwnBoardByNicknamePanel(selectedNickname3); 
			       RootPanel.get("content_wrap").clear();
								RootPanel.get("content_wrap").add(bD);		
				
			}
			});	
		
	}
	});
 
return c ;
	
}		

 
 

}