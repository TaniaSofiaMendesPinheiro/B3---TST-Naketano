package Game;

public interface iCSV {
	
	/**
	 * saves data in csv
	 * @param fileName the passed fileName
	 */
	
	public void saveCSV(String fileName);
	
	/**
	 * load data in csv
	 * @param fileName the passed fileName
	 * @return loaded objects
	 */
	
	public Object loadCSV(String fileName);

}
