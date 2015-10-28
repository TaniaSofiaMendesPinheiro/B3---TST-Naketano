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

	public void neuesSpiel();
	
	public boolean zugDurchführen();

	public String startID(String ID);

	public String zielID(String ID);

	public void spielBeenden();

	public String spielerHinzufügen(String name, String farbe);

}
