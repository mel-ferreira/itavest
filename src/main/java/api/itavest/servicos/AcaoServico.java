package api.itavest.servicos;

import api.itavest.entidades.Acao;
import api.itavest.repositorios.AcaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcaoServico {

    @Autowired
    private AcaoRepositorio acaoRepositorio;

    public List<Acao> findAll()
    {
        return acaoRepositorio.findAll();
    }
    public Acao findById(Long id)
    {
        Optional<Acao> acaoObj =  acaoRepositorio.findById(id);
        return acaoObj.get();
    }
    public List<Acao> findAcoesAbaixoDePreco()
    {
        return acaoRepositorio.findByPrecoLessThan(35.00);
    }

}
