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

	private ArrayList<Spielfigur> spielfiguren;
	public Spielfeld spielfeld;
	public Spielfeld[][] brett = new Spielfeld[12][12];
//	protected Spielbrett[][]brett1;
	private boolean weissAmZug;
	private boolean weissGewonnen;
	private boolean spielIstZuEnde;
	
	
	public Spielbrett(){
		this.erstelleSpielbrett();
//		spielfiguren = new ArrayList<Spielfigur>();
//		this.setzeFigurenAufFeld();
	}
	
	
	public void setzeFigurenAufFeld() {
		
		/**
		 * set white figures on field
		 */
		
		for(int y = 0; y < 5; y++){
			for ( int x = 0 ; x < 12; x++){
				if ( (x+y) % 2 == 0){
					EinfacheFigur ef = new EinfacheFigur(x,y);
					spielfiguren.add(ef);
				}
			}
		}
		
		/**
		 * set black figures on field
		 */
				for ( int y = 8 ; y < 12; y++){
					for (int x = 0; x < 12; x++ ){
						if (spielfeld.getFarbe().schwarz == FarbEnum.schwarz){
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
	
	public Spielfeld getFeld(int x, int y){
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
//	/**
//	 * Create the field with the ID and colour
//	 */
//
//	public void erstelleSpielbrett() {
//		for (int i = 0; i < brett.length; i++) {
//			for (char j = 0; j < brett[i].length; j++) {
//				int x  = (char) (i + 97) ;
//						int y = (j + 1);
//				brett[i][j] = new Spielfeld( x +  y + (y + x) % 2 == 0);
//
//			}
//		}
//
//	}
	

	
	/**
	 * Methode wandelt ID in Index um
	 */
	public int getIndexById(String id){
		int posX = 0;
		int posY = 0;
		for (int i = 0; i < brett.length; i++) {
			for (char j = 0; j < brett[i].length; j++) {
				if(brett[i][j].equals(id)){
					posX = i;
					posY = j;
				}
			}
		}
		return posX + posY;
	}
	
	
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
