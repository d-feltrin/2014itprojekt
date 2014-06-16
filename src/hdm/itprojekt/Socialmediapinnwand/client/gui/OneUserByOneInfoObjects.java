package hdm.itprojekt.Socialmediapinnwand.client.gui;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import hdm.itprojekt.Socialmediapinnwand.client.AService;
import hdm.itprojekt.Socialmediapinnwand.client.AServiceAsync;
import hdm.itprojekt.Socialmediapinnwand.client.CreateUser;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.BusinessObject;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.OwnStringObject;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Post;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Subscription;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;

import com.google.gwt.cell.client.ButtonCellBase.DefaultAppearance.Style;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class OneUserByOneInfoObjects.
 */
public class OneUserByOneInfoObjects extends VerticalPanel implements
		Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5744986706947752922L;

	/** The Async obj. */
	private final AServiceAsync AsyncObj = GWT.create(AService.class);

	/** The generate report2 btn. */
	final Button generateReport2Btn = new Button("Report erstellen");

	/** The report hor panel. */
	final HorizontalPanel reportHorPanel = new HorizontalPanel();
	
	/** The report vert panel1 tab. */
	final VerticalPanel reportVertPanel1Tab = new VerticalPanel();
	
	/** The report vert panel2 tab. */
	final VerticalPanel reportVertPanel2Tab = new VerticalPanel();
	
	/** The report hor panel right. */
	final HorizontalPanel reportHorPanelRight = new HorizontalPanel();
	
	/** The report vert panel right one. */
	final VerticalPanel reportVertPanelRightOne = new VerticalPanel();
	
	/** The report vert panel right two. */
	final VerticalPanel reportVertPanelRightTwo = new VerticalPanel();

	/** The report5 table. */
	final FlexTable report5Table = new FlexTable();
	
	/** The time stamp table. */
	final FlexTable timeStampTable = new FlexTable();
	
	/** The like table. */
	final FlexTable likeTable = new FlexTable();

	/** The report2 headline. */
	final Label report2Headline = new Label("Folgender User ist selektiert:");
	
	/** The user_id temp. */
	int user_idTEMP;
	
	/** The List of nicknames. */
	ListBox ListOfNicknames = new ListBox();
	
	/**
	 * Instantiates a new one user by one info objects.
	 */
	public OneUserByOneInfoObjects() {
			
	}
 
	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.Widget#onLoad()
	 */
	public void onLoad() {

		reportVertPanel1Tab.add(report2Headline);
		reportVertPanel1Tab.add(ListOfNicknames);

		final Label datePickerLabel1 = new Label();
		reportVertPanel1Tab.add(datePickerLabel1);

		DatePicker datePickerFrom = new DatePicker();
		reportVertPanel1Tab.add(datePickerFrom);

		final Label datePickerLabel2 = new Label();
		reportVertPanel1Tab.add(datePickerLabel2);

		DatePicker datePickerTo = new DatePicker();
		reportVertPanel1Tab.add(datePickerTo);

		reportVertPanel1Tab.add(generateReport2Btn);

		reportHorPanel.add(reportVertPanel1Tab);

		reportHorPanel.add(reportVertPanel2Tab);
		RootPanel.get("content_wrap").add(reportHorPanel);

		reportVertPanel2Tab.add(reportHorPanelRight);
		reportHorPanelRight.add(reportVertPanelRightOne);
		reportHorPanelRight.add(reportVertPanelRightTwo);

		reportVertPanelRightOne.add(timeStampTable);
		reportVertPanelRightTwo.add(likeTable);

		reportVertPanel1Tab.setStylePrimaryName("OneOneReportVpanel1");
		reportVertPanel2Tab.setStylePrimaryName("OneOneReportVpanel2");
		reportHorPanel.setStylePrimaryName("reportHorPanelVp");

		report2Headline.setStylePrimaryName("oneoneHeadline");
 

		datePickerFrom.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getFormat("yyyy-mm-dd ")
						.format(date);
				datePickerLabel1.setText(dateString);
			}
		});

		datePickerTo.addValueChangeHandler(new ValueChangeHandler<Date>() {
			public void onValueChange(ValueChangeEvent<Date> event) {
				Date date = event.getValue();
				String dateString = DateTimeFormat.getFormat("yyyy-mm-dd")
						.format(date);
				datePickerLabel2.setText(dateString);
			}
		});

		DateTimeFormat dateFormat = DateTimeFormat.getLongDateFormat();
		DateBox dateBox = new DateBox();
		dateBox.setFormat(new DateBox.DefaultFormat(dateFormat));

		// Dropdown aller vorhandenen User anzeigen
		ListOfNicknames.addItem("User auswählen");
		ListOfNicknames.setSize("200px", "35px");
		ListOfNicknames.addStyleName("ListOfNicknames2");
		ListOfNicknames.getSelectedIndex();

		reportVertPanelRightOne.add(timeStampTable);

		timeStampTable.setText(0, 0, "Anzahl Kommentare");
		timeStampTable.setText(0, 1, "Anzahl Beiträge");
		timeStampTable.setText(0, 2, "Anzahl Abonnements");

		likeTable.setText(0, 0, "Anzahl Likes");

		AsyncObj.getAllUsers(new AsyncCallback<ArrayList<User>>() {

			@Override
			public void onSuccess(ArrayList<User> result) {

				for (int i = 0; i < result.size(); i++) {

					ListOfNicknames.addItem(result.get(i).getNickname());

				}

				ListOfNicknames.addChangeHandler(new ChangeHandler() {
					public void onChange(ChangeEvent event) {
						ShowUserFromSelectedItem(ListOfNicknames,
								ListOfNicknames.getSelectedIndex());
						report5Table.clear();

					}

					public void ShowUserFromSelectedItem( ListBox listOfNicknames, int selectedIndex) {
						// TODO Auto-generated method stub

						String selectedNickname;
						selectedNickname = listOfNicknames
								.getItemText(selectedIndex);

				 AsyncObj.getOneUserIdByNickname(selectedNickname, new AsyncCallback<User>() {

									@Override
									public void onSuccess(User result) {
										
										if(datePickerLabel1.getText().isEmpty()  | datePickerLabel2.getText().isEmpty() ){
											
											Window.alert("Bitte geben Sie ein Von-Datum und ein Bis-Datum ein");
											
										}else{
										  user_idTEMP = result.getUserId();
											String fromDate, toDate; 
											fromDate = datePickerLabel1.getText();
											toDate = datePickerLabel2.getText();
 
								 		AsyncObj.getAllPostsByDateIntervall( user_idTEMP, fromDate, toDate,  new AsyncCallback<ArrayList<Post>>() {
													@Override
													public void onFailure(
															Throwable caught) {

													}

												 

													@Override
													public void onSuccess(
															ArrayList<Post> result) {
														ArrayList<Post> pA = new ArrayList<Post>();
														for (int i = 0; i < result.size(); i++) {
															
															HorizontalPanel hP = new HorizontalPanel();
															
															
															if(result.get(i).getPosr_id().equals(user_idTEMP)){
																
																
																  Post p = new Post();
																  p = result.get(i);
																  pA.add(p);
																  Counter a = new Counter();
																  hP.add(a.getAllPostsByDateIntervall(pA));
																  reportVertPanelRightTwo.add(hP);
															}
															}
														}
													}); 
												}
										
										}

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
										
									} 
										
										
						}); 
					  
									 
					} 
								});

					 

		 
			
		 

				}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}});

	}
}