package com.sena.mvc;

import com.sena.mvc.controlador.ClienteControlador;

/**
 * Clase principal del módulo.
 * Demuestra la aplicación del framework MVC y el almacenamiento de datos.
 */
public class Main {
    public static void main(String[] args) {
        ClienteControlador controlador = new ClienteControlador();

        // Ejemplo de uso
        controlador.registrarCliente("Angel David", "Martinez Tirado", "angel.martinez@example.com");
        controlador.listarClientes();
    }
}
