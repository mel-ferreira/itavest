package api.itavest.controllers;

import api.itavest.dtos.CompraDTO;
import api.itavest.dtos.PagamentoDTO;
import api.itavest.entidades.Compra;
import api.itavest.entidades.Usuario;
import api.itavest.servicos.CompraServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
    @RequestMapping("/compras")
public class CompraController {

    @Autowired
    CompraServico compraServico;

    @GetMapping
    public ResponseEntity<List<CompraDTO>> findAll()
    {
        List<Compra> listaCompra = compraServico.findAll();

        List<CompraDTO> listaCompraDTO = listaCompra.stream()
                .map(CompraDTO::new)
                .toList();

        return ResponseEntity.ok().body(listaCompraDTO);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<CompraDTO> findById(@PathVariable Long id)
    {
        Compra compraObj = compraServico.findById(id);
        return ResponseEntity.ok().body(new CompraDTO(compraObj));
    }
    @PostMapping("/{id}/pagar")
    public ResponseEntity<Compra> pagarCompra(
            @PathVariable Long id,
            @RequestBody PagamentoDTO pagamentoDTO) {

        Compra compra = compraServico.processarPagamento(id, pagamentoDTO.getValor());
        return ResponseEntity.ok().body(compra);
    }
    @PostMapping("/{id}/cancelar")
    public ResponseEntity<CompraDTO> cancelarPagamento(@PathVariable Long id) {

        Compra compra = compraServico.cancelarPagamento(id);
        return ResponseEntity.ok().body(new CompraDTO(compra));
    }


}
