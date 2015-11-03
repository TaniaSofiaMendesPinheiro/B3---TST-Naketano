package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Basisklassen.Spielbrett;



public class SpielTest {

	public static void main(String[] args) {
		
		iBediener s1 = new Spiel();
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String ses = "";
			System.out.println("Help : \n" + "add = Spieler hinzufügen \n" + "start = beginne ein neues Spiel\n" 
			+ "zug = gebe startID und zielID ein\n" + "zeigebrett = zeigt dir die aktuelle Spielbrettbelegung\n" +
					"beenden = beendet das Spiel.");
			System.out.println("Um das Spiel zu beginnen gebe bitte 'add' in die Konsole ein!");

			do {
				
				ses = reader.readLine().toLowerCase();
				switch (ses) {

				// adds new Player if input is valid, else continues the loop
				case "add":
					System.out.println("Wie heißt du?");
					String name = reader.readLine();
					if (name.length() < 2 || name == null) {
						throw new RuntimeException("Bitte gebe einen Namen mit mind 2 Buchstaben ein");
					}
					System.out.println("Welche Farbe möchtest du sein\n" + "\t Tippe 'weiss' für weiß und\n" + "\t Tippe 'schwarz' für schwarz");
					String color = reader.readLine();

					System.out.println("Entscheide nun, ob du eine KI sein willst (y) oder nicht (n).");
					String KI = reader.readLine();
					if (KI.equals("y")) {
						System.out.println("Du bist nun eine KI");
						System.out.println("Um einen neuen Spieler hinzuzufügen bitte 'add' eingeben. \n" + 
								"Beachte, dass es 2 Spieler geben muss.");
								System.out.println("Zum Spiel starten bitte 'start' eingeben.");
						try {
							s1.spielerHinzufügen(name, color, true);
						}catch (Exception e){
							System.err.println("Es gibt schon zwei Spieler. Gebe 'start' zum Starten ein.");
						}
					}
					else if (KI.equals("n")) {
						System.out.println("Du bist ein Mensch.");
						s1.spielerHinzufügen(name, color, false);
						System.out.println("Um einen neuen Spieler hinzuzufügen bitte 'add' eingeben. \n" + 
						"Beachte, dass es 2 Spieler geben muss.");
						System.out.println("Zum Spiel starten bitte 'start' eingeben.");
					}

					break;

				case "start":
					s1.neuesSpiel();
					System.out.println(s1.gibMirCSV());
//					System.out.println("Gebe nun 'start' in die Konsole ein um zu beginnen.\n" + "Willst du das Spiel beenden, so gebe bitte 'beenden' in die Konsole ein.");

					break;
					
				case "zug":
					
					System.out.println("Startfeld eingeben: ");
					String start = reader.readLine();
					System.out.println("Zielfeld eingeben: ");
					String ende = reader.readLine();
					try{
						s1.zugDurchführen(start, ende);
					}catch (RuntimeException re){
					System.err.println("Default!");
					}		
	
					break;

				case "zeigebrett":
					
				System.out.println(s1.gibMirCSV());

					break;

				case "beenden":
					s1.spielBeenden();
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

}
