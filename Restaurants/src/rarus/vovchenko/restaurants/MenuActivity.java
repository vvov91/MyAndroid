package rarus.vovchenko.restaurants;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MenuActivity extends Activity {
	static final ArrayList<Dish> dishes = new ArrayList<Dish>();					// ������ ���� ��� ��������
	static DishesMenuAdapter dishMenuAdapter;										// ������� ������
	static int restId;																// id ���������
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);  

    	restId = Integer.valueOf(getIntent().getStringExtra("id"));					// ��������� id ��������� ����� ������
        
        getResData();																// �������� ������ � ���������
        getDishData();																// �������� ������ � ������
        
        dishMenuAdapter = new DishesMenuAdapter(this, dishes);
                
        ListView menuList = (ListView) findViewById(R.id.menuList);
        menuList.setAdapter(dishMenuAdapter);      
        menuList.setOnItemClickListener(menuItemClickListener);						// �������� ������� �� ������� ������
    }
    
    OnItemClickListener menuItemClickListener = new AdapterView.OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
			DishDialog dishDialog = new DishDialog();								// ������ ������ ��������
    	    dishDialog.show(getFragmentManager(), "dishDialog");					// ������ �������
    	    
    	    Bundle args = new Bundle();												// ����� ��� �������� ������ � ������
    	    
    	    Resources rs = getResources();											// ��������� ��������
    	        	    
    	    int nameId = rs.getIdentifier("r"+Integer.toString(restId)+"_name", "string", getPackageName());	// ��������� id �������� ���������
    	    int phoneId = rs.getIdentifier("r"+Integer.toString(restId)+"_phone", "string", getPackageName());	// ��������� id �������� ���������
    	    args.putString("restName", rs.getString(nameId));						// ��������� ������ ��������
    	    args.putString("restPhone", rs.getString(phoneId));						// � ��������
    	    
    	    int dishId = rs.getIdentifier("array/dish_"+Integer.toString(position+1), null, getPackageName());	// ��������� id string-array'� �����
    	    String[] dish = rs.getStringArray(dishId);								// ��������� �������� �����
    	    args.putString("dishName", dish[0]);									// �������� �����
    	    args.putString("dishPrice", dish[1]);									// ����
    	    
    	    dishDialog.setArguments(args);											// ���������� ������ � �����
		}
	};
	    
    void getResData() {																// �������� ������ � ���������
    	Resources rs = this.getResources();											// ��������� ��������
    	LinearLayout menuHeader = (LinearLayout) findViewById(R.id.menuHeader);

    	if (restId == 1) {															// ������ ��������
    		Rest_1 rest = new Rest_1();
    		int nameId = rs.getIdentifier("r"+Integer.toString(restId)+"_name", "string", this.getPackageName());
    		rest.setName(rs.getString(nameId));										// ��������
    		
    		int ratingId = rs.getIdentifier("r"+Integer.toString(restId)+"_rating", "integer", this.getPackageName());
    		rest.setRating((short) rs.getInteger(ratingId));						// �������
    		
    		int phoneId = rs.getIdentifier("r"+Integer.toString(restId)+"_phone", "string", this.getPackageName());
    		rest.setPhone(rs.getString(phoneId));									// �������
    		
    		int deliveryId = rs.getIdentifier("r"+Integer.toString(restId)+"_delivery", "bool", this.getPackageName());
    		rest.setDelivery(rs.getBoolean(deliveryId));							// �������� �� ���
    		
    		int terminalPaymentId = rs.getIdentifier("r"+Integer.toString(restId)+"_terminalPayment", "bool", this.getPackageName());
    		rest.setTerminalPayment(rs.getBoolean(terminalPaymentId));				// ������ ����� ��������
    		
    		((TextView) findViewById(R.id.resMenuName)).setText(rest.getName());	// ����������� �������� ���������
    		
    		if (rest.isDelivery()) {												// ���� �������� ��������
    			TextView delivery = new TextView(this);								// �������� textview
        		delivery.setText(R.string.delivery);								
        		menuHeader.addView(delivery);
    		}
    		if (rest.isTerminalPayment()) {											// �������� ������ ����� ��������
    			TextView terminalPayment = new TextView(this);
        		terminalPayment.setText(R.string.terminal_payment);
        		menuHeader.addView(terminalPayment);    
    		}		
    	} 
    	
    	if (restId == 2) {															// ������ ��������
    		Rest_2 rest = new Rest_2();    		
    		int nameId = rs.getIdentifier("r"+Integer.toString(restId)+"_name", "string", this.getPackageName());
    		rest.setName(rs.getString(nameId));										// ��������
    		
    		int ratingId = rs.getIdentifier("r"+Integer.toString(restId)+"_rating", "integer", this.getPackageName());
    		rest.setRating((short) rs.getInteger(ratingId));						// �������
    		
    		int phoneId = rs.getIdentifier("r"+Integer.toString(restId)+"_phone", "string", this.getPackageName());
    		rest.setPhone(rs.getString(phoneId));									// �������
    		
    		int terminalPaymentId = rs.getIdentifier("r"+Integer.toString(restId)+"_terminalPayment", "bool", this.getPackageName());
    		rest.setTerminalPayment(rs.getBoolean(terminalPaymentId));				// ������ ����� ��������
    		
    		int seaViewId = rs.getIdentifier("r"+Integer.toString(restId)+"_seaView", "bool", this.getPackageName());
    		rest.setSeaView(rs.getBoolean(seaViewId));								// ��� �� ����
    		
    		((TextView) findViewById(R.id.resMenuName)).setText(rest.getName());  	// ����������� �������� ���������
    		
    		if (rest.isTerminalPayment()) {											// �������� ������ ����� ��������
    			TextView terminalPayment = new TextView(this);
        		terminalPayment.setText(R.string.terminal_payment);
        		menuHeader.addView(terminalPayment);    
    		}	
    		if (rest.isSeaView()) {													// ���� ��� �� ����
    			TextView seaView = new TextView(this);
        		seaView.setText(R.string.sea_view);		
        		menuHeader.addView(seaView);  
    		}
    	}    
    	
    	if (restId == 3) {															// ������ ��������
    		Rest_3 rest = new Rest_3();
    		int nameId = rs.getIdentifier("r"+Integer.toString(restId)+"_name", "string", this.getPackageName());
    		rest.setName(rs.getString(nameId));
    		
    		int ratingId = rs.getIdentifier("r"+Integer.toString(restId)+"_rating", "integer", this.getPackageName());
    		rest.setRating((short) rs.getInteger(ratingId));
    		
    		int phoneId = rs.getIdentifier("r"+Integer.toString(restId)+"_phone", "string", this.getPackageName());
    		rest.setPhone(rs.getString(phoneId));
    		
    		int seaViewId = rs.getIdentifier("r"+Integer.toString(restId)+"_seaView", "bool", this.getPackageName());
    		rest.setSeaView(rs.getBoolean(seaViewId));
    		
    		((TextView) findViewById(R.id.resMenuName)).setText(rest.getName());  	// ����������� �������� ���������
    		
    		if (rest.isSeaView()) {													// ���� ��� �� ����
    			TextView seaView = new TextView(this);
        		seaView.setText(R.string.sea_view);		
        		menuHeader.addView(seaView);  
    		}
    	} 
    	
    	if (restId == 4) {															// �������� ��������
    		Rest_4 rest = new Rest_4();
    		int nameId = rs.getIdentifier("r"+Integer.toString(restId)+"_name", "string", this.getPackageName());
    		rest.setName(rs.getString(nameId));										// ��������
    		
    		int ratingId = rs.getIdentifier("r"+Integer.toString(restId)+"_rating", "integer", this.getPackageName());
    		rest.setRating((short) rs.getInteger(ratingId));						// �������
    		
    		int phoneId = rs.getIdentifier("r"+Integer.toString(restId)+"_phone", "string", this.getPackageName());
    		rest.setPhone(rs.getString(phoneId));									// �������
    		
    		int terminalPaymentId = rs.getIdentifier("r"+Integer.toString(restId)+"_terminalPayment", "bool", this.getPackageName());
    		rest.setTerminalPayment(rs.getBoolean(terminalPaymentId));				// ������ ����� ��������
    		
    		int mountainViewId = rs.getIdentifier("r"+Integer.toString(restId)+"_mountainView", "bool", this.getPackageName());
    		rest.setMountainView(rs.getBoolean(mountainViewId));					// ��� �� ����
    		
    		((TextView) findViewById(R.id.resMenuName)).setText(rest.getName());  	// ����������� �������� ���������

    		if (rest.isTerminalPayment()) {											// �������� ������ ����� ��������
    			TextView terminalPayment = new TextView(this);
        		terminalPayment.setText(R.string.terminal_payment);
        		menuHeader.addView(terminalPayment);    
    		}	
    		if (rest.isMountainView()) {											// ���� ��� �� ����
    			TextView mountainView = new TextView(this);
    			mountainView.setText(R.string.mountain_view);
        		menuHeader.addView(mountainView);    
    		}	 		
    	} 
    }
    
    void getDishData() {															// �������� ������ � ������
    	Resources rs = this.getResources();											// �������� �������
    	int dishId;																	// id string-array'� �����
    	Dish dish;																	// ������-�����
    	for(int i = 1; i <= 10; i++) {
    		dish = new Dish();
    		dishId = rs.getIdentifier("array/dish_"+Integer.toString(i), null, this.getPackageName());	// ��������� id string-array'� �����
    		String[] dishInfo = rs.getStringArray(dishId);							// ��������� ���������� � �����
    		dish.setId(i);															// id
    		dish.setName(dishInfo[0]);												// ��������
    		dish.setPrice(dishInfo[1]);												// ����
    		
    		dishes.add(dish);														// ���������� � ������
        }
    }
}
