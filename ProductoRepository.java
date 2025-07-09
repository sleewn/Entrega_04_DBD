package com.example.demo.repository;
import com.example.demo.entity.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends  JpaRepository<Producto, Integer> {

    Optional<Producto> findById(Integer idProducto);

    List<Producto> findByDescripcionContainingIgnoreCase(String descripcion);
    List<Producto> findByTipoProductoContainingIgnoreCase(String tipoProducto);
    List<Producto> findByNumeroVentasProducto(Integer numeroVentasProducto);
    List<Producto> findByRutUsuarioRutUsuario(String rutUsuario);
    List<Producto> findByRutTiendaRutTienda(String rutTienda);
    List<Producto> findByCartasId(Integer idJuegoCarta);
    List<Producto> findByJuegoDeMesasId(Integer idJuegoMesa);
    List<Producto> findByValoracionsId(Integer idValoracion);

    boolean existsById(Integer idProducto);
}
