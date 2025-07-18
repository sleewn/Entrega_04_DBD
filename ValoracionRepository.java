package com.example.demo.repository;
import  com.example.demo.entity.Valoracion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ValoracionRepository extends JpaRepository<Valoracion, Integer>{
  
    Optional<Valoracion> findById(Integer id);


    List<Valoracion> findByPuntaje(Integer puntaje);
    List<Valoracion> findByComentarioContainingIgnoreCase(String comentario);

    List<Valoracion> findByIdProductoId(Integer idProducto);

    List<Valoracion> findByUsuariosRutUsuario(String rutUsuario);

    boolean existsById(Integer id);
}
