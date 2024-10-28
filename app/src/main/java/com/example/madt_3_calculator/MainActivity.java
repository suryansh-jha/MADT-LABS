package com.example.madt_3_calculator;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private String currentNumber = "";
    private String operator = "";
    private double firstNumber = 0;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        // Number Buttons
        findViewById(R.id.button0).setOnClickListener(this::numberClick);
        findViewById(R.id.button1).setOnClickListener(this::numberClick);
        findViewById(R.id.button2).setOnClickListener(this::numberClick);
        findViewById(R.id.button3).setOnClickListener(this::numberClick);
        findViewById(R.id.button4).setOnClickListener(this::numberClick);
        findViewById(R.id.button5).setOnClickListener(this::numberClick);
        findViewById(R.id.button6).setOnClickListener(this::numberClick);
        findViewById(R.id.button7).setOnClickListener(this::numberClick);
        findViewById(R.id.button8).setOnClickListener(this::numberClick);
        findViewById(R.id.button9).setOnClickListener(this::numberClick);

        // Operation Buttons
        findViewById(R.id.buttonAdd).setOnClickListener(v -> operatorClick("+"));
        findViewById(R.id.buttonSubtract).setOnClickListener(v -> operatorClick("-"));
        findViewById(R.id.buttonMultiply).setOnClickListener(v -> operatorClick("*"));
        findViewById(R.id.buttonDivide).setOnClickListener(v -> operatorClick("/"));
        findViewById(R.id.buttonEquals).setOnClickListener(v -> calculateResult());
        findViewById(R.id.buttonCE).setOnClickListener(v -> clear());
        findViewById(R.id.buttonSign).setOnClickListener(v -> squareRoot());
        findViewById(R.id.buttonC).setOnClickListener(v -> backspace());
        findViewById(R.id.buttonSign).setOnClickListener(v -> signChange());
    }



    private void numberClick(View view) {
        Button button = (Button) view;
        currentNumber += button.getText().toString();
        display.setText(currentNumber);
    }

    private void operatorClick(String op) {
        firstNumber = Double.parseDouble(currentNumber);
        currentNumber = "";
        operator = op;
    }

    private void calculateResult() {
        double secondNumber = Double.parseDouble(currentNumber);
        double result = 0;

        switch (operator) {
            case "+": result = firstNumber + secondNumber; break;
            case "-": result = firstNumber - secondNumber; break;
            case "*": result = firstNumber * secondNumber; break;
            case "/": result = firstNumber / secondNumber; break;
        }
        display.setText(String.valueOf(result));
        currentNumber = String.valueOf(result);
        operator = "";
    }

    private void clear() {
        currentNumber = "";
        firstNumber = 0;
        operator = "";
        display.setText("");
    }

    private void squareRoot() {
        double number = Double.parseDouble(currentNumber);
        display.setText(String.valueOf(Math.sqrt(number)));
        currentNumber = String.valueOf(Math.sqrt(number));
    }

    private void backspace() {
        if (!currentNumber.isEmpty()) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
            display.setText(currentNumber);
        }
    }

    private void signChange() {
        double number = Double.parseDouble(currentNumber);
        number = -number;
        currentNumber = String.valueOf(number);
        display.setText(currentNumber);
    }
}
