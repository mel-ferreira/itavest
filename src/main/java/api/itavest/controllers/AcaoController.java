package api.itavest.controllers;

import api.itavest.entidades.Acao;
import api.itavest.servicos.AcaoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acoes")
public class AcaoController {

    @Autowired
    private AcaoServico acaoServico;

    @GetMapping
    public ResponseEntity<List<Acao>> findAll()
    {
        List<Acao> listaAcao = acaoServico.findAll();
        return ResponseEntity.ok().body(listaAcao);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Acao> findById(@PathVariable Long id)
    {
        Acao acaoObj = acaoServico.findById(id);
        return ResponseEntity.ok().body(acaoObj);
    }
}
