package SpeichernUndLaden;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//Implementieren Sie das Interface iDatenzugriff in der Klasse DatenzugriffSerialisiert , bei dem ein Spiel mit seinem
//gesamten Zustand serialisiert gespeichert und geladen werden kann.

public class DatenzugriffSerialisiert implements iDatenzugriff {
	private ObjectInputStream ois;
	private ObjectOutputStream oos;

	public DatenzugriffSerialisiert() {

	}

//	@Override
//	public void speichern(Object object) throws IOException {
//		if (oos == null) {
//			throw new IOException("Stream to write on is not open!");
//		} else {
//			oos.writeObject(object);
//		}
//
//	}

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
	public void speichern(String pfad, String name, String typ) throws IOException {
		
	}
}
