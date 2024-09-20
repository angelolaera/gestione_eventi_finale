package angelolaera.gestione_eventi_finale.exception;

public class EventoNotFoundException extends RuntimeException {
    public EventoNotFoundException() {
        super("Event not found");
    }
}
