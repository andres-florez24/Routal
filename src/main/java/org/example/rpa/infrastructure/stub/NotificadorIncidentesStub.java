package org.example.rpa.infrastructure.stub;

import org.example.rpa.application.port.NotificadorIncidentes;
import org.example.rpa.domain.model.ReporteDomicilio;
import org.springframework.stereotype.Component;

@Component
public class NotificadorIncidentesStub  implements NotificadorIncidentes {
    @Override
    public void notificarIncidente(ReporteDomicilio reporte, String motivoError) {
        // TODO: reemplazar por la implementación real contra ServiceNow.
        // Por ahora, solo lo registra en la consola de logs.
        System.out.println("[INCIDENTE SIMULADO] Motivo: " + motivoError
                + " | Cliente: " + reporte.getCliente()
                + " | Entrega: " + reporte.getEntrega());
    }

}
