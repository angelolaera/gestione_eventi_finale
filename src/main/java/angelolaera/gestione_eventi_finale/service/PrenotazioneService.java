package angelolaera.gestione_eventi_finale.service;

import angelolaera.gestione_eventi_finale.entities.Evento;
import angelolaera.gestione_eventi_finale.entities.Prenotazione;
import angelolaera.gestione_eventi_finale.entities.Utente;
import angelolaera.gestione_eventi_finale.exception.NotFoundException;
import angelolaera.gestione_eventi_finale.repository.EventoRepository;
import angelolaera.gestione_eventi_finale.repository.PrenotazioneRepository;
import angelolaera.gestione_eventi_finale.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private EventoRepository eventoRepository;

    public List<Prenotazione> trovaTutte() {
        return prenotazioneRepository.findAll();
    }

    public Prenotazione trovaPerId(Long id) {
        return prenotazioneRepository.findById(id).orElseThrow(() -> new NotFoundException("Prenotazione non trovata con ID: " + id));
    }

    public Prenotazione creaPrenotazione(Long utenteId, Long eventoId, int numeroPosti) {
        Utente utente = utenteRepository.findById(utenteId).orElseThrow();
        Evento evento = eventoRepository.findById(eventoId).orElseThrow();

        evento.setPostiDisponibili(evento.getPostiDisponibili() - numeroPosti);
        eventoRepository.save(evento);

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setEvento(evento);
        prenotazione.setNumeroPosti(numeroPosti);

        return prenotazioneRepository.save(prenotazione);
    }

    public Prenotazione trovaPerIdEAggiorna(Long id, Prenotazione prenotazioneAggiornata) {
        Prenotazione prenotazione = trovaPerId(id);
        prenotazione.setNumeroPosti(prenotazioneAggiornata.getNumeroPosti());
        prenotazione.setEvento(prenotazioneAggiornata.getEvento());
        prenotazione.setUtente(prenotazioneAggiornata.getUtente());
        return prenotazioneRepository.save(prenotazione);
    }

    public void trovaPerIdECancella(Long id) {
        Prenotazione prenotazione = trovaPerId(id);
        prenotazioneRepository.delete(prenotazione);
    }

}
