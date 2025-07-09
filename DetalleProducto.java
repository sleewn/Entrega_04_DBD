package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "detalle_producto")
public class DetalleProducto {
    @Id
    @Column(name = "id_producto", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    @JsonBackReference
    private Producto producto;

    @Column(name = "cantidad_producto")
    private Integer cantidadProducto;

    @Column(name = "fecha_guardado")
    private LocalDate fechaGuardado;

    public LocalDate getFechaGuardado() {
        return fechaGuardado;
    }

    public void setFechaGuardado(LocalDate fechaGuardado) {
        this.fechaGuardado = fechaGuardado;
    }

    public Integer getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(Integer cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }


}