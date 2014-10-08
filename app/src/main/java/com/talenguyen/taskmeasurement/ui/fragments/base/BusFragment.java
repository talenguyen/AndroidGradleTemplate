package com.talenguyen.taskmeasurement.ui.fragments.base;

import com.squareup.otto.Bus;

import javax.inject.Inject;

/**
 * Created by giang on 08/10/2014.
 */
public class BusFragment extends ButterKnifeFragment {

    @Inject
    protected Bus bus;

    @Override
    public void onStart() {
        super.onStart();

        bus.register(this);
    }

    @Override
    public void onStop() {
        bus.unregister(this);

        super.onStop();
    }

}
