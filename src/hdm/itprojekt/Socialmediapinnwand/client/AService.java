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

@RemoteServiceRelativePath("asyncservice")
public interface AService extends RemoteService {

	void insertUser(User u);

	void insertPost(Post p);
	
	ArrayList<User> getAllUsers() throws IllegalArgumentException;

	User checkLogin(String nicknameBoxUser, String pwBoxUser);
	
	Vector<Post> getReportPostsByUserId (int pUserId) throws IllegalArgumentException;
	
	ArrayList<User> getAllUsersById(int id); // l�schen
	
	User getOneUserIdByNickname(String selectedNickname);
	
	int getPostsByUserId(int user_id);

	int getSubscriptionByUserId(int user_id);

	int getLikesByUserId(int user_id);

 
	Board getBoardIdFromUserID(int userId, String value);

	void createBoardByOwnUserId(int userID);

	boolean checkUserDuplicate(User u);

	User selectUserbyNickname(String selectedNickname2);
 
	ArrayList<Comment> getAllCommentsByOnePostId(int postIdTemp);

	int getAllPostsByOneUserId(Integer user_id);

	int getAllPostsByOneUserIdAndCount(Integer user_id);

	ArrayList<Post> getAllPostsObjectsByOneUserId(int id);

	void updateUser(User u);

	void deleteUser(User u);

	void deleteSubscriberInformations(int from_user_id);

	ArrayList<User> createSubscriberInformations(int from_user_id);

	ArrayList<User> getOneUserIdByID(int tempUserID);

	void deletePostByPostid(Integer postIdTemp);

	void setLikePostIterator(int couterlike, int postIdTemp);

	//String getOneNicknameFromUserId(int authorID);

	User getOneNicknameFromUserId(int authorID);

	Post loadPostForEdit(int postId);

 

	ArrayList<Comment> getAllPostsObjectsByOnePostId(int postID);

	int getCommentsByUserId(int userId);

	void createCommentByPostID(Comment c);

	void saveComment(Comment c);
	
	
	

	void deleteCommentsByCommentID(int commenId);

	Comment loadCommentsForEdit(int commentId);

	void saveCommentsForEdit(Comment c);

	void savePostForEdit(Post p);
	User getUserIdByUserNickname(User u);

	void createSubscriptionByUserId(Subscription s);

	ArrayList<Subscription> getAllSubscriptionsById(Subscription s);

	void deleteSubscriptionBySubscriptionID(Subscription s);

	//void deleteUser(DeleteUser u, AsyncCallback<Void> asyncCallback);
	
}