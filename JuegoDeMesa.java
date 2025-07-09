package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "juego_de_mesa")
public class JuegoDeMesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_juegomesa", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    @JsonBackReference
    private Producto idProducto;

    @Size(max = 20)
    @Column(name = "nombre_juegomesa", length = 20)
    private String nombreJuegomesa;

    @Column(name = "precio_juegomesa")
    private Integer precioJuegomesa;

    @Column(name = "stock_juegomesa")
    private Integer stockJuegomesa;

    public Integer getStockJuegomesa() {
        return stockJuegomesa;
    }

    public void setStockJuegomesa(Integer stockJuegomesa) {
        this.stockJuegomesa = stockJuegomesa;
    }

    public Integer getPrecioJuegomesa() {
        return precioJuegomesa;
    }

    public void setPrecioJuegomesa(Integer precioJuegomesa) {
        this.precioJuegomesa = precioJuegomesa;
    }

    public String getNombreJuegomesa() {
        return nombreJuegomesa;
    }

    public void setNombreJuegomesa(String nombreJuegomesa) {
        this.nombreJuegomesa = nombreJuegomesa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }


}