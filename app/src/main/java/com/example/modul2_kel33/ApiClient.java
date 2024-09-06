package com.example.modul2_kel33;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    // TODO menginisiasi MainInterface
    private static ApiInterface service;

    public static ApiInterface getService() {

        if (service == null) {
            // Membuat base URL
            String BASE_URL = "https://reqres.in/";

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

            Retrofit retrofit = builder.client(httpClient.build()).build();

            service = retrofit.create(ApiInterface.class);
        }
        return service;
    }
}
