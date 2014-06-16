package hdm.itprojekt.Socialmediapinnwand.shared.bo;

public class User extends BusinessObject {
	private static final long serialVersionUID = 1L;

	/*Folgende Attribute ben�tigt die Klasse User, um einen User laut Anforderungen
	beschreiben zu k�nnen*/
	private String firstname;
	private String lastname;
	private String nickname;
	private String eMailAdress;
	private String password;
	private int user_id;
	private int anzahlFremderAbonnenten;
	private int user_count;
	/*Diese Methode wird aus der Superklasse BusinessObject geerbt (siehe @override)
	*wird hier nicht �berschrieben, da die Methode genau die gleiche bleibt
	*Muss sie hier dann �berhaupt reingeschrieben werden?*/
	
	//public void setId(int id) {
	//	super.setId(id);
	//}

	/*Diese Methode wird aus der Superklasse BusinessObject geerbt (siehe @override)
	*wird hier nicht �berschrieben, da die Methode genau die gleiche bleibt
	Muss sie hier dann �berhaupt reingeschrieben werden?*/
	
	public int getUserId() {
		return user_id;
	}
	
	public void setUserId(int uuser_id) {
		this.user_id = uuser_id;
	}

	//Methode, um den firstnamen eines Users zu setzen
	public void setfirstname(String ufirstname){
		firstname = ufirstname;
	}
	
	//Methode, um den firstnamen eines Users zu erhalten
	public String getfirstname(){
		return firstname;
	}
	
	//Methode, um den lastnamen eines Users zu setzen
	public void setlastname(String ulastname){
		lastname = ulastname;
	}
	
	//Methode, um den lastnamen eines Users zu erhalten
	public String getlastname(){
		return lastname;
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

	public int getUserCount() {
		return user_count;
	}

	public void setUserCount(int user_count) {
		this.user_count = user_count;
	}

}