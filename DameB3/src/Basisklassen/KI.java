package Basisklassen;

public abstract class KI {
	
	/***
	 * @author B3-TST-Naketano
	 */
	
	private Spieler spieler;
	private String name;
	private FarbEnum farbe;
	
	public KI(Spieler spieler, String name, FarbEnum farbe){
		if(spieler == null){
			throw new RuntimeException("KI can`t exist without a Spieler");
		}
		else{
			this.spieler = spieler;
		}
		this.name = name;
		this.farbe = farbe;
	}	
	
	/**
	 * This method want a Spielfigur to get a Dame as fast as possbile.
	 */
	public void werdeDame(){
				
	}
	
	/**
	 * This method want to beat a Spielfigur of the opposite.
	 */
	public void schlageGegner(){
		
	}
	
	/**
	 * This method don`t want to get beat by a Spielfigur of the opposite.
	 */
	public void ausweichen(){
		
	}
	/**
	 * This method is to move the Spielfigur.
	 */
	public void bewegen(){
		
	}
	
}
