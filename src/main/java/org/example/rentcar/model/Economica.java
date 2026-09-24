package org.example.rentcar.model;

import java.util.List;

public class Economica extends Modalidad {
    public Economica(String codigo, String nombre, String descripcion, int duracionMinimaDias, double valorDiario, EstadoModalidad estado, List<String> beneficios) {
        super(codigo, nombre, descripcion, duracionMinimaDias, valorDiario, estado, beneficios);
    }
    // Metodo de la clase Abstracta, se coloca 0.0 porque Economica no da descuento
    @Override
    public double porcentajeDescuento(int dias) {
        return 0.0;
    }
}
