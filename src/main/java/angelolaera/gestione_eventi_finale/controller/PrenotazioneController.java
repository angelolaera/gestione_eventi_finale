package angelolaera.gestione_eventi_finale.controller;

import angelolaera.gestione_eventi_finale.entities.Prenotazione;
import angelolaera.gestione_eventi_finale.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
public class PrenotazioneController {
    @Autowired
    private PrenotazioneService prenotazioneService;

    @PostMapping("/{utenteId}/{eventoId}")
    public Prenotazione creaPrenotazione(@PathVariable Long utenteId,
                                         @PathVariable Long eventoId,
                                         @RequestParam int numeroPosti) {
        return prenotazioneService.creaPrenotazione(utenteId, eventoId, numeroPosti);
    }

    @GetMapping("/utente/{utenteId}")
    public List<Prenotazione> getPrenotazioniPerUtente(@PathVariable Long utenteId) {
        return prenotazioneService.getPrenotazioniPerUtente(utenteId);
    }
}
