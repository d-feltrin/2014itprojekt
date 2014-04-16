package hdm.itprojekt.Socialmediapinnwand.shared.bo;

public class User extends BusinessObject {

	//Folgende Attribute ben�tigt die Klasse User, um einen User laut Anforderungen
	//beschreiben zu k�nnen
	private String vorname;
	private String nachname;
	private String nickname;
	private String eMailAdress;
	private String password;
	private int anzahlFremderAbonnenten;
	
	//Diese Methode wird aus der Superklasse BusinessObject geerbt (siehe @override)
	//wird hier nicht �berschrieben, da die Methode genau die gleiche bleibt
	//Muss sie hier dann �berhaupt reingeschrieben werden?
	@Override
	public void setId(int id) {
		super.setId(id);
	}

	//Diese Methode wird aus der Superklasse BusinessObject geerbt (siehe @override)
	//wird hier nicht �berschrieben, da die Methode genau die gleiche bleibt
	//Muss sie hier dann �berhaupt reingeschrieben werden?
	@Override
	public int getId() {
		return super.getId();
	}

	//Methode, um den Vornamen eines Users zu setzen
	public void setVorname(String vorname){
		
	}
	
	//Methode, um den Vornamen eines Users zu erhalten
	public String getVorname(){
		return vorname;
	}
	
	//Methode, um den Nachnamen eines Users zu setzen
	public void setNachname(String nachname){
		
	}
	
	//Methode, um den Nachnamen eines Users zu erhalten
	public String getNachname(){
		return nachname;
	}
	
	//Methode, um den Nickname eines Users zu setzen
	public void setNickname(String nickname){
		
	}
	
	//Methode, um den Nickname eines Users zu erhalten
	public String getNickname(){
		return nickname;
	}
	
	//Methode, um die E-Mail Adresse eines Users zu setzen
	public void setEMailAdress(String eMailAdress){
		
	}
	
	//Methode, um die E-Mail Adresse eines Users zu erhalten
	public String getEMailAdress(){
		return eMailAdress;
	}
	
	//Methode, um das Passwort eines Nutzers zu setzen
	public void setPassword(String password){
		
	}
	
	//Methode, um das Passwort eines Nutzers zu erhalten
	public String getPassword(){
		return password;
	}
	
	//Methode, um die Anzahl fremder Pinnwand-Abonnenten zu erhalten
	public int getAnzahlFremderAbonnenten(){
		return anzahlFremderAbonnenten;
	}

}