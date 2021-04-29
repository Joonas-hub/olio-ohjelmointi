package com.joonas.harjoitusty;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    // ViewHolder for logfile recycler view.
    private TextView dateView;
    private TextView meatView;
    private TextView vegView;
    private TextView emissionView;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        dateView = itemView.findViewById(R.id.logDate);
        meatView = itemView.findViewById(R.id.logMeat);
        vegView = itemView.findViewById(R.id.logVeg);
        emissionView = itemView.findViewById(R.id.logEmission);
    }

    public TextView getDateTextView(){
        return dateView;
    }
    public TextView getMeatTextView(){
        return meatView;
    }
    public TextView getVegTextView(){
        return vegView;
    }
    public TextView getEmissionTextView(){
        return emissionView;
    }
}
