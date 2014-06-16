package hdm.itprojekt.Socialmediapinnwand.client.gui;

import java.util.ArrayList;
import hdm.itprojekt.Socialmediapinnwand.client.AService;
import hdm.itprojekt.Socialmediapinnwand.client.AServiceAsync;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class AllUsersbByAllInfoObject.
 */
public class AllUsersbByAllInfoObject extends VerticalPanel{
	
	/** The Async obj. */
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	 
 		/** The report hori panel1 tab. */
		 final HorizontalPanel reportHoriPanel1Tab = new HorizontalPanel();
		
		/** The abo vp. */
		final VerticalPanel aboVp = new VerticalPanel();
		
		/** The post vp. */
		final VerticalPanel postVp = new VerticalPanel();
		
		/** The Comments vp. */
		final VerticalPanel CommentsVp = new VerticalPanel();
		
		/** The likes vp. */
		final VerticalPanel likesVp = new VerticalPanel();
		
		/** The post vp headline. */
		final Label postVpHeadline = new Label("2Meisten Beiträge");
		
		/** The post vp subline. */
		final Label postVpSubline = new Label("In diesem Ranking werden Ihnen die User sortiert angezeigt, die am Meisten Beiträge verfasst haben. ");
		
		/** The abo vp headline. */
		final Label aboVpHeadline = new Label("Meisten Abos");
		
		/** The abo vp subline. */
		final Label aboVpSubline = new Label("In diesem Ranking werden Ihnen die User sortiert angezeigt, die am Meisten Beiträge verfasst haben. ");
		
		/** The like vp headline. */
		final Label likeVpHeadline = new Label("Meisten Likes");
		
		/** The like vp subline. */
		final Label likeVpSubline = new Label("In diesem Ranking werden Ihnen die User sortiert angezeigt, die am Meisten Beiträge verfasst haben. ");
		
		/** The comment vp headline. */
		final Label commentVpHeadline = new Label("Meisten Kommentare");
		
		/** The comment vp subline. */
		final Label commentVpSubline = new Label("In diesem Ranking werden Ihnen die User sortiert angezeigt, die am Meisten Beiträge verfasst haben. ");
		
		/** The first row. */
		int firstRow;
		
		/** The report1 table. */
		final FlexTable report1Table = new FlexTable();
		
		/** The report2 table. */
		final FlexTable report2Table = new FlexTable();
		
		/** The report3 table. */
		final FlexTable report3Table = new FlexTable();
		
		/** The report4 table. */
		final FlexTable report4Table = new FlexTable();
		
		/** The u. */
		private User u = new User();
		
		/** The ab. */
		String  ab; 
		    
    		/** The zaehler flex table1. */
    		private Integer  zaehlerFlexTable1 = 1;
		    
    		/** The html. */
    		HTML html = new HTML ();
		    
    		/** The userid_count_posts. */
    		int userid_count_posts;
		      
      		/** The ua. */
      		User ua = new User();
		      
      		/** The ua1. */
      		User ua1 = new User();
		      
      		/** The ua2. */
      		User ua2 = new User();
		      
      		/** The ua3. */
      		User ua3 = new User();
		  
  		/** The zaehler flex table2. */
  		private Integer  zaehlerFlexTable2 = 1;
		  
  		/** The zaehler flex table3. */
  		private Integer  zaehlerFlexTable3 = 1;
		  
  		/** The zaehler flex table4. */
  		private Integer  zaehlerFlexTable4 = 1;
				
