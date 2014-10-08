package com.talenguyen.taskmeasurement.ui.activities.module;

import android.app.Activity;
import android.content.Context;

import com.talenguyen.taskmeasurement.annotations.ForActivity;
import com.talenguyen.taskmeasurement.data.DataModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        complete = false,
        library = true,
        includes = DataModule.class,
        injects = {
        })
public class ActivityScopeModule {
    private final Activity mActivity;

    public ActivityScopeModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @Singleton
    @ForActivity
    Context providesActivityContext() {
        return mActivity;
    }

    @Provides
    @Singleton
    Activity providesActivity() {
        return mActivity;
    }
}