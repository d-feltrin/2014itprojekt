package hdm.itprojekt.Socialmediapinnwand.shared.bo;

public class Post extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*Folgende Attribute ben�tigt die Klasse Post, um ein Posting laut Anforderungen
	beschreiben zu k�nnen*/
	private Integer posr_id;
	private Integer  pid;
	private Integer user_id;
	private Integer board_id;
	private String post;
	private String timestamp;
	private Integer like; 
 	
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
		this.timestamp = timestamp;
	}
	
	//Methode, um den Zeitpunkt eines Posts zu erhalten
	public String getTimestamp(){
		return timestamp;
	}

	public Integer getPosr_id() {
		return posr_id;
	}

	public void setPosr_id(Integer posr_id) {
		this.posr_id = posr_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public Integer getBoard_id() {
		return board_id;
	}

	public void setBoard_id(Integer board_id) {
		this.board_id = board_id;
	}

	public int getPId() {
		return pid;
	}

	public void setPId(int id) {
		this.pid = id;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}
	 
}