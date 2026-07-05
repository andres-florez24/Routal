package org.example.rpa.infrastructure.persistence;

import org.example.rpa.domain.model.MetodoPago;
import org.example.rpa.domain.model.ReporteDomicilio;
import org.springframework.stereotype.Component;

@Component

public class ReporteDomicilioMapper {

    public ReporteDomicilioJpaEntity aEntidad(ReporteDomicilio dominio){
        return new ReporteDomicilioJpaEntity(
                dominio.getId(),
                dominio.getCliente(),
                dominio.getEntrega(),
                dominio.getRecogida(),
                dominio.getMetodoPago().name(),
                dominio.getValor(),
                dominio.getFechaRegistro()
        );
    }
    public ReporteDomicilio aDominio(ReporteDomicilioJpaEntity entidad) {
        return new ReporteDomicilio(
                entidad.getId(),
                entidad.getCliente(),
                entidad.getEntrega(),
                entidad.getRecogida(),
                MetodoPago.desdeTexto(entidad.getMetodoPago()), // texto -> enum
                entidad.getValor(),
                entidad.getFechaRegistro()
        );
    }
}
