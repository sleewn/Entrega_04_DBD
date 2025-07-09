package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "rol")
public class Rol {
    @EmbeddedId
    private RolId id;

    @MapsId("rutUsuario")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rut_usuario")
    @JsonBackReference("usuario-rols")
    private Usuario usuario;

    @Size(max = 50)
    @Column(name = "nombre_rol", length = 50)
    private String nombreRol;

    @MapsId("idPermisos")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_permisos")
    @JsonBackReference
    private Permisos permisos;

    public Permisos getPermisos() {
        return permisos;
    }

    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public RolId getId() {
        return id;
    }

    public void setId(RolId id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }


}