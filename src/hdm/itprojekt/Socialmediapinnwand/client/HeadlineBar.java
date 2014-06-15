package hdm.itprojekt.Socialmediapinnwand.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class HeadlineBar  extends VerticalPanel {

	VerticalPanel vPLeft = new VerticalPanel ();
	VerticalPanel vPRight = new VerticalPanel ();
	HorizontalPanel headlineBar =new HorizontalPanel ();
	Label labelLeft = new Label();
	Label labelRight = new Label();
	Label labelheadtoplist = new Label("Toplisten");

	public void setHeadlineInHeadlineBar(String label){
		this.labelRight.setText(label);
	}

	public class HeadlinesBarReport  extends VerticalPanel {
		public void onLoad(){
			
			vPLeft.setStylePrimaryName("HeadlinesBarEditorLeft");
			vPRight.setStylePrimaryName("vPRight");
			headlineBar.setStylePrimaryName("headlineBar");
	
			labelLeft.setText("System: Report");
			vPLeft.add(labelLeft);
			vPRight.add(labelRight);
			
			headlineBar.add(vPLeft);
			headlineBar.add(vPRight);
			
			this.add(headlineBar);
		}
	}
	
	public class HeadlinesBarEditor  extends VerticalPanel {
		public void onLoad(){
			
			vPLeft.setStylePrimaryName("HeadlinesBarEditorLeft");
			vPRight.setStylePrimaryName("vPRight");
			headlineBar.setStylePrimaryName("headlineBar");
	
			labelLeft.setText("System: Editor");
			vPLeft.add(labelLeft);
			vPRight.add(labelRight);
			
			headlineBar.add(vPLeft);
			headlineBar.add(vPRight);
			
			this.add(headlineBar);
		}
	}
		
	public class HeadlinesAllUserAllInfoO   extends VerticalPanel {
		VerticalPanel vPAllAll = new VerticalPanel ();
	
		public void onLoad(){
			vPAllAll.setStylePrimaryName("vPHeadlinesAllUserAllInfoObjectsAllStats");
			labelheadtoplist.setStylePrimaryName("labelheadtoplist");
		
			vPAllAll.add(labelheadtoplist);
			this.add(vPAllAll);

		}

		public void setText(String string) {
			labelheadtoplist.setText(string); 
		}
	}
 
}