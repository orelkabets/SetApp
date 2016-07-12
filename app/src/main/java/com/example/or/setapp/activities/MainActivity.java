package com.example.or.setapp.activities;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.or.setapp.R;
import com.example.or.setapp.fragments.FooterFragment;
import com.example.or.setapp.fragments.HeaderFragment;


public class MainActivity extends Activity {

    FragmentManager manger;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar = getActionBar();
        actionBar.hide();
        manger = getFragmentManager();

        addHeaderAndFooterFrags();
    }


    public void addHeaderAndFooterFrags(){
        HeaderFragment headerFragment = new HeaderFragment();
        FooterFragment footerFragment = new FooterFragment();
        FragmentTransaction transaction=  manger.beginTransaction();
        transaction.add(R.id.header_containter, headerFragment,"header");
        transaction.addToBackStack("addHeader");
        transaction.add(R.id.footer_container, footerFragment,"header");
        transaction.addToBackStack("addFooter");
        transaction.commit();
    }

    public void openSettings(View v){
        Toast.makeText(MainActivity.this,"settings was clicked", Toast.LENGTH_LONG).show();
    }

    public void createEvent(View v){
        Intent intent = new Intent(MainActivity.this, CreateEvent.class);
        startActivity(intent);
    }



}
