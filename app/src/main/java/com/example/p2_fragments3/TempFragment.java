/*
*Author: John McInnes
*Creation Date: 14/03/20
*Modification Date: 26/03/20
*Assignment: CIS436-001 P2 Fragments & Menu operations
 */

package com.example.p2_fragments3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//import android.support.v7.app.AppCompatActivity;

import androidx.fragment.app.Fragment;


public class TempFragment extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.temp_fragment, container, false);
       Button btnConvertCel = (Button) view.findViewById(R.id.buttonConvertCel);
       Button btnConvertFahr = (Button) view.findViewById(R.id.buttonConvertFahr);
       final EditText editCel = (EditText) view.findViewById(R.id.editCel);
       final EditText editFar = (EditText) view.findViewById(R.id.editFar);



        btnConvertCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("winner");
                int celsius = Integer.parseInt(editCel.getText().toString());
                float printer = conversionTimeCel(celsius);
                displayResult(printer, true);

            }//end onClick
        });
        btnConvertFahr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("winner");
                int fahrenheit = Integer.parseInt((editFar.getText().toString()));
                float printee = conversionTimeFahr(fahrenheit);
                displayResult(printee, false);
            }
        });
        return view;
    }//end onCreateView

    private void displayResult(float temp, boolean unit) {
        TextView printCelsius = (TextView) getView().findViewById(R.id.finalCel);
        TextView printFahrenheit = (TextView) getView().findViewById(R.id.finalFahr);
        if(unit == false){
            //this will edit the celsius final print out

            String prtr = String.valueOf(temp);
            printCelsius.setText(prtr);

        }
        else if(unit == true){
            //this will edit the fahrenheit final print out

            String prt = String.valueOf(temp);
            printFahrenheit.setText(prt);
        }
        else{
            //ya vals are garbage
            System.out.println("final else case in display result()");

        }
    }

    private float conversionTimeFahr(int far) {
        //calculate convertsion from fahrenheit to celsius
        //This method recieves the users text from Fahrenheit to manipulate
        int convertedToCel = (((far - 32)*5)/9);

        return convertedToCel;
    }

    private float conversionTimeCel(int cel) {
        //calculate conversion from celsius to fahrenheit
        //This method recieves the users text from Celsius to manipulate
        int convertedToFahr = (((cel/5)*9)+32);

        return convertedToFahr;
    }//end method that converts CEL ->> FAHR


}
