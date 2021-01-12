package com.example.garage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GarageController {

    public static final String API_URL = "https://pastebin.com/raw/WypPzJCt/";

    private Callback_Garage callBack_garage;

    Callback<Garage> movieCallBack = new Callback<Garage>() {
        @Override
        public void onResponse(Call<Garage> call, Response<Garage> response) {
            if (response.isSuccessful()) {
                Garage garage = response.body();
                if (callBack_garage != null) {
                    callBack_garage.garage(garage);
                }
            } else {
                System.out.println(response.errorBody());
            }
        }

        @Override
        public void onFailure(Call<Garage> call, Throwable t) {
            t.printStackTrace();
        }
    };


    public void fetchGarage(Callback_Garage callBack_garage) {
        this.callBack_garage = callBack_garage;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GarageAPI garageAPI = retrofit.create(GarageAPI.class);

        Call<Garage> call = garageAPI.loadGarage();
        call.enqueue(movieCallBack);
    }

    public interface Callback_Garage {
        void garage(Garage garage);
    }
}
