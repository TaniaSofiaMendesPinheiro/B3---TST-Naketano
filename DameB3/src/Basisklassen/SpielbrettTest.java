package Basisklassen;

public class SpielbrettTest {

	public static void main(String[] args) {

		Spielbrett b = new Spielbrett();
		b.erstelleSpielbrett();
		b.setzeFigurenAufFeld();
		System.out.println(b);
	}

}
