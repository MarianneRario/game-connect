package com.semaphore.gameconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

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

    /* onClick functions here */
    public void dropIn(View view){ // need a View parameter which is the ImageView that was tapped on

        ImageView counter = (ImageView) view; // actual imageview that was tapped on

        // check the tag
        Log.i("Tag", "Tag: " + counter.getTag());
        int tappedCounterTag = Integer.parseInt(counter.getTag().toString());

        // game state tracker - change the gameState array every tapped using the imageview tag
        gameState[tappedCounterTag] = activePlayer;

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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}