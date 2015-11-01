package Game;

import java.io.PrintWriter;
import java.util.Set;

//Über das Interface erfolgt auch die Ausgabe der aktuellen Spielbrett - Belegung
//in CSV - Notation.

/**
 * 
 * @author B3-TST-Naketano
 *
 */

public interface iBediener{

	public void neuesSpiel();
	
	public boolean zugDurchführen(String ID);

	public String startID(String ID);

	public String zielID(String ID);

	public void spielBeenden();

	public void spielerHinzufügen(String name, String farbe);

	public void setZielPosition(int x, int y);
	
	public void removeZielPosition();
	
	public String gibMirCSV(String s1);
	
	
	
	
}



//	PrintWriter pw;
//	pw = new PrintWriter ( new FileWriter ("brett.txt"));
//	for (int i = 1; i < 10; i++){
//		pw.println( i + ";" + i*i + ";" + Math.sqrt(i));
//	}
//	pw.close();
//	
//}


