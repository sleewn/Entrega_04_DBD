package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "boleta")
public class Boleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boleta", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carro_compra")
    @JsonBackReference
    private CarroDeCompra idCarroCompra;

    @Column(name = "monto_final")
    private Integer montoFinal;

    @Column(name = "fecha_boleta")
    private LocalDate fechaBoleta;

    @Size(max = 30)
    @Column(name = "metodo_pago_boleta", length = 30)
    private String metodoPagoBoleta;

    public String getMetodoPagoBoleta() {
        return metodoPagoBoleta;
    }

    public void setMetodoPagoBoleta(String metodoPagoBoleta) {
        this.metodoPagoBoleta = metodoPagoBoleta;
    }

    public LocalDate getFechaBoleta() {
        return fechaBoleta;
    }

    public void setFechaBoleta(LocalDate fechaBoleta) {
        this.fechaBoleta = fechaBoleta;
    }

    public Integer getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(Integer montoFinal) {
        this.montoFinal = montoFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarroDeCompra getIdCarroCompra() {
        return idCarroCompra;
    }

    public void setIdCarroCompra(CarroDeCompra idCarroCompra) {
        this.idCarroCompra = idCarroCompra;
    }
}