package mx.edu.ittepic.judamedranoba.menu_recetas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RecetaActivity extends AppCompatActivity {

    ImageView img;
    TextView name;
    TextView conte;
    Integer i;
    String[] nomrecetas;
    Integer[] imgrecetas;
    String[] conrecetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta);

        img = (ImageView) findViewById(R.id.imv_plato);
        name = (TextView) findViewById(R.id.tv_nombre);
        conte = (TextView) findViewById(R.id.tv_proceso);

        nomrecetas = new String[]{"Chiles en Nogada",
                "Lomo Relleno",
                "Chilaquiles Verdes",
                "Camarones Empanizados",
                "Aguachile",
                "Chicharrón de Pescado",
                "Pollo en Crema",
                "Empanadas de Camarón",
                "Pozole"};
        imgrecetas = new Integer[]{R.drawable.chiles,
                R.drawable.lomo,
                R.drawable.chilaquiles,
                R.drawable.camaempa,
                R.drawable.aguachile,
                R.drawable.chicharron,
                R.drawable.pollo,
                R.drawable.empanadas,
                R.drawable.pozole};
        conrecetas = new String[]{"Preparación:\n" +
                "\n" +
                "1. Se cortan todas las frutas en cubitos.\n" +
                "2. Se tuestan las almendras y los piñones.\n" +
                "3. Se pican el ajo y la cebolla, y se acitronan en un poco de aceite vegetal.\n" +
                "4. Se agrega la carne y se sazona con sal y pimienta.\n" +
                "5. Cuando esté bien cocida la carne, se reserva.\n" +
                "6. En el mismo sartén, se agrega un poco más de aceite y se fríen las frutas, empezando por el plátano.\n" +
                "7. Cuando las frutas empiecen a soltar los jugos, se retiran del fuego y se agregan a la carne, al igual que las almendras, los piñones y las pasas.\n" +
                "8. Se revuelve todo y se deja cocinar tres minutos más a fuego medio. Se retira del fuego y se deja enfriar.\n" +
                "9. Se licúan los quesos, la crema, la leche y las nueces en la licuadora.\n" +
                "10. Para servir, se vierte la crema en el plato, se colocan los chiles encima, se rellenan con la carne y se cubre con la granada y nueces picadas. *También se acostumbra agregar perejil picado a la decoración.",
                "Preparación:\n" +
                        "Horno Precalentado a 190° C\n" +
                        "Funde la mantequilla en una sartén,fríe el tocino con la cebolla y el ajo hasta que estén ligeramente dorados;agrega el puré de papa y el agua, mezcla hasta integrar.\n" +
                        "Agrega las aceitunas,los arándanos, las nueces, la sal, la pimienta y el romero.\n" +
                        "Extiende el lomo y salpimenta por ambos lados. Rellena el lomo con la mezcla anterior,enrolla y amarra.\n" +
                        "Coloca el lomo en una charola para horno, tapa con papel aluminio y hornea durante una hora.\n" +
                        "Retira el papel aluminio y hornea por 25 minutos más o hasta que este dorado.\n",
                "Preparación:\n" +
                        "En una olla ponga los tomates verdes sin cascara y los chiles y rellene con agua hasta que los cubra. Ponga sobre fuego bajo.\n" +
                        "Pase los tomates, los chiles y 1/3 del agua en el que se cocieron a la licuadora y haga puree hasta que se forme una salsa.\n" +
                        "En otra olla grande, ponga la salsa, sazone con sal y cocine sobre fuego medio hasta que se reduzca un poco y se concentren los sabores, unos 5 minutos. Mantenga caliente.\n" +
                        "En un sartén grande, ponga como 1 cm de aceite. Fría la mitad de las tortillas hasta que se doren un poco, unos 3 minutos.\n" +
                        "Repita el paso anterior con el resto de las tortillas.\n" +
                        "Ponga las tortillas sobre toalla de cocina desechables para escurrir un poco la grasa.\n" +
                        "Deje 1/4 de taza del aceite que se utilizó y regrese todas las tortillas al sartén.\n" +
                        "Agregue la cebolla y tape el sartén. Deje que se cocine hasta que este traslucido, unos 4 minutos. Mueva de vez en cuando para que no se dore o queme.\n" +
                        "Agregue la salsa y cocine moviendo otros 3 minutos.\n" +
                        "Sirva los chilaquiles y ponga crema, queso fresco y cilantro picado encima.",
                "Preparación:\n" +
                        "Calienta el aceite a 180 ºC una cacerola de hierro o una freidora eléctrica.\n" +
                        "Mezcla el agua con la fécula de maíz y los huevos.\n" +
                        "Sumerge los camarones, uno por uno, en la mezcla anterior, luego cubre con el pan molido. Pasa de nuevo por la mezcla de fécula y revuelca una vez más en el pan.\n" +
                        "Con mucho cuidado coloca los camarones en el aceite caliente y fríe hasta que se doren perfectamente.",
                "Preparación:\n" +
                        "Exprime el jugo de los limones en un refractario de vidrio. Agrega la cebolla rebanada, el pepino, salpimenta y agrega un poco de chile al gusto.\n" +
                        "Te recomiendo probar la mezcla anterior para que no te pases de chile, puedes agregar poco a poco.\n" +
                        "Deja dentro del refrigerador la preparación por 15 minutos.\n" +
                        "Mientras limpia y pela los camarones. Lávalos bien y sirve dentro del refractario.\n" +
                        "Mezcla bien. Puedes servir enseguida o esperar a que cambie de color el camarón, esto es al gusto.",
                "Preparación:\n" +
                        "Mezclar el aderezo, sal, pimienta y el jugo de limón en un tazón . Agregar el pescado en trozos y cubrir bien, refrigerar tapado durante 1 hora para marinar. Sacar, escurrir y deshechar la marinada.\n" +
                        "Mezclar la harina, la pimienta y el chile en polvo en otro tazón, ir agregando poco a poco el pescado en trozos cubriéndolos por todos lados y colocar en un plato grande.\n" +
                        "Calentar el aceite en un sartén grande, agregar por tandas los trozos de pescado, cocinar de 12 a 15 minutos hasta que estén bien dorados y se cocinen por completo. Pasar el pescado ya cocinado en un molde para hornear, cubrir con papel aluminio y calentar en el horno por 10 min antes de servir.",
                "Preparación:\n" +
                        "Agregar 1 cucharada de margarina en una sartén, esperar a que esté caliente y agregar las cebollas y ajo picado . Acitronar.\n" +
                        "Agregar la crema, los champiñones drenados y salpimentar.\n" +
                        "Cocinar a fuego bajo hasta que los champiñones estén tiernos. Reservar.\n" +
                        "Colocar 1 cucharada de margarina en la sartén, dorar el pollo por ambos lados, esperar hasta que este bien cocido al centro.\n" +
                        "Servir con la salsa de champiñones y espolvorear perejil picado.",
                "Preparación:\n" +
                        "Revolver la masa con el achiote disuelto en un poco de vinagre o agua y poca sal. Picar media cebolla y acitronar en aceite; agregar los camarones picados, aceitunas, chiles en vinagre y el jitomate rojo. Hacer una tortillita con la masa, rellenar con el camarón guisado y doblar como empanada. Freír en aceite y dejar escurrir en papel absorbente. Introducirlas en la salsa verde; retirar y servir. Para preparar la salsa se deben moler los tomates pelados y cocidos con media cebolla, ajo, cilantro y chiles; freír todo junto. Servir.",
                "Preparación:\n" +
                        "Coloca el maíz en una olla grande, cubre con agua, agrega el ajo y sal al gusto y cocina a fuego medio durante 2 horas y agrega la cabeza de ajo.\n" +
                        "Después de ese tiempo, agrega la carne a la olla y cocina durante 1 hora o hasta que la carne esté bien suave.\n" +
                        "Remoja los chiles en agua caliente hasta que estén suaves, quítales las semillas y el rabo y muélelos, Cuela.\n" +
                        "Vierte la salsa roja dentro de la olla con el maíz y deja que suelte el hervor, rectifica la sazón y deja que hierva unos minutos más antes de servir."};

                mostrar(parametro());

    }


    private Integer parametro() {
        i = (Integer) getIntent().getExtras().getSerializable("parametro");
        return i;
    }

    private void mostrar(int parametro){
        img.setImageResource(imgrecetas[parametro]);
        name.setText(nomrecetas[parametro]);
        conte.setText(conrecetas[parametro]);
    }

}
