package my.android.dynamiclayout2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	LinearLayout llMain;
	RadioGroup rgGravity;
	EditText etName;
	Button btnCreate;
	Button btnClear;

	int wrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        llMain = (LinearLayout) findViewById(R.id.llMain);
        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);
        etName = (EditText) findViewById(R.id.etName);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
    }
    
    public void onClick(View v) {
      switch (v.getId()) {
      case R.id.btnCreate:
        // Создание LayoutParams c шириной и высотой по содержимому
        LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
            wrapContent, wrapContent);
        // переменная для хранения значения выравнивания
        // по умолчанию пусть будет LEFT
        int btnGravity = Gravity.LEFT;
        // определяем, какой RadioButton "чекнут" и 
        // соответственно заполняем btnGravity 
        switch (rgGravity.getCheckedRadioButtonId()) {
        	case R.id.rbLeft:
        		btnGravity = Gravity.LEFT;
        		break;
        		
        	case R.id.rbCenter:
        		btnGravity = Gravity.CENTER_HORIZONTAL;
        		break;
        		
        	case R.id.rbRight:
        		btnGravity = Gravity.RIGHT;
        		break;        	
        }
        // переносим полученное значение выравнивания в LayoutParams
        lParams.gravity = btnGravity;

        // создаем Button, пишем текст и добавляем в LinearLayout
        Button btnNew = new Button(this);
        btnNew.setText(etName.getText().toString());
        llMain.addView(btnNew, lParams);
        etName.setText("");
        break;
        
      case R.id.btnClear:
  		llMain.removeAllViews();
  		Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show();
  		break;
      }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
