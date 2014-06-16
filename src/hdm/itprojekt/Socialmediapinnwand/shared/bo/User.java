package hdm.itprojekt.Socialmediapinnwand.shared.bo;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
public class User extends BusinessObject {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/*Folgende Attribute ben�tigt die Klasse User, um einen User laut Anforderungen
	beschreiben zu k�nnen*/
	/** The firstname. */
	private String firstname;
	
	/** The lastname. */
	private String lastname;
	
	/** The nickname. */
	private String nickname;
	
	/** The e mail adress. */
	private String eMailAdress;
	
	/** The password. */
	private String password;
	
	/** The user_id. */
	private int user_id;
	
	/** The anzahl fremder abonnenten. */
	private int anzahlFremderAbonnenten;
	
	/*Diese Methode wird aus der Superklasse BusinessObject geerbt (siehe @override)
	*wird hier nicht �berschrieben, da die Methode genau die gleiche bleibt
	*Muss sie hier dann �berhaupt reingeschrieben werden?*/
	
	//public void setId(int id) {
	//	super.setId(id);
	//}

	/*Diese Methode wird aus der Superklasse BusinessObject geerbt (siehe @override)
	*wird hier nicht �berschrieben, da die Methode genau die gleiche bleibt
	Muss sie hier dann �berhaupt reingeschrieben werden?*/
	
	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId() {
		return user_id;
	}
	
	/**
	 * Sets the user id.
	 *
	 * @param uuser_id the new user id
	 */
	public void setUserId(int uuser_id) {
		this.user_id = uuser_id;
	}

	//Methode, um den firstnamen eines Users zu setzen
	/**
	 * Sets the firstname.
	 *
	 * @param ufirstname the new firstname
	 */
	public void setfirstname(String ufirstname){
		firstname = ufirstname;
	}
	
	//Methode, um den firstnamen eines Users zu erhalten
	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getfirstname(){
		return firstname;
	}
	
	//Methode, um den lastnamen eines Users zu setzen
	/**
	 * Sets the lastname.
	 *
	 * @param ulastname the new lastname
	 */
	public void setlastname(String ulastname){
		lastname = ulastname;
	}
	
	//Methode, um den lastnamen eines Users zu erhalten
	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getlastname(){
		return lastname;
	}
	
	//Methode, um den Nickname eines Users zu setzen
	/**
	 * Sets the nickname.
	 *
	 * @param unickname the new nickname
	 */
	public void setNickname(String unickname){
		nickname = unickname;
	}
	
	//Methode, um den Nickname eines Users zu erhalten
	/**
	 * Gets the nickname.
	 *
	 * @return the nickname
	 */
	public String getNickname(){
		return nickname;
	}
	
	//Methode, um die E-Mail Adresse eines Users zu setzen
	/**
	 * Sets the e mail adress.
	 *
	 * @param ueMailAdress the new e mail adress
	 */
	public void setEMailAdress(String ueMailAdress){
		eMailAdress = ueMailAdress;
	}
	
	//Methode, um die E-Mail Adresse eines Users zu erhalten
	/**
	 * Gets the e mail adress.
	 *
	 * @return the e mail adress
	 */
	public String getEMailAdress(){
		return eMailAdress;
	}
	
	//Methode, um das Passwort eines Nutzers zu setzen
	/**
	 * Sets the password.
	 *
	 * @param upassword the new password
	 */
	public void setPassword(String upassword){
		password = upassword;		
	}
	
	//Methode, um das Passwort eines Nutzers zu erhalten
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword(){
		return password;
	}
	
	//Methode, um die Anzahl fremder Pinnwand-Abonnenten zu erhalten
	/**
	 * Gets the anzahl fremder abonnenten.
	 *
	 * @return the anzahl fremder abonnenten
	 */
	public int getAnzahlFremderAbonnenten(){
		return anzahlFremderAbonnenten;
	}

}