package angelolaera.gestione_eventi_finale.controller;

import angelolaera.gestione_eventi_finale.entities.Utente;
import angelolaera.gestione_eventi_finale.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utenti")
    public class UtenteController {
        @Autowired
        private UtenteService utenteService;

        @PostMapping("/registrati")
        public Utente registrati(@RequestBody Utente utente) {
            return utenteService.registrati(utente);
        }

        @PostMapping("/accedi")
        public Utente accedi(@RequestBody String email) {
            return utenteService.accedi(email);
        }
    }

