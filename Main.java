package org.parqueaderos.parqueadero;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de UDLA para gestionar estudiantes y administradores
        UDLA udla = new UDLA();
        // Creación de un objeto Scanner para la entrada de usuario
        Scanner scanner = new Scanner(System.in);

        // Crear algunos estudiantes de ejemplo
        Estudiante galoguevara = new Estudiante("galo.guevara.torres@udla.edu.ec", "password", "A00998511", 10.0);
        Estudiante rafaela = new Estudiante("rafaela.yanouch@udla.edu.ec", "password", "A001234412", 150.0);
        Estudiante jeanpaul = new Estudiante("jean.rodriguez@udla.edu.ec", "password", "A00987654", 50.0);
        Estudiante thais = new Estudiante("thais.rojas@udla.edu.ec", "password", "A00987654", 50.0);
        // Agregar los estudiantes al sistema UDLA
        udla.agregarEstudiante(galoguevara);
        udla.agregarEstudiante(rafaela);
        udla.agregarEstudiante(jeanpaul);
        udla.agregarEstudiante(thais);

        // Crear un administrador
        AdministradorParqueadero administrador = new AdministradorParqueadero("santiago.cordova.paredes@udla.edu.ec", "admin");
        udla.agregarAdministrador(administrador);

        boolean finalizarPrograma = false;

        // Bucle principal que permite interactuar con el sistema mediante la consola
        while (!finalizarPrograma) {
            System.out.println("Ingrese su correo (o 'exit' para finalizar el programa):");
            String correo = scanner.nextLine();

            if (correo.equalsIgnoreCase("exit")) {
                finalizarPrograma = true;
                break;
            }

            System.out.println("Ingrese su contraseña:");
            String contraseña = scanner.nextLine();

            // Buscar el usuario por correo
            Usuario usuarioLogueado = udla.buscarUsuarioPorCorreo(correo);

            // Verificar si el usuario encontrado es un estudiante
            if (usuarioLogueado instanceof Estudiante) {
                Estudiante estudianteLogueado = (Estudiante) usuarioLogueado;
                // Verificar la contraseña del estudiante
                if (estudianteLogueado.getContraseña().equals(contraseña)) {
                    boolean salir = false;
                    // Bucle para el menú de opciones del estudiante
                    while (!salir) {
                        System.out.println("\nMenú Estudiante:\n");
                        System.out.println("1. Ver vehículos registrados");
                        System.out.println("2. Registrar nuevo vehículo");
                        System.out.println("3. Eliminar vehículo");
                        System.out.println("4. Ver saldo");
                        System.out.println("5. Recargar saldo");
                        System.out.println("6. Transferir horas");
                        System.out.println("0. Salir");
                        try {
                            int opcion = scanner.nextInt();
                            scanner.nextLine();  // Consume newline

                            switch (opcion) {
                                case 1:
                                    // Mostrar vehículos registrados
                                    System.out.println("Vehículos registrados:");
                                    for (Vehiculo vehiculo : estudianteLogueado.getVehiculos()) {
                                        System.out.println("Matrícula: " + vehiculo.obtenerMatricula() + ", Tipo: " + vehiculo.obtenerTipo());
                                    }
                                    break;
                                case 2:
                                    // Registrar nuevo vehículo
                                    System.out.println("Ingrese la matrícula del nuevo vehículo:");
                                    String matricula = scanner.nextLine();
                                    System.out.println("Ingrese el tipo del nuevo vehículo:");
                                    String tipo = scanner.nextLine();
                                    Vehiculo nuevoVehiculo = new Vehiculo(matricula, tipo);
                                    estudianteLogueado.agregarVehiculo(nuevoVehiculo);
                                    System.out.println("Vehículo registrado exitosamente.");
                                    break;
                                case 3:
                                    // Eliminar vehículo
                                    System.out.println("Vehículos registrados:");
                                    for (Vehiculo vehiculo : estudianteLogueado.getVehiculos()) {
                                        System.out.println("Matrícula: " + vehiculo.obtenerMatricula() + ", Tipo: " + vehiculo.obtenerTipo());
                                    }
                                    System.out.println("Ingrese la matrícula del vehículo a eliminar (o 0 para cancelar):");
                                    matricula = scanner.nextLine();
                                    if (!matricula.equals("0")) {
                                        Vehiculo vehiculoAEliminar = null;
                                        for (Vehiculo vehiculo : estudianteLogueado.getVehiculos()) {
                                            if (vehiculo.obtenerMatricula().equals(matricula)) {
                                                vehiculoAEliminar = vehiculo;
                                                break;
                                            }
                                        }
                                        if (vehiculoAEliminar != null) {
                                            estudianteLogueado.removerVehiculo(vehiculoAEliminar);
                                            System.out.println("Vehículo eliminado exitosamente.");
                                        } else {
                                            System.out.println("Vehículo no encontrado.");
                                        }
                                    }
                                    break;
                                case 4:
                                    // Ver saldo
                                    System.out.println("Saldo actual: $" + estudianteLogueado.getSaldo());
                                    break;
                                case 5:
                                    // Recargar saldo
                                    System.out.println("Saldo actual: $" + estudianteLogueado.getSaldo());
                                    try {
                                        System.out.println("Ingrese el monto a recargar (o 0 para cancelar):");
                                        double monto = scanner.nextDouble();
                                        if (monto != 0) {
                                            estudianteLogueado.recargarSaldo(monto);
                                            System.out.println("Saldo recargado exitosamente. Nuevo saldo: $" + estudianteLogueado.getSaldo());
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Monto inválido. Intente de nuevo.");
                                        scanner.next();  // Clear invalid input
                                    }
                                    break;
                                case 6:
                                    // Transferir horas
                                    System.out.println("Estudiantes registrados:");
                                    for (Estudiante estudiante : udla.getEstudiantes()) {
                                        System.out.println("Correo: " + estudiante.getCorreo());
                                    }
                                    System.out.println("Ingrese el correo del estudiante al que desea transferir horas:");
                                    String correoDestino = scanner.nextLine();
                                    Estudiante estudianteDestino = udla.buscarEstudiantePorCorreo(correoDestino);
                                    if (estudianteDestino != null) {
                                        try {
                                            System.out.println("Ingrese el monto a transferir:");
                                            double montoTransferir = scanner.nextDouble();
                                            if (montoTransferir <= estudianteLogueado.getSaldo()) {
                                                estudianteLogueado.recargarSaldo(-montoTransferir);
                                                estudianteDestino.recargarSaldo(montoTransferir);
                                                System.out.println("Transferencia exitosa. Nuevo saldo: $" + estudianteLogueado.getSaldo());
                                            } else {
                                                System.out.println("Saldo insuficiente para realizar la transferencia.");
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("Monto inválido. Intente de nuevo.");
                                            scanner.next();  // Limpiar la entrada inválida
                                        }
                                    } else {
                                        System.out.println("Usuario no válido.");
                                    }
                                    break;
                                case 0:
                                    // Salir del menú de estudiante
                                    salir = true;
                                    break;
                                default:
                                    // Opción inválida del menú de estudiante
                                    System.out.println("Opción inválida. Intente de nuevo.");
                            }
                        } catch (InputMismatchException e) {
                            // Captura de excepciones para entradas no numéricas
                            System.out.println("Entrada inválida. Por favor, ingrese un número.");
                            scanner.next();  // Limpiar la entrada inválida
                        }
                    }
                } else {
                    System.out.println("Correo o contraseña incorrectos.");
                }
            } else if (usuarioLogueado instanceof AdministradorParqueadero) {
                // Verificar si el usuario encontrado es un administrador
                AdministradorParqueadero adminLogueado = (AdministradorParqueadero) usuarioLogueado;
                // Verificar la contraseña del administrador
                if (adminLogueado.getContraseña().equals(contraseña)) {
                    boolean salir = false;
                    // Bucle para el menú de opciones del administrador
                    while (!salir) {
                        System.out.println("\nMenú Administrador:\n");
                        System.out.println("1. Mostrar estudiantes registrados");
                        System.out.println("2. Eliminar estudiante");
                        System.out.println("0. Salir");
                        try {
                            int opcion = scanner.nextInt();
                            scanner.nextLine();  // Consume newline

                            switch (opcion) {
                                case 1:
                                    // Mostrar estudiantes registrados
                                    System.out.println("Estudiantes registrados:");
                                    for (Estudiante estudiante : udla.getEstudiantes()) {
                                        System.out.println("Correo: " + estudiante.getCorreo() + ", Saldo: $" + estudiante.getSaldo());
                                        for (Vehiculo vehiculo : estudiante.getVehiculos()) {
                                            System.out.println("    Vehículo - Matrícula: " + vehiculo.obtenerMatricula() + ", Tipo: " + vehiculo.obtenerTipo());
                                        }
                                    }
                                    break;
                                case 2:
                                    // Eliminar estudiante del sistema
                                    System.out.println("Estudiantes registrados:");
                                    for (Estudiante estudiante : udla.getEstudiantes()) {
                                        System.out.println("Correo: " + estudiante.getCorreo());
                                    }
                                    boolean correoValido = false;
                                    while (!correoValido) {
                                        System.out.println("Ingrese el correo del estudiante a eliminar (o 0 para cancelar):");
                                        String correoEliminar = scanner.nextLine();
                                        if (correoEliminar.equals("0")) {
                                            correoValido = true;
                                        } else {
                                            Estudiante estudianteAEliminar = udla.buscarEstudiantePorCorreo(correoEliminar);
                                            if (estudianteAEliminar != null) {
                                                udla.eliminarEstudiante(estudianteAEliminar);
                                                System.out.println("Estudiante eliminado exitosamente.");
                                                correoValido = true;
                                            } else {
                                                System.out.println("Correo no encontrado. Intente de nuevo.");
                                            }
                                        }
                                    }
                                    break;
                                case 0:
                                    // Salir del menú de administrador
                                    salir = true;
                                    break;
                                default:
                                    System.out.println("Opción inválida. Intente de nuevo.");
                            }
                        } catch (InputMismatchException e) {
                            // Captura de excepciones para entradas no numéricas
                            System.out.println("Entrada inválida. Por favor, ingrese un número.");
                            scanner.next();  // Limpiar la entrada inválida
                        }
                    }
                } else {
                    // Mensaje de error por correo o contraseña incorrectos
                    System.out.println("Correo o contraseña incorrectos.");
                }
            } else {
                // Mensaje de error por usuario no encontrado
                System.out.println("Usuario no encontrado.");
            }
        }
        // Cierre del objeto Scanner para liberar recursos
        scanner.close();
    }
}