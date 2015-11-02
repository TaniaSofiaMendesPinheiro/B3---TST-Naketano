package Game;

import java.io.BufferedReader;import java.io.IOException;
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
//	private Spieler amZug;
	
	public Spiel() {
		this.brett = new Spielbrett();
		spielerliste = new Spieler[2];
	}

	public void spielen() {

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String ses = "";
			System.out.println("Um das Spiel zu beginnen gebe bitte 'add' in die Konsole ein!");

			do {
				if (amZug != null) {
					System.out.println(brett);
					if (amZug.hatGewonnen()) {
						System.out.println(amZug.getName() + " hat gewonnen!");
						return;
					}
					System.out.println(amZug.getName() + " ist am Zug.");
				}
				ses = reader.readLine().toLowerCase();
				switch (ses) {

				// adds new Player if input is valid, else continues the loop
				case "add":
					System.out.println("Wie heißt du?");
					String name = reader.readLine();
					if (name.length() < 2 || name == null) {
						throw new RuntimeException("Bitte gebe einen Namen mit mind 2 Buchstaben ein");
					}
					System.out.println("Welche Farbe möchtest du sein\n" + "\t Tippe 'w' für weiß und\n" + "\t Tippe 's' für schwarz");
					String color = reader.readLine();

					System.out.println("Entscheide nun, ob du gegen eine istKI oder gegen einen Mensch spielen willst.");
					String KI = reader.readLine();
					if (istKI == true) {
						System.out.println("Du spielst nun gegen eine KI");
					}
					if (istKI == false) {
						System.out.println("Du spielst gegen einen anderen Menschen.");
						System.out.println("Jetzt der zweite Spieler: ");
					}
					String name2 = reader.readLine();
					if (name2.length() < 2 || name2 == null || name2 == name) {
						throw new RuntimeException("Bitte gebe einen Namen mit mind 2 Buchstaben ein");
					}
					System.out.println("Welche Farbe möchtest du sein\n" + "\t Tippe 'w' für weiß und\n" + "\t Tippe 's' für schwarz");
					String color2 = reader.readLine();
					if (color2 == color) {
						throw new RuntimeException("Du darfst nicht dieselbe Farbe wie dein Gegner haben!");
					}
					System.out.println(name2 + " du spielst nun gegen " + name + ".");
					System.out.println("Willst du jetzt doch nicht mehr spielen gebe 'beenden' ein.");

					// bitte noch schauen wie ich die exception fangen kann und trotzdem
					// weiter machen kann!!

					// Probleme:
					// 1. wenn ich gegen eine KI spielen will kommt nur müll raus
					// heißt, wenn ich istKI eingebe, kommt zwar nach kurzer zeit
					// "du spielst nun gegen eine KI
					// jedoch wenn ich nochmal enter drück...wirft er mir eine Exception
					// dass ich einen Namen eingeben muss

					// 2. das mit der Farbe funktioniert noch nicht so wie ich mir das
					// vorstelle
					// ich kann die exception zwar catchen...jedoch kommt dann sowohl
					// wenn ich dieselbe als auch eine andere Farbe hab dieser syso vom
					// catch

					break;

				case "start":
					System.out.println("Gebe nun 'start' in die Konsole ein um zu beginnen.\n" + "Willst du das Spiel beenden, so gebe bitte 'beenden' in die Konsole ein.");

					break;

				case "zeigeBrett":
					Spielbrett b1 = new Spielbrett();
					b1.erstelleSpielbrett();

					break;

				case "beenden":
					System.out.println("Bis zum nächsten Mal.");
					break;

				}

			} while (!ses.equals("beenden"));

		} catch (IOException e) {
			System.out.println("Fehler");
		} // catch (RuntimeException re) {
			// System.err.print("Bitte wähle eine andere Farbe!");
		// }
	}


	
	/**
	 * Am Ende der Runde ist der andere Spieler an der Reihe spieler an der stelle
	 * 0 ist immer am zug, deswegen wechselt nach jeder runde die position im
	 * array
	 */

	public void zugEnde() {
		Spieler wechseln = spielerliste[0];
		spielerliste[0] = spielerliste[1];
		spielerliste[1] = wechseln;
	}

	@Override
	public void spielBeenden() {

	}

	@Override
	public void neuesSpiel() {
		this.spielen();
//		if (istKI = true) {
//			spielerHinzufügen("Tania", "weiss");
//			System.out.println("Du spielst gegen eine KI!");
//		} else {
//			spielerHinzufügen("harald", "weiss");
//			spielerHinzufügen("dome", "schwarz");
//
//		}
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
		} else if (spielerliste[1] == null){
			switch (farbe) {
			case "weiss":
				if ( spielerliste[0].getFarbEnum() == FarbEnum.schwarz){
					spielerliste[1] = new Spieler(name, FarbEnum.weiss, KI, this);
					System.out.println("Hallo " + spielerliste[1].getName() + ", du bist weiss");
					
				} else {
					System.err.println("Es gibt schon einen weißen Spieler.");
				}
				break;
			case "schwarz":
				if ( spielerliste[0].getFarbEnum() == FarbEnum.weiss){
				spielerliste[1] = new Spieler(name, FarbEnum.schwarz, KI, this);
				System.out.println("Hallo " + spielerliste[1].getName() + ", du bist schwarz");
				} else {
					System.err.println("Es gibt schon einen schwarzen Spieler.");
				}
				break;
			default:
				System.out.println("Wähle schwarz oder weiss");
			}
			
		}
		else {
			System.err.println("Es können nur zwei Spieler gleichzeitig spielen!");
		}
	}

	
	@Override
	public String gibMirCSV() {

		return this.brett.toString();
	}

	@Override
	public boolean zugDurchführen(String startID, String zielID) {
		if (brett == null)
			throw new RuntimeException("There is no brett available!");
		else if (startID.equals(zielID)) {
			throw new RuntimeException("Not a valid move");

		} else {
			brett.gibMirDiePosition(startID);
//			brett.spielfeld.setID(zielID(""));
		}
		return true;
	}


	@Override
	public void speichern(String pfad, String name, String typ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void laden(String pfad, String name, String typ) {
		// TODO Auto-generated method stub
		
	}

}
