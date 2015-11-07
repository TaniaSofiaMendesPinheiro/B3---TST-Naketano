package SpeichernUndLaden;

import java.io.IOException;
import java.util.Properties;

/**
 * here are methods which save the data
 * in csv or serial
 * @author informatik
 *
 */

public interface iDatenzugriff {
	
	/**
	 * This method opens a file.
	 * @param properties The passed properties.
	 * @throws IOException is thrown if the file can't be open.
	 * @since 1.0.0
	 */
	public void open(Properties properties) throws IOException;
	
	/**
	 * This method writes the object.
	 * @param object The passed object.
	 * @throws IOException is thrown if the object can't be written or the file isn't open.
	 * @since 1.0.0
	 */
	public void write(Object object) throws IOException;
	
	/**
	 * Reads the objects in a file.
	 * @return the loaded objects.
	 * @throws IOException is thrown if the objects can't be read or the file isn't open.
	 */
	public Object read() throws IOException;
	
	/**
	 * This method close a file.
	 * @param object The passed object.
	 * @throws IOException is thrown if the file isn't open.
	 * @since 1.0.0
	 */
	public void close(Object object) throws IOException;
}


