package com.talenguyen.taskmeasurement.ui.fragments.base;

import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by giang on 08/10/2014.
 */
public class ButterKnifeFragment extends BaseFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.inject(this, view);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ButterKnife.reset(this);
    }
}
