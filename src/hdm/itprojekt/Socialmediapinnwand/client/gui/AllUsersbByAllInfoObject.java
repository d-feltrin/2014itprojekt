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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class AllUsersbByAllInfoObject extends VerticalPanel{
	
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	 
 		final HorizontalPanel reportHoriPanel1Tab = new HorizontalPanel();
		final VerticalPanel aboVp = new VerticalPanel();
		final VerticalPanel postVp = new VerticalPanel();
		final VerticalPanel CommentsVp = new VerticalPanel();
		final VerticalPanel likesVp = new VerticalPanel();
		final Label postVpHeadline = new Label("2Meisten Beiträge");
		final Label postVpSubline = new Label("In diesem Ranking werden Ihnen die User sortiert angezeigt, die am Meisten Beiträge verfasst haben. ");
		final Label aboVpHeadline = new Label("Meisten Abos");
		final Label aboVpSubline = new Label("In diesem Ranking werden Ihnen die User sortiert angezeigt, die am Meisten Beiträge verfasst haben. ");
		final Label likeVpHeadline = new Label("Meisten Likes");
		final Label likeVpSubline = new Label("In diesem Ranking werden Ihnen die User sortiert angezeigt, die am Meisten Beiträge verfasst haben. ");
		final Label commentVpHeadline = new Label("Meisten Kommentare");
		final Label commentVpSubline = new Label("In diesem Ranking werden Ihnen die User sortiert angezeigt, die am Meisten Beiträge verfasst haben. ");
	
		final FlexTable report1Table = new FlexTable();
		final FlexTable report2Table = new FlexTable();
		final FlexTable report3Table = new FlexTable();
		final FlexTable report4Table = new FlexTable();
		
		  private Integer  zaehlerFlexTable1 = 1;
		  private Integer  zaehlerFlexTable2 = 1;
		  private Integer  zaehlerFlexTable3 = 1;
		  private Integer  zaehlerFlexTable4 = 1;
				
		public void onLoad() {
			super.onLoad();
			//aboVp.add(report1Table);
			
			postVp.add(postVpHeadline);
			postVp.add(postVpSubline);
			postVp.add(report1Table);
			
			aboVp.add(aboVpHeadline);
			aboVp.add(aboVpSubline);
			aboVp.add(report2Table);
			
			CommentsVp.add(commentVpHeadline);
			CommentsVp.add(commentVpSubline);
			CommentsVp.add(report3Table);
			
			likesVp.add(likeVpHeadline);
			likesVp.add(likeVpSubline);
			likesVp.add(report4Table);
			
			//CommentsVp.add(report1Table);
			//likesVp.add(report1Table);

			loadTableAllUserAllPosts();
			loadTableAllUserAllSubscription ();
			loadTableAllUserComments();
			loadTableAllUserAllLikes ();
			
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
		
		public void loadTableAllUserAllPosts (){
			 
 			final ArrayList<String> report1ArrayList = new ArrayList<String>();
			AsyncObj.getAllUsers(  new AsyncCallback<ArrayList<User>>() {
				//int firstRowSPL = 1;
				@Override
				public void onSuccess(ArrayList<User> result) {
					//report1Table.remove(report1Table);
					if (result != null) {
					int firstRow = 1;
					report1Table.setText(0, 0, "Nickname");
					report1Table.setText(0, 1, "Anzahl Beiträge");
					for (int i = 0; i < result.size()  ; i++) {
						
						User u = new User();
						u.setUserId(result.get(i).getUserId()) ;
 						AsyncObj.getPostsByUserId( u.getUserId(),
								new AsyncCallback<Integer>() {
									@Override
									public void onFailure(Throwable caught) {

									}

									@Override
									public void onSuccess(Integer result) {
										report1Table.setWidget(zaehlerFlexTable1, 1, new Label(
												String.valueOf(result)));
										zaehlerFlexTable1 ++;
									}
								});
		 
						report1Table.setWidget(firstRow, 0, new Label(result.get(i).getNickname()));
					 
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
		
		public void loadTableAllUserAllLikes (){
			 
 			final ArrayList<String> report1ArrayList = new ArrayList<String>();
			AsyncObj.getAllUsers(  new AsyncCallback<ArrayList<User>>() {
				//int firstRowSPL = 1;
				@Override
				public void onSuccess(ArrayList<User> result) {
					//report1Table.remove(report1Table);
					if (result != null) {
					int firstRow = 1;
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

		}
		
}