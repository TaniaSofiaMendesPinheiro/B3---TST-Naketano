package Basisklassen;

import java.io.Serializable;

public class Spielbrett implements Serializable{
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
	protected Spielbrett[][]brett1;
	public Spielfigur[][] spielfigur;
	private Spielfigur [][] figur1;

	// private boolean istSchwarz = true;
	
	/**
	 * 
	 * @param rows number of rows(zeilen)
	 * @param cols number of cols (spalten)
	 */

	public Spielbrett(int rows, int cols) {
		spielfigur = new Spielfigur[rows][cols];
	}
	
	public Spielbrett(){
		this.erstelleSpielbrett();
	}
	
	/**
	 * number of colums
	 * @return
	 */
	
	public int getNumOfColumns(){
		return spielfigur[0].length;
	}
	
	/**
	 * number of rows
	 * @return
	 */
	
	public int getNumOfRows(){
		return spielfigur.length;
	}
	
	/**
	 * content of brett on a given position
	 * @param row rowindex from 0
	 * @param col columnindex from 0
	 * @return content of brett on a given position,
	 * 					null, if there is no figure
	 */
	
	public Spielfigur getContent(int row, int col){
		return spielfigur[row][col];
	}
	
	
	/**
	 * reserves a field with a figure
	 * this method does not looks, if the move is rigth
	 * @param row rowindex from 0
	 * @param col colindex from 0
	 * @param spielfigur the moving figure
	 * @return content, which figure was on that field bevore
	 */
	public Spielfigur setContent(int row, int col, Spielfigur spielfigur){
		Spielfigur result = figur1[row][col];
		figur1[row][col] = spielfigur;
		return result;
	}
	
	public Spielfeld getSpielfeld(String ID){
		return this.spielfeld;
	}
	
//	public String getSpielfeld(String ID){
//		return spielfeld.getID(ID);
//	}


	/**
	 * Create the field with the ID and colour
	 */

	public void erstelleSpielbrett() {
		for (int i = 0; i < brett.length; i++) {
			for (char j = 0; j < brett[i].length; j++) {
				String ID = "" + (char) (j + 97) + (i + 1) + "";
				brett[i][j] = new Spielfeld(ID, (i + j) % 2 == 0);

			}
		}

	}
	


	@Override
	public String toString() {
		String schachbrett = "";
		for (int i = brett.length - 1; i >= 0; i--) {
			for (int j = 0; j < brett[i].length; j++) {
				System.out.print(brett[i][j] + " ");
			}
			System.out.println();
		}
		return schachbrett;
	}
}
