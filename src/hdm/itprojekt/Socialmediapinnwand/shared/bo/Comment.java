package hdm.itprojekt.Socialmediapinnwand.shared.bo;

public class Comment extends BusinessObject {

	/*Folgende Attribute ben�tigt die Klasse Comment, um einen Kommentar laut Anforderungen
	beschreiben zu k�nnen*/
	private Integer id;
	private String text;
	private String timestamp;
	private Integer post_id;
	private Integer user_id;
	
	//Methode, um den Text eines Kommentars zu setzen
	public void setText(String text){	
		this.text=text;
	}
		
	//Methode, um den Text eines Kommentars zu erhalten
	public String getText(){
		return text;
	}
		
	//Methode, um den Zeitpunkt eines Kommentars zu setzen
	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}
		
	//Methode, um den Zeitpunkt eines Kommentars zu erhalten
	public String getTimestamp(){
		return timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}