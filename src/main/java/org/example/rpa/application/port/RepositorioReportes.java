package org.example.rpa.application.port;

import org.example.rpa.domain.model.ReporteDomicilio;

public interface RepositorioReportes {
    ReporteDomicilio guardar (ReporteDomicilio reporte);
    boolean existeReporteDuplicado(String cliente , String reporte);

}
