package com.sun.tino.recyclerviewdemo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<EmailData> data;
    private Context context;

    public Adapter(ArrayList<EmailData> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater mLayoutInflater = LayoutInflater.from(context);
        View itemView = mLayoutInflater.inflate(R.layout.item_row, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {
        viewHolder.text_title.setText(data.get(i).getTitle());
        viewHolder.text_content.setText(data.get(i).getContent());
        viewHolder.text_time.setText(data.get(i).getTime());
        boolean isFavorite = data.get(i).isFavorite();
        if(isFavorite) viewHolder.button_favorite.setImageResource(R.drawable.favorite_start_1);
        else viewHolder.button_favorite.setImageResource(R.drawable.favorite_start);
        //Click to add or remove favorite
        viewHolder.button_favorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(data.get(i).isFavorite()) data.get(i).setFavorite(false);
                else data.get(i).setFavorite(true);
                notifyDataSetChanged();
            }
        });
    }

    public void removeItem(int position){
        data.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView text_title, text_content, text_time;
        ImageButton button_favorite;

        ViewHolder(@NonNull final View itemView) {
            super(itemView);
            text_title = itemView.findViewById(R.id.text_title);
            text_content = itemView.findViewById(R.id.text_content);
            text_time = itemView.findViewById(R.id.text_time);
            button_favorite = itemView.findViewById(R.id.button_favorite);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    removeItem(getAdapterPosition());
                    Toast.makeText(itemView.getContext(), "Removed!", Toast.LENGTH_SHORT).show();
                    return false;
                }
            });
        }
    }
}
