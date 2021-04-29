package com.joonas.harjoitusty;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LogFragment extends Fragment {
    // Fragment view for viewing the logfile.
    RecyclerView logRecycler;
    View view;
    ArrayList<String> dateArray = new ArrayList<>();
    ArrayList<String> meatArray = new ArrayList<>();
    ArrayList<String> vegArray = new ArrayList<>();
    ArrayList<String> emissionArray = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Reads the logfile into a recycler view.
        view = inflater.inflate(R.layout.log_layout, container, false);
        logRecycler = view.findViewById(R.id.logRecycler);
        logRecycler.setLayoutManager(new LinearLayoutManager(view.getContext()));

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getContext().openFileInput("log.txt")));
            String line = "";
            String[] lineSplit;
            while ((line = reader.readLine()) != null){
                lineSplit = line.split(",");
                dateArray.add(lineSplit[0]);
                meatArray.add(lineSplit[1]);
                vegArray.add(lineSplit[2]);
                emissionArray.add(lineSplit[3]);
            }
            RecyclerAdapter adapter = new RecyclerAdapter(dateArray, meatArray, vegArray, emissionArray);
            logRecycler.setAdapter(adapter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return view;
    }
}
