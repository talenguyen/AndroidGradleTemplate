package com.talenguyen.taskmeasurement.data.rest;

import com.talenguyen.taskmeasurement.data.rest.model.base.ResponseBase;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import retrofit.http.Body;
import rx.Observable;

@Singleton
final class MockRestApi implements RestApi {
    @Inject
    public MockRestApi() {
    }

    @Override
    public Observable<ResponseBase<Object>> someEndpoint(@Body List<Object> beaconIdList) {
        return null;
    }
}