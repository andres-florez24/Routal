package org.example.rpa.infrastructure.config;

import org.example.rpa.application.port.NotificadorIncidentes;
import org.example.rpa.application.port.RepositorioReportes;
import org.example.rpa.application.port.ValidadorDomicilioMaestro;
import org.example.rpa.application.usecase.ProcesarReporteUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    @Bean
    public ProcesarReporteUseCase procesarReporteUseCase(
            RepositorioReportes repositorioReportes,
            ValidadorDomicilioMaestro validadorDomicilioMaestro,
            NotificadorIncidentes notificadorIncidentes) {

        return new ProcesarReporteUseCase(
                repositorioReportes,
                validadorDomicilioMaestro,
                notificadorIncidentes
        );
    }
}
