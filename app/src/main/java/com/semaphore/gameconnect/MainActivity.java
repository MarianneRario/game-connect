package com.semaphore.gameconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    /* onClick functions here */
    public void dropIn(View view){ // need a View parameter which is the ImageView that was tapped on

        ImageView counter = (ImageView) view; // actual imageview that was tapped on

        // animate the counter
        counter.setTranslationY(-1000); // take it off at the top of the screen; san manggagaling
        counter.setImageResource(R.drawable.yellow); // set an image on the imageview
        counter.animate().translationYBy(1000).rotation(500).setDuration(500); // paano bababa
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}