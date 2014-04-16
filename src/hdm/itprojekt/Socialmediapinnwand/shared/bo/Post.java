package hdm.itprojekt.Socialmediapinnwand.shared.bo;

public class Post extends BusinessObject {

	//Folgende Attribute benötigt die Klasse Post, um ein Posting laut Anforderungen
	//beschreiben zu können
	private String text;
	private String timestamp;
	
	//Methode, um den Text eines Posts zu setzen
	public void setText(String text){
		
	}
	
	//Methode, um den Text eines Posts zu erhalten
	public String getText(){
		return text;
	}
	
	//Methode, um den Zeitpunkt eines Posts zu setzen
	public void setTimestamp(String timestamp){
		
	}
	
	//Methode, um den Zeitpunkt eines Posts zu erhalten
	public String getTimestamp(){
		return timestamp;
	}
	
}
