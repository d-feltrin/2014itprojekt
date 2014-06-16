package hdm.itprojekt.Socialmediapinnwand.shared.bo;

import java.lang.String;

// TODO: Auto-generated Javadoc
/**
 * The Class OwnStringObject.
 */
public class OwnStringObject   extends BusinessObject  {

 	/** The constructor serial string. */
	 private String constructorSerialString;
 	
	 /** The constructor serial int back. */
	 private Integer constructorSerialIntBack;
	
	/**
	 * Instantiates a new own string object.
	 *
	 * @param constructorSerialString the constructor serial string
	 */
	public OwnStringObject(String constructorSerialString ){
		this.constructorSerialString = constructorSerialString;
	}
	
 /*	public Integer OwnStringObject( Integer constructorSerialIntBack){
		 
 		this.constructorSerialIntBack = constructorSerialIntBack;
 		return constructorSerialIntBack;
	}*/
 
	/**
  * Instantiates a new own string object.
  */
 public OwnStringObject(){
		
	}
	
	/**
	 * Constructor serial int back.
	 *
	 * @param constructorSerialIntBack the constructor serial int back
	 * @return the integer
	 */
	public Integer constructorSerialIntBack (Integer constructorSerialIntBack){
		
		this.constructorSerialIntBack = constructorSerialIntBack;
		return constructorSerialIntBack;
		
	}
	
}