package Game;

import java.io.IOException;

import Basisklassen.Spielbrett;
import Basisklassen.Spieler;
import Basisklassen.Spielfigur;
import SpeichernUndLaden.DatenzugriffCSV;
import SpeichernUndLaden.DatenzugriffSER;
import Basisklassen.FarbEnum;
import SpeichernUndLaden.iDatenzugriff;

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
	private Spielfigur figur;

	public Spiel() {
		this.brett = new Spielbrett();
		spielerliste = new Spieler[2];
		gamestarted = false;
	}

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
		System.out.println(gibMirCSV());
		System.out.println(amZug + " ist jetzt am Zug.");

		// kann pusten?
		// speichert feld + figur in liste, die schlagen können zu beginn des zuges
	}

	@Override
	public void spielBeenden() {

	}

	@Override
	public void neuesSpiel() {
		try {
			if (spielerliste[0] != null && spielerliste[1] == null) {
				throw new RuntimeException("Das ist kein gültiges Spiel. Für dieses Spiel braucht man 2 Spieler!");
			} else if (spielerliste[0].getFarbEnum() == FarbEnum.weiss) {
				amZug = spielerliste[0];
			} else {
				Spieler wechseln = spielerliste[0];
				spielerliste[0] = spielerliste[1];
				spielerliste[1] = wechseln;
				amZug = spielerliste[0];
			}
			gamestarted = true; // boolean flag
			this.spielen();
		} catch (RuntimeException er) {
			System.err.println("Das ist kein gültiges Spiel. Für dieses Spiel braucht man 2 Spieler!");
		}
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
			if (amZug.getFarbEnum().equals(brett.gibMirDiePosition(startID).getFarbe())) {
				if (amZug != null && brett.gibMirDiePosition(zielID).getSpielfigur() != null) {
					if (!(brett.gibMirDiePosition(zielID).getSpielfigur().getFarbEnum().equals(brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum()))) {
						schlagen(zielID, startID);
						zugEnde();
						updateFeld();
					}
				}
			}
			if (brett.gibMirDiePosition(zielID).getSpielfigur() != null) {
				if (prüfeDif(startID, zielID) == false && prüfeDifSchlagen(startID, zielID)) {
					throw new RuntimeException("Ungültiger Zug.");
				}
			}
			if (brett.gibMirDiePosition(zielID).getSpielfigur() != null) {
				if (!(brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum().equals(brett.gibMirDiePosition(zielID).getSpielfigur().getFarbEnum()))) {
					if (prüfeDifSchlagen(startID, zielID) == true) {
						schlagen(startID, zielID);
						zugEnde();
						updateFeld();
					}
				}
				if (brett.gibMirDiePosition(zielID).getSpielfigur() == null) {
					if( brett.gibMirDiePosition(zielID) = "l"){
					for (int x = 0; x < 1; x++) {
						for (int y = 0; y < 12; y++) {
							if (brett[x][y].getFarbe() == FarbEnum.schwarz) {
								if (brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum().equals(amZug.getFarbEnum())) {
									brett.gibMirDiePosition(zielID).setSpielfigur(figur.istDame());
						}
				}

			}

			if (brett.gibMirDiePosition(startID).getSpielfigur() != null && brett.gibMirDiePosition(zielID).getSpielfigur() != null && brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum() == brett.gibMirDiePosition(zielID).getSpielfigur().getFarbEnum()) {
				throw new RuntimeException("You cannot go on a field which is already taken with one of your own figure.");

			}
			if (!(amZug.getFarbEnum().equals(brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum()))) {
				throw new RuntimeException("You have to go with a figure of your colour");
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
	public void speichern(String pfad, String name, String typ) throws IOException {
		if (typ.equals("csv")) {
			String csv = spielerliste[0].toCSV() + "\n";
			csv += spielerliste[1].toCSV() + "\n";
			csv += amZug.getFarbEnum() + "\n";
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 12; j++) {
					csv += brett.gibMirDiePosition(i, j);
					iDatenzugriff x = new DatenzugriffCSV();
					x.speichern(pfad, name, typ);
				}
			}
		} else {
			// if( typ.equals("ser")){
			// String ser = spielerliste[0].toSER() + "\n";
			// ser += spielerliste[1].toSER() + "\n";
			// ser+= amZug.getFarbEnum() + "\n";
			// for ( int i = 0; i < 12; i++){
			// for ( int j = 0; j < 12; j++){
			// ser += brett.gibMirDiePosition(i, j);
			iDatenzugriff y = new DatenzugriffSER();
			y.speichern(pfad, name, typ);
		}
	}

	@Override
	public void laden(String pfad, String name, String typ) throws IOException {
		if (typ.equals("ser")) {
			iDatenzugriff iD = new DatenzugriffSER();
			iD.laden();
		} else {
			iDatenzugriff iDz = new DatenzugriffCSV();
			iDz.laden();
		}
	}

	/**
	 * Überprüft ob Start-/Zielfeld weiss ist, ob Zug zulässig ist, ob Startfeld
	 * Figur hat
	 * 
	 * @param startID
	 * @param zielID
	 */

	private boolean schlagen(String startID, String zielID) {
		try {
			if (brett.gibMirDiePosition(startID).getSpielfigur() == null) {
				throw new RuntimeException("Auf deinem Startfeld ist keine Figur.");
			} else if (brett.gibMirDiePosition(zielID).getFarbe() == FarbEnum.weiss) {
				throw new RuntimeException("Weisse Felder sind ungültig!");
			} else if (brett.gibMirDiePosition(zielID).getSpielfigur() != null) {
				if (prüfeDifSchlagen(startID, zielID) == false) {
					throw new RuntimeException("Der Zug ist ungültig");
				} else if (prüfeDifSchlagen(startID, zielID) == true && brett.gibMirDiePosition(zielID).getSpielfigur() == null) {
					if (prüfeDif(startID, zielID) == true) {
						startID = zielID;

						brett.gibMirDiePosition(startID + 1).setSpielfigur(null);
						brett.gibMirDiePosition(zielID).setSpielfigur(brett.gibMirDiePosition(startID).getSpielfigur());
						brett.gibMirDiePosition(startID).setSpielfigur(null);
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();

		}
		return true;
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

	/**
	 * updates our field --> and shows the current brett
	 */
	public void updateFeld() {

		gibMirCSV();

	}

}
