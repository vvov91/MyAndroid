package rarus.vovchenko.restaurants;

public class Rest_2 extends Restaurant {
	private boolean terminalPayment;				// ������ ����� ��������
	private boolean seaView;						// ��� �� ����
	
	public boolean isTerminalPayment() {
		return terminalPayment;
	}
	public void setTerminalPayment(boolean terminalPayment) {
		this.terminalPayment = terminalPayment;
	}
	
	public boolean isSeaView() {
		return seaView;
	}
	public void setSeaView(boolean seaView) {
		this.seaView = seaView;
	}
}