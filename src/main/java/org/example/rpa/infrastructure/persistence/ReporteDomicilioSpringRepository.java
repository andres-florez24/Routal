package org.example.rpa.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReporteDomicilioSpringRepository extends JpaRepository<ReporteDomicilioJpaEntity,Integer> {
    boolean existsByClienteAndEntrega(String cliente, String entrega);
}
