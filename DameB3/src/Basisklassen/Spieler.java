package Basisklassen;

import java.io.Serializable;

import Game.Spiel;


public class Spieler implements Serializable{
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 2289924887751584485L;
		/**
		 * @author B3-TST-Naketano
		 */

	private String name;
	private FarbEnum farbe;
	
	/**
	 * player musst know game and KI
	 * 
	 * @param 
	 */
	
	private KI ki;
	private boolean istKI;

	/**
	 * public Spieler for the Junit test
	 * 
	 * 
	 */
	public Spieler(){
		
	}

	/**
	 * constructor of spieler with all objects on it
	 * 
	 * @param ID
	 * @param farbe
	 * @param spielfigur
	 */

	public Spieler(String name, FarbEnum farbe, boolean istKI, Spiel spiel) {
		this.name = name;
		this.farbe = farbe;
		if (istKI == true){
			ki.add(ki);
		}
	}

	/** getter for name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * setter for name
	 * 
	 * @param name
	 * @throws RuntimeException
	 * 						my player has to have a name
	 *           my name has to have min 2 letters,
	 */

	public void setName(String name) {
		if (name == null || name.length() < 2)
			throw new RuntimeException("the value of name is not allowed");
		else {
			this.name = name;
		}
	}

	/** getter for Farbenum
	 * 
	 * @return farbe
	 */

	public FarbEnum getFarbEnum() {
		return farbe;
	}

	/**
	 * setter for color
	 * 
	 * @param color
	 * @throws RuntimeException
	 * 						my player has to have a color
	 *           	the colors are only schwarz or weiss,
	 */

	public void setFarbEnum(FarbEnum farbe){
		if ( farbe == null ){
			throw new RuntimeException ("colour cannot be null");
		}
			if(farbe != farbe.schwarz | farbe != farbe.weiss) throw new RuntimeException("you need the colour black or w");
			else{
			this.farbe = farbe.schwarz;
			this.farbe = farbe.weiss;
		}
	}
	
	public String toCSV(){
		int x;
		if (ki != null ){
			x = 1;
		} else {
			x = 0;
		}
		return name+";"+farbe+";"+x;
	}
	

	@Override
	public String toString(){
		return this.getName();
	}
	
//	@Override
//	public String toString() {
//		String outputSring = "";
//		if((getName() == null) && (getFarbEnum() == null) && (ki == null)) {
//			outputSring += "There is no name and no color.";
//		} else {
//			outputSring += "Name: " + getName() + "\n" +
//						   "Farbe: " + getFarbEnum() + "\n" + "KI: " + this.ki;
//		}
//		return outputSring;
//	}

}
