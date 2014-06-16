package hdm.itprojekt.Socialmediapinnwand.shared.bo;

// TODO: Auto-generated Javadoc
/**
 * The Class Subscription.
 */
public class Subscription extends BusinessObject {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	/*Folgende Attribute ben�tigt die Klasse Subscription, um ein Abonnement laut Anforderungen
	beschreiben zu k�nnen*/
	/** The abo. */
	private boolean abo;
	
	/** The abo counter. */
	private int aboCounter;
	
	/** The source_from_user. */
	private int source_from_user;
	
	/** The source_to_user. */
	private int source_to_user;
	
	/** The from_user. */
	private int from_user;
	
	/** The to_user. */
	private int to_user;
	
	/** The to user nickname. */
	private String toUserNickname;
	
	//Methode, um eine Abo-Beziehung auf true oder false zu setzen
	/**
	 * Sets the abo.
	 *
	 * @param abo the new abo
	 */
	public void setAbo(boolean abo){
	}
	
	//Methode, um eine Abo-Beziehung mit true oder false zu erhalten
	/**
	 * Gets the abo.
	 *
	 * @return the abo
	 */
	public boolean getAbo(){
		return abo;
	}
	
	//Methode, um die Abo-Beziehungen zu addieren = um 1 zu erh�hen
	/**
	 * Sets the abo counter.
	 *
	 * @param AboCounter the new abo counter
	 */
	public void setAboCounter(int AboCounter){
	}
	
	//Methode, um die Anzahl der Abo-Beziehungen zu erhalten
	/**
	 * Gets the abo counter.
	 *
	 * @return the abo counter
	 */
	public int getAboCounter(){
		return aboCounter;
	}

	/**
	 * Gets the to user.
	 *
	 * @return the to user
	 */
	public int getToUser() {
		return to_user;
	}

	/**
	 * Sets the to user.
	 *
	 * @param to_user the new to user
	 */
	public void setToUser(int to_user) {
		this.to_user = to_user;
	}

	/**
	 * Gets the from user.
	 *
	 * @return the from user
	 */
	public int getFromUser() {
		return from_user;
	}

	/**
	 * Sets the from user.
	 *
	 * @param from_user the new from user
	 */
	public void setFromUser(int from_user) {
		this.from_user = from_user;
	}

	/**
	 * Gets the source from user.
	 *
	 * @return the source from user
	 */
	public int getSourceFromUser() {
		return source_from_user;
	}

	/**
	 * Sets the source from user.
	 *
	 * @param source_from_user the new source from user
	 */
	public void setSourceFromUser(int source_from_user) {
		this.source_from_user = source_from_user;
	}

	/**
	 * Gets the source to user.
	 *
	 * @return the source to user
	 */
	public int getSourceToUser() {
		return source_to_user;
	}

	/**
	 * Sets the source to user.
	 *
	 * @param source_to_user the new source to user
	 */
	public void setSourceToUser(int source_to_user) {
		this.source_to_user = source_to_user;
	}

	/**
	 * Gets the to user nickname.
	 *
	 * @return the to user nickname
	 */
	public String getToUserNickname() {
		return toUserNickname;
	}

	/**
	 * Sets the to user nickname.
	 *
	 * @param toUserNickname the new to user nickname
	 */
	public void setToUserNickname(String toUserNickname) {
		this.toUserNickname = toUserNickname;
	}
	
}
