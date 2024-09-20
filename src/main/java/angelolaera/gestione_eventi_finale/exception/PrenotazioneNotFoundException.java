package angelolaera.gestione_eventi_finale.exception;

public class PrenotazioneNotFoundException extends RuntimeException {
    public PrenotazioneNotFoundException() {
        super("Prenotazione non trovata");
    }
}
