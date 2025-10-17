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

    public Titulo() {

    }

    public void muestraPelicula() {
        System.out.println("Mi pelicula es: " + nombre);
    }

    public void evaluarPelicula(double nota) {
        sumaNotas += nota;
        mediaNotas++;
    }

    public void promedioNotasPelicula() {
        System.out.println("Nota promedio final: " + sumaNotas/mediaNotas);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setFechaLanzamiento(int fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public boolean isIncluidoPlan() {
        return incluidoPlan;
    }

    public void setIncluidoPlan(boolean incluidoPlan) {
        this.incluidoPlan = incluidoPlan;
    }

    public double getSumaNotas() {
        return sumaNotas;
    }

    public void setSumaNotas(double sumaNotas) {
        this.sumaNotas = sumaNotas;
    }

    public static double getMediaNotas() {
}
