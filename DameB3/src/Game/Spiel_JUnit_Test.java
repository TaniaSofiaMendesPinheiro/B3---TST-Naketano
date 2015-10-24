package Game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Spiel_JUnit_Test {
	
	private Spiel spiel;
	
	@Before
	public void vorMethode(){
		System.out.println("@Before");
		spiel = new Spiel();
	}

	@Test
	public void test() {
		

	}

}
