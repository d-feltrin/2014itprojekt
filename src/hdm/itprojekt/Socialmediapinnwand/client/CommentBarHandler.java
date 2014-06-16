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

// TODO: Auto-generated Javadoc
/**
 * The Class CommentBarHandler.
 */
public class CommentBarHandler   extends Composite implements ClickHandler {
	 
		/** The Async obj. */
		private final AServiceAsync AsyncObj = GWT.create(AService.class);
		
 		/** The author nickname. */
		 private String authorNickname;
		
		/** The counter. */
		private int counter;
		
		/** The ownuser id. */
		private int ownuserID;
		
		/** The post id. */
		private int	postID;
		
		/** The comment_userid. */
		private int comment_userid;
		
		/** The commen id. */
		private int	commenId;
		
		/** The selected nickname3. */
		private  String selectedNickname3 = Cookies.getCookie("SelectedListItem");
 		
		 /** The message. */
		 private String message; 
		//Comment c = new Comment();
		/** The test. */
		String test  = "fuck";

//DialogBox affe = new DialogBox(true);
		  
		/** The fp. */
FlowPanel fp = new FlowPanel();
 
	  	/** The session editor. */
	  	String sessionEditor = Cookies.getCookie("SessionUserNicknameEditor");
	  	//	String sessionSelectItem = Cookies.getCookie("SessionUserNicknameEditor");

	  	/** The Co delete btn. */
	  	Button CoDeleteBtn    = new Button("d");
	  	
	  	/** The Co edit btn. */
	  	Button CoEditBtn = new Button("e" );
	 
	  	
	  	
	  	 
 	
		// public PostBarHandler(int authorID, int ownuserID, int postID, int counter ) {
	 /**
		 * Instantiates a new comment bar handler.
		 *
		 * @param commentid the commentid
		 * @param comment_userid the comment_userid
		 * @param ownuser the ownuser
		 */
		public CommentBarHandler(int commentid, int comment_userid, int ownuser){
			 
			 this.commenId=commentid;
			 this.ownuserID =ownuser;
			 this.comment_userid=comment_userid;
		 

				if(ownuserID == comment_userid ){
				 
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
		 	
		 /**
 		 * Instantiates a new comment bar handler.
 		 */
 		public CommentBarHandler() {
				 
		  }
		 
	 
			  
		 

			/* (non-Javadoc)
			 * @see com.google.gwt.event.dom.client.ClickHandler#onClick(com.google.gwt.event.dom.client.ClickEvent)
			 */
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

			/**
			 * Gets the author nickname.
			 *
			 * @return the author nickname
			 */
			public String getAuthorNickname() {
				return authorNickname;
			}

			/**
			 * Sets the author nickname.
			 *
			 * @param authorNickname the new author nickname
			 */
			public void setAuthorNickname(String authorNickname) {
				this.authorNickname = authorNickname;
			}
	
}