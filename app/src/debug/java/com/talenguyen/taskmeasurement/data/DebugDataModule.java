package com.talenguyen.taskmeasurement.data;

import com.talenguyen.taskmeasurement.data.rest.DebugApiModule;

import dagger.Module;

@Module(
        includes = {
                DebugApiModule.class,
                DataModule.class
        },
        complete = false,
        library = true,
        overrides = true)
public final class DebugDataModule {
}
