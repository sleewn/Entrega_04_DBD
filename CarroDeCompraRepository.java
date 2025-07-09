package com.example.demo.repository;
import com.example.demo.entity.CarroDeCompra;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarroDeCompraRepository extends JpaRepository<CarroDeCompra, Integer> {
    Optional<CarroDeCompra> findById(int id);

    List<CarroDeCompra> findByRutUsuarioRutUsuario(String rutUsuario);

    List<CarroDeCompra> findByRutTiendaRutTienda(String rutTienda);

    List<CarroDeCompra> findByBoletasId(Integer idBoleta);

    List<CarroDeCompra> findByProductosId(Integer idProducto);

    List<CarroDeCompra> findByPrecioTotalLessThan(Integer precioTotal);
    List<CarroDeCompra> findByPrecioTotalLessThanEqual(Integer precioTotal);
    List<CarroDeCompra> findByPrecioTotalGreaterThan(Integer precioTotal);
    List<CarroDeCompra> findByPrecioTotalGreaterThanEqual(Integer precioTotal);

    boolean existsById(Integer id);
}
