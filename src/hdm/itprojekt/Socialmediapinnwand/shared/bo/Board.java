package hdm.itprojekt.Socialmediapinnwand.shared.bo;

import hdm.itprojekt.Socialmediapinnwand.client.AService;
import hdm.itprojekt.Socialmediapinnwand.client.AServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

// TODO: Auto-generated Javadoc
/**
 * The Class Board.
 */
public class Board extends BusinessObject {
	
	/** The board_id. */
	private int board_id;
	
	//Methode, um den Zeitpunkt eines Kommentars zu setzen
		/**
	 * Sets the board id.
	 *
	 * @param board_id the new board id
	 */
	public void setBoardId(int board_id){
			this.board_id = board_id;
		}
			
		//Methode, um den Zeitpunkt eines Kommentars zu erhalten
		/**
		 * Gets the board id.
		 *
		 * @return the board id
		 */
		public int getBoardId(){
			return board_id;
		}
		
		/**
		 * Instantiates a new board.
		 */
		public  Board() {
			
			this.board_id = board_id;
			
		}
 
}