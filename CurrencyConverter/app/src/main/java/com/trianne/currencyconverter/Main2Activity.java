package com.trianne.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    Keys keys;
    private Conversion conversion;
    private TextView rp, usd, yen, euro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final TextView currency = (TextView) findViewById(R.id.currency);
        euro = (TextView) findViewById(R.id.euro);
        rp = findViewById(R.id.rp);
        yen = findViewById(R.id.yen);
        usd = findViewById(R.id.usd);
        Button submit = (Button) findViewById(R.id.submit);

        final Bundle extras = getIntent().getExtras();

        if (extras != null) {
            submit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    double inputCurrency = 0;
                    String inputtedText = ((EditText) findViewById(R.id.input)).getText().toString();

                    if(inputtedText.isEmpty()) {
                        Toast.makeText(
                                Main2Activity.this,
                                "Please input the value!" +inputtedText,
                                Toast.LENGTH_SHORT).show();
                    } else {
                        inputCurrency = Double.parseDouble(inputtedText);
                        convertCurrency(extras, inputCurrency);
                        showConvertedCurrency();
                    }
                }
            });
        }
    }

   private void convertCurrency(Bundle extras, double inputCurrency) {
        if (extras.get(keys.RUPIAH) != null) {
            this.conversion = new Conversion(keys.RUPIAH, inputCurrency);
        } else if (extras.get(keys.USD) != null) {
            this.conversion = new Conversion(keys.USD, inputCurrency);
        } else if (extras.get(keys.YEN) != null) {
            this.conversion = new Conversion(keys.YEN, inputCurrency);
        } else if (extras.get(keys.EURO) != null) {
            this.conversion = new Conversion(keys.EURO, inputCurrency);
        } else {
            Toast.makeText(Main2Activity.this, "NO EXTRAS", Toast.LENGTH_SHORT).show();
        }
    }

    private void showConvertedCurrency() {
        this.rp.setText("Rupiah = " + this.conversion.getRupiah());
        this.usd.setText("USD = " + this.conversion.getUsd());
        this.euro.setText("Euro = " + this.conversion.getEuro());
        this.yen.setText("Yen = " + this.conversion.getYen());
    }

    public void onBtnBack(View view) {
        finish();
    }
}
