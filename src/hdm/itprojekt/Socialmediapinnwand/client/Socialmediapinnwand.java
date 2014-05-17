package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.client.Login;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import hdm.itprojekt.Socialmediapinnwand.client.*;


public class Socialmediapinnwand implements EntryPoint {

	public final User u = new User();
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	
	
	public void onModuleLoad() {
		String checkCookie = Cookies.getCookie("SM4S");
		
		if(checkCookie == null) {
			
			
			RootPanel.get("content_wrap").clear();
			RootPanel.get("head_wrap_middle").clear();
			RootPanel.get("head_wrap_right").clear();
			RootPanel.get("head_wrap_middle").add(new Login());
			
		} else {
			RootPanel.get("content_wrap").clear();
			RootPanel.get("head_wrap_middle").clear();
			RootPanel.get("head_wrap_right").clear();
			RootPanel.get().clear();
			RootPanel.get().add(new Socialmediapinnwand_entry());
		}

		
	}


	
}
