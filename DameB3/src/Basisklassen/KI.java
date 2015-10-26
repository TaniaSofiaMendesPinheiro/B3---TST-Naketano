package Basisklassen;

public abstract class KI {
	
	private Spieler spieler;
	
	public KI(Spieler spieler){
		if(spieler == null){
			throw new RuntimeException("KI can`t exist without a Spieler");
		}
		else{
			this.spieler = spieler;
		}
	}

	public KI add(KI ki) {
		return ki;
	}

}
