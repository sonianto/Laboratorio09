package ar.edu.utn.frsf.isi.dam.laboratorio09;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAcelerometro;
    private List<acelerar> lista;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!=null) {
            mAcelerometro = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
        else
        {
            Toast.makeText(getApplicationContext(),
                    "No hay acelerometro " ,
                    Toast.LENGTH_LONG).show();
        }
        lista=new ArrayList<acelerar>();
        listView=(ListView)findViewById(R.id.listView);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        acelerar aux=new acelerar();
       /* aux.setMagnitudX(String.valueOf(sensorEvent.values[0]));
        aux.setMagnitudY(String.valueOf(sensorEvent.values[1]));
        aux.setMagnitudZ(String.valueOf(sensorEvent.values[2]));*/
        Toast.makeText(getApplicationContext(),
                "Clicked on Row: " + sensorEvent.values[0],
                Toast.LENGTH_LONG).show();
        lista.add(aux);
        AdapterDatos a = new AdapterDatos(lista,getApplicationContext() );
        listView.setAdapter(a);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAcelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

}
