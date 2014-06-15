package hdm.itprojekt.Socialmediapinnwand.shared.bo;

import hdm.itprojekt.Socialmediapinnwand.client.AService;
import hdm.itprojekt.Socialmediapinnwand.client.AServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class Board extends BusinessObject {
	
	private int board_id;
	
	//Methode, um den Zeitpunkt eines Kommentars zu setzen
		public void setBoardId(int board_id){
			this.board_id = board_id;
		}
			
		//Methode, um den Zeitpunkt eines Kommentars zu erhalten
		public int getBoardId(){
			return board_id;
		}
		
		public  Board() {
			
			this.board_id = board_id;
			
		}
 
}