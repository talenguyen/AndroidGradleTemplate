package com.talenguyen.taskmeasurement;

public final class Modules {
    public static Object[] list(Activity activity) {
        return new Object[] {
                new ActivityScopeModule(activity)
        };
    }

    private Modules() {
        // No instances.
    }
}