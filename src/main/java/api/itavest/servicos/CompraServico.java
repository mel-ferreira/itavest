package api.itavest.servicos;

import api.itavest.entidades.Compra;
import api.itavest.entidades.Pagamento;
import api.itavest.entidades.enums.PagamentoStatus;
import api.itavest.repositorios.CompraRepositorio;
import api.itavest.servicos.exceptions.BusinessException;
import api.itavest.servicos.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class CompraServico {

    private static final Logger log = LoggerFactory.getLogger(CompraServico.class);

    @Autowired
    CompraRepositorio compraRepositorio;

    public List<Compra> findAll()
    {

        List<Compra> listaCompras = compraRepositorio.findAll();
        log.debug("Quantidade de compras encontradas: {}", listaCompras.size());
        return listaCompras;
    }

    public Compra findById(Long id)
    {
        Optional<Compra> compraObj = compraRepositorio.findById(id);
        return compraObj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
    @Transactional
    public Compra processarPagamento(Long compraId, Double valor) {

        Compra compra = compraRepositorio.findById(compraId)
                .orElseThrow(() -> new ResourceNotFoundException("Compra não encontrada"));

        if (valor <= 0) {
            throw new BusinessException("Valor do pagamento deve ser positivo");
        }

        if (valor == null) {
            throw new BusinessException("Valor do pagamento não pode ser nulo");
        }
        if(!valor.equals(compra.getTotal()))
        {
            throw new BusinessException("Valor do pagamento deve ser igual ao total da compra");
        }

        Pagamento pagamentoExistente = compra.getPagamento();

        if (pagamentoExistente != null) {

            if (pagamentoExistente.getPagamentoStatus() == PagamentoStatus.CANCELADO) {
                throw new BusinessException("Compra já está cancelada");
            }

            if (pagamentoExistente.getPagamentoStatus() == PagamentoStatus.EXECUTADO) {
                throw new BusinessException("Pagamento já foi processado");
            }

            throw new BusinessException("Compra já possui pagamento");
        }

        Pagamento pagamento = new Pagamento();
        pagamento.setDataPagamento(Instant.now());
        pagamento.setPagamentoStatus(PagamentoStatus.EXECUTADO);
        pagamento.setCompra(compra);

        compra.setPagamento(pagamento);

        return compraRepositorio.save(compra);
    }
    @Transactional
    public Compra cancelarPagamento(Long compraId) {

        Compra compra = compraRepositorio.findById(compraId)
                .orElseThrow(() -> new ResourceNotFoundException(compraId));

        Pagamento pagamento = compra.getPagamento();

        if (pagamento == null) {
            throw new BusinessException("Pagamento não existe");
        }

        if (pagamento.getPagamentoStatus() == PagamentoStatus.CANCELADO) {
            throw new BusinessException("Pagamento já está cancelado");
        }

        pagamento.setPagamentoStatus(PagamentoStatus.CANCELADO);

        compra.setPagamento(pagamento);

        return compraRepositorio.save(compra);
    }
}
