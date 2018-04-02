package com.trianne.intentcoba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickNext(View view){
        try {
            EditText buttonNext = (EditText) findViewById(R.id.editTextData);
            String name = buttonNext.getText().toString();
            if (! name.isEmpty()){
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra(KEY_NAME, name);
                startActivity(i);
            }
            else {
                Toast.makeText(getApplication(), "Masukkan nama", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), "Error, coba lagi", Toast.LENGTH_SHORT).show();
        }
    }
}
