package car.tracker.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by somasekhar on 5/27/2017.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundExceptions extends RuntimeException {

    public NotFoundExceptions(String message) {
        super(message);
    }

    public NotFoundExceptions(String message, Throwable cause) {

    super(message,cause);
    }
}
