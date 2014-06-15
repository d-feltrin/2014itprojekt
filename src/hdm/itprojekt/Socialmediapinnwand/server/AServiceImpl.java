package hdm.itprojekt.Socialmediapinnwand.server;

import java.util.ArrayList;
import java.util.Vector;
import hdm.itprojekt.Socialmediapinnwand.client.AService;
import hdm.itprojekt.Socialmediapinnwand.client.DeleteUser;
import hdm.itprojekt.Socialmediapinnwand.server.db.*;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Board;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Comment;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.OwnStringObject;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Post;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Subscription;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class AServiceImpl extends RemoteServiceServlet implements AService {

	private UserMapper uMapper = null;
	private PostMapper pMapper = null;
	private LoginMapper lMapper = null;
	private BoardMapper bMapper = null;
	private CommentMapper cMapper = null;
	private SubscriptionMapper sMapper = null;
	/**
	 * Initialize all database-mapper and extends service-servlet
	 */
	public void init() throws IllegalArgumentException {
		this.uMapper = UserMapper.userMapper();
		this.pMapper = PostMapper.postMapper();
		this.lMapper = LoginMapper.loginMapper();
		this.bMapper = BoardMapper.boardMapper();
		this.cMapper = CommentMapper.commentMapper();
		this.sMapper = SubscriptionMapper.subMapper();
		
	}

	public void insertUser(User u) {
		init();
		uMapper.insertUser(u);
	}
	
	public ArrayList<User> getOneUserIdByID(int id) {
		init();
		 ArrayList<User> u  =bMapper.getOneUserIdByID(id);
		 

		 if (!u.isEmpty()) {
			return u;
		} else {
			return null;
		}  
	 
	}
	 
	public void deleteUser(User u) {
		init();
		uMapper.deleteUser(u);
	}
	
	public boolean checkUserDuplicate(User u) {
		init();
		boolean a = uMapper.checkUserDuplicate(u);
		return a; 
	}
	
	@Override
	public ArrayList<User> getAllUsers() throws IllegalArgumentException {
		init();
		ArrayList<User> listit = uMapper.getAllUsers();
		if (!listit.isEmpty()) {
			return listit;
		} else {
			return null;
		}
	}

	public User checkLogin(String nicknameBoxUser, String pwBoxUser) {
		init();
		User u = new User();
		u = lMapper.checkLogin(nicknameBoxUser, pwBoxUser);

		if (u != null) {
			return u;
		} else {
			return null;
		}
	}
	
	@Override
	public void updateUser(User u){
		init();
		uMapper.updateUser(u);

 	}

	@Override
	public Vector<Post> getReportPostsByUserId(int pUserId)
			throws IllegalArgumentException {
	init();
	
		return pMapper.getReportPostsByUserId(pUserId);
	}

	@Override
	public ArrayList<User> getAllUsersById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPostsByUserId(int user_id) {
			init();
			int postCount = pMapper.getPostCountByUserId(user_id);
			return postCount;
	}
	
	@Override
	public int getSubscriptionByUserId(int user_id) {
			init();
			int postCount = pMapper.getSubscriptionCountByUserId(user_id);
			return postCount;
	}
	
	 
	
	@Override
	public int getLikesByUserId(int user_id) {
			init();
			int postCount = pMapper.getLikesCountByUserId(user_id);
			return postCount;
	}
	
	@Override
	public User getOneUserIdByNickname(String selectedNickname) {
			init();
			

			User a = new User();
			 
			 a = pMapper.getOneUserIdByNicknameMapper(selectedNickname) ;
			
			//OwnStringObject a  = new OwnStringObject(post);
			
			//selectNick =  pMapper.getOneUserIdByNicknameMapper(selectedNickname);
			
			
		//	selectNickBack = (int)selectNick;
			return a;
	}
	
	@Override
	public int getAllPostsByOneUserId(Integer user_id) {
			init();
			int postCount = pMapper.getAllPostsByOneUserId(user_id);
			return postCount;
	}

	@Override
	public Board getBoardIdFromUserID(int userId, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createBoardByOwnUserId(int userID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User selectUserbyNickname(String selectedNickname2) {
		 
		init();
		User u = uMapper.getAllPostsByOneUserId(selectedNickname2);
		return u;
	}

	@Override
	public ArrayList<Comment> getAllCommentsByOnePostId(int postIdTemp) {

		init();
		 ArrayList<Comment>  c = pMapper.getAllCommentsByOnePostId(postIdTemp);
		 if (!c.isEmpty()) {
				return c;
			} else {
				return null;
			}  
		 
		 
 	}

	@Override
	public int getAllPostsByOneUserIdAndCount(Integer user_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public ArrayList<Post> getAllPostsObjectsByOneUserId(int id) {
 
		init();
		
		ArrayList<Post> u = pMapper.getAllPostsObjectsByOneUserId(id);
	 
		if (u != null) {
			return u;
		} else {
 return null;
}
		 
	}

	@Override
	public void deleteSubscriberInformations(int from_user_id) {
		bMapper.deleteSubscriberInformations(from_user_id);
		
	}

	@Override
	public ArrayList<User> createSubscriberInformations(int from_user_id) {
		init();
		 ArrayList<User>  u = bMapper.createSubscriberInformations(from_user_id);
		return u;
	}

 	public void insertPost(Post p) {
		init();
		pMapper.insertPost(p);		
	}

	@Override
	public void setLikePostIterator(int couterlike, int postIdTemp) {
		init();
	 pMapper.setLikePostIterator(couterlike,postIdTemp);
		 	
	}

	@Override
	public void deletePostByPostid(Integer postIdTemp) {
		init();
		  pMapper.deletePostByPostid(postIdTemp);		
	}

	@Override
	public User getOneNicknameFromUserId(int authorID) {
		init();
		
		  User u = uMapper.getOneNicknameFromUserId(authorID);	
 		return u;
	}

	@Override
	public Post loadPostForEdit(int postId) {
		 
		init();
		Post p = pMapper.loadPostForEdit(postId); 
		
		return p;
	}

	@Override
	public void savePostForEdit(Post p) {
	 
		init();
		 pMapper.savePostForEdit(p); 
		
 	}

	@Override
	public ArrayList<Comment> getAllPostsObjectsByOnePostId(int postID) {
 
			init();
			ArrayList<Comment> c=  pMapper.getAllCommentsByOnePostId(postID); 
			return c; 
		 
	}

	@Override
	public int getCommentsByUserId(int user_id) {
			init();
			int postCount = pMapper.getCommentsCountByUserId(user_id);
			return postCount;
	}

	@Override
	public void createCommentByPostID(Comment c) {
		init();
		cMapper.createCommentByPostID(c);
		
	}

	@Override
	public void saveComment(Comment c) {
		init();
		 cMapper.saveCommentsForEdit(c);  
		
	}

	@Override
	public void deleteCommentsByCommentID(int commenId) {
		 
		init();
		 cMapper.deleteCommentsByCommentID(commenId);  
		
	}

	@Override
	public Comment loadCommentsForEdit(int commentId) {
		init();
		Comment c = cMapper.loadCommentsForEdit(commentId); 

		
		return c;
	}

	 

	@Override
	public void saveCommentsForEdit(Comment c) {
		init();
		  cMapper.saveCommentsForEdit(c); 
				
	}
	
	@Override
	public User getUserIdByUserNickname(User u) {
		init();
		return uMapper.getUserIdByUserNickname(u);
	}

	@Override
	public void createSubscriptionByUserId(Subscription s) {
		init();
		sMapper.createSubscriptionByUserId(s);

	}

	@Override
	public ArrayList<Subscription> getAllSubscriptionsById(Subscription sub) {
		init();
		ArrayList<Subscription> sp = sMapper.getAllSubscriptionsById(sub);

		if (!sp.isEmpty()) {
			return sp;
		} else {
			return null;
		}

	}

	@Override
	public void deleteSubscriptionBySubscriptionID(Subscription s) {
		init();
		sMapper.deleteSubscriptionBySubscriptionID(s);

	}

	/*@Override
	public void deleteUser(DeleteUser u, AsyncCallback<Void> asyncCallback) {
	
			init();
			uMapper.deleteUser(u);
		
	}
*/

/*
	@Override
	public void createBoardByOwnUserId(int userID) {
 		init();
	//	Board postCount = pMapper.createBoardByUserID(userID);
 	} 
	
	*/
}