package my.android.mycalculator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Settings extends Activity implements OnClickListener {
	
	final String ATTR_NAME_TEXT = "text";
	final String ATTR_NAME_CHECKED = "checked";
	
	ListView lv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		String[] titles = {"Отображать кнопку \".\"", "Тёмный фон"};
		boolean[] checked = {getIntent().getBooleanExtra("0", false), getIntent().getBooleanExtra("1", false)};
		String[] from = {ATTR_NAME_TEXT, ATTR_NAME_CHECKED};		
		int[] to = {R.id.textView, R.id.checkBox};
		Button btnSave = (Button) findViewById(R.id.btnSave);
		btnSave.setOnClickListener(this);
		
		ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(titles.length);
		Map<String, Object>	m;
		for (int i = 0; i < titles.length; i++) {
			m = new HashMap<String, Object>();
			m.put(ATTR_NAME_CHECKED, checked[i]);
			m.put(ATTR_NAME_TEXT, titles[i]);
			data.add(m);
		}
		
		lv = (ListView) findViewById(R.id.listView);
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);		
		SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.list_item, from, to); 		
		lv.setAdapter(sAdapter);
	}	
	
	public void onClick(View v) {
	    Intent intent = new Intent();
	    int key;
		SparseBooleanArray sbArray = lv.getCheckedItemPositions();
		for (int i = 0; i < sbArray.size(); i++) {
			key = sbArray.keyAt(i);
		      if (sbArray.get(key)) {
		  		  intent.putExtra(String.valueOf(key), true);
		      }
		} 	
	    setResult(RESULT_OK, intent);
	    finish();
	  }
}
