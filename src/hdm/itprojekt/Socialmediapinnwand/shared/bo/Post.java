package hdm.itprojekt.Socialmediapinnwand.shared.bo;

public class Post extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*Folgende Attribute benötigt die Klasse Post, um ein Posting laut Anforderungen
	beschreiben zu können*/
	private String post;
	private String timestamp;
	
	//Methode, um den Text eines Posts zu setzen
	public void setPost(String postText){
		post = postText;
	}
	
	//Methode, um den Text eines Posts zu erhalten
	public String getPost(){
		return post;
	}
	
	//Methode, um den Zeitpunkt eines Posts zu setzen
	public void setTimestamp(String timestamp){
	}
	
	//Methode, um den Zeitpunkt eines Posts zu erhalten
	public String getTimestamp(){
		return timestamp;
	}
	
}
