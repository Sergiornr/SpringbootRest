package com.programacionRestFront.controller;

import com.programacionRestFront.repository.entity.Usuario;
import com.programacionRestFront.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        Usuario getUsuario= usuarioService.buscarId(id);
        if(getUsuario == null){
            return ResponseEntity.badRequest().body("usuario inexistente");
        }else{
            return ResponseEntity.status(200).body(getUsuario);
        }
    }
    @PostMapping
    public ResponseEntity<?> create(@RequestBody Usuario usuario){
        if(usuarioService.buscarId(usuario.getId()) == null) {
            Usuario usuarioCreado = usuarioService.crear(usuario);
            return ResponseEntity.status(200).body(usuarioCreado);}
        else{
            return ResponseEntity.badRequest().body("El usuario ya existe");}}
    @DeleteMapping("/{id}")  //no ?id=1
    public ResponseEntity<?> delete(@PathVariable Long id){
        if( usuarioService.buscarId(id) != null){
            usuarioService.eliminar(id);
            return ResponseEntity.status(200).body("usuario eliminado");
        }else{
            return ResponseEntity.badRequest().body("Id inexistente");}}
    @PutMapping
    public ResponseEntity<?> update(@RequestBody Usuario usuarioModificado){
        if(usuarioService.buscarId(usuarioModificado.getId()) != null)
            return ResponseEntity.status(201).body( usuarioService.update(usuarioModificado));
        else return ResponseEntity.badRequest().body("no pudimos modificarlo");}

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Usuario> lista= usuarioService.listar();
        if(lista.isEmpty()){
            return (ResponseEntity<?>) ResponseEntity.noContent();
        }else{
            return ResponseEntity.ok().body(lista);
        }

    }

}
