package SpeichernUndLaden;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * here are methods which save the data
 * in csv or serial
 * @author informatik
 *
 */

public interface iDatenzugriff {
	
	/**
	 * This method writes the object.
	 * @param object The passed object.
	 * @throws IOException is thrown if the object can't be written or the file isn't open.
	 * @since 1.0.0
	 */
	public void speichern(String pfad, String name, String inhalt) throws IOException;
	
	/**
	 * Reads the objects in a file.
	 * @return the loaded objects.
	 * @throws IOException is thrown if the objects can't be read or the file isn't open.
	 */
	public Object laden(BufferedReader reader) throws IOException;
	
	
}


