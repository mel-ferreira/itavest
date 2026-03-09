package api.itavest.dtos;

import api.itavest.entidades.Compra;
import api.itavest.entidades.enums.CompraStatus;
import api.itavest.entidades.enums.PagamentoStatus;

import java.time.Instant;
import java.util.List;

public class CompraDTO {

    private Long id;
    private String status;
    private Double total;
    private CompraStatus compraStatus;
    private UsuarioDTO usuario;
    private List<CompraItemDTO> compraItens;

    private Instant dataPagamento;
    private Instant dataCompra;


    public CompraDTO(){}

    public CompraDTO(Compra compra) {
        this.id = compra.getId();
        this.status = compra.getCompraStatus().name();
        this.total = compra.getTotal();
        this.usuario = new UsuarioDTO(compra.getCliente());

        this.dataCompra = compra.getDataCompra();

        if (compra.getPagamento() != null
                && compra.getPagamento().getPagamentoStatus() != PagamentoStatus.PENDENTE) {

            this.dataPagamento = compra.getPagamento().getDataPagamento();
        }
        this.compraItens = compra.getCompraItens().stream()
                .map(CompraItemDTO::new)
                .toList();
    }

    public Long getId() { return id; }
    public String getStatus() { return status; }
    public Double getTotal() { return total; }
    public UsuarioDTO getUsuario() { return usuario; }
    public List<CompraItemDTO> getItens() { return compraItens; }
    public Instant getDataCompra(){return dataCompra;}
    public Instant getDataPagamento(){return dataPagamento;}
}