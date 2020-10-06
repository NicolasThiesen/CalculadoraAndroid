package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView display;
    private TextView preview;
    private String f_number;
    private  String s_number;
    private int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.textView);
        preview = findViewById(R.id.textPreview);
    }
    public void OnClick0(View v){
        AtualizarDisplay(0);
    }
    public void OnClick1(View v){
        AtualizarDisplay(1);
    }
    public void OnClick2(View v){
        AtualizarDisplay(2);
    }
    public void OnClick3(View v){
        AtualizarDisplay(3);
    }
    public void OnClick4(View v){
        AtualizarDisplay(4);
    }
    public void OnClick5(View v){
        AtualizarDisplay(5);
    }
    public void OnClick6(View v){
        AtualizarDisplay(6);
    }
    public void OnClick7(View v){
        AtualizarDisplay(7);
    }
    public void OnClick8(View v){
        AtualizarDisplay(8);
    }
    public void OnClick9(View v){
        AtualizarDisplay(9);
    }
    public void OnClickRemove(View v){
        String n_string = display.getText().toString();
        if(n_string.length()>1){
            n_string = n_string.substring(0,n_string.length()-1);
        }else {
            n_string = "0";
        }
        display.setText(n_string);
    }
    public void OnClickPlus(View v){
        SetOperation("+");
    }
    public void OnClickReset(View v){
        f_number = null;
        s_number = null;
        display.setText("0");
        preview.setText("");
    }
    private int Convert (String number){
        int val = Integer.valueOf(number);
        return val;
    }
    private void Calculate(int num1, int num2, String operator){
        switch (operator){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case  "*":
                result = num1 * num2;
                break;
        }
    }
    private void SetOperation(String operator){
        if(f_number== null){
            f_number = display.toString();
            preview.setText(f_number);
            display.setText("0");
        }
        else if(s_number==null) {
            s_number = display.toString();
            Calculate(Convert(f_number),Convert(s_number),operator);
            display.setText(result);
        }else{
            f_number = String.valueOf(result);
            s_number = display.toString();
            Calculate(Convert(f_number),Convert(s_number),operator);
            display.setText(result);
        }
    }
    private void AtualizarDisplay(int numero){
        String n_string = display.getText().toString();
        if(n_string.equals("0")){
            display.setText(""+numero);
        }else {
            n_string = n_string + numero;
            display.setText(n_string);
        }

    }

}