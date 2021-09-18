package ru.otus.gpbu.pse.homework05.myybooks.repository;

public class DoesNotExistException extends RuntimeException{
    public DoesNotExistException(String message, Throwable e){
        super(message, e);
    }
}
