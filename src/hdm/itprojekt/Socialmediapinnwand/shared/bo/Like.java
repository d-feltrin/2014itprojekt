package hdm.itprojekt.Socialmediapinnwand.shared.bo;

public class Like extends BusinessObject {

	/*Folgende Attribute ben�tigt die Klasse Like, um einen Like laut Anforderungen
	beschreiben zu k�nnen*/
	private boolean like;
	private int likeCounter;
	
	//Methode, um eine Like-Beziehung auf true oder false zu setzen
	public void setLike(boolean like){
	}
		
	//Methode, um eine Like-Beziehung mit true oder false zu erhalten
	public boolean getLike(){
		return like;
	}
		
	//Methode, um die Like-Beziehungen zu addieren = um 1 zu erh�hen
	public void setLikeCounter(int likeCounter){	
	}
		
	//Methode, um die Anzahl der Like-Beziehungen zu erhalten
	public int getLikeCounter(){
		return likeCounter;
	}
	
}