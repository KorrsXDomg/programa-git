package com.sena.mvc.modelo;

/**
 * Clase modelo que representa la entidad Cliente.
 * Aplica el estándar de codificación: PascalCase para clases.
 */
public class Cliente {
    private int idCliente;      // Identificador único
    private String nombre;      // Nombre del cliente
    private String apellido;    // Apellido del cliente
    private String email;       // Correo electrónico

    public Cliente() {}

    public Cliente(String nombre, String apellido, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
    }

    // Getters y Setters
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return idCliente + "," + nombre + "," + apellido + "," + email;
    }
}
