package com.caesar.ho.activity;

import android.app.Activity;
import android.content.res.ObbInfo;
import android.os.Bundle;
import android.os.PersistableBundle;

import com.caesar.ho.R;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by demi on 16/11/28.
 */

public class ClockActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

    }
}
