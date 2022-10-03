package br.fmu.projetoaulam;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;

public class SensorActivity extends AppCompatActivity {
    EditText editTextNumberX;
    EditText editTextNumberY;
    EditText editTextNumberZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        editTextNumberX = findViewById(R.id.editTextNumberX);
        editTextNumberY = findViewById(R.id.editTextNumberY);
        editTextNumberZ = findViewById(R.id.editTextNumberZ);
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float x = sensorEvent.values[0];
                float y = sensorEvent.values[1];
                float z = sensorEvent.values[2];
                editTextNumberX.setText(Float.toString(x));
                editTextNumberY.setText(Float.toString(y));
                editTextNumberZ.setText(Float.toString(z));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {}
        }, sensor, SensorManager.SENSOR_DELAY_FASTEST);
    }
}