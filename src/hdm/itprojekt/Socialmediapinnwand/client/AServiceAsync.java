package hdm.itprojekt.Socialmediapinnwand.client;

import java.util.ArrayList;
import java.util.Vector;
import com.google.gwt.user.client.rpc.AsyncCallback;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.*;

// TODO: Auto-generated Javadoc
/**
 * The Interface AServiceAsync.
 */
public interface AServiceAsync {

	/**
	 * Insert user.
	 *
	 * @param u the u
	 * @param callback the callback
	 */
	void insertUser(User u, AsyncCallback<Void> callback);

	/**
	 * Gets the all users.
	 *
	 * @param callback the callback
	 * @return the all users
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	void getAllUsers(AsyncCallback<ArrayList<User>> callback)
			throws IllegalArgumentException;

	/**
	 * Check login.
	 *
	 * @param nicknameBoxUser the nickname box user
	 * @param pwBoxUser the pw box user
	 * @param asyncCallback the async callback
	 */
	void checkLogin(String nicknameBoxUser, String pwBoxUser,
			AsyncCallback<User> asyncCallback);

	/**
	 * Gets the report posts by user id.
	 *
	 * @param pUserId the user id
	 * @param callback the callback
	 * @return the report posts by user id
	 */
	void getReportPostsByUserId(int pUserId,
			AsyncCallback<Vector<Post>> callback);

	/**
	 * Gets the all users by id.
	 *
	 * @param id the id
	 * @param callback the callback
	 * @return the all users by id
	 */
	void getAllUsersById(int id, AsyncCallback<ArrayList<User>> callback);

 
	/**
	 * Gets the subscription by user id.
	 *
	 * @param user_id the user_id
	 * @param callback the callback
	 * @return the subscription by user id
	 */
	void getSubscriptionByUserId(int user_id, AsyncCallback<Integer> callback);

	/**
	 * Gets the likes by user id.
	 *
	 * @param user_id the user_id
	 * @param callback the callback
	 * @return the likes by user id
	 */
	void getLikesByUserId(int user_id, AsyncCallback<Integer> callback);

	/**
	 * Gets the one user id by nickname.
	 *
	 * @param selectedNickname the selected nickname
	 * @param asyncCallback the async callback
	 * @return the one user id by nickname
	 */
	void getOneUserIdByNickname(String selectedNickname,
			AsyncCallback<User> asyncCallback);

	/**
	 * Gets the board id from user id.
	 *
	 * @param userId the user id
	 * @param value the value
	 * @param asyncCallback the async callback
	 * @return the board id from user id
	 */
	void getBoardIdFromUserID(int userId, String value,
			AsyncCallback<Board> asyncCallback);

	/**
	 * Insert post.
	 *
	 * @param p the p
	 * @param callback the callback
	 */
	void insertPost(Post p, AsyncCallback<Void> callback);

	/**
	 * Creates the board by own user id.
	 *
	 * @param userID the user id
	 * @param asyncCallback the async callback
	 */
	void createBoardByOwnUserId(int userID, AsyncCallback<Void> asyncCallback);

	/**
	 * Check user duplicate.
	 *
	 * @param u the u
	 * @param asyncCallback the async callback
	 */
	void checkUserDuplicate(User u, AsyncCallback<Boolean> asyncCallback);

	/**
	 * Select userby nickname.
	 *
	 * @param selectedNickname2 the selected nickname2
	 * @param asyncCallback the async callback
	 */
	void selectUserbyNickname(String selectedNickname2,
			AsyncCallback<User> asyncCallback);

	/**
	 * Gets the all posts by one user id.
	 *
	 * @param user_id the user_id
	 * @param asyncCallback the async callback
	 * @return the all posts by one user id
	 */
	void getAllPostsByOneUserId(Integer user_id,
			AsyncCallback<Integer> asyncCallback);

	/**
	 * Gets the all posts by one user id and count.
	 *
	 * @param user_id the user_id
	 * @param asyncCallback the async callback
	 * @return the all posts by one user id and count
	 */
	void getAllPostsByOneUserIdAndCount(Integer user_id,
			AsyncCallback<Integer> asyncCallback);

	/**
	 * Gets the all posts objects by one user id.
	 *
	 * @param id the id
	 * @param asyncCallback the async callback
	 * @return the all posts objects by one user id
	 */
	void getAllPostsObjectsByOneUserId(int id,
			AsyncCallback<ArrayList<Post>> asyncCallback);

	/**
	 * Gets the all comments by one post id.
	 *
	 * @param postIdTemp the post id temp
	 * @param asyncCallback the async callback
	 * @return the all comments by one post id
	 */
	void getAllCommentsByOnePostId(int postIdTemp,
			AsyncCallback<ArrayList<Comment>> asyncCallback);

	/**
	 * Update user.
	 *
	 * @param u the u
	 * @param asyncCallback the async callback
	 */
	void updateUser(User u, AsyncCallback<Void> asyncCallback);

	/**
	 * Delete user.
	 *
	 * @param u the u
	 * @param asyncCallback the async callback
	 */
	void deleteUser(User u, AsyncCallback<Void> asyncCallback);

	/**
	 * Delete subscriber informations.
	 *
	 * @param from_user_id the from_user_id
	 * @param asyncCallback the async callback
	 */
	void deleteSubscriberInformations(int from_user_id,
			AsyncCallback<Void> asyncCallback);

	/**
	 * Creates the subscriber informations.
	 *
	 * @param from_user_id the from_user_id
	 * @param asyncCallback the async callback
	 */
	void createSubscriberInformations(int from_user_id,
			AsyncCallback<ArrayList<User>> asyncCallback);

