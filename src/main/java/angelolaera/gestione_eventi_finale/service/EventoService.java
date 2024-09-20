package angelolaera.gestione_eventi_finale.service;

import angelolaera.gestione_eventi_finale.entities.Evento;
import angelolaera.gestione_eventi_finale.exception.NotFoundException;
import angelolaera.gestione_eventi_finale.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> trovaTutti() {
        return eventoRepository.findAll();
    }

    public Evento trovaPerId(Long id) {
        return eventoRepository.findById(id).orElseThrow(() -> new NotFoundException("Evento non trovato con ID: " + id));
    }

    public Evento salvaEvento(Evento evento) {
        return eventoRepository.save(evento);
    }

    public Evento trovaPerIdEAggiorna(Long id, Evento eventoAggiornato) {
        Evento evento = trovaPerId(id);
        evento.setTitolo(eventoAggiornato.getTitolo());
        evento.setDescrizione(eventoAggiornato.getDescrizione());
        evento.setData(eventoAggiornato.getData());
        evento.setLuogo(eventoAggiornato.getLuogo());
        evento.setPostiDisponibili(eventoAggiornato.getPostiDisponibili());
        return eventoRepository.save(evento);
    }

    public void trovaPerIdECancella(Long id) {
        Evento evento = trovaPerId(id);
        eventoRepository.delete(evento);
    }
}
