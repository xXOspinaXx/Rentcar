package org.example.rentcar.model;

import java.util.List;

public class Ejecutiva extends Modalidad {
    public Ejecutiva(String codigo, String nombre, String descripcion, int duracionMinimaDias,double valorDiario,EstadoModalidad estado, List<String> beneficios) {
        super(codigo, nombre, descripcion, duracionMinimaDias,valorDiario, estado, beneficios);
    }
    //Apartir del dia 7 se le hace el 5% de descuento
    @Override
    public double porcentajeDescuento(int dias) {
        return dias >= 7 ? 0.05 : 0.0;
    }
}
