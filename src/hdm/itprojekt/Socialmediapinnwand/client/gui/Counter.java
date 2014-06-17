package hdm.itprojekt.Socialmediapinnwand.client.gui;

import java.util.ArrayList;

import hdm.itprojekt.Socialmediapinnwand.client.AService;
import hdm.itprojekt.Socialmediapinnwand.client.AServiceAsync;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Post;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

// TODO: Auto-generated Javadoc
/**
 * The Class Counter.
 */
public class Counter extends FlowPanel{

	
	  /** The nickname. */
  	private String nickname ;
	  
  	/** The nickname2. */
  	private String nickname2 ;
	  
  	/** The nickname3. */
  	private String nickname3 ;
	  
  	/** The nickname4. */
  	private String nickname4 ;
	
	/** The userid. */
	private int userid ;
	
	/** The userid2. */
	private int userid2 ;
	
	/** The userid3. */
	private int userid3 ;
	
	/** The userid4. */
	private int userid4 ;
	
	/** The countindex. */
	private int countindex ;
	
	/** The report1 table. */
	FlexTable report1Table = new FlexTable();
	
	/** The report2 table. */
	FlexTable report2Table = new FlexTable();
	
	/** The report3 table. */
	FlexTable report3Table = new FlexTable();
	
	/** The report4 table. */
	FlexTable report4Table = new FlexTable();
	
	/** The report5 table. */
	FlexTable report5Table = new FlexTable();
	
	/** The zaehler flex table1. */
	private int zaehlerFlexTable1 = 1;

/** The p. */
private Post p = new Post();

int Iterator = 2; 
 
 


	/** The Async obj. */
	final AServiceAsync AsyncObj = GWT.create(AService.class);

	
 
	
	
	
	/**
	 * Gets the all posts by date intervall.
	 *
	 * @param p the p
	 * @return the all posts by date intervall
	 */
	public FlexTable getAllPostsByDateIntervall( ArrayList<Post> p, int posterid){
		report5Table.setText(0, 0, "Anzahl Kommentare");
		report5Table.setText(0, 1, "Anzahl Beiträge");
		report5Table.setText(0, 2, "Anzahl Abonnements");
		
		for (int i = 0; i < p.size(); i++) {
		 Window.alert(p.get(i).getPosr_id() + " " + posterid +" - " );
			
			if ( p.get(i).getPosr_id() == posterid){
			
				report5Table.setWidget(i+1 , 0, new Label( String.valueOf(p.get(i).getPosr_id()) ) );
				report5Table.setWidget(i+1 , 2, new Label( String.valueOf(p.get(i).getTimestamp()) ) );
				report5Table.setWidget(i+1 , 1, new Label( String.valueOf(p.get(i).getPost()) ) );
				
				Iterator++;
			} 
			
			
			
			
		}
		
		int rowCount = report5Table.getRowCount();
		
	/*	if(rowCount==0){
			
			Window.alert("Der Nuter hat keine Beiträge in diesem Zeitraum veröffentlich");
		}else {
		report5Table.getFlexCellFormatter().setColSpan(1, 0, 2); 
		report5Table.setWidget(1, 0,  new Label( String.valueOf(rowCount))   );
		report5Table.setWidget(1, 2,  new Label( "Beiträge")   );
		}*/
 
		return report5Table;
		
	}
	
	
	/**
	 * Gets the posts by user id.
	 *
	 * @param userid the userid
	 * @param nickname the nickname
	 * @return the posts by user id
	 */
	public FlexTable getPostsByUserId( int userid,   final String nickname){
		
		AsyncObj.getPostsByUserId(userid, new AsyncCallback<Integer>()  {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Fehler bei der Abfrage");
			}
		
			public void onSuccess(Integer result) {
				
				   report1Table.setWidget(0 , 1, new Label( "Beiträge" ) );
				   report1Table.setWidget(0 , 0, new Label("Nickname" ) ); 
			   report1Table.setWidget(zaehlerFlexTable1 , 1, new Label(result +" " ) );
			   report1Table.setWidget(zaehlerFlexTable1 , 0, new Label(nickname ) ); 
			   report1Table.setStyleName("report1Table");
			}
			
		});
		return report1Table;
		
	}
	
	
	
/**
 * Gets the all likes by user id.
 *
 * @param userid2 the userid2
 * @param nickname2 the nickname2
 * @return the all likes by user id
 */
public FlexTable getAllLikesByUserId( int userid2,   final String nickname2){
		
		AsyncObj.getAllLikesByUserId(userid, new AsyncCallback<Integer>()  {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Fehler bei der Abfrage");
			}
		
			public void onSuccess(Integer result) {
				
				   report2Table.setWidget(0 , 1, new Label( "Likes" ) );
				   report2Table.setWidget(0 , 0, new Label("Nickname" ) ); 
			   report2Table.setWidget(zaehlerFlexTable1 , 1, new Label(result +" " ) );
			   report2Table.setWidget(zaehlerFlexTable1 , 0, new Label(nickname2 ) ); 
			   report2Table.setStyleName("report2Table");
			}
			
		});
		return report2Table;
		
	}
	


/**
 * Gets the subscriptions by user id.
 *
 * @param userid3 the userid3
 * @param nickname3 the nickname3
 * @return the subscriptions by user id
 */
public FlexTable getSubscriptionsByUserId( int userid3,   final String nickname3){
	
	AsyncObj.getSubscriptionsByUserId(userid, new AsyncCallback<Integer>()  {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Fehler bei der Abfrage");
		}
	
		public void onSuccess(Integer result) {
			
			   report3Table.setWidget(0 , 1, new Label( "Abos" ) );
			   report3Table.setWidget(0 , 0, new Label("Nickname" ) ); 
		   report3Table.setWidget(zaehlerFlexTable1 , 1, new Label(result +" " ) );
		   report3Table.setWidget(zaehlerFlexTable1 , 0, new Label(nickname3 ) ); 
		   report3Table.setStyleName("report3Table");
		}
		
	});
	return report3Table;
	
}


/**
 * Gets the comments by user id.
 *
 * @param userid4 the userid4
 * @param nickname4 the nickname4
 * @return the comments by user id
 */
public FlexTable getCommentsByUserId( int userid4,   final String nickname4){
	
	AsyncObj.getAllCommentsCountByUserId(userid, new AsyncCallback<Integer>()  {

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Fehler bei der Abfrage");
		}
	
		public void onSuccess(Integer result) {
			
			   report4Table.setWidget(0 , 1, new Label( "Kommentare " ) );
			   report4Table.setWidget(0 , 0, new Label("Nickname" ) ); 
		   report4Table.setWidget(zaehlerFlexTable1 , 1, new Label(result +" " ) );
		   report4Table.setWidget(zaehlerFlexTable1 , 0, new Label(nickname4 ) ); 
		   report4Table.setStyleName("report3Table");
		}
		
	});
	return report4Table;
	
}
 
	
	
 
	
	
	
	
	
	

		
		 
	
}
