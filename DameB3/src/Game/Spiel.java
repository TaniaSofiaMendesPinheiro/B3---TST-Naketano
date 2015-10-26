package Game;

import Basisklassen.FarbEnum;
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

public class Spiel implements iBediener {

	private Spielbrett brett;
	private Spieler spielerWeiss;
	private Spieler spielerSchwarz;
	private boolean weiss_gerade_am_Zug = true;

	public Spiel() {

	}

	public Spiel(Spielbrett brett, Spieler weiss, Spieler schwarz, Spieler spieler_gerade_am_zug) {
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
		boolean istBeginner = true;
		if (farbe == "weiss") {
			istBeginner = true;
		} else {
			istBeginner = false;
		}
		if (istKI == true) {
			Spiel s = new Spiel();
			s.spielerHinzufügen(name, farbe, istKI);
		}
		// istKI = false;
		// Spiel s1 = new Spiel();
		// s1.spielerHinzufügen(name, farbe);
	}

	@Override
	public boolean zugDurchführen() {
		if (brett == null)
			throw new RuntimeException("There is no brett available!");
		else if (startID() == zielID())
			throw new RuntimeException("Invalid move");
		return true;
	}

	@Override
	public String startID() {
		return brett.spielfeld.getID();
	}

	@Override
	public String zielID() {
		if (brett.spielfeld.getFarbe() == FarbEnum.weiss) {
			throw new RuntimeException("white is not allowed for player or dame");
		} else if (brett.spielfeld.getSpielfigur() != null) {
			throw new RuntimeException("Field is not valid!");
		} else {
			brett.spielfeld.setID(zielID());
		}
		return brett.spielfeld.getID();
	}

	@Override
	public void spielBeenden() {
		
		
	}

	@Override
	public void spielerHinzufügen(String name, String farbe, boolean istKI) {
		if (name == null || name.length() < 2)
			throw new RuntimeException("Invalid Input!");
		else {
			name = name;
		}
		if (farbe != "weiß" || farbe != "schwarz")
			throw new RuntimeException("You have to be black or white");
		else {
			farbe = farbe;
		}
	}
}