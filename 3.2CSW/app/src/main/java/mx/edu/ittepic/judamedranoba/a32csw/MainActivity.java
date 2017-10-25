package mx.edu.ittepic.judamedranoba.a32csw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    String json_string;
    String JSON_STRING;

    Button consultar;
    EditText localidad;
    TextView Clima;
    ImageView Img;
    TextView HL;
    TextView State;
    TextView Country;
    TextView Lu;
    String [] datos;
    WS http;
    String S;
    Bitmap bm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consultar = (Button) findViewById(R.id.consultar);
        localidad = (EditText) findViewById(R.id.tv_loc);
        Clima = (TextView) findViewById(R.id.clim);
        HL = (TextView) findViewById(R.id.hl);
        State = (TextView) findViewById(R.id.state);
        Country = (TextView) findViewById(R.id.country);
        Lu = (TextView) findViewById(R.id.lu);
        Img = (ImageView) findViewById(R.id.img);

        consultar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loc = localidad.getText().toString();
                S = "http://api.apixu.com/v1/current.json?key=b090462d0dbe4db1be5112352171210&q="+loc;
                http = new WS();
                http.execute(S, "1");
            }
        });

    }

    private class WS extends AsyncTask<String, Void, String> {
        URL url;
        @Override
        protected String doInBackground(String... params) {
            String cadena = "";
            if (params[1]== "1"){
                try {
                    url = new URL(S);
                    HttpURLConnection connection = null; // Abrir conexion
                    connection = (HttpURLConnection) url.openConnection();
                    int respuesta = 0;
                    respuesta = connection.getResponseCode();
                    InputStream inputStream = null;
                    inputStream = connection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder stringBuilder = new StringBuilder();

                    if (respuesta == HttpURLConnection.HTTP_OK) {
                        while ((json_string = bufferedReader.readLine()) != null) {
                            stringBuilder.append(json_string + "\n");
                        }
                        bufferedReader.close();
                        inputStream.close();
                        connection.disconnect();
                        String temporal = stringBuilder.toString();
                        JSONObject jsonObj = new JSONObject(temporal);
                        JSONObject location = jsonObj.getJSONObject("location");
                        JSONObject current = jsonObj.getJSONObject("current");
                        JSONObject condition = current.getJSONObject("condition");
                        cadena += current.getString("temp_c")+"º C"+","+location.getString("localtime")+","+"Estado: "+location.getString("region")+","+"Pais: "+location.getString("country")+","+"Ultima Actulización: "+current.getString("last_updated");
                        datos = cadena.split(",");

                        URL _url = new URL("http:"+condition.getString("icon"));
                        URLConnection con = _url.openConnection();
                        con.connect();
                        InputStream is = con.getInputStream();
                        BufferedInputStream bis = new BufferedInputStream(is);
                        bm = BitmapFactory.decodeStream(bis);
                        bis.close();
                        is.close();

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return  cadena;
        }


        @Override
        protected void onPostExecute(String result) {
            JSON_STRING = result;
            Clima.setText(datos[0]);
            HL.setText(datos[1]);
            State.setText(datos[2]);
            Country.setText(datos[3]);
            Lu.setText(datos[4]);
            Img.setImageBitmap(bm);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}
