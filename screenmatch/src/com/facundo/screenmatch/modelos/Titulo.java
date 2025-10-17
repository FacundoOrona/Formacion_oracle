package com.facundo.screenmatch.modelos;

public class Titulo {

    private String nombre;
    private int fechaLanzamiento;
    private int duracionMinutos;
    private boolean incluidoPlan;
    private double sumaNotas;
    private static double mediaNotas;

    public Titulo(double sumaNotas, boolean incluidoPlan, int duracionMinutos, int fechaLanzamiento, String nombre) {
        this.sumaNotas = sumaNotas;
        this.incluidoPlan = incluidoPlan;
        this.duracionMinutos = duracionMinutos;
        this.fechaLanzamiento = fechaLanzamiento;
        this.nombre = nombre;
    }
}
