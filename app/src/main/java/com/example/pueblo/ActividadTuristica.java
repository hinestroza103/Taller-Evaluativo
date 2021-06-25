package com.example.pueblo;

import java.io.Serializable;

public class ActividadTuristica implements Serializable {
    String informacion;
    String actividad;
    String fotosolaya;

    public ActividadTuristica(String informacion, String actividad, String fotosolaya) {
        this.informacion = informacion;
        this.actividad = actividad;
        this.fotosolaya = fotosolaya;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getFotosolaya() { return fotosolaya; }

    public void setFotosolaya(String fotosolaya) {
        this.fotosolaya = fotosolaya;
    }
}
