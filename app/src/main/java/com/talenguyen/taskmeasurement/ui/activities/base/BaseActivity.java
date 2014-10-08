package com.talenguyen.taskmeasurement.ui.activities.base;

import android.app.Activity;
import android.os.Bundle;

import com.talenguyen.taskmeasurement.App;
import com.talenguyen.taskmeasurement.utils.Injector;

import dagger.ObjectGraph;
import hugo.weaving.DebugLog;

/**
 * Created by bartoszjarocki on 23/02/14.
 */
public abstract class BaseActivity extends Activity implements Injector {

    protected ObjectGraph mActivityGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        inject();
        setupActionBar();
    }

    @Override
    protected void onDestroy() {
        clearData();

        super.onDestroy();
    }

    /**
     * Inject the supplied {@code object} using the activity-specific graph.
     */
    @Override
    public void inject(Object object) {
        mActivityGraph.inject(object);
    }

    @Override
    public ObjectGraph getObjectGraph() {
        return mActivityGraph;
    }

    protected abstract Object[] getActivityModules();

    @DebugLog
    private void inject() {
        // Create the activity graph by .plus-ing our modules onto the application graph.
        App application = App.get(this);
        Object[] modules = getActivityModules();
        if (modules == null) {
            modules = new Object[]{};
        }
        mActivityGraph = application.getObjectGraph().plus(modules);

        // Inject ourselves so subclasses will have dependencies fulfilled when this method returns.
        mActivityGraph.inject(this);
    }

    private void setupActionBar() {
        if (getActionBar() == null) {
            return;
        }

        getActionBar().setDisplayShowTitleEnabled(false);
    }

    private void clearData() {
        // Eagerly clear the reference to the activity graph to allow it to be garbage collected as
        // soon as possible.
        mActivityGraph = null;
    }
}
