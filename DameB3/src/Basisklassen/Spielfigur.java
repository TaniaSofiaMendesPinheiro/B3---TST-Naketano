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
	FarbEnum farbe;
	private String ID;
	boolean istDame = false;
	private boolean weiss = true;
	// that you can distinguish between the figures from players
	
	public Spielfigur(){
		
	}

	/**
	 * constructor of spielfigur with all objects on it
	 * 
	 * @param farbe
	 */
	
	
	public Spielfigur(FarbEnum farbe, boolean istDame) {
		this.farbe = farbe;
		this.istDame = istDame;
	}

	public FarbEnum getFarbEnum() {
		return farbe;
	}
	
	
	/**
	 * is for the player to know whom the figure belongsto
	 * @return
	 */
	
	public boolean istWeiss(){
		return this.weiss;
	}
	
	/**
	 * for the field...to set the black ones on board
	 */
	
	public void setSchwarzenStein(){
		weiss = false;
	}
	
	public void setIstDame(boolean istDame){
		this.istDame = true;
	}
	
	public boolean istDame(){
		return istDame;
	}
	
	public String toCSV(){
		String x = " ";
		if(istDame){
			if ( farbe == FarbEnum.weiss){
				x = "DameW";
			}else{
				x = "DameS";
			}
		} else {
		if ( farbe == FarbEnum.weiss){
			x = "w";
		}
			 x  = "s";
		}
		return ID+";"+farbe+";"+x;
}

	
	@Override
	public String toString(){
		if(istDame){
			if ( farbe == FarbEnum.weiss){
				return "DameW";
			}else{
				return "DameS";
			}
		}
		if ( farbe == FarbEnum.weiss){
			return "w";
		}
			return "s";
	}
	
	
}
