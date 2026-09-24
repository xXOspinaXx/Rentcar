package org.example.rentcar.model;

import java.util.List;

public class Premium extends Modalidad {
    private final String tipoCobertura;
    private final int conductoresAdicionales;
    private final String caracteristicasEspeciales;

    public Premium(String codigo, String nombre, String descripcion, int duracionMinimaDias, double valorDiario, EstadoModalidad estado, List<String> beneficios, String tipoCobertura, int conductoresAdicionales, String caracteristicasEspeciales) {
        super(codigo, nombre, descripcion, duracionMinimaDias, valorDiario, estado, beneficios);
        this.tipoCobertura = tipoCobertura;
        this.conductoresAdicionales = conductoresAdicionales;
        this.caracteristicasEspeciales = caracteristicasEspeciales;
    }
    //Siempre va a tener el 5% despues del dia 7 10% de descuento
    @Override
    public double porcentajeDescuento(int dias){
        return dias >= 7 ? 0.10 : 0.05;
    }

    public String getTipoCobertura() {return tipoCobertura;}
    public int getConductoresAdicionales() {return conductoresAdicionales;}
    public String getCaracteristicasEspeciales() {return caracteristicasEspeciales;}

}
