package com.talenguyen.taskmeasurement.ui.activities.base;

import com.squareup.otto.Bus;

import javax.inject.Inject;

/**
 * Created by giang on 08/10/2014.
 */
public abstract class BusActivity extends ButterKnifeActivity {
    @Inject
    protected Bus bus;

    @Override
    protected void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        bus.unregister(this);
    }
}
