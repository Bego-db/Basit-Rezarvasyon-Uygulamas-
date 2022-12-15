package com.example.e_randevu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.filament.View;

import java.util.Collections;

public class raporActivity extends AppCompatActivity {
    ListView liste;
    ArrayAdapter ad_adapter;
    ArrayAdapter tarih_adapter;
    ArrayAdapter saat_adapter;
    String ad,tarih,saat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapor);
         Intent e=getIntent();




    }



}