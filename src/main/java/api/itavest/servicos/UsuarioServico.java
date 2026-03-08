package api.itavest.servicos;

import api.itavest.entidades.Usuario;
import api.itavest.repositorios.UsuarioRepositorio;
import api.itavest.servicos.exceptions.BusinessException;
import api.itavest.servicos.exceptions.DatabaseException;
import api.itavest.servicos.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServico {

    private static final Logger log = LoggerFactory.getLogger(UsuarioServico.class);


    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> findAll()
    {
        List<Usuario> listaUsuarios = usuarioRepositorio.findAll();
        log.debug("Quantidade de usuários encontrados: {}", listaUsuarios.size());
        return listaUsuarios;
    }

    public Usuario findById(Long id)
    {
        Optional<Usuario> usuarioObj = usuarioRepositorio.findById(id);
        return usuarioObj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    public Usuario insert(Usuario usuarioObj) {

        if(usuarioRepositorio.existsByEmail(usuarioObj.getEmail())) {
            throw new BusinessException("Email já cadastrado");
        }
        return usuarioRepositorio.save(usuarioObj);
    }
    public void delete(Long id)
    {
        try
        {
            usuarioRepositorio.deleteById(id);
        }
        catch(EmptyResultDataAccessException e)
        {
            throw new ResourceNotFoundException(id);
        }
        catch(DataIntegrityViolationException e)
        {
            throw new DatabaseException(e.getMessage());
        }
    }
    public Usuario update(Long id, Usuario obj)
    {
        try {
            Usuario entity = usuarioRepositorio.getReferenceById(id);
            atualizarDados(entity, obj);
            return usuarioRepositorio.save(entity);
        }
        catch(EntityNotFoundException e)
        {
            throw new ResourceNotFoundException(id);
        }
    }

    private void atualizarDados(Usuario entity, Usuario obj) {
        entity.setNome(obj.getNome());
        entity.setEmail(obj.getEmail());
        entity.setTelefone(obj.getTelefone());
    }
}
