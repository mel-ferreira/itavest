package api.itavest.dtos;

import api.itavest.entidades.Acao;

public class AcaoDTO {

    private Long id;
    private String nome;
    private Double preco;

    public AcaoDTO(){}

    public AcaoDTO(Acao entity)
    {
        id = entity.getId();
        nome = entity.getTicker();
        preco = entity.getPreco();
    }

    public Long getId() {
        return id;
    }

    public String getTicker() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }
}