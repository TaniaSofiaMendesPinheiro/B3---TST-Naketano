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
	private Spieler spielerliste[];
	private Spielbrett brett;
	private Spieler amZug;

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
			String linie;
			ArrayList<String> linien = new ArrayList<String>();
			ArrayList<Spielbrett> brett = new ArrayList<>();
			while ((linie = br.readLine()) != null){
				linien.add(linie);
				String[] readedAttributes = new String[3];
				for ( int i = 0; i < readedAttributes.length; i++){
					readedAttributes = linien.get(0).split(";");
				}
				if(readedAttributes[0] == null){
					return brett;
				}else{
					String id = readedAttributes[0];
					String startID = readedAttributes[1];
					String zielID = readedAttributes[2];
//					String spielfeld = readedAttributes[3];
					Spiel s1 = new Spiel();
					Spielbrett brettle = new Spielbrett();
					brettle.getIndexById(id);
					brettle.gibMirDiePosition(zielID);
					brettle.gibMirDiePosition(startID);
					brettle.gibMirDiePosition(zielID).getSpielfigur();
					for ( int i = 0; i < 12; i++){
						for ( int j = 0; j < 12; j++){
							brettle.gibMirDiePosition(i, j).getSpielfigur();
						}
					}
					brett.add(brettle);
				}
				linien.remove(linie);
			} 
			return brett;
	}

	@Override
	public void speichern(String pfad, String name, String inhalt) throws IOException {
	
		BufferedWriter out = null;
//		try{
//			out = new BufferedWriter(new OutputStreamWriter(inhalt.writeInhalt(".savecsv")));
//			
//		} catch (Exception e){
//			System.out.println("");
//		}
		
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

