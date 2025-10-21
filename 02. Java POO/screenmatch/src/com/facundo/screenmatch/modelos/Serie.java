package com.facundo.screenmatch.modelos;

public class Serie extends Titulo {

    private int temporadas;
    private int episidosPorTemporada;

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getEpisidosPorTemporada() {
        return episidosPorTemporada;
    }

    public void setEpisidosPorTemporada(int episidosPorTemporada) {
        this.episidosPorTemporada = episidosPorTemporada;
    }

    @Override
    public int getDuracionMinutos() {
        return super.getDuracionMinutos();
    }
}
