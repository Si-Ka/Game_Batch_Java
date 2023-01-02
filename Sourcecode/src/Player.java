import java.util.ArrayList;

public class Player {
	
	public ArrayList<Item> inventar = new ArrayList<Item>(); 
	public ArrayList<String> events = new ArrayList<String>();

	int iAdmin;
	String sUser, sPw;	
	
	Raum aktuell;
	String sNick;
	int iRank, iXp, iStrength, iAgility, iIntel, iConst, iCharisma, iHp, iArmor, iSchield, iPsy;	

//#####		Konstruktor
	public Player(String[] sArrayDatas) {
		this.sUser		= sArrayDatas[0]; 
		this.sPw		= sArrayDatas[1];
		this.iRank		= Gamedat.vStringToInt(sArrayDatas[2]);
		this.iXp		= Gamedat.vStringToInt(sArrayDatas[3]);
		this.iStrength	= Gamedat.vStringToInt(sArrayDatas[4]); 
		this.iAgility	= Gamedat.vStringToInt(sArrayDatas[5]);
		this.iIntel		= Gamedat.vStringToInt(sArrayDatas[6]); 
		this.iConst		= Gamedat.vStringToInt(sArrayDatas[7]);
		this.iCharisma	= Gamedat.vStringToInt(sArrayDatas[8]);
		this.iHp		= Gamedat.vStringToInt(sArrayDatas[9]);
		this.iArmor		= Gamedat.vStringToInt(sArrayDatas[10]);
		this.iSchield	= Gamedat.vStringToInt(sArrayDatas[11]); 
		this.iPsy		= Gamedat.vStringToInt(sArrayDatas[12]);		
		this.iAdmin		= Gamedat.vStringToInt(sArrayDatas[13]);
		this.aktuell	= Gamedat.oGetRoomById(sArrayDatas[14]);
	}
	
	public Player (String sUser, String sPw) {
		this.sUser		= sUser; 
		this.sPw		= sPw;
		this.setDefault();
	}

	public Player () {		
	}
//#####		set Values
	public void setDefault(){
		this.iRank		= 1; 
		this.iXp		= 0; 
		this.iStrength	= 5; 
		this.iAgility	= 5; 
		this.iIntel		= 5; 
		this.iConst		= 5; 
		this.iCharisma	= 5;
		this.iHp		= 100; 
		this.iArmor		= 0; 
		this.iSchield	= 0; 
		this.iPsy		= 100;
		this.aktuell 	= Gamedat.oGetRoomById("011");
	}
	
	public void vShowStats() {
		System.out.println("In Bearbeitung");
	}
	
	public void vShowInvent() {
		System.out.println("In Bearbeitung");
	}
	
	public void vSaveDatas() {
		System.out.println("In Bearbeitung");
	}
	
	public boolean bEndSession() {		
		this.vSaveDatas();
		System.out.println("Du verlässt nun diese Welt und gelangst ins Haubtmen�.");
		return false;
	}
	
//#####		change Room
	public void gehNord() {
		if(aktuell.nord!=null) {
			aktuell = aktuell.nord;
			aktuell.vAktionHandler("Nord");
		} else aktuell.vWand();
	}
	
	public void gehOst() {
		if(aktuell.ost!=null) {
			aktuell = aktuell.ost;			
			aktuell.vAktionHandler("Ost");
		} else aktuell.vWand();		
	}
	
	public void gehSued() {
		if(aktuell.sued!=null) {
			aktuell = aktuell.sued;
			aktuell.vAktionHandler("Sued");
		} else aktuell.vWand();
	}
	
	public void gehWest() {
		if(aktuell.west!=null) {
			aktuell = aktuell.west;
			aktuell.vAktionHandler("West");
		} else aktuell.vWand();
	}
	
	public void gehHoch() {
		if(aktuell.over!=null) {
			aktuell = aktuell.over;
			aktuell.vAktionHandler("Oben");
		} else aktuell.vWand();
	}
	
	public void gehRunter() {
		if(aktuell.under!=null) {
			aktuell = aktuell.under;
			aktuell.vAktionHandler("Unten");
		} else aktuell.vWand();
	}	
}
