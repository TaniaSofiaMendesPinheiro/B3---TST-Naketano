package BasisklassenJUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Basisklassen.FarbEnum;
import Basisklassen.Spieler;

public class SpielerTest {
	
	private Spieler spieler;
		
	@Before
	public void vorMethode(){
		System.out.println("@Before");
		spieler = new Spieler();
	}
	
	
	@Test (expected = RuntimeException.class)
	public void testeFarbenum(){
		spieler.setFarbenum(null);
	}
	
	@Test (expected = RuntimeException.class)
	public void testeName(){
		spieler.setName(null);
	}
	
}
