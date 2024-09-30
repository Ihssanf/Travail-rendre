package com.myproject.mysqljdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    // Remplacez ces constantes par vos informations de connexion
    private static final String URL = "jdbc:mysql://localhost:3306/basee";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    /**
     * Établit une connexion à la base de données MySQL.
     *
     * @return Une instance de Connection.
     * @throws SQLException Si une erreur de connexion se produit.
     */
    public Connection connect() throws SQLException {
        // Chargement explicite du driver (optionnel depuis JDBC 4.0)
        try {
            Class.forName("com.mysql.jdbc.Driver"); // Utiliser "com.mysql.jdbc.Driver" pour les anciennes versions
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL non trouvé. Assurez-vous que le driver est dans le classpath.");
            throw new SQLException(e);
        }

        // Établir la connexion
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
