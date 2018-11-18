package com.example.blanka.mam2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

public class SensorObserver implements SensorEventListener {

    TextView lightTV;

    SensorObserver(TextView tv) {
        lightTV = tv;
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_LIGHT) {
            lightTV.setText(String.valueOf(event.values[0])+" lux ");
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
