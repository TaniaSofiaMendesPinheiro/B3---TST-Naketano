package Basisklassen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import Game.Spiel;
import Game.iBediener;
//import Basisklassen.Spielbrett;

public abstract class KI implements Serializable{
	
	private iBediener x;
	private Spielbrett brett;
	private String [] zug = new String [2];
	private ArrayList<String[]> zugliste1;
	private Spieler spieler;
	private Spiel spiel;
	private String name;
	private FarbEnum farbe;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3230841103787560281L;
	/***
	 * @author B3-TST-Naketano
	 */
	
	public KI (Spieler spieler, String name, FarbEnum farbe){
		if(spieler == null){
			throw new RuntimeException("KI can`t exist without a Spieler");
		}
		else{
			this.spieler = spieler;
			this.name = name;
			this.farbe = farbe;
			this.spielen();
		}	
	}
	
	public KI add(KI ki){
		return ki;
	}
	
	public void spielen(){
		this.schlagenSammeln();
		this.zügeSammeln();
	}
	
	public void zügeSammeln(){
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 12; j++){
				if(brett.gibMirDiePosition(i, j).getSpielfigur() == null){
					throw new RuntimeException("Es sind keine Züge möglich!");
				}
				else if(brett.gibMirDiePosition(i, j).getSpielfigur().getFarbEnum() == spieler.getFarbEnum()){
					if(brett.gibMirDiePosition(i, j).getSpielfigur() != null &&
						brett.gibMirDiePosition(i + 1, j +1).getSpielfigur() == null){
						
							String start = brett.gibMirDiePosition(i, j).getID();
							String ende = brett.gibMirDiePosition(i+1, j+1).getID();
							zug[0] = start;
							zug[1] = ende;
							zugliste1.add(zug);
					}
					else if(brett.gibMirDiePosition(i, j).getSpielfigur() != null && 
									brett.gibMirDiePosition(i + 1, j -1).getSpielfigur() == null){
							String start = brett.gibMirDiePosition(i, j).getID();
							String ende = brett.gibMirDiePosition(i+1, j-1).getID();
							zug[0] = start;
							zug[1] = ende;
							zugliste1.add(zug);
					}
				} 
				Collections.shuffle(zugliste1);
				String [] liste = zugliste1.get(0);
				String start = liste[0];
				String ende = liste[1];
				spiel.zugDurchführen(start, ende);
				spiel.zugEnde();
				spiel.updateFeld();
			}
		}
	}
	
	
	public void schlagenSammeln(){
		for(int i = 0; i < 12; i++){
			for(int j = 0; j < 12; j++){
				if(brett.gibMirDiePosition(i, j).getSpielfigur() == null){
					throw new RuntimeException("Es sind keine Züge möglich!");
				}
				else if(brett.gibMirDiePosition(i, j).getSpielfigur().getFarbEnum() == spieler.getFarbEnum()){
					if(brett.gibMirDiePosition(i + 1, j +1).getSpielfigur() !=null &&
						 brett.gibMirDiePosition(i+1, j+1).getSpielfigur().getFarbEnum() != spieler.getFarbEnum()){
						
							String start = brett.gibMirDiePosition(i, j).getID();
							String ende = brett.gibMirDiePosition(i+2, j+2).getID();
							zug[0] = start;
							zug[1] = ende;
							zugliste1.add(zug);
					}
					else if(brett.gibMirDiePosition(i, j).getSpielfigur() != null && 
							brett.gibMirDiePosition(i+1, j-1).getSpielfigur().getFarbEnum() != spieler.getFarbEnum()){
							String start = brett.gibMirDiePosition(i, j).getID();
							String ende = brett.gibMirDiePosition(i+2, j-2).getID();
							zug[0] = start;
							zug[1] = ende;
							zugliste1.add(zug);
					}
				} 
				Collections.shuffle(zugliste1);
				String [] liste = zugliste1.get(0);
				String start = liste[0];
				String ende = liste[1];
				spiel.zugDurchführen(start, ende);
				spiel.zugEnde();
				spiel.updateFeld();
				
			}
		}
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
//		if (brett.gibMirDiePosition(startID) < brett || brett.gibMirDiePosition(ID))
//			
//		
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
