package rarus.vovchenko.restaurants;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class MenuActivity extends Activity {
	ArrayList<Dish> dishes = new ArrayList<Dish>();
	DishesMenuAdapter dishMenuAdapter;
	int restId = getIntent().getIntExtra("id", 1); 
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        
        getDishData();
        
        dishMenuAdapter = new DishesMenuAdapter(this, dishes);
        
        ListView restList = (ListView) findViewById(R.id.restList);
        restList.setAdapter(dishMenuAdapter);        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    void getDishData() {
    	String[] dishResource = this.getResources().getStringArray(this.getResources().getIdentifier("id"+restId, "string", this.getPackageName()));
    	for (int i = 0; i < dishResource.length-1; i++) {
    		dishes.add(new Dish(i, dishResource[i], dishResource[++i]));
        }
    }
}
