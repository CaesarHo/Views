package com.caesar.ho.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.caesar.ho.R;
import com.caesar.ho.fragment.ProfitsChartFragment;

/**
 * Created by demi on 2017/5/12.
 */

public class PortfoliosActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolios);
        if (savedInstanceState == null) {
            ProfitsChartFragment profitsFragment = new ProfitsChartFragment();
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, profitsFragment)
                    .commit();
        }
    }
}
