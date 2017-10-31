package mx.edu.ittepic.judamedranoba.a42laboratorio;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button Calcular;
    EditText Numero;
    TextView Datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calcular = (Button) findViewById(R.id.btn_cal);
        Numero = (EditText) findViewById(R.id.edt_num);
        Datos = (TextView) findViewById(R.id.tv_datos);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               new calcula().execute();
            }
        });

    }

    private class calcula extends AsyncTask<StringBuilder, Object, StringBuilder> {

        int num = Integer.parseInt(Numero.getText().toString());
        int res;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected StringBuilder doInBackground(StringBuilder... strings) {
            StringBuilder li= new StringBuilder();
            for(int i=1; i<=10; i++){
                res = i*num;
                li.append(num+" x "+i+" = "+res+"\n");
            }
            return li;
        }

        @Override
        protected void onProgressUpdate(Object... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(StringBuilder s) {
            Datos.setText(s.toString());
        }
    }
}
