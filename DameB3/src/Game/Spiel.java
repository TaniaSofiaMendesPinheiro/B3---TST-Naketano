package Game;

import Basisklassen.Spielbrett;
import Basisklassen.FarbEnum;
import Basisklassen.Spieler;
import Basisklassen.Spielfeld;

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
	private Spieler[] spielerliste;
	private Spieler amZug;
	private boolean gamestarted;

	public Spiel() {
		this.brett = new Spielbrett();
		spielerliste = new Spieler[2];
		gamestarted = false;
	}

	// public int getSpielzüge() {
	// return this.spielzüge;
	// }
	//
	// public void setSpielzüge(int spielzüge) {
	// if (spielzüge < 0) {
	// throw new IllegalArgumentException("Something went wrong.");
	// } else {
	// this.spielzüge += spielzüge;
	// }
	// }
	//
	// public Spielfeld getFeld(){
	// return feld;
	// }
	//
	// public void setFeld(Spielfeld feld){
	// this.feld = feld;
	// }

	public void spielen() {

	}

	/**
	 * Am Ende der Runde ist der andere Spieler an der Reihe spieler an der stelle
	 * 0 ist immer am zug, deswegen wechselt nach jeder runde die position im
	 * array
	 */

	public void zugEnde() {

		// hat gepustet?

		Spieler wechseln = spielerliste[0];
		spielerliste[0] = spielerliste[1];
		spielerliste[1] = wechseln;
		amZug = spielerliste[0];
		System.out.println(amZug + " ist jetzt am Zug.");
		System.out.println(gibMirCSV());

		// kann pusten?
		// speichert feld + figur in liste, die schlagen können zu beginn des zuges
	}

	@Override
	public void spielBeenden() {

	}

	@Override
	public void neuesSpiel() {
		if (spielerliste[0].getFarbEnum() == FarbEnum.weiss) {
			amZug = spielerliste[0];
		} else {
			Spieler wechseln = spielerliste[0];
			spielerliste[0] = spielerliste[1];
			spielerliste[1] = wechseln;
			amZug = spielerliste[0];
		}
		gamestarted = true; // boolean flag
		this.spielen();
	}

	@Override
	public void spielerHinzufügen(String name, String farbe, boolean KI) {
		if (spielerliste[0] == null) {
			switch (farbe) {
			case "weiss":
				spielerliste[0] = new Spieler(name, FarbEnum.weiss, KI, this);
				System.out.println("Hallo " + spielerliste[0].getName() + ", du bist weiss");
				break;
			case "schwarz":
				spielerliste[0] = new Spieler(name, FarbEnum.schwarz, KI, this);
				System.out.println("Hallo " + spielerliste[0].getName() + ", du bist schwarz");
				break;
			default:
				System.out.println("Wähle schwarz oder weiss");
			}
		} else if (spielerliste[1] == null) {
			switch (farbe) {
			case "weiss":
				if (spielerliste[0].getFarbEnum() == FarbEnum.schwarz) {
					spielerliste[1] = new Spieler(name, FarbEnum.weiss, KI, this);
					System.out.println("Hallo " + spielerliste[1].getName() + ", du bist weiss");

				} else {
					System.err.println("Es gibt schon einen weißen Spieler.");
				}
				break;
			case "schwarz":
				if (spielerliste[0].getFarbEnum() == FarbEnum.weiss) {
					spielerliste[1] = new Spieler(name, FarbEnum.schwarz, KI, this);
					System.out.println("Hallo " + spielerliste[1].getName() + ", du bist schwarz");
				} else {
					System.err.println("Es gibt schon einen schwarzen Spieler.");
				}
				break;
			default:
				System.out.println("Wähle schwarz oder weiss");
			}

		} else {

			throw new RuntimeException("");
			// System.err.println("Es können nur zwei Spieler gleichzeitig spielen!");
		}
	}

	@Override
	public String gibMirCSV() {

		return this.brett.toString();
	}

	// führe ich gerade ein "pusten" durch
	// nachdem wir uns bewegt haben
	// ist startfeld in der liste enthalten
	// wenn ja --> liste leer
	// hat gepustet? -> ist liste leer?
	// wenn ich nicht gepustet habt, ich muss an dem punkt die liste
	// leeren...bevor ich tausche!!
	// zufällig -> wert aus liste zufällig und aus liste raus

	@Override
	public void zugDurchführen(String startID, String zielID) {
		try {
			if (brett == null) {
				throw new RuntimeException("There is no brett available!");
			}
			if (startID.equals(zielID)) {
				throw new RuntimeException("Not a valid move");
			}
			if (brett.gibMirDiePosition(zielID).getFarbe() == FarbEnum.weiss || brett.gibMirDiePosition(startID).getFarbe() == FarbEnum.weiss) {
				throw new RuntimeException("Not a valid move on a white field");
			}
			if (amZug != null && brett.gibMirDiePosition(zielID).getSpielfigur() != null) {
				if (!(brett.gibMirDiePosition(zielID).getSpielfigur().getFarbEnum().equals(brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum()))) {
					schlagen(zielID, startID);
					zugEnde();
					updateFeld();
				}
			}
			if (brett.gibMirDiePosition(zielID).getSpielfigur() != null) {
				if (prüfeDif(startID, zielID) == false){//&& amZug != null) {
					throw new RuntimeException("Ungültiger Zug.");
				
				} 
			}
			if (brett.gibMirDiePosition(startID).getSpielfigur() != null && brett.gibMirDiePosition(zielID).getSpielfigur() != null && brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum() == brett.gibMirDiePosition(zielID).getSpielfigur().getFarbEnum()) {

				throw new RuntimeException("You cannot go on a field which is already taken with one of your own figure.");
			}
			brett.gibMirDiePosition(zielID).setSpielfigur(brett.gibMirDiePosition(startID).getSpielfigur());
			brett.gibMirDiePosition(startID).setSpielfigur(null);
			zugEnde();
			updateFeld();
		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
			re.printStackTrace();
		}
	}

	@Override
	public void speichern(String pfad, String name, String typ) {

	}

	@Override
	public void laden(String pfad, String name, String typ) {

	}

	/**
	 * Überprüft ob Start-/Zielfeld weiss ist, ob Zug zulässig ist, ob Startfeld
	 * Figur hat
	 * 
	 * @param startID
	 * @param zielID
	 */

	private void schlagen(String startID, String zielID) {
		try {
			if (brett.gibMirDiePosition(startID).getSpielfigur() == null) {
				System.err.println("Auf deinem Startfeld ist keine Figur.");
			}
			// prüfung ob startfeld weiss eig unnötig, da zuvor auf figur null geprüft
			// wird und weisse felder immer figur = null ist
			else if (brett.gibMirDiePosition(startID).getFarbe() == FarbEnum.weiss) {
				System.err.println("Weisse Felder sind ungültig!");
			} else if (brett.gibMirDiePosition(zielID).getFarbe() == FarbEnum.weiss) {
				System.err.println("Weisse Felder sind ungültig!");
			} else if (prüfeDifSchlagen(startID, zielID) == false) {
				System.err.println("Der Zug ist ungültig");
			} else if (prüfeDifSchlagen(startID, zielID) == true && brett.gibMirDiePosition(zielID).getSpielfigur() == null) {
				int[] liste1 = brett.getIndexById(startID);
				liste1[0] += 1;
				liste1[1] += 1;
				brett.gibMirDiePosition(zielID).setSpielfigur(brett.gibMirDiePosition(startID).getSpielfigur());
				brett.gibMirDiePosition(startID).setSpielfigur(null);
				brett.gibMirDiePosition(liste1[0], liste1[1]).setSpielfigur(null);
			}
		} catch (Exception e) {
			System.out.println("Schlagen hat nicht geklappt, bitte versuche es nochmal");
		}
	}

	/**
	 * prüft diferenz zwischen start id und ziel id, diferenz muss genau 1 sein!
	 * math.abs() gibt den betrag zurück, ohne vorzeichen
	 */

	public boolean prüfeDif(String startId, String zielId) {
		int[] liste1 = brett.getIndexById(startId);
		int[] liste2 = brett.getIndexById(zielId);

		return (Math.abs(liste2[0]) - Math.abs(liste1[0]) == 1 && liste2[1] - liste1[1] == 1);

	}

	/**
	 * gleiche methode wie prüfeDif nur mit der diferenz von 2, da die zu
	 * schlagende figur übersprungen wird.
	 * 
	 * @param startId
	 * @param zielId
	 * @return
	 */
	public boolean prüfeDifSchlagen(String startId, String zielId) {
		int[] liste1 = brett.getIndexById(startId);
		int[] liste2 = brett.getIndexById(zielId);

		if (Math.abs(liste2[0]) - Math.abs(liste1[0]) == 2 && liste2[1] - liste1[1] == 2) {
			return true;
		}
		return false;
	}

	// soll array durchlaufen und überall wo feld eine figur hat auf dem brett x
	// oder o setzen..
	public void updateFeld() {

		gibMirCSV();
		// for (int i = 0; i < 12; i++) {
		// for (int j = 0; j < 12; j++) {
		// if (this.brett.gibMirDiePosition(i, j).getSpielfigur() != null) {
		// if (this.brett.gibMirDiePosition(i, j).getSpielfigur().getFarbEnum() ==
		// FarbEnum.weiss) {
		// brett.toString();
		// } else if (this.brett.gibMirDiePosition(i,
		// j).getSpielfigur().getFarbEnum() == FarbEnum.schwarz) {
		// brett.toString();
		// }
		// }
		// }
		// }
	}

	//
	// protected void updateBrett(){
	// feld.setSpielfigur(null);
	// feld = brett.gibMirDiePosition(posY, posX);
	// feld.setSpielfigur(this);
	//
	//
	// }
}
