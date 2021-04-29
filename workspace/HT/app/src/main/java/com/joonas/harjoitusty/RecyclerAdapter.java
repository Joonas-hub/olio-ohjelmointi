package com.joonas.harjoitusty;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    // Adapter for displaying the logfile in a recycler view.
    private ArrayList<String> dateArray;
    private ArrayList<String> meatArray;
    private ArrayList<String> vegArray;
    private ArrayList<String> emissionArray;

    public RecyclerAdapter(ArrayList<String> dateArray, ArrayList<String> meatArray, ArrayList<String> vegArray, ArrayList<String> emissionArray){
        this.dateArray = dateArray;
        this.meatArray = meatArray;
        this.vegArray = vegArray;
        this.emissionArray = emissionArray;
    }

    @Override
    public int getItemViewType(final int position){
        return R.layout.recycler_layout;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.getDateTextView().setText(dateArray.get(position));
        holder.getMeatTextView().setText(meatArray.get(position));
        holder.getVegTextView().setText(vegArray.get(position));
        holder.getEmissionTextView().setText(emissionArray.get(position));

    }

    @Override
    public int getItemCount() {
        return dateArray.size();
    }
}