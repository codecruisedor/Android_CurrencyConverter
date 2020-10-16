package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button euro,pound,dollar,bitcoin,rupee,australian_dollar,canadian_dollar,yen,dinar,
    euro2,pound2,dollar2,bitcoin2,rupee2,australian_dollar2,canadian_dollar2,yen2,dinar2,submit,clear;
    EditText Input;
    TextView result;
    ArrayList<Button> pressedButtons1,pressedButtons2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pressedButtons1 = new ArrayList<>();
        pressedButtons2 = new ArrayList<>();


        euro = findViewById(R.id.euro);
        pound = findViewById(R.id.pound);
        dollar = findViewById(R.id.dollar);
        bitcoin = findViewById(R.id.bitcoin);
        rupee = findViewById(R.id.rupee);
        australian_dollar = findViewById(R.id.australian_dollar);
        canadian_dollar = findViewById(R.id.canadian_dollar);
        yen = findViewById(R.id.yen);
        dinar = findViewById(R.id.dinar);

        euro2 = findViewById(R.id.euro2);
        pound2 = findViewById(R.id.pound2);
        dollar2= findViewById(R.id.dollar2);
        bitcoin2 = findViewById(R.id.bitcoin2);
        rupee2 = findViewById(R.id.rupee2);
        australian_dollar2 = findViewById(R.id.australian_dollar2);
        canadian_dollar2 = findViewById(R.id.canadian_dollar2);
        yen2 = findViewById(R.id.yen2);
        dinar2 = findViewById(R.id.dinar2);
        submit = findViewById(R.id.submit_button);

        Input = findViewById(R.id.editText);
        result = findViewById(R.id.textView);
        clear = findViewById(R.id.clear_button);

        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process(euro);
            }
        });

        pound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process(pound);
            }
        });
        dollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process(dollar);
            }
        });
        bitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process(bitcoin);
            }
        });
        rupee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process(rupee);
            }
        });
        australian_dollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process(australian_dollar);
            }
        });
        canadian_dollar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process(canadian_dollar);
            }
        });
        yen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process(yen);
            }
        });
        dinar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process(dinar);
            }
        });

        euro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process2(euro2);
            }
        });
        pound2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process2(pound2);
            }
        });
        dollar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process2(dollar2);
            }
        });

        rupee2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process2(rupee2);
            }
        });
        bitcoin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process2(bitcoin2);
            }
        });
        australian_dollar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process2(australian_dollar2);
            }
        });
        canadian_dollar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process2(canadian_dollar2);
            }
        });
        dinar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button_clicked_process2(dinar2);
            }
        });
        yen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               button_clicked_process2(yen2);
            }
        });


        //do for every

       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Button fromCurrency = pressedButtons1.get(0);
               Button toCurrency = pressedButtons2.get(0);
               if(fromCurrency == toCurrency){
                   Context context = getApplicationContext();
                   CharSequence text = "Please select different currencies to convert";
                   int duration = Toast.LENGTH_SHORT;

                   Toast toast = Toast.makeText(context, text, duration);
                   toast.show();
               }else{
                   ConvertCurrency(fromCurrency,toCurrency);
               }

           }


       });
       clear.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               result.setText("0.00");
               Input.setText(null);
               if(!pressedButtons1.isEmpty()){
                   pressedButtons1.get(0).setBackgroundColor(getResources().getColor(R.color.defaultColor));
                   pressedButtons1.clear();
               }
               if(!pressedButtons2.isEmpty()){
                   pressedButtons2.get(0).setBackgroundColor(getResources().getColor(R.color.defaultColor));
                   pressedButtons2.clear();
               }
           }
       });

    }
    public void button_clicked_process(Button b){
        b.setBackgroundColor(getResources().getColor(R.color.buttonPressed));
        if(!pressedButtons1.isEmpty()){
            pressedButtons1.get(0).setBackgroundColor(getResources().getColor(R.color.defaultColor));
            pressedButtons1.remove(0);
        }
        pressedButtons1.add(b);
    }


    public void button_clicked_process2(Button b){
        b.setBackgroundColor(getResources().getColor(R.color.buttonPressed));
        if(!pressedButtons2.isEmpty()){
            pressedButtons2.get(0).setBackgroundColor(getResources().getColor(R.color.defaultColor));
            pressedButtons2.remove(0);
        }
        pressedButtons2.add(b);
    }


    public void ConvertCurrency(Button f,Button t){
        String input =  Input.getText().toString();
        if(TextUtils.isEmpty(input)){
            Input.setError("Empty User Input");
        }
        DecimalFormat number_format = new DecimalFormat("#.00");
        result.setText(null);
        double i = Double.parseDouble(input);
        double res = 0;


        if(f == euro){
            if(t == rupee2) {
                res = i*86.14;
            }else if(t == dollar2){
                res = i*1.17;
            }else if(t == australian_dollar2){
                res = i*1.66;
            }else if(t == canadian_dollar2){
                res = i*1.54;
            }else if(t == yen2){
                res = i*123.35;
            }else if(t == bitcoin2){
                res = i*0.0001030265;
            }else if(t == pound2){
                res = i*0.90;
            }else if(t == dinar2){
                res = i*4.30;
            }
        }else if(f == pound){
            if(t == rupee2) {
                res = i*94.88;
            }else if(t == dollar2){
                res = i*1.29;
            }else if(t == australian_dollar2){
                res = i*1.82;
            }else if(t == canadian_dollar2){
                res = i*1.71;
            }else if(t == yen2){
                res = i*136.12;
            }else if(t == bitcoin2){
                res = i*0.00011;
            }else if(t == euro2){
                res = i*1.10;
            }else if(t == dinar2){
                res = i*4.74;
            }
        }else if(f == dollar){
            if(t == rupee2) {
                res = i*73.45;
            }else if(t == pound2){
                res = i*0.77;
            }else if(t == australian_dollar2){
                res = i*1.41;
            }else if(t == canadian_dollar2){
                res = i*1.32;
            }else if(t == yen2){
                res = i*105.39;
            }else if(t == bitcoin2){
                res = i*0.000087;
            }else if(t == euro2){
                res = i*0.86;
            }else if(t == dinar2){
                res = i*3.67;
            }
        }else if(f == rupee){
            if(t == dollar2) {
                res = i*0.014;
            }else if(t == pound2){
                res = i*0.011;
            }else if(t == australian_dollar2){
                res = i*0.019;
            }else if(t == canadian_dollar2){
                res = i*0.018;
            }else if(t == yen2){
                res = i*1.43;
            }else if(t == bitcoin2){
                res = i*0.0000012;
            }else if(t == euro2){
                res = i*0.012;
            }else if(t == dinar2){
                res = i*0.050;
            }
        }else if(f == australian_dollar){
            if(t == dollar2) {
                res = i*0.71;
            }else if(t == pound2){
                res = i*0.55;
            }else if(t == rupee2){
                res = i*52.03;
            }else if(t == canadian_dollar2){
                res = i*0.94;
            }else if(t == yen2){
                res = i*74.65;
            }else if(t == bitcoin2){
                res = i*0.000062;
            }else if(t == euro2){
                res = i*0.61;
            }else if(t == dinar2){
                res = i*2.60;
            }
        }else if(f == canadian_dollar){
            if(t == dollar2) {
                res = i*0.71;
            }else if(t == pound2){
                res = i*0.55;
            }else if(t == rupee2){
                res = i*52.03;
            }else if(t == australian_dollar2){
                res = i*0.94;
            }else if(t == yen2){
                res = i*74.65;
            }else if(t == bitcoin2){
                res = i*0.000062;
            }else if(t == euro2){
                res = i*0.61;
            }else if(t == dinar2){
                res = i*2.60;
            }
        }else if(f == yen){
            if(t == dollar2) {
                res = i*0.0095;
            }else if(t == pound2){
                res = i*0.0073;
            }else if(t == rupee2){
                res = i*0.70;
            }else if(t == australian_dollar2){
                res = i*0.013;
            }else if(t == canadian_dollar2){
                res = i*0.013;
            }else if(t == bitcoin2){
                res = i*0.00;
            }else if(t == euro2){
                res = i*0.0081;
            }else if(t == dinar2){
                res = i*0.035;
            }
        }else if(f == bitcoin){
            if(t == dollar2) {
                res = i*11382;
            }else if(t == pound2){
                res = i*8812.68;
            }else if(t == rupee2){
                res = i*836052.29;
            }else if(t == australian_dollar2){
                res = i*16073.66 ;
            }else if(t == canadian_dollar2){
                res = i*15063.22 ;
            }else if(t == yen2){
                res = i*1199543.29;
            }else if(t == euro2){
                res = i*9731.61 ;
            }else if(t == dinar2){
                res = i *41802.80;
            }
        }else if(f == dinar){
            if(t == dollar2) {
                res = i*0.27;
            }else if(t == pound2){
                res = i*0.21;
            }else if(t == rupee2){
                res = i*20.00;
            }else if(t == australian_dollar2){
                res = i*0.38;
            }else if(t == canadian_dollar2){
                res = i*0.36;
            }else if(t == yen2){
                res = i*28.69;
            }else if(t == euro2){
                res = i*0.23;
            }else if(t == bitcoin2){
                res = i *0.000024;
            }
        }

        result.setText(""+number_format.format(res));
    }
}