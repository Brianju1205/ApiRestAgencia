package com.agencia.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.agencia.api.entities.Auto; 
import java.util.List;

@Repository
public interface AutoRepository extends JpaRepository<Auto, String> {


    /**
     *  autos filtrados por Marca
     * 
     */
    @Query("SELECT a FROM Auto a JOIN a.marca m WHERE m.nombre = :nombreMarca")
    List<Auto> findAutosByMarcaNombre(@Param("nombreMarca") String nombre);


    @Query("SELECT a FROM Auto a WHERE a.precio > :precioMinimo")
    List<Auto> findAutosByPrecioMayorA(@Param("precioMinimo") Double precio);
    

    List<Auto> findByModelo(Integer modelo);

    List<Auto> findByModeloLessThan(Integer modelo);

    @Query("SELECT a FROM Auto a JOIN a.marca m WHERE m.pais = :nombrePais")
    List<Auto> findAutosByPais(@Param("nombrePais") String pais);
}
