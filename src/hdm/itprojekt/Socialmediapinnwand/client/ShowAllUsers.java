package hdm.itprojekt.Socialmediapinnwand.client;

import java.util.ArrayList;

import hdm.itprojekt.Socialmediapinnwand.shared.AService;
import hdm.itprojekt.Socialmediapinnwand.shared.AServiceAsync;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ShowAllUsers implements EntryPoint {
	
	final VerticalPanel contentPanel = new VerticalPanel();
	final ListBox  ListOfNicknames = new ListBox();
	
	private final AServiceAsync AsyncObj = GWT.create(AService.class);

	
		public void onModuleLoad() {
			
			ListOfNicknames.addItem("Test");
			ListOfNicknames.addItem("One");
			ListOfNicknames.addItem("Two");
			ListOfNicknames.addItem("Three");
			ListOfNicknames.setSize("500px", "35px");
			ListOfNicknames.addStyleName("mainmenu-dropdown");
			
			// Dropdown dem RootPanel zuordnen
			RootPanel.get("head_wrap_middle").add(ListOfNicknames);
			
			AsyncObj.getAllUsers(new AsyncCallback<ArrayList<User>>() {
	//ergebnis.get(i).getDozentID())
				@Override
				public void onSuccess(ArrayList<User> ergebnis) {
					
						for(int i = 0; i< ergebnis.size(); i++) {
												
						ListOfNicknames.addItem(ergebnis.get(i).getNickname());
						
						
					}
					}

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}
					});
				
					}
		}
