package hdm.itprojekt.Socialmediapinnwand.client.gui;

import java.util.ArrayList;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import hdm.itprojekt.Socialmediapinnwand.client.AService;
import hdm.itprojekt.Socialmediapinnwand.client.AServiceAsync;
import hdm.itprojekt.Socialmediapinnwand.client.BoardPanel;
import hdm.itprojekt.Socialmediapinnwand.client.BoardPanel.createOwnBoardByNicknamePanel;
import hdm.itprojekt.Socialmediapinnwand.client.HeadlineBar;
import hdm.itprojekt.Socialmediapinnwand.client.HeadlineBar.HeadlinesAllUserAllInfoO;
import hdm.itprojekt.Socialmediapinnwand.client.HeadlineBar.HeadlinesBarEditor;
import hdm.itprojekt.Socialmediapinnwand.client.HeadlineBar.HeadlinesBarReport;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Board;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Post;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;

// TODO: Auto-generated Javadoc
/**
 * The Class BoardOverview.
 */
public class BoardOverview  extends VerticalPanel {
	
	/** The Async obj. */
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	
	/** The List of nicknames. */
	final ListBox ListOfNicknames = new ListBox();
	 
 	/** The s. */
 	final String s = "Eigene Pinnwand:";
	
	/** The take user id. */
	private int takeUserID = 0;
	
	/** The take nickname. */
	private String takeNickname;
	
	/** The report6 table. */
	FlexTable report6Table = new FlexTable();	
	
	/** The listboxindex. */
	private final int listboxindex = ListOfNicknames.getSelectedIndex();
	
	/** The selected nickname2. */
	private    String selectedNickname2; 
	    
    	/** The selected nickname. */
    	String selectedNickname;
	
	/**
	 * Instantiates a new board overview.
	 *
	 * @param takeUserID the take user id
	 */
	public BoardOverview(int takeUserID){
		
		this.takeUserID = takeUserID;
		
		//createBoardByUserID(UserId);
		
	}
	
	/**
	 * Instantiates a new board overview.
	 *
	 * @param takeNickname the take nickname
	 */
	public BoardOverview(String takeNickname ){
		this.takeNickname=takeNickname;
	}
	
	/**
	 * Instantiates a new board overview.
	 */
	public BoardOverview(  ){
 	}
	
	/**
	 * Board overview.
	 *
	 * @return the string
	 */
	public String BoardOverview(  ){
		return selectedNickname2;

 	}
	
	//get selected board 
	// sonst cookie select nickname
	
	/**
	 * Gets the selected list box index.
	 *
	 * @param listOfNicknames the list of nicknames
	 * @param selectedIndex the selected index
	 * @return the selected list box index
	 */
	public String getSelectedListBoxIndex (ListBox listOfNicknames, int selectedIndex) {
 		String selectedNickname =  listOfNicknames.getItemText(selectedIndex);
 		
 		String s1 ="Eigene Pinnwand";
	//	Window.alert(" " + selectedNickname);

		return selectedNickname;
 		 
	}
	
	/**
	 * Gets the list box.
	 *
	 * @return the list box
	 */
	public String getListBox(){
		
		String selectedNickname3 = getSelectedListBoxIndex(ListOfNicknames, ListOfNicknames.getSelectedIndex());
	 

		return selectedNickname3;
	}
 
/**
 * Gets the selected nickname.
 *
 * @return the selected nickname
 */
public String getSelectedNickname (){
		
		return selectedNickname2;
	}
	
