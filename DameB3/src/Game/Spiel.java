package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Basisklassen.Spielbrett;
import Basisklassen.FarbEnum;
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
	private Spieler[] spielerliste;
	private Spieler amZug;
	private boolean gamestarted;
//	protected int spielzüge;
//	private Spielfeld feld;

	public Spiel() {
		this.brett = new Spielbrett();
		spielerliste = new Spieler[2];
		gamestarted = false;
	}

//	public int getSpielzüge() {
//		return this.spielzüge;
//	}
//
//	public void setSpielzüge(int spielzüge) {
//		if (spielzüge < 0) {
//			throw new IllegalArgumentException("Something went wrong.");
//		} else {
//			this.spielzüge += spielzüge;
//		}
//	}
//	
//	public Spielfeld getFeld(){
//		return feld;
//	}
//	
//	public void setFeld(Spielfeld feld){
//		this.feld = feld;
//	}

	public void spielen() {

	}

	// private boolean andererMussPusten(int[] tokenKoords){
	// Spielfigur token = map.getField(tokenKoords[0],
	// tokenKoords[1]).getSpielfigur();
	// ArrayList<Spielfigur> bullies = map.getFigurenDieSchlagenKoennen(); //das
	// müsste natürlich implementiert werden :D
	// for(Spielfigur f : bullies){
	// if(token.equals(f)){
	// return false;
	// }
	// }
	// return true;

	// private boolean pusten(String ID) {
	// Spielfigur figur = brett
	// }

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

	// if (istKI = true) {
	// spielerHinzufügen("Tania", "weiss");
	// System.out.println("Du spielst gegen eine KI!");
	// } else {
	// spielerHinzufügen("harald", "weiss");
	// spielerHinzufügen("dome", "schwarz");
	//
	// }

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
		String s2 = this.brett.toString();

		return s2;
	}

	@Override
	public boolean zugDurchführen(String startID, String zielID) {

		// führe ich gerade ein "pusten" durch
		// nachdem wir uns bewegt haben
		// ist startfeld in der liste enthalten
		// wenn ja --> liste leer
		// hat gepustet? -> ist liste leer?
		// wenn ich nicht gepustet habt, ich muss an dem punkt die liste
		// leeren...bevor ich tausche!!
		// zufällig -> wert aus liste zufällig und aus liste raus

		if (brett == null)
			throw new RuntimeException("There is no brett available!");
		else if (startID.equals(zielID)) {
			throw new RuntimeException("Not a valid move");
		} else if (brett.gibMirDiePosition(zielID).getFarbe() == FarbEnum.weiss) {
			throw new RuntimeException("Not a valid move on a white field");
			
		}else if (brett.gibMirDiePosition(zielID).getSpielfigur() != null) {
			if (!(brett.gibMirDiePosition(zielID).getSpielfigur().equals(brett.gibMirDiePosition(startID).getSpielfigur()))) {
				schlagen(zielID, startID);
				updateFeld();
			}
		} else if (!(brett.gibMirDiePosition(startID).equals(brett.gibMirDiePosition(zielID)))) {
			if (brett.gibMirDiePosition(zielID).getSpielfigur() == null) {
				brett.gibMirDiePosition(zielID).setSpielfigur(brett.gibMirDiePosition(startID).getSpielfigur());
				brett.gibMirDiePosition(startID).setSpielfigur(null);
				updateFeld();
			}
		} else if (brett.gibMirDiePosition(startID).getSpielfigur().equals(brett.gibMirDiePosition(zielID).getSpielfigur())) {
			throw new RuntimeException("You cannot go on a field which is already taken with one of your own figure.");
//		} else {
//			brett.gibMirDiePosition(zielID).setSpielfigur(brett.gibMirDiePosition(startID).getSpielfigur());
//			brett.gibMirDiePosition(startID).setSpielfigur(null);
//			updateFeld();

		}
		return true;
	}

	@Override
	public void speichern(String pfad, String name, String typ) {
		

	}

	@Override
	public void laden(String pfad, String name, String typ) {
		

	}

	private void schlagen(String startID, String zielID) {
		if (!(brett.gibMirDiePosition(zielID).getSpielfigur().equals(brett.gibMirDiePosition(startID).getSpielfigur()))) {
			brett.gibMirDiePosition(zielID).setSpielfigur(null);
			brett.gibMirDiePosition(zielID).setSpielfigur(brett.gibMirDiePosition(startID).getSpielfigur());
			brett.gibMirDiePosition(startID).setSpielfigur(null);

		}
	}
	public boolean prüfeDif(String startId, String zielId){
		if(brett.getIndexById(startId))
		
		return true;
	}
	
	/**
	 * soll mein brett nach der move methode aktualisieren und auf den neusten Stand bringen
	 */
	
	protected void updateFeld(){
		this.brett.gibMirDiePosition(null).setSpielfigur(null);
		
	}

}
