package mx.edu.ittepic.judamedranoba.a211_persistenciabasica;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText EdtNombre;
    EditText EdtNumControl;
    EditText EdtCorreo;
    Button BtnGuardar;
    Button BtnLeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EdtNombre = (EditText) findViewById(R.id.edt_nombre);
        EdtNumControl = (EditText) findViewById(R.id.edt_control);
        EdtCorreo = (EditText) findViewById(R.id.edt_correo);
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
        String con=EdtNumControl.getText().toString();
        String cor=EdtCorreo.getText().toString();

        editor.putString("nombre",nom);
        editor.putString("control",con);
        editor.putString("correo",cor);

        editor.commit();

        EdtNombre.setText("");
        EdtNumControl.setText("");
        EdtCorreo.setText("");
       // Toast.makeText(getApplicationContext(),"Saved"+getEmojiByUnicode(0x1F44D),Toast.LENGTH_SHORT).show();
    }

    private void DataRecovery(){
        SharedPreferences datos=getSharedPreferences("data", Context.MODE_PRIVATE);

        String nom=datos.getString("nombre","Nada guardado");
        String con=datos.getString("control","");
        String cor=datos.getString("correo","");

        EdtNombre.setText(nom);
        EdtNumControl.setText(con);
        EdtCorreo.setText(cor);

        //Toast.makeText(getApplicationContext(),"Recuperado"+getEmojiByUnicode(0x1F44D),Toast.LENGTH_SHORT).show();
    }

    /*public String getEmojiByUnicode(int unicode){
        return new String(Character.toChars(unicode));
    }*/

}
