package org.example;
import java.sql.*;
import java.util.Scanner;

public class AuthorsBrowser {
    public static void main(String[] args) {
        try (Connection connection = DatabaseUtil.getConnection();
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("All authors:");
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("SELECT * FROM Authors")) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("AuthorID");
                    String firstName = resultSet.getString("FirstName");
                    String lastName = resultSet.getString("LastName");
                    System.out.println("ID: " + id + " — " + firstName + " " + lastName);
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }

            System.out.print("Enter last-name prefix to search: ");
            String prefix = scanner.nextLine();
            try (PreparedStatement preparedStatement =
                         connection.prepareStatement("SELECT * FROM Authors WHERE LastName LIKE ?")) {
                preparedStatement.setString(1, prefix + "%");
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    boolean found = false;
                    while (resultSet.next()) {
                        found = true;
                        int id = resultSet.getInt("AuthorID");
                        String firstName = resultSet.getString("FirstName");
                        String lastName = resultSet.getString("LastName");
                        System.out.println("ID: " + id + " — " + firstName + " " + lastName);
                    }

                    if (!found) {
                        System.out.println("No results found.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }
}