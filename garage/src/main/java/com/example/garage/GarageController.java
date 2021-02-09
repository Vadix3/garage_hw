package com.example.garage;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class GarageController implements Callback<Garage> {

    public static final String API_URL = "https://pastebin.com/raw/";
    private static final String TAG = "myTag";

    private Garage myGarage = null;
    private CallBack_Garage callBack_garage;

    public void start(CallBack_Garage callBack_garage) {
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
        call.enqueue(this);

    }


    @Override
    public void onFailure(Call<Garage> call, Throwable t) {
        Log.d(TAG, "onFailure: " + call.toString());
        t.printStackTrace();
    }


    @Override
    public void onResponse(Call<Garage> call, Response<Garage> response) {
        if (response.isSuccessful()) {
            Garage garage = response.body();

            if (callBack_garage != null) {
                callBack_garage.getGarage(garage);
            }
        } else {
            Log.d(TAG, "onResponseError: " + response.toString());
        }
    }

    public interface CallBack_Garage {
        void getGarage(Garage garage);
    }
}
