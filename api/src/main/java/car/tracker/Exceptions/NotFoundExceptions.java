package car.tracker.Exceptions;

/**
 * Created by somasekhar on 5/27/2017.
 */
public class NotFoundExceptions extends RuntimeException {

    public NotFoundExceptions(String message) {
        super(message);
    }

    public NotFoundExceptions(String message, Throwable cause) {

    super(message,cause);
    }
}
