package Game;

import java.util.Set;

//Über das Interface erfolgt auch die Ausgabe der aktuellen Spielbrett - Belegung
//in CSV - Notation.

/**
 * 
 * @author B3-TST-Naketano
 *
 */

public interface iBediener {

	
	public void spielLaden();
	public void spielSpeichern();
	public Spiel neuesSpiel(String name, String farbe, boolean KI);
	public boolean zugDurchführen();
	public String startID();
	public String zielID();
	
		
	
	
}
