package my.android.advancedmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
    	menu.add(0, 1, 0, "Add");
        menu.add(0, 2, 0, "Edit");
        menu.add(0, 3, 3, "Delete");
        menu.add(1, 4, 1, "Copy");
        menu.add(1, 5, 2, "Paste");
        menu.add(1, 6, 4, "Exit");
        return true;
    }
    
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
      menu.setGroupVisible(1, chb.isChecked());
      return super.onPrepareOptionsMenu(menu);
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
      StringBuilder sb = new StringBuilder();

      sb.append("Item Menu");
      sb.append("\r\n groupId: " + String.valueOf(item.getGroupId()));
      sb.append("\r\n itemId: " + String.valueOf(item.getItemId()));
      sb.append("\r\n order: " + String.valueOf(item.getOrder()));
      sb.append("\r\n title: " + item.getTitle());
      tv.setText(sb.toString());
      
      return super.onOptionsItemSelected(item);
    }
}
