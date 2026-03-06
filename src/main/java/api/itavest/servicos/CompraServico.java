package api.itavest.servicos;

import api.itavest.entidades.Compra;
import api.itavest.entidades.Usuario;
import api.itavest.repositorios.CompraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraServico {

    @Autowired
    CompraRepositorio compraRepositorio;

    public List<Compra> findAll()
    {
        return compraRepositorio.findAll();
    }

    public Compra findById(Long id)
    {
        Optional<Compra> compraObj = compraRepositorio.findById(id);
        return compraObj.get();
    }
}
