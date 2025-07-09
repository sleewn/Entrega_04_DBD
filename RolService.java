package com.example.demo.service;

import com.example.demo.entity.Rol;
import com.example.demo.entity.RolId;
import com.example.demo.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RolService {
    @Autowired
    private RolRepository rolRepository;


    @Transactional(readOnly = true)
    public List<Rol> listarRoles(){
        return rolRepository.findAll();
    }


    @Transactional(readOnly = true)
    public Optional<Rol> encontrarPorId(RolId id){
        return rolRepository.findById(id);
    }


    @Transactional(readOnly = true)
    public List<Rol> encontrarRolPorNombre(String nombreRol){
        return rolRepository.findByNombreRolContainingIgnoreCase(nombreRol);
    }


    @Transactional(readOnly = true)
    public Optional<Rol> encontrarUsuarioPorRut(String rut){
        return rolRepository.findByUsuarioRutUsuario(rut);
    }


    @Transactional(readOnly = true)
    public List<Rol> encontrarRolPorIdPermisos(Integer idPermisos){
        return rolRepository.findByPermisosId(idPermisos);
    }
}
