package org.example.rpa.application.port;

import org.example.rpa.domain.model.ReporteDomicilio;

public interface NotificadorIncidentes {

    /**
     * Crea un incidente de primer nivel cuando un reporte
     * presenta discrepancias o falla la automatización.
     */
    void notificarIncidente(ReporteDomicilio reporte, String motivoError);
}

