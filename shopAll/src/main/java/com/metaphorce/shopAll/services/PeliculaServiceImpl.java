package com.metaphorce.shopAll.services;

import com.metaphorce.shopAll.entities.Pelicula;
import com.metaphorce.shopAll.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    @Autowired
    PeliculaRepository repository;

    @Override
    public List<Pelicula> getPelicula() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            System.out.println("Error al obtener las peliculas: "+ e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<Pelicula> getPeliculaById(Integer id){
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar la película con id " + id + ": " + e.getMessage(), e);
        }
    }

    @Override
    public List<Pelicula> getPeliculaByDisponible(boolean disponible){
        try {
            return repository.findByDisponible(disponible);
        } catch (Exception e) {
            throw new RuntimeException("Error al buscar las películas disponibles " + e.getMessage(), e);
        }
    }

    @Override
    public Pelicula savePelicula(Pelicula pelicula) {
        try {
            return repository.save(pelicula);
        } catch (Exception e) {
            throw new RuntimeException("Error al guardar la película "+ e.getMessage(), e);
        }

    }

    @Override
    public Pelicula updatePelicula(Integer id, Pelicula pelicula){
        Optional<Pelicula> encontrarPelicula = repository.findById(id);
        try {
            if (encontrarPelicula.isPresent()) {
                Pelicula peliculaActual = encontrarPelicula.get();

                peliculaActual.setDisponible(pelicula.getDisponible());

                return repository.save(peliculaActual);
            } else {
                throw new RuntimeException("No se encontro la pelicula con el id: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al modificar la pelicula " + e.getMessage(), e);
        }

    }

    @Override
    public boolean deletePeliculaById(Integer id){
        try {
            if (repository.existsById(id)) {
                repository.deleteById(id);
                return true;
            }else{
                System.out.println("No se encontró la película con el id: "+ id);
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al eliminar la película " + e.getMessage(), e);
        }
    }

}
