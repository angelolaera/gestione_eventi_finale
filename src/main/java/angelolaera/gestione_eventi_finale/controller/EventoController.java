package angelolaera.gestione_eventi_finale.controller;

import angelolaera.gestione_eventi_finale.entities.Evento;
import angelolaera.gestione_eventi_finale.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventi")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    // 1. GET http://localhost:3001/eventi
    @GetMapping
    private List<Evento> getAllEventi() {
        return eventoService.trovaTutti();
    }

    // 2. GET http://localhost:3001/eventi/{id}
    @GetMapping("/{id}")
    private Evento getEventoById(@PathVariable Long id) {
        return eventoService.trovaPerId(id);
    }

    // 3. POST http://localhost:3001/eventi (+body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Evento createEvento(@RequestBody Evento body) {
        return eventoService.salvaEvento(body);
    }

    // 4. PUT http://localhost:3001/eventi/{id} (+body)
    @PutMapping("/{id}")
    private Evento findEventoByIdAndUpdate(@PathVariable Long id, @RequestBody Evento body) {
        return eventoService.trovaPerIdEAggiorna(id, body);
    }

    // 5. DELETE http://localhost:3001/eventi/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteEvento(@PathVariable Long id) {
        eventoService.trovaPerIdECancella(id);
    }
}
