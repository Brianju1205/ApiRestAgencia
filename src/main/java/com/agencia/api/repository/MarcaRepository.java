package com.agencia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.agencia.api.entities.Marca;

@Repository 
public interface MarcaRepository extends JpaRepository<Marca, Integer> {

    // findAll() 
    // findById()
    // save()
    // deleteById()
}
