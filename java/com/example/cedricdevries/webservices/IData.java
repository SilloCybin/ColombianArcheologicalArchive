package com.example.cedricdevries.webservices;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IData {
    @GET("/resource/{id}.json")
    Call<List<ArcheologicalElement>> get(@Path("id") String id);
}
