package org.example.rentcar.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cliente {
    private final String nombreCompleto;
    private final String documento;
    private final String telefono;
    private final String correo;
    private final int edad;
    private final LocalDate fechaRegistro;
    private final List<Reserva> reservas = new ArrayList<>();

    public Cliente(String nombreCompleto, String documento, String telefono, String correo, int edad) {
        if(nombreCompleto == null || nombreCompleto.isBlank())
            throw new IllegalArgumentException("El nombre es obligatorio");
        if(documento == null || documento.isBlank())
            throw new IllegalArgumentException("El documento es obligatorio");
        if(telefono == null || telefono.isBlank())
            throw  new IllegalArgumentException("El telefono es obligatorio ");
        if(edad < 18)
            throw new IllegalArgumentException("El cliente debe ser mayor de edad");

        this.nombreCompleto = nombreCompleto;
        this.documento = documento;
        this.telefono = telefono;
        this.correo = correo;
        this.edad = edad;
        this.fechaRegistro = LocalDate.now();
    }

    public void agregarReserva(Reserva reserva){reservas.add(reserva);}
    public String getNombreCompleto(){return nombreCompleto;}public String getDocumento() {return documento;}
    public String getTelefono(){return telefono;}
    public String getCorreo(){return correo;}
    public int getEdad(){return edad;}
    public LocalDate getFechaRegistro() {return fechaRegistro;}
    public List<Reserva> getReservas() {return Collections.unmodifiableList(reservas);}

    @Override
    public String toString(){
        return nombreCompleto + " - " + documento;
    }

}
