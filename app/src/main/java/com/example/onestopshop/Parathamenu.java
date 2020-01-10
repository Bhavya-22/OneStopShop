package com.example.onestopshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Parathamenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parathamenu);
        Intent intent=getIntent();
        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.parantha1);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openparantha1();
            }
        });
        LinearLayout linearLayout1=(LinearLayout)findViewById(R.id.parantha2);
        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openparantha2();
            }
        });
        LinearLayout linearLayout2=(LinearLayout)findViewById(R.id.parantha3);
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openparantha3();
            }
        });
    }

    public void openparantha1(){
        Intent intent= new Intent(Parathamenu.this,Parantha1.class);
        startActivity(intent);
        finish();
    }
    public void openparantha2(){
        Intent intent= new Intent(Parathamenu.this,parantha2.class);
        startActivity(intent);
        finish();
    }
    public void openparantha3(){
        Intent intent= new Intent(Parathamenu.this,parantha3.class);
        startActivity(intent);
        finish();
    }
}
