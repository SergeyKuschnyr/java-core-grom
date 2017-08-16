package lesson20.task2.Exception;

/**
 * Created by Kushn_000 on 15.08.2017.
 */
public class LimitExceeded extends BadRequestException {
    public LimitExceeded(String message) {
        super(message);
    }
}
