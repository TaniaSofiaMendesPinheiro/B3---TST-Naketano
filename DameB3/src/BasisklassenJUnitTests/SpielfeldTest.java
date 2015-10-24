package BasisklassenJUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Basisklassen.Spielfeld;

public class SpielfeldTest {

	private Spielfeld spielfeld;

	@Before
	public void vorMethode() {
		System.out.println("@Before");
		spielfeld = new Spielfeld();
	}

	@Test(expected = RuntimeException.class)
	public void testeGetID() {
		spielfeld.setID("A115");
		spielfeld.setID("A");

	}
}
