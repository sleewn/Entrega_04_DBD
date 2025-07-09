package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
public class Usuario {
    @Id
    @Size(max = 12)
    @Column(name = "rut_usuario", nullable = false, length = 12)
    private String rutUsuario;

    @Size(max = 15)
    @Column(name = "nombre_usuario", length = 15)
    private String nombreUsuario;

    @Size(max = 15)
    @Column(name = "apellido_usuario", length = 15)
    private String apellidoUsuario;

    @Size(max = 50)
    @Column(name = "\"contraseña_usuario\"", length = 50)
    private String contrasenaUsuario;

    @Size(max = 25)
    @Column(name = "comuna_usuario", length = 25)
    private String comunaUsuario;

    @Size(max = 25)
    @Column(name = "region_usuario", length = 25)
    private String regionUsuario;

    @Size(max = 25)
    @Column(name = "correo_usuario", length = 25)
    private String correoUsuario;

    @Column(name = "fechanacimiento_usuario")
    private LocalDate fechaNacimientoUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_valoracion")
    @JsonIgnoreProperties({"usuarios", "hibernateLazyInitializer", "handler"})
    private Valoracion idValoracion;

    @OneToMany(mappedBy = "rutUsuario")
    @JsonManagedReference("usuario-carrodecompra")
    private Set<CarroDeCompra> carroDeCompras = new LinkedHashSet<>();

    @OneToMany(mappedBy = "rutUsuario")
    @JsonManagedReference("usuario-producto")
    private Set<Producto> productos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference("usuario-rols")
    private Set<Rol> rols = new LinkedHashSet<>();

    public Set<Rol> getRols() {
        return rols;
    }

    public void setRols(Set<Rol> rols) {
        this.rols = rols;
    }

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

    public Valoracion getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(Valoracion idValoracion) {
        this.idValoracion = idValoracion;
    }

    public LocalDate getFechaNacimientoUsuario() {
        return fechaNacimientoUsuario;
    }

    public void setFechaNacimientoUsuario(LocalDate fechaNacimientoUsuario) {
        this.fechaNacimientoUsuario = fechaNacimientoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getRegionUsuario() {
        return regionUsuario;
    }

    public void setRegionUsuario(String regionUsuario) {
        this.regionUsuario = regionUsuario;
    }

    public String getComunaUsuario() {
        return comunaUsuario;
    }

    public void setComunaUsuario(String comunaUsuario) {
        this.comunaUsuario = comunaUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }
}
