package edu.ub.pis2016.mmanjarrez.practica2;

import java.util.ArrayList;

/**
 * Clase encargada de manipular los datos
 */
public class DatosAsignaturas {

    private ArrayList<Asignatura> asignaturasFinal;
    private ArrayList<Asignatura> asignaturas;

    public DatosAsignaturas() {
        this.asignaturas = new ArrayList<Asignatura>();
        this.asignaturasFinal = new ArrayList<Asignatura>();
    }

    public ArrayList<Asignatura> getAsignaturasCursando() {
        return asignaturas;
    }

    public ArrayList<Asignatura> getAsignaturasFinalizadas() {
        return asignaturasFinal;
    }

    public void crearAsignatura (String nombre, String curs, String nota, String cuatrimestre, String profesor, boolean finalizada) {
        if (!finalizada) {
            asignaturas.add(new Asignatura(nombre, curs, nota, cuatrimestre, profesor, finalizada));
        } else {
            asignaturasFinal.add(new Asignatura(nombre, curs, nota, cuatrimestre, profesor, finalizada));
        }
    }

    public void modificaAsignatura (String nombre, String curs, String nota, String cuatrimestre, String profesor, boolean finalizada) {
        if (!finalizada) {
            asignaturas.add(new Asignatura(nombre, curs, nota, cuatrimestre, profesor, finalizada));
        } else {
            asignaturasFinal.add(new Asignatura(nombre, curs, nota, cuatrimestre, profesor, finalizada));
        }
    }



    public void eliminaAsignatura (String finalizada, int pos) {
        if (finalizada.equals("noac")) {
            asignaturas.remove(pos);
        } else {
            asignaturasFinal.remove(pos);
        }
    }



}
