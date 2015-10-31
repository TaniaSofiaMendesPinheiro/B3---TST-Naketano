package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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
	private Spieler [] spielerliste;
	private Spieler spieler;
	private Spieler amZug;
	private boolean istDame = false;
	private boolean istKI = false;
	private boolean mensch = true;

	

	public Spiel() {
		this.brett = new Spielbrett();
		spielerliste = new Spieler[2];
		this.spielen();
	}

	public void spielen(){
		
		try{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String ses = "";
		System.out.println("Um das Spiel zu beginnen gebe bitte 'add' in die Konsole ein!");
		
		do{
			if(amZug != null){
				System.out.println(brett);
				if(amZug.hatGewonnen()){
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
					if ( name.length() < 2 || name == null){
						throw new RuntimeException ("Bitte gebe einen Namen mit mind 2 Buchstaben ein");
					}
					System.out.println("Welche Farbe möchtest du sein\n" + "\t Tippe 'weiss' für weiß und\n"
							+ "\t Tippe 'schwarz' für schwarz");
					String color = reader.readLine();
					
//					if(spielerHinzufügen(name,color)){
					System.out.println("Willkommen: " + name + " du hast dir die Farbe \n" + color + " ausgesucht." );
								
					System.out.println("Entscheide nun, ob du gegen eine istKI oder gegen einen Mensch spielen willst.");
					String KI = reader.readLine();
					if(istKI == true){
					System.out.println("Du spielst nun gegen eine KI");
					} if (istKI == false){
//					String Mensch = reader.readLine();
					System.out.println("Du spielst gegen einen anderen Menschen.");
					System.out.println("Jetzt der zweite Spieler: ");
					}
					String name2 = reader.readLine();
					if(name2.length() < 2 || name2 == null || name2 == name){
						throw new RuntimeException("Bitte gebe einen Namen mit mind 2 Buchstaben ein");
					}
					System.out.println("Welche Farbe möchtest du sein\n" + "\t Tippe 'weiss' für weiß und\n"
							+ "\t Tippe 'schwarz' für schwarz");
					String color2 = reader.readLine();
					if ( !(color2 == color)){
						throw new RuntimeException("Du darfst nicht dieselbe Farbe haben wie dein Mitspieler");
						// bitte noch schauen wie ich die exception fangen kann und trotzdem weiter machen kann!!
					}
					
					System.out.println("Willkommen: " + name2 + " du hast dir die Farbe \n" + color2 + " ausgesucht." );
					System.out.println(name2 + " du spielst nun gegen " + name2 + ".");
					System.out.println("Willst du jetzt doch nicht mehr spielen gebe 'beenden' ein.\n"
							+ "Um das Spiel zu einem anderen Zeitpunkt zu beenden gebe 'beenden' in der Konsole ein.");
					
				break;
				
						
					
				
				case "zeigeBrett" :
					Spielbrett b1 = new Spielbrett();
					b1.erstelleSpielbrett();
					
					break;
				
							
				case "beenden": System.out.println("Bis zum nächsten Mal.");
				break;
				
				
				
				
			}
			
			
			
		}while(!ses.equals("beenden"));
		 
		}catch(IOException e){
			System.out.println("Fehler");
		}
}
	
	
	@Override
	public boolean zugDurchführen(String ID) {
		if (brett == null)
			throw new RuntimeException("There is no brett available!");
		else if (startID(brett.spielfeld.getID(ID)) == zielID(brett.spielfeld.getID(ID))) {
			throw new RuntimeException("Not a valid move");
			// } else if( else if (startID(brett.spielfeld.getFarbe()) &&
			// zielID(brett.spielfeld.getFarbe())){
			// return false;
		} else if (startID(brett.spielfeld.getID(ID)) != zielID(brett.spielfeld.getID(ID))) {
			brett.spielfeld.setID(zielID(""));
		}
		return true;
	}

	@Override
	public String startID(String ID) {
		String startID = brett.spielfeld.getID(ID);
		if (ID == null | ID.length() < 2 | ID.length() > 3) {
			throw new RuntimeException("This is not a valid position!");
		} else
			return brett.spielfeld.getID(ID);
	}

	@Override
	public String zielID(String ID) {
//		String zielID = brett.spielfeld.setID(ID);
		
		if (brett.spielfeld.getFarbe() != FarbEnum.schwarz) {
			throw new RuntimeException("white is not allowed for player or dame");
		}
		if (brett.spielfeld.getSpielfigur() != null) {

		} else if (brett.spielfeld.getSpielfigur() != null) {
			throw new RuntimeException("Field is not valid!");
		} else {
			brett.spielfeld.setID(zielID(ID));
		}
		return brett.spielfeld.getID(ID);
	}
	
	/**
	 * Am Ende der Runde ist der andere Spieler an der Reihe
	 * spieler an der stelle 0 ist immer am zug, deswegen wechselt nach 
	 * jeder runde die position im array
	 */
	
	public void zugEnde(){
		Spieler wechseln = spielerliste[0];
		spielerliste [0] = spielerliste[1];
		spielerliste [1] = wechseln;
	}
	

	@Override
	public void spielBeenden() {

	}

	@Override
	public void neuesSpiel() {
		if (istKI = true) {
			spielerHinzufügen("Tania", "weiss");
			System.out.println("Du spielst gegen eine KI!");
		} else {
			spielerHinzufügen("harald", "weiss");
			spielerHinzufügen("dome", "schwarz");

		}
	}

	@Override
	public void spielerHinzufügen(String name, String farbe) {
		if(spielerliste[0] == null | spielerliste[1] == null){
			switch(farbe){
			case "weiss": spielerliste[0] = new Spieler(name, FarbEnum.weiss);
			System.out.println("Hallo " + spieler.getName() + ", du bist weiss");
			break;
			case "schwarz": spielerliste [1] = new Spieler(name, FarbEnum.schwarz);
			System.out.println("Hallo " + spieler.getName() + ", du bist schwarz");
			break;
			default: System.out.println("Wähle schwarz oder weiss");
			}
		}else{System.err.println("Es können nur zwei Spieler gleichzeitig spielen!");}
	}

	/**
	 * this is a method for our figures to set on our brett.
	 */

	public void setzeFigurenAufsBrett(String ID) {
		char x = 0;
		for (int i = 0; i <= 5; i++) {
			for (char j = 0; j <= (char) (x + 108); j++) {
				if (brett.spielfeld.getFarbe() == FarbEnum.schwarz) {
					brett.getSpielfeld(ID).setSpielfigur(new Spielfigur());
				}
			}
		}

		char y = 0;
		for (int i = 8; i <= 12; i++) {
			for (char j = 0; j <= (char) (y + 108); j++) {
				if (brett.spielfeld.getFarbe() == FarbEnum.schwarz) {
					brett.getSpielfeld(ID).setSpielfigur(new Spielfigur());
				}
			}
		}
		// return "x" + x + "y" + y;
	}

}

	
//	/**
//	 * if 2 coordinates in valid brett
//	 */
//
//	@Override
//	public boolean istNochImBrett(int row, int col) {
//		return row >= 0 && col >= 0 &&
//				row < spielfigur.length && col < spielfigur[0].length;
//				
//			
//		}
	
	
