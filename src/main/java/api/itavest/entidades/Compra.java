package api.itavest.entidades;

import api.itavest.entidades.enums.CompraStatus;
import api.itavest.entidades.enums.PagamentoStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")
    private Instant dataCompra;

    private Integer compraStatus;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Usuario cliente;

    @OneToMany(mappedBy = "id.compra")
    private Set<CompraItem> compraItens = new HashSet<>();

    public Compra(){}

    public Compra(Long id, Instant dataCompra, Usuario cliente) {
        this.id = id;
        this.dataCompra = dataCompra;
        setCompraStatus(CompraStatus.PAGAMENTO_PENDENTE);
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Instant dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public CompraStatus getCompraStatus()
    {
        return CompraStatus.valueOf(compraStatus);
    }

    public void setCompraStatus(CompraStatus compraStatus)
    {
        if(compraStatus != null)
        {
            this.compraStatus = compraStatus.getCodigo();
        }
    }

    public Set<CompraItem> getCompraItens()
    {
        return compraItens;
    }

    @OneToOne(mappedBy = "compra", cascade = CascadeType.ALL)
    private Pagamento pagamento;

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;

        if (pagamento != null)
        {
            PagamentoStatus status = pagamento.getPagamentoStatus();

            if (status == PagamentoStatus.EXECUTADO) {
                setCompraStatus(CompraStatus.PAGO);
            }

            if (status == PagamentoStatus.PENDENTE) {
                setCompraStatus(CompraStatus.PAGAMENTO_PENDENTE);
            }

            if (status == PagamentoStatus.CANCELADO) {
                setCompraStatus(CompraStatus.CANCELADO);
            }
        }
    }
    public Double getTotal()
    {
        double soma = 0.0;
        for (CompraItem item : compraItens)
        {
            soma += item.getSubtotal();
        }
        return soma;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Compra compra = (Compra) o;
        return Objects.equals(id, compra.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
