package edu.ub.pis2016.mmanjarrez.practica2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by orla_ on 07/07/2016.
 */
public class ActivityModificaAsignatura extends AppCompatActivity {

    private Button aceptar, cancelar;
    private EditText nombre, profesor, cuatrimestre, curso, nota1;
    private RadioGroup radio;
    private TextView nota;
    private boolean finalizada;
    private CtrlAsignaturas objeto;
    private String acabada;
    private String pos;
    private RadioButton ra1,ra2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_asignatura);
        objeto = Comunicador.getObjeto();

        Intent i = getIntent();
        pos = i.getStringExtra("posicion");
        acabada = i.getStringExtra("valor");

        Asignatura asigna;
        if (acabada.equals("ac")) {
           asigna = objeto.getAsigAcabada(Integer.parseInt(pos));
        } else {
            asigna = objeto.getAsigCursando(Integer.parseInt(pos));
        }


        //TextView
        nota = (TextView) findViewById(R.id.nota2);

        // Botones
        this.aceptar = (Button) findViewById(R.id.aceptar2);
        this.cancelar = (Button) findViewById(R.id.cancelar2);

        // Edit Text
        this.nombre = (EditText) findViewById(R.id.nombre12);
        this.profesor = (EditText) findViewById(R.id.profesor12);
        this.cuatrimestre = (EditText) findViewById(R.id.cuatri12);
        this.curso = (EditText) findViewById(R.id.curso12);
        this.nota1 = (EditText) findViewById(R.id.nota12);

        this.nombre.setText(asigna.getNombre().toString());
        this.profesor.setText(asigna.getProfesor().toString());
        this.cuatrimestre.setText(asigna.getCuatrimestre().toString());
        this.curso.setText(asigna.getCurs().toString());



        //radioButon
        this.radio = (RadioGroup) findViewById(R.id.finalizada2);
        this.ra1 = (RadioButton) findViewById(R.id.Rb12);
        this.ra2 = (RadioButton) findViewById(R.id.Rb22);
        if (acabada.equals("ac")) {
            this.nota1.setText(asigna.getNota().toString());
            nota.setVisibility(View.VISIBLE);
            nota1.setVisibility(View.VISIBLE);
            ra1.setChecked(true);
            ra2.setChecked(false);
        } else {
            this.nota1.setText(asigna.getNota().toString());
            nota.setVisibility(View.INVISIBLE);
            nota1.setVisibility(View.INVISIBLE);
            ra1.setChecked(false);
            ra2.setChecked(true);
        }
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch(checkedId) {
                    case R.id.Rb12:
                        finalizada = true;
                        nota.setVisibility(View.VISIBLE);
                        nota1.setVisibility(View.VISIBLE);
                        break;
                    case R.id.Rb22:
                        finalizada = false;
                        nota.setVisibility(View.INVISIBLE);
                        nota1.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        });

        this.aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                objeto.setNombre(nombre.getText().toString());
                objeto.setCurs(curso.getText().toString());
                if (finalizada) {
                    objeto.setNota(nota1.getText().toString());
                } else {
                    objeto.setNota("Cursando");
                }
                objeto.setCuatrimestre(cuatrimestre.getText().toString());
                objeto.setProfesor(profesor.getText().toString());
                objeto.setFinalizada(finalizada);
                objeto.eliminaAsignatura(acabada,Integer.parseInt(pos));
                objeto.modificaAsignatura();
                Intent intent = new Intent(ActivityModificaAsignatura.this, ActivityMuestraAsignaturas.class);
                intent.putExtra("valor",acabada);
                startActivity(intent);
                finish();


            }
        });

        this.cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }

}
