package hdm.itprojekt.Socialmediapinnwand.shared.bo;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/*Die Superklasse BusinessObject gibt das Attribut und die Methoden f�r eindeutige ID's
der Objekte vor*/
/**
 * The Class BusinessObject.
 */
public class BusinessObject implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	//Folgende Attribute sollen in der Klasse vorhanden sein
	/** The id. */
	private int id;
	
	//Methode, um die ID eines Objektes dieser Klasse zu setzen
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id=id;
	};
	
	//Methode, um die gesetzte ID eines Objektes dieser Klasse zu erhalten
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
}