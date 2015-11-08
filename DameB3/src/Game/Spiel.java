package Game;

import java.io.Serializable;

import SpeichernUndLaden.iCSV;
import SpeichernUndLaden.iSerialize;
import Basisklassen.Spielbrett;
import Basisklassen.Spieler;
import Basisklassen.Spielfigur;
import Basisklassen.FarbEnum;

//Implementieren Sie die Klasse Spiel testgetrieben unter Verwendung von JUnit mit nicht
//trivialen JUnit - Tests. Jedes Spiel kennt ein Spielbrett, 2 Spieler und den Spieler,
//der gerade am Zug ist. Das Spiel implementiert ein Interface iBediener, welches Sie definieren müssen. Alle
//Interaktionen der Benutzer müssen über dieses Interface statt finden.

/**
 * 
 * @author B3-TST-Naketano
 *
 */

public class Spiel implements iBediener, iCSV, iSerialize, Serializable {

	private static final long serialVersionUID = -2772918960157309026L;
	private Spielbrett brett;
	private Spieler[] spielerliste;
	private Spieler amZug;
	private boolean gamestarted;
	private Spielfigur figur;

	public Spiel() {
		this.brett = new Spielbrett();
		spielerliste = new Spieler[2];
		gamestarted = false;
	}

	public void spielen() {

	}

	/**
	 * Am Ende der Runde ist der andere Spieler an der Reihe spieler an der stelle
	 * 0 ist immer am zug, deswegen wechselt nach jeder runde die position im
	 * array
	 */

	public void zugEnde() {

		// hat gepustet?

		Spieler wechseln = spielerliste[0];
		spielerliste[0] = spielerliste[1];
		spielerliste[1] = wechseln;
		amZug = spielerliste[0];
		System.out.println(gibMirCSV());
		System.out.println(amZug + " ist jetzt am Zug.");

		// kann pusten?
		// speichert feld + figur in liste, die schlagen können zu beginn des zuges
	}

	@Override
	public void spielBeenden() {

	}

	@Override
	public void neuesSpiel() {
		try {
			if (spielerliste[0] != null && spielerliste[1] == null) {
				throw new RuntimeException("Das ist kein gültiges Spiel. Für dieses Spiel braucht man 2 Spieler!");
			} else if (spielerliste[0].getFarbEnum() == FarbEnum.weiss) {
				amZug = spielerliste[0];
			} else {
				Spieler wechseln = spielerliste[0];
				spielerliste[0] = spielerliste[1];
				spielerliste[1] = wechseln;
				amZug = spielerliste[0];
			}
			gamestarted = true; // boolean flag
			this.spielen();
			System.out.println(amZug + " beginnt.");
		} catch (RuntimeException er) {
			System.err.println("Das ist kein gültiges Spiel. Für dieses Spiel braucht man 2 Spieler!");
		}
	}

