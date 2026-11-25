package com.sena.gestion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO que implementa las operaciones CRUD para la entidad Cliente.
 */
public class ClienteDAO {

    public void insertar(Cliente cliente) {
        String sql = "INSERT INTO cliente (nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.executeUpdate();
            System.out.println("Cliente insertado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al insertar cliente: " + e.getMessage());
        }
    }

    public List<Cliente> consultarTodos() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setIdCliente(rs.getInt("id_cliente"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setEmail(rs.getString("email"));
                c.setTelefono(rs.getString("telefono"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar clientes: " + e.getMessage());
        }
        return lista;
    }

    public void actualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nombre=?, apellido=?, email=?, telefono=? WHERE id_cliente=?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setInt(5, cliente.getIdCliente());
            stmt.executeUpdate();
            System.out.println("Cliente actualizado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al actualizar cliente: " + e.getMessage());
        }
    }

    public void eliminar(int idCliente) {
        String sql = "DELETE FROM cliente WHERE id_cliente=?";
        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCliente);
            stmt.executeUpdate();
            System.out.println("Cliente eliminado correctamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
        }
    }
}
