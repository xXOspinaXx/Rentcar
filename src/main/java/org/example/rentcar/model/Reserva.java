package org.example.rentcar.model;

import javafx.util.Builder;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Reserva {
    private final String codigo;
    private final Cliente cliente;
    private final Vehiculo vehiculo;
    private final Modalidad modalidad;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;
    private final List<ServicioAdicional> servicios;

    private Reserva(Builder b){
        this.codigo = b.codigo;
        this.cliente = b.cliente;
        this.vehiculo = b.vehiculo;
        this.modalidad = b.modalidad;
        this.fechaInicio = b.fechaInicio;
        this.fechaFin = b.fechaFin;
        this.servicios = new ArrayList<>(b.servicios);
    }

    public int dias() {
        return (int) ChronoUnit.DAYS.between(fechaInicio, fechaFin);
    }

    public double calcularTotal(){
        double base = dias() * (modalidad.getValorDiario() + vehiculo.tarifaDiaria());
        double descuento = base * modalidad.porcentajeDescuento(dias());
        double extras = 0;
        for(ServicioAdicional s : servicios) {
            extras += s.precio();
        }
        return base - descuento + extras;
    }

    public String getCodigo() {return codigo;}
    public Cliente getCliente() {return cliente;}
    public Vehiculo getVehiculo() {return vehiculo;}
    public Modalidad getModalidad() {return modalidad;}
    public LocalDate getFechaInicio() {return fechaInicio;}
    public LocalDate getFechaFin() {return fechaFin;}
    public List<ServicioAdicional> getServicios() {return Collections.unmodifiableList(servicios);}

    @Override
    public String toString() {
        return codigo + " | " + cliente.getNombreCompleto() + " | " + vehiculo.placa()
                + " | " + modalidad.getNombre() + " | " + fechaInicio + " a " + fechaFin;
    }

    //Metodo Builder
    public static class Builder {
        private String codigo;
        private  Cliente cliente;
        private Vehiculo vehiculo;
        private Modalidad modalidad;
        private LocalDate fechaInicio;
        private LocalDate fechaFin;
        private final List<ServicioAdicional> servicios = new ArrayList<>();

        public Builder codigo(String codigo){this.codigo = codigo; return this;}
        public Builder cliente(Cliente cliente){this.cliente = cliente; return this;}
        public Builder vehiculo(Vehiculo vehiculo){this.vehiculo = vehiculo; return this;}
        public Builder modalidad(Modalidad modalidad) { this.modalidad = modalidad; return this; }

        public Builder periodo(LocalDate inicio, LocalDate fin) {
            this.fechaInicio = inicio;
            this.fechaFin = fin;
            return this;
        }

        public Builder servicio(ServicioAdicional servicio) {
            if (!servicio.disponible())
                throw new IllegalArgumentException("Servicio no disponible: " + servicio.nombre());
            servicios.add(servicio);
            return this;
        }

        public Reserva build() {
            if (codigo == null || cliente == null || vehiculo == null
                    || modalidad == null || fechaInicio == null || fechaFin == null)
                throw new IllegalStateException("Faltan datos de la reserva");
            if (!fechaFin.isAfter(fechaInicio))
                throw new IllegalStateException("La fecha fin debe ser posterior a la de inicio");
            if (modalidad.getEstado() != EstadoModalidad.DISPONIBLE)
                throw new IllegalStateException("La modalidad no está disponible");
            long dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
            if (dias < modalidad.getDuracionMinima())
                throw new IllegalStateException(
                        "Duración menor a la mínima (" + modalidad.getDuracionMinima() + " días)");
            return new Reserva(this);
        }
    }

}

