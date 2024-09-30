package com.myproject.mysqljdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MySQLJDBC {
    public static void main(String[] args) {
        DBConnectionManager dbConnection = new DBConnectionManager();
        Connection connection = null;
        Scanner scanner = new Scanner(System.in); // Créer une seule instance de Scanner

        try {
            connection = dbConnection.connect();
            System.out.println("Connexion réussie à la base de données !");

            DevDataManager devDataManager = new DevDataManager(connection);
            devDataManager.createTable();
            devDataManager.insertData();
            devDataManager.displayMaxScripts();
            devDataManager.displayTotalScripts();
            devDataManager.calculateWeeklyScripts();
            devDataManager.calculateScriptsByDeveloper(scanner); // Passer le Scanner
            devDataManager.executeUserQuery(scanner); // Passer le Scanner

        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        } finally {
            // Assurez-vous que les ressources sont fermées même si des exceptions se produisent
            try {
                if (connection != null) connection.close();
                scanner.close(); // Fermer le Scanner ici
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }
}

