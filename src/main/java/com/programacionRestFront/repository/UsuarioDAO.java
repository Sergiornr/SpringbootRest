package com.programacionRestFront.repository;

import com.programacionRestFront.repository.entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioDAO implements IDAO<Usuario>{

    private List<Usuario> usuarios;

    public UsuarioDAO() {
        this.usuarios = new ArrayList<>();
        usuarios.add(new Usuario(1L,"Juani"));
        usuarios.add(new Usuario(2L,"Lauti"));
    }

    @Override
    public Usuario create(Usuario usuario) {

        usuarios.add(usuario);
        return usuario;
    }

    @Override
    public Usuario getByID(Long id) {
        Usuario usuarioBuscado=null;
        for(Usuario u:usuarios){
            if (u.getId().equals(id)){
                usuarioBuscado=u;

            }
        }
        return usuarioBuscado;
    }

    @Override
    public List<Usuario> getAll() {
        return usuarios;
    }

    @Override
    public void delete(Long id) {
        for(Usuario u:usuarios){
            if (u.getId().equals(id)){
                usuarios.remove(u);
            }
        }
    }

    @Override
    public Usuario update(Usuario usuario) {
        Usuario usuarioModificado= null;
        for (Usuario u:usuarios){
            if(u.getId().equals(usuario.getId())){
                u.setName(usuario.getName());
                usuarioModificado=u;
                //u=usuario;
            }
        }
        return usuarioModificado;
    }

}