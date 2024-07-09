package org.parqueaderos.parqueadero; // Declaración del paquete al que pertenece esta clase

import java.util.ArrayList; // Importación de la clase ArrayList de la biblioteca estándar de Java
import java.util.List;

public class UDLA { // Declaración de la clase UDLA
    // Atributo privado que contiene la lista de estudiantes
    private List<Estudiante> estudiantes = new ArrayList<>();
    // Atributo privado que contiene la lista de administradores del parqueadero
    private List<AdministradorParqueadero> administradores = new ArrayList<>();

    // Método para agregar un estudiante a la lista de estudiantes
    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante); // Agrega el estudiante dado a la lista de estudiantes
    }
    // Eliminar un estudiante de la lista
    public void eliminarEstudiante(Estudiante estudiante) {
        estudiantes.remove(estudiante);
    }

    // Método para obtener la lista de estudiantes
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }  // Devuelve la lista de estudiantes

    // Método para buscar al estudiante  por su correo electrónico
    public Estudiante buscarEstudiantePorCorreo(String correo) {
        // Itera sobre la lista de estudiantes
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCorreo().equals(correo)) {
                return estudiante;
            }
        }
        return null;
    }
    // Agregar un administrador a la lista
    public void agregarAdministrador(AdministradorParqueadero administrador) {
        administradores.add(administrador);
    }

    // Buscar un usuario (estudiante o administrador) por su correo
    public Usuario buscarUsuarioPorCorreo(String correo) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCorreo().equals(correo)) {
                return estudiante;
            }
        }
        for (AdministradorParqueadero administrador : administradores) {
            if (administrador.getCorreo().equals(correo)) {
                return administrador;
            }
        }
        return null;
    }
}