	/**
	 * Load users.
	 */
	void loadUsers() {
		// Dropdown aller vorhandenen User anzeigen
		final String cookieNickname = Cookies.getCookie("SessionUserNicknameEditor");
 
	//	ListOfNicknames.addItem("Eigene Pinnwand:" );
		ListOfNicknames.setSize("400px", "35px");
		ListOfNicknames.addStyleName("mainmenu-dropdown");
 
		// Dropdown dem RootPanel zuordnen
		RootPanel.get("head_wrap_middle").add(ListOfNicknames);

		AsyncObj.getAllUsers(new AsyncCallback<ArrayList<User>>() {
			
			@Override
			public void onSuccess(ArrayList<User> result) {

				for (int i = 0; i < result.size(); i++) {

					ListOfNicknames.addItem(result.get(i).getNickname());

				}
				
				ListOfNicknames.addChangeHandler(new ChangeHandler() {
				 
			 		public void onChange(ChangeEvent event) {
					
						selectedNickname2=	getSelectedListBoxIndex(ListOfNicknames, ListOfNicknames.getSelectedIndex());
					//	ShowUserFromSelectedItem(ListOfNicknames, ListOfNicknames.getSelectedIndex());
						
						Cookies.setCookie("SelectedListItem",
								selectedNickname2);
					 
 						if (selectedNickname2.contains(cookieNickname)  ){
							     BoardPanel bP = new BoardPanel(); 
							     createOwnBoardByNicknamePanel bD =  bP.new createOwnBoardByNicknamePanel(selectedNickname2); 
 								RootPanel.get("content_wrap").clear();
 								HeadlineBar hB2 = new HeadlineBar();
 								hB2.setHeadlineInHeadlineBar("Eigene Pinnwand");
 								HeadlinesBarEditor HeadlineAllAll2 = hB2.new HeadlinesBarEditor();
 								RootPanel.get("content_wrap").add(HeadlineAllAll2);
 					 	       RootPanel.get("content_wrap").add(bD);
						}
						else{
							 	 BoardPanel bP = new BoardPanel(); 
							 	  createOwnBoardByNicknamePanel bD =  bP.new createOwnBoardByNicknamePanel(selectedNickname2); 
								RootPanel.get("content_wrap").clear();
								HeadlineBar hB2 = new HeadlineBar();
								hB2.setHeadlineInHeadlineBar("Pinnwand von:  " +selectedNickname2 );
								HeadlinesBarEditor HeadlineAllAll2 = hB2.new HeadlinesBarEditor();
								RootPanel.get("content_wrap").add(HeadlineAllAll2);
							 	RootPanel.get("content_wrap").add(bD);
						}
						
					}
					
					public void ShowUserFromSelectedItem(ListBox listOfNicknames, int selectedIndex) {
						// TODO Auto-generated method stub
						
 						String selectedNickname =  listOfNicknames.getItemText(selectedIndex);

						 AsyncObj.getOneUserIdByNickname(  selectedNickname, new AsyncCallback<User>() {
							 
								@Override
								 public void onSuccess(User result) {
									
		 							Integer user_id = result.getUserId();
													 
								//Window.alert(""+user_id);
									
								 	AsyncObj.getAllPostsObjectsByOneUserId(user_id,new AsyncCallback<ArrayList<Post>> () {
								 			
								 				@Override
												public void onFailure(Throwable caught) {

												}

												@Override
												public void onSuccess(ArrayList<Post> result) {
												 	//Window.alert("22----"+result);
													report6Table.setWidget(1, 0, new Label(String.valueOf(result)));
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
				
			}

			@Override
			public void onFailure(Throwable caught) {

				Window.alert("Konnte keine User finden");

			}
		});

	}	
	
	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.Widget#onLoad()
	 */
	public void onLoad(){
		HeadlineBar hB2 = new HeadlineBar();
		hB2.setHeadlineInHeadlineBar("Herzlich Willkommen auf deiner Pinnwand" );
		HeadlinesBarEditor HeadlineAllAll2 = hB2.new HeadlinesBarEditor();
		RootPanel.get("content_wrap").add(HeadlineAllAll2);

		//final int UserId = Integer.parseInt(Cookies.getCookie("SessionUserID"));
	//	final int BoardId = Integer.parseInt(Cookies.getCookie("SessionBoardID"));
		
	
	//	int listboxindex = ListOfNicknames.getSelectedIndex();
	//	String selectedNickname; 
	//	selectedNickname =  ListOfNicknames.getItemText(listboxindex);
 
		ListOfNicknames.addItem("Wählen Sie einen User aus");
		
		loadUsers();
		 final  String cookieNickname = Cookies.getCookie("SessionUserNicknameEditor");
	 
		if ( selectedNickname2==null  ){
	        BoardPanel bP = new BoardPanel(); 
	        createOwnBoardByNicknamePanel bD =  bP.new createOwnBoardByNicknamePanel(cookieNickname); 
 			RootPanel.get("content_wrap").add(bD);
	    }
		else {
			String s = selectedNickname2;
		    BoardPanel bP = new BoardPanel(); 
		    createOwnBoardByNicknamePanel bD =  bP.new createOwnBoardByNicknamePanel(s); 
		 	RootPanel.get("content_wrap").add(bD);
		}	
		
	 
	 	
	}

}