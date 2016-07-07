package edu.ub.pis2016.mmanjarrez.practica2;

import java.util.ArrayList;

/**
 * Created by mmanjaag7.alumnes on 03/06/16.
 */
public class CtrlAsignaturas {

    private DatosAsignaturas datos;

    private String curs,nota,cuatrimestre;
    private String nombre,profesor;
    private boolean finalizada;

    public CtrlAsignaturas() {
        this.datos = new DatosAsignaturas();
    }

    public Asignatura getAsigAcabada (int pos) {
        return datos.getAsignaturasFinalizadas().get(pos);
    }

    public Asignatura getAsigCursando (int pos) {
        return datos.getAsignaturasCursando().get(pos);
    }

    public boolean vaciaAcabada () {
        return datos.getAsignaturasFinalizadas().isEmpty();
    }

    public boolean vaciaCursando () {
        return datos.getAsignaturasCursando().isEmpty();
    }

    public void agregaAsignatura() {
        datos.crearAsignatura(nombre,curs,nota,cuatrimestre,profesor,finalizada);
    }

    public void modificaAsignatura () {
        datos.modificaAsignatura(nombre,curs,nota,cuatrimestre,profesor,finalizada);
    }

    public void eliminaAsignatura(String acabada, int pos) {
        datos.eliminaAsignatura(acabada,pos);
    }

    public ArrayList<Asignatura> muestraAsignaturas(Boolean finalizada) {
        if (!finalizada) {
            return datos.getAsignaturasCursando();
        } else {
            return datos.getAsignaturasFinalizadas();
        }
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public void setDatos(DatosAsignaturas datos) {
        this.datos = datos;
    }

    public void setCurs(String curs) {
        this.curs = curs;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public void setCuatrimestre(String cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
}
