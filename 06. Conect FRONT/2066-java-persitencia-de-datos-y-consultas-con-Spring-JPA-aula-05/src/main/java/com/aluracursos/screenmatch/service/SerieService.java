package com.aluracursos.screenmatch.service;

import com.aluracursos.screenmatch.dto.SerieDTO;
import com.aluracursos.screenmatch.model.Serie;
import com.aluracursos.screenmatch.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.http.PUT;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    public List<SerieDTO> obtenerSeries () {
        return toResponseList(serieRepository.findAll());
    }

    public List<SerieDTO> obtenerTop5() {
        return toResponseList(serieRepository.findTop5ByOrderByEvaluacionDesc());
    }

    public List<SerieDTO> obtenerLanzamientosMasRecientes () {
        return toResponseList(serieRepository.lanzamientosMasRecientes());
    }

    public List<SerieDTO> toResponseList (List<Serie> series) {
         return  series.stream()
                 .map(s -> new SerieDTO(
                         s.getId(),
                         s.getTitulo(),
                         s.getTotalTemporadas(),
                         s.getEvaluacion(),
                         s.getPoster(),
                         s.getGenero(),
                         s.getActores(),
                         s.getSinopsis()
                 )).collect(Collectors.toList());
    }

    public SerieDTO obtenerPorId(Long id) {
        Optional<Serie> serie = serieRepository.findById(id);
        if (serie.isPresent()) {
            Serie s = serie.get();
            return new SerieDTO(
                    s.getId(),
                    s.getTitulo(),
                    s.getTotalTemporadas(),
                    s.getEvaluacion(),
                    s.getPoster(),
                    s.getGenero(),
                    s.getActores(),
                    s.getSinopsis());
        }
        return null;
    }
}
