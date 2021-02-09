package com.example.garage_hw;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;

import com.example.garage.Activity_Garage;


/**
 * A BLUE employees garage app
 */

public class MainActivity extends Activity_Garage {

    private int blueColor = 0xff448aff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setAppType("Employees app");
        setAppColor(blueColor);
    }
}