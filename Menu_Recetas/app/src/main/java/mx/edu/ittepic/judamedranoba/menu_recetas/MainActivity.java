package mx.edu.ittepic.judamedranoba.menu_recetas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView Lv;
    ArrayList<Lista_entrada> datos;
    ArrayAdapter<String> adaptador;
    String[] nomrecetas;
    Integer[] imgrecetas;
    String[] conrecetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datos = new ArrayList<Lista_entrada>();

        nomrecetas = new String[]{"Chiles en Nogada",
                                "Lomo Relleno",
                                "Chilaquiles Verdes",
                                "Camarones Empanizados",
                                "Aguachile",
                                "Chicharrón de Pescado",
                                "Pollo en Crema",
                                "Empanadas de Camarón",
                                "Pozole"};

        imgrecetas = new Integer[]{R.drawable.chiles,
                                    R.drawable.lomo,
                                    R.drawable.chilaquiles,
                                    R.drawable.camaempa,
                                    R.drawable.aguachile,
                                    R.drawable.chicharron,
                                    R.drawable.pollo,
                                    R.drawable.empanadas,
                                    R.drawable.pozole};

        for (int i=0; i < nomrecetas.length; i++)
            datos.add(new Lista_entrada(imgrecetas[i], nomrecetas[i]));


        Lv = (ListView) findViewById(R.id.lv);
        Lv.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Lista_entrada) entrada).get_textoEncima());

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
                }
            }
        });


        Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adap, View view, int posicion, long id) {
                Intent intent = new Intent(MainActivity.this, RecetaActivity.class);
                intent.putExtra("parametro", posicion);
                startActivity(intent);
            }
        });

    }
}
