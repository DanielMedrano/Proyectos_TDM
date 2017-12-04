package com.example.juandaniel.callogcontentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.texto);
        ObtenerDatosLlamadas();
    }


    public void ObtenerDatosLlamadas() {

        Uri uri;

        uri = Uri.parse("content://call_log/calls");

        String[] projeccion = new String[]{CallLog.Calls.TYPE, CallLog.Calls.NUMBER, CallLog.Calls.DURATION};



        Cursor c = getContentResolver().query(
                uri,
                projeccion,
                null,
                null,
                null);

        textView.setText("");


        while(c.moveToNext()){
            textView.append("Tipo: " + c.getString(0) + " Número: " + c.getString(1) + " Duración: " + c.getString(2) +"\n");
        }
        c.close();

    }

}
