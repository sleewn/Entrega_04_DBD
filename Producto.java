package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rut_usuario")
    @JsonBackReference("usuario-producto")
    //@JsonIgnore
    private Usuario rutUsuario;

    @Size(max = 1500)
    @Column(name = "descripcion", length = 1500)
    private String descripcion;

    @Size(max = 100)
    @Column(name = "tipo_producto", length = 100)
    private String tipoProducto;

    @Column(name = "numero_ventas_producto")
    private Integer numeroVentasProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rut_tienda")
    @JsonBackReference
    private Tienda rutTienda;

    @OneToMany(mappedBy = "idProducto")
    @JsonManagedReference
    private Set<Carta> cartas = new LinkedHashSet<>();

    @OneToOne(mappedBy = "producto")
    @JsonManagedReference
    private DetalleProducto detalleProducto;

    @OneToMany(mappedBy = "idProducto")
    @JsonManagedReference
    private Set<JuegoDeMesa> juegoDeMesas = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "productoxcarrodecompra",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_carro_compras"))
    @JsonIgnore
    private Set<CarroDeCompra> carroDeCompras = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idProducto")
    @JsonManagedReference
    private Set<Valoracion> valoracions = new LinkedHashSet<>();

    public Set<Valoracion> getValoracions() {
        return valoracions;
    }

    public void setValoracions(Set<Valoracion> valoracions) {
        this.valoracions = valoracions;
    }

    public Set<CarroDeCompra> getCarroDeCompras() {
        return carroDeCompras;
    }

    public void setCarroDeCompras(Set<CarroDeCompra> carroDeCompras) {
        this.carroDeCompras = carroDeCompras;
    }

    public Set<JuegoDeMesa> getJuegoDeMesas() {
        return juegoDeMesas;
    }

    public void setJuegoDeMesas(Set<JuegoDeMesa> juegoDeMesas) {
        this.juegoDeMesas = juegoDeMesas;
    }

    public DetalleProducto getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(DetalleProducto detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

    public Set<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(Set<Carta> cartas) {
        this.cartas = cartas;
    }

    public Tienda getRutTienda() {
        return rutTienda;
    }

    public void setRutTienda(Tienda rutTienda) {
        this.rutTienda = rutTienda;
    }

    public Integer getNumeroVentasProducto() {
        return numeroVentasProducto;
    }

    public void setNumeroVentasProducto(Integer numeroVentasProducto) {
        this.numeroVentasProducto = numeroVentasProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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