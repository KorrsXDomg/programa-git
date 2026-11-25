package com.sena.gestion;

import java.util.List;

/**
 * Clase principal para probar las operaciones CRUD.
 */
public class Main {
    public static void main(String[] args) {
        ClienteDAO dao = new ClienteDAO();

        // INSERTAR
        Cliente nuevo = new Cliente("Angel David", "Martinez Tirado", "angel.martinez@example.com", "3001234567");
        dao.insertar(nuevo);

        // CONSULTAR
        List<Cliente> clientes = dao.consultarTodos();
        System.out.println("Listado de clientes:");
        for (Cliente c : clientes) {
            System.out.println(c.getIdCliente() + " - " + c.getNombre() + " " + c.getApellido());
        }

        // ACTUALIZAR (ejemplo con id 1)
        if (!clientes.isEmpty()) {
            Cliente actualizar = clientes.get(0);
            actualizar.setTelefono("3109876543");
            dao.actualizar(actualizar);
        }

        // ELIMINAR (ejemplo)
        // dao.eliminar(1);
    }
}
