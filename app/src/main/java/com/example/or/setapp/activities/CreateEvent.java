package com.example.or.setapp.activities;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.example.or.setapp.R;
import com.example.or.setapp.fragments.What_fragment;
import com.example.or.setapp.fragments.When_clickedFragment;
import com.example.or.setapp.fragments.When_fragment;
import com.example.or.setapp.fragments.Where_fragment;
import com.jzxiang.pickerview.TimePickerDialog;
import com.jzxiang.pickerview.data.Type;
import com.jzxiang.pickerview.listener.OnDateSetListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateEvent extends FragmentActivity implements OnDateSetListener {
    private static final int STARTTIME = 1;
    private static final int ENDTIME = 2;
    boolean isStartTime = false;
    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat tf = new SimpleDateFormat("HH:mm");
    TimePickerDialog mDialogAll;
    TextView startTime,endTime;
    android.support.v4.app.FragmentManager manger;
    When_clickedFragment when_clickedFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);
        ActionBar actionBar = getActionBar();
        actionBar.hide();

        manger = getSupportFragmentManager();

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
        when_clickedFragment = new When_clickedFragment();
        transaction.replace(R.id.when_container, when_clickedFragment, "when_reference");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void OnTimeClicked(View v){
        switch (v.getId()){
            case R.id.startTime :
                isStartTime = true;
                OpenDateTimeDialog(STARTTIME);
                break;
            case R.id.endTime :
                isStartTime = false;
                OpenDateTimeDialog(ENDTIME);
                break;
        }
    }

    public void OpenDateTimeDialog(int state){
        String dpString = "Select End Date and Time";
        if (state == STARTTIME) {
            dpString = "Select Start Date and Time";
        }
        long tenYears = 10L * 365 * 1000 * 60 * 60 * 24L;
        mDialogAll = new TimePickerDialog.Builder()
                .setCallBack(this)
                .setCancelStringId("Cancel")
                .setSureStringId("Sure")
                .setTitleStringId(dpString)
                .setYearText(" Year")
                .setMonthText(" Month")
                .setDayText(" Day")
                .setHourText(" Hour")
                .setMinuteText(" Minute")
                .setCyclic(false)
                .setMinMillseconds(System.currentTimeMillis())
                .setMaxMillseconds(System.currentTimeMillis() + tenYears)
                .setCurrentMillseconds(System.currentTimeMillis())
                .setThemeColor(getResources().getColor(R.color.timepicker_dialog_bg))
                .setType(Type.ALL)
                .setWheelItemTextNormalColor(getResources().getColor(R.color.lightpurple))
                .setWheelItemTextSelectorColor(getResources().getColor(R.color.purple))
                .setWheelItemTextSize(14)
                .build();



        mDialogAll.show(getSupportFragmentManager(),"all");
    }


    @Override
    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
        String text = getDateToString(millseconds);
        if (isStartTime)
            when_clickedFragment.changeStartTimeText(text);
        else
            when_clickedFragment.changeEndTimeText(text);
    }

    public String getDateToString(long time) {
        Date d = new Date(time);
        return tf.format(d);
    }
}