		/* (non-Javadoc)
		 * @see com.google.gwt.user.client.ui.Widget#onLoad()
		 */
		public void onLoad() {
			super.onLoad();
			//aboVp.add(report1Table);
			loadTableAllUserAllPosts();
			loadTableAllUserComments();
			loadTableAllUserAllSubscription();
			loadTableAllUserAllLikes();
			postVp.add(postVpHeadline);
			postVp.add(postVpSubline);
			
			//postVp.add(loadTableAllUserAllPosts());
			
			aboVp.add(aboVpHeadline);
			aboVp.add(aboVpSubline);
		//	aboVp.add(report2Table);
			
			CommentsVp.add(commentVpHeadline);
			CommentsVp.add(commentVpSubline);
		//	CommentsVp.add(report3Table);
			
			likesVp.add(likeVpHeadline);
			likesVp.add(likeVpSubline);
		//	likesVp.add(report4Table);
			
			//CommentsVp.add(report1Table);
			//likesVp.add(report1Table);

			//loadTableAllUserAllPosts();
	//		loadTableAllUserAllSubscription ();
		//	loadTableAllUserComments();
		//	loadTableAllUserAllLikes ();
			
			reportHoriPanel1Tab.add(aboVp);
			reportHoriPanel1Tab.add(postVp);
			reportHoriPanel1Tab.add(CommentsVp);
			reportHoriPanel1Tab.add(likesVp);
	
			likeVpHeadline.setStylePrimaryName("likeVpHeadline");
			likeVpSubline.setStylePrimaryName("likeVpSubline");
			
			commentVpHeadline.setStylePrimaryName("commentVpHeadline");
			commentVpSubline.setStylePrimaryName("commentVpSubline");
			
			postVpHeadline.setStylePrimaryName("postVpHeadline");
			postVpSubline.setStylePrimaryName("postVpSubline");
			
			aboVpHeadline.setStylePrimaryName("aboVpHeadline");
			aboVpSubline.setStylePrimaryName("aboVpSubline");
			
			aboVp.setStylePrimaryName("aboVp");
			postVp.setStylePrimaryName("postVp");
			CommentsVp.setStylePrimaryName("CommentsVp");
			likesVp.setStylePrimaryName("likesVp");
			
			reportHoriPanel1Tab.setStylePrimaryName("reportHoriPanel1Tab");
			
 		report1Table.addStyleName("report1Table");
 		report2Table.addStyleName("report2Table");
		report3Table.addStyleName("report3Table");
		report4Table.addStyleName("report4Table");
	//		report1Table.getRowFormatter().addStyleName(0,"FlexTable-Header");
			
  			RootPanel.get("content_wrap").add(reportHoriPanel1Tab);
			
			
 		/*	 vEditor.setStylePrimaryName("LoginPanelLeft");
 		    vReport.setStylePrimaryName("LoginPanelRight");
 		    

 		    vEditorHeadline.addStyleName("LoginHeadlineEditor");
 		    vReportHeadline.addStyleName("LoginHeadlineReport");
 		    
 		    vEditorSubline.addStyleName("LoginSublineEditor");
 		    vReportSubline.addStyleName("LoginSublineReport");
				
			*/
	}
		
