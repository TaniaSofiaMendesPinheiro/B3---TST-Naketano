package Basisklassen;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import SpeichernUndLaden.iDatenzugriff;

//Implementieren Sie das Interface iDatenzugriff in der Klasse DatenzugriffSER , bei dem ein Spiel mit seinem
//gesamten Zustand serialisiert gespeichert und geladen werden kann.

public class DatenzugriffSER implements iDatenzugriff {
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
		
	@Override
	public void open(Properties properties) throws IOException {
		String dateiName = properties.getProperty("Filename");

		if (dateiName == null) {
			throw new IOException("Filename not defined!");
		} else {
			if ("s".equals(properties.getProperty("Mode"))) {	// s = save
				oos = new ObjectOutputStream(new FileOutputStream(dateiName));
			} else if ("l".equals(properties.getProperty("Mode"))) {		// l = load
				ois = new ObjectInputStream(new FileInputStream(dateiName));
			} else {
				throw new IOException("Mode not defined");
			}
		}
	}

	@Override
	public void write(Object object) throws IOException {
		if (oos == null) {
			throw new IOException("Stream to write not is not open!");
		} else {
			FileOutputStream stream = new FileOutputStream ("das Spiel.ser");
			oos = new ObjectOutputStream(brett.)
			oos.writeObject();
		}
	}

	@Override
	public Object read() throws IOException {
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
	public void close(Object object) throws IOException {
		if (ois != null) {
			ois.close();
			ois = null;
		} else if (oos != null) {
			oos.close();
			oos = null;
		}
	}
}
