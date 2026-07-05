package org.example.rpa.domain.model;
public enum MetodoPago {
    EFECTIVO,
    TRANSFERENCIA,
    TARJETA,
    CREDITO;

    public static MetodoPago desdeTexto(String textoCrudo) {
        if (textoCrudo == null || textoCrudo.isBlank()) {
            throw new DatoInvalidoException("El método de pago no puede estar vacío.");
        }
        String normalizado = textoCrudo.trim().toUpperCase()
                .replace("É", "E").replace("Ó", "O");

        return switch (normalizado) {
            case "EFECTIVO", "CASH" -> EFECTIVO;
            case "TRANSFERENCIA", "TRANSFER" -> TRANSFERENCIA;
            case "TARJETA", "TARJETA DEBITO", "DEBITO" -> TARJETA;
            case "CREDITO" -> CREDITO;
            default -> throw new DatoInvalidoException(
                    "Método de pago no reconocido: " + textoCrudo);
        };
    }
}