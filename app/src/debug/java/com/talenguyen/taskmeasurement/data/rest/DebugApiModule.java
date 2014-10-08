package com.talenguyen.taskmeasurement.data.rest;

import android.content.SharedPreferences;

import com.talenguyen.taskmeasurement.annotations.ApiEndpoint;
import com.talenguyen.taskmeasurement.annotations.IsMockMode;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;
import retrofit.android.AndroidMockValuePersistence;

@Module(
        complete = false,
        library = true,
        overrides = true,
        includes = ApiModule.class
)
public final class DebugApiModule {
    @Provides
    @Singleton
    @ApiEndpoint
    String provideEndpoint() {
        return ApiEndpoints.MOCK_MODE.url;
    }

    @Provides
    @Singleton
    @IsMockMode
    boolean provideIsMockMode(@ApiEndpoint String endpoint) {
        return ApiEndpoints.isMockMode(endpoint);
    }

    @Provides
    @Singleton
    MockRestAdapter provideMockRestAdapter(RestAdapter restAdapter,
                                           SharedPreferences preferences) {
        MockRestAdapter mockRestAdapter = MockRestAdapter.from(restAdapter);
        AndroidMockValuePersistence.install(mockRestAdapter, preferences);

        return mockRestAdapter;
    }

    @Provides
    @Singleton
    RestApi provideJojoRestApi(RestAdapter restAdapter,
                               MockRestAdapter mockRestAdapter, @IsMockMode boolean isMockMode,
                               MockRestApi mockService) {
        if (isMockMode) {
            return mockRestAdapter.create(RestApi.class, mockService);
        }
        return restAdapter.create(RestApi.class);
    }

    @Provides
    @Singleton
    ApiManager provideApiManager(RestApi restApi) {
        return new ApiManager(restApi);
    }
}