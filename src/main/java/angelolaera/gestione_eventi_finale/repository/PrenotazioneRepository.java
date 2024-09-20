package angelolaera.gestione_eventi_finale.repository;

import angelolaera.gestione_eventi_finale.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Long> {
    List<Prenotazione> findUtenteById(Long utenteId);
}
