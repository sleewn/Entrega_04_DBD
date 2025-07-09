package com.example.demo.repository;
import com.example.demo.entity.Boleta;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BoletaRepository extends JpaRepository<Boleta, Integer> {
    Optional<Boleta> findById(int id);

    List<Boleta> findByIdCarroCompraId(Integer id);

    List<Boleta> findByMontoFinalLessThan(Integer montoFinal);
    List<Boleta> findByMontoFinalLessThanEqual(Integer montoFinal);
    List<Boleta> findByMontoFinalGreaterThan(Integer montoFinal);
    List<Boleta> findByMontoFinalGreaterThanEqual(Integer montoFinal);

    List<Boleta> findByFechaBoleta(LocalDate fechaBoleta);
    List<Boleta> findByFechaBoletaBetween(LocalDate fechaBoleta1, LocalDate fechaBoleta2);

    List<Boleta> findByMetodoPagoBoletaContainingIgnoreCase(String metodoPagoBoleta);

    boolean existsById(Integer id);
}
