package com.example.onestopshop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Stallslist extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<Items4> list;
    Adapter4 adapter;
    private static final String TAG = "Stallslist";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stallslistlayout);
        Intent intent= getIntent();
        list=new ArrayList<>();
        adapter=new Adapter4(Stallslist.this,list);
        recyclerView = (RecyclerView) findViewById(R.id.myRecycler);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        reference = FirebaseDatabase.getInstance().getReference().child("Items4");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<Items4>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {   Items4 p=dataSnapshot1.getValue(Items4.class);
                    Log.d(TAG, "onDataChange: "+p.getName() + " " +p.getPrice() + " " +p.getProfilePic());
                    list.add(p);
                }
                adapter = new Adapter4(Stallslist.this,list);
                Log.d(TAG, "onDataChange: "+list.size());
               recyclerView.setAdapter(adapter);

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d(TAG, "onCancelled: ");
                Toast.makeText(Stallslist.this,databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
