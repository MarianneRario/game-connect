package com.semaphore.gameconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0; // this integer will serve as a flag (boolean); 0 - Yellow, 1 - Red

    // initially, the state of the game is none. Empty represents by 2, so in our array, let's put nine 2s
    // 0 - Yellow, 1 - Red, 2 - Empty
    int[] gameState = {2,2,2,2,2,2,2,2,2};

    // create an array of winning positions
    int [][] winningPositions = {
                                {0,1,2},{3,4,5},{6,7,8}, // horizontal winning positions
                                {0,3,6},{1,4,7},{2,5,8}, // vertical winning positions
                                {0,4,8}, // diagonal right winning position
                                {2,4,6} // diagonal left winning position
                                };
    // checks whether the game is still going or already done
    boolean gameActive = true;

    /* onClick functions here */
    public void dropIn(View view){ // need a View parameter which is the ImageView that was tapped on

        ImageView counter = (ImageView) view; // actual imageview that was tapped on

        // check the tag
        int tappedCounterTag = Integer.parseInt(counter.getTag().toString());

        // check if the gameState element in the array is already occupied by 0 or 1 and if the gameActive is true
        if(gameState[tappedCounterTag] == 2 && gameActive){
            // game state tracker - change the gameState array every tapped using the imageview tag
            gameState[tappedCounterTag] = activePlayer;

            Log.i("Info", "Value " + gameState[tappedCounterTag]);

            // animate the counter
            counter.setTranslationY(-1000); // take it off at the top of the screen; san manggagaling
            // change the image per click
            if(activePlayer == 0){
                activePlayer = 1;
                counter.setImageResource(R.drawable.yellow); // set an image on the imageview
            } else {
                activePlayer = 0;
                counter.setImageResource(R.drawable.red); // set an image on the imageview
            }
            counter.animate().translationYBy(1000).rotation(500).setDuration(500); // paano bababa

            /* CHECK AGAINST THE WINNING POSITION */
            for(int[] winningPosition: winningPositions){
                if((gameState[winningPosition[0]]) == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] != 2) {

                    // if all conditions are met, gameActive will be false
                    gameActive = false;

                    // decide which color has won
                    String winner;
                    if(activePlayer == 1){
                        winner = "Yellow";
                    } else {
                        winner = "Red";
                    }

                    // if all the above condition is all met, then someone has won
                    Toast.makeText(this, winner + " has won", Toast.LENGTH_LONG).show();

                }
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}