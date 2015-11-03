package Game;


//Über das Interface erfolgt auch die Ausgabe der aktuellen Spielbrett - Belegung
//in CSV - Notation.

/**
 * 
 * @author B3-TST-Naketano
 *
 */

public interface iBediener{

	public void neuesSpiel();
	
	public boolean zugDurchführen(String startID, String zielID);

	public void spielBeenden();

	public void spielerHinzufügen(String name, String farbe, boolean KI);

	public String gibMirCSV();
	
	public void speichern(String pfad, String name, String typ);
	
	public void laden(String pfad, String name, String typ);
	
	
}



