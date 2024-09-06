package com.example.modul2_kel33;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("api/users?page=2")
    Call<ListUserResponse> getList();

}

