package hdm.itprojekt.Socialmediapinnwand.shared.bo;

public class Subscription extends BusinessObject {
	private static final long serialVersionUID = 1L;
	/*Folgende Attribute ben�tigt die Klasse Subscription, um ein Abonnement laut Anforderungen
	beschreiben zu k�nnen*/
	private boolean abo;
	private int aboCounter;
	
	private int source_from_user;
	private int source_to_user;
	private int from_user;
	private int to_user;
	private String toUserNickname;
	
	//Methode, um eine Abo-Beziehung auf true oder false zu setzen
	public void setAbo(boolean abo){
	}
	
	//Methode, um eine Abo-Beziehung mit true oder false zu erhalten
	public boolean getAbo(){
		return abo;
	}
	
	//Methode, um die Abo-Beziehungen zu addieren = um 1 zu erh�hen
	public void setAboCounter(int AboCounter){
	}
	
	//Methode, um die Anzahl der Abo-Beziehungen zu erhalten
	public int getAboCounter(){
		return aboCounter;
	}

	public int getToUser() {
		return to_user;
	}

	public void setToUser(int to_user) {
		this.to_user = to_user;
	}

	public int getFromUser() {
		return from_user;
	}

	public void setFromUser(int from_user) {
		this.from_user = from_user;
	}

	public int getSourceFromUser() {
		return source_from_user;
	}

	public void setSourceFromUser(int source_from_user) {
		this.source_from_user = source_from_user;
	}

	public int getSourceToUser() {
		return source_to_user;
	}

	public void setSourceToUser(int source_to_user) {
		this.source_to_user = source_to_user;
	}

	public String getToUserNickname() {
		return toUserNickname;
	}

	public void setToUserNickname(String toUserNickname) {
		this.toUserNickname = toUserNickname;
	}
	
}
