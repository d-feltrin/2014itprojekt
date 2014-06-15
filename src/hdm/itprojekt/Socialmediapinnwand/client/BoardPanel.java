package hdm.itprojekt.Socialmediapinnwand.client;
 
import java.util.ArrayList;
import hdm.itprojekt.Socialmediapinnwand.client.gui.BoardOverview;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Board;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Post;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Subscription;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.User;
import hdm.itprojekt.Socialmediapinnwand.shared.bo.Comment;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.thirdparty.javascript.rhino.head.ast.ThrowStatement;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RichTextArea;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class BoardPanel extends HorizontalPanel {
	

	final Label postVpHeadline = new Label("was");
	final Label postVpSubline = new Label("In diesem Ranking werden Ihnen die User sortiert angezeigt, die am Meisten Beiträge verfasst haben. ");
	final  private FlexTable FlexTableTemp = new FlexTable();
	int counter = 0;

	String  from_UserId = Cookies.getCookie("SessionUserNicknameEditor");
	int  ownuserID = Integer.parseInt(Cookies.getCookie("SessionUserIDEditor"));

 	int postID =0;   
	int counter0 =0;
	int likecounter =1;
	int counter1 =2;
	String authorNickname;
	VerticalPanel boardcontent = new VerticalPanel();
	FlexTable report8table = new FlexTable();
	/*Async Counter*/
	/*int d = 1;
  	int d2 = 2;*/
	int d3 = 3;
		int d4 = 4;
		Post po = new Post();
		int itemp = 0;
		
	final HorizontalPanel boardHoriPanel1Tab = new HorizontalPanel();
	final VerticalPanel leftVp = new VerticalPanel();
	Label headlineAbo = new Label("Alle Abonennten der Pinnwand");
	final VerticalPanel leftVpSubProfilInfo = new VerticalPanel();
	final VerticalPanel leftVpSubAboInfo = new VerticalPanel();
	final Button BoardAboBtn = new Button("Dieses Board abbonieren");
	/*Felxtable All POst */
	Integer counterPostTable ;
			
	int couterlike ;
	int authorID ;
	
	final VerticalPanel rightVp = new VerticalPanel();
	
	public class BoardPanelDasboard extends VerticalPanel {
 		private final AServiceAsync AsyncObj = GWT.create(AService.class);

	/*
		public Board showOwnBoard (){
			Label a = new Label("sadasd");
			RootPanel.get("content_wrap").add(a);
			return null;
			
		}
		*/
		
		public void createBoardByOwnUserId (int UserId){
			 
			Integer UserID = UserId; 
			 AsyncObj.createBoardByOwnUserId(UserID, new AsyncCallback<Void>(){
				@Override
				public void onFailure(Throwable caught) {
				}
				@Override
				public void onSuccess(Void result) {
					// TODO Auto-generated method stub
				}
			 }); 
		}
		
		public void onLoad(){
		
			postVpHeadline.setStylePrimaryName("postVpHeadline");
			postVpSubline.setStylePrimaryName("postVpSubline");
	 		report8table.addStyleName("report7table");
	
	 	//	rightVp.add(report7table);
	 		
	 		boardHoriPanel1Tab.add(leftVp);
	 		boardHoriPanel1Tab.add(rightVp);
			RootPanel.get("content_wrap").clear();
	
			RootPanel.get("content_wrap").add(boardHoriPanel1Tab); 
	 
		/*	if (selectedNickname == cookieNickname ){
				
				Board ownBoard = new Board();
			//	Board.getOwnBoard();
				Window.alert("ownBoard"); 
			}
			else {
				Window.alert("anderesBoard"); 
	
			} 
		
	 */
			
		}
	
}
	
	public class createOwnBoardByNicknamePanel extends VerticalPanel {
		final int userSessionCookieID = Integer.parseInt(Cookies
				.getCookie("SessionUserIDEditor"));
		final String userSubscriptionCookie = Cookies
				.getCookie("SelectedListItem");
 		private final AServiceAsync AsyncObj = GWT.create(AService.class);
 		private String  cookienameTemp;
 		
 		
	public createOwnBoardByNicknamePanel(String cookiename) {
	
		this.cookienameTemp = cookiename;
	}
		
	public void createUserInformations(String cookienameTemp) {
		 AsyncObj.selectUserbyNickname(cookienameTemp, new AsyncCallback<User>(){
				@Override
				public void onFailure(Throwable caught) {
					Window.alert("Hopala! Ein Fehler ist aufgetreten");
				}
				@Override
				public void onSuccess(User result) {
					Label a = new Label ("Nickname:" );
					Label a1 = new Label ( result.getNickname());
					Label b = new Label ("Vorname:" );
					Label b1 = new Label (result.getfirstname());
					Label c = new Label ("Nachname:" );
					Label c1 = new Label ( result.getlastname());
					Label d = new Label ("E-Mail-Adresse.:" );	
					Label d1 = new Label (result.getEMailAdress());	
					Label e = new Label ("User Informationen:");	
					leftVpSubProfilInfo.add(e);
					e.setStylePrimaryName("leftVpSubProfilInfo_Headline");

					leftVpSubProfilInfo.add(a);
					leftVpSubProfilInfo.add(a1);
					leftVpSubProfilInfo.add(b);
					leftVpSubProfilInfo.add(b1);
					leftVpSubProfilInfo.add(c);
					leftVpSubProfilInfo.add(c1);
					leftVpSubProfilInfo.add(d);
					leftVpSubProfilInfo.add(d1);
					
					a.setStylePrimaryName("leftVpSubProfilInfo_Subline");
					b.setStylePrimaryName("leftVpSubProfilInfo_Subline");
					c.setStylePrimaryName("leftVpSubProfilInfo_Subline");
					d.setStylePrimaryName("leftVpSubProfilInfo_Subline");
					a1.setStylePrimaryName("leftVpSubProfilInfo_Subline1");
					b1.setStylePrimaryName("leftVpSubProfilInfo_Subline2");
					c1.setStylePrimaryName("leftVpSubProfilInfo_Subline2");
					d1.setStylePrimaryName("leftVpSubProfilInfo_Subline2");
				}
		 });
	}	
	public void getAllSubscriptionsByUserNickname() {

		User u = new User();

		u.setNickname(userSubscriptionCookie);

		AsyncObj.getUserIdByUserNickname(u, new AsyncCallback<User>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Leider ein Fehler");

			}

			@Override
			public void onSuccess(User result) {
				int userSessionCookie = Integer.parseInt(Cookies
						.getCookie("SessionUserIDEditor"));
				Subscription s = new Subscription();
				s.setFromUser(userSessionCookie);
				s.setToUser(result.getUserId());
				AsyncObj.getAllSubscriptionsById(s,
						new AsyncCallback<ArrayList<Subscription>>() {

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Leider ein Fehler xy");

							}

							@Override
							public void onSuccess(

							ArrayList<Subscription> result) {

								for (int i = 0; i < result.size(); i++) {
									final Subscription s = new Subscription();
									s.setId(result.get(i).getId());
									s.setFromUser(result.get(i)
											.getFromUser());
									s.setToUser(result.get(i).getToUser());
									if (s.getFromUser() == result.get(i)
											.getFromUser()) {
										BoardAboBtn.setVisible(false);

									}

									Button AboDeleteBtn = new Button("d");
									AboDeleteBtn
											.setStylePrimaryName("PostDeleteBtn");
									AboDeleteBtn
											.addClickHandler(new ClickHandler() {

												@Override
												public void onClick(
														ClickEvent event) {
													AsyncObj.deleteSubscriptionBySubscriptionID(
															s,
															new AsyncCallback<Void>() {

																@Override
																public void onFailure(
																		Throwable caught) {
																	// TODO
																	// Auto-generated
																	// method
																	// stub

																}

																@Override
																public void onSuccess(
																		Void result) {
																	Window.alert("erfolgreich");

																}

															});

													new DeleteSubscription(
															s);

												}
											});
									FlexTableTemp
											.setWidget(
													counter,
													0,
													new Label(
															userSubscriptionCookie));
									FlexTableTemp.setWidget(counter, 1,
											AboDeleteBtn);

									FlexTableTemp.getFlexCellFormatter()
											.setStyleName(counter, 0,
													"firstline_abo");
									FlexTableTemp.getFlexCellFormatter()
											.setStyleName(counter, 1,
													"secoundline_abo");
									counter++;
								}
							}
						});

			}
		});

	}

	public void createSubscriptionByUserNickname(User user) {
		User u = new User();
		u.setNickname(user.getNickname());

		AsyncObj.getUserIdByUserNickname(u, new AsyncCallback<User>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Leider ein Fehler");

			}

			@Override
			public void onSuccess(User result) {
				Subscription s = new Subscription();
				s.setFromUser(userSessionCookieID);
				s.setToUser(result.getUserId());
				AsyncObj.createSubscriptionByUserId(s,
						new AsyncCallback<Void>() {

							@Override
							public void onFailure(Throwable caught) {
								Window.alert("Leider ein Fehler bei createSubscriptionByUserId");

							}

							@Override
							public void onSuccess(Void result) {
								Window.alert("Erfolgreich abonniert");

							}
						});
			}

		});

	}

