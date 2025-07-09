package com.example.demo.service;
import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;


    @Transactional(readOnly = true)
    public List<Producto> findAll(){
        return  productoRepository.findAll();
    }


    @Transactional(readOnly = true)
    public Optional<Producto> findById(Integer id){
        return productoRepository.findById(id);
    }


    @Transactional(readOnly = true)
    public List<Producto> listarPorNombre(String nombre){
        return productoRepository.findByDescripcionContainingIgnoreCase(nombre);
    }


    @Transactional(readOnly = true)
    public List<Producto> listarPorTipoProducto(String tipo){
        return productoRepository.findByTipoProductoContainingIgnoreCase(tipo);
    }


    @Transactional(readOnly = true)
    public List<Producto> listarPorNumeroDeVentas(Integer numeroVentas){
        return productoRepository.findByNumeroVentasProducto(numeroVentas);
    }


    @Transactional(readOnly = true)
    public List<Producto> listarPorRutUsuario(String rutUsuario){
        return productoRepository.findByRutUsuarioRutUsuario(rutUsuario);
    }


    @Transactional(readOnly = true)
    public List<Producto> listarPorRutTienda(String rutTienda){
        return productoRepository.findByRutTiendaRutTienda(rutTienda);
    }


    @Transactional(readOnly = true)
    public List<Producto> listarPorIdCarta(Integer idCarta){
        return productoRepository.findByCartasId(idCarta);
    }


    @Transactional(readOnly = true)
    public List<Producto> listarPorIdJuegoDeMesa(Integer idJuegoMesa){
        return productoRepository.findByJuegoDeMesasId(idJuegoMesa);
    }


    @Transactional(readOnly = true)
    public List<Producto> listarPorValoracion(Integer idValoracion){
        return productoRepository.findByValoracionsId(idValoracion);
    }

    public Producto crearProducto(Producto producto){
        if(this.productoRepository.existsById(producto.getId())){
            throw new IllegalArgumentException("Existe un producto con este id.");
        }
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(Producto producto){
        if(!this.productoRepository.existsById(producto.getId())){
            throw new IllegalArgumentException("No existe un producto con este id.");
        }
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Producto producto){
        if(!this.productoRepository.existsById(producto.getId())){
            throw new IllegalArgumentException("No existe un producto con este id.");
        }
        productoRepository.delete(producto);
    }
}
