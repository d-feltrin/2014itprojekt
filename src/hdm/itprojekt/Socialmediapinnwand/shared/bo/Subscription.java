package hdm.itprojekt.Socialmediapinnwand.shared.bo;

public class Subscription extends BusinessObject {

	//Folgende Attribute ben�tigt die Klasse Subscription, um ein Abonnement laut Anforderungen
	//beschreiben zu k�nnen
	private boolean abo;
	private int aboCounter;
	
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
	
}
