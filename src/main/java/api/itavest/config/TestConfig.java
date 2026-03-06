package api.itavest.config;

import api.itavest.entidades.Acao;
import api.itavest.entidades.Compra;
import api.itavest.entidades.CompraItem;
import api.itavest.entidades.Usuario;
import api.itavest.entidades.enums.CompraStatus;
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

        usuarioRepositorio.saveAll(Arrays.asList(usuario1,usuario2));

        Compra compra1 = new Compra(null, Instant.now(), CompraStatus.PAGO, usuario1);
        Compra compra2 = new Compra(null, Instant.now(), CompraStatus.PAGO, usuario2);
        Compra compra3 = new Compra(null, Instant.now(), CompraStatus.CANCELADO, usuario1);

        compraRepositorio.saveAll(Arrays.asList(compra1,compra2,compra3));

        Acao acao1 = new Acao(null, "BLUT3", 48.75);
        Acao acao2 = new Acao(null, "GRNX4", 32.40);
        Acao acao3 = new Acao(null, "VSTA3", 57.90);
        Acao acao4 = new Acao(null, "ORBI3", 21.65);
        Acao acao5 = new Acao(null, "NOVA4", 39.20);

        acaoRepositorio.saveAll(Arrays.asList(acao1,acao2,acao3,acao4,acao5));

        CompraItem compraItem1 = new CompraItem(compra1, acao1, 2, acao1.getPreco());
        CompraItem compraItem2 = new CompraItem(compra2, acao2, 5, acao2.getPreco());
        CompraItem compraItem3 = new CompraItem(compra3, acao3, 10, acao3.getPreco());

        compraItemRepositorio.saveAll(Arrays.asList(compraItem1,compraItem2,compraItem3));

    }
}
