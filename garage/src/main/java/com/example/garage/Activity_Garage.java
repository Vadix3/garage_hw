package com.example.garage;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class Activity_Garage extends AppCompatActivity {

    private static final String TAG = "myTag";
    public static final String API_URL = "https://pastebin.com/raw/WypPzJCt";

    private ConstraintLayout layout;
    private Garage myGarage = null;

    private TextView garageName;
    private TextView openStatus;
    private TextView garageAddress;
    private TextView appType;
    private ListView carsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garage);

        // init views
        initViews();
        getGarageDetails();
    }

    /**
     * A method to get the garage details
     */
    private void getGarageDetails() {
        Log.d(TAG, "getGarageDetails: ");
        new GarageController().start(new GarageController.CallBack_Garage() {
            @Override
            public void getGarage(Garage garage) {
                myGarage = garage;
                updateUI();
            }
        });

    }

    /**
     * A method to update the UI according to the garage we got
     */
    private void updateUI() {
        Log.d(TAG, "updateUI: ");
        setGarageName(myGarage.getName());
        setCarsList(myGarage.getCars());
        setOpenStatus(myGarage.getOpen());
        setGarageAddress(myGarage.getAddress());
    }

    private void setGarageName(String name) {
        garageName.setText(name); // set garage name
    }

    private void setCarsList(List<String> cars) {
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cars);
        carsList.setAdapter(itemsAdapter);
    }

    private void setOpenStatus(Boolean open) {
        if (open) { // set open status
            openStatus.setText("Open");
        } else {
            openStatus.setText("Closed");
        }
    }

    private void setGarageAddress(String address) {
        garageAddress.setText(address); // set garage address
    }

    protected void setAppType(String type) {
        appType.setText(type);
    }

    protected void setAppColor(int color) {
        Log.d(TAG, "setAppColor: " + color);
        layout.setBackgroundColor(color);
    }

    /**
     * A method to initialize the views
     */
    private void initViews() {
        Log.d(TAG, "initViews: ");
        garageName = findViewById(R.id.main_LBL_garageName);
        openStatus = findViewById(R.id.main_LBL_openStatus);
        garageAddress = findViewById(R.id.main_LBL_address);
        carsList = findViewById(R.id.main_LST_carsList);
        appType = findViewById(R.id.main_LBL_appType);
        layout = findViewById(R.id.main_LAY_mainLayout);
    }

}
