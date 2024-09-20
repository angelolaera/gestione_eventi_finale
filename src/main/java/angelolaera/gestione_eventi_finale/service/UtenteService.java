package angelolaera.gestione_eventi_finale.service;


import angelolaera.gestione_eventi_finale.entities.Utente;
import angelolaera.gestione_eventi_finale.exception.NotFoundException;
import angelolaera.gestione_eventi_finale.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public List<Utente> trovaTutti() {
        return utenteRepository.findAll();
    }

    public Utente trovaPerId(Long id) {
        return utenteRepository.findById(id).orElseThrow(() -> new NotFoundException("Utente non trovato con ID: " + id));
    }

    public Utente salvaUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public Utente trovaPerIdEAggiorna(Long id, Utente utenteAggiornato) {
        Utente utente = trovaPerId(id);
        utente.setNome(utenteAggiornato.getNome());
        utente.setCognome(utenteAggiornato.getCognome());
        utente.setEmail(utenteAggiornato.getEmail());
        return utenteRepository.save(utente);
    }

    public void trovaPerIdECancella(Long id) {
        Utente utente = trovaPerId(id);
        utenteRepository.delete(utente);
    }
}
