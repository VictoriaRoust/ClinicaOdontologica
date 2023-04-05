package com.dh.backendIntegrador.exception;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}

