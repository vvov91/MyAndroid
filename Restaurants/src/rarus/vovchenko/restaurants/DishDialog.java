package rarus.vovchenko.restaurants;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class DishDialog extends DialogFragment {
	String[] variants = {"�� SMS", "�� email", "�� ��������"};				// �������� ��������
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState){
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());	// �������� �������
		builder.setTitle(R.string.order);									// �������� �������
		builder.setItems(variants, new DialogInterface.OnClickListener() {	// �������� ������� �� ������� ������ �������
			public void onClick(DialogInterface dialog, int which) {
				Bundle args = getArguments();								// �������� ������ �� ����
				Intent intent;
				switch(which) {
					case 0:													// �������� ���
						intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms: " + args.getString("restPhone")));
						intent.putExtra("sms_body", "��������: "+args.getString("restName")+"\n�����: "+args.getString("dishName")+"\n����: "+args.getString("dishPrice"));
						startActivity(intent);
						break;
						
					case 1:													// �������� email
						intent = new Intent(Intent.ACTION_SEND);
						intent.setType("message/rfc822");
						intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"delivery@mail.ru"});
						intent.putExtra(Intent.EXTRA_SUBJECT, "�����");
						intent.putExtra(Intent.EXTRA_TEXT, "��������: "+args.getString("restName")+"\n�����: "+args.getString("dishName")+"\n����: "+args.getString("dishPrice"));
						startActivity(Intent.createChooser(intent, "�������� email"));
						break;
						
					case 2:													// ������
						intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + args.getString("restPhone")));
						startActivity(intent);
						break;
				}
            }
		});
		return builder.create();
	}
}