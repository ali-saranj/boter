package com.example.bottle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

public class setind extends AppCompatActivity {

    Button btn;
    int    imgD;
    ImageView image1,image2,image3,image4;
    RadioButton rb8,rb4,rb2;
    int tdad = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setind);

        btn = findViewById(R.id.btn_save);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        rb2 = findViewById(R.id.rb2);
        rb4 = findViewById(R.id.rb4);
        rb8 = findViewById(R.id.rb8);

        imgD = R.drawable.bottle;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rb2.isChecked())
                    tdad = 4;
                else if (rb4.isChecked())
                    tdad = 2;
               else if (rb8.isChecked())
                    tdad = 1;

                Intent intent = new Intent(setind.this, MainActivity.class);
                finish();
                intent.putExtra("imgD", imgD);
                intent.putExtra("tdad",tdad);
                startActivity(intent);
            }
        });

    }

    public void imgclick(View view) {
        ImageView imageView = (ImageView) view;
        image1.setBackground(null);
        image2.setBackground(null);
        image3.setBackground(null);
        image4.setBackground(null);
        imageView.setBackgroundColor(Color.GREEN);
        switch (Integer.parseInt(imageView.getTag().toString())) {
            case 1:
                imgD = R.drawable.fanta;
                break;
            case 2:
                imgD = R.drawable.bottle;
                break;
            case 3:
                imgD = R.drawable.coca;
                break;
            case 4:
                imgD = R.drawable.tabar;
                break;
            default:
                break;
        }

    }
}