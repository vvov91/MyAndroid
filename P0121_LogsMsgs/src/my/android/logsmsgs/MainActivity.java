package my.android.logsmsgs;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	TextView tvOut;
	Button btnOk;
	Button btnCancel;
	
	private static final String TAG = "myLogs";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Log.d(TAG, "поиск View-элементов");
        tvOut = (TextView) findViewById(R.id.tvOut);
        btnOk = (Button) findViewById(R.id.btnOk);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        Log.d(TAG, "присваиваем обработчик кнопкам");
        btnOk.setOnClickListener(this);
        btnCancel.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onClick(View v) {
      Log.d(TAG, "по id определеяем кнопку, вызвавшую этот обработчик");
      switch (v.getId()) {
      case R.id.btnOk:
    	  Log.d(TAG, "кнопка ОК");
    	  tvOut.setText("Нажата кнопка ОК");
    	  Toast.makeText(this, "Нажата кнопка ОК", Toast.LENGTH_LONG).show();
    	  break;
      case R.id.btnCancel:
    	  Log.d(TAG, "кнопка Cancel");
    	  tvOut.setText("Нажата кнопка Cancel");
    	  Toast.makeText(this, "Нажата кнопка Cancel", Toast.LENGTH_LONG).show();
    	  break;
      }
    }
}