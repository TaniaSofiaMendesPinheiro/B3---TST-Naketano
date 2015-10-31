package Basisklassen;
// Implementieren Sie die Klasse Spielfigur. Jede Spielfigur hat eine Farbe,
// die aus einer
// FarbEnum (schwarz, weiß) zu wählen ist. Außerdem hat eine Spielfigur
// stets eine gültige
// Position auf dem Spielbrett.

import java.io.Serializable;

public class Spielfigur implements Serializable{

	/**
	 * @author B3-TST-Naketano
	 */
	private static final long serialVersionUID = -1153301073951482590L;
	private Spielfeld spielfeld;
	FarbEnum farbe;
	private boolean istFigur = true;
	private boolean istDame = false;
	
	public Spielfigur(){
		
	}

	/**
	 * constructor of spielfigur with all objects on it
	 * 
	 * @param ID
	 * @param farbe
	 * @param spielfeld
	 */
	
	
	public Spielfigur(Spielfeld spielfeld, FarbEnum farbe) {
		this.spielfeld = spielfeld;
		this.farbe = farbe;
		
	}

	/**
	 * 
	 * @param feld
	 */
	public void setSpielfeld(String ID) {
		this.ID = ID;

	}

	public Spielfeld getSpielfeld() {
		return spielfeld;
	}

	public FarbEnum getFarbEnum() {
		return farbe;

	}
	
	/**
	 * my figure gets and takes the ID of my field.. so i don't need a special getter and setter for ID
	 */
//	public String getID() {
//		return ID;
//	}
//
//	public void setID(String iD) {
//		this.ID = iD;
//	}
}
