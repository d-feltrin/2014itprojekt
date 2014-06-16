package hdm.itprojekt.Socialmediapinnwand.shared.bo;

// TODO: Auto-generated Javadoc
/**
 * The Class Comment.
 */
public class Comment extends BusinessObject {

	/*Folgende Attribute ben�tigt die Klasse Comment, um einen Kommentar laut Anforderungen
	beschreiben zu k�nnen*/
	/** The id. */
	private Integer id;
	
	/** The text. */
	private String text;
	
	/** The timestamp. */
	private String timestamp;
	
	/** The post_id. */
	private Integer post_id;
	
	/** The user_id. */
	private Integer user_id;
	
	//Methode, um den Text eines Kommentars zu setzen
	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text){	
		this.text=text;
	}
		
	//Methode, um den Text eines Kommentars zu erhalten
	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText(){
		return text;
	}
		
	//Methode, um den Zeitpunkt eines Kommentars zu setzen
	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}
		
	//Methode, um den Zeitpunkt eines Kommentars zu erhalten
	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public String getTimestamp(){
		return timestamp;
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.shared.bo.BusinessObject#getId()
	 */
	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.shared.bo.BusinessObject#setId(int)
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the post_id.
	 *
	 * @return the post_id
	 */
	public int getPost_id() {
		return post_id;
	}

	/**
	 * Sets the post_id.
	 *
	 * @param post_id the new post_id
	 */
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	/**
	 * Gets the user_id.
	 *
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * Sets the user_id.
	 *
	 * @param user_id the new user_id
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
}