package api.itavest.config;

import api.itavest.entidades.Compra;
import api.itavest.entidades.Usuario;
import api.itavest.entidades.enums.CompraStatus;
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

    @Override
    public void run(String @NonNull ... args) {
        Usuario usuario1 = new Usuario(null, "Melissa Ferreira", "melissa@gmail.com", "11983493502", "melzinha123");
        Usuario usuario2 = new Usuario(null, "Rayssa Soares", "rayssa@gmail.com", "11983496204", "123456789");

        Compra compra1 = new Compra(null, Instant.now(), CompraStatus.PAGO, usuario1);
        Compra compra2 = new Compra(null, Instant.now(), CompraStatus.PAGO, usuario2);
        Compra compra3 = new Compra(null, Instant.now(), CompraStatus.CANCELADO, usuario1);

        usuarioRepositorio.saveAll(Arrays.asList(usuario1,usuario2));
        compraRepositorio.saveAll(Arrays.asList(compra1,compra2,compra3));

    }
}
