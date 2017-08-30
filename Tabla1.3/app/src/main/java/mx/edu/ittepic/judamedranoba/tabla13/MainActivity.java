package mx.edu.ittepic.judamedranoba.tabla13;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView txtTitulo;
    TextView txtSbar;
    SeekBar skBar;
    ArrayList<String> table;
    ListView lvRes;
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = (TextView) findViewById(R.id.txt_titulo);
        txtSbar = (TextView) findViewById(R.id.txt_sbar);
        skBar = (SeekBar) findViewById(R.id.sk_bar);

        table=new ArrayList<String>();
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, table);
        lvRes = (ListView) findViewById(R.id.lv_res);
        lvRes.setAdapter(adaptador);

        lvRes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"Ha presionado "+ table.get(i),Toast.LENGTH_SHORT).show();
            }
        });

        //Implementar metodos para mostrar en un textview el numero de progreso
        skBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar skBar, int progress, boolean b) {
                txtSbar.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if (!table.isEmpty())table.clear();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                getTable(skBar.getProgress());
                lvRes.setAdapter(adaptador);
            }
        });

    }

    //Metodos para mostrar tabla de multiplicar
    public void getTable(int num){
        String cad;
        int n = num;
        for(int i=1; i<=10; i++){
            cad = i +" x "+n+" = "+i*n;
            table.add(cad);
        }
    }

}
