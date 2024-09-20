package angelolaera.gestione_eventi_finale.repository;
import angelolaera.gestione_eventi_finale.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, Long> {
    Utente findByEmail(String email);
}