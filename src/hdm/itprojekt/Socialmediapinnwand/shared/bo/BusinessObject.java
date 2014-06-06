package hdm.itprojekt.Socialmediapinnwand.shared.bo;

import java.io.Serializable;

/*Die Superklasse BusinessObject gibt das Attribut und die Methoden f�r eindeutige ID's
der Objekte vor*/
public class BusinessObject implements Serializable {
	private static final long serialVersionUID = 1L;

private int id;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
}
