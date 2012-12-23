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
	static final ArrayList<Dish> dishes = new ArrayList<Dish>();					// список блюд для адаптера
	static DishesMenuAdapter dishMenuAdapter;										// адаптер списка
	static int restId;																// id ресторана
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);  

    	restId = Integer.valueOf(getIntent().getStringExtra("id"));					// получение id ресторана через интент
        
        getResData();																// загрузка данных о ресторане
        getDishData();																// загрузка данных о блюдах
        
        dishMenuAdapter = new DishesMenuAdapter(this, dishes);
                
        ListView menuList = (ListView) findViewById(R.id.menuList);
        menuList.setAdapter(dishMenuAdapter);      
        menuList.setOnItemClickListener(menuItemClickListener);						// листенер нажатия на элемент списка
    }
    
    OnItemClickListener menuItemClickListener = new AdapterView.OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id) {
			DishDialog dishDialog = new DishDialog();								// диалог выбора действия
    	    dishDialog.show(getFragmentManager(), "dishDialog");					// запуск диалога
    	    
    	    Bundle args = new Bundle();												// бандл для передачи данных в диалог
    	    
    	    Resources rs = getResources();											// получение ресурсов
    	        	    
    	    int nameId = rs.getIdentifier("r"+Integer.toString(restId)+"_name", "string", getPackageName());	// получение id названия ресторана
    	    int phoneId = rs.getIdentifier("r"+Integer.toString(restId)+"_phone", "string", getPackageName());	// получение id телефона ресторана
    	    args.putString("restName", rs.getString(nameId));						// получение самого названия
    	    args.putString("restPhone", rs.getString(phoneId));						// и телефона
    	    
    	    int dishId = rs.getIdentifier("array/dish_"+Integer.toString(position+1), null, getPackageName());	// получение id string-array'я блюда
    	    String[] dish = rs.getStringArray(dishId);								// получение значений блюда
    	    args.putString("dishName", dish[0]);									// название блюда
    	    args.putString("dishPrice", dish[1]);									// цена
    	    
    	    dishDialog.setArguments(args);											// добавление данных в бандл
		}
	};
	    
    void getResData() {																// загрузка данных о ресторане
    	Resources rs = this.getResources();											// получение ресурсов
    	LinearLayout menuHeader = (LinearLayout) findViewById(R.id.menuHeader);

    	if (restId == 1) {															// первый ресторан
    		Rest_1 rest = new Rest_1();
    		int nameId = rs.getIdentifier("r"+Integer.toString(restId)+"_name", "string", this.getPackageName());
    		rest.setName(rs.getString(nameId));										// название
    		
    		int ratingId = rs.getIdentifier("r"+Integer.toString(restId)+"_rating", "integer", this.getPackageName());
    		rest.setRating((short) rs.getInteger(ratingId));						// рейтинг
    		
    		int phoneId = rs.getIdentifier("r"+Integer.toString(restId)+"_phone", "string", this.getPackageName());
    		rest.setPhone(rs.getString(phoneId));									// телефон
    		
    		int deliveryId = rs.getIdentifier("r"+Integer.toString(restId)+"_delivery", "bool", this.getPackageName());
    		rest.setDelivery(rs.getBoolean(deliveryId));							// доставка на дом
    		
    		int terminalPaymentId = rs.getIdentifier("r"+Integer.toString(restId)+"_terminalPayment", "bool", this.getPackageName());
    		rest.setTerminalPayment(rs.getBoolean(terminalPaymentId));				// оплата через терминал
    		
    		((TextView) findViewById(R.id.resMenuName)).setText(rest.getName());	// отображение названия ресторана
    		
    		if (rest.isDelivery()) {												// если возможна доставка
    			TextView delivery = new TextView(this);								// создание textview
        		delivery.setText(R.string.delivery);								
        		menuHeader.addView(delivery);
    		}
    		if (rest.isTerminalPayment()) {											// возможна оплата через терминал
    			TextView terminalPayment = new TextView(this);
        		terminalPayment.setText(R.string.terminal_payment);
        		menuHeader.addView(terminalPayment);    
    		}		
    	} 
    	
    	if (restId == 2) {															// второй ресторан
    		Rest_2 rest = new Rest_2();    		
    		int nameId = rs.getIdentifier("r"+Integer.toString(restId)+"_name", "string", this.getPackageName());
    		rest.setName(rs.getString(nameId));										// название
    		
    		int ratingId = rs.getIdentifier("r"+Integer.toString(restId)+"_rating", "integer", this.getPackageName());
    		rest.setRating((short) rs.getInteger(ratingId));						// рейтинг
    		
    		int phoneId = rs.getIdentifier("r"+Integer.toString(restId)+"_phone", "string", this.getPackageName());
    		rest.setPhone(rs.getString(phoneId));									// телефон
    		
    		int terminalPaymentId = rs.getIdentifier("r"+Integer.toString(restId)+"_terminalPayment", "bool", this.getPackageName());
    		rest.setTerminalPayment(rs.getBoolean(terminalPaymentId));				// оплата через терминал
    		
    		int seaViewId = rs.getIdentifier("r"+Integer.toString(restId)+"_seaView", "bool", this.getPackageName());
    		rest.setSeaView(rs.getBoolean(seaViewId));								// вид на море
    		
    		((TextView) findViewById(R.id.resMenuName)).setText(rest.getName());  	// отображение названия ресторана
    		
    		if (rest.isTerminalPayment()) {											// возможна оплата через терминал
    			TextView terminalPayment = new TextView(this);
        		terminalPayment.setText(R.string.terminal_payment);
        		menuHeader.addView(terminalPayment);    
    		}	
    		if (rest.isSeaView()) {													// есть вид на море
    			TextView seaView = new TextView(this);
        		seaView.setText(R.string.sea_view);		
        		menuHeader.addView(seaView);  
    		}
    	}    
    	
    	if (restId == 3) {															// третий ресторан
    		Rest_3 rest = new Rest_3();
    		int nameId = rs.getIdentifier("r"+Integer.toString(restId)+"_name", "string", this.getPackageName());
    		rest.setName(rs.getString(nameId));
    		
    		int ratingId = rs.getIdentifier("r"+Integer.toString(restId)+"_rating", "integer", this.getPackageName());
    		rest.setRating((short) rs.getInteger(ratingId));
    		
    		int phoneId = rs.getIdentifier("r"+Integer.toString(restId)+"_phone", "string", this.getPackageName());
    		rest.setPhone(rs.getString(phoneId));
    		
    		int seaViewId = rs.getIdentifier("r"+Integer.toString(restId)+"_seaView", "bool", this.getPackageName());
    		rest.setSeaView(rs.getBoolean(seaViewId));
    		
    		((TextView) findViewById(R.id.resMenuName)).setText(rest.getName());  	// отображение названия ресторана
    		
    		if (rest.isSeaView()) {													// есть вид на море
    			TextView seaView = new TextView(this);
        		seaView.setText(R.string.sea_view);		
        		menuHeader.addView(seaView);  
    		}
    	} 
    	
    	if (restId == 4) {															// четвёртый ресторан
    		Rest_4 rest = new Rest_4();
    		int nameId = rs.getIdentifier("r"+Integer.toString(restId)+"_name", "string", this.getPackageName());
    		rest.setName(rs.getString(nameId));										// название
    		
    		int ratingId = rs.getIdentifier("r"+Integer.toString(restId)+"_rating", "integer", this.getPackageName());
    		rest.setRating((short) rs.getInteger(ratingId));						// рейтинг
    		
    		int phoneId = rs.getIdentifier("r"+Integer.toString(restId)+"_phone", "string", this.getPackageName());
    		rest.setPhone(rs.getString(phoneId));									// телефон
    		
    		int terminalPaymentId = rs.getIdentifier("r"+Integer.toString(restId)+"_terminalPayment", "bool", this.getPackageName());
    		rest.setTerminalPayment(rs.getBoolean(terminalPaymentId));				// оплата через терминал
    		
    		int mountainViewId = rs.getIdentifier("r"+Integer.toString(restId)+"_mountainView", "bool", this.getPackageName());
    		rest.setMountainView(rs.getBoolean(mountainViewId));					// вид на горы
    		
    		((TextView) findViewById(R.id.resMenuName)).setText(rest.getName());  	// отображение названия ресторана

    		if (rest.isTerminalPayment()) {											// возможна оплата через терминал
    			TextView terminalPayment = new TextView(this);
        		terminalPayment.setText(R.string.terminal_payment);
        		menuHeader.addView(terminalPayment);    
    		}	
    		if (rest.isMountainView()) {											// есть вид на горы
    			TextView mountainView = new TextView(this);
    			mountainView.setText(R.string.mountain_view);
        		menuHeader.addView(mountainView);    
    		}	 		
    	} 
    }
    
    void getDishData() {															// загрузка данных о блюдах
    	Resources rs = this.getResources();											// получаем ресурсы
    	int dishId;																	// id string-array'я блюда
    	Dish dish;																	// объект-блюдо
    	for(int i = 1; i <= 10; i++) {
    		dish = new Dish();
    		dishId = rs.getIdentifier("array/dish_"+Integer.toString(i), null, this.getPackageName());	// получение id string-array'я блюда
    		String[] dishInfo = rs.getStringArray(dishId);							// получение информации о блюде
    		dish.setId(i);															// id
    		dish.setName(dishInfo[0]);												// название
    		dish.setPrice(dishInfo[1]);												// цена
    		
    		dishes.add(dish);														// добавление в список
        }
    }
}
