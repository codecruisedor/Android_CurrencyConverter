package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    Button euro,pound,dollar,bitcoin,rupee,australian_dollar,canadian_dollar,yen,dinar,
    euro2,pound2,dollar2,bitcoin2,rupee2,australian_dollar2,canadian_dollar2,yen2,dinar2,submit,clear;
    EditText Input;
    TextView result;
    String from="",to="",URL = "";
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
        result.setText(null);
        if (f.getText().toString().equals(t.getText().toString())){
            Toast.makeText(MainActivity.this,"Select two different currencies!",Toast.LENGTH_SHORT).show();
            return;
        }


        if(f == euro){
            from = "euro";
            if(t == rupee2) {
                to = "inr";
            }else if(t == dollar2){
                to = "usd";
            }else if(t == australian_dollar2){
                to = "aud";
            }else if(t == canadian_dollar2){
                to = "cad";
            }else if(t == yen2){
                to = "yen";
            }else if(t == bitcoin2){
                to = "bitcoin";
            }else if(t == pound2){
                to = "pound";
            }else if(t == dinar2){
                to = "dinar";
            }
        }else if(f == pound){
            from = "pound";
            if(t == rupee2) {
                to = "rupee";
            }else if(t == dollar2){
                to = "usd";
            }else if(t == australian_dollar2){
                to = "aud";
            }else if(t == canadian_dollar2){
                to = "cad";
            }else if(t == yen2){
                to = "yen";
            }else if(t == bitcoin2){
                to = "bitcoin";
            }else if(t == euro2){
                to = "euro";
            }else if(t == dinar2){
                to = "dinar";
            }
        }else if(f == dollar){
            from = "dollar";
            if(t == rupee2) {
                to = "rupee";
            }else if(t == pound2){
                to = "pound";
            }else if(t == australian_dollar2){
                to = "aud";
            }else if(t == canadian_dollar2){
                to = "cad";
            }else if(t == yen2){
                to = "yen";
            }else if(t == bitcoin2){
                to = "bitcoin";
            }else if(t == euro2){
                to = "euro";
            }else if(t == dinar2){
                to = "dinar";
            }
        }else if(f == rupee){
            from = "rupee";
            if(t == dollar2) {
                to = "usd";
            }else if(t == pound2){
                to = "pound";
            }else if(t == australian_dollar2){
                to = "aud";
            }else if(t == canadian_dollar2){
                to = "cad";
            }else if(t == yen2){
                to = "yen";
            }else if(t == bitcoin2){
                to = "bitcoin";
            }else if(t == euro2){
                to = "euro";
            }else if(t == dinar2){
                to = "dinar";
            }
        }else if(f == australian_dollar){
            from = "aud";
            if(t == dollar2) {
                to = "usd";
            }else if(t == pound2){
                to = "pound";
            }else if(t == rupee2){
                to = "rupee";
            }else if(t == canadian_dollar2){
                to = "cad";
            }else if(t == yen2){
                to = "yen";
            }else if(t == bitcoin2){
                to = "bitcoin";
            }else if(t == euro2){
                to = "euro";
            }else if(t == dinar2){
                to = "dinar";
            }
        }else if(f == canadian_dollar){
            from = "cad";
            if(t == dollar2) {
                to = "usd";
            }else if(t == pound2){
                to = "pound";
            }else if(t == rupee2){
                to = "rupee";
            }else if(t == australian_dollar2){
                to = "aud";
            }else if(t == yen2){
                to = "yen";
            }else if(t == bitcoin2){
                to = "bitcoin";
            }else if(t == euro2){
                to = "euro";
            }else if(t == dinar2){
                to = "dinar";
            }
        }else if(f == yen){
            from = "yen";
            if(t == dollar2) {
                to = "usd";
            }else if(t == pound2){
                to = "pound";
            }else if(t == rupee2){
                to = "rupee";
            }else if(t == australian_dollar2){
                to = "aud";
            }else if(t == canadian_dollar2){
                to = "cad";
            }else if(t == bitcoin2){
                to = "bitcoin";
            }else if(t == euro2){
                to = "euro";
            }else if(t == dinar2){
                to = "dinar";
            }
        }else if(f == bitcoin){
            from = "bitcoin";
            if(t == dollar2) {
                to = "usd";
            }else if(t == pound2){
                to = "pound";
            }else if(t == rupee2){
                to = "rupee";
            }else if(t == australian_dollar2){
                to = "aud";
            }else if(t == yen2){
                to = "yen";
            }else if(t == euro2){
                to = "euro";
            }else if(t == dinar2){
                to = "dinar";
            }
        }else if(f == dinar){
            from = "dinar";
            if(t == dollar2) {
                to = "usd";
            }else if(t == pound2){
                to = "pound";
            }else if(t == rupee2){
                to = "rupee";
            }else if(t == australian_dollar2){
                to = "aud";
            }else if(t == canadian_dollar2){
                to = "cad";
            }else if(t == yen2){
                to = "yen";
            }else if(t == euro2){
                to = "euro";
            }else if(t == bitcoin2){
                to = "bitcoin";
            }
        }

        new doIT().execute();
    }
    public class doIT extends AsyncTask<Void,Void,Void> {
        String value = "";
        @Override
        protected Void doInBackground(Void... params) {
            try {
                URL = "https://www.google.com/search?q="+Input.getText().toString()+"+"+from+"+"+"to"+"+"+to+"&oq=10+&aqs=chrome.6.69i59j69i57j35i39j0i67i457j0i67l2j0i10i67j69i65.6429j1j7&sourceid=chrome&ie=UTF-8";
                Document document = Jsoup.connect(URL).get();
                Elements elements = document.getElementsByClass("DFlfde SwHCTb");
                for (Element element: elements){
                    value = String.valueOf(element.text());
                }
            } catch (IOException e) {
                e.printStackTrace();
            } return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            result.setText(value);
            super.onPostExecute(aVoid);
        }
    }
}