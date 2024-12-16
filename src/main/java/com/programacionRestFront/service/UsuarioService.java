package com.programacionRestFront.service;


import com.programacionRestFront.repository.IDAO;
import com.programacionRestFront.repository.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private final IDAO<Usuario> usuarioDAO;
    public UsuarioService(IDAO<Usuario> usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    public Usuario crear(Usuario usuario){
        return usuarioDAO.create(usuario);
    }


    public void eliminar(Long id ){
        usuarioDAO.delete(id);

    };

    public Usuario buscarId(Long id ){
        return usuarioDAO.getByID(id);
    }

    public List<Usuario> listar(){
        return  usuarioDAO.getAll();
    }


    public Usuario update(Usuario usuario){
        return  usuarioDAO.update(usuario);
    }

}