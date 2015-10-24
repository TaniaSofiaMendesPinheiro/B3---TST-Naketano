package BasisklassenJUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Basisklassen.Spieler;
import Basisklassen.Spielfigur;

public class SpielfigurTest {

	private Spielfigur spielfigur;
	
	@Before
	public void vorMethode(){
		System.out.println("@Before");
		spielfigur = new Spielfigur();
	}

}
