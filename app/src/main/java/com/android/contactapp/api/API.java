package com.android.contactapp.api;

import com.android.contactapp.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface API {

    @GET("/api")
    Call<Model> getResults(@Query("results") String results,
                           @Query("exc") String exc,
                           @Query("nat") String nat,
                           @Query("noinfo") String noinfo);


}
