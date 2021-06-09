package com.example.bottle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Darbarema extends AppCompatActivity {

    Button       btn_email;
    MenuInflater inflater1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_darbarema);

        btn_email = findViewById(R.id.bt_email);
        inflater1 = getMenuInflater();

        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] EMAIL_ADRAS = {"ali.saranj1384@gmail.com"};
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, EMAIL_ADRAS);
//                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
//                intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        inflater1.inflate(R.menu.button,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public void click(MenuItem item) {
        startActivity(new Intent(Darbarema.this,MainActivity.class));
    }
}