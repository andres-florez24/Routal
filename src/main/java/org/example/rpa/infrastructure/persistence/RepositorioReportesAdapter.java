package org.example.rpa.infrastructure.persistence;

import org.example.rpa.application.port.RepositorioReportes;
import org.example.rpa.domain.model.ReporteDomicilio;
import org.springframework.stereotype.Component;

@Component
public class RepositorioReportesAdapter implements RepositorioReportes {
    private final ReporteDomicilioSpringRepository springRepository;
    private final ReporteDomicilioMapper mapper;

    public RepositorioReportesAdapter(ReporteDomicilioSpringRepository springRepository, ReporteDomicilioMapper mapper) {
        this.springRepository =  springRepository;
        this.mapper = mapper;
    }

    @Override
    public ReporteDomicilio guardar(ReporteDomicilio reporte) {
        ReporteDomicilioJpaEntity entidad = mapper.aEntidad(reporte);
        ReporteDomicilioJpaEntity guardada = springRepository.save(entidad);
        return mapper.aDominio(guardada);
    }

    @Override
    public boolean existeReporteDuplicado(String cliente, String entrega) {
        return springRepository.existsByClienteAndEntrega(cliente, entrega);
    }

}
