package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tienda")
public class Tienda {
    @Id
    @Size(max = 12)
    @Column(name = "rut_tienda", nullable = false, length = 12)
    private String rutTienda;

    @Size(max = 100)
    @Column(name = "nombre_tienda", length = 100)
    private String nombreTienda;

    @Size(max = 100)
    @Column(name = "region", length = 100)
    private String region;

    @Size(max = 100)
    @Column(name = "comuna", length = 100)
    private String comuna;

    @OneToMany(mappedBy = "rutTienda")
    @JsonManagedReference
    private Set<CarroDeCompra> carroDeCompras = new LinkedHashSet<>();

    @OneToMany(mappedBy = "rutTienda")
    @JsonManagedReference
    private Set<Producto> productos = new LinkedHashSet<>();

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    public Set<CarroDeCompra> getCarroDeCompras() {
        return carroDeCompras;
    }

    public void setCarroDeCompras(Set<CarroDeCompra> carroDeCompras) {
        this.carroDeCompras = carroDeCompras;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public String getRutTienda() {
        return rutTienda;
    }

    public void setRutTienda(String rutTienda) {
        this.rutTienda = rutTienda;
    }

}