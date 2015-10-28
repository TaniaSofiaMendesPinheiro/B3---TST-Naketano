package Game;

import Game.FarbEnum;
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
	private FarbEnum farbe;

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
	public boolean zugDurchführen() {
		if (brett == null)
			throw new RuntimeException("There is no brett available!");
		else if (startID(brett.spielfeld.getID()) == zielID(brett.spielfeld.getID())) {
			throw new RuntimeException("Not a valid move");
			// } else if( else if (startID(brett.spielfeld.getFarbe()) &&
			// zielID(brett.spielfeld.getFarbe())){
			// return false;
		} else if (startID(brett.spielfeld.getID()) != zielID(brett.spielfeld.getID())) {
			zugDurchführen();
			brett.spielfeld.setID(zielID(""));
		}
		return true;
	}

	@Override
	public String startID(String ID) {
		if (ID == null | ID.length() < 2 | ID.length() > 3) {
			throw new RuntimeException("This is not a valid position!");
		} else
			return brett.spielfeld.getID();
	}

	@Override
	public String zielID(String ID) {
		if (brett.spielfeld.getFarbe() != FarbEnum.schwarz) {
			throw new RuntimeException("white is not allowed for player or dame");
		} else if (brett.spielfeld.getSpielfigur() != null) {
			throw new RuntimeException("Field is not valid!");
		} else {
			brett.spielfeld.setID(zielID(ID));
		}
		return brett.spielfeld.getID();
	}

	@Override
	public void spielBeenden() {

	}

	@Override
	public void neuesSpiel(String name, Game.FarbEnum farbe, Game.Spieler spieler) {
		if (name == null || name.length() < 2) {
			System.out.println("Invalid name, it has to have 3 letters");
		}
		if ((farbe != farbe.schwarz) | (farbe != farbe.weiss)) {
			System.out.println("You have to choose a colour!");
		}
		if (spieler == spieler.KI) {
			System.out.println("Du spielst gegen eine KI!");
		} else {
			if (spieler == spieler.menschlspieler) {
				spielerHinzufügen(name, farbe, spieler);
			}
		}

	}

	@Override
	public String spielerHinzufügen(String name, FarbEnum farbe, Game.Spieler spieler) {
		if (name == null || name.length() < 2)
			throw new RuntimeException("Invalid Input!");
		else {
			name = name;
		}
		if ( !(farbe == FarbEnum.weiss | farbe == FarbEnum.schwarz)){
				throw new ArithmeticException("Please choose a colour between weiss or schwarz");
		}else {
			farbe = farbe;
		}
		System.out.println("Sie haben erfolgreich einen neuen Spieler hinzugefügt!");
		return " ";
	}

	
}
