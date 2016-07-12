package com.example.or.setapp.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.or.setapp.R;

public class FirstScreen extends Activity {


    AnimationDrawable myAnimationDrawable;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        ActionBar actionBar = getActionBar();
        actionBar.hide();
        logo = (ImageView)findViewById(R.id.splashscreen);
        myAnimationDrawable = (AnimationDrawable)logo.getDrawable();
        myAnimationDrawable.start();

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                Intent i = new Intent(FirstScreen.this, login.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, myAnimationDrawable.getDuration(0) * myAnimationDrawable.getNumberOfFrames());
    }
}
