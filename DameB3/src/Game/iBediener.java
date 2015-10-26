package Game;

//Über das Interface erfolgt auch die Ausgabe der aktuellen Spielbrett - Belegung
//in CSV - Notation.

public interface iBediener {
	
	public void spielLaden();
	public void spielSpeichern();
	public void neuesSpiel(String name, String farbe, boolean KI);

	
	
}


		

//		PrintWriter pw;
//		
//		pw = new PrintWriter (new FileWriter("brett.txt"));
//		
//		pw.close();
	

