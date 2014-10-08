package com.talenguyen.taskmeasurement.ui.activities.base;

import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * Created by giang on 08/10/2014.
 */
public abstract class ButterKnifeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.reset(this);
    }
}
