package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
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

    Button submit, clear;
    EditText Input;
    TextView result;
    String URL = "";
    AutoCompleteTextView autoCompleteTextView_currency1, autoCompleteTextView_currency2;
    String[] array_of_currencies = {"UAE Dirham",
            "Afghani",
            "Lek",
            "Armeniam Dram",
            "Netherlands Antillian Guilder",
            "Kwanza",
            "Argentine Peso",
            "Australian Dollar",
            "Aruban Florin",
            "Azerbaijanian Manat",
            "Convertible Mark",
            "Barbados Dollar",
            "Taka",
            "Bulgarian Lev",
            "Bahraini Dinar",
            "Burundi Franc",
            "Bermudian Dollar",
            "Brunei Dollar",
            "Boliviano",
            "Brazilian Real",
            "Bahamian Dollar",
            "Ngultrum",
            "Pula",
            "Belarusian Ruble",
            "Belize Dollar",
            "Canadian Dollar",
            "Congolese Franc",
            "Swiss Franc",
            "Swiss Franc",
            "Chilean Peso",
            "Yuan Renminbi",
            "Colombian Peso",
            "Costa Rican Colón",
            "Cuban Peso",
            "Cabo Verde Escudo",
            "Czech Koruna",
            "Djibouti Franc",
            "Danish Krone",
            "Dominican Peso",
            "Algerian Dinar",
            "Egyptian Pound",
            "Nakfa",
            "Ethiopian Birr",
            "Euro",
            "Fiji Dollar",
            "Falkland Islands Pound",
            "Pound Sterling",
            "Lari",
            "Ghana Cedi",
            "Gibraltar Pound",
            "Dalasi",
            "Guinea Franc",
            "Quetzal",
            "Guyana Dollar",
            "Hong Kong Dollar",
            "Lempira",
            "Croatian Kuna",
            "Gourde",
            "Forint",
            "Rupiah",
            "New Israeli Sheqel",
            "Indian Rupee",
            "Iraqi Dinar",
            "Iranian Rial",
            "Iceland Króna",
            "Jamaican Dollar",
            "Jordanian Dinar",
            "Yen",
            "Kenyan Shilling",
            "Som",
            "Riel",
            "Comoro Franc",
            "North Korean Won",
            "Won",
            "Kuwaiti Dinar",
            "Cayman Islands Dollar",
            "Tenge",
            "Kip",
            "Lebanese Pound",
            "Sri Lanka Rupee",
            "Liberian Dollar",
            "Loti",
            "Libyan Dinar",
            "Moroccan Dirham",
            "Moroccan Dirham",
            "Moldovan Leu",
            "Malagasy Ariary",
            "Denar",
            "Kyat",
            "Tugrik",
            "Patac",
            "Ouguiya",
            "Mauritius Rupee",
            "Rufiyaa",
            "Malawi Kwacha",
            "Mexican Peso",
            "Malaysian Ringgit",
            "Metical",
            "Namibian Dollar",
            "Naira",
            "Córdoba Oro",
            "rwegian Krone",
            "Nepalese Rupee",
            "New Zealand Dollar",
            "Rial Omani",
            "Balboa",
            "Sol",
            "Kina",
            "Philippine Peso",
            "Pakistan Rupee",
            "Zloty",
            "Guaraní",
            "Qatari Rial",
            "Romanian Leu",
            "Serbian Dinar",
            "Russian Ruble",
            "Rwanda Franc",
            "Saudi Riyal",
            "Solomon Islands Dollar",
            "Seychelles Rupee",
            "Sudanese Pound",
            "Swedish Krona",
            "Singapore Dollar",
            "Saint Helena Pound",
            "Leone",
            "Somali Shilling",
            "Suriname Dollar",
            "South Sudanese Pound",
            "Dobra",
            "Syrian Pound",
            "Lilangeni",
            "Baht",
            "Somoni",
            "Turkmenistan New Manat",
            "Tunisian Dinar",
            "anga",
            "Turkish Lira",
            "Trinidad and Tobago Dollar",
            "New Taiwan Dollar",
            "Tanzanian Shilling",
            "Hryvnia",
            "Uganda Shilling",
            "US Dollar",
            "Peso Uruguayo",
            "Uzbekistan Sum",
            "Bolívar",
            "Dong",
            "Vatu",
            "Tala",
            "CFA Franc (BEAC)",
            "East Caribbean Dollar",
            "East Caribbean Dollar",
            "CFA Franc (BCEAO)",
            "CFP Franc",
            "Yemeni Rial",
            "Rand",
            "Zambian Kwacha",
            "Zimbabwe Dollar"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView_currency1 = findViewById(R.id.autoComplete_currency1);
        autoCompleteTextView_currency2 = findViewById(R.id.autoComplete_currency2);
        submit = findViewById(R.id.submit_button);

        Input = findViewById(R.id.editText);
        result = findViewById(R.id.textView);
        clear = findViewById(R.id.clear_button);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.support_simple_spinner_dropdown_item,array_of_currencies);

        autoCompleteTextView_currency1.setAdapter(adapter);
        autoCompleteTextView_currency2.setAdapter(adapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    ConvertCurrency();
            }


        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                autoCompleteTextView_currency1.setText("");
                autoCompleteTextView_currency2.setText("");
                result.setText("");
                Input.setText("");

            }

        });
    }
    public void ConvertCurrency(){

        new doIT().execute();
    }

    public class doIT extends AsyncTask<Void, Void, Void> {
        String value = "";

        @Override
        protected Void doInBackground(Void... params) {
            try {
                URL = "https://www.google.com/search?q=" + Input.getText().toString() + "+" + autoCompleteTextView_currency1.getText().toString() + "+" + "to" + "+" + autoCompleteTextView_currency2.getText().toString() + "&oq=10+&aqs=chrome.6.69i59j69i57j35i39j0i67i457j0i67l2j0i10i67j69i65.6429j1j7&sourceid=chrome&ie=UTF-8";
                Document document = Jsoup.connect(URL).get();
                Elements elements = document.getElementsByClass("DFlfde SwHCTb");
                for (Element element : elements) {
                    value = String.valueOf(element.text());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            result.setText(value);
            super.onPostExecute(aVoid);
        }
    }

}