package Basisklassen;

import java.io.Serializable;

public class EinfacheFigur extends Spielfigur implements Serializable{ // weil es eine ableitung von Spielfigur ist 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4419712583299476866L;

	public EinfacheFigur  (Spielfeld feld, FarbEnum farbe, String ID){
		super (feld, farbe, ID);
		
			
	}
	

}
