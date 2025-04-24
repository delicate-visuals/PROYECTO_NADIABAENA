package com.trueconnect.trueconnectrecom.models;

public class Recomendacion {
    private int idRecomendacion;
    private String nombre;
    private String descripcion;

    public Recomendacion(int idRecomendacion, String nombre, String descripcion) {
        this.idRecomendacion = idRecomendacion;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Recomendacion() {
        this.nombre = "";
        this.descripcion = "";
    }

    public int getIdRecomendacion() {
        return idRecomendacion;
    }

    public void setIdRecomendacion(int idRecomendacion) {
        this.idRecomendacion = idRecomendacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
