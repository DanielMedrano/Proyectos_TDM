package mx.edu.ittepic.judamedranoba.a15datos_entreactivities;

import android.content.ClipDescription;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static mx.edu.ittepic.judamedranoba.a15datos_entreactivities.R.id.tv2;

public class Main2Activity extends AppCompatActivity {

    EditText Edit2;
    TextView Txt2;
    Button Butn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Edit2 = (EditText) findViewById(R.id.edt2);
        Txt2 = (TextView) findViewById(tv2);
        Butn2 = (Button) findViewById(R.id.btn2);

        Txt2.setText(getIntent().getExtras().get("parametro").toString());

        Butn2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                intent.putExtra("parametro2", Edit2.getText().toString());
                startActivity(intent);
            }
        });

    }
}
