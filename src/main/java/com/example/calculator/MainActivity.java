package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private  static  final char ADDITION = '+';
    private  static  final char SUBTRACTION = '-';
    private  static  final char MULTIPLICATION='*';
    private  static  final char DIVISION = '/';
    private  static  final char PERCENT = '%';

    private char currentSymbol;

    private double firstValue=0;
    private double secondValue;
    private TextView inputDisplay, outputDisplay;
    private DecimalFormat decimalFormat;
    private MaterialButton button0,button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonDot,buttonAdd,
            buttonSub,buttonMul,buttonDiv,buttonPercent,buttonEqual,buttonClear,buttonOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.##");
        inputDisplay=findViewById(R.id.input);
        outputDisplay=findViewById(R.id.output);

        button0=findViewById(R.id.btn0);
        button1=findViewById(R.id.btn1);
        button2=findViewById(R.id.btn2);
        button3=findViewById(R.id.btn3);
        button4=findViewById(R.id.btn4);
        button5=findViewById(R.id.btn5);
        button6=findViewById(R.id.btn6);
        button7=findViewById(R.id.btn7);
        button8=findViewById(R.id.btn8);
        button9=findViewById(R.id.btn9);
        buttonDot=findViewById(R.id.btnPoint);


        buttonAdd=findViewById(R.id.addition);
        buttonSub=findViewById(R.id.subtract);
        buttonDiv=findViewById(R.id.division);
        buttonMul=findViewById(R.id.multiply);
        buttonClear=findViewById(R.id.clear);
        buttonOff=findViewById(R.id.off);
        buttonEqual = findViewById(R.id.equal);
        buttonPercent=findViewById(R.id.percent);

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText() + "0");
                outputDisplay.setText("");
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"1");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"2");
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"3");
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"4");
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"5");
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"6");
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText() + "7");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText() + "8");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+"9");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentSymbol = ADDITION;
                allCalculations();
                outputDisplay.setText(decimalFormat.format(firstValue) + "+");
                inputDisplay.setText(null);
            }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allCalculations();
                currentSymbol=SUBTRACTION;
                outputDisplay.setText(decimalFormat.format(firstValue) + "-");
                inputDisplay.setText(null);
            }
        });
        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allCalculations();
                currentSymbol=MULTIPLICATION;
                outputDisplay.setText(decimalFormat.format(firstValue) + "*");
                inputDisplay.setText(null);
            }
        });
        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allCalculations();
                currentSymbol=DIVISION;
                outputDisplay.setText(decimalFormat.format(firstValue) + "/");
                inputDisplay.setText(null);
            }
        });
        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allCalculations();
                currentSymbol=PERCENT;
                outputDisplay.setText(decimalFormat.format(firstValue) + "%");
                inputDisplay.setText(null);
            }
        });
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDisplay.setText(inputDisplay.getText()+".");
            }
        });
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputDisplay.getText().length() > 0) {
                    CharSequence currentText = inputDisplay.getText();
                    inputDisplay.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    firstValue = 0;
                    secondValue = 0;
                    inputDisplay.setText("");
                    outputDisplay.setText("");
                }
            }
        });

        buttonOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allCalculations();
                if (!Double.isNaN(firstValue)) {
                    outputDisplay.setText(decimalFormat.format(firstValue));
                    inputDisplay.setText(null);
                    currentSymbol = ADDITION;
                }
            }
        });


    }

    private void allCalculations() {
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble(inputDisplay.getText().toString());
            inputDisplay.setText(null);

            if (currentSymbol == ADDITION) {
                firstValue = this.firstValue + secondValue;
            } else if (currentSymbol == SUBTRACTION) {
                firstValue = this.firstValue - secondValue;
            } else if (currentSymbol == MULTIPLICATION) {
                firstValue = this.firstValue * secondValue;
            }  else if (currentSymbol == DIVISION) {
            if (secondValue != 0) {
                firstValue = this.firstValue / secondValue;
            } else {
                outputDisplay.setText("Cannot divide by zero");
                inputDisplay.setText(null);
                firstValue = 0;
                currentSymbol = ADDITION;
                return;
            }

        } else if (currentSymbol == PERCENT) {
                firstValue = firstValue * (secondValue / 100.0);
            } else {
                try {
                    firstValue = Double.parseDouble(inputDisplay.getText().toString());
                } catch (NumberFormatException ex) {
                    outputDisplay.setText("Error: Invalid input");
                    inputDisplay.setText(null);
                }

            }
        }
    }
}