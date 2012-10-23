package my.android.dynamiclayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // создание LinearLayout
        LinearLayout linLayout = new LinearLayout(this);
        // установим вертикальную ориентацию
        linLayout.setOrientation(LinearLayout.VERTICAL);
        // создаем LayoutParams  
        LayoutParams linLayoutParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT); 
        // устанавливаем linLayout как корневой элемент экрана 
        setContentView(linLayout, linLayoutParam);

        LayoutParams lpView = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        
        TextView tv = new TextView(this);
        tv.setText("Текст");
        tv.setLayoutParams(lpView);
        linLayout.addView(tv);
        
        Button btn = new Button(this);
        btn.setText("Кнопка");
        linLayout.addView(btn, lpView);
        
        LinearLayout.LayoutParams leftMarginParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftMarginParams.leftMargin = 50;
        
        Button btn1 = new Button(this);
        btn1.setText("Кнопка1");
        linLayout.addView(btn1, leftMarginParams);
        
        LinearLayout.LayoutParams rightGravityParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightGravityParams.gravity = Gravity.RIGHT;
        
        Button btn2 = new Button(this);
        btn2.setText("Кнопка2");
        linLayout.addView(btn2, rightGravityParams);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
