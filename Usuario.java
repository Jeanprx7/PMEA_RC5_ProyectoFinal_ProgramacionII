package org.parqueaderos.parqueadero;

public class Usuario {
    private String correo; // Correo electrónico del usuario
    private String contraseña; // Contraseña del usuario

    // Constructor de la clase Usuario
    public Usuario(String correo, String contraseña) {
        this.correo = correo;
        this.contraseña = contraseña;
    }
    // Método para obtener el correo electrónico del usuario
    public String getCorreo() {
        return correo;
    }

    // Método para obtener la contraseña del usuario
    public String getContraseña() {
        return contraseña;
    }

    // Iniciar sesión verificando el correo y la contraseña
    public boolean iniciarSesion(String correo, String contraseña) {
        return this.correo.equals(correo) && this.contraseña.equals(contraseña);
    }
}


