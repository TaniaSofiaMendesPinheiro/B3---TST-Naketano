package Basisklassen;

public class Spielbrett {
	/**
	 * @author B3-TST-Naketano
	 * @parm: Connection with Spielfeld Connection with FarbEnum Created Array
	 *        Brett with height and width of 12 Created boolean istSchwarz for set
	 *        colour of the field
	 */

	public Spielfeld spielfeld;
	public Spielfeld[][] brett = new Spielfeld[12][12];

	// private boolean istSchwarz = true;

	public Spielbrett() {
		this.erstelleSpielbrett();
	}

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
	
	public void setzeSteine(){
		erstelleSpielbrett();
	
		
		
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