	/**
	 * Gets the one user id by id.
	 *
	 * @param tempUserID the temp user id
	 * @param asyncCallback the async callback
	 * @return the one user id by id
	 */
	void getOneUserIdByID(int tempUserID,
			AsyncCallback<ArrayList<User>> asyncCallback);

	/**
	 * Sets the like post iterator.
	 *
	 * @param couterlike the couterlike
	 * @param postIdTemp the post id temp
	 * @param asyncCallback the async callback
	 */
	void setLikePostIterator(int couterlike, int postIdTemp,
			AsyncCallback<Void> asyncCallback);

	/**
	 * Delete post by postid.
	 *
	 * @param postIdTemp the post id temp
	 * @param asyncCallback the async callback
	 */
	void deletePostByPostid(Integer postIdTemp,
			AsyncCallback<Void> asyncCallback);

	/**
	 * Gets the one nickname from user id.
	 *
	 * @param authorID the author id
	 * @param asyncCallback the async callback
	 * @return the one nickname from user id
	 */
	void getOneNicknameFromUserId(int authorID,
			AsyncCallback<User> asyncCallback);

	/**
	 * Load post for edit.
	 *
	 * @param postId the post id
	 * @param asyncCallback the async callback
	 */
	void loadPostForEdit(int postId, AsyncCallback<Post> asyncCallback);

	/**
	 * Save post for edit.
	 *
	 * @param p the p
	 * @param asyncCallback the async callback
	 */
	void savePostForEdit(Post p, AsyncCallback<Void> asyncCallback);

	/**
	 * Gets the all posts objects by one post id.
	 *
	 * @param postID the post id
	 * @param asyncCallback the async callback
	 * @return the all posts objects by one post id
	 */
	void getAllPostsObjectsByOnePostId(int postID,
			AsyncCallback<ArrayList<Comment>> asyncCallback);

	/**
	 * Gets the comments by user id.
	 *
	 * @param userId the user id
	 * @param asyncCallback the async callback
	 * @return the comments by user id
	 */
	void getCommentsByUserId(int userId, AsyncCallback<Integer> asyncCallback);

	/**
	 * Creates the comment by post id.
	 *
	 * @param c the c
	 * @param asyncCallback the async callback
	 */
	void createCommentByPostID(Comment c, AsyncCallback<Void> asyncCallback);

	/**
	 * Save comment.
	 *
	 * @param c the c
	 * @param asyncCallback the async callback
	 */
	void saveComment(Comment c, AsyncCallback<Void> asyncCallback);

	/**
	 * Delete comments by comment id.
	 *
	 * @param commenId the commen id
	 * @param asyncCallback the async callback
	 */
	void deleteCommentsByCommentID(int commenId,
			AsyncCallback<Void> asyncCallback);

	/**
	 * Load comments for edit.
	 *
	 * @param commentId the comment id
	 * @param asyncCallback the async callback
	 */
	void loadCommentsForEdit(int commentId, AsyncCallback<Comment> asyncCallback);

	/**
	 * Save comments for edit.
	 *
	 * @param c the c
	 * @param asyncCallback the async callback
	 */
	void saveCommentsForEdit(Comment c, AsyncCallback<Void> asyncCallback);

	/**
	 * Gets the user id by user nickname.
	 *
	 * @param u the u
	 * @param callback the callback
	 * @return the user id by user nickname
	 */
	void getUserIdByUserNickname(User u, AsyncCallback<User> callback);

	/**
	 * Creates the subscription by user id.
	 *
	 * @param s the s
	 * @param callback the callback
	 */
	void createSubscriptionByUserId(Subscription s, AsyncCallback<Void> callback);

	/**
	 * Gets the all subscriptions by id.
	 *
	 * @param s the s
	 * @param callback the callback
	 * @return the all subscriptions by id
	 */
	void getAllSubscriptionsById(Subscription s,
			AsyncCallback<ArrayList<Subscription>> callback);

	/**
	 * Delete subscription by subscription id.
	 *
	 * @param s the s
	 * @param callback the callback
	 */
	void deleteSubscriptionBySubscriptionID(Subscription s,
			AsyncCallback<Void> callback);

	 

	/**
	 * Gets the posts by user id.
	 *
	 * @param userid the userid
	 * @param asyncCallback the async callback
	 * @return the posts by user id
	 */
	void getPostsByUserId(int userid, AsyncCallback<Integer> asyncCallback);

	/**
	 * Gets the all likes by user id.
	 *
	 * @param userid the userid
	 * @param asyncCallback the async callback
	 * @return the all likes by user id
	 */
	void getAllLikesByUserId(int userid, AsyncCallback<Integer> asyncCallback);

	/**
	 * Gets the subscriptions by user id.
	 *
	 * @param userid the userid
	 * @param asyncCallback the async callback
	 * @return the subscriptions by user id
	 */
	void getSubscriptionsByUserId(int userid,
			AsyncCallback<Integer> asyncCallback);

	/**
	 * Gets the all comments count by user id.
	 *
	 * @param userid the userid
	 * @param asyncCallback the async callback
	 * @return the all comments count by user id
	 */
	void getAllCommentsCountByUserId(int userid,
			AsyncCallback<Integer> asyncCallback);

	/**
	 * Gets the all posts by date intervall.
	 *
	 * @param user_id the user_id
	 * @param fromDate the from date
	 * @param toDate the to date
	 * @param asyncCallback the async callback
	 * @return the all posts by date intervall
	 */
	void getAllPostsByDateIntervall(int user_id, String fromDate,
			String toDate, AsyncCallback<ArrayList<Post>> asyncCallback);

 
	
	
 
}