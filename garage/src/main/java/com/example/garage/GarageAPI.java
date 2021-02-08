package com.example.garage;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GarageAPI {

    @GET("WypPzJCt")
    Call<Garage> loadGarage();

}
