package my.android.simplelistener;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onClickStart(View v) {
    	switch (v.getId()) {
	     case R.id.btnOk:
	       tvOut.setText("Нажата кнопка Ok");
	       break;
	     case R.id.btnCancel:
	       tvOut.setText("Нажата кнопка Cancel");
	       break;
	     }
    }
}
