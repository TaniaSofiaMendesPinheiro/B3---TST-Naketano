package Basisklassen;

import java.io.Serializable;
import Game.Spiel;
import Game.iBediener;

public abstract class KI implements Serializable{
	
	private iBediener x;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3230841103787560281L;
	/***
	 * @author B3-TST-Naketano
	 */
	
	public KI (Spiel spiel){
		x = spiel;
	}
//	
//	private Spieler spieler;
//	private String name;
//	private FarbEnum farbe;
//	
//	public KI(Spieler spieler, String name, FarbEnum farbe){
//		if(spieler == null){
//			throw new RuntimeException("KI can`t exist without a Spieler");
//		}
//		else{
//			this.spieler = spieler;
//		}
//		this.name = name;
//		this.farbe = farbe;
//	}	
	
	
	public abstract void denken();
	
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
