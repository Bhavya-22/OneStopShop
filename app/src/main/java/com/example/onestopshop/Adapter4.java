package com.example.onestopshop;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.example.onestopshop.R;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Adapter4 extends RecyclerView.Adapter<Adapter4.MyViewHolder> {

    Context context;
    ArrayList<Items4> items4;

    public Adapter4(Context context, ArrayList<Items4> items4) {
        this.context = context;
        this.items4 = items4;
    }

    @NonNull
    @Override
    public Adapter4.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_items4, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter4.MyViewHolder holder, final int position) {
        Items4 item=items4.get(position);
        holder.name.setText(item.getName());
        holder.price.setText(items4.get(position).getPrice());
        Picasso.get().load(items4.get(position).getProfilePic()).into(holder.profilePic);

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, pavbhaji.class);
                intent.putExtra("pav bhaji", (Serializable) items4.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items4.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, price;
        ImageView profilePic;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, pavbhaji.class);
                    intent.putExtra("pav bhaji",(Serializable) items4.get(getAdapterPosition()));
                    context.startActivity(intent);
                }

            });
            price = (TextView) itemView.findViewById(R.id.price);
            profilePic = (ImageView) itemView.findViewById(R.id.profilePic);

        }


    }


}

