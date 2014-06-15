package hdm.itprojekt.Socialmediapinnwand.shared.bo;

import java.lang.String;

public class OwnStringObject   extends BusinessObject  {

 	private String constructorSerialString;
 	private Integer constructorSerialIntBack;
	
	public OwnStringObject(String constructorSerialString ){
		this.constructorSerialString = constructorSerialString;
	}
	
 /*	public Integer OwnStringObject( Integer constructorSerialIntBack){
		 
 		this.constructorSerialIntBack = constructorSerialIntBack;
 		return constructorSerialIntBack;
	}*/
 
	public OwnStringObject(){
		
	}
	
	public Integer constructorSerialIntBack (Integer constructorSerialIntBack){
		
		this.constructorSerialIntBack = constructorSerialIntBack;
		return constructorSerialIntBack;
		
	}
	
}