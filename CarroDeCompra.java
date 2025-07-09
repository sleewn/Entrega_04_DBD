package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "carro_de_compra")
public class CarroDeCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carro_compra", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rut_usuario")
    @JsonBackReference("usuario-carrodecompra")
    private Usuario rutUsuario;

    @Column(name = "precio_total")
    private Integer precioTotal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rut_tienda")
    @JsonBackReference
    private Tienda rutTienda;

    @OneToMany(mappedBy = "idCarroCompra")
    @JsonManagedReference
    private Set<Boleta> boletas = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "carroDeCompras")
    @JsonIgnore
    private Set<Producto> productos = new LinkedHashSet<>();

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    public Set<Boleta> getBoletas() {
        return boletas;
    }

    public void setBoletas(Set<Boleta> boletas) {
        this.boletas = boletas;
    }

    public Tienda getRutTienda() {
        return rutTienda;
    }

    public void setRutTienda(Tienda rutTienda) {
        this.rutTienda = rutTienda;
    }

    public Integer getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Integer precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(Usuario rutUsuario) {
        this.rutUsuario = rutUsuario;
    }


}