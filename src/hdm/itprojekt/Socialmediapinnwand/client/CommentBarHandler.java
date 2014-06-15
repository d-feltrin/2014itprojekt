package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.client.BoardPanel.createOwnBoardByNicknamePanel;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Comment;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Post;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;
import java.util.Map;
import com.google.appengine.api.images.ImagesServicePb.ImagesCompositeRequest.Builder;
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
import com.google.gwt.user.client.ui.Widget;

public class CommentBarHandler   extends Composite implements ClickHandler {
	 
		private final AServiceAsync AsyncObj = GWT.create(AService.class);
		
 		private String authorNickname;
		private int counter;
		private int ownuserID;
		private int	postID;
		private int comment_userid;
		private int	commenId;
		private  String selectedNickname3 = Cookies.getCookie("SelectedListItem");
 		private String message; 
		//Comment c = new Comment();
		String test  = "fuck";

//DialogBox affe = new DialogBox(true);
		  
		FlowPanel fp = new FlowPanel();
 
	  	String sessionEditor = Cookies.getCookie("SessionUserNicknameEditor");
	  	//	String sessionSelectItem = Cookies.getCookie("SessionUserNicknameEditor");

	  	Button CoDeleteBtn    = new Button("d");
	  	Button CoEditBtn = new Button("e" );
	 
	  	
	  	
	  	 
 	
		// public PostBarHandler(int authorID, int ownuserID, int postID, int counter ) {
	 public CommentBarHandler(int commentid, int comment_userid, int ownuser){
			 
			 this.commenId=commentid;
			 this.ownuserID =ownuser;
			 this.comment_userid=comment_userid;
			   /* this.authorID = c.getUser_id();
 			    this.ownuserID = ownuser;
			    this.postID = p.getPId();
			    this.message = p.getPost();
 			  */
				  
			    
		//	  this.editPost.setPId(p.getPId());
			   /*  this.editPost.setPost(p.getPost());
			    this.editPost.setTimestamp(p.getTimestamp());
			    this.editPost.setPosr_id(p.getPId());
			    this.editPost.setUser_id(p.getUser_id());
				*/
			 

				if(ownuserID == comment_userid ){
					
				//	if(sessionEditor.toUpperCase().equals(selectedNickname3.toUpperCase())){
				 
				    fp.add(CoDeleteBtn);
				    fp.add(CoEditBtn);
				    CoDeleteBtn.addClickHandler(this);
				    CoEditBtn.addClickHandler(this);
				    CoDeleteBtn.setStylePrimaryName("PostDeleteBtn");
				    CoEditBtn.setStylePrimaryName("PostEditBtn");
					 
					fp.addStyleName("Postbar_buttons_Panel");
					initWidget(fp);
				}
				
				else {
			 
				     initWidget(fp);
				}
			  }
		 	
		 public CommentBarHandler() {
				 
		  }
		 
	 
			  
		 

			@Override
			public void onClick(ClickEvent event) {
					  
					Widget sender = (Widget) event.getSource();
					  
			  if (sender == CoDeleteBtn) {
				 		   
					  AsyncObj.deleteCommentsByCommentID(commenId , new  AsyncCallback<Void>(){
							// count all einträge select
							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
							}
							@Override
							public void onSuccess(Void result) {
								// TODO Auto-generated method stub
						 		 Window.alert("Das neue Kommentar   ist gelöscht ");
						 		BoardPanel  np= new BoardPanel();
						 		   createOwnBoardByNicknamePanel bD =  np.new createOwnBoardByNicknamePanel(selectedNickname3); 
	 						       RootPanel.get("content_wrap").clear();
	 											RootPanel.get("content_wrap").add(bD);
							}
							}); 	
					   
					  
					  
					  
										 
										  
									  }
					  
				  else if (sender == CoEditBtn) {
					 
					  
					  EditComment a = new EditComment(commenId );

										   
 										 
										  
									  }
					  
					  
			}

			public String getAuthorNickname() {
				return authorNickname;
			}

			public void setAuthorNickname(String authorNickname) {
				this.authorNickname = authorNickname;
			}
	
}