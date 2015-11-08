package Game;

import java.io.IOException;


//Über das Interface erfolgt auch die Ausgabe der aktuellen Spielbrett - Belegung
//in CSV - Notation.

/**
 * 
 * @author B3-TST-Naketano
 *
 */

public interface iBediener{

	public void neuesSpiel();
	
	public void zugDurchführen(String startID, String zielID); // von boolean auf void geändert, zum testen tobi

	public void spielBeenden();

	public void spielerHinzufügen(String name, String farbe, boolean KI);

	public String gibMirCSV();
	
//	public void speichern(String pfad, String name, String typ) throws IOException;
//	
//	public void laden(String pfad, String name, String typ) throws IOException;
	
	
}



