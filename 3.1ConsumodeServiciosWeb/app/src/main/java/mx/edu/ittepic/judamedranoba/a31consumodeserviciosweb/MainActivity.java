package mx.edu.ittepic.judamedranoba.a31consumodeserviciosweb;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    Button btn ;
    TextView res;
    WServices http;
    String GET_TODO = "http://api.openweathermap.org/data/2.5/weather?q=Tepic,mx&APPID=43c15c5563c8a024f16293f4e47a282e";
    String json_string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);
        res = (TextView) findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                http = new WServices();
                http.execute(GET_TODO, "1");
            }
        });
    }

    public class WServices extends AsyncTask<String, Void, String> {
        URL url;
        @Override
        protected String doInBackground(String... params) {
            String cadena = "";
            if (params[1]== "1"){
                try {
                    url = new URL(GET_TODO);
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
                        JSONArray clima = jsonObj.getJSONArray("weather");
                        JSONObject uno = clima.getJSONObject(0);
                        JSONObject main = jsonObj.getJSONObject("main");
                        JSONObject wind = jsonObj.getJSONObject("wind");
                        JSONObject clouds = jsonObj.getJSONObject("clouds");
                        JSONObject sys = jsonObj.getJSONObject("sys");
                        /*"weather":[{"id":802,"main":"Clouds","description":"scattered clouds","icon":"03d"}],
                        "base":"stations","main":{"temp":282.15,"pressure":1016,"humidity":87,"temp_min":282.15,"temp_max":282.15},
                        "visibility":16093,"wind":{"speed":1.47,"deg":116.002},"clouds":{"all":40},"dt":1493902320,
                        "sys":{"type":1,"id":4020,"message":1.7872,"country":"MX","sunrise":1493900769,"sunset":1493947602},
                        "id":3981941,"name":"Tepic","cod":200}*/
                        cadena += "CLIMA"+"\n" +"ID: "+uno.getString("id")+" MAIN: "+uno.getString("main")+" DESCRIPTION: "+
                                uno.getString("description")+" ICON: "+uno.getString("icon")+
                                "\n"+" BASE: "+jsonObj.getString("base")+
                                "\n"+"MAIN"+
                                "\n"+"TEMP: "+main.getString("temp")+" PRESSURE: "+main.getString("pressure")+" HUMIDITY: "+
                                main.getString("humidity")+" TEMP_MIN: "+main.getString("temp_min")+" TEMP_MAX: "+main.getString("temp_max")+
                                "\n"+"VISIBILITY: "+jsonObj.getString("visibility")+
                                "\n"+"WIND"+
                                "\n"+"SPEED: "+wind.getString("speed")+" DEG: "+wind.getString("deg")+
                                "\n"+"CLOUDS"+
                                "\n"+"ALL: "+clouds.getString("all")+
                                "\n"+"DT: "+jsonObj.getString("dt")+
                                "\n"+"SYS"+
                                "\n"+"TYPE: "+sys.getString("type")+" ID: "+sys.getString("id")+" MESSAGE: "+sys.getString("message")+
                                " COUNTRY: "+sys.getString("country")+ " SUNRISE: "+sys.getString("sunrise")+" SUNSET: "+sys.getString("sunset")+
                                "\n"+"ID: "+jsonObj.getString("id")+
                                "\n"+"NAME: "+jsonObj.getString("name")+
                                "\n"+"COD: "+jsonObj.getString("cod");

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return  cadena;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            res.setText(s);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }
    }
}