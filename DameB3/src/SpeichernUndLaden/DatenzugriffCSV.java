package SpeichernUndLaden;

import java.io.BufferedReader;import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Properties;

import Basisklassen.Spielbrett;
import Basisklassen.Spieler;
import Basisklassen.Spielfigur;
import Game.Spiel;


//Implementieren Sie das Interface iDatenzugriff in der Klasse DatenzugriffCSV,
//bei dem ein Spiel mit seinem gesamten Zustand als CSV - Datei gespeichert und geladen werden kann

public class DatenzugriffCSV implements iDatenzugriff {

	private BufferedReader br;
	private BufferedWriter bw;
	
	@Override
	public void open(Properties properties) throws IOException {
		String fileName = properties.getProperty("Filename");
		
		if(fileName == null) {
			throw new IOException("Filename not defined!");
		}
		
		if("s".equals(properties.getProperty("Mode"))) {		// save
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
		} else if("l".equals(properties.getProperty("Mode"))) {	// load
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
			bw.write(daten + ";");
		}		
	}

	@Override
	public Object read() throws IOException {
		String linie;
		ArrayList<String> linien = new ArrayList<String>();
		ArrayList<Spieler> spielers = new ArrayList<>();
		ArrayList<Spielbrett> brettle = new ArrayList<>();
		while((linie = br.readLine()) != null) {
			linien.add(linie);
			String[] readedAttributes = new String[7];			
			for(int i = 0; i < readedAttributes.length; i++) {
    			readedAttributes = linien.get(0).split(";");
    		}
			
			if(readedAttributes[0] == null) {
    			return spielers;
//    			return brettle;
    		} else {
    			String name = readedAttributes[0];
    			String farbe = readedAttributes[1];
    			String iD = readedAttributes[2];
    			boolean istDame = Boolean.parseBoolean(readedAttributes[3]);
    			String KI = readedAttributes[4];
    			boolean weiss = Boolean.parseBoolean(readedAttributes[5]);
    			Spielbrett brett = new Spielbrett();
    			Spieler spieler = new Spieler();
    			spieler.setFarbEnum(new FarbEnum());
    			spieler.setName(name);
    			brett.setzDieFigurenAufsFeld();
 
    			
    			brettle.add(spielers);
    		}
			linien.remove(linie);
    		}
			return spielers;
			return brettle;
//    			String street = readedAttributes[3];
//    			int houseNumber = Integer.parseInt(readedAttributes[4]);
//    			String place = readedAttributes[5];
//    			String postalCode = readedAttributes[6];
//    			Spiel spiel = new Spiel();
//    			Spieler spieler = new Spieler();
//    			student.setStudentNumber(studentNumber);
//    			student.setName(new Name(preName,surName));
//    			student.setAddress(new Address(street, houseNumber, place, postalCode));
//    			students.add(student);
//    		}
//			linien.remove(linie);
//		}			
//		return students;
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



