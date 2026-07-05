package org.example.rpa.domain.model;
import java.time.LocalDateTime;
import java.util.Objects;

public class ReporteDomicilio {
    private final Integer id;
    private final String cliente;
    private final String entrega;
    private final String recogida;
    private final MetodoPago metodoPago;
    private final int valor;
    private final LocalDateTime fechaRegistro;

    public ReporteDomicilio(Integer id, String cliente, String entrega,
                            String recogida, MetodoPago metodoPago,
                            int valor, LocalDateTime fechaRegistro) {
        this.cliente = validarTexto(cliente, "cliente");
        this.entrega = validarTexto(entrega, "entrega");
        this.recogida = validarTexto(recogida, "recogida");
        this.metodoPago = Objects.requireNonNull(metodoPago, "El método de pago es obligatorio.");
        this.valor = validarValor(valor);
        this.id = id;
        this.fechaRegistro = fechaRegistro != null ? fechaRegistro : LocalDateTime.now();
    }

    private String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new DatoInvalidoException("El campo '" + campo + "' no puede estar vacío.");
        }
        return valor.trim();
    }

    private int validarValor(int valor) {
        if (valor <= 0) {
            throw new DatoInvalidoException("El valor del domicilio debe ser mayor a cero.");
        }
        return valor;
    }


    public Integer getId() { return id; }
    public String getCliente() { return cliente; }
    public String getEntrega() { return entrega; }
    public String getRecogida() { return recogida; }
    public MetodoPago getMetodoPago() { return metodoPago; }
    public int getValor() { return valor; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
}