package br.com.sharezard.exceptions;


import static org.springframework.http.HttpStatus.CONFLICT;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = CONFLICT)
public class ConflictException extends RuntimeException {
    public ConflictException (String message) {
        super(message);
    }
}
