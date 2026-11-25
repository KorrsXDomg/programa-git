package com.sena.mvc.controlador;

import com.sena.mvc.modelo.AlmacenamientoClientes;
import com.sena.mvc.modelo.Cliente;
import java.util.List;

/**
 * Controlador del módulo de clientes.
 * Aplica el patrón MVC (framework de arquitectura).
 */
public class ClienteControlador {
    private AlmacenamientoClientes almacenamiento = new AlmacenamientoClientes();

    public void registrarCliente(String nombre, String apellido, String email) {
        Cliente cliente = new Cliente(nombre, apellido, email);
        almacenamiento.guardar(cliente);
        System.out.println("Cliente registrado correctamente.");
    }

    public void listarClientes() {
        List<Cliente> clientes = almacenamiento.leerTodos();
        System.out.println("=== Listado de Clientes ===");
        for (Cliente c : clientes) {
            System.out.println(c.getIdCliente() + " - " + c.getNombre() + " " + c.getApellido() + " (" + c.getEmail() + ")");
        }
    }
}
