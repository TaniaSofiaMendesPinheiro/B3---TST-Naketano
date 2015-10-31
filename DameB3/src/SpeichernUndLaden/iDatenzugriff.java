package SpeichernUndLaden;

//Definieren Sie ein allgemein gültiges Datenzugriffsinterface iDatenzugriff
//zum Laden und zum Speichern von Daten.

/**
 * this interface contains the methods to save and load serialized data
 * @author B3---TST-Naketano
 *
 */

public interface iDatenzugriff {
	
	
	
	public void saveSerialize();
	
	public Object loadSerialize();
	
	
	


}
