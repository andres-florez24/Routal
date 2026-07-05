package org.example.rpa.application.usecase;

import org.example.rpa.application.port.NotificadorIncidentes;
import org.example.rpa.application.port.RepositorioReportes;
import org.example.rpa.application.port.ValidadorDomicilioMaestro;
import org.example.rpa.domain.model.ReporteDomicilio;

public class ProcesarReporteUseCase {
    private final RepositorioReportes repositorioReportes;
    private final ValidadorDomicilioMaestro validadorDomicilioMaestro;
    private final NotificadorIncidentes notificadorIncidentes;

    public ProcesarReporteUseCase(RepositorioReportes  repositorioReportes,ValidadorDomicilioMaestro validadorDomicilioMaestro,NotificadorIncidentes notificadorIncidentes) {
        this.repositorioReportes = repositorioReportes;
        this.validadorDomicilioMaestro = validadorDomicilioMaestro;
        this.notificadorIncidentes = notificadorIncidentes;

    }

    public ReporteDomicilio ejecutar(ReporteDomicilio reporte){
        boolean esValido =validadorDomicilioMaestro.existeDomicilioValido(
                reporte.getEntrega(),reporte.getCliente());

        ReporteDomicilio reporteGuardado = repositorioReportes.guardar(reporte);

        if(!esValido){
            notificadorIncidentes.notificarIncidente(
                    reporteGuardado, "El domicilio o la empresa no coinciden con la base maestra (Google Sheets).");
        }
        return reporteGuardado;
    }
}
