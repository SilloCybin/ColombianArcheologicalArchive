package com.example.cedricdevries.webservices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Data {

    private Retrofit retrofit;
    private IData petition;

    Data() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.datos.gov.co")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        petition = retrofit.create(IData.class);
    }

    public void get(String url, final IActions actions) {

        Call<List<ArcheologicalElement>> call = petition.get(url);
        call.enqueue(
                new Callback<List<ArcheologicalElement>>() {
                    @Override
                    public void onResponse(Call<List<ArcheologicalElement>> call, Response<List<ArcheologicalElement>> response) {
                        switch (response.code()) {
                            case 200:
                                List<ArcheologicalElement> data = response.body();
                                actions.actionResponseData(data);
                                break;
                            case 401:
                                break;
                            default:
                                break;
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ArcheologicalElement>> call, Throwable t) {
                        try {
                            actions.actionErrorResponse(t);
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    }
                }
        );
    }
}
