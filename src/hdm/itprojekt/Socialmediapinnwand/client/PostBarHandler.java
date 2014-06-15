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

public class PostBarHandler   extends Composite implements ClickHandler {
	 
		private final AServiceAsync AsyncObj = GWT.create(AService.class);
		
		private int authorID;
		private String authorNickname;
		private int counter;
		private int ownuserID;
		private int	postID;
		private int	commenId;
		private  String selectedNickname3 = Cookies.getCookie("SelectedListItem");
 		private String message; 
		//Comment c = new Comment();
		String test  = "fuck";

//DialogBox affe = new DialogBox(true);
		  
		FlowPanel fp = new FlowPanel();
 
	  	String sessionEditor = Cookies.getCookie("SessionUserNicknameEditor");
	  	//	String sessionSelectItem = Cookies.getCookie("SessionUserNicknameEditor");

	  	Button PostDeleteBtn    = new Button("d");
	  	Button PostEditBtn = new Button("e" );
	  	Button PostLikeBtn = new Button("+");
	  	Button PostCommentBtn = new Button("c");
	  	
	  	
	  	Button CoDeleteBtn    = new Button("d");
	  	Button CoEditBtn = new Button("e" );
	
		// public PostBarHandler(int authorID, int ownuserID, int postID, int counter ) {
			 public PostBarHandler(Post p, int ownuser ) {
				 

			    this.authorID = p.getPosr_id();
			    this.counter = p.getLike();
			    this.ownuserID = ownuser;
			    this.postID = p.getPId();
			    this.message = p.getPost();
 			  
				  
			    
		//	  this.editPost.setPId(p.getPId());
			   /*  this.editPost.setPost(p.getPost());
			    this.editPost.setTimestamp(p.getTimestamp());
			    this.editPost.setPosr_id(p.getPId());
			    this.editPost.setUser_id(p.getUser_id());
				*/
			 

				if(authorID == ownuserID ){
					
				//	if(sessionEditor.toUpperCase().equals(selectedNickname3.toUpperCase())){
					fp.add(PostLikeBtn);
					fp.add(PostCommentBtn);
					PostLikeBtn.addClickHandler(this);
					PostCommentBtn.addClickHandler(this);
				    fp.add(PostEditBtn);
				    fp.add(PostDeleteBtn);
				    PostDeleteBtn.addClickHandler(this);
				    PostEditBtn.addClickHandler(this);
					PostDeleteBtn.setStylePrimaryName("PostDeleteBtn");
					PostEditBtn.setStylePrimaryName("PostEditBtn");
					PostLikeBtn.setStylePrimaryName("PostLikeBtn");
					PostCommentBtn.setStylePrimaryName("PostCommentBtn");
					fp.addStyleName("Postbar_buttons_Panel");
					initWidget(fp);
				}
				
				else {
				    fp.add(PostLikeBtn);
				    fp.add(PostCommentBtn);
				    PostLikeBtn.addClickHandler(this);
				    PostCommentBtn.addClickHandler(this);
					PostLikeBtn.setStylePrimaryName("PostLikeBtn");
					PostCommentBtn.setStylePrimaryName("PostCommentBtn");
					 fp.addStyleName("Postbar_buttons_Panel");
				     initWidget(fp);
				}
			  }
		 	
		 public PostBarHandler() {
				 
		  }
		 
		 public PostBarHandler(int commentid){
			 
			 this.commenId=commentid;
			 
			 
			 
			 
		 }
			  
			  /*public String ShowNickname(int authorID ){
				  AsyncObj.getOneNicknameFromUserId(authorID, new  AsyncCallback<String>(){
						// count all einträge select
						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
						}
					 
						@Override
						public void onSuccess(String result) {

							String u ; 
							u = result;
							setAuthorNickname(u);
					 
							Window.alert(authorNickname);
						}
						});
				  
				  return authorNickname;
				 
			  }
		 
			 */

			@Override
			public void onClick(ClickEvent event) {
					  
					Widget sender = (Widget) event.getSource();
					  
					  if (sender == PostDeleteBtn) {	
							 AsyncObj.deletePostByPostid (postID, new  AsyncCallback<Void>(){
									// count all einträge select
									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
									}
									@Override
									public void onSuccess(
											Void result) {
								 		 Window.alert("Der Beitrag wurde gelöscht");
								  		BoardPanel  np= new BoardPanel();
								 		   createOwnBoardByNicknamePanel bD =  np.new createOwnBoardByNicknamePanel(selectedNickname3); 
			 						       RootPanel.get("content_wrap").clear();
			 											RootPanel.get("content_wrap").add(bD);
									}  
							 });
					} 
				  
				  else if (sender == PostEditBtn) {
	 
			 
				 
			 	  //Object Post konnte nicht eindeutig instaziert werden daher mussten wir das Objekt in einzelne Parameter zulegen und in der Edit Post Klasse wieder zusammenbauen
					  
					  EditPost a = new EditPost(postID, counter, ownuserID, authorID, message );
					
					  
					  
					  
					  //initWidget(a);
					
					// affe.show();
		  
				  }
				  else if (sender == PostLikeBtn) {
 				  		 	counter++;
				  			AsyncObj.setLikePostIterator(counter,postID, new  AsyncCallback<Void>(){
									// count all einträge select
									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
									}
									@Override
									public void onSuccess(Void result) {
										// TODO Auto-generated method stub
							 
								 		BoardPanel  np= new BoardPanel();
								 		   createOwnBoardByNicknamePanel bD =  np.new createOwnBoardByNicknamePanel(selectedNickname3); 
			 						       RootPanel.get("content_wrap").clear();
			 											RootPanel.get("content_wrap").add(bD);
								 		 
									}
							}); 
				  					
				}
				  
				  else if (sender == PostCommentBtn) {
 
					   
				   CreateComment ab = new CreateComment(postID);
					 
					  
				  }
				  else if (sender == CoDeleteBtn) {
				 		   
					  AsyncObj.deleteCommentsByCommentID(commenId , new  AsyncCallback<Void>(){
							// count all einträge select
							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
							}
							@Override
							public void onSuccess(Void result) {
								// TODO Auto-generated method stub
						 		 Window.alert("Das neue Kommentar wu ist weg");
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