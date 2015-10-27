package Game;

public class SpielTest {

	public static void main(String[] args) {
		
		Spiel s1 = new Spiel();
		s1.spielerHinzufügen("Alex", FarbEnum.weiss, Spieler.spieler);
		
		System.out.println(s1);
		
		
		

	}

}
