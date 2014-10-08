package com.talenguyen.taskmeasurement.ui.activities.module;

import android.app.Activity;
import android.content.Context;

import com.talenguyen.taskmeasurement.annotations.ForActivity;
import com.talenguyen.taskmeasurement.data.DebugDataModule;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
        overrides = true,
        complete = false,
        library = true,
        includes = DebugDataModule.class,
        injects = {
        })
public class DebugActivityScopeModule {
    private final Activity mActivity;

    public DebugActivityScopeModule(Activity activity) {
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