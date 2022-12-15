package com.example.e_randevu;

import
        androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

   Button btn;
   Intent i;
   EditText metin;
   String mtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.giris);


    }
    public void dene (View v){
        i=new Intent(this,randActivity2.class);
        metin=(EditText)findViewById(R.id.etMusteri) ;
        mtn=metin.getText().toString();
        if(!TextUtils.isEmpty(mtn)){
            i.putExtra("musteriad", mtn);
            startActivity(i);


        }
        else{

            Toast.makeText(getApplicationContext(),"Lütfen Adınızı Giriniz", Toast.LENGTH_SHORT).show();
        }

    }
}