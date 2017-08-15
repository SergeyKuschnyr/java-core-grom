package lesson20.task1.exeption;

/**
 * Created by Kushn_000 on 15.08.2017.
 */
public class BadRequestException extends Exception {
    public BadRequestException(String message) {
        super(message);
    }
}
