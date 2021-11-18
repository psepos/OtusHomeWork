package ru.otus.gpbu.earth.service.adminserver;

public class ShutdownErrorException extends Exception {

    public ShutdownErrorException() {
        super();
    }
    public ShutdownErrorException(String message) {
        super(message);
    }
    public ShutdownErrorException(String message, Throwable cause) {
        super(message, cause);
    }

}
