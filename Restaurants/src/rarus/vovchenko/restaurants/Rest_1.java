package rarus.vovchenko.restaurants;

public class Rest_1 extends Restaurant {
	private boolean delivery;						// �������� �� ���
	private boolean terminalPayment;				// ������ ����� ��������
	
	public boolean isDelivery() {
		return delivery;
	}
	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}
	
	public boolean isTerminalPayment() {
		return terminalPayment;
	}
	public void setTerminalPayment(boolean terminalPayment) {
		this.terminalPayment = terminalPayment;
	}	
}