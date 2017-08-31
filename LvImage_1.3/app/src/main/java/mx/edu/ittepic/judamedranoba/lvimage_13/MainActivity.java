package mx.edu.ittepic.judamedranoba.lvimage_13;

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
    String[] nombre;
    String[] nocontrol;
    String[] carrera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datos = new ArrayList<Lista_entrada>();

        nombre = new String[]{"ABREGO DELGADO ALEXIA ARIANA",
                "CARO LOPEZ LUIS RICARDO" ,
                "CARVAJAL GUTIERREZ RAUL RAFAEL" ,
                "CASILLAS UREÑA FERMIN MICHET" ,
                "CRESPO DURAN PABLO ARTURO" ,
                "ESPINO SERRANO CESAR RAMSES" ,
                "ESPINOZA ORONIA CARLOS EDUARDO" ,
                "FREGOSO CORONA JESÚS EDUARDO" ,
                "GALAVIZ ARROYO OLIVER JASIEL" ,
                "GALINDO DELGADO DONADONY DONAJI" ,
                "GONZALEZ CASTELLANOS EDGAR FABRIZIO" ,
                "HERNANDEZ SANDOVAL ABRIL YARELI" ,
                "JIMENEZ ORTIZ JUAN DANIEL" ,
                "LIZOLA CHAVARÍN LUIS FERNANDO" ,
                "MEDRANO BARAJAS JUAN DANIEL" ,
                "RAMIREZ GARCIA JUAN RAMON" ,
                "RODRIGUEZ ADAME OLIVER GIOVANNY" ,
                "SANCHEZ JIMENEZ ANA PATRICIA" ,
                "SÁNCHEZ PARTIDA HÉCTOR OMAR" ,
                "VALDEZ CORREA CARLOS GERMAN" ,
                "CARRILLO GONZÁLEZ CARLOS ARTURO" ,
                "HERNANDEZ BAEZA JAVIER" ,
                "IBARRA MARAVILLAS JONATHAN GUADALUPE" ,
                "MARIN BAUTISTA IRVING ALDAHYR" ,
                "OCAMPO AGUILAR JESÚS ANDRÉS" ,
                "SALAZAR NAVARRO IRAN JAIR" ,
                "TEJEDA MORA CESAR"};

        nocontrol = new String[]{"13400378" ,
                "13400395" ,
                "13400396" ,
                "12400256" ,
                "13400397" ,
                "13400402" ,
                "12401119" ,
                "13400405" ,
                "13400406" ,
                "13400408" ,
                "13400419" ,
                "13400430" ,
                "13400436" ,
                "13400441" ,
                "13400457" ,
                "13400478" ,
                "13400507" ,
                "13400491" ,
                "12400322" ,
                "12400326" ,
                "13401087" ,
                "13401367" ,
                "13401097" ,
                "12400663" ,
                "13401100" ,
                "11400309" ,
                "13401105"};

        carrera = new String[]{"ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ISC" ,
                "ITIC" ,
                "ITIC" ,
                "ITIC" ,
                "ITIC" ,
                "ITIC" ,
                "ITIC" ,
                "ITIC"};


        for (int i=0; i < nombre.length; i++)
        datos.add(new Lista_entrada(R.drawable.facebook, nombre[i], nocontrol[i]+" - "+carrera[i]));


        Lv = (ListView) findViewById(R.id.lv);
        Lv.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                if (entrada != null) {
                    TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
                    if (texto_superior_entrada != null)
                        texto_superior_entrada.setText(((Lista_entrada) entrada).get_textoEncima());

                    TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior);
                    if (texto_inferior_entrada != null)
                        texto_inferior_entrada.setText(((Lista_entrada) entrada).get_textoDebajo());

                    ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen);
                    if (imagen_entrada != null)
                        imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
                }
            }
        });

        /*
        https://jarroba.com/listview-o-listado-en-android/

        Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                Lista_entrada elegido = (Lista_entrada) pariente.getItemAtPosition(posicion);
                CharSequence texto = "Seleccionado: " + elegido.get_textoDebajo();
                Toast.makeText(MainActivity.this, texto, Toast.LENGTH_LONG).show();
            }
        });


        Lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Ha presionado "+ table.get(i),Toast.LENGTH_SHORT).show();
            }
        });*/
    }
}
