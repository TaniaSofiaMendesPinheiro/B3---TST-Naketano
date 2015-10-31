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

import Basisklassen.FarbEnum;
import Basisklassen.Spieler;
import Basisklassen.Spielfeld;
import Basisklassen.Spielbrett;
import Basisklassen.Spielfigur;
import Game.Spiel;

//Implementieren Sie das Interface iDatenzugriff in der Klasse DatenzugriffCSV,
//bei dem ein Spiel mit seinem gesamten Zustand als CSV - Datei gespeichert und geladen werden kann

public class DatenzugriffCSV implements iDatenzugriff{
	
	private BufferedReader br;
	private BufferedWriter bw;

	@Override
	public void open(Properties properties) throws IOException {
		
		String fileName = properties.getProperty("FileName");
		
		if ( fileName == null){
			throw new IOException("fileName not defined");
		}
		if("s".equals(properties.getProperty("Mode"))) {
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
		} else if("l".equals(properties.getProperty("Mode"))) {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		} else {
			throw new IOException("Mode not defined!");
		}	

	}

	@Override
	public void write(Object object) throws IOException {
		String daten = (String)object;
		if(daten.equals("#")) {
			bw.write("\n");
		} else {
			bw.write(daten + ",");
		}
		
	}

	@Override
	public Object read() throws IOException {
		String linie;
		ArrayList<String> linien = new ArrayList<String>();
		ArrayList<Spieler> spieler1 = new ArrayList<>();
		while((linie = br.readLine()) != null) {
			linien.add(linie);
			String[] readedAttributes = new String[2];			
			for(int i = 0; i < readedAttributes.length; i++) {
    			readedAttributes = linien.get(0).split(",");
    		}
			
			if(readedAttributes[0] == null) {
    			return spieler1;
    		} else {
    			String farbe = readedAttributes[0];
    			String name = readedAttributes[1];
    			Spiel s1 = new Spiel();
    			Spielfigur figur1 = new Spielfigur();
    			Spielfigur figur2 = new Spielfigur();
    			figur1.setSpielfeld(new Spielfeld());	// spielfigur auf feld
    			figur1.setID(new String());			// spielfigur auf id
    		}
			linien.remove(linie);
		}			
		return s1;
	}

	@Override
	public void close(Object object) throws IOException {
		if(bw != null) {
			bw.close();
			bw = null;
		}
		
		if(br != null) {
			br.close();
			br = null;
		}
	}
		
	}

}
