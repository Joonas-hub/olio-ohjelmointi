package com.joonas.harjoitusty;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EntryFragment extends Fragment {
    // Fragment view for reading user inputs and creating new diet entries.
    View view;
    TextView meatInput, vegInput;
    Button dietOKButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.entry_layout, container, false);
        meatInput = view.findViewById(R.id.meatConsumption);
        vegInput = view.findViewById(R.id.vegetableConsumption);
        dietOKButton = view.findViewById(R.id.dietEntryOKButton);

        View.OnClickListener entryButtonListener = new View.OnClickListener() {
            // Listener for new diet entry creation button. Reads user inputs and sends them to MainActivity.
            @Override
            public void onClick(View v) {
                String meatInputText = meatInput.getText().toString();
                String vegInputText = vegInput.getText().toString();

                Intent intent = new Intent(getActivity().getBaseContext(), MainActivity.class);
                intent.putExtra("meat", meatInputText);
                intent.putExtra("veg", vegInputText);
                startActivity(intent);
                System.out.println("Starting intent");
            }

        };

        dietOKButton.setOnClickListener(entryButtonListener);

        return view;
    }


}
