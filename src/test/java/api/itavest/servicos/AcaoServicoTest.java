package api.itavest.servicos;

import api.itavest.entidades.Acao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
public class AcaoServicoTest {

    @Autowired
    private AcaoServico acaoServico;

    @Test
    void deveRetornarAcoesAbaixoDe35() {

        List<Acao> resultado = acaoServico.findAcoesAbaixoDePreco();

        assertFalse(resultado.isEmpty());
    }

    @Test
    void deveBuscarAcaoPorId() {

        Acao acao = acaoServico.findById(1L);

        assertNotNull(acao);
    }

    @Test
    void deveRetornarListaDeAcoes() {

        List<Acao> lista = acaoServico.findAll();

        assertFalse(lista.isEmpty());
    }
}