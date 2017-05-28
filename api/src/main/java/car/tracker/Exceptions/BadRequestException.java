package car.tracker.Exceptions;

/**
 * Created by somasekhar on 5/28/2017.
 */
public class BadRequestException extends RuntimeException {
    public BadRequestException(String message){
        super(message);
    }

    public BadRequestException(String message, Throwable cause){
        super(message,cause);
    }

}
