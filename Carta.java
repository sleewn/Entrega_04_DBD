package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "carta")
public class Carta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carta", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    @JsonBackReference
    private Producto idProducto;

    @Size(max = 20)
    @Column(name = "nombre_carta", length = 20)
    private String nombreCarta;

    @Column(name = "precio_carta")
    private Integer precioCarta;

    @Size(max = 10)
    @Column(name = "rareza_carta", length = 10)
    private String rarezaCarta;

    @Column(name = "stock_carta")
    private Integer stockCarta;

    @Size(max = 400)
    @Column(name = "url_carta", length = 400)
    private String urlCarta;

    @Size(max = 10)
    @Column(name = "estado_carta", length = 10)
    private String estadoCarta;

    @Column(name = "\"año_carta\"")
    private LocalDate añoCarta;

    public LocalDate getAñoCarta() {
        return añoCarta;
    }

    public void setAñoCarta(LocalDate añoCarta) {
        this.añoCarta = añoCarta;
    }

    public String getEstadoCarta() {
        return estadoCarta;
    }

    public void setEstadoCarta(String estadoCarta) {
        this.estadoCarta = estadoCarta;
    }

    public String getUrlCarta() {
        return urlCarta;
    }

    public void setUrlCarta(String urlCarta) {
        this.urlCarta = urlCarta;
    }

    public Integer getStockCarta() {
        return stockCarta;
    }

    public void setStockCarta(Integer stockCarta) {
        this.stockCarta = stockCarta;
    }

    public String getRarezaCarta() {
        return rarezaCarta;
    }

    public void setRarezaCarta(String rarezaCarta) {
        this.rarezaCarta = rarezaCarta;
    }

    public Integer getPrecioCarta() {
        return precioCarta;
    }

    public void setPrecioCarta(Integer precioCarta) {
        this.precioCarta = precioCarta;
    }

    public String getNombreCarta() {
        return nombreCarta;
    }

    public void setNombreCarta(String nombreCarta) {
        this.nombreCarta = nombreCarta;
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