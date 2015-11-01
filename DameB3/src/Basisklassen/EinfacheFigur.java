package Basisklassen;

import java.io.Serializable;

public class EinfacheFigur extends Spielfigur implements Serializable{ // weil es eine ableitung von Spielfigur ist 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4419712583299476866L;

	public EinfacheFigur  (Spielfeld feld, FarbEnum farbe){
		super (feld, farbe);
	}
	
	public EinfacheFigur (int x, int y){
		this.posX = x;
		this.posY = y;
	}
	

}
