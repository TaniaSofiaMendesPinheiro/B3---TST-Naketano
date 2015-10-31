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
	
	private Spiel spiel;
	private KI ki;

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

	public Spieler(String name, FarbEnum farbe, KI ki) {
		this.name = name;
		this.farbe = farbe;
		this.ki = ki;
		}

	/** getter for name
	 * 
	 * @return name
	 */
	public String getname() {
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
}