package hdm.itprojekt.Socialmediapinnwand.client;

import java.util.ArrayList;
import java.util.Vector;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Board;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Comment;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.OwnStringObject;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Post;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Subscription;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface AService.
 */
@RemoteServiceRelativePath("asyncservice")
public interface AService extends RemoteService {

	/**
	 * Insert user.
	 *
	 * @param u the u
	 */
	void insertUser(User u);

	/**
	 * Insert post.
	 *
	 * @param p the p
	 */
	void insertPost(Post p);
	
	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	ArrayList<User> getAllUsers() throws IllegalArgumentException;

	/**
	 * Check login.
	 *
	 * @param nicknameBoxUser the nickname box user
	 * @param pwBoxUser the pw box user
	 * @return the user
	 */
	User checkLogin(String nicknameBoxUser, String pwBoxUser);
	
	/**
	 * Gets the report posts by user id.
	 *
	 * @param pUserId the user id
	 * @return the report posts by user id
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	Vector<Post> getReportPostsByUserId (int pUserId) throws IllegalArgumentException;
	
	/**
	 * Gets the all users by id.
	 *
	 * @param id the id
	 * @return the all users by id
	 */
	ArrayList<User> getAllUsersById(int id); 
	
	/**
	 * Gets the one user id by nickname.
	 *
	 * @param selectedNickname the selected nickname
	 * @return the one user id by nickname
	 */
	User getOneUserIdByNickname(String selectedNickname);
	
	/**
	 * Gets the subscription by user id.
	 *
	 * @param user_id the user_id
	 * @return the subscription by user id
	 */
	int getSubscriptionByUserId(int user_id);

	/**
	 * Gets the likes by user id.
	 *
	 * @param user_id the user_id
	 * @return the likes by user id
	 */
	int getLikesByUserId(int user_id);

	/**
	 * Gets the board id from user id.
	 *
	 * @param userId the user id
	 * @param value the value
	 * @return the board id from user id
	 */
	Board getBoardIdFromUserID(int userId, String value);

	/**
	 * Creates the board by own user id.
	 *
	 * @param userID the user id
	 */
	void createBoardByOwnUserId(int userID);

	/**
	 * Check user duplicate.
	 *
	 * @param u the u
	 * @return true, if successful
	 */
	boolean checkUserDuplicate(User u);

	/**
	 * Select userby nickname.
	 *
	 * @param selectedNickname2 the selected nickname2
	 * @return the user
	 */
	User selectUserbyNickname(String selectedNickname2);
 
	/**
	 * Gets the all comments by one post id.
	 *
	 * @param postIdTemp the post id temp
	 * @return the all comments by one post id
	 */
	ArrayList<Comment> getAllCommentsByOnePostId(int postIdTemp);

	/**
	 * Gets the all posts by one user id.
	 *
	 * @param user_id the user_id
	 * @return the all posts by one user id
	 */
	int getAllPostsByOneUserId(Integer user_id);

	/**
	 * Gets the all posts by one user id and count.
	 *
	 * @param user_id the user_id
	 * @return the all posts by one user id and count
	 */
	int getAllPostsByOneUserIdAndCount(Integer user_id);

	/**
	 * Gets the all posts objects by one user id.
	 *
	 * @param id the id
	 * @return the all posts objects by one user id
	 */
	ArrayList<Post> getAllPostsObjectsByOneUserId(int id);

	/**
	 * Update user.
	 *
	 * @param u the u
	 */
	void updateUser(User u);

	/**
	 * Delete user.
	 *
	 * @param u the u
	 */
	void deleteUser(User u);

	/**
	 * Delete subscriber informations.
	 *
	 * @param from_user_id the from_user_id
	 */
	void deleteSubscriberInformations(int from_user_id);

	/**
	 * Creates the subscriber informations.
	 *
	 * @param from_user_id the from_user_id
	 * @return the array list
	 */
	ArrayList<User> createSubscriberInformations(int from_user_id);

