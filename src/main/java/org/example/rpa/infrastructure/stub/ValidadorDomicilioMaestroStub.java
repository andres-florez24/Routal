package org.example.rpa.infrastructure.stub;

import org.example.rpa.application.port.ValidadorDomicilioMaestro;
import org.springframework.stereotype.Component;
@Component
public class ValidadorDomicilioMaestroStub implements ValidadorDomicilioMaestro {
    @Override
    public boolean existeDomicilioValido(String entrega, String cliente) {
        // TODO: reemplazar por la implementación real contra Google Sheets.
        // Por ahora, siempre retorna true para permitir probar el flujo completo.
        return true;
   }
}

