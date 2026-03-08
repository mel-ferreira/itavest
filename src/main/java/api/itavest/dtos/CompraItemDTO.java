package api.itavest.dtos;

import api.itavest.entidades.CompraItem;

public class CompraItemDTO {

    private Long acaoId;
    private String acaoTicker;
    private Integer quantidade;
    private Double precoUnitario;
    private Double subtotal;

    public CompraItemDTO(CompraItem item) {
        this.acaoId = item.getAcao().getId();
        this.acaoTicker = item.getAcao().getTicker();
        this.quantidade = item.getQuantidade();
        this.precoUnitario = item.getPreco();
        this.subtotal = item.getSubtotal();
    }

    public Long getAcaoId() { return acaoId; }
    public String getAcaoNome() { return acaoTicker; }
    public Integer getQuantidade() { return quantidade; }
    public Double getPrecoUnitario() { return precoUnitario; }
    public Double getSubtotal() { return subtotal; }
}