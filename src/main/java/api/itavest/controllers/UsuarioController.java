package api.itavest.controllers;

import api.itavest.dtos.UsuarioDTO;
import api.itavest.dtos.UsuarioInsertDTO;
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
    public ResponseEntity<List<UsuarioDTO>>findAll()
    {
        List<Usuario> listaUsuario = usuarioServico.findAll();
        List<UsuarioDTO> usuarioDto = listaUsuario.stream()
                .map(UsuarioDTO::new)
                .toList();
        return ResponseEntity.ok().body(usuarioDto);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<UsuarioDTO>findById(@PathVariable Long id)
    {
        Usuario usuarioObj = usuarioServico.findById(id);
        return ResponseEntity.ok().body(new UsuarioDTO(usuarioObj));
    }
    @PostMapping
    public ResponseEntity<UsuarioDTO> insertUsuario(@RequestBody UsuarioInsertDTO usuarioObj)
    {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioObj.getNome());
        usuario.setEmail(usuarioObj.getEmail());

        usuario = usuarioServico.insert(usuario);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").
                buildAndExpand(usuario.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id)
    {
        usuarioServico.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioInsertDTO  usuarioObj)
    {
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioObj.getNome());
        usuario.setEmail(usuarioObj.getEmail());

        usuario = usuarioServico.update(id, usuario);
        return ResponseEntity.ok().body(new UsuarioDTO(usuario));
    }
}
