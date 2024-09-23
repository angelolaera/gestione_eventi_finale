package angelolaera.gestione_eventi_finale.controller;

import angelolaera.gestione_eventi_finale.entities.Utente;
import angelolaera.gestione_eventi_finale.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;

    // 1. GET http://localhost:3001/utenti
    @GetMapping
    private List<Utente> getAllUtenti() {
        return utenteService.trovaTutti();
    }

    // 2. GET http://localhost:3001/utenti/{id}
    @GetMapping("/{id}")
    private Utente getUtenteById(@PathVariable Long id) {
        return utenteService.trovaPerId(id);
    }

    // 3. POST http://localhost:3001/utenti (+body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Utente createUtente(@RequestBody Utente body) {
        return utenteService.salvaUtente(body);
    }

    // 4. PUT http://localhost:3001/utenti/{id} (+body)
    @PutMapping("/{id}")
    private Utente updateUtenteById(@PathVariable Long id, @RequestBody Utente body) {
        return utenteService.trovaPerIdEAggiorna(id, body);
    }

    // 5. DELETE http://localhost:3001/utenti/{id}
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    private void deleteUtente(@PathVariable Long id) {
        utenteService.trovaPerIdECancella(id);
    }
}


