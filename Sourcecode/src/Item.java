
public class Item {
	
	String sId, sName, sDescription, sEvent0, sEvent1, sEvent2;
	int iHp, iLoad0, iEventLev;	
	
	
	public void vActionHandler (int setLev) {
		Gamedat.vPrintLine("-");
		String [] sTextArray = null;
		int iCount;
		this.iEventLev += setLev;
		
		if (this.iEventLev == 0) sTextArray = Gamedat.aDeliByChar(sEvent0, '¥');
		else if (this.iEventLev == 1) sTextArray = Gamedat.aDeliByChar(sEvent1, '¥'); 
		else if (this.iEventLev > 1) sTextArray = Gamedat.aDeliByChar(sEvent2, '¥'); 
	
		for (iCount = 0; iCount < sTextArray.length; iCount++) System.out.println(sTextArray[iCount]);
		Gamedat.vPrintLine("-");
	}	
	
	public void vActionHandler () {
		vActionHandler(this.iEventLev);
	}
}
