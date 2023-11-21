/**
 * Klasa obsługująca wyjątek związany z błędnym inputem od użytkownika.
 */
public class InvalidInputException extends RuntimeException {
    /**
     * Metoda obsługująca wyjątek
     * @param message komunikat związany z konkretnym błędem inputu
     */
    public InvalidInputException (String message) {
        super(message);
    }
}
