package com.sena.servicio;

import java.util.HashMap;
import java.util.Map;

/**
 * Servicio web para registro e inicio de sesión.
 * Recibe usuario y contraseña, valida y devuelve mensaje de éxito o error.
 */
public class ServicioAutenticacion {

    // Almacenamiento simple de usuarios (en producción sería una base de datos)
    private static Map<String, String> usuarios = new HashMap<>();

    /**
     * Servicio de registro de usuario.
     * @param usuario nombre de usuario
     * @param contrasena contraseña
     * @return mensaje de resultado
     */
    public String registrar(String usuario, String contrasena) {
        // Validaciones
        if (usuario == null || usuario.trim().isEmpty()) {
            return "Error: El usuario no puede estar vacío.";
        }
        if (contrasena == null || contrasena.length() < 4) {
            return "Error: La contraseña debe tener al menos 4 caracteres.";
        }
        if (usuarios.containsKey(usuario)) {
            return "Error: El usuario ya existe.";
        }

        usuarios.put(usuario, contrasena);
        return "Registro exitoso. Usuario creado correctamente.";
    }

    /**
     * Servicio de inicio de sesión.
     * @param usuario nombre de usuario
     * @param contrasena contraseña
     * @return mensaje de autenticación
     */
    public String iniciarSesion(String usuario, String contrasena) {
        // Validaciones
        if (usuario == null || contrasena == null) {
            return "Error en la autenticación: Datos incompletos.";
        }
        if (!usuarios.containsKey(usuario)) {
            return "Error en la autenticación: Usuario no encontrado.";
        }
        if (!usuarios.get(usuario).equals(contrasena)) {
            return "Error en la autenticación: Contraseña incorrecta.";
        }

        return "Autenticación satisfactoria. Bienvenido " + usuario + ".";
    }

    // Método de prueba
    public static void main(String[] args) {
        ServicioAutenticacion servicio = new ServicioAutenticacion();

        System.out.println(servicio.registrar("angel", "1234"));
        System.out.println(servicio.iniciarSesion("angel", "1234"));
        System.out.println(servicio.iniciarSesion("angel", "wrong"));
    }
}
