package com.example.combined_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    private ArrayList<Fruit> fruitList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Fruit fruit);
    }

    public FruitAdapter(ArrayList<Fruit> fruitList, OnItemClickListener listener) {
        this.fruitList = fruitList;
        this.listener = listener;
    }

    @Override
    public FruitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fruit_item, parent, false);
        return new FruitViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FruitViewHolder holder, int position) {
        Fruit fruit = fruitList.get(position);
        holder.fruitName.setText(fruit.getName());
        holder.fruitImage.setImageResource(fruit.getImageResource());

        holder.itemView.setOnClickListener(v -> listener.onItemClick(fruit));
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }

    public static class FruitViewHolder extends RecyclerView.ViewHolder {

        public TextView fruitName;
        public ImageView fruitImage;

        public FruitViewHolder(View itemView) {
            super(itemView);
            fruitName = itemView.findViewById(R.id.fruitName);
            fruitImage = itemView.findViewById(R.id.fruitImage);
        }
    }
}
