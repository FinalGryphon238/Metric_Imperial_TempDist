package com.example.p2_fragments3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TempFragment tempFragment;
    private DistFragment distFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tempFragment = new TempFragment();
        distFragment = new DistFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.placeHolderLayout, tempFragment);
        //commit the change
        fragmentTransaction.commit();

    }//end onCreate
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }//end onCreateOptionsMenu

   @Override
   public boolean onOptionsItemSelected(MenuItem item){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


            if(item.getItemId()== R.id.menu_temp){
            /*Toast.makeText(this,
                    "Clicked Temperature",
                    Toast.LENGTH_LONG).show();*/
                fragmentTransaction.replace(R.id.placeHolderLayout,
                        tempFragment);

            }
            else if(item.getItemId()==R.id.menu_dist){
            /*Toast.makeText(this,
                    "Clicked Distance",
                    Toast.LENGTH_LONG).show();*/

                fragmentTransaction.replace(R.id.placeHolderLayout,
                        distFragment);

            }
            else{
            //default
            return super.onContextItemSelected(item);
            }

        fragmentTransaction.commit();
        return true;
    }// end onOptionSelected
}
