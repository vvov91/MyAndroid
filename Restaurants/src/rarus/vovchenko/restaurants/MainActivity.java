package rarus.vovchenko.restaurants;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	static final ArrayList<Restaurant> rests = new ArrayList<Restaurant>();			// список ресторанов для адаптера
	Restaurant rest[] = {new Rest_1(), new Rest_2(), new Rest_3(), new Rest_4()};	// классы ресторанов
	static RestsMenuAdapter restMenuAdapter;										// адаптер списка
	static int[] resIds = {0,1,2,3}; 												// id ресторанов
	static final int SORT_BY_NAME = 0;
	static final int SORT_BY_RATING = 1;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        getResData();																// загрузка данных о ресторанах
        
        restMenuAdapter = new RestsMenuAdapter(this, rests);
        
        ListView restList = (ListView) findViewById(R.id.restList);
        restList.setAdapter(restMenuAdapter);
        restList.setOnItemClickListener(restItemClickListener);						// листенер нажатия на элемент списка
    }
    
    OnItemClickListener restItemClickListener = new AdapterView.OnItemClickListener() {
    	public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {    		 
    	    Intent menuIntent = new Intent(MainActivity.this, MenuActivity.class);
    	    menuIntent.putExtra("id", Integer.toString(resIds[position]+1));		// id выбранного ресторана 
    		startActivity(menuIntent);												// запуск экрана с меню ресторана
		}
	};
    
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch(item.getItemId()) {													// перебор элементов меню
    		case R.id.menu_exit:													// выход из приложения
    			finish();
    			break;
    			
    		case R.id.menu_sort_name:												// сортировка по названию
    			sortList(SORT_BY_NAME);												// запуск сортировки
    			restMenuAdapter = new RestsMenuAdapter(this, rests);				// инициализация адаптера с новыми данными
    			ListView restList = (ListView) findViewById(R.id.restList);			
    			restList.setAdapter(restMenuAdapter);    							// применение адаптера
    			restList.setOnItemClickListener(restItemClickListener);
    			Toast toast = Toast.makeText(this, "Список отсортирован по названию ресторана", Toast.LENGTH_LONG);
    			toast.show();														// уведомление о сортировке
    			break;
    		
    		case R.id.menu_sort_rating:												// сортировка по рейтингу
    			sortList(SORT_BY_RATING);											// запуск сортировки
    			restMenuAdapter = new RestsMenuAdapter(this, rests);				// инициализация адаптера с новыми данными
    			restList = (ListView) findViewById(R.id.restList);
    			restList.setAdapter(restMenuAdapter);        						// применение адаптера
    			restList.setOnItemClickListener(restItemClickListener);
    			toast = Toast.makeText(this, "Список отсортирован по рейтингу ресторана", Toast.LENGTH_LONG);
    			toast.show();														// уведомление о сортировке
    			break;
    	}
    	return super.onOptionsItemSelected(item);
    }
    
    void getResData() {																// загрузка сведений о ресторанах
    	Resources rs = this.getResources();											// получение ресурсов
    	for(int i = 1; i <= 4; i++) {
    		rest[i-1].setId(i);														// установка id
    		
    		int nameId = rs.getIdentifier("r"+Integer.toString(i)+"_name", "string", this.getPackageName());	// получение id строки с названием
    		rest[i-1].setName(rs.getString(nameId));								// получение ресурса по полученному id
    		
    		int ratingId = rs.getIdentifier("r"+Integer.toString(i)+"_rating", "integer", this.getPackageName());	// получение id строки с рейтингом
    		rest[i-1].setRating((short) rs.getInteger(ratingId));
    		
    		int phoneId = rs.getIdentifier("r"+Integer.toString(i)+"_phone", "string", this.getPackageName());	// получение id строки с телефоном
    		rest[i-1].setPhone(rs.getString(phoneId));
    		
    		int imageId = rs.getIdentifier("drawable/id"+Integer.toString(i), "string", this.getPackageName());	// получение id строки с названием фото
    		rest[i-1].setImage(imageId);
    		
    		rests.add(rest[i-1]);													// добавление элемента в ArrayList
        }
    }
    
    void sortList(int type) {														// сортировка
    	String[] names = {rest[0].getName(), rest[1].getName(), rest[2].getName(), rest[3].getName()};	// названия ресторанов
    	int[] ratings = {rest[0].getRating(), rest[1].getRating(), rest[2].getRating(), rest[3].getRating()};	// рейтинги ресторанов
    	int idTmp, ratingTmp;														// временное значение id и рейтинга
    	String nameTmp; 															// временное значение названия
    	
    	switch (type) {
    		case 0:																	// сортировка по названию
    			for(int i = 1; i < 3; i++) {										// вставками
    				idTmp = i;
    				nameTmp = names[i];
    				for(int j = i-1; j >= 0; j--) {
    					if (names[j].charAt(0) < nameTmp.charAt(0))
    						break;
    					names[j+1] = names[j];
    					resIds[j+1] = resIds[j];
    					names[j] = nameTmp;
    					resIds[j] = idTmp;
    				}
    			}   
    			break;
    			
    		case 1:																	// сортировка по рейтингу
    			for(int i = 1; i < 3; i++) {										// вставками
    				idTmp = i;
    				ratingTmp = ratings[i];
    				for(int j = i-1; j >= 0; j--) {
    					if (ratings[j] > ratingTmp)
    						break;
    					ratings[j+1] = ratings[j];
    					resIds[j+1] = resIds[j];
    					ratings[j] = ratingTmp;
    					resIds[j] = idTmp;
    				}
    			}   
    			break;
    	}
		rests.clear();																// очистка ArrayList с ресторанами
    	for(int i = 0; i < 4; i++)
    		rests.add(rest[resIds[i]]);												// добавление в отсортированном порядке
    }
}