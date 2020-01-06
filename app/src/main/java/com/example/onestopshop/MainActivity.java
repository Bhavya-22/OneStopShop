package com.example.onestopshop;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        Button button = (Button) findViewById(R.id.Stationary);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();

            }
        });
        Button button1 = (Button) findViewById(R.id.cafe);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();

            }
        });
        Button button2 = (Button) findViewById(R.id.canteen);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCanteen();

            }
        });
        Button button3 = (Button) findViewById(R.id.stalls);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStalls();

            }
        });}



            public void openActivity2(){
                Intent intent = new Intent(this, Activity2.class);
                startActivity(intent);
            }
    public void openActivity3(){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
    public void openCanteen() {
                Intent intent = new Intent(this, Canteen.class);
                startActivity(intent);
    }
    public void openStalls() {
        Intent intent = new Intent(this, Stalls.class);
        startActivity(intent);

    }


    }
