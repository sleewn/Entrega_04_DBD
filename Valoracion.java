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
@Table(name = "valoracion")
public class Valoracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valoracion", nullable = false)
    private Integer id;

    @Column(name = "puntaje")
    private Integer puntaje;

    @Size(max = 500)
    @Column(name = "comentario", length = 500)
    private String comentario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto")
    @JsonBackReference()
    private Producto idProducto;

    @OneToMany(mappedBy = "idValoracion")
    
    @JsonIgnore
    private Set<Usuario> usuarios = new LinkedHashSet<>();

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}