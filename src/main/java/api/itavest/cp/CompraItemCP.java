package api.itavest.cp;

import api.itavest.entidades.Acao;
import api.itavest.entidades.Compra;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Embeddable
public class CompraItemCP {

    @ManyToOne
    @JoinColumn(name = "compra_id")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "acao_id")
    private Acao acao;

    public Compra getCompra()
    {
        return compra;
    }
    public void setCompra(Compra compra)
    {
        this.compra = compra;
    }
    public Acao getAcao()
    {
        return acao;
    }
    public void setAcao(Acao acao)
    {
        this.acao = acao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CompraItemCP that = (CompraItemCP) o;
        return Objects.equals(compra, that.compra) && Objects.equals(acao, that.acao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compra, acao);
    }
}
