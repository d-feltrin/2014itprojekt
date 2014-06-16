package hdm.itprojekt.Socialmediapinnwand.shared.bo;

// TODO: Auto-generated Javadoc
/**
 * The Class Like.
 */
public class Like extends BusinessObject {

	/*Folgende Attribute ben�tigt die Klasse Like, um einen Like laut Anforderungen
	beschreiben zu k�nnen*/
	/** The like. */
	private boolean like;
	
	/** The like counter. */
	private int likeCounter;
	
	//Methode, um eine Like-Beziehung auf true oder false zu setzen
	/**
	 * Sets the like.
	 *
	 * @param like the new like
	 */
	public void setLike(boolean like){
	}
		
	//Methode, um eine Like-Beziehung mit true oder false zu erhalten
	/**
	 * Gets the like.
	 *
	 * @return the like
	 */
	public boolean getLike(){
		return like;
	}
		
	//Methode, um die Like-Beziehungen zu addieren = um 1 zu erh�hen
	/**
	 * Sets the like counter.
	 *
	 * @param likeCounter the new like counter
	 */
	public void setLikeCounter(int likeCounter){	
	}
		
	//Methode, um die Anzahl der Like-Beziehungen zu erhalten
	/**
	 * Gets the like counter.
	 *
	 * @return the like counter
	 */
	public int getLikeCounter(){
		return likeCounter;
	}
	
}