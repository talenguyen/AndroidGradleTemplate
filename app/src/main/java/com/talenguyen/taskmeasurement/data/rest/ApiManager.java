package com.talenguyen.taskmeasurement.data.rest;

import com.talenguyen.taskmeasurement.data.rest.model.base.ResponseBase;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import hugo.weaving.DebugLog;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@Singleton
public class ApiManager {
    RestApi restApi;

    @Inject
    public ApiManager(RestApi restApi) {
        this.restApi = restApi;
    }

    @DebugLog
    public Observable<ResponseBase<Object>> someEndpoint(final List<Object> someBody) {
        return restApi.someEndpoint(someBody)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
