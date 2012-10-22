package my.android.viewbyid;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView myTextView = (TextView) findViewById(R.id.myText);
        myTextView.setText("Новый текст в TextView");
        
        Button myBtn = (Button) findViewById(R.id.myBtn);
        myBtn.setText("Кнопка");
        myBtn.setEnabled(false);
        
        CheckBox myChb = (CheckBox) findViewById(R.id.myChb);
        myChb.setChecked(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
