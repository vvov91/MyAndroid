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
	static final ArrayList<Restaurant> rests = new ArrayList<Restaurant>();			// ������ ���������� ��� ��������
	Restaurant rest[] = {new Rest_1(), new Rest_2(), new Rest_3(), new Rest_4()};	// ������ ����������
	static RestsMenuAdapter restMenuAdapter;										// ������� ������
	static int[] resIds = {0,1,2,3}; 												// id ����������
	static final int SORT_BY_NAME = 0;
	static final int SORT_BY_RATING = 1;
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        getResData();																// �������� ������ � ����������
        
        restMenuAdapter = new RestsMenuAdapter(this, rests);
        
        ListView restList = (ListView) findViewById(R.id.restList);
        restList.setAdapter(restMenuAdapter);
        restList.setOnItemClickListener(restItemClickListener);						// �������� ������� �� ������� ������
    }
    
    OnItemClickListener restItemClickListener = new AdapterView.OnItemClickListener() {
    	public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {    		 
    	    Intent menuIntent = new Intent(MainActivity.this, MenuActivity.class);
    	    menuIntent.putExtra("id", Integer.toString(resIds[position]+1));		// id ���������� ��������� 
    		startActivity(menuIntent);												// ������ ������ � ���� ���������
		}
	};
    
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch(item.getItemId()) {													// ������� ��������� ����
    		case R.id.menu_exit:													// ����� �� ����������
    			finish();
    			break;
    			
    		case R.id.menu_sort_name:												// ���������� �� ��������
    			sortList(SORT_BY_NAME);												// ������ ����������
    			restMenuAdapter = new RestsMenuAdapter(this, rests);				// ������������� �������� � ������ �������
    			ListView restList = (ListView) findViewById(R.id.restList);			
    			restList.setAdapter(restMenuAdapter);    							// ���������� ��������
    			restList.setOnItemClickListener(restItemClickListener);
    			Toast toast = Toast.makeText(this, "������ ������������ �� �������� ���������", Toast.LENGTH_LONG);
    			toast.show();														// ����������� � ����������
    			break;
    		
    		case R.id.menu_sort_rating:												// ���������� �� ��������
    			sortList(SORT_BY_RATING);											// ������ ����������
    			restMenuAdapter = new RestsMenuAdapter(this, rests);				// ������������� �������� � ������ �������
    			restList = (ListView) findViewById(R.id.restList);
    			restList.setAdapter(restMenuAdapter);        						// ���������� ��������
    			restList.setOnItemClickListener(restItemClickListener);
    			toast = Toast.makeText(this, "������ ������������ �� �������� ���������", Toast.LENGTH_LONG);
    			toast.show();														// ����������� � ����������
    			break;
    	}
    	return super.onOptionsItemSelected(item);
    }
    
    void getResData() {																// �������� �������� � ����������
    	Resources rs = this.getResources();											// ��������� ��������
    	for(int i = 1; i <= 4; i++) {
    		rest[i-1].setId(i);														// ��������� id
    		
    		int nameId = rs.getIdentifier("r"+Integer.toString(i)+"_name", "string", this.getPackageName());	// ��������� id ������ � ���������
    		rest[i-1].setName(rs.getString(nameId));								// ��������� ������� �� ����������� id
    		
    		int ratingId = rs.getIdentifier("r"+Integer.toString(i)+"_rating", "integer", this.getPackageName());	// ��������� id ������ � ���������
    		rest[i-1].setRating((short) rs.getInteger(ratingId));
    		
    		int phoneId = rs.getIdentifier("r"+Integer.toString(i)+"_phone", "string", this.getPackageName());	// ��������� id ������ � ���������
    		rest[i-1].setPhone(rs.getString(phoneId));
    		
    		int imageId = rs.getIdentifier("drawable/id"+Integer.toString(i), "string", this.getPackageName());	// ��������� id ������ � ��������� ����
    		rest[i-1].setImage(imageId);
    		
    		rests.add(rest[i-1]);													// ���������� �������� � ArrayList
        }
    }
    
    void sortList(int type) {														// ����������
    	String[] names = {rest[0].getName(), rest[1].getName(), rest[2].getName(), rest[3].getName()};	// �������� ����������
    	int[] ratings = {rest[0].getRating(), rest[1].getRating(), rest[2].getRating(), rest[3].getRating()};	// �������� ����������
    	int idTmp, ratingTmp;														// ��������� �������� id � ��������
    	String nameTmp; 															// ��������� �������� ��������
    	
    	switch (type) {
    		case 0:																	// ���������� �� ��������
    			for(int i = 1; i < 3; i++) {										// ���������
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
    			
    		case 1:																	// ���������� �� ��������
    			for(int i = 1; i < 3; i++) {										// ���������
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
		rests.clear();																// ������� ArrayList � �����������
    	for(int i = 0; i < 4; i++)
    		rests.add(rest[resIds[i]]);												// ���������� � ��������������� �������
    }
}