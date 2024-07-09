package org.parqueaderos.parqueadero;

import java.util.ArrayList;

public class Estudiante extends Usuario {
    private String idBanner; // Identificador único del estudiante
    private double saldo;    // Saldo del estudiante para utilizar en el parqueadero
    private ArrayList<Vehiculo> vehiculos;  // Lista de vehículos registrados por el estudiante


    // Constructor de la clase Estudiante
    public Estudiante(String correo, String contraseña, String idBanner, double saldo) {
        super(correo, contraseña); // Llama al constructor de la superclase Usuario
        this.idBanner = idBanner;
        this.saldo = saldo;
        this.vehiculos = new ArrayList<>(); // Inicializa la lista de vehículos vacía
    }
    // Método para obtener el ID Banner del estudiante
    public String getIdBanner() {
        return idBanner;
    }
    // Método para obtener el saldo del estudiante
    public double getSaldo() {
        return saldo;
    }
    // Método para recargar el saldo del estudiante
    public void recargarSaldo(double monto) {
        this.saldo += monto;
    }
    // Método para agregar un vehículo a la lista del estudiante
    public void agregarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.add(vehiculo);
    }
    // Método para remover un vehículo de la lista del estudiante
    public void removerVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    }
    // Método para obtener la lista de vehículos del estudiante
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}


