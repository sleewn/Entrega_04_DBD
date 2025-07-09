package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RolId implements Serializable {
    private static final long serialVersionUID = 28319104961214354L;
    @NotNull
    @Column(name = "id_permisos", nullable = false)
    private Integer idPermisos;

    @Size(max = 12)
    @NotNull
    @Column(name = "rut_usuario", nullable = false, length = 12)
    private String rutUsuario;

    public Integer getIdPermisos() {
        return idPermisos;
    }

    public void setIdPermisos(Integer idPermisos) {
        this.idPermisos = idPermisos;
    }

    public String getRutUsuario() {
        return rutUsuario;
    }

    public void setRutUsuario(String rutUsuario) {
        this.rutUsuario = rutUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RolId entity = (RolId) o;
        return Objects.equals(this.idPermisos, entity.idPermisos) &&
                Objects.equals(this.rutUsuario, entity.rutUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPermisos, rutUsuario);
    }

}