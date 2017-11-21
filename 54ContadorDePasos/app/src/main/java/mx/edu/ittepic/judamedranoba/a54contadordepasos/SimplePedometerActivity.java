package mx.edu.ittepic.judamedranoba.a54contadordepasos;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SimplePedometerActivity extends AppCompatActivity implements SensorEventListener, StepListener {

    private TextView textView;
    private SimpleStepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    private int numSteps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //textView = (TextView) findViewById(R.id.textView);
        textView = new TextView(this);
        setContentView(textView);

        // Get an instance of the SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new SimpleStepDetector();
        simpleStepDetector.registerListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        numSteps = 0;
        textView.setText(numSteps);
        sensorManager.registerListener(this, accel, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
    public void step(long timeNs) {
        numSteps++;
        textView.setText(numSteps);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
