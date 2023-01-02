
public class Raum {
	
	static boolean bLoop = false;
	
	public Raum nord, ost, sued, west, over, under;
	String id, sRoomName, sNord, sOst, sSued, sWest, sOver, sUnder, sEvent0, sEvent1;
	int iXmap, iYmap, iZmap, iEventLev;	

//#####		Konstruktor
	public Raum(String[] sArrayDatas) {			
		this.id 		= sArrayDatas[0];
		this.iXmap		= Character.getNumericValue(sArrayDatas[0].charAt(0));
		this.iYmap		= Character.getNumericValue(sArrayDatas[0].charAt(1));
		this.iZmap		= Character.getNumericValue(sArrayDatas[0].charAt(2));
		this.sRoomName 	= sArrayDatas[1];
		this.sNord		= sArrayDatas[2];
		this.sOst 		= sArrayDatas[3];
		this.sSued 		= sArrayDatas[4];
		this.sWest 		= sArrayDatas[5];
		this.sOver 		= sArrayDatas[6];
		this.sUnder 	= sArrayDatas[7];	
		this.sEvent0	= "eins";
		this.sEvent1	= "zwei";
		this.iEventLev	= 0;
	}

//#####		other Metods
	
	public void vCompleteRooms() {
		this.vAssignRooms();
		Gamedat.vFillStringList("Events.txt");
		Gamedat.StringList.forEach((n) -> this.vAssignEvents(Gamedat.aDeliByChar(n, ';')));		
	}
	
	public void vAssignRooms () {
		this.nord = Gamedat.oGetRoomById(this.sNord);
		this.ost = Gamedat.oGetRoomById(this.sOst);
		this.sued = Gamedat.oGetRoomById(this.sSued);
		this.west = Gamedat.oGetRoomById(this.sWest);
		this.over = Gamedat.oGetRoomById(this.sOver);
		this.under = Gamedat.oGetRoomById(this.sUnder);
	}
	
 	public void vAktionHandler(String sString, int iCheck) {
 		if (iCheck < 2) Gamedat.vPrintLine("-");
 		
 		if (iCheck == 0) System.out.println(	"Du gehst nach " + sString); 
 	 	else if (iCheck == 1) System.out.println(sString);
 		
 		Gamedat.vPrintLine("="); 		
		if (this.iEventLev++ == 0) Gamedat.vLinePrinter(sEvent0, '¥');
		else if (this.iEventLev++ > 0) Gamedat.vLinePrinter(sEvent1, '¥');
		Gamedat.vPrintMap(this.iXmap, this.iYmap, this.iZmap);
	}
 	
 	public void vAktionHandler(String sDirektion) {
 		this.vAktionHandler(sDirektion, 0);
	}
 	
 	public void vAktionHandler() {
 		this.vAktionHandler("Du erwachst wieder aus deinem Schlaf", 1);
	}
 	
 	public void vWand() {
 		System.out.println(	"Du kannst da nicht entlang");
		Gamedat.vPrintMap(this.iXmap, this.iYmap, this.iZmap);
 	}
 	
	public void vAssignEvents(String[] sArrayDatas) {
		if (sArrayDatas[0].equals(this.id)) {
			this.sEvent0 = sArrayDatas[1];
			this.sEvent1 = sArrayDatas[2];
		}
	}	
}
