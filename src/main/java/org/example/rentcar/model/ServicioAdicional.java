package org.example.rentcar.model;

public record ServicioAdicional(String codigo, String nombre, String descripcion, double precio, boolean disponible){

    public ServicioAdicional {
        if(codigo == null || codigo.isBlank())
            throw new IllegalArgumentException("El codigo es obligatorio");
        if(precio < 0)
            throw new IllegalArgumentException("El precio no puede ser negativo");
    }

    @Override
    public String toString(){
        return nombre + "($" + precio + ")";
    }
}
