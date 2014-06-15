package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import hdm.itprojekt.Socialmediapinnwand.client.*;
import hdm.itprojekt.Socialmediapinnwand.client.LoginEntry.SocialmediapinnwandEditor;
import hdm.itprojekt.Socialmediapinnwand.client.LoginEntry.SocialmediapinnwandReport;
import hdm.itprojekt.Socialmediapinnwand.client.LoginPanels.LoginDasboard;

public class Socialmediapinnwand implements EntryPoint      {

	public void onModuleLoad() {
		
		 /*
		Cookies.removeCookie("SessionUserNicknameEditor" );
		 Cookies.removeCookie("SessionUserID" );
			Cookies.removeCookie("SessionUserNicknameReport" );
			 Cookies.removeCookie("SessionUserID" );
			*/

		String sessionEditor = Cookies.getCookie("SessionUserNicknameEditor");
 
		String sessionReport = Cookies.getCookie("SessionUserNicknameReport");
		
		RootPanel.get("Impressum").add(new Impressum());
		 	 
 	 if(sessionEditor != null ) {
		LoginEntry a = new LoginEntry();
			SocialmediapinnwandEditor b = a.new SocialmediapinnwandEditor();
			RootPanel.get("content_wrap").clear();

		 	RootPanel.get("content_wrap").add(b); 		
			} 
 	 else if(sessionReport != null){
			LoginEntry a1 = new LoginEntry();
			SocialmediapinnwandReport b1 = a1.new SocialmediapinnwandReport();
			RootPanel.get("content_wrap").clear();

		 	RootPanel.get("content_wrap").add(b1);
		}
		
		else  	  {

			RootPanel.get("content_wrap").clear();
			RootPanel.get("head_wrap_middle").clear();
			RootPanel.get("head_wrap_right").clear();
			LoginPanels a = new LoginPanels();
			LoginDasboard b = a.new LoginDasboard(); 
			RootPanel.get("content_wrap").add(b);
		} 
		
	}
	
}