package hdm.itprojekt.Socialmediapinnwand.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class HeadlineBar.
 */
public class HeadlineBar  extends VerticalPanel {

	/** The v p left. */
	VerticalPanel vPLeft = new VerticalPanel ();
	
	/** The v p right. */
	VerticalPanel vPRight = new VerticalPanel ();
	
	/** The headline bar. */
	HorizontalPanel headlineBar =new HorizontalPanel ();
	
	/** The label left. */
	Label labelLeft = new Label();
	
	/** The label right. */
	Label labelRight = new Label();
	
	/** The labelheadtoplist. */
	Label labelheadtoplist = new Label("Toplisten");

	/**
	 * Sets the headline in headline bar.
	 *
	 * @param label the new headline in headline bar
	 */
	public void setHeadlineInHeadlineBar(String label){
		this.labelRight.setText(label);
	}

	/**
	 * The Class HeadlinesBarReport.
	 */
	public class HeadlinesBarReport  extends VerticalPanel {
		
		/* (non-Javadoc)
		 * @see com.google.gwt.user.client.ui.Widget#onLoad()
		 */
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
	
	/**
	 * The Class HeadlinesBarEditor.
	 */
	public class HeadlinesBarEditor  extends VerticalPanel {
		
		/* (non-Javadoc)
		 * @see com.google.gwt.user.client.ui.Widget#onLoad()
		 */
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
		
	/**
	 * The Class HeadlinesAllUserAllInfoO.
	 */
	public class HeadlinesAllUserAllInfoO   extends VerticalPanel {
		
		/** The v p all all. */
		VerticalPanel vPAllAll = new VerticalPanel ();
	
		/* (non-Javadoc)
		 * @see com.google.gwt.user.client.ui.Widget#onLoad()
		 */
		public void onLoad(){
			vPAllAll.setStylePrimaryName("vPHeadlinesAllUserAllInfoObjectsAllStats");
			labelheadtoplist.setStylePrimaryName("labelheadtoplist");
		
			vPAllAll.add(labelheadtoplist);
			this.add(vPAllAll);

		}

		/**
		 * Sets the text.
		 *
		 * @param string the new text
		 */
		public void setText(String string) {
			labelheadtoplist.setText(string); 
		}
	}
 
}