package com.metaphorce.shopAll.services;

import com.metaphorce.shopAll.entities.Pelicula;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface PeliculaService {

    List<Pelicula> getPelicula();

    Optional<Pelicula> getPeliculaById(Integer id);

    List<Pelicula> getPeliculaByDisponible(boolean disponible);

    Pelicula savePelicula(Pelicula pelicula);

    Pelicula updatePelicula(Integer id, Pelicula pelicula);

    boolean deletePeliculaById(Integer id);

}
