package com.talenguyen.taskmeasurement;

import android.app.Activity;

import com.talenguyen.taskmeasurement.ui.activities.module.DebugActivityScopeModule;

public final class Modules {
    public static Object[] list(Activity activity) {
        return new Object[]{
                new DebugActivityScopeModule(activity)
        };
    }

    private Modules() {
        // No instances.
    }
}