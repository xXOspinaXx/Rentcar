package org.example.rentcar.model;

import java.util.List;

public final class ModalidadFactory {
    private ModalidadFactory() {}

    public static Modalidad crearEconomica(String codigo, String nombre, String descripcion, int minDias, double valorDiario, EstadoModalidad estado, List<String> beneficios) {
        return new Economica(codigo, nombre, descripcion, minDias, valorDiario, estado, beneficios);
    }

    public static Modalidad crearEjecutiva (String codigo, String nombre, String descripcion, int minDias, double valorDiario, EstadoModalidad estado, List<String>beneficios){
        return new Ejecutiva(codigo, nombre, descripcion, minDias, valorDiario, estado, beneficios);
    }

    public static Modalidad crearPremium (String codigo, String nombre, String descripcion, int minDias, double valorDiario, EstadoModalidad estado, List<String> beneficios, String cobertura, int conductores, String caracteristicas) {
        return new Premium(codigo, nombre, descripcion, minDias, valorDiario, estado, beneficios, cobertura, conductores, caracteristicas);
    }
}
