package hdm.itprojekt.Socialmediapinnwand.shared.bo;

public class Comment extends BusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*Folgende Attribute ben�tigt die Klasse Comment, um einen Kommentar laut Anforderungen
	beschreiben zu k�nnen*/
	private String commentText;
	private int commentId;
	private String timestamp;
	private int commentPostId;
	private int fromCommentId;
	private String CommentFromUserNickname;
	
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getCommentPostId() {
		return commentPostId;
	}
	public void setCommentPostId(int commentPostId) {
		this.commentPostId = commentPostId;
	}
	public int getFromCommentId() {
		return fromCommentId;
	}
	public void setFromCommentId(int fromCommentId) {
		this.fromCommentId = fromCommentId;
	}
	public String getCommentFromUserNickname() {
		return CommentFromUserNickname;
	}
	public void setCommentFromUserNickname(String commentFromUserNickname) {
		CommentFromUserNickname = commentFromUserNickname;
	}
	
	
	
}
