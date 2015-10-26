package Game;

import Basisklassen.Spielbrett;
import Basisklassen.Spieler;
import Basisklassen.Spielfeld;
import Basisklassen.Spielfigur;

//Implementieren Sie die Klasse Spiel testgetrieben unter Verwendung von JUnit mit nicht
//trivialen JUnit - Tests. Jedes Spiel kennt ein Spielbrett, 2 Spieler und den Spieler,
//der gerade am Zug ist. Das Spiel implementiert ein Interface iBediener, welches Sie definieren müssen. Alle
//Interaktionen der Benutzer müssen über dieses Interface statt finden.

/**
 * 
 * @author B3-TST-Naketano
 *
 */

public class Spiel implements iBediener{	
	
	private Spielbrett brett;
	private Spieler weiss;
	private Spieler schwarz;
	private boolean weiss_gerade_am_Zug = true;
	private Spielfeld spielfeld;
	
	
	public Spiel(){
		
	}
	

	public Spiel (Spielbrett brett, Spieler weiss, Spieler schwarz, Spieler spieler_gerade_am_zug){
	super();
	}


	@Override
	public void spielLaden() {
		
		
	}


	@Override
	public void spielSpeichern() {
		
		
	}


	@Override
	public void neuesSpiel(String name, String farbe, boolean istKI) {
		if(istKI == true){
		Spiel s = new Spiel();
		s.spielerHinzufügen(name, farbe, istKI);
		}
//		istKI = false;
//		Spiel s1 = new Spiel();
//		s1.spielerHinzufügen(name, farbe);
		}


	@Override
	public boolean zugDurchführen() {
		if(spielfeld == null){
			return true;
		}
		return false;
	}


	@Override
	public String startID() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String zielID() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void spielBeenden() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public String spielerHinzufügen(String name, String farbe, boolean istKI) {
		// TODO Auto-generated method stub
		return null;
	}

}