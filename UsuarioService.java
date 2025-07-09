package com.example.demo.service;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario crearUsuario(Usuario usuario) {
        if(this.usuarioRepository.existsById(usuario.getRutUsuario())){
            throw new IllegalArgumentException("Ya existe un usuario con este rut.");
        }
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public Usuario actualizarUsuario(Usuario usuario) {
        if(!this.usuarioRepository.existsById(usuario.getRutUsuario())){
            throw new IllegalArgumentException("No existe un usuario con este rut.");
        }
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    public Optional<Usuario> obtenerUsuarioPorId(String rutUsuario) {
        return usuarioRepository.findById(rutUsuario);
    }

    @Transactional(readOnly = true)
    public List<Usuario> listarUsuariosPorNombre(String nombreUsuario) {
        return usuarioRepository.findByNombreUsuarioContainingIgnoreCase(nombreUsuario);
    }

    @Transactional(readOnly = true)
    public List<Usuario> listarUsuariosPorApellido(String apellidoUsuario) {
        return usuarioRepository.findByApellidoUsuarioContainingIgnoreCase(apellidoUsuario);
    }

    @Transactional(readOnly = true)
    public List<Usuario> listarUsuariosPorCorreo(String correoUsuario) {
        return usuarioRepository.findByCorreoUsuarioContainingIgnoreCase(correoUsuario);
    }

    @Transactional(readOnly = true)
    public List<Usuario> listarUsuariosPorRegion(String regionUsuario) {
        return usuarioRepository.findByRegionUsuarioContainingIgnoreCase(regionUsuario);
    }

    @Transactional(readOnly = true)
    public List<Usuario> listarUsuariosPorComuna(String comunaUsuario) {
        return usuarioRepository.findByComunaUsuarioContainingIgnoreCase(comunaUsuario);
    }
}
