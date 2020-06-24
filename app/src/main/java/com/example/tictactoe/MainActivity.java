package com.example.tictactoe;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int active = 0; //0=circle , 1= cross
    //We need to set some memory to store the actions
    int[] gameState ={2,2,2,2,2,2,2,2,2};   //2 means unplayed
    int[][] winningLocation={{0,1,2},{3,4,5},{6,7,8},   //horizontal
            {0,3,6},{1,4,7},{2,5,8},    //vertical
            {0,4,8},{2,4,6}};       //diagonal
    public void dropin(View view) {
        ImageView counter = (ImageView) view; // We dont have to specify id, because it will act on any element clicked on
        int tapped = Integer.parseInt(counter.getTag().toString());
        if (gameState[tapped] == 2) //Setting unset variable
        {
            gameState[tapped] =active;
            counter.setTranslationY(-1000f);
            if (active == 0) {
                counter.setImageResource(R.drawable.donut);
                active = 1;
            }
            else {
                counter.setImageResource(R.drawable.closesma);
                active = 0;
            }
            counter.animate().translationYBy(1000f).rotation(720).setDuration(300);
            for(int[] win:winningLocation)
            {
                if(gameState[win[0]]==gameState[win[1]]
                 && gameState[win[1]] ==gameState[win[2]] && gameState[win[0]]!=2)
                {
                    System.out.println(gameState[win[0]]);  //prints who won
                }
            }

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //adds items to action bar
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