//	public void createSubscriberInformations(int from_user_id) {
//	 //Window.alert("ownBoard" + from_user_id);
//		 AsyncObj.createSubscriberInformations(from_user_id, new AsyncCallback<ArrayList<User>>(){
//			 
//				@Override
//				public void onFailure(Throwable caught) {
//					Window.alert("dddddddddduhuh1")	;									
//
//				}
//				@Override
//				public void onSuccess(ArrayList<User>  result) {
//					
//					for (int i = 0; i < result.size(); i++) {
//						
//						String TempNIckname = result.get(i).getNickname();
//						int TempUserID = result.get(i).getUserId();
//						//Window.alert("tempid" + TempNIckname +""+TempUserID )	;	
//				 
//						 AsyncObj.getOneUserIdByID(TempUserID, new AsyncCallback<ArrayList<User>>(){
//
//							@Override
//							public void onFailure(Throwable caught) {
//								Window.alert("dddddddddduhuh2")	;									
//								
//							}
//							
//							@Override
//							public void onSuccess(ArrayList<User> result) {
//								
//							 
//								for (int i = 0; i < result.size(); i++) {
//									Button AboDeleteBtn = new Button("d");
//									AboDeleteBtn.setStylePrimaryName("PostDeleteBtn");
//
//									User a = new User();
//									String nicknameTemp = result.get(i).getNickname();
//									
// 								 	final Integer TempUserID = result.get(i).getUserId();
// 									// Window.alert(""+TempUserID )	;	
//
//								 	FlexTableTemp.setWidget(counter, 0, new Label( nicknameTemp));
//									FlexTableTemp.setWidget(counter, 1,  AboDeleteBtn);
//									
//									FlexTableTemp.getFlexCellFormatter().setStyleName(counter,  0, "firstline_abo");
//									FlexTableTemp.getFlexCellFormatter().setStyleName(counter,  1, "secoundline_abo");
//									
//									AboDeleteBtn.addClickHandler(new ClickHandler() {
//									    public void onClick(ClickEvent event) {
//												  
//									    	AsyncObj.deleteSubscriberInformations(TempUserID, new AsyncCallback<Void>(){
//
//												@Override
//												public void onFailure(Throwable caught) {
//													Window.alert("dddddddddduhuh3")	;									
//													 
//												}
//
//												@Override
//												public void onSuccess(Void result) {
//														Window.alert("juhuh")	;									
//												}
//									    		
//									    	});
//									    	
//									    }
//									  });							
//									
//									counter++;								
//
//								}							
//								
//							}							 
//							 
//						 });
//						
//					}
//
//				}
//		 }); 
//	}
//	
	public void addRow(FlexTable report7table) {
		 
		         int numRows = report7table.getRowCount();
		         report7table.setText(numRows, 0, "Row "+ numRows);
		         report7table.setText(numRows, 1, "Item["+ numRows +", 1]");
		         report7table.setText(numRows, 2, "Item["+ numRows +", 2]");
		         report7table.setText(numRows, 3, "Item["+ numRows +", 2]");
		         report7table.setText(numRows, 4, "Item["+ numRows +", 2]");
		     }
		 
		     public void deleteRow(FlexTable report7table) {
		         int numRows = report7table.getRowCount();
		         if (numRows > 1) {
		        	 report7table.removeRow(numRows - 1);
		         }
		     }

		     public int countRow(FlexTable report7table) {
		         int numRows = report7table.getRowCount();
		         return numRows;
		     }
	 	  
		     
		     
		     public FlexTable addNewTable(int counter, Post p) {
		    	 
		    	 
		    	 
		    	 
		 		int d = 0;
				  	int d2 = 1;
			 
				 
					final FlexTable report7table = new FlexTable();
			
					 itemp = counter+1;
					 
			 		couterlike = p.getLike();
			 		postID = p.getPId();
			 		authorID = p.getPosr_id();
			 // Window.alert("d1-  "+d +"  d2-  "+d2+"  d3-  "+d3);
			 		
			 	    
			 		po.setPId(p.getPId());
			 		po.setLike(p.getLike());
			 	   	po.setTimestamp(p.getTimestamp());
			 	   	po.setPost( p.getPost());
			 	   	po.setPosr_id(p.getPosr_id());
		 		
			 	   	
			 	//	final FlexTable report7table = new FlexTable();
					report7table.addStyleName("report7table");
					
				  	
					 // report7table.setBorderWidth(1);
						 report7table.getFlexCellFormatter().setStyleName(d,  0, "firstline0");
						 report7table.getFlexCellFormatter().setStyleName(d,  1, "firstline1");
						 report7table.getFlexCellFormatter().setStyleName(d,  2, "firstline2");
						 report7table.getFlexCellFormatter().setStyleName(d,  3, "firstline3");
						 report7table.getFlexCellFormatter().setStyleName(d,  4 , "firstline4");
					//	 report7table.getFlexCellFormatter().setStyleName(d,  5, "firstline5");
					//	 report7table.getFlexCellFormatter().setStyleName(d,  6, "firstline6");
					//	 report7table.getFlexCellFormatter().setStyleName(d,  7, "firstline7");
						 report7table.getFlexCellFormatter().setStyleName(d2, 0, "secoundline"); 
						//boardcontent.add(report7table);
				 
						 
					// scheisse 
					  	report7table.setWidget(d, 0, new Label(String.valueOf(itemp)));
						report7table.setWidget(d, 1,new GetPostBarAuthor(authorID)  ) ;
						report7table.setWidget(d, 2, new Label(p.getTimestamp()));
					    report7table.setWidget(d, 3, new Label( String.valueOf(couterlike))   );
					    report7table.setWidget(d, 4, new PostBarHandler(po, ownuserID));
					  
						 report7table.getFlexCellFormatter().setColSpan(d2, 0, 5); 
						 report7table.setWidget(d2, 0,  new Label(p.getPost())); // von wem nickname und wann
						
						 
						 
						 
						 
						 

						 AsyncObj.getAllCommentsByOnePostId(postID, new AsyncCallback<ArrayList<Comment>>() {
								@Override
								public void onFailure(Throwable caught) {
								 Window.alert("fehler dd");
								}
								@Override
								public void onSuccess(ArrayList<Comment> result) {
									
									
									int itemp2 = 1;
								
									//addRow(report7table);
									
									if(result != null){	
										
										
								
									
									//	 int i  = countRow(report7table);
										
										 	 

										for (int j = 0; j <= result.size(); j++) {	
											
											int commendidTemp = result.get(j).getId();

											//int comment_useridTemp = result.get(j).getId();
											
											if(j==0){
												d3 = 2;
												d4 = 3;
											}else {
											
											
											
										 
									//	VerticalPanel tableinner = new VerticalPanel();
									 	Comment c = new Comment(); 
										c.setUser_id(result.get(j).getUser_id());
										int commentIdTemp = result.get(j).getUser_id();
									//	String a ="a";
										
										report7table.setWidget(d3, 1 , new Label(String.valueOf(j) + " Kommentar"+ ":"));
						 
										report7table.setWidget(d3 , 2, new GetPostBarAuthor(authorID)  ) ;
									 	report7table.setWidget(d3 , 3 ,  new Label(String.valueOf(result.get(j).getTimestamp())));

									//	Window.alert(""+ commendidTemp + comment_useridTemp);
										report7table.setWidget(d3 , 0, new Label());
									 	report7table.setWidget(d3 , 4 ,  new CommentBarHandler(commendidTemp,commentIdTemp, ownuserID));

									 	
									 report7table.getFlexCellFormatter().setColSpan(d4, 1, 5); 
								//	 report7table.getFlexCellFormatter().setStyleName(d4, 2, "secoundline_d3"); 
									 report7table.setWidget(d4, 1,  new Label(result.get(j).getText() )); // von wem nickname und wann
									
									 
			 
						 report7table.getFlexCellFormatter().setStyleName(d3,  0, "firstline0_d3");
						report7table.getFlexCellFormatter().setStyleName(d3,  1, "firstline1_d3");
						report7table.getFlexCellFormatter().setStyleName(d3,  2, "firstline2_d3");
						report7table.getFlexCellFormatter().setStyleName(d3,  3, "firstline3_d3");
					 report7table.getFlexCellFormatter().setStyleName(d3,  4 , "firstline4_d3");
						report7table.getFlexCellFormatter().setStyleName(d4,  0 , "secoundline_d3_b");	
					 	report7table.getFlexCellFormatter().setStyleName(d4,  1 , "secoundline_d3");	
					//	report7table.getFlexCellFormatter().setStyleName(d4,  1 , "secoundline_d3_b");	
			 
						d3 +=2;
							d4 +=2;
											}
					
			 	//tableinner.add(report9table);
	 
						  
						  //	d += 2; 
						 	//d2 += 2; 	
					 	}  
							
									}		 
									
								 
								// 	d = 1; 
								//	 	d2 = 2;
									
									 
									}   
								 
								 
								}
								 
							  );
							
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
						 
		 
				 	// Window.alert(" was hat d  " +  d );

				 //	d += 2; 
			  //	d2 += 2;
				return report7table; 
			   	
				// Window.alert(" was hat d2  " +  d );
			 	
				 
				 
		 
				 
			  	
			  	
			  	
				//	Window.alert("A1 Spalte Postbar d " +d  +"  d2 "   +d2 );
				   	
					
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		    	 
		     }
		     
		public void createBodardByNickname(String cookienameTemp) {
		// Window.alert("ownBoard" + cookienameTemp);
			final String sessionEditor = Cookies.getCookie("SessionUserNicknameEditor");
		
 			
		 AsyncObj.selectUserbyNickname(cookienameTemp, new AsyncCallback<User>(){
				@Override
				public void onFailure(Throwable caught) {
					//Window.alert("dd");
				}
				@Override
				public void onSuccess(User result) {
					
					final int tempUserid= result.getUserId();
 					
  					 AsyncObj.getAllPostsObjectsByOneUserId(tempUserid, new  AsyncCallback<ArrayList<Post>>(){
	
  						 
  					
  							
						 	@Override
							public void onSuccess(ArrayList<Post> result) {
						 		 					 	
						 	//	int d = 1;
						 	//	int d2 = 2;
						 		//int d3 = 3;
						 		//int d4 = 4;
						 		//int d3 = 0;
							 
 									for (int i = 0; i < result.size(); i++) {
 										
 										
 										VerticalPanel vP = new VerticalPanel();
 										vP.add(  addNewTable(i, result.get(i)));
 										boardcontent.add(vP);

									 
									//	 authorNickname = ShowNickname(authorID);
										 //d3 += 3; 									 
										 
										
										// d4 += 2; 
										 
 									}
 									
 									
 								 
 									
 									
 									
 									
 									
 									
 									
 									
 									
 									
 									
 									
 									
 									
 									
 									
 									
 									
 									
 									
 									
 								
						 	}

							@Override
							public void onFailure(Throwable caught) {
 						Window.alert( "saaaaaaaaaaaaaaaa"); 
							}
															
 							}  );	
						 	 					
				}
			 });		 
		
	}

	// Constructor Nickname Private Variable 		
	
	public void onLoad(){
		final String userSubscriptionCookie = Cookies
				.getCookie("SelectedListItem");
		getAllSubscriptionsByUserNickname();
		BoardAboBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				User user = new User();
				user.setNickname(userSubscriptionCookie);
				createSubscriptionByUserNickname(user);

			}
		});
		
		leftVpSubProfilInfo.setStylePrimaryName("leftVpSubProfilInfo");
		leftVpSubAboInfo.setStylePrimaryName("leftVpSubAboInfo");
		leftVp.setStylePrimaryName("leftVpBoard");
		rightVp.setStylePrimaryName("rightVpBoard");
		headlineAbo.setStylePrimaryName("headlineAbo_pinnwand");
		
		postVpHeadline.setStylePrimaryName("postVpHeadline");
		postVpSubline.setStylePrimaryName("postVpSubline");
 	
 		boardHoriPanel1Tab.addStyleName("boardHoriPanel1Tab");
 		BoardAboBtn.setStylePrimaryName("aboVpDeleteBtn");
 		
 		report8table.setText(0, 0, "Nr");
 		report8table.setText(0, 1, "Author");
 		report8table.setText(0, 2, "Zeitstempel");
 		report8table.setText(0, 3, "Likes");
		report8table.getFlexCellFormatter().setColSpan(0, 4, 4); 
 		report8table.setText(0, 4, "Aktions Buttons");
	   
		super.onLoad();
	 
//		 final int from_UserId = Integer.parseInt(Cookies.getCookie("SessionUserIDEditor"));
		// Window.alert(""+from_UserId);
		CreatePost a = new CreatePost();
		rightVp.add(a);
 		//rightVp.add(report8table);
 		rightVp.add(boardcontent);
 		createBodardByNickname(cookienameTemp);
		createUserInformations(cookienameTemp);
//		createSubscriberInformations(from_UserId);
	
	 	leftVpSubAboInfo.add(headlineAbo);
		leftVpSubAboInfo.add(FlexTableTemp);
		leftVpSubAboInfo.add(BoardAboBtn);

 		leftVp.add(leftVpSubProfilInfo);
 		leftVp.add(leftVpSubAboInfo);
 		
 		boardHoriPanel1Tab.add(leftVp) ;
 		boardHoriPanel1Tab.add(rightVp); 
 		this.add(boardHoriPanel1Tab);
		
	}
	
	}	

}