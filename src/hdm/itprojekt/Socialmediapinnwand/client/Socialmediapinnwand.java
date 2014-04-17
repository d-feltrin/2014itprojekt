package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.client.CreateUser;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Socialmediapinnwand implements EntryPoint {
	
	final VerticalPanel contentPanel = new VerticalPanel();
	final Button TestButton = new Button ("Test");
	
	public void onModuleLoad() {

TestButton.addClickHandler(new ClickHandler(){
	public void onClick(ClickEvent event){
		
		
			
				CreateUser newUser = new CreateUser();
				
				RootPanel.get("denis").clear();
				RootPanel.get("denis").add(newUser);
								
			
	}
});

RootPanel.get("denis").add(contentPanel);
RootPanel.get("denis").add(TestButton);

}
}
