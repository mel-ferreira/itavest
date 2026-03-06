package api.itavest.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @OneToMany(mappedBy = "id.acao")
    private Set<CompraItem> compraItens = new HashSet<>();

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

    @JsonIgnore
    public Set<Compra> getCompras()
    {
        Set<Compra> set = new HashSet<>();
        for (CompraItem item : compraItens)
        {
            set.add(item.getCompra());
        }
        return set;
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
