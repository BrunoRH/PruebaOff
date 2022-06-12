package com.donacion.controller;


import com.donacion.models.Usuario;
import com.donacion.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController{
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/guardar")
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        System.out.println(usuario.toString());
        return usuarioService.saveUser(usuario);
    }
    @GetMapping("/listar")
    public ArrayList<Usuario> getUsuarios(){
        return usuarioService.getUsuarios();
    }
    @GetMapping("/buscar/{id}")
    public Usuario showUsuario(@PathVariable Long id){
        return usuarioService.getUsuario(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public String removeUsuario(@PathVariable Long id){
        System.out.println("id: "+id);
        return usuarioService.removeUsuario(id);
    }

    @PutMapping("/actualizar/{id}")
    public Usuario updateEstudiante(@RequestBody Usuario usuario, @PathVariable Long id){
        Usuario usuarioActual = usuarioService.getUsuario(id);
        usuarioActual.setDni(usuario.getDni());
        usuarioActual.setUsername(usuario.getUsername());
        usuarioActual.setPassword(usuario.getPassword());
        usuarioActual.setEmail(usuario.getEmail());
        usuarioActual.setApellidos(usuario.getApellidos());
        usuarioActual.setDireccion(usuario.getDireccion());

        return usuarioService.saveUser(usuarioActual);
    }

}
