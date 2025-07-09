package com.example.demo.repository;
import com.example.demo.entity.Carta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Repository
public interface CartaRepository extends JpaRepository<Carta, Integer> {
    Optional<Carta> findById(Integer id);
    Optional<Carta> findByIdProductoId(Integer idProducto);
    List<Carta> findByNombreCartaContainingIgnoreCase(String nombreCarta);

    List<Carta> findByRarezaCartaContainingIgnoreCase(String rarezaCarta);

    List<Carta> findByEstadoCartaContainingIgnoreCase(String estadoCarta);

    List<Carta> findByUrlCartaContainingIgnoreCase(String urlCarta);
    List<Carta> findByPrecioCarta(Integer precioCarta);
    List<Carta> findByPrecioCartaLessThan(Integer precioCarta);
    List<Carta> findByPrecioCartaLessThanEqual(Integer precioCarta);
    List<Carta> findByPrecioCartaGreaterThanEqual(Integer precioCarta);
    List<Carta> findByPrecioCartaGreaterThan(Integer precioCarta);

    List<Carta> findByStockCarta(Integer precioCarta);
    List<Carta> findByStockCartaLessThan(Integer precioCarta);
    List<Carta> findByStockCartaLessThanEqual(Integer precioCarta);
    List<Carta> findByStockCartaGreaterThanEqual(Integer precioCarta);
    List<Carta> findByStockCartaGreaterThan(Integer precioCarta);

    @Query(value = "SELECT * FROM carta c WHERE YEAR(c.anioCarta) BETWEEN YEAR(:añoCarta) AND YEAR(:aniooCarta2)", nativeQuery = true)
    List<Carta> findByAnioCartaBetween(LocalDate anioCarta, LocalDate aniooCarta2);

    @Query("SELECT c FROM Carta c WHERE YEAR(c.añoCarta) = :anio")
    List<Carta> findByAnioCarta(Integer anio);

    boolean existsById(Integer integer);
}

