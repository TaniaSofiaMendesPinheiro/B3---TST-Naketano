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
	private String ID;
	private boolean istFigur = true;
	private boolean istDame = false;
	protected int posX;
	protected int posY;
	private boolean weiss = true;
	// that you can distinguish between the figures from players
	protected boolean bewegDich = false;
	
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

	public Spielfigur(int posX, int posY) {

		this.posX = posX;
		this.posY = posY;
		
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
	 * @return x position of figure
	 */
	
	public int getPosX(){
		return posX;
	}
	
	/**
	 * 
	 * @return y-position from figure
	 */
	
	public int getPosY(){
		return posY;
	}
	
	/**
	 * set X-pos of figure
	 * @param posX
	 */
	
	public void setPosX(int posX){
		this.posX= posX;
	}
	
	/**
	 * set Y-pos of figure
	 * @param posY
	 */
	
	public void setPosY(int posY){
		this.posY = posY;
	}
	
	/**
	 * is for the player to know whom the figure belongsto
	 * @return
	 */
	
	public boolean istWeiss(){
		return this.weiss;
	}
	
	public boolean bewegDich(){
		return bewegDich;
	}
	
	public void wechselBewegDich(boolean bewegen){
		bewegDich = bewegen;
	}
	
	/**
	 * for the field...to set the black ones on board
	 */
	
	public void setSchwarzenStein(){
		weiss = false;
	}
	
	@Override
	public String toString(){
		if ( farbe == FarbEnum.weiss){
			return "o";
		}
		return "x";
	}
	
}
