package Basisklassen;

public abstract class Spielfigur {

	// Implementieren Sie die Klasse Spielfigur. Jede Spielfigur hat eine Farbe,
	// die aus einer
	// FarbEnum (schwarz, weiß) zu wählen ist. Außerdem hat eine Spielfigur
	// stets eine gültige
	// Position auf dem Spielbrett.
	/**
	 * @author Sina, Tania, Tobi
	 */

	private Spielfeld spielfeld;
	FarbEnum farbe;
	private String ID;
	private boolean istFigur = true;
	private boolean istDame = false;

	/**
	 * constructor of spielfigur with all objects on it
	 * 
	 * @param ID
	 * @param farbe
	 * @param spielfeld
	 */

	public Spielfigur(Spielfeld spielfeld, FarbEnum farbe, String ID) {
		this.spielfeld = spielfeld;
		this.farbe = farbe;
		this.setID(ID);

	}
		public Spielfigur(){
			
		}
	/**
	 * 
	 * @param feld
	 */
	public void setSpielfeld(Spielfeld spielfeld) {
		this.spielfeld = spielfeld;

	}

	public Spielfeld getSpielfeld() {
		return spielfeld;
	}

	public FarbEnum getFarbEnum() {
		return farbe;

	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		this.ID = iD;
	}
}
