package hdm.itprojekt.Socialmediapinnwand.client;

import hdm.itprojekt.Socialmediapinnwand.shared.bo.Post;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CreatePost extends VerticalPanel {

	// Definieren von benötigten Widgets
	private final Button submitPost = new Button("Absenden");
	private final TextArea post = new TextArea();
	private final Label lbPost = new Label("Erstelle einen Post");

	// Wie kann man das hier bezeichnen?
	private final AServiceAsync AsyncObj = GWT.create(AService.class);
	private Post p;

	private final VerticalPanel vertPanel = new VerticalPanel();

	public void onLoad() {

		// Widgets mit vordefiniertem Text befüllen
		post.setCharacterWidth(80);
		post.setVisibleLines(10);
		post.setStylePrimaryName("postnowbox_content");

		// Widgets dem Panel zuordnen
		vertPanel.add(post);
		RootPanel.get("content_wrap").add(vertPanel);
		
		
		lbPost.setStylePrimaryName("postnowbox_headline");

		// Dem RootPanel ein Panel und einen Button zuordnen
		// (Muss noch angepasst werden, da wir am Schluss noch mehr Funktionen
		// haben)
		

		submitPost.setStylePrimaryName("postnowbox_submit_button");
		
		RootPanel.get("content_wrap").add(submitPost);

		// Dem Benutzerbutton einen ClickHandler zuordnen
		submitPost.addClickHandler(new ClickHandler() {

			// Der ClickHandler erstellt ein neues User-Objekt mit
			// entsprechenden Werten aus den Widgets
			public void onClick(ClickEvent event) {
				if (post.getValue().isEmpty()) {
					Window.alert("Bitte gebe deinen Post ein");

				} else {
					p = new Post();
					p.setPost(post.getValue());

					// Implementierung der Asynchronität des Callbacks für den
					// insert-Befehl
					AsyncObj.insertPost(p, new AsyncCallback<Void>() {
						@Override
						// Anzeige bei fehlerhaftem insert-Befehl
						public void onFailure(Throwable caught) {

						}

						@Override
						// Anzeige bei erfolgreichem insert-Befehl
						public void onSuccess(Void result) {
							Window.alert("Erfolgreich gepostet!");

						}
					});
				}
			}
		});
	}
}

