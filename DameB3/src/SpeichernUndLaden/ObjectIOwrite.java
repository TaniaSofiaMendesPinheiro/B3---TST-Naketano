package SpeichernUndLaden;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectIOwrite {
	
	public static void main (String [] args) throws IOException{
		ObjectOutputStream oos = null;
		
		
		try{
			
			
			oos.new ObjectOutputStream (new FileOutputStream("out.ser"));
//				oos.writeObject();
//				syso()
		}
		catch( FileNotFoundException e){
			System.err.println("Konnte 'out.ser' nicht erzeugen.");
		}
		catch (IOException e){
			System.err.println("Fehler bei der Ein-/Ausgabe " + e);
		}
		
		finally{
			try{
				oos.close();
			}
			catch (Exception e){
				System.err.println("Fehler beim Schließen der Datei.");
			}
		}
		}
	}


