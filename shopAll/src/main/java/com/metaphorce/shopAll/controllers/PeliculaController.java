package com.metaphorce.shopAll.controllers;

import com.metaphorce.shopAll.entities.Pelicula;
import com.metaphorce.shopAll.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/shopAllAPI/peliculas")
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @GetMapping
    public ResponseEntity<List<Pelicula>> getPeliculas(){
        List<Pelicula> peliculas = peliculaService.getPelicula();
        return ResponseEntity.ok(peliculas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pelicula>> getPeliculaById(@PathVariable("id") Integer id){
        Optional<Pelicula> getPeliculaById = peliculaService.getPeliculaById(id);
        return ResponseEntity.ok(getPeliculaById);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<Pelicula>> getPeliculasByDisponible(boolean disponible){
        List<Pelicula> getPeliculasByDisponible = peliculaService.getPeliculaByDisponible(true);
        return ResponseEntity.ok(getPeliculasByDisponible);
    }

    @GetMapping("/noDisponibles")
    public ResponseEntity<List<Pelicula>> getPeliculasByNoDisponible(boolean disponible){
        List<Pelicula> getPeliculasByDisponible = peliculaService.getPeliculaByDisponible(false);
        return ResponseEntity.ok(getPeliculasByDisponible);
    }

    @PostMapping
    public ResponseEntity<Pelicula> addPelicula(@RequestBody Pelicula pelicula){
        Pelicula addPelicula = peliculaService.savePelicula(pelicula);
        return ResponseEntity.ok(addPelicula);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> updatePelicula(@PathVariable("id") Integer id, @RequestBody Pelicula pelicula){
        Pelicula updatePelicula = peliculaService.updatePelicula(id, pelicula);
        return ResponseEntity.ok(updatePelicula);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deletePeliculaById(@PathVariable("id") Integer id){
        boolean eliminarPelicula = peliculaService.deletePeliculaById(id);
        if(eliminarPelicula){
            return ResponseEntity.ok("La pelicula con el id: "+ id + " ha sido eliminada");
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
