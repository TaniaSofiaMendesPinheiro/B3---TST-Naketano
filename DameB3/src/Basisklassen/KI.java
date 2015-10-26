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

	public KI add(KI ki) {
		return ki;
	}
	
	
}
