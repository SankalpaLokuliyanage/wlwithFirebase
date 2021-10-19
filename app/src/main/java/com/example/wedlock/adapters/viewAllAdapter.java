package com.example.wedlock.adapters;

import android.content.Context;
import android.content.Intent;
import android.opengl.GLU;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.wedlock.R;
import com.example.wedlock.activities.DetailedActivity;
import com.example.wedlock.activities.ViewAllActivity;
import com.example.wedlock.models.viewAllModel;

import java.util.List;

public class viewAllAdapter extends RecyclerView.Adapter<viewAllAdapter.ViewHolder> {

    Context context;
    List<viewAllModel> list;

    public viewAllAdapter(Context context, List<viewAllModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_all_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(list.get(position).getImg_url()).into(holder.imageView);
        holder.name.setText(list.get(position).getName());
        holder.description.setText(list.get(position).getDescription());
        holder.price.setText(list.get(position).getPrice());
        holder.number.setText(list.get(position).getNumber());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailedActivity.class);
                intent.putExtra("detail", list.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView name, description, price, number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.viewall_img);
            name = itemView.findViewById(R.id.viewall_name);
            description = itemView.findViewById(R.id.viewall_description);
            price = itemView.findViewById(R.id.viewall_price);
            number = itemView.findViewById(R.id.viewall_mobile);

        }
    }
}
