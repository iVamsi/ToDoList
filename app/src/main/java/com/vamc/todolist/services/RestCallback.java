package com.vamc.todolist.services;

import retrofit.Callback;
import retrofit.RetrofitError;

public abstract class RestCallback<T> implements Callback<T> {

    public abstract void failure(RestServiceError restError);

    @Override
    public void failure(RetrofitError error) {
        RestServiceError restError = (RestServiceError) error.getBodyAs(RestServiceError.class);
        // create your own class as
        // how the error message gonna show up from server side if there is an error
        if (restError != null)
            failure(restError);
        else {
            failure(new RestServiceError(error.getMessage()));
        }
    }
}
