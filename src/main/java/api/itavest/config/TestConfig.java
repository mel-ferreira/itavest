package api.itavest.config;

import api.itavest.entidades.*;
import api.itavest.entidades.enums.CompraStatus;
import api.itavest.entidades.enums.PagamentoStatus;
import api.itavest.repositorios.AcaoRepositorio;
import api.itavest.repositorios.CompraItemRepositorio;
import api.itavest.repositorios.CompraRepositorio;
import api.itavest.repositorios.UsuarioRepositorio;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Autowired
    CompraRepositorio compraRepositorio;

    @Autowired
    AcaoRepositorio acaoRepositorio;

    @Autowired
    CompraItemRepositorio compraItemRepositorio;

    @Override
    public void run(String @NonNull ... args) {
        Usuario usuario1 = new Usuario(null, "Melissa Ferreira", "melissa@gmail.com", "11983493502", "melzinha123");
        Usuario usuario2 = new Usuario(null, "Rayssa Soares", "rayssa@gmail.com", "11983496204", "123456789");
        Usuario usuario3 = new Usuario(null, "Lucas Almeida", "lucas.almeida@gmail.com", "11984561230", "123456789");
        Usuario usuario4 = new Usuario(null, "Fernanda Costa", "fernanda.costa@gmail.com", "11987654321", "123456789");
        Usuario usuario5 = new Usuario(null, "Bruno Martins", "bruno.martins@gmail.com", "11991234567", "123456789");
        Usuario usuario6 = new Usuario(null, "Camila Rodrigues", "camila.rodrigues@gmail.com", "11992345678", "123456789");
        Usuario usuario7 = new Usuario(null, "Gabriel Ferreira", "gabriel.ferreira@gmail.com", "11993456789", "123456789");
        Usuario usuario8 = new Usuario(null, "Juliana Santos", "juliana.santos@gmail.com", "11994567890", "123456789");
        Usuario usuario9 = new Usuario(null, "Pedro Henrique", "pedro.henrique@gmail.com", "11995678901", "123456789");

        usuarioRepositorio.saveAll(Arrays.asList(usuario1,usuario2, usuario3, usuario4, usuario5, usuario6, usuario7, usuario8, usuario9));

        Compra compra1 = new Compra(null, Instant.now(), usuario1);
        Compra compra2 = new Compra(null, Instant.now(), usuario2);
        Compra compra3 = new Compra(null, Instant.now(), usuario1);
        Compra compra4 = new Compra(null, Instant.now(), usuario2);
        Compra compra5 = new Compra(null, Instant.now(), usuario3);
        Compra compra6 = new Compra(null, Instant.now(), usuario4);
        Compra compra7 = new Compra(null, Instant.now(), usuario5);
        Compra compra8 = new Compra(null, Instant.now(), usuario6);
        Compra compra9 = new Compra(null, Instant.now(), usuario7);
        Compra compra10 = new Compra(null, Instant.now(), usuario8);
        Compra compra11 = new Compra(null, Instant.now(), usuario9);
        Compra compra12 = new Compra(null, Instant.now(), usuario1);


        compraRepositorio.saveAll(Arrays.asList(compra1, compra2, compra3, compra4, compra5, compra6, compra7, compra8, compra9, compra10, compra11));

        Acao acao1 = new Acao(null, "BLUT3", 48.75);
        Acao acao2 = new Acao(null, "GRNX4", 32.40);
        Acao acao3 = new Acao(null, "VSTA3", 57.90);
        Acao acao4 = new Acao(null, "ORBI3", 21.65);
        Acao acao5 = new Acao(null, "NOVA4", 39.20);

        acaoRepositorio.saveAll(Arrays.asList(acao1,acao2,acao3,acao4,acao5));

        CompraItem compraItem1 = new CompraItem(compra1, acao1, 2, acao1.getPreco());
        CompraItem compraItem2 = new CompraItem(compra2, acao2, 5, acao2.getPreco());
        CompraItem compraItem3 = new CompraItem(compra3, acao3, 10, acao3.getPreco());
        CompraItem compraItem4 = new CompraItem(compra4, acao4, 5, acao4.getPreco());
        CompraItem compraItem5 = new CompraItem(compra5, acao5, 12, acao5.getPreco());
        CompraItem compraItem6 = new CompraItem(compra6, acao1, 7, acao1.getPreco());
        CompraItem compraItem7 = new CompraItem(compra7, acao2, 3, acao2.getPreco());
        CompraItem compraItem8 = new CompraItem(compra8, acao3, 20, acao3.getPreco());
        CompraItem compraItem9 = new CompraItem(compra9, acao4, 8, acao4.getPreco());
        CompraItem compraItem10 = new CompraItem(compra10, acao5, 15, acao5.getPreco());
        CompraItem compraItem11 = new CompraItem(compra11, acao5, 3, acao5.getPreco());
        CompraItem compraItem12 = new CompraItem(compra12, acao3, 12, acao5.getPreco());


        compraItemRepositorio.saveAll(Arrays.asList(compraItem1,compraItem2,compraItem3, compraItem4, compraItem5, compraItem6, compraItem7, compraItem8, compraItem9, compraItem10, compraItem11));

        Pagamento pagamento1 = new Pagamento(null,Instant.now(), PagamentoStatus.EXECUTADO,compra1);
        Pagamento pagamento2 = new Pagamento(null,Instant.now(), PagamentoStatus.PENDENTE,compra2);
        Pagamento pagamento3 = new Pagamento(null,Instant.now(), PagamentoStatus.CANCELADO,compra3);
        Pagamento pagamento4 = new Pagamento(null, Instant.now(), PagamentoStatus.EXECUTADO, compra4);
        Pagamento pagamento5 = new Pagamento(null, Instant.now(), PagamentoStatus.PENDENTE, compra5);
        Pagamento pagamento6 = new Pagamento(null, Instant.now(), PagamentoStatus.EXECUTADO, compra6);
        Pagamento pagamento7 = new Pagamento(null, Instant.now(), PagamentoStatus.CANCELADO, compra7);

        compra1.setPagamento(pagamento1);
        compra2.setPagamento(pagamento2);
        compra3.setPagamento(pagamento3);
        compra4.setPagamento(pagamento4);
        compra5.setPagamento(pagamento5);
        compra6.setPagamento(pagamento6);
        compra7.setPagamento(pagamento7);

        compraRepositorio.saveAll(Arrays.asList(compra1,compra2,compra3));

    }
}
