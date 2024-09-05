package br.com.unime.apibooks.exceptions;

public class TableEmptyException extends RuntimeException {
    public TableEmptyException(String message) {
        super(message);
    }
}
