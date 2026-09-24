package org.example.rentcar.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class Modalidad {
    private final String codigo;
    private final String nombre;
    private final String descripcion;
    private final int duracionMinima;
    private final double valorDiario;
    private EstadoModalidad estado;
    private final List<String> beneficios = new ArrayList<>();

    protected Modalidad (String codigo, String nombre, String descripcion, int duracionMinima, double valorDiario, EstadoModalidad estado, List<String> beneficios ){
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionMinima = duracionMinima;
        this.valorDiario = valorDiario;
        this.estado = estado;
        this.beneficios.addAll(beneficios);

    }

    //Metodo abstracto para que todas las sublcases lo definan por separado
    public abstract double porcentajeDescuento(int dias);

    //MEtodos Gets y set del atributo modificable
    public String getCodigo() {return codigo;}
    public String getNombre() {return nombre;}
    public String getDescripcion() {return descripcion;}
    public int getDuracionMinima() {return duracionMinima;}
    public double getValorDiario() {return valorDiario;}
    public EstadoModalidad getEstado() {return estado;}
    public List<String> getBeneficios() {return Collections.unmodifiableList(beneficios);}
    public void setEstado(EstadoModalidad estado) {this.estado = estado;}

    @Override
    public String toString() { return nombre + "(" + codigo + ")";}
}
