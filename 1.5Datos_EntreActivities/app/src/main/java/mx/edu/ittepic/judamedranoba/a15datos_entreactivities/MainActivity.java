package mx.edu.ittepic.judamedranoba.a15datos_entreactivities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText Edit;
    TextView Txt;
    Button Butn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Edit = (EditText) findViewById(R.id.edt);
        Txt = (TextView) findViewById(R.id.tv);
        Butn = (Button) findViewById(R.id.btn);

        Bundle parametros = this.getIntent().getExtras();
        if(parametros != null) {
            String datos = parametros.getString("parametro2");
            Txt.setText(datos);}

        Butn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("parametro", Edit.getText());
                startActivity(intent);
            }
        });

    }

}
