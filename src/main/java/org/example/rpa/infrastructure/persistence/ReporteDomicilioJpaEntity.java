package org.example.rpa.infrastructure.persistence;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="reportes_telegram")
public class ReporteDomicilioJpaEntity {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String cliente;

    @Column(nullable = false)
    private String entrega;

    @Column(nullable = false)
    private String recogida;

    @Column(name = "metodo_pago", nullable = false)
    private String metodoPago;

    @Column(nullable = false)
    private int valor;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    // JPA exige un constructor vacío (lo usa internamente por reflexión)
    protected ReporteDomicilioJpaEntity() {
    }

    public ReporteDomicilioJpaEntity(Integer id, String cliente, String entrega, String recogida,
                                     String metodoPago, int valor, LocalDateTime fechaRegistro) {
        this.id= id;
        this.cliente = cliente;
        this.entrega = entrega;
        this.recogida = recogida;
        this.metodoPago = metodoPago;
        this.valor = valor;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getId() { return id; }
    public String getCliente() { return cliente; }
    public String getEntrega() { return entrega; }
    public String getRecogida() { return recogida; }
    public String getMetodoPago() { return metodoPago; }
    public int getValor() { return valor; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }

}
