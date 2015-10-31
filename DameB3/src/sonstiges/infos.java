package sonstiges;

public class infos {
	
	/**
	 * Du hast zwei Szenarien für die ID - ein Buchstabe + eine Zahl ODER ein Buchstabe + 
	 * zwei Zahlen (A1 vs A12, es gibt kein AZ1 und kein A123)
	 * Du kannst jetzt verschiedene Methoden schreiben, alle davon sollten im Spielbrett stehen, 
	 * da dieses ja die Spielfelder verwaltet. Inhaltlich tun die alle fast das selbe:
	 * 1. public int[] idToIndex(String ID) -> speichert die Index-Werte in ein Array mit 
	 * zwei felden (also quasi [ i | j ] )
	 * 
	 * 2. public Spielfeld getFieldByID(String ID) -> gibt das Spielfeld-Objekt mit der 
	 * übergebenen ID zurück 
	 * 
	 * Bei beiden Methoden (und du brauchst eigentlich nur eine davon, kannst dir 
	 * halt aussuchen welche du besser findest) hast du zwei Möglichkeiten sie zu implementieren:
	 * 
	 * 1. Du duchläufst das zweidimensionale Spielfeld-Array im Spielbrett bis du das Objekt 
	 * mit der übergebenen ID gefunden hast (id.equals(id)) und gibst dann entweder die 
	 * Index-Werte auf denen du dich gerade befindest oder halt das Objekt selbst zurück
	 * 
	 * 2. du Splittest den String, castest den Buchstaben-Anteil in Char und errechnest 
	 * dann mit -97 den Index, castest den Zahlen-Anteil in Int und errechnest mit -1 den 
	 * anderen Index und gibst diese Werte entweder zurück oder greifst mit diesen Werten 
	 * direkt aufs Array zu um das Spielfeld-Objekt an der Stelle zu bekommen
	 */

}
