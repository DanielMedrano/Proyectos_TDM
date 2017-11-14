package mx.edu.ittepic.judamedranoba.a51deteccionsensores;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SensorManager sensorManager;
    ListView List;
    ArrayList<Lista_entrada> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List = (ListView) findViewById(R.id.lv);
        datos = new ArrayList<Lista_entrada>();
        sensorManager = (SensorManager)this.getSystemService(SENSOR_SERVICE);

        List<Sensor> lista = sensorManager.getSensorList(Sensor.TYPE_ALL);
        for(int i=1; i<lista.size(); i++){
            datos.add(new Lista_entrada("Nombre : "+lista.get(i).getName(),"Fabricante : "+lista.get(i).getVendor(),
                    "Versión : "+lista.get(i).getVersion(),"Máximo Rango : "+lista.get(i).getMaximumRange(),
                    "Delay : "+lista.get(i).getMinDelay(),"Power : "+lista.get(i).getPower()));
        }

        List.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {

                    TextView nombre = (TextView) view.findViewById(R.id.tv_nombre);
                    if (nombre != null)
                        nombre.setText(((Lista_entrada) entrada).getNombre());

                    TextView fabricante = (TextView) view.findViewById(R.id.tv_fabricante);
                    if (fabricante != null)
                        fabricante.setText(((Lista_entrada) entrada).getFabricante());

                    TextView version = (TextView) view.findViewById(R.id.tv_version);
                    if (version != null)
                        version.setText(((Lista_entrada) entrada).getVersion());

                    TextView maximo = (TextView) view.findViewById(R.id.tv_rango);
                    if (maximo != null)
                        maximo.setText(((Lista_entrada) entrada).getRango());

                    TextView delay = (TextView) view.findViewById(R.id.tv_delay);
                    if (delay != null)
                        delay.setText(((Lista_entrada) entrada).getDelay());

                    TextView power = (TextView) view.findViewById(R.id.tv_power);
                    if (power != null)
                        power.setText(((Lista_entrada) entrada).getPower());

                }
            }
        });

    }
}
