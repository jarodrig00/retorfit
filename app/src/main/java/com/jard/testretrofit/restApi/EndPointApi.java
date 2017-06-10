package com.jard.testretrofit.restApi;

import com.jard.testretrofit.restApi.model.MediaResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jarodrig on 01/06/2017.
 */

public interface EndPointApi {
    @GET(RestApiConstant.URL_MEDIA)
    Call<MediaResponse> getMedia(@Path("user_id") String id);
}
