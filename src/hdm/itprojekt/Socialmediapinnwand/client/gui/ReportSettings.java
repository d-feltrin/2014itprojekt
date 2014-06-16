package hdm.itprojekt.Socialmediapinnwand.client.gui;

import hdm.itprojekt.Socialmediapinnwand.client.AService;
import hdm.itprojekt.Socialmediapinnwand.client.AServiceAsync;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlowPanel;

public class ReportSettings {

	
	
	
	
	
	
	
	public class PostCounter extends FlowPanel {
		
		int userid;
		
		public  PostCounter(int userid) {
			this.userid = userid;
			
		}
		
		private final AServiceAsync AsyncObj = GWT.create(AService.class);
		int tempCounter;
		
	public int getPostsCountByUserId (){
	
	AsyncObj.getPostsByUserId(userid, new AsyncCallback<Integer>()  {
		

		@Override
		public void onFailure(Throwable caught) {
			Window.alert("Fehler bei der Abfrage");
		}

		@Override
		public void onSuccess(Integer result) {
			
			int res = (int)result;
			 
			 tempCounter = result;
		  
		
			
		}
	});

	return tempCounter;
	}
	
	}
	
	
	
}
