package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.calc_title_tv);

    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.one_btn:
                textView.append("1");
                break;
            case R.id.two_btn:
                textView.append("2");
                break;
            case R.id.three_btn:
                textView.append("3");
                break;
            case R.id.four_btn:
                textView.append("4");
                break;
            case R.id.five_btn:
                textView.append("5");
                break;
            case R.id.six_btn:
                textView.append("6");
                break;
            case R.id.seven_btn:
                textView.append("7");
                break;
            case R.id.eight_btn:
                textView.append("8");
                break;
            case R.id.nine_btn:
                textView.append("9");
                break;
            case R.id.zero_btn:
                textView.append("0");
                break;
            case R.id.back_btn:
                textView.setText(textView.getText().toString().replaceFirst(".$", ""));
                break;
            case R.id.dot_btn:
                textView.append(".");
        }
    }

    //для  кнопки AC
    public void clearClick(View view) {
        textView.setText("");
    }

    ArrayList<Double> numbers = new ArrayList<>();
    ArrayList<String> sign = new ArrayList<>();
    ArrayList<ArrayList> result = new ArrayList<>();

    public void resClick(View view) {
        Intent intent;
        intent = new Intent(MainActivity.this, Text_view.class);
        intent.putExtra("res", textView.getText().toString());
        startActivity(intent);
    }

    public void math(View view) {
        try {
            //очищает строку от пробелов и всех знаков и сохраняет числом
            Double num = new Double(textView.getText().toString().replaceAll("\\s+", ""));
            numbers.add(num);
            textView.setText(" ");
            switch (view.getId()) {
                case R.id.plus_btn:
                    sign.add("+");
                    break;
                case R.id.delenie_btn:
                    sign.add("/");
                    break;
                case R.id.minus:
                    sign.add("-");
                    break;
                case R.id.umnoj_btn:
                    sign.add("x");
                    break;
                case R.id.protsent_btn:
                    sign.add("%");
            }
        } catch (Exception e) {
            Toast toast = Toast.makeText(getBaseContext(), "Не верно введены данные", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    public void equal(View view) {
        //Сохраняет ответ чтобы дальше с ним работать
        try {
            Double num = new Double(textView.getText().toString().replaceAll("\\s+", ""));
            numbers.add(num);
        } catch (Exception e) {
            Toast toast = Toast.makeText(getBaseContext(), "Не верно введены данные", Toast.LENGTH_LONG);
            toast.show();
        }
        double res = 0;
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (sign.get(i) == "+") {
                res = numbers.get(i) + numbers.get(i + 1);
                textView.setText(String.valueOf(res));
                numbers.clear();
                sign.clear();
            } else if (sign.get(i) == "-") {
                res = numbers.get(i) - numbers.get(i + 1);
                textView.setText(String.valueOf(res));
                numbers.clear();
                sign.clear();
            } else if (sign.get(i) == "x") {
                res = numbers.get(i) * numbers.get(i + 1);
                textView.setText(String.valueOf(res));
                numbers.clear();
                sign.clear();
            } else if (sign.get(i) == "/") {
                try {
                    res = numbers.get(i) / numbers.get(i + 1);
                    textView.setText(String.valueOf(res));
                    numbers.clear();
                    sign.clear();
                } catch (Exception e) {
                    Toast toast = Toast.makeText(getBaseContext(), "Деление на ноль не возможно", Toast.LENGTH_LONG);
                    toast.show();
                }
            }

        }
    }
}