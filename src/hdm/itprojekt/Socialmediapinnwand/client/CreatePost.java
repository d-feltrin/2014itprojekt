package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.shared.AService;
import hdm.itprojekt.Socialmediapinnwand.shared.AServiceAsync;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Post;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CreatePost extends VerticalPanel {
	
	//Definieren von benötigten Widgets
		private final Button submitPost = new Button("Absenden");
		private final TextArea post = new TextArea();
	
		
		//Wie kann man das hier bezeichnen?
		private final AServiceAsync AsyncObj = GWT.create(AService.class);
		private Post p;
		
		private final VerticalPanel vertPanel = new VerticalPanel(); 
		
		public void onLoad() {
			
			//Widgets mit vordefiniertem Text befüllen
			post.setText("Dein Status..");
			post.setCharacterWidth(80);
			post.setVisibleLines(10);
			
			//Widgets dem Panel zuordnen
			vertPanel.add(post);
						
			//Dem RootPanel ein Panel und einen Button zuordnen
			//(Muss noch angepasst werden, da wir am Schluss noch mehr Funktionen haben)
			this.add(vertPanel);
			this.add(submitPost);
			
			//Dem Benutzerbutton einen ClickHandler zuordnen
			submitPost.addClickHandler(new ClickHandler() {

				//Der ClickHandler erstellt ein neues User-Objekt mit entsprechenden Werten aus den Widgets
				  public void onClick(ClickEvent event) {
					  p = new Post();
					  p.setPost(post.getValue());
					  
					  
					  //Implementierung der Asynchronität des Callbacks für den insert-Befehl
					  AsyncObj.insertPost(p,
								new AsyncCallback<Void>() {
									@Override
									//Anzeige bei fehlerhaftem insert-Befehl
									public void onFailure(Throwable caught) {
										
									}

									@Override
									//Anzeige bei erfolgreichem insert-Befehl
									public void onSuccess(Void result) {
										Window.alert("Erfolgreich gepostet!");

									}
							  });
									  }
							  });
		}
	}
		
		//?
		//private final Sm4sAdministrationAsync ServiceObj = GWT.create(Sm4sAdministration.class);
		//private User u;
		