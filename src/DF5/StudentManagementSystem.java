package DF5;

import java.sql.*;
import java.util.Scanner;

/**
 * This class manages student data in a database using JDBC.
 */
public class StudentManagementSystem {
    static Connection connection;
    static Scanner input = new Scanner(System.in);

    /**
     * Establishes a connection to the database.
     *
     * @return The database connection, or null if connection fails.
     */
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "");
            return connection;
        } catch (Exception e) {
            System.out.println("Failed to establish database connection: " + e.getMessage());
            return null;
        }
    }

    /**
     * Closes the database connection.
     */
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed successfully");
            }
        } catch (Exception e) {
            System.out.println("Failed to close connection: " + e.getMessage());
        }
    }

    /**
     * Adds a new student to the database.
     *
     * @param rollNo The roll number of the student.
     * @param name   The name of the student.
     */
    public static void addStudent(int rollNo, String name) {
        PreparedStatement stmt = null;
        try {
            connection = getConnection(); // Establish connection before adding student
            if (connection == null) {
                System.out.println("No database connection available");
                return;
            }

            String sql = "INSERT INTO students (roll_no, name) VALUES (?, ?)";
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, rollNo);
            stmt.setString(2, name);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student added successfully!");
            } else {
                System.out.println("Failed to add student");
            }
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                closeConnection();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    /**
     * Main method to register a student.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        System.out.println("JDBC Implementation");
        System.out.println("Register student");
        System.out.print("Please enter student roll no: ");
        int studentRollNo = input.nextInt();
        System.out.print("Please enter student name: ");
        input.nextLine(); // Consume newline
        String studentName = input.nextLine();

        addStudent(studentRollNo, studentName);
    }
}
