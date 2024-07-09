package org.parqueaderos.parqueadero;

public class Vehiculo {
    private String matricula;
    private String tipo;

    // Constructor para la clase Vehiculo
    public Vehiculo(String matricula, String tipo) {
        this.matricula = matricula;
        this.tipo = tipo;
    }

    // Obtener la matrícula del vehículo
    public String obtenerMatricula() {
        return matricula;
    }
    // Obtener el tipo de vehículo
    public String obtenerTipo() {
        return tipo;
    }
}

