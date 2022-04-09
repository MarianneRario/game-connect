package com.semaphore.gameconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0; // this integer will serve as a flag (boolean); 0 - Yellow, 1 - Red

    // initially, the state of the game is none. None represents by 2, so in our array, let's put nine 2s
    int[] gameState = {}

    /* onClick functions here */
    public void dropIn(View view){ // need a View parameter which is the ImageView that was tapped on

        ImageView counter = (ImageView) view; // actual imageview that was tapped on

        // check the tag
        Log.i("Tag", "Tag: " + counter.getTag());

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