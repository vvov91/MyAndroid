package rarus.vovchenko.restaurants;

public class Rest_4 extends Restaurant {
	private boolean terminalPayment;				// оплата через терминал
	private boolean mountainView;					// вид на горы
	
	public boolean isTerminalPayment() {
		return terminalPayment;
	}
	public void setTerminalPayment(boolean terminalPayment) {
		this.terminalPayment = terminalPayment;
	}
	
	public boolean isMountainView() {
		return mountainView;
	}
	public void setMountainView(boolean mountainView) {
		this.mountainView = mountainView;
	}
}