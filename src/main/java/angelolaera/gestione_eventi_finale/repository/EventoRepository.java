package angelolaera.gestione_eventi_finale.repository;
import angelolaera.gestione_eventi_finale.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    List<Evento> findAll();
}
