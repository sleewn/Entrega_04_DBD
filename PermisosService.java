package com.example.demo.service;
import com.example.demo.entity.Permisos;
import com.example.demo.repository.PermisosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PermisosService {
    @Autowired
    private PermisosRepository PermisosRepository;


    @Transactional(readOnly = true)
    public List<Permisos> listarTodosLosPermisos(){
        return PermisosRepository.findAll();
    }


    @Transactional(readOnly = true)
    public Optional<Permisos> ObtenerPermisoPorId(Integer id){
        return PermisosRepository.findById(id);
    }


    @Transactional(readOnly = true)
    public List<Permisos> ListarPermisosPorAcciones(String accion){
        return PermisosRepository.findByAccionesContainingIgnoreCase(accion);
    }
}
