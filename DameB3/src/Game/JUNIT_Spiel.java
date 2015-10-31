package Game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Basisklassen.FarbEnum;
import Basisklassen.Spieler;

public class JUNIT_Spiel {
	
	private Spiel spiel;
	public FarbEnum rot;

	@Before
	public void vorMethode(){
		System.out.println("@Before");
		spiel = new Spiel();
	}
	
	@Test (expected = RuntimeException.class)
	public void testeSpielerhinzufügen(){
		spiel.spielerHinzufügen(null, null);
	}
	
	@Test (expected = RuntimeException.class)
	public void testeZielID(){
		spiel.zielID("a");
		spiel.zielID("a1548");
	}
	
	@Test 
	public void testeZugdurchführen(){
		spiel.startID("a1");
		spiel.zielID("b3");
		
	}

}
