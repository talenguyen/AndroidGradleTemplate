package com.talenguyen.taskmeasurement.ui.fragments.base;

import android.app.Fragment;
import android.os.Bundle;

import com.talenguyen.taskmeasurement.ui.activities.base.BaseActivity;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 */
public class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inject();
    }

    private void inject() {
        // Assume that it lives within a BaseActivity host
        ((BaseActivity) getActivity()).inject(this);
    }
}