	@Override
	public void spielerHinzufügen(String name, String farbe, boolean KI) {
		if (KI == false) {
			if (spielerliste[0] == null) {
				switch (farbe) {
				case "weiss":
					spielerliste[0] = new Spieler(name, FarbEnum.weiss, false, this);
					System.out.println("Hallo " + spielerliste[0].getName() + ", du bist weiss");
					break;
				case "schwarz":
					spielerliste[0] = new Spieler(name, FarbEnum.schwarz, false, this);
					System.out.println("Hallo " + spielerliste[0].getName() + ", du bist schwarz");
					break;
				default:
					System.out.println("Wähle schwarz oder weiss");
				}
			} else if (spielerliste[1] == null) {
				switch (farbe) {
				case "weiss":
					if (spielerliste[0].getFarbEnum() == FarbEnum.schwarz) {
						spielerliste[1] = new Spieler(name, FarbEnum.weiss, false, this);
						System.out.println("Hallo " + spielerliste[1].getName() + ", du bist weiss");

					} else {
						System.err.println("Es gibt schon einen weißen Spieler.");
					}
					break;
				case "schwarz":
					if (spielerliste[0].getFarbEnum() == FarbEnum.weiss) {
						spielerliste[1] = new Spieler(name, FarbEnum.schwarz, false, this);
						System.out.println("Hallo " + spielerliste[1].getName() + ", du bist schwarz");
					} else {
						System.err.println("Es gibt schon einen schwarzen Spieler.");
					}
					break;
				default:
					System.out.println("Wähle schwarz oder weiss");
				}

			} else {

				throw new RuntimeException("Da ging was schief.");
			}

			// funktioniert, wenn schwarz und weiss keine KI
		} else if (KI == true) {
			if (spielerliste[0] == null) {
				switch (farbe) {
				case "weiss":
					spielerliste[0] = new Spieler(name, FarbEnum.weiss, false, this);
					System.out.println("Hallo " + spielerliste[0].getName() + ", du bist weiss");
					break;
				case "schwarz":
					spielerliste[0] = new Spieler(name, FarbEnum.schwarz, false, this);
					System.out.println("Hallo " + spielerliste[0].getName() + ", du bist schwarz");
					break;
				default:
					System.out.println("Wähle schwarz oder weiss");
				}
			} else if (spielerliste[1] == null) {
				switch (farbe) {
				case "weiss":
					if (spielerliste[0].getFarbEnum() == FarbEnum.schwarz) {
						spielerliste[1] = new Spieler(name, FarbEnum.weiss, false, this);
						System.out.println("Hallo " + spielerliste[1].getName() + ", du bist weiss");

					} else {
						System.err.println("Es gibt schon einen weißen Spieler.");
					}
					break;
				case "schwarz":
					if (spielerliste[0].getFarbEnum() == FarbEnum.weiss) {
						spielerliste[1] = new Spieler(name, FarbEnum.schwarz, false, this);
						System.out.println("Hallo " + spielerliste[1].getName() + ", du bist schwarz");
					} else {
						System.err.println("Es gibt schon einen schwarzen Spieler.");
					}
					break;
				}
			} else {
				if (spielerliste[0] == null) {
					switch (farbe) {
					case "weiss":
						spielerliste[0] = new Spieler(name, FarbEnum.weiss, true, this);
						System.out.println("Hallo " + spielerliste[0].getName() + ", du bist weiss");
						break;
					case "schwarz":
						spielerliste[0] = new Spieler(name, FarbEnum.schwarz, true, this);
						System.out.println("Hallo " + spielerliste[0].getName() + ", du bist schwarz");
						break;
					default:
						System.out.println("Wähle schwarz oder weiss");
					}
				} else if (spielerliste[1] == null) {
					switch (farbe) {
					case "weiss":
						if (spielerliste[0].getFarbEnum() == FarbEnum.schwarz) {
							spielerliste[1] = new Spieler(name, FarbEnum.weiss, true, this);
							System.out.println("Hallo " + spielerliste[1].getName() + ", du bist weiss");

						} else {
							System.err.println("Es gibt schon einen weißen Spieler.");
						}
						break;
					case "schwarz":
						if (spielerliste[0].getFarbEnum() == FarbEnum.weiss) {
							spielerliste[1] = new Spieler(name, FarbEnum.schwarz, false, this);
							System.out.println("Hallo " + spielerliste[1].getName() + ", du bist schwarz");
						} else {
							System.err.println("Es gibt schon einen schwarzen Spieler.");
						}
						break;
					}
				} else {
					if (spielerliste[0] == null) {
						switch (farbe) {
						case "weiss":
							spielerliste[0] = new Spieler(name, FarbEnum.weiss, false, this);
							System.out.println("Hallo " + spielerliste[0].getName() + ", du bist weiss");
							break;
						case "schwarz":
							spielerliste[0] = new Spieler(name, FarbEnum.schwarz, true, this);
							System.out.println("Hallo " + spielerliste[0].getName() + ", du bist schwarz");
							break;
						default:
							System.out.println("Wähle schwarz oder weiss");
						}
					} else if (spielerliste[1] == null) {
						switch (farbe) {
						case "weiss":
							if (spielerliste[0].getFarbEnum() == FarbEnum.schwarz) {
								spielerliste[1] = new Spieler(name, FarbEnum.weiss, false, this);
								System.out.println("Hallo " + spielerliste[1].getName() + ", du bist weiss");

							} else {
								System.err.println("Es gibt schon einen weißen Spieler.");
							}
							break;
						case "schwarz":
							if (spielerliste[0].getFarbEnum() == FarbEnum.weiss) {
								spielerliste[1] = new Spieler(name, FarbEnum.schwarz, false, this);
								System.out.println("Hallo " + spielerliste[1].getName() + ", du bist schwarz");
							} else {
								System.err.println("Es gibt schon einen schwarzen Spieler.");
							}
							break;
						}
					} else {
						if (spielerliste[0] == null) {
							switch (farbe) {
							case "weiss":
								spielerliste[0] = new Spieler(name, FarbEnum.weiss, false, this);
								System.out.println("Hallo " + spielerliste[0].getName() + ", du bist weiss");
								break;
							case "schwarz":
								spielerliste[0] = new Spieler(name, FarbEnum.schwarz, true, this);
								System.out.println("Hallo " + spielerliste[0].getName() + ", du bist schwarz");
								break;
							default:
								System.out.println("Wähle schwarz oder weiss");
							}
						} else if (spielerliste[1] == null) {
							switch (farbe) {
							case "weiss":
								if (spielerliste[0].getFarbEnum() == FarbEnum.schwarz) {
									spielerliste[1] = new Spieler(name, FarbEnum.weiss, true, this);
									System.out.println("Hallo " + spielerliste[1].getName() + ", du bist weiss");

								} else {
									System.err.println("Es gibt schon einen weißen Spieler.");
								}
								break;
							case "schwarz":
								if (spielerliste[0].getFarbEnum() == FarbEnum.weiss) {
									spielerliste[1] = new Spieler(name, FarbEnum.schwarz, true, this);
									System.out.println("Hallo " + spielerliste[1].getName() + ", du bist schwarz");
								} else {
									System.err.println("Es gibt schon einen schwarzen Spieler.");
								}
								break;
							}
						} else {
							if (spielerliste[0] == null) {
								switch (farbe) {
								case "weiss":
									spielerliste[0] = new Spieler(name, FarbEnum.weiss, true, this);
									System.out.println("Hallo " + spielerliste[0].getName() + ", du bist weiss");
									break;
								case "schwarz":
									spielerliste[0] = new Spieler(name, FarbEnum.schwarz, false, this);
									System.out.println("Hallo " + spielerliste[0].getName() + ", du bist schwarz");
									break;
								default:
									System.out.println("Wähle schwarz oder weiss");
								}
							} else if (spielerliste[1] == null) {
								switch (farbe) {
								case "weiss":
									if (spielerliste[0].getFarbEnum() == FarbEnum.schwarz) {
										spielerliste[1] = new Spieler(name, FarbEnum.weiss, false, this);
										System.out.println("Hallo " + spielerliste[1].getName() + ", du bist weiss");

									} else {
										System.err.println("Es gibt schon einen weißen Spieler.");
									}
									break;
								case "schwarz":
									if (spielerliste[0].getFarbEnum() == FarbEnum.weiss) {
										spielerliste[1] = new Spieler(name, FarbEnum.schwarz, true, this);
										System.out.println("Hallo " + spielerliste[1].getName() + ", du bist schwarz");
									} else {
										System.err.println("Es gibt schon einen schwarzen Spieler.");
									}
									break;
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public String gibMirCSV() {

		return this.brett.toString();
	}

	// führe ich gerade ein "pusten" durch
	// nachdem wir uns bewegt haben
	// ist startfeld in der liste enthalten
	// wenn ja --> liste leer
	// hat gepustet? -> ist liste leer?
	// wenn ich nicht gepustet habt, ich muss an dem punkt die liste
	// leeren...bevor ich tausche!!
	// zufällig -> wert aus liste zufällig und aus liste raus

	@Override
	public void zugDurchführen(String startID, String zielID) {
		try {
			if (brett.gibMirDiePosition(startID).getSpielfigur().istDame() == false) {
				if (brett == null) {
					throw new RuntimeException("There is no brett available!");
				}
				if (startID.equals(zielID)) {
					throw new RuntimeException("Not a valid move");
				}
				if (brett.gibMirDiePosition(zielID).getFarbe() == FarbEnum.weiss || brett.gibMirDiePosition(startID).getFarbe() == FarbEnum.weiss) {
					throw new RuntimeException("Not a valid move on a white field");
				}
				if (amZug.getFarbEnum().equals(brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum())) {
					if (amZug != null && brett.gibMirDiePosition(zielID).getSpielfigur() == null && prüfeDifSchlagen(startID, zielID)) {
						schlagen(startID, zielID);
						zugEnde();
						updateFeld();
						
					}
				}
				if (brett.gibMirDiePosition(zielID).getSpielfigur() != null) {
					if (prüfeDif(startID, zielID) == false && prüfeDifSchlagen(startID, zielID) == false) {
						throw new RuntimeException("This is not a valid move!");
					}
				}
				if (brett.gibMirDiePosition(startID).getSpielfigur() != null && brett.gibMirDiePosition(zielID).getSpielfigur() != null && brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum() == brett.gibMirDiePosition(zielID).getSpielfigur().getFarbEnum()) {
					throw new RuntimeException("You cannot go on a field which is already taken with one of your own figure.");
				}
				if (prüfeDif(startID, zielID) == false && brett.gibMirDiePosition(zielID).getSpielfigur() == null && prüfeDifSchlagen(startID, zielID) == false) {
					throw new RuntimeException("DU kannst nur ein Feld laufen");
				}
				if (!(amZug.getFarbEnum().equals(brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum()))) {
					throw new RuntimeException("You have to go with a figure of your colour");
				}
				if (prüfeDif(startID, zielID) == true) {
					brett.gibMirDiePosition(zielID).setSpielfigur(brett.gibMirDiePosition(startID).getSpielfigur());
					brett.gibMirDiePosition(startID).setSpielfigur(null);
					int[] liste = brett.getIndexById(zielID);
					if (brett.gibMirDiePosition(zielID).getSpielfigur().getFarbEnum() == FarbEnum.weiss && liste[1] == 12 | brett.gibMirDiePosition(zielID).getSpielfigur().getFarbEnum() == FarbEnum.schwarz && liste[1] == 1) {
						brett.gibMirDiePosition(zielID).getSpielfigur().setIstDame(true);

					}
					zugEnde();
					updateFeld();
					
				}
			}
			/**
			 * zugdurchführen für dame
			 */
			else if (brett.gibMirDiePosition(startID).getSpielfigur().istDame() == true) {
				if (brett == null) {
					throw new RuntimeException("There is no brett available!");
				}
				if (startID.equals(zielID)) {
					throw new RuntimeException("Not a valid move");
				}
				if (brett.gibMirDiePosition(zielID).getFarbe() == FarbEnum.weiss || brett.gibMirDiePosition(startID).getFarbe() == FarbEnum.weiss) {
					throw new RuntimeException("Not a valid move on a white field");
				}
				if (amZug.getFarbEnum().equals(brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum())) {
					if (amZug != null && brett.gibMirDiePosition(zielID).getSpielfigur() == null && prüfeDifSchlagen(startID, zielID) == true) {
						schlagen(startID, zielID);
						updateFeld();
						zugEnde();
					}
				}
				if (brett.gibMirDiePosition(zielID).getSpielfigur() != null) {
					if (prüfeDifDame(startID, zielID) == false) {
						throw new RuntimeException("This is not a valid move!");
					}
				}
				if (brett.gibMirDiePosition(startID).getSpielfigur() != null && brett.gibMirDiePosition(zielID).getSpielfigur() != null && brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum() == brett.gibMirDiePosition(zielID).getSpielfigur().getFarbEnum()) {
					throw new RuntimeException("You cannot go on a field which is already taken with one of your own figure.");
				}
				if (!(amZug.getFarbEnum().equals(brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum()))) {
					throw new RuntimeException("You have to go with a figure of your colour");
				}
				if (prüfeDif(startID, zielID) == true) {
					brett.gibMirDiePosition(zielID).setSpielfigur(brett.gibMirDiePosition(startID).getSpielfigur());
					brett.gibMirDiePosition(startID).setSpielfigur(null);
					updateFeld();
					zugEnde();
				}

			}
		} catch (RuntimeException re) {
			System.err.println(re.getMessage());
		}
	}

	// @Override
	// public void speichern(String pfad, String name, String typ) throws
	// IOException {
	// // if (typ.equals("csv")) {
	// // String csv = spielerliste[0].toCSV() + "\n";
	// // csv += spielerliste[1].toCSV() + "\n";
	// // csv += amZug.getFarbEnum() + "\n";
	// // for (int i = 0; i < 12; i++) {
	// // for (int j = 0; j < 12; j++) {
	// // csv += brett.gibMirDiePosition(i, j);
	// // iDatenzugriff x = new DatenzugriffCSV();
	// // x.speichern(pfad, name, typ);
	// // }
	// // }
	// // } else {
	// // iDatenzugriff y = new DatenzugriffSER();
	// // y.speichern(pfad, name, typ);
	// // }
	// }
	//
	// @Override
	// public void laden(String pfad, String name, String typ) throws IOException
	// {
	// // if (typ.equals("ser")) {
	// // iDatenzugriff iD = new DatenzugriffSER();
	// // iD.laden();
	// // } else {
	// // iDatenzugriff iDz = new DatenzugriffCSV();
	// // iDz.laden();
	// // }
	// }

	/**
	 * Überprüft ob Start-/Zielfeld weiss ist, ob Zug zulässig ist, ob Startfeld
	 * Figur hat
	 * 
	 * @param startID
	 * @param zielID
	 */

	private void schlagen(String startID, String zielID) {
		try {
			/**
			 * schlagen methode für Steine/normale Figur
			 */
			if (brett.gibMirDiePosition(startID).getSpielfigur().istDame() == false) {
				if (brett.gibMirDiePosition(startID).getSpielfigur() == null) {
					throw new RuntimeException("Auf deinem Startfeld ist keine Figur.");
				} else if (brett.gibMirDiePosition(zielID).getFarbe() == FarbEnum.weiss) {
					throw new RuntimeException("Weisse Felder sind ungültig!");
				} else if (brett.gibMirDiePosition(zielID).getSpielfigur() != null) {
					throw new RuntimeException("Der Zug ist ungültig");
				} else if (brett.gibMirDiePosition(zielID).getSpielfigur() == null) {
					if (prüfeDifSchlagen(startID, zielID) && amZug != null && brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum().equals(amZug.getFarbEnum())) {
						int[] liste1 = brett.getIndexById(startID);
						liste1[0] += 1; // y-achse
						liste1[1] += 1; // x-achse
						if (brett.gibMirDiePosition(liste1[0], liste1[1]).getSpielfigur() != null) {
							brett.gibMirDiePosition(zielID).setSpielfigur(brett.gibMirDiePosition(startID).getSpielfigur());
							brett.gibMirDiePosition(startID).setSpielfigur(null);
							brett.gibMirDiePosition(liste1[0], liste1[1]).setSpielfigur(null);
						}
						System.out.println("Sie haben soeben erfolgreich geschlagen!");
					} else if (prüfeDifSchlagen(startID, zielID) && amZug != null && brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum().equals(amZug.getFarbEnum())) {
						int[] liste1 = brett.getIndexById(startID);
						liste1[0] -= 1; // y-achse
						liste1[1] -= 1; // x-achse
						if (brett.gibMirDiePosition(liste1[0], liste1[1]).getSpielfigur() != null) {
							brett.gibMirDiePosition(zielID).setSpielfigur(brett.gibMirDiePosition(startID).getSpielfigur());
							brett.gibMirDiePosition(startID).setSpielfigur(null);
							brett.gibMirDiePosition(liste1[0], liste1[1]).setSpielfigur(null);
						}
						System.out.println("Sie haben soeben erfolgreich geschlagen!");
					} else if (prüfeDifSchlagen(startID, zielID) && amZug != null && brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum().equals(amZug.getFarbEnum())) {
						int[] liste1 = brett.getIndexById(startID);
						liste1[0] += 1; // y-achse
						liste1[1] -= 1; // x-achse
						if (brett.gibMirDiePosition(liste1[0], liste1[1]).getSpielfigur() != null) {
							brett.gibMirDiePosition(zielID).setSpielfigur(brett.gibMirDiePosition(startID).getSpielfigur());
							brett.gibMirDiePosition(startID).setSpielfigur(null);
							brett.gibMirDiePosition(liste1[0], liste1[1]).setSpielfigur(null);
						}
						System.out.println("Sie haben soeben erfolgreich geschlagen!");
					} else if (prüfeDifSchlagen(startID, zielID) && amZug != null && brett.gibMirDiePosition(startID).getSpielfigur().getFarbEnum().equals(amZug.getFarbEnum())) {
						int[] liste1 = brett.getIndexById(startID);
						liste1[0] -= 1; // y-achse
						liste1[1] += 1; // x-achse
						if (brett.gibMirDiePosition(liste1[0], liste1[1]).getSpielfigur() != null) {
							brett.gibMirDiePosition(zielID).setSpielfigur(brett.gibMirDiePosition(startID).getSpielfigur());
							brett.gibMirDiePosition(startID).setSpielfigur(null);
							brett.gibMirDiePosition(liste1[0], liste1[1]).setSpielfigur(null);
						}
						System.out.println("Sie haben soeben erfolgreich geschlagen!");
					} else {
						throw new RuntimeException("Da lief was schief!");
					}
					/**
					 * das gleiche nochmal für die dame
					 */
				} else if (brett.gibMirDiePosition(startID).getSpielfigur().istDame() == true) {
					if (brett.gibMirDiePosition(startID).getSpielfigur() == null) {
						throw new RuntimeException("Auf deinem Startfeld ist keine Figur.");
					} else if (brett.gibMirDiePosition(zielID).getFarbe() == FarbEnum.weiss) {
						throw new RuntimeException("Weisse Felder sind ungültig!");
					} else if (brett.gibMirDiePosition(zielID).getSpielfigur() != null) {
						throw new RuntimeException("Der Zug ist ungültig");
					} else if (brett.gibMirDiePosition(zielID).getSpielfigur() == null && amZug.getFarbEnum() == FarbEnum.weiss || amZug.getFarbEnum() == FarbEnum.schwarz) {
						if (prüfeDifDame(startID, zielID)) {
							int[] liste1 = brett.getIndexById(startID);
							liste1[0] += 1; // y-achse
							liste1[1] += 1; // x-achse
							brett.gibMirDiePosition(zielID).setSpielfigur(brett.gibMirDiePosition(startID).getSpielfigur());
							brett.gibMirDiePosition(startID).setSpielfigur(null);
							brett.gibMirDiePosition(liste1[0], liste1[1]).setSpielfigur(null);
							System.out.println("Sie haben soeben erfolgreich geschlagen!");
						}
					} else if (brett.gibMirDiePosition(zielID).getSpielfigur() == null && amZug.getFarbEnum() == FarbEnum.weiss || amZug.getFarbEnum() == FarbEnum.schwarz) {
						if (prüfeDifDame(startID, zielID)) {
							int[] liste1 = brett.getIndexById(startID);
							liste1[0] -= 1; // y-achse
							liste1[1] -= 1; // x-achse
							brett.gibMirDiePosition(zielID).setSpielfigur(brett.gibMirDiePosition(startID).getSpielfigur());
							brett.gibMirDiePosition(startID).setSpielfigur(null);
							brett.gibMirDiePosition(liste1[0], liste1[1]).setSpielfigur(null);
							System.out.println("Sie haben soeben erfolgreich geschlagen!");
						}
					} else if (brett.gibMirDiePosition(zielID).getSpielfigur() == null && amZug.getFarbEnum() == FarbEnum.weiss || amZug.getFarbEnum() == FarbEnum.schwarz) {
						if (prüfeDifDame(startID, zielID)) {
							int[] liste1 = brett.getIndexById(startID);
							liste1[0] += 1; // y-achse
							liste1[1] -= 1; // x-achse
							brett.gibMirDiePosition(zielID).setSpielfigur(brett.gibMirDiePosition(startID).getSpielfigur());
							brett.gibMirDiePosition(startID).setSpielfigur(null);
							brett.gibMirDiePosition(liste1[0], liste1[1]).setSpielfigur(null);
							System.out.println("Sie haben soeben erfolgreich geschlagen!");
						}
					} else if (brett.gibMirDiePosition(zielID).getSpielfigur() == null && amZug.getFarbEnum() == FarbEnum.weiss || amZug.getFarbEnum() == FarbEnum.schwarz) {
						if (prüfeDifDame(startID, zielID)) {
							int[] liste1 = brett.getIndexById(startID);
							liste1[0] -= 1; // y-achse
							liste1[1] += 1; // x-achse
							brett.gibMirDiePosition(zielID).setSpielfigur(brett.gibMirDiePosition(startID).getSpielfigur());
							brett.gibMirDiePosition(startID).setSpielfigur(null);
							brett.gibMirDiePosition(liste1[0], liste1[1]).setSpielfigur(null);
							System.out.println("Sie haben soeben erfolgreich geschlagen!");
						}
					} else {
						throw new RuntimeException("Da lief was schief!");
					}
				}
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();

		}
	}

	/**
	 * prüft diferenz zwischen start id und ziel id, diferenz muss genau 1 sein!
	 * math.abs() gibt den betrag zurück, ohne vorzeichen
	 */

	public boolean prüfeDif(String startId, String zielId) {
		int[] liste1 = brett.getIndexById(startId);
		int[] liste2 = brett.getIndexById(zielId);

		if (brett.gibMirDiePosition(startId).getSpielfigur().getFarbEnum() == FarbEnum.weiss) {
			return (Math.abs(liste2[0]) - Math.abs(liste1[0]) == 1 && liste2[1] - liste1[1] == 1 || Math.abs(liste2[0]) - Math.abs(liste1[0]) == 1 && liste2[1] - liste1[1] == -1);
		} else if (brett.gibMirDiePosition(startId).getSpielfigur().getFarbEnum() == FarbEnum.schwarz) {
			return (Math.abs(liste2[0]) - Math.abs(liste1[0]) == -1 && liste2[1] - liste1[1] == -1 || Math.abs(liste2[0]) - Math.abs(liste1[0]) == -1 && liste2[1] - liste1[1] == 1);
		}
		return false;
	}

	/**
	 * gleiche methode wie prüfeDif nur mit der diferenz von 2, da die zu
	 * schlagende figur übersprungen wird.
	 * 
	 * @param startId
	 * @param zielId
	 * @return
	 */
	public boolean prüfeDifSchlagen(String startId, String zielId) {
		int[] liste1 = brett.getIndexById(startId);
		int[] liste2 = brett.getIndexById(zielId);

		if (brett.gibMirDiePosition(startId).getSpielfigur().getFarbEnum() == FarbEnum.weiss && amZug.getFarbEnum() == FarbEnum.weiss) {
			if (Math.abs(liste2[0]) - Math.abs(liste1[0]) == 2 && liste2[1] - liste1[1] == 2) {
				return true;
			} else if (Math.abs(liste2[0]) - Math.abs(liste1[0]) == -2 && liste2[1] - liste1[1] == 2) {
				return true;
			} else if (Math.abs(liste2[0]) - Math.abs(liste1[0]) == 2 && liste2[1] - liste1[1] == -2) {
				return true;
			} else if (Math.abs(liste2[0]) - Math.abs(liste1[0]) == -2 && liste2[1] - liste1[1] == -2) {
				return true;
			}
			return false;
		} else if (brett.gibMirDiePosition(startId).getSpielfigur().getFarbEnum() == FarbEnum.schwarz && amZug.getFarbEnum() == FarbEnum.schwarz) {
			if (Math.abs(liste2[0]) - Math.abs(liste1[0]) == -2 && liste2[1] - liste1[1] == 2) {
				return true;
			} else if (Math.abs(liste2[0]) - Math.abs(liste1[0]) == -2 && liste2[1] - liste1[1] == -2) {
				return true;
			} else if (Math.abs(liste2[0]) - Math.abs(liste1[0]) == 2 && liste2[1] - liste1[1] == -2) {
				return true;
			} else if (Math.abs(liste2[0]) - Math.abs(liste1[0]) == 2 && liste2[1] - liste1[1] == 2) {
				return true;
			}
		}
		return false;
	}

	public boolean prüfeDifDame(String startId, String zielId) {
		int[] liste1 = brett.getIndexById(startId);
		int[] liste2 = brett.getIndexById(zielId);

		if (Math.abs(liste2[0]) - Math.abs(liste1[0]) == Math.abs(liste2[1]) - Math.abs(liste1[1])) {
			return true;
		}
		return false;
	}

	// public void werdeDame(String ID, Spielfigur stein){
	// int [] liste = brett.getIndexById(ID);
	// if(brett.gibMirDiePosition(ID).getSpielfigur().getFarbEnum() ==
	// FarbEnum.weiss && liste[1] == 12 |
	// brett.gibMirDiePosition(ID).getSpielfigur().getFarbEnum() ==
	// FarbEnum.schwarz && liste[1] == 1){
	// brett.gibMirDiePosition(ID).getSpielfigur().setIstDame(true);
	// }
	// }

	/**
	 * updates our field --> and shows the current brett
	 */
	public void updateFeld() {

		gibMirCSV();

	}

	@Override
	public void saveSerialize(String fileName) {

	}

	@Override
	public Object loadSerialize(String fileName) {
		return null;
	}

	@Override
	public void saveCSV(String fileName) {

	}

	@Override
	public Object loadCSV(String fileName) {
		return null;
	}

}
