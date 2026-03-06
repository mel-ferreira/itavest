package api.itavest.entidades;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_acoes")
public class Acao {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String ticker;
    private Double preco;

    public Acao(){}

    public Acao(Long id, String ticker, Double preco) {
        this.id = id;
        this.ticker = ticker;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Acao acao = (Acao) o;
        return Objects.equals(id, acao.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
