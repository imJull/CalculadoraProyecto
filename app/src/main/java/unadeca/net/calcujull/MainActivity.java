package unadeca.net.calcujull;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        //Declaracion de variables

        final EditText tx1 = findViewById(R.id.txto1);
        final EditText tx2 = findViewById(R.id.txto2);
        Button btsum = findViewById(R.id.btnsumar);
        Button btres = findViewById(R.id.btnrestar);
        Button btmul = findViewById(R.id.btnmultiplicar);
        Button btdiv = findViewById(R.id.btndividir);
        final TextView txresp = findViewById(R.id.respuesta);

        // Funcionalidad del boton sumar

        btsum.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                validacion(tx1, tx2);
                txresp.setText(String.format(Locale.getDefault(),
                            "%d" , suma(Integer.parseInt(tx1.getText().toString()), Integer.parseInt(tx2.getText().toString()))));


            }
        });
            //Funcionalidad del boton restar
        btres.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                validacion(tx1, tx2);
                txresp.setText(String.format(Locale.getDefault(),
                        "%d" , resta(Integer.parseInt(tx1.getText().toString()), Integer.parseInt(tx2.getText().toString()))));


            }
        });

        //funcionalidad del boton de multiplicacion
        btmul.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                validacion(tx1, tx2);
                txresp.setText(String.format(Locale.getDefault(),
                        "%d" , multiplicacion(Integer.parseInt(tx1.getText().toString()), Integer.parseInt(tx2.getText().toString()))));


            }
        });
        // Funcionalidad del boton de division
        btdiv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                validacion(tx1, tx2);
                txresp.setText(String.format(Locale.getDefault(),
                        "%g" , dividir(Float.parseFloat(tx1.getText().toString()), Float.parseFloat(tx2.getText().toString()))));


            }


        });




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

        //Se encuentran las funciones matemáticas de resta, suma, multiplicación y division; las cuales se declaran en las funcionalidades de los botones
        //Tambien se incluye la funcion para validar posibles errores. Valida el de los espacios e blanco
        private int suma(int N1,int N2){
            return N1+N2;
        }

        private int resta(int N1,int N2){
            return N1-N2;
        }

        private int multiplicacion(int N1,int N2){
            return N1*N2;
        }

        private float dividir(float N1,float N2){
            return N1/N2;
        }



        private boolean validacion(EditText tx1, EditText tx2){
            boolean validerror = true;

            if (tx1.getText().toString().isEmpty()){
                tx1.setText("0");
                validerror = false;
            }
            if (tx2.getText().toString().isEmpty()){
                tx2.setText("0");
                validerror = false;
            } return validerror;


        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
