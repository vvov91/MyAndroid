package rarus.vovchenko.restaurants;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {
	ArrayList<Restaurant> rests = new ArrayList<Restaurant>();
	RestsMenuAdapter restMenuAdapter;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        getResData();
        
        restMenuAdapter = new RestsMenuAdapter(this, rests);
        
        ListView restList = (ListView) findViewById(R.id.restList);
        restList.setAdapter(restMenuAdapter);    
        restList.setOnItemClickListener(restItemClickListener);
    }
    
    OnItemClickListener restItemClickListener = new AdapterView.OnItemClickListener() {
    	public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
    		/* 
    		Intent menuIntent = new Intent(null, MenuActivity.class);
    		menuIntent.putExtra("id", position);
    		startActivity(menuIntent);
    		*/
		}
	};
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    void getResData() {
    	String[] restResource = this.getResources().getStringArray(R.array.r_details);
    	for (int i = 0; i < restResource.length-1; i++) {
        	rests.add(new Restaurant(i, restResource[i], this.getResources().getIdentifier("drawable/"+restResource[++i], "string", this.getPackageName()), restResource[++i]));
        }
    }
}