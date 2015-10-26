package Game;

import java.util.Set;

//Über das Interface erfolgt auch die Ausgabe der aktuellen Spielbrett - Belegung
//in CSV - Notation.

public interface iBediener {

	
	public void spielLaden();
	public void spielSpeichern();
	public Spiel neuesSpiel(String name, String farbe, boolean KI);
	public boolean zugDurchführen();
	public String startID();
	public String zielID();
	
		
	
	
}

	
	




		

//		PrintWriter pw;
//		
//		pw = new PrintWriter (new FileWriter("brett.txt"));
//		
//		pw.close();
	
