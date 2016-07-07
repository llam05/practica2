package edu.ub.pis2016.mmanjarrez.practica2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VisionAsignatura extends AppCompatActivity {

    TextView asig, prof, cuatri, nota, curs;
    Button volver, modifica, elimina;
    CtrlAsignaturas control;
    String acabada;
    String pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vision_asignatura);

        this.control = Comunicador.getObjeto();

        this.asig = (TextView) findViewById(R.id.asig);
        this.prof = (TextView) findViewById(R.id.profe1);
        this.cuatri = (TextView) findViewById(R.id.cuatri1);
        this.nota = (TextView) findViewById(R.id.nota1);
        this.curs = (TextView) findViewById(R.id.curso1);

        this.elimina = (Button) findViewById(R.id.eliminar);
        this.modifica = (Button) findViewById(R.id.modifi);
        this.volver = (Button) findViewById(R.id.volver);

        Intent i = getIntent();
        String snombre = i.getStringExtra("nombre");
        String sprofe = i.getStringExtra("prof");
        String scuatri = i.getStringExtra("cuatri");
        String snota = i.getStringExtra("nota");
        String scurs = i.getStringExtra("curs");
        pos = i.getStringExtra("posicion");
        acabada = i.getStringExtra("acabada");

        this.asig.setText(snombre);
        this.prof.setText(sprofe);
        this.cuatri.setText(scuatri);
        this.nota.setText(snota);
        this.curs.setText(scurs);

        this.elimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                control.eliminaAsignatura(acabada,Integer.parseInt(pos));
                Intent intent = new Intent(VisionAsignatura.this, ActivityMuestraAsignaturas.class);
                intent.putExtra("valor",acabada);
                startActivity(intent);
                finish();
            }
        });

        this.modifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Comunicador.setObjeto(control);
                Intent intent = new Intent(VisionAsignatura.this, ActivityModificaAsignatura.class);
                intent.putExtra("valor",acabada);
                intent.putExtra("posicion",pos);
                startActivity(intent);
                finish();
            }
        });
    }
}
