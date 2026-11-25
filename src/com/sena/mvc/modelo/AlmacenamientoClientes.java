package com.sena.mvc.modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que integra herramienta de almacenamiento de datos (archivo de texto).
 * Simula persistencia de datos para el módulo.
 */
public class AlmacenamientoClientes {
    private static final String ARCHIVO = "datos/clientes.txt";

    public void guardar(Cliente cliente) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            writer.write(cliente.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar: " + e.getMessage());
        }
    }

    public List<Cliente> leerTodos() {
        List<Cliente> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    Cliente c = new Cliente(partes[1], partes[2], partes[3]);
                    c.setIdCliente(Integer.parseInt(partes[0]));
                    lista.add(c);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }
        return lista;
    }
}
