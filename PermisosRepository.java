package com.example.demo.repository;
import  com.example.demo.entity.Permisos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PermisosRepository extends JpaRepository<Permisos, Integer>{

    Optional<Permisos> findById(Integer id);


    List<Permisos> findByAccionesContainingIgnoreCase(String acciones);

    boolean existsById(Integer id);
}
