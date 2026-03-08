package api.itavest.servicos;

import api.itavest.entidades.Acao;
import api.itavest.repositorios.AcaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AcaoServico {
    private static final Logger log = LoggerFactory.getLogger(AcaoServico.class);

    @Autowired
    private AcaoRepositorio acaoRepositorio;

    public List<Acao> findAll()
    {
        List<Acao> listaAcao = acaoRepositorio.findAll();
        log.debug("Quantidade de ações encontradas: {}", listaAcao.size());
        return listaAcao;
    }
    public Acao findById(Long id)
    {
        Optional<Acao> acaoObj =  acaoRepositorio.findById(id);
        return acaoObj.get();
    }
    public List<Acao> findAcoesAbaixoDePreco()
    {
        List<Acao> listaAcoesBaratas =  acaoRepositorio.findByPrecoLessThan(35.00);
        log.debug("Quantidade de  abaixo de R$35.00 encontradas: {}", listaAcoesBaratas.size());
        return listaAcoesBaratas;

    }

}
