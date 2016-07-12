package com.example.or.setapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.or.setapp.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by or on 7/8/2016.
 */
public class When_clickedFragment extends android.support.v4.app.Fragment {

    static TextView startTime;
    static TextView endTime ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.when_reference, container, false);


    }

    @Override
    public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        startTime = (TextView)getActivity().findViewById(R.id.startTime);
        endTime   = (TextView)getActivity().findViewById(R.id.endTime);

        Calendar now = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("hh:mm");
        startTime.setText(df.format(now.getTime()));
        now.add(Calendar.MINUTE, 30);
        endTime.setText(df.format(now.getTime()));
    }

    public static void changeStartTimeText(String mText)
    {
        startTime.setText(mText);
    }

    public static void changeEndTimeText(String mText)
    {
        endTime.setText(mText);
    }

}
