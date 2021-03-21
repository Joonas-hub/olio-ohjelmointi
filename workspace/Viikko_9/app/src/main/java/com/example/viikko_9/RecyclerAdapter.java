package com.example.viikko_9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<String> titleList;
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView titleTextView;

        public ViewHolder(View view){
            super(view);
            titleTextView = (TextView) view.findViewById(R.id.titleView);
        }
        public TextView getTextView(){
            return titleTextView;
        }
    }
    public RecyclerAdapter(ArrayList<String> titleList){
        this.titleList = titleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_re, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.getTextView().setText(titleList.get(position));
    }

    @Override
    public int getItemCount() {
        return titleList.size();
    }
}
