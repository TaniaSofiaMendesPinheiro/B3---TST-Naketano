package Game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class JUNIT_Spiel {
	
	private Spiel spiel;

	@Before
	public void vorMethode(){
		System.out.println("@Before");
		spiel = new Spiel();
	}
	
	@Test (expected = RuntimeException.class)
	public void testeSpielerhinzufügen(){
		spiel.spielerHinzufügen(null, "rot", false);
	}
	
	@Test (expected = RuntimeException.class)
	public void testeZielID(){
		spiel.zielID("a");
		spiel.zielID("a1548");
	}

}
