package com.example.demo.repository;
import com.example.demo.entity.RolId;
import  com.example.demo.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findById(String rutUsuario);
    List<Usuario> findByNombreUsuarioContainingIgnoreCase(String nombreUsuario);
    List<Usuario> findByApellidoUsuarioContainingIgnoreCase(String apellidoUsuario);
    List<Usuario> findByRegionUsuarioContainingIgnoreCase(String regionUsuario);
    List<Usuario> findByComunaUsuarioContainingIgnoreCase(String comunaUsuario);
    List<Usuario> findByCorreoUsuarioContainingIgnoreCase(String correoUsuario);
    List<Usuario> findByNombreUsuarioOrApellidoUsuarioContainingIgnoreCase(String nombreUsuario, String apellidoUsuario);
    List<Usuario> findByIdValoracionId(Integer idValoracion);

    List<Usuario> findByCarroDeComprasId(Integer idCarroDeCompras);
    List<Usuario> findByProductosId(Integer idProducto);
    List<Usuario> findByRolsId(RolId id);

    List<Usuario> findByRolsIdRutUsuario(String idRutUsuario);
    List<Usuario> findByRolsIdIdPermisos(Integer idPermisos);

    boolean existsById(String rutUsuario);
}
