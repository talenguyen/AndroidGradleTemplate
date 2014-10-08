package com.talenguyen.taskmeasurement;

import dagger.Module;

@Module(
        addsTo = AppModule.class,
        overrides = true
)
public final class DebugAppModule {
}
