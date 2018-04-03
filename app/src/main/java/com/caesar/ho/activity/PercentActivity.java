package com.caesar.ho.activity;

import android.app.Activity;
import android.os.Bundle;

import com.caesar.ho.R;
import com.caesar.ho.view.OvalProgrossView;

/**
 * Created by demi on 16/11/29.
 */

public class PercentActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_percent);
        OvalProgrossView oval= (OvalProgrossView) findViewById(R.id.oval);
        oval.setmOvalProgress(88);

    }
}
