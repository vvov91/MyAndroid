package my.android.advancedmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {

	TextView tv;
	CheckBox chb;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        tv = (TextView) findViewById(R.id.textView);
        chb = (CheckBox) findViewById(R.id.chbExtMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	 getMenuInflater().inflate(R.menu.mymenu, menu);
    	 return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
      menu.setGroupVisible(R.id.group1, chb.isChecked());
      return super.onPrepareOptionsMenu(menu);
    }
}
