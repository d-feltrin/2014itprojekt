package hdm.itprojekt.Socialmediapinnwand.client.gui;

import java.io.Serializable;
import java.util.ArrayList;
import hdm.itprojekt.Socialmediapinnwand.client.AService;
import hdm.itprojekt.Socialmediapinnwand.client.AServiceAsync;
import hdm.itprojekt.Socialmediapinnwand.client.CreateUser;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.BusinessObject;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.OwnStringObject;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class OneUserByOneInfoObjects extends VerticalPanel  implements Serializable {
    private static final long serialVersionUID = 5744986706947752922L;

	private final AServiceAsync AsyncObj = GWT.create(AService.class);
 
	final HorizontalPanel reportHorPanel = new HorizontalPanel();
	
	final VerticalPanel reportVertPanel1Tab = new VerticalPanel();
	final VerticalPanel reportVertPanel2Tab = new VerticalPanel();
	
	final FlexTable report5Table = new FlexTable();
	final Label report2Headline = new Label(
			"Folgender User ist selektiert:");
	
 	ListBox ListOfNicknames = new ListBox();
	 
	public void onLoad() {
		
		reportVertPanel1Tab.add(report2Headline);
		reportVertPanel1Tab.add(ListOfNicknames);
 		reportHorPanel.add(reportVertPanel1Tab);

		reportHorPanel.add(reportVertPanel2Tab);
		RootPanel.get("content_wrap").add(reportHorPanel);
 
		reportVertPanel1Tab.setStylePrimaryName("OneOneReportVpanel1");
		reportVertPanel2Tab.setStylePrimaryName("OneOneReportVpanel2");
		reportHorPanel.setStylePrimaryName("reportHorPanelVp");

		report2Headline.setStylePrimaryName("oneoneHeadline");

		// Dropdown aller vorhandenen User anzeigen
			ListOfNicknames.addItem("User ausw�hlen");
			 ListOfNicknames.setSize("200px", "35px");
			 ListOfNicknames.addStyleName("ListOfNicknames2");
			 ListOfNicknames.getSelectedIndex();
			 
			 reportVertPanel2Tab.add(report5Table);
			 
				report5Table.setText(0, 0, "Anzahl Abos");
				report5Table.setText(0, 1, "Anzahl Beiträge");
				report5Table.setText(0, 2, "Anzahl Kommentare");
				report5Table.setText(0, 3, "Anzahl Likes");
			 
 	AsyncObj.getAllUsers(new AsyncCallback<ArrayList<User>>() {
				
		@Override
		public void onSuccess(ArrayList<User> result) {

			for (int i = 0; i < result.size(); i++) {

				ListOfNicknames.addItem(result.get(i).getNickname());
				 
			}
			
			ListOfNicknames.addChangeHandler(new ChangeHandler() {
			public void onChange(ChangeEvent event) {
				ShowUserFromSelectedItem(ListOfNicknames, ListOfNicknames.getSelectedIndex());
				report5Table.clear();
			
			}
			
			public void ShowUserFromSelectedItem(ListBox listOfNicknames, int selectedIndex) {
				// TODO Auto-generated method stub
				 
				String selectedNickname; 
				selectedNickname =  listOfNicknames.getItemText(selectedIndex);
 
				 AsyncObj.getOneUserIdByNickname(  selectedNickname, new AsyncCallback<User>() {
		  
						@Override
						 public void onSuccess(User result) {
							
 							Integer user_id = result.getId();
									
						 
 							
 							
 						/*	
 							
 							
 							AsyncObj.getAllPostsAndLikesByOneUserIdAndCount(user_id,new AsyncCallback<Integer>() {
										@Override
										public void onFailure(Throwable caught) {

										}

										@Override
										public void onSuccess(Integer result) {
											report5Table.clear(); 
											Window.alert("22----"+result);
											report5Table.setWidget(1, 0, new Label(String.valueOf(result)));
										}
							}); 
						 	
						 	
						 	
 							
 							AsyncObj.getAllCommentsByOneUserIdAndCount(user_id,new AsyncCallback<Integer>() {
										@Override
										public void onFailure(Throwable caught) {

										}

										@Override
										public void onSuccess(Integer result) {
											report5Table.clear(); 
											Window.alert("22----"+result);
											report5Table.setWidget(1, 0, new Label(String.valueOf(result)));
										}
							}); 
 							
 							
 							
 							AsyncObj.getAllSubscriptionsByOneUserIdAndCount(user_id,new AsyncCallback<Integer>() {
										@Override
										public void onFailure(Throwable caught) {

										}

										@Override
										public void onSuccess(Integer result) {
											report5Table.clear(); 
											Window.alert("22----"+result);
											report5Table.setWidget(1, 0, new Label(String.valueOf(result)));
										}
							}); 
 							*/
 							
 							
 							
 							AsyncObj.getAllPostsByOneUserIdAndCount(user_id,new AsyncCallback<Integer>() {
										@Override
										public void onFailure(Throwable caught) {

										}

										@Override
										public void onSuccess(Integer result) {
											report5Table.clear(); 
											Window.alert("22----"+result);
											report5Table.setWidget(1, 0, new Label(String.valueOf(result)));
										}
							}); 
						 	
						 	
						 	
						 	
						 	
						 	
						 	
						 	
						 	
						 	
						 	
						 	
						} 
	
						@Override
						public void onFailure(Throwable caught) {
							Window.alert("asdasd");
						}

				 }
						 );	
			
			}
						
			});			
			
		//	ListOfNicknames.getSelectedIndex();
		//	wenn selectet item dann As AsyncObj
		}

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Konnte keine User finden");
		}
	});				
	 
}

}