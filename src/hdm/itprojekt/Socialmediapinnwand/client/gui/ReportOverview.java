package hdm.itprojekt.Socialmediapinnwand.client.gui;

import hdm.itprojekt.Socialmediapinnwand.client.HeadlineBar;
import hdm.itprojekt.Socialmediapinnwand.client.HeadlineBar.HeadlinesAllUserAllInfoO;
import hdm.itprojekt.Socialmediapinnwand.client.HeadlineBar.HeadlinesBarReport;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

// TODO: Auto-generated Javadoc
/**
 * The Class ReportOverview.
 */
public class ReportOverview extends VerticalPanel {

	/* (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.Widget#onLoad()
	 */
	public void onLoad(){
		
		//HeadlineBar
		HeadlineBar hB1 = new HeadlineBar();
		hB1.setHeadlineInHeadlineBar("Alle Statistiken");
		HeadlinesBarReport HeadlinesBarReport =  hB1.new HeadlinesBarReport();
		
		HeadlineBar hB2 = new HeadlineBar();
		//hB2.setHeadlineInHeadlineBar("Alle Statistiken");
		HeadlinesAllUserAllInfoO HeadlineAllAll = hB2.new HeadlinesAllUserAllInfoO();
		
		
		HeadlineBar hB3 = new HeadlineBar();
		//hB2.setHeadlineInHeadlineBar("Alle Statistiken");
		HeadlinesAllUserAllInfoO HeadlineAllAll2 = hB3.new HeadlinesAllUserAllInfoO();

		OneUserByOneInfoObjects View2 = new OneUserByOneInfoObjects();
		AllUsersbByAllInfoObject View1 = new AllUsersbByAllInfoObject();
		
		RootPanel.get("content_wrap").add(HeadlinesBarReport);
		RootPanel.get("content_wrap").add(HeadlineAllAll);
		RootPanel.get("content_wrap").add(View1);
		
		
 
		RootPanel.get("content_wrap").add(HeadlineAllAll2);
		RootPanel.get("content_wrap").add(View2);
		
		
		
		
		
		
	}
	
}