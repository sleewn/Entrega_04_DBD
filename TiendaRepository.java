package com.example.demo.repository;
import  com.example.demo.entity.Tienda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TiendaRepository extends JpaRepository<Tienda, String>{

    Optional<Tienda> findById(String rutTienda);


    List<Tienda> findByNombreTiendaContainingIgnoreCase(String nombreTienda);
    List<Tienda> findByRegionContainingIgnoreCase(String region);
    List<Tienda> findByComunaContainingIgnoreCase(String comuna);


    @Query("SELECT t FROM Tienda t WHERE t.nombreTienda = :nombreTienda AND t.region = :region")
    List<Tienda> buscarTiendasPorNombreYRegion(@Param("nombreTienda") String nombreTienda, @Param("region") String region);

    @Query("SELECT t FROM Tienda t WHERE t.nombreTienda = :nombreTienda AND t.comuna = :comuna")
    List<Tienda> buscarTiendasPorNombreYComuna(@Param("nombreTienda") String nombreTienda, @Param("comuna") String comuna);

    @Query("SELECT t FROM Tienda t WHERE t.region = :region AND t.comuna = :comuna")
    List<Tienda> buscarTiendasPorRegionYComuna(@Param("region") String region, @Param("comuna") String comuna);

    @Query("SELECT t FROM Tienda t WHERE t.nombreTienda = :nombreTienda AND t.region = :region AND t.comuna = :comuna")
    List<Tienda> buscarTiendasPorNombreRegionYComuna(@Param("nombreTienda") String nombreTienda, @Param("region") String region, @Param("comuna") String comuna);


    @Query(value = "SELECT * FROM Tienda WHERE rut_tienda = :rutTienda", nativeQuery = true)
    Optional<Tienda> buscarTiendaPorRutNativo(@Param("rutTienda") String rutTienda);

    @Query(value = "SELECT * FROM Tienda WHERE nombre_tienda = :nombreTienda", nativeQuery = true)
    Optional<Tienda> buscarTiendaPorNombreNativo(@Param("nombreTienda") String nombreTienda);

    @Query(value = "SELECT * FROM Tienda WHERE region = :region", nativeQuery = true)
    Optional<Tienda> buscarTiendaPorRegionNativo(@Param("region") String region);

    @Query(value = "SELECT * FROM Tienda WHERE comuna = :comuna", nativeQuery = true)
    Optional<Tienda> buscarTiendaPorComunaNativo(@Param("comuna") String comuna);

    @Query(value = "SELECT * FROM Tienda WHERE nombre_tienda = :nombreTienda AND region = :region", nativeQuery = true)
    Optional<Tienda> buscarTiendaPorNombreYRegionNativo(@Param("nombreTienda") String nombreTienda,  @Param("region") String region);

    @Query(value = "SELECT * FROM Tienda WHERE nombre_tienda = :nombreTienda AND comuna = :comuna", nativeQuery = true)
    Optional<Tienda> buscarTiendaPorNombreYComunaNativo(@Param("nombreTienda") String nombreTienda,  @Param("region") String region);

    @Query(value = "SELECT * FROM Tienda WHERE region = :region AND comuna = :comuna", nativeQuery = true)
    Optional<Tienda> buscarTiendaPorRegionYComunaNativo(@Param("comuna") String comuna,  @Param("region") String region);

    @Query(value = "SELECT * FROM Tienda WHERE nombre_tienda = :nombreTienda AND region = :region AND comuna = :comuna", nativeQuery = true)
    Optional<Tienda> buscarTiendaPorNombreRegionYComunaNativo(@Param("nombreTienda") String nombreTienda, @Param("region") String region,  @Param("comuna") String comuna);


    boolean existsById(String rutTienda);
}
