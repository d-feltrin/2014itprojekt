package hdm.itprojekt.Socialmediapinnwand.shared.bo;

public class User extends BusinessObject {
	private static final long serialVersionUID = 1L;

	/*Folgende Attribute benötigt die Klasse User, um einen User laut Anforderungen
	beschreiben zu können*/
	private String vorname;
	private String nachname;
	private String nickname;
	private String eMailAdress;
	private String password;
	private int user_id;
	private int anzahlFremderAbonnenten;
	
	/*Diese Methode wird aus der Superklasse BusinessObject geerbt (siehe @override)
	*wird hier nicht überschrieben, da die Methode genau die gleiche bleibt
	*Muss sie hier dann überhaupt reingeschrieben werden?*/
	
	//public void setId(int id) {
	//	super.setId(id);
	//}

	/*Diese Methode wird aus der Superklasse BusinessObject geerbt (siehe @override)
	*wird hier nicht überschrieben, da die Methode genau die gleiche bleibt
	Muss sie hier dann überhaupt reingeschrieben werden?*/
	
	
	public int getUserId() {
		return user_id;
	}
	
	public void setUserId(int uuser_id) {
		user_id = uuser_id;
	}

	//Methode, um den Vornamen eines Users zu setzen
	public void setVorname(String uvorname){
		vorname = uvorname;
	}
	
	//Methode, um den Vornamen eines Users zu erhalten
	public String getVorname(){
		return vorname;
	}
	
	//Methode, um den Nachnamen eines Users zu setzen
	public void setNachname(String unachname){
		nachname = unachname;
	}
	
	//Methode, um den Nachnamen eines Users zu erhalten
	public String getNachname(){
		return nachname;
	}
	
	//Methode, um den Nickname eines Users zu setzen
	public void setNickname(String unickname){
		nickname = unickname;
	}
	
	//Methode, um den Nickname eines Users zu erhalten
	public String getNickname(){
		return nickname;
	}
	
	//Methode, um die E-Mail Adresse eines Users zu setzen
	public void setEMailAdress(String ueMailAdress){
		eMailAdress = ueMailAdress;
	}
	
	//Methode, um die E-Mail Adresse eines Users zu erhalten
	public String getEMailAdress(){
		return eMailAdress;
	}
	
	//Methode, um das Passwort eines Nutzers zu setzen
	public void setPassword(String upassword){
		password = upassword;		
	}
	
	//Methode, um das Passwort eines Nutzers zu erhalten
	public String getPassword(){
		return password;
	}
	
	//Methode, um die Anzahl fremder Pinnwand-Abonnenten zu erhalten
	public int getAnzahlFremderAbonnenten(){
		return anzahlFremderAbonnenten;
	}

	public void setDozentID(int int1) {
		// TODO Auto-generated method stub
		
	}

}
