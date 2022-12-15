package com.example.e_randevu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class randActivity2 extends AppCompatActivity {
    Button btn9, btn10, btn11, btn12, btn1, btn2, btn3, btn4, rapor;
    CalendarView takvim;
    TextView goster, goster2;
    String tarih, saat, goster1, goster3;
    Intent e;
    public String musteriAd,tarih1,saat1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rand2);
        Intent i = getIntent();
        musteriAd= i.getStringExtra("musteriad");
        Toast.makeText(getApplicationContext(), "Hoşgeldin " +musteriAd, Toast.LENGTH_SHORT).show();

        btn9 = (Button) findViewById(R.id.btnsaat9);
        btn10 = (Button) findViewById(R.id.btnsaat10);
        btn11 = (Button) findViewById(R.id.btnsaat11);
        btn12 = (Button) findViewById(R.id.btnsaat12);
        btn1 = (Button) findViewById(R.id.btnsaat1);
        btn2 = (Button) findViewById(R.id.btnsaat2);
        btn3 = (Button) findViewById(R.id.btnsaat3);
        btn4 = (Button) findViewById(R.id.btnsaat4);
        goster = (TextView) findViewById(R.id.zaman);
        goster2 = (TextView) findViewById(R.id.zaman2);
        takvim = (CalendarView) findViewById(R.id.tkvm);
        rapor = (Button) findViewById(R.id.btnrandevu3);


        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goster2.setText("Seçtiğiniz Saat: " + btn9.getText().toString());
                saat1=btn9.getText().toString();

            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goster2.setText("Seçtiğiniz Saat: " + btn10.getText().toString());
                saat1=btn10.getText().toString();
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goster2.setText("Seçtiğiniz Saat: " + btn11.getText().toString());
                saat1=btn11.getText().toString();
            }
        });
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goster2.setText("Seçtiğiniz Saat: " + btn11.getText().toString());
                saat1=btn11.getText().toString();
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goster2.setText("Seçtiğiniz Saat: " + btn12.getText().toString());
                saat1=btn12.getText().toString();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goster2.setText("Seçtiğiniz Saat: " + btn1.getText().toString());
                saat1=btn1.getText().toString();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goster2.setText("Seçtiğiniz Saat: " + btn2.getText().toString());
                saat1=btn2.getText().toString();

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goster2.setText("Seçtiğiniz Saat: " + btn3.getText().toString());
                saat1=btn3.getText().toString();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goster2.setText("Seçtiğiniz Saat: " + btn4.getText().toString());
                saat1=btn4.getText().toString();
            }
        });
        takvim.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int yıl, int ay, int gun) {
                ay++;
                goster.setText("Seçtiğiniz Tarih: " + gun + "/" + ay + "/" + yıl);
                tarih1=(gun + "/" + ay + "/" + yıl);

            }
        });

    }

    public void kayıt(View v){
       goster1=goster.getText().toString() ;
       goster3=goster2.getText().toString();
        if(!TextUtils.isEmpty(goster1)){
            if(!TextUtils.isEmpty(goster3)){

                //veri tabanı kaydı
                try {
                    SQLiteDatabase db =this.openOrCreateDatabase("Randevu",MODE_PRIVATE,null);
                    db.execSQL("CREATE TABLE IF NOT EXISTS randevular (id INTEGER PRIMARY KEY,musteriAdi VARCHAR,tarih VARCHAR,saat VARCHAR)");
                    String sqlSorgu="INSERT  INTO randevular (musteriAdi,tarih,saat) VALUES(?,?,?)";
                    SQLiteStatement statement=db.compileStatement(sqlSorgu);
                    statement.bindString(1,musteriAd);
                    statement.bindString(2,saat1);
                    statement.bindString(3,tarih1);
                    statement.execute();

                    Toast.makeText(getApplicationContext(),"Randevu Alındı",Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                 e.printStackTrace();
                }
            }
        }
        else{
            Toast.makeText(getApplicationContext(),"Tarih Ve Saat Seçiniz",Toast.LENGTH_SHORT).show();
        }
    }
    public  void kytgor(View v){
        Intent e=new Intent(this,raporActivity.class);
        startActivity(e);



    }



}

