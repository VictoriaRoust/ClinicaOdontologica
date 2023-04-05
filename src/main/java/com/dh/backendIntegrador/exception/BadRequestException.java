package com.dh.backendIntegrador.exception;

public class BadRequestException extends Exception{
    public BadRequestException(String mensaje){
        super(mensaje);
    }
}
