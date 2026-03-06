package api.itavest.servicos;

import api.itavest.entidades.Usuario;
import api.itavest.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServico {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> findAll()
    {
        return usuarioRepositorio.findAll();
    }

    public Usuario findById(Long id)
    {
        Optional<Usuario> usuarioObj = usuarioRepositorio.findById(id);
        return usuarioObj.get();
    }
    public Usuario insert(Usuario usuarioObj) {
        return usuarioRepositorio.save(usuarioObj);
    }
}
