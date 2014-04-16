package hdm.itprojekt.Socialmediapinnwand.shared.bo;

public class Comment extends BusinessObject {

	//Folgende Attribute benötigt die Klasse Comment, um einen Kommentar laut Anforderungen
	//beschreiben zu können
	private String text;
	private String timestamp;
	
	//Methode, um den Text eines Kommentars zu setzen
		public void setText(String text){
			
		}
		
		//Methode, um den Text eines Kommentars zu erhalten
		public String getText(){
			return text;
		}
		
		//Methode, um den Zeitpunkt eines Kommentars zu setzen
		public void setTimestamp(String timestamp){
			
		}
		
		//Methode, um den Zeitpunkt eines Kommentars zu erhalten
		public String getTimestamp(){
			return timestamp;
		}
	
}
