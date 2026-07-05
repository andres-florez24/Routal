package org.example.rpa.application.port;

public interface ValidadorDomicilioMaestro {
    /**
     * Verifica si el domicilio y la empresa existen registrados
     * en la fuente maestra de control (Google Sheets).
     */
    boolean existeDomicilioValido(String entrega, String cliente);
}
