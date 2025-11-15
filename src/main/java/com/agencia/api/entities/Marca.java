package com.agencia.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany; 
import jakarta.persistence.CascadeType; 
import com.fasterxml.jackson.annotation.JsonIgnore; 
import java.util.List; 

@Entity 
@Table(name = "marcas") 
public class Marca {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_marca") 
    private Integer idMarca;

    @Column(length = 50, nullable = false) 
    private String nombre; 

    @Column(length = 50)
    private String pais; 
    
    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL) //
    @JsonIgnore 
    private List<Auto> autos;
    
    public Marca() {
    }
    public List<Auto> getAutos() {
        return autos;
    }

    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }

    public Integer getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}