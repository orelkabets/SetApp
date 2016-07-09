package com.example.or.setapp;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateEvent extends Activity {

    MyTextView when;
    Button selectTune;
    EditText what,where;
    TextView start,end;
    FragmentManager manger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        ActionBar actionBar = getActionBar();
        actionBar.hide();

        manger = getFragmentManager();

        // adding what , when, where textViews
        AddTextFragments();
    }

    private void AddTextFragments() {
        FragmentTransaction transaction=  manger.beginTransaction();
        // what text frag
        What_fragment whatFragment = new What_fragment();
        transaction.add(R.id.what_container, whatFragment,"what_text");
        transaction.addToBackStack("addWhatText");
        // when text frag
        When_fragment whenFragment = new When_fragment();
        transaction.add(R.id.when_container, whenFragment,"when_text");
        transaction.addToBackStack("addWhenText");
        // where text frag
        Where_fragment whereFragment = new Where_fragment();
        transaction.add(R.id.where_container, whereFragment,"where_text");
        transaction.addToBackStack("addWhereText");
        transaction.commit();
    }


    public void OnWhenClicked(View v){
        FragmentTransaction transaction = manger.beginTransaction();
        // define the when reference to replace the when text
        When_clickedFragment when_clickedFragment = new When_clickedFragment();
        transaction.replace(R.id.when_container, when_clickedFragment, "when_reference");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void OnTimeClicked(View v){

    }

}
