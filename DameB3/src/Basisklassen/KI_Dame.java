package Basisklassen;

import java.io.Serializable;

public class KI_Dame extends KI implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6123686338447429273L;
	private boolean istKI = false;
	private KI KI2;

	public KI_Dame(Spieler spieler, String name, FarbEnum farbe) {
		super(spieler, name, farbe);
	}
	
	
	
	public void move(){

	}
	
	
	


}
