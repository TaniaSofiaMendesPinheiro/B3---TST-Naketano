package Game;

import Basisklassen.FarbEnum;
import Basisklassen.Spielbrett;

public class TestklasseSpiel {

	public static void main(String[] args) {

		Spiel s2 = new Spiel();
		s2.spielerHinzufügen("Sina", "weiss", false);
		s2.spielerHinzufügen("Kol", "schwarz", false);
		s2.zugDurchführen("a5", "b6");
		System.out.println(s2.gibMirCSV());
		
	}

}
