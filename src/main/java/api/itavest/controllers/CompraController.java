package api.itavest.controllers;

import api.itavest.entidades.Compra;
import api.itavest.servicos.CompraServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("/compras")
public class CompraController {

    @Autowired
    CompraServico compraServico;

    @GetMapping
    public ResponseEntity<List<Compra>> findAll()
    {
        List<Compra> listaCompra = compraServico.findAll();
        return ResponseEntity.ok().body(listaCompra);
    }
    @GetMapping(value="/{id}")
    public ResponseEntity<Compra> findById(@PathVariable Long id)
    {
        Compra compraObj = compraServico.findById(id);
        return ResponseEntity.ok().body(compraObj);
    }

}
