package rarus.vovchenko.restaurants;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class DishDialog extends DialogFragment {
	String[] variants = {"По SMS", "По email", "По телефону"};				// варианты действий
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState){
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());	// создание диалога
		builder.setTitle(R.string.order);									// название диалога
		builder.setItems(variants, new DialogInterface.OnClickListener() {	// листенер нажатия на элемент списка диалога
			public void onClick(DialogInterface dialog, int which) {
				Bundle args = getArguments();								// получаем данные из меню
				Intent intent;
				switch(which) {
					case 0:													// отправка смс
						intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms: " + args.getString("restPhone")));
						intent.putExtra("sms_body", "Ресторан: "+args.getString("restName")+"\nЗаказ: "+args.getString("dishName")+"\nЦена: "+args.getString("dishPrice"));
						startActivity(intent);
						break;
						
					case 1:													// отправка email
						intent = new Intent(Intent.ACTION_SEND);
						intent.setType("message/rfc822");
						intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"delivery@mail.ru"});
						intent.putExtra(Intent.EXTRA_SUBJECT, "Заказ");
						intent.putExtra(Intent.EXTRA_TEXT, "Ресторан: "+args.getString("restName")+"\nЗаказ: "+args.getString("dishName")+"\nЦена: "+args.getString("dishPrice"));
						startActivity(Intent.createChooser(intent, "Отправка email"));
						break;
						
					case 2:													// звонок
						intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + args.getString("restPhone")));
						startActivity(intent);
						break;
				}
            }
		});
		return builder.create();
	}
}