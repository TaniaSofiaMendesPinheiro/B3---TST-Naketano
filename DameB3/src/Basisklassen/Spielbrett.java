package Basisklassen;

public class Spielbrett {
	/**
	 * @author informatik tobi,tania,sina,alex
	 * @parm: Connection with Spielfeld Connection with FarbEnum Created Array
	 *        Brett with height and width of 12 Created boolean istSchwarz for set
	 *        colour of the field
	 */

	private Spielfeld spielfeld;
	private Spielfeld[][] Brett = new Spielfeld[12][12];
//	private boolean istSchwarz = true;

	public Spielbrett() {
		this.erstelleSpielbrett();
	}

	/**
	 * Create the field with the ID and colour
	 */
	public void erstelleSpielbrett() {
		for (int i = 0; i < Brett.length; i++) {
			for (char j = 0; j < Brett[i].length; j++) {
				String ID = "" + (char) (j + 97) + (i + 1) + "";
				Brett[i][j] = new Spielfeld(ID, (i + j) % 2 == 0);

//				System.out.print(" " + ID + "/" + (i + j) % 2 == 0 + " ");
			}
//			System.out.println("");
		}
	
		//return istSchwarz;
	}
	
	@Override
	public String toString(){
		String test = "";
		for(int i = Brett.length-1; i >= 0; i--){
			for(int j = 0; j < Brett[i].length; j++){
				System.out.print(Brett[i][j]+" ");
			}
			System.out.println();
		}
		return test;
	}
}
