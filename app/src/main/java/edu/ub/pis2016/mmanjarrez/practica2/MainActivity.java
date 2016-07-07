package edu.ub.pis2016.mmanjarrez.practica2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button agrega, muestra, muestrac, salir;
    private CtrlAsignaturas control;
    private ArrayList<Asignatura> asignaturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botones
        this.agrega = (Button) findViewById(R.id.agrega);
        this.muestra = (Button) findViewById(R.id.muestra);
        this.muestrac = (Button) findViewById(R.id.mostrarac);
        this.salir = (Button) findViewById(R.id.salir);

        // Instancia del controlador y de la clase para guardar los datos
        this.control = new CtrlAsignaturas();

        this.agrega.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comunicador.setObjeto(control);
                Intent intent = new Intent(MainActivity.this, ActivityAgregaAsignatura.class);
                startActivity(intent);

            }
        });

        this.muestra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comunicador.setObjeto(control);
                Intent intent = new Intent(MainActivity.this, ActivityMuestraAsignaturas.class);
                intent.putExtra("valor","noac");
                startActivity(intent);
            }
        });

        this.muestrac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comunicador.setObjeto(control);
                Intent intent = new Intent(MainActivity.this, ActivityMuestraAsignaturas.class);
                intent.putExtra("valor","ac");
                startActivity(intent);
            }
        });

        this.salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    public CtrlAsignaturas getControlador() {
        return this.control;
    }
}
