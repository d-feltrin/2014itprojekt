package hdm.itprojekt.Socialmediapinnwand.client;

import java.util.ArrayList;
import java.util.Vector;
import com.google.gwt.user.client.rpc.AsyncCallback;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.*;

public interface AServiceAsync {

	void insertUser(User u, AsyncCallback<Void> callback);

	void getAllUsers(AsyncCallback<ArrayList<User>> callback)
			throws IllegalArgumentException;

	void checkLogin(String nicknameBoxUser, String pwBoxUser,
			AsyncCallback<User> asyncCallback);

	void getReportPostsByUserId(int pUserId,
			AsyncCallback<Vector<Post>> callback);

	void getAllUsersById(int id, AsyncCallback<ArrayList<User>> callback);

 
	void getSubscriptionByUserId(int user_id, AsyncCallback<Integer> callback);

	void getLikesByUserId(int user_id, AsyncCallback<Integer> callback);

	void getOneUserIdByNickname(String selectedNickname,
			AsyncCallback<User> asyncCallback);

	void getBoardIdFromUserID(int userId, String value,
			AsyncCallback<Board> asyncCallback);

	void insertPost(Post p, AsyncCallback<Void> callback);

	void createBoardByOwnUserId(int userID, AsyncCallback<Void> asyncCallback);

	void checkUserDuplicate(User u, AsyncCallback<Boolean> asyncCallback);

	void selectUserbyNickname(String selectedNickname2,
			AsyncCallback<User> asyncCallback);

	void getAllPostsByOneUserId(Integer user_id,
			AsyncCallback<Integer> asyncCallback);

	void getAllPostsByOneUserIdAndCount(Integer user_id,
			AsyncCallback<Integer> asyncCallback);

	void getAllPostsObjectsByOneUserId(int id,
			AsyncCallback<ArrayList<Post>> asyncCallback);

	void getAllCommentsByOnePostId(int postIdTemp,
			AsyncCallback<ArrayList<Comment>> asyncCallback);

	void updateUser(User u, AsyncCallback<Void> asyncCallback);

	void deleteUser(User u, AsyncCallback<Void> asyncCallback);

	void deleteSubscriberInformations(int from_user_id,
			AsyncCallback<Void> asyncCallback);

	void createSubscriberInformations(int from_user_id,
			AsyncCallback<ArrayList<User>> asyncCallback);

	void getOneUserIdByID(int tempUserID,
			AsyncCallback<ArrayList<User>> asyncCallback);

	void setLikePostIterator(int couterlike, int postIdTemp,
			AsyncCallback<Void> asyncCallback);

	void deletePostByPostid(Integer postIdTemp,
			AsyncCallback<Void> asyncCallback);

	void getOneNicknameFromUserId(int authorID,
			AsyncCallback<User> asyncCallback);

	void loadPostForEdit(int postId, AsyncCallback<Post> asyncCallback);

	void savePostForEdit(Post p, AsyncCallback<Void> asyncCallback);

	void getAllPostsObjectsByOnePostId(int postID,
			AsyncCallback<ArrayList<Comment>> asyncCallback);

	void getCommentsByUserId(int userId, AsyncCallback<Integer> asyncCallback);

	void createCommentByPostID(Comment c, AsyncCallback<Void> asyncCallback);

	void saveComment(Comment c, AsyncCallback<Void> asyncCallback);

	void deleteCommentsByCommentID(int commenId,
			AsyncCallback<Void> asyncCallback);

	void loadCommentsForEdit(int commentId, AsyncCallback<Comment> asyncCallback);

	void saveCommentsForEdit(Comment c, AsyncCallback<Void> asyncCallback);

	void getUserIdByUserNickname(User u, AsyncCallback<User> callback);

	void createSubscriptionByUserId(Subscription s, AsyncCallback<Void> callback);

	void getAllSubscriptionsById(Subscription s,
			AsyncCallback<ArrayList<Subscription>> callback);

	void deleteSubscriptionBySubscriptionID(Subscription s,
			AsyncCallback<Void> callback);

	 

	void getPostsByUserId(int userid, AsyncCallback<Integer> asyncCallback);

	void getPostCountByUserId(int userId, AsyncCallback<Integer> asyncCallback);

	// void deleteUser(DeleteUser u, AsyncCallback<Void> asyncCallback);

}