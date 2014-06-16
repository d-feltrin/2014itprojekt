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

public class AllUsersbByAllInfoObject extends VerticalPanel {

	private final AServiceAsync AsyncObj = GWT.create(AService.class);

	final HorizontalPanel reportHoriPanel1Tab = new HorizontalPanel();
	final VerticalPanel aboVp = new VerticalPanel();
	final VerticalPanel postVp = new VerticalPanel();
	final VerticalPanel CommentsVp = new VerticalPanel();
	final VerticalPanel likesVp = new VerticalPanel();
	final Label postVpHeadline = new Label("2Meisten Beiträge");
	final Label postVpSubline = new Label(
			"In diesem Ranking werden Ihnen die User sortiert angezeigt, die am Meisten Beiträge verfasst haben. ");
	final Label aboVpHeadline = new Label("Meisten Abos");
	final Label aboVpSubline = new Label(
			"In diesem Ranking werden Ihnen die User sortiert angezeigt, die am Meisten Beiträge verfasst haben. ");
	final Label likeVpHeadline = new Label("Meisten Likes");
	final Label likeVpSubline = new Label(
			"In diesem Ranking werden Ihnen die User sortiert angezeigt, die am Meisten Beiträge verfasst haben. ");
	final Label commentVpHeadline = new Label("Meisten Kommentare");
	final Label commentVpSubline = new Label(
			"In diesem Ranking werden Ihnen die User sortiert angezeigt, die am Meisten Beiträge verfasst haben. ");

	final FlexTable report1Table = new FlexTable();
	final FlexTable report2Table = new FlexTable();
	final FlexTable report3Table = new FlexTable();
	final FlexTable report4Table = new FlexTable();
	private Integer firstRow1 = 1;
	private Integer zaehlerFlexTable1 = 1;
	private User u = new User();

	private Integer zaehlerFlexTable2 = 1;
	private Integer zaehlerFlexTable3 = 1;
	private Integer zaehlerFlexTable4 = 1;

	public void onLoad() {
		super.onLoad();
		// aboVp.add(report1Table);

		postVp.add(postVpHeadline);
		postVp.add(postVpSubline);
		

		aboVp.add(aboVpHeadline);
		aboVp.add(aboVpSubline);
		aboVp.add(report2Table);

		CommentsVp.add(commentVpHeadline);
		CommentsVp.add(commentVpSubline);
		CommentsVp.add(report3Table);

		likesVp.add(likeVpHeadline);
		likesVp.add(likeVpSubline);
		likesVp.add(report4Table);

		 CommentsVp.add(report1Table);
		 likesVp.add(report1Table);

		loadTableAllUserAllPosts();
		// loadTableAllUserAllSubscription ();
		// loadTableAllUserComments();
		// loadTableAllUserAllLikes ();

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
		postVp.add(report1Table);

		reportHoriPanel1Tab.setStylePrimaryName("reportHoriPanel1Tab");

		report1Table.addStyleName("report1Table");
		report2Table.addStyleName("report2Table");
		report3Table.addStyleName("report3Table");
		report4Table.addStyleName("report4Table");

		RootPanel.get("content_wrap").add(reportHoriPanel1Tab);

	}

	public void loadTableAllUserAllPosts() {

		// final ArrayList<String> report1ArrayList = new ArrayList<String>();
		AsyncObj.getAllUsers(new AsyncCallback<ArrayList<User>>() {

			
			
			

			@Override
			public void onSuccess(ArrayList<User> result) {
				

				report1Table.setText(0, 0, "Nickname");
				report1Table.setText(0, 1, "Anzahl Beiträge");
				
				int firstRow = 1;
				for (int i = 0; i < result.size(); i++) {
					u = result.get(i);
					report1Table.setText(firstRow, 0,u.getNickname());
					
					
					
					AsyncObj.getPostCountByUserId(result.get(i).getUserId(),
							
							new AsyncCallback<Integer>() {

								@Override
								public void onSuccess(Integer result) {
									report1Table.setText(firstRow1, 1, String.valueOf(result)
											+ " Beitr�ge");
									firstRow1++;
								}

								@Override
								public void onFailure(Throwable caught) {
									// TODO Auto-generated method stub

								}
								
							});
					
					firstRow++;

				}}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}
		
		
		});
		this.add(report1Table);
	}
}