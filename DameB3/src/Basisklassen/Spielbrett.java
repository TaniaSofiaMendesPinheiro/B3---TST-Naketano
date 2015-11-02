package Basisklassen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Spielbrett implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 5465100426783802281L;
		
	public Spielfeld[][] brett = new Spielfeld[12][12];


	public Spielbrett() {
		this.erstelleSpielbrett();
		setzDieFigurenAufsFeld();
	}

	 /**
	 * Methode wandelt ID in Index um
	 */
	 public int [] getIndexById(String id) {
	 int [] index = new int [2];
	 for (int i = 0; i < brett.length; i++) {
		 for (char j = 0; j < brett[i].length; j++) {
			 if (id.equals(id)) {
				 index[0] = i;
				 index[1] = j;
			 }
		 }
	 }
	 return index;
	 }

	/**
	 * generates my brett
	 */

	public void erstelleSpielbrett() {

		for (int i = 0; i < brett.length; i++) {
			for (char j = 0; j < brett[i].length; j++) {
				String ID = "" + (char) (j + 97) + (i + 1) + "";
				brett[i][j] = new Spielfeld(ID, (i + j) % 2 == 0);
			}
		}
	}

	/**
	 * nimmt 2 integer als x und y coordinate und returnt mit mein feld
	 * 
	 * @param posY
	 *          vertical
	 * @param posX
	 *          horizontal
	 * @return das feld als cooridinaten
	 */

	public Spielfeld gibMirDiePosition(int posY, int posX) {
		return brett[posY][posX];
	}
	
	public Spielfeld gibMirDiePosition(String ID) {
		int [] index = getIndexById(ID);
		return brett[index[0]][index[1]];
	}

	public void setzDieFigurenAufsFeld() {
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 12; y++) {
				if (brett[x][y].getFarbe() == FarbEnum.schwarz) {
					Spielfigur figurweiss = new Spielfigur(x, y);
					figurweiss.farbe = FarbEnum.weiss;
					brett[x][y].setSpielfigur(figurweiss);
				}
			}
		}

		for (int x = 7; x < 12; x++) {
			for (char y = 0; y < 12; y++) {
				if (brett[x][y].getFarbe() == FarbEnum.schwarz) {
					Spielfigur figurschwarz = new Spielfigur(x, y);
					figurschwarz.farbe = FarbEnum.schwarz;
					brett[x][y].setSpielfigur(figurschwarz);
				}
			}
		}
	}

	@Override
	public String toString() {
		String schachbrett = " ";
		for (int i = brett.length - 1; i >= 0; i--) {
			for (int j = 0; j < this.brett[i].length; j++) {
			}
			schachbrett += " \n ";
			for (int j = 0; j < this.brett[i].length; j++) {
				schachbrett += "| " + brett[i][j] + " |";
			}
			schachbrett += " \n ";
			for (int j = 0; j < this.brett[i].length; j++) {

			}
			schachbrett += " \n ";

		}

		return schachbrett;
	}

}
