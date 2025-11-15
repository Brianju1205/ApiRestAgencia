package com.agencia.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn; 
import jakarta.persistence.ManyToOne;
@Entity 
@Table(name = "autos")
public class Auto {

    @Id 
    @Column(name = "no_serie", length = 50) 
    private String noSerie;

    @Column(length = 100)
    private String tipo; 

    private Integer modelo;

    @Column(nullable = false)
    private Double precio; 

    @ManyToOne
    @JoinColumn(name = "id_marca_fk", referencedColumnName = "id_marca")
    private Marca marca;
   

    public Auto() {
    }
    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getNoSerie() {
        return noSerie;
    }

    public void setNoSerie(String noSerie) {
        this.noSerie = noSerie;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}