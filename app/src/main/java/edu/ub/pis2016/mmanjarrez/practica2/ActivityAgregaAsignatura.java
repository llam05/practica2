package edu.ub.pis2016.mmanjarrez.practica2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Agregar Asignatura
 */
public class ActivityAgregaAsignatura extends AppCompatActivity {

    private Button aceptar, cancelar;
    private EditText nombre, profesor, cuatrimestre, curso, nota1;
    private RadioGroup radio;
    private TextView nota;
    private boolean finalizada = false;
    private CtrlAsignaturas objeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_asignatura);
        objeto = Comunicador.getObjeto();



        //TextView
        nota = (TextView) findViewById(R.id.nota);

        // Botones
        this.aceptar = (Button) findViewById(R.id.aceptar);
        this.cancelar = (Button) findViewById(R.id.cancelar);

        // Edit Text
        this.nombre = (EditText) findViewById(R.id.nombre1);
        this.profesor = (EditText) findViewById(R.id.profesor1);
        this.cuatrimestre = (EditText) findViewById(R.id.cuatri1);
        this.curso = (EditText) findViewById(R.id.curso1);
        this.nota1 = (EditText) findViewById(R.id.nota1);

        //radioButon
        this.radio = (RadioGroup) findViewById(R.id.finalizada);
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch(checkedId) {
                    case R.id.Rb1:
                        finalizada = true;
                        nota.setVisibility(View.VISIBLE);
                        nota1.setVisibility(View.VISIBLE);
                        break;
                    case R.id.Rb2:
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
                objeto.agregaAsignatura();
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
