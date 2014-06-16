package hdm.itprojekt.Socialmediapinnwand.shared.bo;

// TODO: Auto-generated Javadoc
/**
 * The Class Post.
 */
public class Post extends BusinessObject {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/*Folgende Attribute ben�tigt die Klasse Post, um ein Posting laut Anforderungen
	beschreiben zu k�nnen*/
	/** The posr_id. */
	private Integer posr_id;
	
	/** The pid. */
	private Integer  pid;
	
	/** The user_id. */
	private Integer user_id;
	
	/** The board_id. */
	private Integer board_id;
	
	/** The post. */
	private String post;
	
	/** The timestamp. */
	private String timestamp;
	
	/** The like. */
	private Integer like; 
 	
	//Methode, um den Text eines Posts zu setzen
	/**
	 * Sets the post.
	 *
	 * @param postText the new post
	 */
	public void setPost(String postText){
		post = postText;
	}
 
	//Methode, um den Text eines Posts zu erhalten
	/**
	 * Gets the post.
	 *
	 * @return the post
	 */
	public String getPost(){
		return post;
	}
	
	//Methode, um den Zeitpunkt eines Posts zu setzen
	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(String timestamp){
		this.timestamp = timestamp;
	}
	
	//Methode, um den Zeitpunkt eines Posts zu erhalten
	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public String getTimestamp(){
		return timestamp;
	}

	/**
	 * Gets the posr_id.
	 *
	 * @return the posr_id
	 */
	public Integer getPosr_id() {
		return posr_id;
	}

	/**
	 * Sets the posr_id.
	 *
	 * @param posr_id the new posr_id
	 */
	public void setPosr_id(Integer posr_id) {
		this.posr_id = posr_id;
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

	/**
	 * Gets the board_id.
	 *
	 * @return the board_id
	 */
	public Integer getBoard_id() {
		return board_id;
	}

	/**
	 * Sets the board_id.
	 *
	 * @param board_id the new board_id
	 */
	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}

	/**
	 * Gets the p id.
	 *
	 * @return the p id
	 */
	public int getPId() {
		return pid;
	}

	/**
	 * Sets the p id.
	 *
	 * @param id the new p id
	 */
	public void setPId(int id) {
		this.pid = id;
	}

	/**
	 * Gets the like.
	 *
	 * @return the like
	 */
	public int getLike() {
		return like;
	}

	/**
	 * Sets the like.
	 *
	 * @param like the new like
	 */
	public void setLike(int like) {
		this.like = like;
	}
	 
}