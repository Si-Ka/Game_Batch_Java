

public class Game {
							
	public static void main(String[] args)  {
		
		boolean bLoop = false;	
		Player player = null;
		
//#####			Main Loop Start		
		
		do {		
			
//#####			Loading Datas				
						
			Gamedat.vFillStringList("Rooms.txt");
			Gamedat.StringList.forEach(n -> Gamedat.roomList.add(new Raum(Gamedat.aDeliByChar(n, ';'))));
			Gamedat.roomList.forEach(n -> n.vCompleteRooms());	
			Gamedat.vFillStringList("SaveFiles.txt");
			Gamedat.StringList.forEach(n -> Gamedat.playerList.add(new Player(Gamedat.aDeliByChar(n, ';'))));
			
//######		Start the Programm			
			
			do {
				player = null;
				System.out.println("Haubtmenü\n\nWähle nun aus:\n[1] zum Anmelden\n[2] zum Registrieren\n[0] zum beenden");
				switch (Gamedat.sc.nextLine()) {
				case "1": player = Gamedat.ladePlayerAusListe(); 	break;
				case "2": player = Gamedat.oCreateNewPlayer();		break;
				case "0": Gamedat.vGameEnd();						break;
				default: System.out.println("Fehlerhafte Eingabe, bitte wiederholen");
				}
			} while (player == null);
			
			System.out.println("\nDas Spiel beginnt nun");
			player.aktuell.vAktionHandler();
			
			do {
				bLoop = true;
				Gamedat.vPrintIgMenu(player.aktuell.sRoomName);
				switch (Gamedat.sc.nextLine()) {
				case "1": player.gehNord();				break;
				case "2": player.gehOst();				break;
				case "3": player.gehSued();				break;
				case "4": player.gehWest();				break;
				case "5": player.gehHoch();				break;
				case "6": player.gehRunter();			break;
				case "8": player.vShowInvent();			break;
				case "9": player.vShowStats();			break;
				case "0": bLoop = player.bEndSession(); break;
				default: System.out.println("Falsche Eingabe");
				}
			} while (bLoop == true);			
		} while (true);
	}
}
