package com.example.demo.repository;
import com.example.demo.entity.JuegoDeMesa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JuegoDeMesaRepository extends JpaRepository<JuegoDeMesa, Integer>{
    Optional<JuegoDeMesa> findById(Integer id);

    List<JuegoDeMesa> findByNombreJuegomesaContainingIgnoreCase(String nombreJuegomesa);

    List<JuegoDeMesa> findByPrecioJuegomesa(Integer precioJuegoMesa);
    List<JuegoDeMesa> findByPrecioJuegomesaLessThan(Integer precioJuegoMesa);
    List<JuegoDeMesa> findByPrecioJuegomesaLessThanEqual(Integer precioJuegoMesa);
    List<JuegoDeMesa> findByPrecioJuegomesaGreaterThanEqual(Integer precioJuegoMesa);
    List<JuegoDeMesa> findByPrecioJuegomesaGreaterThan(Integer precioJuegoMesa);

    List<JuegoDeMesa> findByStockJuegomesa(Integer stockJuegoMesa);
    List<JuegoDeMesa> findByStockJuegomesaLessThan(Integer stockJuegoMesa);
    List<JuegoDeMesa> findByStockJuegomesaLessThanEqual(Integer stockJuegoMesa);
    List<JuegoDeMesa> findByStockJuegomesaGreaterThanEqual(Integer stockJuegoMesa);
    List<JuegoDeMesa> findByStockJuegomesaGreaterThan(Integer stockJuegoMesa);
    List<JuegoDeMesa> findByIdProductoId(Integer idProducto);


    boolean existsById(Integer id);
}