	/**
	 * Gets the one user id by id.
	 *
	 * @param tempUserID the temp user id
	 * @return the one user id by id
	 */
	ArrayList<User> getOneUserIdByID(int tempUserID);

	/**
	 * Delete post by postid.
	 *
	 * @param postIdTemp the post id temp
	 */
	void deletePostByPostid(Integer postIdTemp);

	/**
	 * Sets the like post iterator.
	 *
	 * @param couterlike the couterlike
	 * @param postIdTemp the post id temp
	 */
	void setLikePostIterator(int couterlike, int postIdTemp);

	/**
	 * Gets the one nickname from user id.
	 *
	 * @param authorID the author id
	 * @return the one nickname from user id
	 */
	User getOneNicknameFromUserId(int authorID);

	/**
	 * Load post for edit.
	 *
	 * @param postId the post id
	 * @return the post
	 */
	Post loadPostForEdit(int postId);

	/**
	 * Gets the all posts objects by one post id.
	 *
	 * @param postID the post id
	 * @return the all posts objects by one post id
	 */
	ArrayList<Comment> getAllPostsObjectsByOnePostId(int postID);

	/**
	 * Gets the comments by user id.
	 *
	 * @param userId the user id
	 * @return the comments by user id
	 */
	int getCommentsByUserId(int userId);

	/**
	 * Creates the comment by post id.
	 *
	 * @param c the c
	 */
	void createCommentByPostID(Comment c);

	/**
	 * Save comment.
	 *
	 * @param c the c
	 */
	void saveComment(Comment c);

	/**
	 * Delete comments by comment id.
	 *
	 * @param commenId the commen id
	 */
	void deleteCommentsByCommentID(int commenId);

	/**
	 * Load comments for edit.
	 *
	 * @param commentId the comment id
	 * @return the comment
	 */
	Comment loadCommentsForEdit(int commentId);

	/**
	 * Save comments for edit.
	 *
	 * @param c the c
	 */
	void saveCommentsForEdit(Comment c);

	/**
	 * Save post for edit.
	 *
	 * @param p the p
	 */
	void savePostForEdit(Post p);
	
	/**
	 * Gets the user id by user nickname.
	 *
	 * @param u the u
	 * @return the user id by user nickname
	 */
	User getUserIdByUserNickname(User u);

	/**
	 * Creates the subscription by user id.
	 *
	 * @param s the s
	 */
	void createSubscriptionByUserId(Subscription s);

	/**
	 * Gets the all subscriptions by id.
	 *
	 * @param s the s
	 * @return the all subscriptions by id
	 */
	ArrayList<Subscription> getAllSubscriptionsById(Subscription s);

	/**
	 * Delete subscription by subscription id.
	 *
	 * @param s the s
	 */
	void deleteSubscriptionBySubscriptionID(Subscription s);

	/**
	 * Gets the posts by user id.
	 *
	 * @param userid the userid
	 * @return the posts by user id
	 */
	int getPostsByUserId(int userid);

	/**
	 * Gets the all likes by user id.
	 *
	 * @param userid the userid
	 * @return the all likes by user id
	 */
	int getAllLikesByUserId(int userid);

	/**
	 * Gets the subscriptions by user id.
	 *
	 * @param userid the userid
	 * @return the subscriptions by user id
	 */
	int getSubscriptionsByUserId(int userid);

 
	/**
	 * Gets the all comments count by user id.
	 *
	 * @param userid the userid
	 * @return the all comments count by user id
	 */
	int getAllCommentsCountByUserId(int userid);

	/**
	 * Gets the all posts by date intervall.
	 *
	 * @param user_id the user_id
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @return the all posts by date intervall
	 */
	ArrayList<Post> getAllPostsByDateIntervall(int user_id, String fromDate,
			String toDate);

 

	//void deleteUser(DeleteUser u, AsyncCallback<Void> asyncCallback);
	
}