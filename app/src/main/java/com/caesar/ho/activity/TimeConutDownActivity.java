package com.caesar.ho.activity;

import android.app.Activity;
import android.os.Bundle;

import com.caesar.ho.R;
import com.caesar.ho.view.TimeCountDownView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by demi on 17/1/20.
 */

public class TimeConutDownActivity extends Activity {
    TimeCountDownView countdown ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        countdown = (TimeCountDownView) findViewById(R.id.countdown);
        countdown.setDeadTime(str2Time("2020-02-09 12:00:00"));
    }
    public static long str2Time(String str){
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return c.getTimeInMillis();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        countdown.finishCount();
    }
}
