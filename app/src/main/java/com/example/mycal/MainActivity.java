package com.example.mycal;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Notification;
import android.drm.DrmStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button equal;
    private Button clear;
    private TextView info;
    private TextView res;
    private final char ADDITION='+';
    private final char SUBTRACTION='-';
    private final char MULTIPLICATION='*';
    private final char DIVISION='/';
    private final char EQL=0;
    private double val1=Double.NaN;
    private double val2;
    private char ACTION;

    MainActivity.Calculation myCal=new Calculation();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUIView();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString()+"9");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCal.compute();
                ACTION=ADDITION;
                res.setText(String.valueOf(val1)+"+");
                info.setText(null);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCal.compute();
                ACTION=SUBTRACTION;
                res.setText(String.valueOf(val1)+"-");
                info.setText(null);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCal.compute();
                ACTION=MULTIPLICATION;
                res.setText(String.valueOf(val1)+"*");
                info.setText(null);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCal.compute();
                ACTION=DIVISION;
                res.setText(String.valueOf(val1)+"/");
                info.setText(null);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCal.compute();
                ACTION=EQL;
                res.setText(res.getText().toString()+String.valueOf(val2)+ "=" + String.valueOf(val1));
                info.setText(null);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length()>0){
                    CharSequence name=info.getText().toString();
                    info.setText(name.subSequence(0,name.length()-1));
                }
                else {
                    val1=Double.NaN;
                    val2=Double.NaN;
                    info.setText(null);
                    res.setText(null);
                }
            }
        });
    }


    private void setupUIView(){
        zero=(Button) findViewById(R.id.btnzero);
        one=(Button) findViewById(R.id.btn1);
        two=(Button) findViewById(R.id.btn2);
        three=(Button) findViewById(R.id.btn3);
        four=(Button) findViewById(R.id.btn4);
        five=(Button) findViewById(R.id.btn5);
        six=(Button) findViewById(R.id.btn6);
        seven=(Button) findViewById(R.id.btn7);
        eight=(Button) findViewById(R.id.btn8);
        nine=(Button) findViewById(R.id.btn9);
        add=(Button) findViewById(R.id.btnadd);
        sub=(Button) findViewById(R.id.btnMinus);
        mul=(Button) findViewById(R.id.btnMult);
        div=(Button) findViewById(R.id.btnDiv);
        equal=(Button) findViewById(R.id.btnequal);
        clear=(Button) findViewById(R.id.btnclear);
        info=(TextView) findViewById(R.id.tvcontrol);
        res=(TextView) findViewById(R.id.tvResult);

    }
    public class Calculation{
        private void compute(){
            if(!Double.isNaN(val1)){
                val2=Double.parseDouble(info.getText().toString());

                switch (ACTION){
                    case ADDITION:
                        val1=val1+val2;
                        break;
                    case  SUBTRACTION:
                        val1=val1-val2;
                        break;
                    case MULTIPLICATION:
                        val1=val1*val2;
                        break;
                    case DIVISION:
                        val1=val1/val2;
                        break;
                    case EQL:
                        break;
                }
            }
            else{
                val1=Double.parseDouble(info.getText().toString());
            }
        }
    }
}