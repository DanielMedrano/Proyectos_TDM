package mx.edu.ittepic.judamedranoba.a122_laboratorio1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText EdtNombre;
    EditText EdtCelular;
    EditText EdtDireccion;
    EditText EdtFecha;
    EditText EdtHrInicio;
    EditText EdtHrFin;
    EditText EdtPlatillos;
    EditText EdtPostres;
    CheckBox ManBasica;
    CheckBox ManLujo;
    SeekBar Meseros;
    Button BtnGuardar;
    Button BtnLeer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EdtNombre = (EditText) findViewById(R.id.edt_nombre);
        EdtCelular = (EditText) findViewById(R.id.edt_celular);
        EdtDireccion = (EditText) findViewById(R.id.edt_direccion);
        EdtFecha = (EditText) findViewById(R.id.edt_Fecha);
        EdtHrInicio = (EditText) findViewById(R.id.edt_hrinicio);
        EdtHrFin = (EditText) findViewById(R.id.edt_hrfin);
        EdtPlatillos = (EditText) findViewById(R.id.edt_platillos);
        EdtPostres = (EditText) findViewById(R.id.edt_postres);
        ManBasica = (CheckBox) findViewById(R.id.ch_basica);
        ManLujo = (CheckBox) findViewById(R.id.ch_basica);
        Meseros = (SeekBar) findViewById(R.id.sk_meseros);
        BtnGuardar = (Button) findViewById(R.id.btn_guardar);
        BtnLeer = (Button) findViewById(R.id.btn_leer);

        BtnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSave();
            }
        });

        BtnLeer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataRecovery();
            }
        });

    }

    private void DataSave(){
        SharedPreferences datos=getSharedPreferences("data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=datos.edit();

        String nom=EdtNombre.getText().toString();
        String cel=EdtCelular.getText().toString();
        String dir=EdtDireccion.getText().toString();
        String fec=EdtFecha.getText().toString();
        String hri=EdtHrInicio.getText().toString();
        String hrf=EdtHrFin.getText().toString();
        String pla=EdtPlatillos.getText().toString();
        String pos=EdtPostres.getText().toString();
        Boolean mbas = ManBasica.isChecked();
        Boolean mluj = ManLujo.isChecked();
        int mes = Meseros.getProgress();

        editor.putString("nombre",nom);
        editor.putString("celular",cel);
        editor.putString("direccion",dir);
        editor.putString("fecha",fec);
        editor.putString("hora_inicio",hri);
        editor.putString("hora_fin",hrf);
        editor.putString("platillos",pla);
        editor.putString("postres",pos);
        editor.putBoolean("mbasica",mbas);
        editor.putBoolean("mlujo",mluj);
        editor.putInt("meseros",mes);

        editor.commit();

        EdtNombre.setText("");
        EdtCelular.setText("");
        EdtDireccion.setText("");
        EdtFecha.setText("");
        EdtHrInicio.setText("");
        EdtHrFin.setText("");
        EdtPlatillos.setText("");
        EdtPostres.setText("");
        ManBasica.setChecked(false);
        ManLujo.setChecked(false);
        Meseros.setProgress(0);

        Toast.makeText(getApplicationContext(),"Guardado",Toast.LENGTH_SHORT).show();
    }

    private void DataRecovery(){
        SharedPreferences datos=getSharedPreferences("data", Context.MODE_PRIVATE);

        String nom = datos.getString("nombre","");
        String cel = datos.getString("celular","");
        String dir = datos.getString("direccion","");
        String fec = datos.getString("fecha","");
        String hri = datos.getString("hora_inicio","");
        String hrf = datos.getString("hora_fin","");
        String pla = datos.getString("platillos","");
        String pos = datos.getString("postres","");
        Boolean bas = datos.getBoolean("mbasica",false);
        Boolean luj = datos.getBoolean("mlujo",false);
        int mes = datos.getInt("meseros",0);

        EdtNombre.setText(nom);
        EdtCelular.setText(cel);
        EdtDireccion.setText(dir);
        EdtFecha.setText(fec);
        EdtHrInicio.setText(hri);
        EdtHrFin.setText(hrf);
        EdtPlatillos.setText(pla);
        EdtPostres.setText(pos);
        ManBasica.setChecked(bas);
        ManLujo.setChecked(luj);
        Meseros.setProgress(mes);

    }

}
