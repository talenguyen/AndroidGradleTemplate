package com.talenguyen.taskmeasurement.ui.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.talenguyen.taskmeasurement.Modules;
import com.talenguyen.taskmeasurement.R;
import com.talenguyen.taskmeasurement.ui.activities.base.BaseActivity;

import rx.Observable;

public class BlankActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);

        Observable.just("Hello, world! -Dan")
                .subscribe(s -> System.out.println(s));
    }

    @Override
    protected Object[] getActivityModules() {
        return Modules.list(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.blank, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
