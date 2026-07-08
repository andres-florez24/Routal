package org.example.rpa.infrastructure.web;

import org.example.rpa.application.usecase.ProcesarReporteUseCase;
import org.example.rpa.domain.model.DatoInvalidoException;
import org.example.rpa.domain.model.ReporteDomicilio;
import org.example.rpa.domain.parser.ParserReporteTelegram;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/reportes")
public class ReporteController {
    private final ProcesarReporteUseCase procesarReporteUseCase;
    private final ParserReporteTelegram parser;

    public ReporteController(ProcesarReporteUseCase procesarReporteUseCase) {
        this.procesarReporteUseCase = procesarReporteUseCase;
        this.parser = new ParserReporteTelegram();
    }

    @PostMapping
    public ResponseEntity<?> recibirReporte(@RequestBody Map<String, String> datosCrudos) {
        try {
            ReporteDomicilio reporte = parser.parsear(datosCrudos);
            ReporteDomicilio guardado = procesarReporteUseCase.ejecutar(reporte);
            return ResponseEntity.ok(guardado);

        } catch (DatoInvalidoException e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }



}
