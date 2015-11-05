package SpeichernUndLaden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//Implementieren Sie das Interface iDatenzugriff in der Klasse DatenzugriffSER , bei dem ein Spiel mit seinem
//gesamten Zustand serialisiert gespeichert und geladen werden kann.

public class DatenzugriffSER implements iDatenzugriff {
	private ObjectInputStream ois;
	private ObjectOutputStream oos;


	@Override
	public Object laden() throws IOException {
		if (ois == null) {
			throw new IOException("Stream to read is not open!");
		}

		try {
			Object object = ois.readObject();
			return object;
			
		} catch (ClassNotFoundException error) {
			throw new IOException("Could not deserialize!");
		}
	}

	@Override
	public void speichern(String pfad, String name, String inhalt) throws IOException {
		
		if ( oos == null){
			throw new IOException("Stream to write on is not open!");
		} else{
			oos.writeObject(inhalt); 
		}
		
	}
}
