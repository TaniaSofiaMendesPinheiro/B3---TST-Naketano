package Basisklassen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

	private List<Spielfigur> spielfiguren;
	public Spielfeld spielfeld;
	public Spielfeld[][] brett = new Spielfeld[12][12];
//	protected Spielbrett[][]brett1;
	private boolean weissAmZug;
	private boolean weissGewonnen;
	private boolean spielIstZuEnde;
	
	
	public Spielbrett(){
		this.erstelleSpielbrett();
		spielfiguren = new ArrayList<Spielfigur>();
		setzeFigurenAufFeld();
	}
	
	
	private void setzeFigurenAufFeld() {
		
		for(int y = 0; y < 5; y++){
			for ( int x = 0 ; x < 12; x++){
				if ( (x+y) % 2 == 0){
					EinfacheFigur ef = new EinfacheFigur(x,y);
					spielfiguren.add(ef);
				}
			}
		}
				for ( int y = 8 ; y < 12; y++){
					for (int x = 0; x < 12; x++ ){
						if ( (x+y)% 2 == 0){
						EinfacheFigur ef = new EinfacheFigur( x,y);
						ef.setSchwarzenStein();
						spielfiguren.add(ef);
				}
			}
		}
				weissAmZug = true;
		
	}

		
	public Spielfeld getSpielfeld(String ID){
		return this.spielfeld;
	}
	
	/**
	 * change the person who is next
	 */

	public void wechselDenDerAmZug(){
		if ( weissAmZug){
			weissAmZug = false;
		}else{
			weissAmZug = true;
		}
	}
	
	public List<Spielfigur> getAlleFigurenVomBrett(){
		return spielfiguren;
	}
	
	public boolean istWeissGeradeDran(){
		return weissAmZug;
	}
	
	
	/**
	 * my figur gets her figures back on position x and y
	 * @param x
	 * @param y
	 * @return
	 */
	public Spielfigur getFigur(int x, int y){
		for(Spielfigur figur: spielfiguren){
			if ( figur.getPosX() == x && figur.getPosY() == y){
				return figur;
			}
		}
		return null;
	}
	
	/**
	 * gets back the winner in white
	 * sets our player in white to winner
	 * @param gewonnen
	 */
	
	public void setWeissGewinner(boolean gewonnen){
		weissGewonnen = gewonnen;
	}
	
	/**
	 * is our player in white winner?
	 * @return
	 */
	public boolean istWeissGewinner(){
		return weissGewonnen;
	}
	
	/**
	 * game ends
	 */
	
	public void spielIstZuEnde(){
		spielIstZuEnde = true;
	}
	
	public boolean istDasSpielZuEnde(){
		return spielIstZuEnde;
	}
	/**
	 * Create the field with the ID and colour
	 */

	public void erstelleSpielbrett() {
		for (int y = 0; y < brett.length; y++) {
			for (char x = 0; x < brett[y].length; x++) {
				String ID = "" + (char) (x + 97) + (y + 1) + "";
				brett[y][x] = new Spielfeld(ID, (y + x) % 2 == 0);

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
		for (int y = brett.length - 1; y >= 0; y--) {
			for (int x = 0; x < brett[y].length; x++) {
				System.out.print(brett[y][x] + " ");
			}
			System.out.println();
		}
		return schachbrett;
	}
}
