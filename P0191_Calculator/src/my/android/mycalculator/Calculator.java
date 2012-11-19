package my.android.mycalculator;

public class Calculator {
	// ��������
	public float Add(float arg1, float arg2) {
		if(!Float.isNaN(arg1) || !Float.isNaN(arg2)) {
			return arg1 + arg2;
		} else {
			return 0;
		}
	}
	
	// ���������
	public float Deduct(float arg1, float arg2) {
		if(!Float.isNaN(arg1) || !Float.isNaN(arg2)) {
			return arg1 - arg2;
		} else {
			return 0;
		}
	}
	
	// ���������
	public float Multiply(float arg1, float arg2) {
		if(!Float.isNaN(arg1) || !Float.isNaN(arg2)) {
			return arg1 * arg2;
		} else {
			return 0;
		}
	}
	
	// �������
	public float Divide(float arg1, float arg2) {
		float result = 0;
		if(!Float.isNaN(arg1) || !Float.isNaN(arg2)) {
			if(arg2 != 0) {								// �������� ������� �� ����
				result = arg1 / arg2;
			} else {
				result = 0;
			}
		}
		return result;
	}
}