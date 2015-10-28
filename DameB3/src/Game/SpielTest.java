package Game;

import Basisklassen.Spielbrett;

public class SpielTest {

	public static void main(String[] args) {
		
		Spiel s1 = new Spiel();
		Spielbrett b = new Spielbrett();
		System.out.println(b);
		s1.spielerHinzufügen("Kira", FarbEnum.schwarz, Spieler.menschlspieler);
		s1.neuesSpiel("Ha", FarbEnum.weiss, Spieler.menschlspieler, Spieler.menschlspieler);
		
		
		

	}

}