		/**
		 * Load table all user all posts.
		 */
		public void loadTableAllUserAllPosts (){
			 
 			AsyncObj.getAllUsers(  new AsyncCallback<ArrayList<User>>() {
				//int firstRowSPL = 1;
				@Override
				public void onSuccess(ArrayList<User> result) {
					for (int i = 0; i < result.size()  ; i++) {
						 HorizontalPanel hP = new HorizontalPanel();
						 FlexTable dP = new FlexTable();
						 ua.setNickname(result.get(i).getNickname()) ;
						 ua.setUserId(result.get(i).getUserId()) ;
						// Neuer Counter für FlexTable
						  Counter cO = new Counter( );
						  hP.add(cO.getPostsByUserId(ua.getUserId(), ua.getNickname() ));
						  // Hier adden wir das p dem Postpanel
						  postVp.add(hP);
						}
					 
										
				}

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Konnte keine User finden");
				}
			});

		}
		
		
		/**
		 * Load table all user all subscription.
		 */
		public void loadTableAllUserAllSubscription (){
			 
 			AsyncObj.getAllUsers(  new AsyncCallback<ArrayList<User>>() {
				//int firstRowSPL = 1;
				@Override
				public void onSuccess(ArrayList<User> result) {
					for (int i = 0; i < result.size()  ; i++) {
						 HorizontalPanel hP = new HorizontalPanel();
						 FlexTable dP = new FlexTable();
						 ua1.setNickname(result.get(i).getNickname()) ;
						 ua1.setUserId(result.get(i).getUserId()) ;
						// Neuer Counter für FlexTable
						  Counter cO = new Counter( );
						  hP.add(cO.getSubscriptionsByUserId(ua1.getUserId(), ua1.getNickname() ));
						  // Hier adden wir das p dem Postpanel
						  aboVp.add(hP);
						}
					 
										
				}

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Konnte keine User finden");
				}
			});

		}	
		
		/**
		 * Load table all user comments.
		 */
		public void loadTableAllUserComments (){
			 
 			AsyncObj.getAllUsers(  new AsyncCallback<ArrayList<User>>() {
				//int firstRowSPL = 1;
				@Override
				public void onSuccess(ArrayList<User> result) {
					for (int i = 0; i < result.size()  ; i++) {
						 HorizontalPanel hP = new HorizontalPanel();
						 FlexTable dP = new FlexTable();
						 ua2.setNickname(result.get(i).getNickname()) ;
						 ua2.setUserId(result.get(i).getUserId()) ;
						// Neuer Counter für FlexTable
						  Counter cO = new Counter( );
						  hP.add(cO.getCommentsByUserId(ua2.getUserId(), ua2.getNickname() ));
						  // Hier adden wir das p dem Postpanel
						  CommentsVp.add(hP);
						}
					 
										
				}

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Konnte keine User finden");
				}
			});

		}	
		
		
		
		
		/**
		 * Load table all user all likes.
		 */
		public void loadTableAllUserAllLikes (){
			 
 			AsyncObj.getAllUsers(  new AsyncCallback<ArrayList<User>>() {
				//int firstRowSPL = 1;
				@Override
				public void onSuccess(ArrayList<User> result) {
					for (int i = 0; i < result.size()  ; i++) {
						 HorizontalPanel hP = new HorizontalPanel();
						 FlexTable dP = new FlexTable();
						 ua3.setNickname(result.get(i).getNickname()) ;
						 ua3.setUserId(result.get(i).getUserId()) ;
						// Neuer Counter für FlexTable
						  Counter cO = new Counter( );
						  hP.add(cO.getAllLikesByUserId(ua3.getUserId(), ua3.getNickname() ));
						  // Hier adden wir das p dem Postpanel
						  likesVp.add(hP);
						}
					 
										
				}

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Konnte keine User finden");
				}
			});

		}	
		
		
		
		
		
		
		 
		
		
		
		
		
		
		
		
		
	 
		 
		/*
		public void loadTableAllUserAllSubscription(){
			 
 			final ArrayList<String> report1ArrayList = new ArrayList<String>();
			AsyncObj.getAllUsers(  new AsyncCallback<ArrayList<User>>() {
				//int firstRowSPL = 1;
				@Override
				public void onSuccess(ArrayList<User> result) {
					//report1Table.remove(report1Table);
					if (result != null) {
					int firstRow = 1;
					report2Table.setText(0, 0, "Nickname");
					report2Table.setText(0, 1, "Anzahl Abos");
					for (int i = 0; i < result.size()  ; i++) {
						
						User reportUser = result.get(i);
						
						AsyncObj.getSubscriptionByUserId (
								reportUser.getUserId(),
								new AsyncCallback<Integer>() {
									@Override
									public void onFailure(Throwable caught) {

									}

									@Override
									public void onSuccess(Integer result) {
										report2Table.setWidget(zaehlerFlexTable2, 1, new Label(
												String.valueOf(result)));
										zaehlerFlexTable2 ++;
									}
								});
		 
						report2Table.setWidget(firstRow, 0, new Label(result.get(i). getNickname()));
					 
						firstRow++;
						}
					}
										
				}

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Konnte keine User finden");

				}
			});

		}
		*/ 
		/*
		public void loadTableAllUserComments (){
			 
 			final ArrayList<String> report1ArrayList = new ArrayList<String>();
			AsyncObj.getAllUsers(  new AsyncCallback<ArrayList<User>>() {
				//int firstRowSPL = 1;
				@Override
				public void onSuccess(ArrayList<User> result) {
					//report1Table.remove(report1Table);
					if (result != null) {
					int firstRow = 1;
					report3Table.setText(0, 0, "Nickname");
					report3Table.setText(0, 1, "Anzahl Kommentare");
					for (int i = 0; i < result.size()  ; i++) {
						
						User reportUser = result.get(i);
						
						AsyncObj.getCommentsByUserId(
								reportUser.getUserId(),
								new AsyncCallback<Integer>() {
									@Override
									public void onFailure(Throwable caught) {

									}

									@Override
									public void onSuccess(Integer result) {
										report2Table.setWidget(zaehlerFlexTable3, 1, new Label(
												String.valueOf(result)));
										zaehlerFlexTable3 ++;
									}
								});
		 
						report3Table.setWidget(firstRow, 0, new Label(result.get(i). getNickname()));
					 
						firstRow++;
						}
					}
										
				}

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Konnte keine User finden");

				}
			});

		}
		*/
		
		/*
		public void loadTableAllUserAllLikes (){
			 
 			final ArrayList<String> report1ArrayList = new ArrayList<String>();
			AsyncObj.getAllUsers(  new AsyncCallback<ArrayList<User>>() {
				//int firstRowSPL = 1;
				@Override
				public void onSuccess(ArrayList<User> result) {
					//report1Table.remove(report1Table);
					if (result != null) {
						firstRow = 1;
					report4Table.setText(0, 0, "Nickname");
					report4Table.setText(0, 1, "Anzahl Abos");
					for (int i = 0; i < result.size()  ; i++) {
						
						User reportUser = result.get(i);
						
						AsyncObj.getLikesByUserId(
								reportUser.getUserId(),
								new AsyncCallback<Integer>() {
									@Override
									public void onFailure(Throwable caught) {

									}

									@Override
									public void onSuccess(Integer result) {
										report2Table.setWidget(zaehlerFlexTable4, 1, new Label(
												String.valueOf(result)));
										zaehlerFlexTable4 ++;
									} 
								});
		 
						report4Table.setWidget(firstRow, 0, new Label(result.get(i). getNickname()));
					 
						firstRow++;
						}
					}
										
				}

				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Konnte keine User finden");

				}
			});

		}*/
		
}