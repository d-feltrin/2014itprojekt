package hdm.itprojekt.Socialmediapinnwand.shared.bo;

import java.io.Serializable;

/*Die Superklasse BusinessObject gibt das Attribut und die Methoden für eindeutige ID's
der Objekte vor*/
public class BusinessObject implements Serializable {
	private static final long serialVersionUID = 1L;

	//Folgende Attribute sollen in der Klasse vorhanden sein
	private int id;
	
	//Methode, um die ID eines Objektes dieser Klasse zu setzen
	public void setId(int id) {
		
	};
	
	//Methode, um die gesetzte ID eines Objektes dieser Klasse zu erhalten
	public int getId() {
		return id;
	}
	
}