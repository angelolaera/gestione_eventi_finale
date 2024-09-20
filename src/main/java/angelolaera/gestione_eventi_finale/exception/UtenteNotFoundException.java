package angelolaera.gestione_eventi_finale.exception;

public class UtenteNotFoundException extends RuntimeException {
    public UtenteNotFoundException() {
        super("User not found");
    }
}
