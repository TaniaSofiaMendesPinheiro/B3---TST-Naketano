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
//	protected Spielbrett[][]brett1;
	
	public Spielbrett(){
		this.erstelleSpielbrett();
	}
	
	public int [] idToIndex(String ID){
		
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
	
//  @Override
//  public String toString() {
//      String test = "";
//      for (int i = 0; i < this.brett.length; i++) {
//          for (int j = 0; j < this.brett[i].length; j++) {
//              test += "-------";
//          }
//          test += "\n";
//          for (int j = 0; j < this.brett[i].length; j++) {
//              test += "| " + brett[i][j] + " |";
//          }
//          test += "\n";
//          for (int j = 0; j < this.brett[i].length; j++) {
//              test += "-------";
//          }
//          test += "\n";
//          System.out.println();
//					
//      }
//      return test;
//  } 


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
