package com.example.demo.repository;
import com.example.demo.entity.Rol;
import com.example.demo.entity.RolId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, RolId> {
    Optional<Rol> findById(RolId id);
    Optional<Rol> findByUsuarioRutUsuario(String rutUsuario);

    List<Rol> findByNombreRolContainingIgnoreCase(String nombreRol);
    List<Rol> findByPermisosId(Integer idPermisos);

    boolean existsById(RolId id);

    List<Rol> id(RolId id);
}
