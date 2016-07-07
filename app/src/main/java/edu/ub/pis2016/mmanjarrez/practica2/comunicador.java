package edu.ub.pis2016.mmanjarrez.practica2;

/**
 * Created by mmanjaag7.alumnes on 03/06/16.
 */
class Comunicador {
    private static CtrlAsignaturas objeto = null;

    public static void setObjeto(CtrlAsignaturas newObjeto) {
        objeto = newObjeto;
    }

    public static CtrlAsignaturas getObjeto() {
        return objeto;
    }
}
