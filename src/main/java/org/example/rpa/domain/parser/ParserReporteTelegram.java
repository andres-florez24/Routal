package org.example.rpa.domain.parser;

import org.example.rpa.domain.model.DatoInvalidoException;
import org.example.rpa.domain.model.MetodoPago;
import org.example.rpa.domain.model.ReporteDomicilio;

import java.util.Map;

public class ParserReporteTelegram {

    public ReporteDomicilio parsear(Map<String, String> datosCrudos) {
        if (datosCrudos == null || datosCrudos.isEmpty()) {
            throw new DatoInvalidoException("El mensaje de Telegram llegó vacío o mal formado.");
        }
        String cliente = obtenerCampo(datosCrudos, "cliente");
        String entrega = obtenerCampo(datosCrudos, "entrega");
        String recogida = obtenerCampo(datosCrudos, "recogida");
        MetodoPago metodoPago = MetodoPago.desdeTexto(obtenerCampo(datosCrudos, "metodo_pago"));
        int valor = parsearValor(obtenerCampo(datosCrudos, "valor"));

        return new ReporteDomicilio(null, cliente, entrega, recogida, metodoPago, valor, null);
    }

    private String obtenerCampo(Map<String, String> datos, String clave) {
        String valor = datos.get(clave);
        if (valor == null || valor.isBlank()) {
            throw new DatoInvalidoException("Falta el campo obligatorio: '" + clave + "'.");
        }
        return valor;
    }

    private int parsearValor(String valorTexto) {
        try {
            String limpio = valorTexto.replaceAll("[^0-9]", "");
            return Integer.parseInt(limpio);
        } catch (NumberFormatException e) {
            throw new DatoInvalidoException("El valor del domicilio no es numérico: " + valorTexto);
        }
    }
}