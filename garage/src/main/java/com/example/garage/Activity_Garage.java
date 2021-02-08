package com.example.garage;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity_Garage extends AppCompatActivity {

    private static final String TAG = "myTag";
    public static final String API_URL = "https://pastebin.com/raw/WypPzJCt";

    private TextView testText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage);
        GarageController controller = new GarageController();
        controller.start();

//        new GarageController().fetchGarage(new GarageController.Callback_Garage() {
//            @Override
//            public void garage(Garage garage) {
//                testText.setText(garage.toString());
//                Log.d(TAG, "garage: "+garage.toString());
//            }
//        });

    }

}
