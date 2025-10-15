package fractalflame.exception;

public class IllegalMaxHitCountException extends RuntimeException {
    private static final String MESSAGE = "Максимальное количество не может быть нулевым";

    public IllegalMaxHitCountException() {
        super(MESSAGE);
    }
}
