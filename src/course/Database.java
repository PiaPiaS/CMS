package course;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    static final String DB_URL = "jdbc:mysql://localhost/courseMsystem";
    static final String USERNAME = "root";
    static final String PASSWORD = "";

    public Connection getConnection() throws SQLException {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connecting to the database....");

            if (connection != null) {
                System.out.println("Database connected successfully!");

                createStudentTableIfNotExists(connection);
                // Commented out admin-related methods and table creation
                // createAdminTableIfNotExists(connection);
                createInstructorTableIfNotExists(connection);

                return connection;
            }
        } catch (SQLException exc) {
            System.out.println("Something went wrong while connecting to the database.");
            exc.printStackTrace();
            throw new SQLException("Error connecting to the database.", exc);
        }

        return null;
    }

    private void createInstructorTableIfNotExists(Connection connection) {
        String query = "CREATE TABLE IF NOT EXISTS instructor (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "username VARCHAR(255) NOT NULL," +
                "email VARCHAR(255) NOT NULL," +
                "password VARCHAR(255) NOT NULL," +
                "additional_instructor_field VARCHAR(255))";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error creating 'instructor' table.", ex);
        }
    }

    private void createStudentTableIfNotExists(Connection connection) {
        String query = "CREATE TABLE IF NOT EXISTS student (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "username VARCHAR(255) NOT NULL," +
                "email VARCHAR(255) NOT NULL," +
                "password VARCHAR(255) NOT NULL," +
                "additional_student_field VARCHAR(255))";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error creating 'student' table.", ex);
        }
    }

    public void insertStudent(String username, String email, String password) throws SQLException {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                createStudentTableIfNotExists(connection);

                String studentQuery = "INSERT INTO student (username, email, password, additional_student_field) VALUES (?, ?, ?, ?)";
                try (PreparedStatement studentStatement = connection.prepareStatement(studentQuery)) {
                    studentStatement.setString(1, username);
                    studentStatement.setString(2, email);
                    studentStatement.setString(3, password);
                    studentStatement.setString(4, "Additional student data");
                    studentStatement.executeUpdate();
                }
            }
        } catch (SQLException exc) {
            System.out.println("Something went wrong while connecting to the database.");
            exc.printStackTrace();
            throw new SQLException("Error connecting to the database.", exc);
        }
    }

    public void insertInstructor(String username, String email, String password) throws SQLException {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                createInstructorTableIfNotExists(connection);

                String instructorQuery = "INSERT INTO instructor (username, email, password, additional_instructor_field) VALUES (?, ?, ?, ?)";
                try (PreparedStatement instructorStatement = connection.prepareStatement(instructorQuery)) {
                    instructorStatement.setString(1, username);
                    instructorStatement.setString(2, email);
                    instructorStatement.setString(3, password);
                    instructorStatement.setString(4, "Additional instructor data");
                    instructorStatement.executeUpdate();
                }
            }
        } catch (SQLException exc) {
            System.out.println("Something went wrong while connecting to the database.");
            exc.printStackTrace();
            throw new SQLException("Error connecting to the database.", exc);
        }
    }

    public boolean checkCredentials(String email, String password, String role) {
        try (Connection connection = getConnection()) {
            String query;
            switch (role.toLowerCase()) {
                case "student":
                    query = "SELECT * FROM student WHERE email = ? AND password = ?";
                    break;
                case "instructor":
                    query = "SELECT * FROM instructor WHERE email = ? AND password = ?";
                    break;
               
                 case "admin":
                     query = "SELECT * FROM admin WHERE email = ? AND password = ?";
                     break;
                default:
                    System.out.println("Invalid role specified.");
                    return false;
            }

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, email);
                statement.setString(2, password);

                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    System.out.println("Login successful!");
                    return true;
                } else {
                    System.out.println("Incorrect email or password.");
                    return false;
                }
            }
        } catch (SQLException exc) {
            System.out.println("Something went wrong while connecting to the database.");
            exc.printStackTrace();
            throw new RuntimeException("Error connecting to the database.", exc);
        }
    }

    public static void main(String[] args) {
        // Test your methods here if needed
    }
}
