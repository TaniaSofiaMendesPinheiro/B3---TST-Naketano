package Basisklassen;

import java.io.Serializable;


public class Spielfeld implements Serializable{ // extends JButton

	// Implementieren Sie die Klasse Spielfeld.
	// Jedes Spielfeld hat eine ID gemäß der Schachnotation.
	// Außerdem kann ein Spielfeld eine Spielfigur kennen.

	private static final long serialVersionUID = 961135637441496019L;
	/**
	 * @author B3-TST-Naketano
	 */

	private Spielfigur spielfigur;
	private FarbEnum farbe;
	private String ID;


	public Spielfeld() {

	}

	/**
	 * constructor, if spielfeld is without spielfigur // spielfeld = empty
	 * 
	 * @param iD2
	 * @param istSchwarz
	 */

	public Spielfeld(String ID, boolean istSchwarz) {
		this.ID = ID;
		if (istSchwarz)
			this.farbe = FarbEnum.schwarz;
		else
			this.farbe = FarbEnum.weiss;

	}

	/**
	 * constructor with id, farbe and spielfigur --> my field is complete!
	 * 
	 * @param ID
	 * @param farbe
	 * @param spielfigur
	 */
//
//	public Spielfeld(String ID, FarbEnum farbe, Spielfigur spielfigur) {
//		this.ID = ID;
//		this.spielfigur = spielfigur;
//		this.farbe = farbe;
//	}
//	
//	public Spielfeld(String ID, FarbEnum fabre, EinfacheFigur stein){
//		
//	}


	public FarbEnum getFarbe() {
		return farbe;
	}

	public void setFarbe(FarbEnum farbe) {
		this.farbe = farbe;
	}

	/**
	 * getter for ID
	 * 
	 * @return ID
	 * 
	 */

	public String getID() {
		return ID;
	}

	/**
	 * setter for ID
	 * 
	 * @param iD
	 * @throws RuntimeException
	 *           my ID has to have min 2 symbols, but max 3 symbols
	 *           "a1 - a12"
	 */

	public void setID(String ID) {
		if (ID.length() <= 2 || ID.length() >= 3)
			throw new RuntimeException("This is not a valid ID!");
		else {
			this.ID = ID;
		}

	}

	/**
	 * getter spielfigur
	 * 
	 * @return
	 */

	public Spielfigur getSpielfigur() {
		return this.spielfigur;
	}

	/**
	 * setter spielfigur
	 * 
	 * @param spielfigur
	 */

	public void setSpielfigur(Spielfigur spielfigur) {
		this.spielfigur = spielfigur;
	}
	
//	public void setStein(EinfacheFigur stein){
//		this.stein = stein;
//	}
	
	public String toCSV(){
		String x = " ";
		if (spielfigur != null){
			if( farbe == FarbEnum.weiss){
			x = "w";	// weiße figur hat ein w
		}else{
			x = "DameW";	// schwarze figur hat ein s
		}
		}
		if (spielfigur != null){
			if (farbe == FarbEnum.schwarz){
				x = "s";
			}else{
				x = "DameS";
			}
		}if (spielfigur == null){
			x = "e";	// e = empty	
		}	
	
		return ID+";"+farbe+";"+x;
}
	

	@Override
	public String toString() {

		return this.spielfigur + ";" + this.ID + ";" + this.farbe ;
	}

}
