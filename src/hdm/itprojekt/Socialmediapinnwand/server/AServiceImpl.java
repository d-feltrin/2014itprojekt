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

// TODO: Auto-generated Javadoc
/**
 * The Class AServiceImpl.
 */
public class AServiceImpl extends RemoteServiceServlet implements AService {

	/** The u mapper. */
	private UserMapper uMapper = null;
	
	/** The p mapper. */
	private PostMapper pMapper = null;
	
	/** The l mapper. */
	private LoginMapper lMapper = null;
	
	/** The b mapper. */
	private BoardMapper bMapper = null;
	
	/** The c mapper. */
	private CommentMapper cMapper = null;
	
	/** The s mapper. */
	private SubscriptionMapper sMapper = null;
	
	/**
	 * Initialize all database-mapper and extends service-servlet.
	 *
	 * @throws IllegalArgumentException the illegal argument exception
	 */
	public void init() throws IllegalArgumentException {
		this.uMapper = UserMapper.userMapper();
		this.pMapper = PostMapper.postMapper();
		this.lMapper = LoginMapper.loginMapper();
		this.bMapper = BoardMapper.boardMapper();
		this.cMapper = CommentMapper.commentMapper();
		this.sMapper = SubscriptionMapper.subMapper();
		
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#insertUser(hdm.itprojekt.Socialmediapinnwand.shared.bo.User)
	 */
	public void insertUser(User u) {
		init();
		uMapper.insertUser(u);
	}
	
	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getOneUserIdByID(int)
	 */
	public ArrayList<User> getOneUserIdByID(int id) {
		init();
		 ArrayList<User> u  =bMapper.getOneUserIdByID(id);
		 

		 if (!u.isEmpty()) {
			return u;
		} else {
			return null;
		}  
	 
	}
	 
	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#deleteUser(hdm.itprojekt.Socialmediapinnwand.shared.bo.User)
	 */
	public void deleteUser(User u) {
		init();
		uMapper.deleteUser(u);
	}
	
	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#checkUserDuplicate(hdm.itprojekt.Socialmediapinnwand.shared.bo.User)
	 */
	public boolean checkUserDuplicate(User u) {
		init();
		boolean a = uMapper.checkUserDuplicate(u);
		return a; 
	}
	
	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getAllUsers()
	 */
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

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#checkLogin(java.lang.String, java.lang.String)
	 */
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
	
	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#updateUser(hdm.itprojekt.Socialmediapinnwand.shared.bo.User)
	 */
	@Override
	public void updateUser(User u){
		init();
		uMapper.updateUser(u);

 	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getReportPostsByUserId(int)
	 */
	@Override
	public Vector<Post> getReportPostsByUserId(int pUserId)
			throws IllegalArgumentException {
	init();
	
		return pMapper.getReportPostsByUserId(pUserId);
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getAllUsersById(int)
	 */
	@Override
	public ArrayList<User> getAllUsersById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getPostsByUserId(int)
	 */
	@Override
	public int getPostsByUserId(int user_id) {
			init();
 
			int postCount = pMapper.getPostCountByUserId(user_id);
			return postCount;
	}
	
	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getSubscriptionByUserId(int)
	 */
	@Override
	public int getSubscriptionByUserId(int user_id) {
			init();
			int postCount = pMapper.getSubscriptionCountByUserId(user_id);
			return postCount;
	}
	
	 
	
	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getLikesByUserId(int)
	 */
	@Override
	public int getLikesByUserId(int user_id) {
			init();
			int postCount = pMapper.getLikesCountByUserId(user_id);
			return postCount;
	}
	
	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getOneUserIdByNickname(java.lang.String)
	 */
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
	
	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getAllPostsByOneUserId(java.lang.Integer)
	 */
	@Override
	public int getAllPostsByOneUserId(Integer user_id) {
			init();
			int postCount = pMapper.getAllPostsByOneUserId(user_id);
			return postCount;
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getBoardIdFromUserID(int, java.lang.String)
	 */
	@Override
	public Board getBoardIdFromUserID(int userId, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#createBoardByOwnUserId(int)
	 */
	@Override
	public void createBoardByOwnUserId(int userID) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#selectUserbyNickname(java.lang.String)
	 */
	@Override
	public User selectUserbyNickname(String selectedNickname2) {
		 
		init();
		User u = uMapper.getAllPostsByOneUserId(selectedNickname2);
		return u;
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getAllCommentsByOnePostId(int)
	 */
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

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getAllPostsByOneUserIdAndCount(java.lang.Integer)
	 */
	@Override
	public int getAllPostsByOneUserIdAndCount(Integer user_id) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getAllPostsObjectsByOneUserId(int)
	 */
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

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#deleteSubscriberInformations(int)
	 */
	@Override
	public void deleteSubscriberInformations(int from_user_id) {
		bMapper.deleteSubscriberInformations(from_user_id);
		
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#createSubscriberInformations(int)
	 */
	@Override
	public ArrayList<User> createSubscriberInformations(int from_user_id) {
		init();
		 ArrayList<User>  u = bMapper.createSubscriberInformations(from_user_id);
		return u;
	}

 	/* (non-Javadoc)
	  * @see hdm.itprojekt.Socialmediapinnwand.client.AService#insertPost(hdm.itprojekt.Socialmediapinnwand.shared.bo.Post)
	  */
	 public void insertPost(Post p) {
		init();
		pMapper.insertPost(p);		
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#setLikePostIterator(int, int)
	 */
	@Override
	public void setLikePostIterator(int couterlike, int postIdTemp) {
		init();
	 pMapper.setLikePostIterator(couterlike,postIdTemp);
		 	
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#deletePostByPostid(java.lang.Integer)
	 */
	@Override
	public void deletePostByPostid(Integer postIdTemp) {
		init();
		  pMapper.deletePostByPostid(postIdTemp);		
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getOneNicknameFromUserId(int)
	 */
	@Override
	public User getOneNicknameFromUserId(int authorID) {
		init();
		
		  User u = uMapper.getOneNicknameFromUserId(authorID);	
 		return u;
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#loadPostForEdit(int)
	 */
	@Override
	public Post loadPostForEdit(int postId) {
		 
		init();
		Post p = pMapper.loadPostForEdit(postId); 
		
		return p;
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#savePostForEdit(hdm.itprojekt.Socialmediapinnwand.shared.bo.Post)
	 */
	@Override
	public void savePostForEdit(Post p) {
	 
		init();
		 pMapper.savePostForEdit(p); 
		
 	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getAllPostsObjectsByOnePostId(int)
	 */
	@Override
	public ArrayList<Comment> getAllPostsObjectsByOnePostId(int postID) {
 
			init();
			ArrayList<Comment> c=  pMapper.getAllCommentsByOnePostId(postID); 
			return c; 
		 
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getCommentsByUserId(int)
	 */
	@Override
	public int getCommentsByUserId(int user_id) {
			init();
			int postCount = pMapper.getCommentsCountByUserId(user_id);
			return postCount;
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#createCommentByPostID(hdm.itprojekt.Socialmediapinnwand.shared.bo.Comment)
	 */
	@Override
	public void createCommentByPostID(Comment c) {
		init();
		cMapper.createCommentByPostID(c);
		
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#saveComment(hdm.itprojekt.Socialmediapinnwand.shared.bo.Comment)
	 */
	@Override
	public void saveComment(Comment c) {
		init();
		 cMapper.saveCommentsForEdit(c);  
		
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#deleteCommentsByCommentID(int)
	 */
	@Override
	public void deleteCommentsByCommentID(int commenId) {
		 
		init();
		 cMapper.deleteCommentsByCommentID(commenId);  
		
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#loadCommentsForEdit(int)
	 */
	@Override
	public Comment loadCommentsForEdit(int commentId) {
		init();
		Comment c = cMapper.loadCommentsForEdit(commentId); 

		
		return c;
	}

	 

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#saveCommentsForEdit(hdm.itprojekt.Socialmediapinnwand.shared.bo.Comment)
	 */
	@Override
	public void saveCommentsForEdit(Comment c) {
		init();
		  cMapper.saveCommentsForEdit(c); 
				
	}
	
	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getUserIdByUserNickname(hdm.itprojekt.Socialmediapinnwand.shared.bo.User)
	 */
	@Override
	public User getUserIdByUserNickname(User u) {
		init();
		return uMapper.getUserIdByUserNickname(u);
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#createSubscriptionByUserId(hdm.itprojekt.Socialmediapinnwand.shared.bo.Subscription)
	 */
	@Override
	public void createSubscriptionByUserId(Subscription s) {
		init();
		sMapper.createSubscriptionByUserId(s);

	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getAllSubscriptionsById(hdm.itprojekt.Socialmediapinnwand.shared.bo.Subscription)
	 */
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

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#deleteSubscriptionBySubscriptionID(hdm.itprojekt.Socialmediapinnwand.shared.bo.Subscription)
	 */
	@Override
	public void deleteSubscriptionBySubscriptionID(Subscription s) {
		init();
		sMapper.deleteSubscriptionBySubscriptionID(s);

	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getAllLikesByUserId(int)
	 */
	@Override
	public int getAllLikesByUserId(int userid) {
		init();
		 
		int likeCount = pMapper.getLikeCountByUserId(userid);
		return likeCount;
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getSubscriptionsByUserId(int)
	 */
	@Override
	public int getSubscriptionsByUserId(int userid) {
		init();
		int subCount = pMapper.getSubscriptionsByUserId(userid);
		return subCount;
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getAllCommentsCountByUserId(int)
	 */
	@Override
	public int getAllCommentsCountByUserId(int userid) {
		init();
		int commentCount = pMapper.getAllCommentsCountByUserId(userid);
		return commentCount;
	}

	/* (non-Javadoc)
	 * @see hdm.itprojekt.Socialmediapinnwand.client.AService#getAllPostsByDateIntervall(int, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<Post> getAllPostsByDateIntervall(int user_id, String fromDate,
			String toDate) {
		 
		init();
		ArrayList<Post>   p = pMapper.getAllPostsByDateIntervall(user_id,fromDate, toDate );
		return p;
		
		 
	}

 
}