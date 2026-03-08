package api.itavest.controllers;

import api.itavest.dtos.AcaoDTO;
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
    public ResponseEntity<List<AcaoDTO>> findAll()
    {
        List<Acao> listaAcao = acaoServico.findAll();

        List<AcaoDTO> listaAcaoDto = listaAcao.stream().
                map(AcaoDTO::new).toList();
        return ResponseEntity.ok().body(listaAcaoDto);
    }
    @GetMapping("/baratas")
    public ResponseEntity<List<AcaoDTO>> findAcoesAbaixoDoPreco()
    {
        List<Acao> lista = acaoServico.findAcoesAbaixoDePreco();

        List<AcaoDTO> listaDto = lista.stream()
                .map(AcaoDTO::new)
                .toList();

        return ResponseEntity.ok().body(listaDto);
    }
}
