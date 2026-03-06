package api.itavest.entidades;

import api.itavest.cp.CompraItemCP;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_compra_item")
public class CompraItem {

    @EmbeddedId
    private CompraItemCP id = new CompraItemCP();

    private Integer quantidade;
    private Double preco;

    public CompraItem(){}

    public CompraItem(Compra compra, Acao acao, Integer quantidade, Double preco) {
        id.setCompra(compra);
        id.setAcao(acao);
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @JsonIgnore
    public Compra getCompra()
    {
        return id.getCompra();
    }

    public void setCompra(Compra compra)
    {
        id.setCompra(compra);
    }

    @JsonIgnore
    public Acao getAcao()
    {
        return id.getAcao();
    }

    public void setAcao(Acao acao)
    {
        id.setAcao(acao);
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
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
        CompraItem that = (CompraItem) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
