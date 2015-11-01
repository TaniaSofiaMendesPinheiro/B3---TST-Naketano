import Basisklassen.Spielfeld;


public class brett2 {
	
	private Spielfeld[][] brett;
	private int posX = 12;
	private int posY = 12;

	
	public brett2(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
		this.erstelleBrett();
		
	}


	private void erstelleBrett() {
		this.brett = new Spielfeld[this.posX][this.posY];
		for (int i = 0; i < brett.length; i++) {
			for (char j = 0; j < brett[i].length; j++) {
				String ID = "" + (char) (j + 97) + (i + 1) + "";
				brett[i][j] = new Spielfeld();
			}
		}
	}


	public int getPosX() {
		return this.posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return this.posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}
}
