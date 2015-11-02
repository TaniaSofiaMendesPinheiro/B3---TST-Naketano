package Basisklassen;

import java.io.Serializable;

import Game.Spiel;

public class KI_Dame extends KI implements Serializable{
	
	public KI_Dame(Spiel spiel) {
		super(spiel);
	
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = -6123686338447429273L;
	private boolean istKI = false;
//
//	public KI_Dame(Spieler spieler, String name, FarbEnum farbe) {
//		super(spieler, name, farbe);
//	}

	

	@Override
	public void denken() {

/**
 *  zug = schlagen	
 *  if ( zug == null)
 *  zug = dameWerden()
 *  if (zug == null)	
 *  zug = bewegen
 *  ....
 *  
 *  iBediener x = this.spiel;
 *  x.zugDurchführen(zug)
 *  
 */
	}
	
	
	


}
