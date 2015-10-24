package Game;

import Basisklassen.Spielbrett;
import Basisklassen.Spieler;
import Basisklassen.Spielfeld;
import Basisklassen.Spielfigur;

//Implementieren Sie die Klasse Spiel testgetrieben unter Verwendung von JUnit mit nicht
//trivialen JUnit - Tests. Jedes Spiel kennt ein Spielbrett, 2 Spieler und den Spieler,
//der gerade am Zug ist. Das Spiel implementiert ein Interface iBediener, welches Sie definieren müssen. Alle
//Interaktionen der Benutzer müssen über dieses Interface statt finden.

public class Spiel implements iBediener{	
	
	private Spielbrett brett;
	private Spieler weiss;
	private Spieler schwarz;
	private boolean weiss_gerade_am_Zug = true;
	
	
	public Spiel(){
		
	}
	

	public Spiel (Spielbrett brett, Spieler weiss, Spieler schwarz, Spieler spieler_gerade_am_zug){
	super();
	}
}
