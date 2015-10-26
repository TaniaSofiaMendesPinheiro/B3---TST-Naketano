package Basisklassen;

public abstract class KI {
	
	/***
	 * @author B3-TST-Naketano
	 */
	
	private Spieler spieler;
	
	public KI(Spieler spieler){
		if(spieler == null){
			throw new RuntimeException("KI can`t exist without a Spieler");
		}
		else{
			this.spieler = spieler;
		}
	}

}
