package com.example.p2_fragments3;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class DistFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.dist_fragment,container,false);
        Button btnConvertToKM = (Button) view.findViewById(R.id.buttonConvertToKM);
        Button btnConvertToM =(Button) view.findViewById(R.id.buttonConvertToM);
        final EditText editKilo = (EditText) view.findViewById(R.id.editKM);
        final EditText editMiles = (EditText) view.findViewById(R.id.editM);

        btnConvertToM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int kilometres = Integer.parseInt(editKilo.getText().toString());
                double printer = conversionTimeToMiles(kilometres);
                displayResult(printer, false);
            }
        });

        btnConvertToKM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int miles = Integer.parseInt(editMiles.getText().toString());
                double printest = conversionTimeToKilometres(miles);
                displayResult(printest, true);
            }
        });

        return view;
    }//end onCreateView

    private double conversionTimeToKilometres(int m) {
        double convertedToKilometres = m*1.609;
        return convertedToKilometres;

    }

    private void displayResult(double dist, boolean b) {
        TextView printMiles = (TextView) getView().findViewById(R.id.finalMiles);
        TextView printKilom = (TextView) getView().findViewById(R.id.finalKilo);
        if(b == false){
            String thePrint = String.valueOf(dist);
            printMiles.setText(thePrint);
        }
        else if(b == true){
            String prinnnt = String.valueOf(dist);
            printKilom.setText(prinnnt);
        }
        else{
            //ya vals are garbage
            System.out.println("final else case in display result()");

        }
    }

    private double conversionTimeToMiles(int km) {
        double convertedToMiles = km / 1.609;
        return convertedToMiles;

    }

}
