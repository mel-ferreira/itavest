package api.itavest.dtos;

import api.itavest.entidades.Compra;
import api.itavest.entidades.enums.CompraStatus;

import java.util.List;

public class CompraDTO {

    private Long id;
    private String status;
    private Double total;
    private CompraStatus compraStatus;
    private UsuarioDTO usuario;
    private List<CompraItemDTO> compraItens;


    public CompraDTO(){}

    public CompraDTO(Compra compra) {
        this.id = compra.getId();
        this.status = compra.getCompraStatus().name();
        this.total = compra.getTotal();
        this.usuario = new UsuarioDTO(compra.getCliente());

        this.compraItens = compra.getCompraItens().stream()
                .map(CompraItemDTO::new)
                .toList();
    }

    public Long getId() { return id; }
    public String getStatus() { return status; }
    public Double getTotal() { return total; }
    public UsuarioDTO getUsuario() { return usuario; }
    public List<CompraItemDTO> getItens() { return compraItens; }
}