package SpeichernUndLaden;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Properties;

import Basisklassen.Spielbrett;
import Basisklassen.FarbEnum;
import Basisklassen.Spieler;
import Basisklassen.Spielfeld;
import Basisklassen.Spielfigur;
import Game.Spiel;

//Implementieren Sie das Interface iDatenzugriff in der Klasse DatenzugriffCSV,
//bei dem ein Spiel mit seinem gesamten Zustand als CSV - Datei gespeichert und geladen werden kann

public class DatenzugriffCSV implements iDatenzugriff {

	private BufferedReader br;
	private BufferedWriter bw;

	// @Override
	// public void open(Properties properties) throws IOException {
	//
	// String fileName = properties.getProperty("FileName");
	//
	// if ( fileName == null){
	// throw new IOException("fileName not defined");
	// }
	// if("s".equals(properties.getProperty("Mode"))) {
	// bw = new BufferedWriter(new OutputStreamWriter(new
	// FileOutputStream(fileName)));
	// } else if("l".equals(properties.getProperty("Mode"))) {
	// br = new BufferedReader(new InputStreamReader(new
	// FileInputStream(fileName)));
	// } else {
	// throw new IOException("Mode not defined!");
	// }
	//
	// }

	// @Override
	// public void speichern(Object object) throws IOException {
	// if (object instanceof String){
	// String daten = (String)object;
	// bw.write(daten);
	// }
	// }

	@Override
	public Object laden(BufferedReader reader) throws IOException {
		try {
			String line = reader.readLine();
			String[] fields = line.split(";");
			spielerliste = fields[0];
			spielfeld = fields[1];
		} catch (NullPointerException e) {
			throw new IOException("Unerwartetes Dateiende");
		} catch (NumberFormatException e) {
			throw new IOException("Falsches Elementformat");
		} catch (IndexOutOfBoundsException e) {
			throw new IOException("Zu wenig Dateielemente");
		}
	}

	@Override
	public void speichern(String pfad, String name, String typ) throws IOException {
//
//		iDatenzugriff x = new DatenzugriffCSV();
//		x.speichern(pfad + name + typ);
	}

}

// String linie;
// ArrayList<String> linien = new ArrayList<String>();
// ArrayList<Spielfigur> figuren = new ArrayList<>();
// while((linie = br.readLine()) != null) {
// linien.add(linie);
// String[] readedAttributes = new String[3];
// for(int i = 0; i < readedAttributes.length; i++) {
// readedAttributes = linien.get(0).split(",");
// }
//
// if(readedAttributes[0] == null) {
// return figuren;
// } else {
// String farbe = readedAttributes[0];
// String name = readedAttributes[1];
// String ID = readedAttributes[2];
// Spiel s1 = new Spiel();
// Spielfigur figur1 = new Spielfigur();
// figur1.getFarbEnum();
// figuren.add(figur1);
//
// }
// linien.remove(linie);
// }
// return figuren;

