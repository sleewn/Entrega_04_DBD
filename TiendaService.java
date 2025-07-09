package com.example.demo.service;

import com.example.demo.entity.Tienda;
import com.example.demo.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TiendaService {
    @Autowired
    private TiendaRepository tiendaRepository;


    @Transactional(readOnly = true)
    public List<Tienda> obtenerTodasLasTiendas() {
        return tiendaRepository.findAll();
    }


    @Transactional(readOnly = true)
    public Optional<Tienda> obtenerTiendaPorRut(String rutTienda) {
        return tiendaRepository.findById(rutTienda);
    }


    @Transactional(readOnly = true)
    public List<Tienda> buscarTiendasPorNombre(String region) {
        return tiendaRepository.findByNombreTiendaContainingIgnoreCase(region);
    }


    @Transactional(readOnly = true)
    public List<Tienda> buscarTiendasPorRegion(String region) {
        return tiendaRepository.findByRegionContainingIgnoreCase(region);
    }


    @Transactional(readOnly = true)
    public List<Tienda> buscarTiendasPorComuna(String comuna) {
        return tiendaRepository.findByComunaContainingIgnoreCase(comuna);
    }


    @Transactional(readOnly = true)
    public List<Tienda> buscarTiendasPorRegionYComuna(String region, String comuna) {
        return tiendaRepository.buscarTiendasPorRegionYComuna(region, comuna);
    }


    @Transactional(readOnly = true)
    public List<Tienda> buscarTiendasPorNombreYRegion(String nombreTienda, String region) {
        return tiendaRepository.buscarTiendasPorNombreYRegion(nombreTienda, region);
    }


    @Transactional(readOnly = true)
    public List<Tienda> buscarTiendasPorNombreYComuna(String nombreTienda, String comuna) {
        return tiendaRepository.buscarTiendasPorNombreYComuna(nombreTienda, comuna);
    }


    @Transactional(readOnly = true)
    public List<Tienda> buscarTiendasPorNombreRegionYComuna(String nombreTienda, String region, String comuna) {
        return tiendaRepository.buscarTiendasPorNombreRegionYComuna(nombreTienda, region, comuna);
    }


    public Tienda crearTienda(Tienda tienda) {
        if(this.tiendaRepository.existsById(tienda.getRutTienda())){
            throw new IllegalArgumentException("Ya existe una tienda con este rut.");
        }
        return tiendaRepository.save(tienda);
    }


    public Tienda actualizarTienda(Tienda tienda) {
        if(!this.tiendaRepository.existsById(tienda.getRutTienda())){
            throw new IllegalArgumentException("No existe una tienda con este rut.");
        }
        return tiendaRepository.save(tienda);
    }


    public void eliminarTienda(String rutTienda) {
        if(!this.tiendaRepository.existsById(rutTienda)){
            throw new IllegalArgumentException("No existe una tienda con este rut.");
        }
        tiendaRepository.deleteById(rutTienda);
    }
}
