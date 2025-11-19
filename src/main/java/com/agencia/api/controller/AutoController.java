package com.agencia.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.agencia.api.entities.Auto;
import com.agencia.api.repository.AutoRepository;

import java.util.List;

@RestController
@RequestMapping("/api") 
public class AutoController {

    @Autowired
    private AutoRepository autoRepository;

    /**
     * DELETE http://localhost:8080/api/auto/{NoSerie}
     */
    @DeleteMapping("/auto/{NoSerie}")
    public ResponseEntity<Void> deleteAuto(@PathVariable String NoSerie) {
        if (!autoRepository.existsById(NoSerie)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        autoRepository.deleteById(NoSerie);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     *POST http://localhost:8080/api/auto
     */
    @PostMapping("/auto")
    public ResponseEntity<Auto> createAuto(@RequestBody Auto auto) {
        try {
            Auto nuevoAuto = autoRepository.save(auto);
            return new ResponseEntity<>(nuevoAuto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * GET http://localhost:8080/api/autos/marca/{nombre}
     */
    @GetMapping("/autos/marca/{nombre}")
    public ResponseEntity<List<Auto>> getAutosByMarca(@PathVariable String nombre) {
        List<Auto> autos = autoRepository.findAutosByMarcaNombre(nombre);
        return new ResponseEntity<>(autos, HttpStatus.OK);
    }

    /**
     *GET http://localhost:8080/api/autos/precio/{varprecio}
     */
    @GetMapping("/autos/precio/{varprecio}")
    public ResponseEntity<List<Auto>> getAutosByPrecioMayorA(@PathVariable Double varprecio) {
        List<Auto> autos = autoRepository.findAutosByPrecioMayorA(varprecio);
        return new ResponseEntity<>(autos, HttpStatus.OK);
    }
}