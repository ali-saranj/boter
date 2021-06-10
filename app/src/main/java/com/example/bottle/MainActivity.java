package com.example.bottle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.security.SecureRandom;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button    btn_h, btn_g;
    View           layout;
    SecureRandom   random = new SecureRandom();
    LayoutInflater inflater;
    MenuInflater   inflater1;

    final String[] H = {"آیا تاکنون شخص دیگری را به خاطر کاری که خودت انجام داده ای مقصر کرده ای؟","چه نیروی خارق العاده ای دوس داشتی که داشته باشی؟","چگونه با استرس و فشار مقابله می کنی؟","","اگه میتونستی تا اخر عمر یک سن ثابت داشته باشی چندسالگی بود؟","از چه عاملی در زندگی شخصی بیشترین ترس را داری؟", "اگر به گذشته برگردی چه چیزی را تغییر میدی؟", "بهترین دروغی که تو زندگیت گفتی چی بوده؟", "آیا تا به حال به خاطر ظاهر یا شخصیتی که داری مورد قضاوت قرار گرفتی؟", "اگر میتونستی ذهنیت یک نفر را درمورد خودت تغییر بدی چه کسی را انتخاب می کردی؟", "ترسناک ترین خوابی که تا به حال دیده ای چه بوده است؟", "نفرت انگیزترین عادت تو چیست؟", "شرم آورترین لحظه زندگی ات کدام لحظه بوده است؟", "احمقانه ترین کاری که مقابل آینه انجام داده ای چه کاری بوده است؟", "بهترین روز زندگی ات چه روزی بوده است؟"};
    final String[] G = {"باصدای بلند بخندید."," یک تکه صابون را لیس بزنید.","ده دقیقه تمام به طور مداوم صحبت کنید."," با یکی از دوستان خود تماس بگیرید و با او جدی دعوا کنید.","3 لیوان بزرگ آب را بدون توقف بنوشید.","زشت ترین عکس تان را به عنوان عکس پروفایل خود قرار دهید.","محتویات کیف خود را به افراد دیگر نشان دهید.","با پدر یا مادرت تماس بگیر و بگو ازش متنفری!", "به مدت یک دقیقه بدون موسیقی برقص", "یکی از شرکت کنندگان را انتخاب کن تا به تو سیلی بزند", "یک دقیقه کامل پلک نزن", "یکی از شرکت کنندگان تو را قلقلک بدهد و سعی کن نخندی", "2 دقیقه بدون دلیل قهقه بزن و بخند", "اولین آهنگی که به ذهنت میاد را بخون", "یک لیوان سرکه را با نمک ترکیب کن و بخور"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.setProperty("https.protocols", "TLSv1.1");

        imageView = findViewById(R.id.img);
        layout = findViewById(R.id.la);
        btn_g = findViewById(R.id.btn_g);
        btn_h = findViewById(R.id.btn_h);

        layout.setVisibility(View.GONE);
        inflater = getLayoutInflater();

        Intent intent = getIntent();

        imageView.setImageResource(intent.getIntExtra("imgD",R.drawable.bottle));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int rotation = random.nextInt(40) + 10;
                imageView.animate().rotation((45 * intent.getIntExtra("tdad",1)) * (rotation/intent.getIntExtra("tdad",1)) + imageView.getRotation()).setDuration(2*(30 * rotation)*(intent.getIntExtra("tedad",1)));
                layout.setVisibility(View.VISIBLE);

            }
        });
        btn_h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.GONE);
                buildD(H[(random.nextInt(H.length))]);
            }
        });
        btn_g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layout.setVisibility(View.GONE);
                buildD(G[(random.nextInt(G.length))]);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        inflater1 = getMenuInflater();
        inflater1.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.seting:
                startActivity(new Intent(MainActivity.this,setind.class));
                finish();
                break;
            case R.id.darbare:
                startActivity(new Intent(MainActivity.this,Darbarema.class));
                finish();
                break;
            case R.id.amti:
                openApp();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void buildD(String text) {
        View view = inflater.inflate(R.layout.cc, findViewById(R.id.pa));
        Dialog dialog = new Dialog(this);
        TextView tv = view.findViewById(R.id.tv);
        tv.setText(text);
        dialog.setContentView(view);
        dialog.show();

    }

    public void openApp(){

        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("ir.mservices.market");
        if (launchIntent != null) {
            String url = "https://myket.ir/app/info.medrick.babashah";
            if (!url.startsWith("https://") && !url.startsWith("http://")) {
                url = "http://" + url;

                Intent openUrlIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(openUrlIntent);
            }
        }else {
            String q = "دانلود مایکت";
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
            intent.putExtra(SearchManager.QUERY, q);
            startActivity(intent);
        }

    }
}