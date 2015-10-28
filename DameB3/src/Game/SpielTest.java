package Game;

import Basisklassen.FarbEnum;
import Basisklassen.Spielbrett;

public class SpielTest {

	public static void main(String[] args) {
		
		Spiel s1 = new Spiel();
		Spielbrett b = new Spielbrett();
		System.out.println(b);
		s1.neuesSpiel();
		s1.setzeFigurAufBrett(istFigur, FarbEnum.weiss);
		
		

	}

}
