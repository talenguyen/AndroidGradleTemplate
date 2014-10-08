package com.talenguyen.taskmeasurement.data.rest;

import com.talenguyen.taskmeasurement.data.rest.model.base.ResponseBase;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.POST;
import rx.Observable;

//TODO: insert api methods here
interface RestApi {
    @POST("/someEndpoint/")
    public Observable<ResponseBase<Object>> someEndpoint(@Body List<Object> someBody);
}