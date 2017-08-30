package mx.edu.ittepic.judamedranoba.tabla12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtTitulo;
    TextView txtSbar;
    SeekBar skBar;
    TextView txtRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitulo = (TextView) findViewById(R.id.txt_titulo);
        txtSbar = (TextView) findViewById(R.id.txt_sbar);
        skBar = (SeekBar) findViewById(R.id.sk_bar);
        txtRes = (TextView) findViewById(R.id.txt_res);


        //Implementar metodos para mostrar en un textview el numero de progreso
        skBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar skBar, int progress, boolean b) {
                txtSbar.setText(progress+"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                int numero = skBar.getProgress();

                String resultado = getTabla(numero);
                txtRes.setText(resultado);
            }
        });
    }

    //Metodos para mostrar tabla de multiplicar
    public String getTabla(int num){
        String cad = num+"\n";
        int n = num;
        for(int i=1; i<=10; i++){
            cad = cad+ i +"x"+n+"="+i*n+"\n";
        }
        return cad;
    }
}
