package com.example.demo.repository;
import  com.example.demo.entity.DetalleProducto;

import com.example.demo.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DetalleProductoRepository extends JpaRepository<DetalleProducto,Integer> {
    Optional<DetalleProducto> findById(Integer idProducto);
    List<DetalleProducto> findByProducto(Producto producto);
    List<DetalleProducto> findByCantidadProducto(Integer cantidadProducto);
    List<DetalleProducto> findByCantidadProductoLessThan(Integer cantidadProductoIsLessThan);
    List<DetalleProducto> findByCantidadProductoLessThanEqual(Integer cantidadProducto);
    List<DetalleProducto> findByCantidadProductoGreaterThanEqual(Integer cantidadProducto);
    List<DetalleProducto> findByCantidadProductoGreaterThan(Integer cantidadProducto);

    List<DetalleProducto> findByFechaGuardado(LocalDate fechaGuardado);

    boolean existsById(Integer idProducto);
}
