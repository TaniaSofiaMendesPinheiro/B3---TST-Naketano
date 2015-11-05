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

	
	@Override
	public Object laden() throws IOException {
		String linie;
		ArrayList<String> linien = new ArrayList<String>();
		ArrayList<Spielbrett> brett = new ArrayList<>();
		while ((linie = br.readLine()) != null) {
			linien.add(linie);
			String[] readedAttributes = new String[3];
			for (int i = 0; i < readedAttributes.length; i++) {
				readedAttributes = linien.get(0).split(";");
			}
			if (readedAttributes[0] == null) {
				return brett;
			} else {
				String id = readedAttributes[0];
				String startID = readedAttributes[1];
				String zielID = readedAttributes[2];
				// String spielfeld = readedAttributes[3];
				Spiel s1 = new Spiel();
				Spielbrett brettle = new Spielbrett();
				brettle.getIndexById(id);
				brettle.gibMirDiePosition(zielID);
				brettle.gibMirDiePosition(startID);
				brettle.gibMirDiePosition(zielID).getSpielfigur();
				for (int i = 0; i < 12; i++) {
					for (int j = 0; j < 12; j++) {
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
		String daten = pfad + name + inhalt;
		if (daten.equals("")) {
			bw.write("\n");
		} else {
			bw.write(daten + ";");
		}

	}
}



