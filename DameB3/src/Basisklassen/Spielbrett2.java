package Basisklassen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Spielbrett2 implements Serializable {

	/**
		 * 
		 */
	private static final long serialVersionUID = 5465100426783802281L;
	/**
	 * @author B3-TST-Naketano
	 * @parm: Connection with Spielfeld Connection with FarbEnum Created Array
	 *        Brett with height and width of 12 Created boolean istSchwarz for set
	 *        colour of the field
	 */

	public Spielfeld spielfeld;
	public Spielfeld[][] brett = new Spielfeld[12][12];
	// protected Spielbrett[][]brett1;
	private boolean weissAmZug;
	private boolean weissGewonnen;
	private boolean spielIstZuEnde;

	public Spielbrett2() {
		this.erstelleSpielbrett();
		setzDieFigurenAufsFeld();
	}

	/**
	 * change the person who is next
	 */

	public void wechseltDenDerAmZug() {
		if (weissAmZug) {
			weissAmZug = false;
		} else {
			weissAmZug = true;
		}
	}

	public boolean istWeissGeradeDran() {
		return weissAmZug;
	}

	/**
	 * my figur gets her figures back on position x and y
	 * 
	 * @param x
	 * @param y
	 * @return
	 */

	/**
	 * gets back the winner in white sets our player in white to winner
	 * 
	 * @param gewonnen
	 */

	public void setWeissGewinner(boolean gewonnen) {
		weissGewonnen = gewonnen;
	}

	/**
	 * is our player in white winner?
	 * 
	 * @return
	 */
	public boolean istWeissGewinner() {
		return weissGewonnen;
	}

	/**
	 * game ends
	 */

	public void spielIstZuEnde() {
		spielIstZuEnde = true;
	}

	public boolean istDasSpielZuEnde() {
		return spielIstZuEnde;
	}

	 /**
	 * Methode wandelt ID in Index um
	 */
	 public int [] getIndexById(String id) {
	 for (int i = 0; i < brett.length; i++) {
	 for (char j = 0; j < brett[i].length; j++) {
	 if (id.equals(id)) {
	 posX = i;
	 posY = j;
	 }
	 }
	 }
	 return posX + posY;
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

	public void setzDieFigurenAufsFeld() {
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < 12; y++) {
				if (brett[x][y].getFarbe() == FarbEnum.schwarz) {
					Spielfigur figurweiss = new Spielfigur(x, y);
					brett[x][y].setSpielfigur(figurweiss);
				}
			}
		}

		for (int x = 7; x < 12; x++) {
			for (char y = 0; y < 12; y++) {
				if (brett[x][y].getFarbe() == FarbEnum.schwarz) {
					Spielfigur figurschwarz = new Spielfigur(x, y);
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
