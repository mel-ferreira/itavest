package api.itavest.entidades;

import api.itavest.entidades.enums.PagamentoStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_pagamentos")
public class Pagamento {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private Instant dataPagamento;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Compra compra;

    private Integer pagamentoStatus;

    public Pagamento(){}

    public Pagamento(Long id, Instant dataPagamento, PagamentoStatus pagamentoStatus, Compra compra) {
        this.id = id;
        this.dataPagamento = dataPagamento;
        setPagamentoStatus(pagamentoStatus);
        this.compra = compra;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Instant dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public PagamentoStatus getPagamentoStatus()
    {
        return PagamentoStatus.valueOf(pagamentoStatus);
    }

    public void setPagamentoStatus(PagamentoStatus pagamentoStatus)
    {
        if(pagamentoStatus != null)
        {
            this.pagamentoStatus = pagamentoStatus.getCodigo();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(id, pagamento.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
