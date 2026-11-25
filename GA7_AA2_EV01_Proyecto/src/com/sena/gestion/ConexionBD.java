package com.sena.gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase para gestionar la conexión a la base de datos mediante JDBC.
 */
public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_gestion";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}
