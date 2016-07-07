package edu.ub.pis2016.mmanjarrez.practica2;

/**
 * Clase asignatura. Contendra la información e cada asignatura
 */
public class Asignatura {

    private String curs,nota,cuatrimestre;
    private String nombre,profesor;
    private boolean finalizada;

    /**
     * Constructor
     * @param curs curso de la asignatura
     * @param nota nota de la asignatura
     * @param cuatrimestre cuatrimestre de la asignatura
     * @param profesor profesor de la asignatura
     * @param finalizada si se ha cursado o no
     */
    public Asignatura(String nombre, String curs, String nota, String cuatrimestre, String profesor, boolean finalizada) {
        this.nombre = nombre;
        this.curs = curs;
        this.nota = nota;
        this.cuatrimestre = cuatrimestre;
        this.profesor = profesor;
        this.finalizada = finalizada;
    }

    public String getNota() {
        return nota;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public String getCurs() {
        return curs;
    }

    public String getCuatrimestre() {
        return cuatrimestre;
    }

    public String getProfesor() {
        return profesor;
    }

    @Override
    public String toString() {
        return  "curs='" + curs + '\'' +
                ", nota='" + nota + '\'' +
                ", cuatrimestre='" + cuatrimestre + '\'' +
                ", nombre='" + nombre + '\'' +
                ", profesor='" + profesor + '\'' +
                ", finalizada=" + finalizada;
    }
}
