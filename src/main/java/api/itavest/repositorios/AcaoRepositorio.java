package api.itavest.repositorios;


import api.itavest.entidades.Acao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AcaoRepositorio extends JpaRepository<Acao, Long> {
    List<Acao> findByPrecoLessThan(Double preco);

}
