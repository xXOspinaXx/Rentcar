package org.example.rentcar.model;

public class Vehiculo(String placa, String marca, String modelo, int año, String tipo, double tarifaDiaria){

    public Vehiculo {
        if (placa == null || placa.isBlank())
            throw new IllegalArgumentException("La placa es obligatoria");
        if (tarifaDiaria <= 0)
            throw new IllegalArgumentException("La tarifa diaria debe ser mayor a 0");
    }

    @Override
    public String toString(){
        return placa +" - " + marca + " " + modelo;
    }
}
