package api.itavest.controllers;

import api.itavest.entidades.Usuario;
import api.itavest.servicos.UsuarioServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioServico usuarioServico;

    @GetMapping()
    public ResponseEntity<List<Usuario>>findAll()
    {
        List<Usuario> listaUsuario = usuarioServico.findAll();
        return ResponseEntity.ok().body(listaUsuario);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Usuario>findById(@PathVariable Long id)
    {
        Usuario usuarioObj = usuarioServico.findById(id);
        return ResponseEntity.ok().body(usuarioObj);
    }
    @PostMapping
    public ResponseEntity<Usuario> insertUsuario(@RequestBody Usuario usuarioObj)
    {
        usuarioObj = usuarioServico.insert(usuarioObj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").
                buildAndExpand(usuarioObj.getId()).toUri();
        return ResponseEntity.created(uri).body(usuarioObj);

    }
}
