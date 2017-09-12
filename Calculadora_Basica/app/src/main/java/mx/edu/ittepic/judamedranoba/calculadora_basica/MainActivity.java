package mx.edu.ittepic.judamedranoba.calculadora_basica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText EdtNum;
    Button Btn0;
    Button Btn1;
    Button Btn2;
    Button Btn3;
    Button Btn4;
    Button Btn5;
    Button Btn6;
    Button Btn7;
    Button Btn8;
    Button Btn9;
    Button BtnMas;
    Button BtnMenos;
    Button BtnPor;
    Button BtnEntre;
    Button BtnMM;
    Button BtnIgual;
    Float Var;
    Float Var1;
    Float Var2;
    Integer Operacion;
    Boolean Bandera = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EdtNum = (EditText) findViewById(R.id.edt_num);
        Btn0 = (Button) findViewById(R.id.btn_0);
        Btn1 = (Button) findViewById(R.id.btn_1);
        Btn2 = (Button) findViewById(R.id.btn_2);
        Btn3 = (Button) findViewById(R.id.btn_3);
        Btn4 = (Button) findViewById(R.id.btn_4);
        Btn5 = (Button) findViewById(R.id.btn_5);
        Btn6 = (Button) findViewById(R.id.btn_6);
        Btn7 = (Button) findViewById(R.id.btn_7);
        Btn8 = (Button) findViewById(R.id.btn_8);
        Btn9 = (Button) findViewById(R.id.btn_9);
        BtnMas = (Button) findViewById(R.id.btn_mas);
        BtnMenos = (Button) findViewById(R.id.btn_menos);
        BtnPor = (Button) findViewById(R.id.btn_por);
        BtnEntre = (Button) findViewById(R.id.btn_entre);
        BtnMM = (Button) findViewById(R.id.btn_mm);
        BtnIgual = (Button) findViewById(R.id.btn_igual);

        EdtNum.setEnabled(false);

        Btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EdtNum.setText(EdtNum.getText() + "0");
                Indicador();
            }
        });

        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EdtNum.setText(EdtNum.getText() + "1");
                Indicador();
            }
        });

        Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EdtNum.setText(EdtNum.getText() + "2");
                Indicador();
            }
        });

        Btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EdtNum.setText(EdtNum.getText() + "3");
                Indicador();
            }
        });

        Btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EdtNum.setText(EdtNum.getText() + "4");
                Indicador();
            }
        });

        Btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EdtNum.setText(EdtNum.getText() + "5");
                Indicador();
            }
        });

        Btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EdtNum.setText(EdtNum.getText() + "6");
                Indicador();
            }
        });

        Btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EdtNum.setText(EdtNum.getText() + "7");
                Indicador();
            }
        });

        Btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EdtNum.setText(EdtNum.getText() + "8");
                Indicador();
            }
        });

        Btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EdtNum.setText(EdtNum.getText() + "9");
                Indicador();
            }
        });

        BtnMas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Var1 = Float.parseFloat(EdtNum.getText() + "");
                EdtNum.setText("");
                Operacion = 0;
            }
        });

        BtnMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Var1 = Float.parseFloat(EdtNum.getText() + "");
                EdtNum.setText("");
                Operacion = 1;
            }
        });

        BtnPor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Var1 = Float.parseFloat(EdtNum.getText() + "");
                EdtNum.setText("");
                Operacion = 2;
            }
        });

        BtnEntre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Var1 = Float.parseFloat(EdtNum.getText() + "");
                EdtNum.setText("");
                Operacion = 3;
            }
        });

        BtnMM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Var = Float.parseFloat(EdtNum.getText() + "");
                EdtNum.setText(Var * -1 + "");
            }
        });

        BtnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Var2 = Float.parseFloat(EdtNum.getText() + "");
                EdtNum.setText(Calculo(Var1,Var2,Operacion)+"");
                Bandera = true;
            }
        });
    }

        private float Calculo(float Num1, float Num2, int Oper){
            float Resultado=0;
            switch (Oper) {
                case 0:
                    Resultado = Num1 + Num2;
                    break;
                case 1:
                    Resultado = Num1 - Num2;
                    break;
                case 2:
                    Resultado = Num1 * Num2;
                    break;
                case 3:
                    Resultado = Num1 / Num2;
                    break;
                default:
                    Resultado = 0;
                    break;
            }
            return Resultado;
        }

        private void Indicador(){
            if(Bandera==true){
                EdtNum.setText("");
                Bandera=false;
            }
        }

    }
