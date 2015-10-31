package SpeichernUndLaden;

//Implementieren Sie das Interface iDatenzugriff in der Klasse DatenzugriffSerialisiert , bei dem ein Spiel mit seinem
//gesamten Zustand serialisiert gespeichert und geladen werden kann.

import java.io.Serializable;

public class DatenzugriffSerialisiert implements Serializable, iDatenzugriff{

	/**
	 * default serialnr.
	 */
	private static final long serialVersionUID = 1L;
	

	
public DatenzugriffSerialisiert(){
	
}

//	
//	/**
//	 * method for SpielLaden()
//	 * saved positions and moves are on screen
//	 */
//	@Override
//	public void spielLaden() {
//	
//	}
//	
//	/**
//	 * this method saves the game from the moment you save
//	 */
//
//	@Override
//	public void spielSpeichern() {
//	
//	}
//
//	/**
//	 * this method saves the positions of your figures, if you want to go out for a while
//	 * 
//	 */
//	@Override
//	public void speicherPositionenVonFigur() {
//	
//	}

	@Override
	public void saveSerialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object loadSerialize() {
		// TODO Auto-generated method stub
		return null;
	}
	

	}
	
