package com.trianne.intentcoba;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            String name = extras.getString("NAMA");

            TextView welcomeText = (TextView) findViewById(R.id.textViewWelcome);
            welcomeText.setText("Welcome"+name);
            Toast.makeText(getApplication(), name, Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickCall (View view){
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:081932698624"));
        startActivity(i);
    }

    public void onClickGallery (View view){
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setType("image/*");
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}
