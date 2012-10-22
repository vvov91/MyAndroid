package my.android.onclickbuttons;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView tvOut;
	Button btnOk;
	Button btnCancel;
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
	     super.onCreate(savedInstanceState);
	     setContentView(R.layout.main);
	 
	     tvOut = (TextView) findViewById(R.id.tvOut);
	     btnOk = (Button) findViewById(R.id.btnOk);
	     btnCancel = (Button) findViewById(R.id.btnCancel);
	 
	     OnClickListener oclBtnOk = new OnClickListener() {
	       public void onClick(View v) {
	         tvOut.setText("������ ������ ��");
	       }
	     };
	 
	     btnOk.setOnClickListener(oclBtnOk);
	
	     OnClickListener oclBtnCancel = new OnClickListener() {
	       public void onClick(View v) {
	           tvOut.setText("������ ������ Cancel");
	         }
	       };
	    
	    btnCancel.setOnClickListener(oclBtnCancel);	
	}
}
