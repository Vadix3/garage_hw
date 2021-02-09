package com.example.customers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.garage.Activity_Garage;

public class MainActivity extends Activity_Garage {

    private int greenColor = 0xff69f0ae;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAppType("Customers app");
        setAppColor(greenColor);
    }
}