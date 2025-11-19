package com.aluracursos.screenmatch.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodio (
    @JsonAlias("Title")
    String tiulo,
    @JsonAlias("Year")
    String año,
    @JsonAlias("Plot")
    String plot
) {
}
