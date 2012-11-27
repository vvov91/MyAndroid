package my.android.mycalculator;

import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	// результаты расчётов и строка с вводимым числом
	TextView Args, editArgs;
	// кнопки
	Button btnClr, btnClrE, btnPls;
	Button btn1, btn2, btn3, btnMns;
	Button btn4, btn5, btn6, btnMlt;
	Button btn7, btn8, btn9, btnDvd;
	Button btn0, btnDot, btnEqvl;
	// выполняемое действие (+, -, *, /)
	int action = 0;
	// первый операнд
	float arg1;
	
	Calculator calc = new Calculator();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // получаем элементы
        Args = (TextView) findViewById(R.id.tvArgs);
        // включение скролла для поля с расчётами
        Args.setMovementMethod(new ScrollingMovementMethod());
        editArgs = (TextView) findViewById(R.id.tvEditArgs);
    	(btnClr = (Button) findViewById(R.id.btnClr)).setOnClickListener(this);
    	(btnClrE = (Button) findViewById(R.id.btnClrE)).setOnClickListener(this);
    	(btnPls = (Button) findViewById(R.id.btnPls)).setOnClickListener(this);
    	(btn1 = (Button) findViewById(R.id.btn1)).setOnClickListener(this);
    	(btn2 = (Button) findViewById(R.id.btn2)).setOnClickListener(this);
    	(btn3 = (Button) findViewById(R.id.btn3)).setOnClickListener(this);
    	(btnMns = (Button) findViewById(R.id.btnMns)).setOnClickListener(this);
    	(btn4 = (Button) findViewById(R.id.btn4)).setOnClickListener(this);
    	(btn5 = (Button) findViewById(R.id.btn5)).setOnClickListener(this);
    	(btn6 = (Button) findViewById(R.id.btn6)).setOnClickListener(this);
    	(btnMlt = (Button) findViewById(R.id.btnMlt)).setOnClickListener(this);
    	(btn7 = (Button) findViewById(R.id.btn7)).setOnClickListener(this);
    	(btn8 = (Button) findViewById(R.id.btn8)).setOnClickListener(this);
    	(btn9 = (Button) findViewById(R.id.btn9)).setOnClickListener(this);
    	(btnDvd = (Button) findViewById(R.id.btnDvd)).setOnClickListener(this);
    	(btn0 = (Button) findViewById(R.id.btn0)).setOnClickListener(this);
    	(btnDot = (Button) findViewById(R.id.btnDot)).setOnClickListener(this);
    	(btnEqvl = (Button) findViewById(R.id.btnEqvl)).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

	public void onClick(View arg0) {
		// форматирование вывода
		DecimalFormat argFormat = new DecimalFormat("###.###");
		
		// действия в зависимости от нажатой кнопки на кейпаде
		switch(arg0.getId()) {
		// очистка поля с операндом
		case R.id.btnClr:						
			editArgs.setText("0");
			action = 0;
			break;

		// очистка всех результатов расчетов и поля с операндом
		case R.id.btnClrE:						
			editArgs.setText("0");
			Args.setText("");
			action = 0;
			break;
		
		// кнопка +
		case R.id.btnPls:
			if(action == 0) {						// если уже не выполняем какую-либо операцию
				arg1 = Float.parseFloat(editArgs.getText().toString());		// сохраняем операнд
				Args.setText(Args.getText() + "-------\n"+ argFormat.format(arg1) + " +");	// выводим в результаты
				editArgs.setText("0");				// в поле ввода операнда снова 0
				action = 1;							// производим суммирование
			}
			break;
		
		// кнопка -
		case R.id.btnMns:
			if(action == 0) {						// если уже не выполняем какую-либо операцию
				arg1 = Float.parseFloat(editArgs.getText().toString());		// сохраняем операнд
				Args.setText(Args.getText() + "-------\n"+ argFormat.format(arg1) + " -");	// выводим в результаты
				editArgs.setText("0");				// в поле ввода операнда снова 0
				action = 2;							// производим суммирование
			}
			break;
			
		// кнопка *
		case R.id.btnMlt:
			if(action == 0) {						// если уже не выполняем какую-либо операцию
				arg1 = Float.parseFloat(editArgs.getText().toString());		// сохраняем операнд
				Args.setText(Args.getText() + "-------\n"+ argFormat.format(arg1) + " *");	// выводим в результаты
				editArgs.setText("0");				// в поле ввода операнда снова 0
				action = 3;							// производим суммирование
			}
			break;
		
		// кнопка /
		case R.id.btnDvd:
			if(action == 0) {						// если уже не выполняем какую-либо операцию
				arg1 = Float.parseFloat(editArgs.getText().toString());		// сохраняем операнд
				Args.setText(Args.getText() + "-------\n"+ argFormat.format(arg1) + " /");	// выводим в результаты
				editArgs.setText("0");				// в поле ввода операнда снова 0
				action = 4;							// производим суммирование
			}
			break;
			
		// кнопка 0
		case R.id.btn0:
			if(Float.parseFloat(editArgs.getText().toString()) == 0) {		// если ничего не введено 
				editArgs.setText("0");										// ноль и оставляем
			} else {														// иначе
				editArgs.setText(editArgs.getText() + "0");					// добавляем в строку 0
			}
			break;
			
		// кнопка 1			
		case R.id.btn1:
			if(Float.parseFloat(editArgs.getText().toString()) == 0) {		// если ничего не введено  
				editArgs.setText("1");										// заменяем на 1
			} else {														// иначе
				editArgs.setText(editArgs.getText() + "1");					// добавляем в строку 1
			}
			break;
		
		// кнопка 2	
		case R.id.btn2:
			if(Float.parseFloat(editArgs.getText().toString()) == 0) {		// если ничего не введено 
				editArgs.setText("2");										// заменяем на 2
			} else {														// иначе
				editArgs.setText(editArgs.getText() + "2");					// добавляем в строку 2
			}
			break;
			
		// кнопка 3	
		case R.id.btn3:
			if(Float.parseFloat(editArgs.getText().toString()) == 0) {		// если ничего не введено 
				editArgs.setText("3");										// заменяем на 3
			} else {														// иначе
				editArgs.setText(editArgs.getText() + "3");					// добавляем в строку 3
			}
			break;
			
		// кнопка 4	
		case R.id.btn4:
			if(Float.parseFloat(editArgs.getText().toString()) == 0) {		// если ничего не введено 
				editArgs.setText("4");										// заменяем на 4
			} else {														// иначе
				editArgs.setText(editArgs.getText() + "4");					// добавляем в строку 4
			}
			break;
			
		// кнопка 5
		case R.id.btn5:
			if(Float.parseFloat(editArgs.getText().toString()) == 0) {		// если ничего не введено 
				editArgs.setText("5");										// заменяем на 5
			} else {														// иначе
				editArgs.setText(editArgs.getText() + "5");					// добавляем в строку 5
			}
			break;

		// кнопка 6	
		case R.id.btn6:
			if(Float.parseFloat(editArgs.getText().toString()) == 0) {		// если ничего не введено 
				editArgs.setText("6");										// заменяем на 6
			} else {														// иначе
				editArgs.setText(editArgs.getText() + "6");					// добавляем в строку 6
			}
			break;
			
		// кнопка 7	
		case R.id.btn7:
			if(Float.parseFloat(editArgs.getText().toString()) == 0) {		// если ничего не введено 
				editArgs.setText("7");										// заменяем на 7
			} else {														// иначе
				editArgs.setText(editArgs.getText() + "7");					// добавляем в строку 7
			}
			break;
			
		// кнопка 8	
		case R.id.btn8:
			if(Float.parseFloat(editArgs.getText().toString()) == 0) {		// если ничего не введено 
				editArgs.setText("8");										// заменяем на 8
			} else {														// иначе
				editArgs.setText(editArgs.getText() + "8");					// добавляем в строку 8
			}
			break;
			
		// кнопка 9	
		case R.id.btn9:
			if(Float.parseFloat(editArgs.getText().toString()) == 0) { 		// если ничего не введено 
				editArgs.setText("9");										// заменяем на 9
			} else {														// иначе
				editArgs.setText(editArgs.getText() + "9");					// добавляем в строку 9
			}
			break;
			
		// кнопка .
		case R.id.btnDot:
			if(!editArgs.getText().toString().contains(".")) {				// если точка ещё не добавлена
				editArgs.setText(editArgs.getText() + ".");					// добавляем её в строку
			}
			break;
			
		// кнопка =			
		case R.id.btnEqvl:
			// результат подсчёта и второй операнд
			float result = 0, arg2 = Float.parseFloat(editArgs.getText().toString());
			switch(action) {
			// сложение
			case 1:
				result = calc.Add(arg1, arg2);
				break;
			
			//вычитание
			case 2:
				result = calc.Deduct(arg1, arg2);
				break;
				
			// умножение					
			case 3:
				result = calc.Multiply(arg1, arg2);
				break;
				
			// деление					
			case 4:
				result = calc.Divide(arg1, arg2);
				break;					
			}
			
			if(action != 0) {												// если были произведены вычисления
				Args.setText(Args.getText() + " " + argFormat.format(arg2) + " = " + argFormat.format(result) + "\n");	// вывод результата
				editArgs.setText("0");										// в поле ввода операнда ноль
				arg1 = 0;													// обнуляем первый операнд
				action = 0;													// вычисление выполнено
			}
			break;
		}		
	}
}
