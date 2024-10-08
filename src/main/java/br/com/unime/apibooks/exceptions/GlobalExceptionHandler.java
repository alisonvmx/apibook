package br.com.unime.apibooks.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ BookNotFoundException.class, TableEmptyException.class })
    public ResponseEntity<Map<String, String>> handleAllExceptions(Exception exception) {
        Map<String, String> errorResponse = new HashMap<>();

        if (exception instanceof BookNotFoundException) {
            errorResponse.put("message", exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }else if(exception instanceof TableEmptyException){
            errorResponse.put("message", exception.getMessage());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorResponse);
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

}
