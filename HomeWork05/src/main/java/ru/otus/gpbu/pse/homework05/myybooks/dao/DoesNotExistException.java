package ru.otus.gpbu.pse.homework05.myybooks.dao;

public class DoesNotExistException extends RuntimeException{
    public DoesNotExistException(String message, Throwable e){
        super(message, e);
    }
}
