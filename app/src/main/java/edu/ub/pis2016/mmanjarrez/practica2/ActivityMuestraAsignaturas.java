package edu.ub.pis2016.mmanjarrez.practica2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mmanjaag7.alumnes on 03/06/16.
 */
public class ActivityMuestraAsignaturas extends AppCompatActivity {
    private CtrlAsignaturas control;
    private ListView lista;
    private String valor;
    private ArrayList<Asignatura> asignaturas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muestra_asignatura);
        control = Comunicador.getObjeto();

        lista = (ListView) findViewById(R.id.lista);

        Intent i = getIntent();
        valor = i.getStringExtra("valor");

        this.asignaturas = new ArrayList<Asignatura>();

        if (valor.equals("ac")) {
            this.asignaturas = control.muestraAsignaturas(true);
        } else {
            this.asignaturas = control.muestraAsignaturas(false);
        }

        this.lista.setAdapter(new AsignaturaaAdapter(this, asignaturas));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {

                Asignatura item = (Asignatura) lista.getAdapter().getItem(position);
                Intent intent = new Intent(ActivityMuestraAsignaturas.this, VisionAsignatura.class);
                intent.putExtra("nombre",item.getNombre());
                intent.putExtra("prof",item.getProfesor());
                intent.putExtra("cuatri",item.getCuatrimestre());
                intent.putExtra("nota",item.getNota());
                intent.putExtra("curs",item.getCurs());
                if (valor.equals("ac")) {
                    intent.putExtra("acabada", "ac");
                } else {
                    intent.putExtra("acabada", "noac");
                }
                intent.putExtra("posicion",Integer.toString(position));

                startActivity(intent);
                finish();

            }
        });


    }



}
