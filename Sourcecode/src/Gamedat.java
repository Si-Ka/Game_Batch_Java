import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Gamedat {
	
	public static Scanner sc = new Scanner(System.in);	
	public static ArrayList<Player> playerList = new ArrayList<Player>();
	public static ArrayList<Raum> roomList = new ArrayList<Raum>(); 
	public static ArrayList<Item> itemList = new ArrayList<Item>(); 
	public static ArrayList<String> StringList = new ArrayList<String>();
		
//#####			Game Methods
	
	public static Player ladePlayerAusListe(){							
		String sUser, sPw;
		
		System.out.println("Bitte Usernamen eingeben");
		sUser = Gamedat.sc.nextLine();
		System.out.println("Bitte passwort eingeben");
		sPw = Gamedat.sc.nextLine();
		
		for(int iCount = 0; iCount < playerList.size(); iCount++) {											
			if(	playerList.get(iCount).sUser.equals(sUser) && playerList.get(iCount).sPw.equals(sPw)) {
				System.out.println("Wilkommen " + sUser);
				return playerList.get(iCount);			
			} else System.out.println("Passwort oder Name stimmen nicht");
		}		
		return null;
	}
	
	public static Player oCreateNewPlayer() {
		String sUser, sPw;
		Player player = null;
		
		System.out.println("Bitte neuen Nutzernamen eingeben");
		sUser = Gamedat.sc.nextLine();
		System.out.println("Bitte neues passwort eingeben");
		sPw = Gamedat.sc.nextLine();
		player = new Player(sUser,sPw);
		Gamedat.playerList.add(player);
		return player;
	}
	
	public static void vGameEnd() {
		System.out.println("Das Programm wird nun beendet");
		Gamedat.sc.close();
		System.exit(0);
	}

 	public static Raum oGetRoomById(String sCheck) {		
		for(int i = 0; i < roomList.size(); i++) 
			if (sCheck.equals(roomList.get(i).id)) return roomList.get(i);							
		return null;			
	} 
	
//#####			Other Methods
 	
 	public static int vStringToInt (String sStringValue) {
		
		int	iPoint = 0;
		String sReturn = "", sBuff0;
		
		for (iPoint = 0; iPoint < sStringValue.length(); iPoint++) {
			sBuff0 = sStringValue.substring(iPoint,(iPoint+1));
			if (sBuff0.equals("0")||sBuff0.equals("1")||sBuff0.equals("2")||sBuff0.equals("3")||sBuff0.equals("4")||
				sBuff0.equals("5")||sBuff0.equals("6")||sBuff0.equals("7")||sBuff0.equals("8")||sBuff0.equals("9")){
				sReturn = (sReturn + sBuff0);
			}
		}
		return Integer.parseInt(sReturn);
	}
 	
	public static boolean bCheckChar(String sPruefling, String sChar) {						
		
		int iLength = sPruefling.length();
		int iRunChar = 0 ;
		String sCharx ;
		boolean bZeichen = false ;
				
		for (iRunChar = 0 ; iRunChar < iLength ; iRunChar++) {
			sCharx = sPruefling.substring (iRunChar , iRunChar+1) ;
			if (sCharx.equals(sChar)) {
				iRunChar = iLength ;
				bZeichen = true ;
			} 
		}
		return bZeichen;
	}

	public static String[] aDeliByChar(String sLine, char cDeli) {				
		
		int	iBuff1 = 0; 
		int iBuff2 = 0; 
		int iCcolum = 0;
		String [] sArrayDatas = new String [countLetter(sLine, cDeli, false)];	
		for (iBuff2 = 0; iBuff2 < sLine.length(); iBuff2++) {
			iBuff1 = sLine.indexOf(cDeli, iBuff2);
			sArrayDatas[iCcolum] = sLine.substring(iBuff2,iBuff1);
			iBuff2 = iBuff1;
			iCcolum++;										
		}	
		return sArrayDatas;
	}
	
	public static int countLetter(String str, char letter, boolean check) {
		
		int count = 0;
		
		if (check) {
			str = str.toLowerCase();		
			letter = Character.toLowerCase(letter);	
		}		
		for (int i = 0; i < str.length(); i++) {
			char currentLetter = str.charAt(i);
			if (currentLetter == letter)
				count++;			
		}		
		return count;
	}
	
	public static void vLinePrinter (String str, char cDeli) {
		String[] sTextArray = aDeliByChar(str, cDeli);
		for (int i = 0; i < sTextArray.length; i++) System.out.println(sTextArray[i]);	
	}

//#####			TXT Metods
	
	public static void vFillStringList (String sDataName){
			FileReader fr = null;
			String sLine = null;
			boolean bLoop = true;
			StringList.clear();
			
			try {
				fr = new FileReader (sDataName);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			BufferedReader	br 	= new BufferedReader (fr);		
			
			do {
				try {
					sLine = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}			
				if (sLine == null) bLoop = false;
				else StringList.add(sLine);		
			} while (bLoop);
			
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
//#####			Print Templates
	
	public static void vPrintLine(String x, int z) {
		for (int i = 0; i < z; i++) System.out.print(x);	
		System.out.println("");
	}
	
	public static void vPrintLine(String x) {
		vPrintLine(x, 60);
	}
	
	
//#####			Print Game Teplates	
 	public static void vPrintMap (int x, int y, int z) {
		String [][] o = {{" ", " ", " "},{" ", " ", " "},{" ", " ", " "}};	
		
		Gamedat.vPrintLine("-");
		System.out.println("X = " + x);
		System.out.println("Y = " + y);
		System.out.println("Z = " + (z-1));
		if (x > 0 && x < 4 && y > -1 && y < 3 ) {
			o[x-1][y] = "x";
			System.out.println(
					"Aktueller Standort\n" +
					"------------------\n" +
					" ╔═════╦═════╦═════╗\n" + 
					" ║  "+o[0][2]+"  ║  "+o[1][2]+"  ║  "+o[2][2]+"  ║\n" + 
					" ╠═════╬═════╬═════╣\n" + 
					" ║  "+o[0][1]+"  ║  "+o[1][1]+"  ║  "+o[2][1]+"  ║\n" +  
					" ╠═════╬═════╬═════╣\n" + 
					" ║  "+o[0][0]+"  ║  "+o[1][0]+"  ║  "+o[2][0]+"  ║\n" +  
					" ╚═════╩═════╩═════╝\n" +
					"  Ebene: " + (z-1));
		}
		
		else System.out.println("Du befindest dich ausserhalb der Map");		
		Gamedat.vPrintLine("-");
	}	

	public static void vPrintIgMenu(String sRoomName) {
		System.out.println(	"Du bist im Raum " + sRoomName + " Wohin willst du nun?\n\n"+
				"Drücke einer der folgenden Tasten:\n" +
				"[1] um nach Norden zu gehen\n" +
				"[2] um nach Osten zu gehen\n" +
				"[3] um nach Westen zu gehen\n" +
				"[4] um nach Osten zu gehen\n" +
				"[5] um nach Oben zu gehen\n" +
				"[6] um nach Unten zu gehen\n" +
				"[8] um deine Stats zu sehen\n" +
				"[9] um dein Inventar zu sehen\n" +
				"[0] um ins Haubtmenü zu gelangen");
	}
}
