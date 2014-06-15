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

public class CreateComment extends DialogBox{
	
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	private int postId;
 private Comment p = new Comment();
 
//	int left = Window.getClientWidth() /2;
//	int top = Window.getClientHeight() /2;
	
	private  String selectedNickname3 = Cookies.getCookie("SelectedListItem");

	DialogBox a = new DialogBox(true); 
	Button saveBtn = new Button("Speichern");
	Button closeBtn = new Button("Abbrechen");
	TextArea editPost = new TextArea();

	Label headline = new Label("Kommentar schreiben  ");
	
	VerticalPanel contentPanel = new VerticalPanel();
	
	private final VerticalPanel wrapPanel = new VerticalPanel();
	
	FlowPanel ButtonPanel = new FlowPanel();
//	Cookies.getCookie("SessionBoardID", String.valueOf(result.getBoardId()));
			  
	 
	
	 
	 
	 int foo;
	 
	public CreateComment(int postID   ){
		 
		a.setGlassEnabled(true);
		a.show();
		a.center();
		this.postId=postID;
		
		showCreateCommentPanel(postId, foo);
	} 

 

public void saveCommentForPanel(int postId, int foo) {
		
		//Window.alert("  " + c.getText() + "Post-Test");
	 	//Window.alert("  " + c.getId() + "PostId-Test");

	 final String a2  ; 

 
	 	 
	/*
	AsyncObj.getOneUserIdByNickname(a2 , new  AsyncCallback<User>(){

		@Override
		public void onFailure(Throwable caught) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSuccess(User result) {
			// TODO Auto-generated method stub
			
		}
		
		// count all einträge select
		 
	 
		});
	
	
	*/
	a2 = Cookies.getCookie("SessionUserIDEditor" ); 
	 foo=Integer.parseInt(a2);
	 
	 	p.setText(editPost.getText());
	 	p.setPost_id(postId);
	 	p.setUser_id(foo);
	  
//		Window.alert("  " + p.getPost() + "sadasda sd asd qa");
	 //	Window.alert("  " + a.getPId() + "sadasda sd asd qa");
	 	

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