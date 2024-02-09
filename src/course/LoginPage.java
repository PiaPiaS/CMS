package course;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {
    private JComboBox<String> roleComboBox;
    private JFrame frame;
    private JTextField emailField;
    private JPasswordField passwordField;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginPage window = new LoginPage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LoginPage() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 746, 559);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(255, 255, 255));
        mainPanel.setBounds(360, 0, 372, 522);
        frame.getContentPane().add(mainPanel);
        mainPanel.setLayout(null);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setForeground(new Color(0, 128, 128));
        emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
        emailLabel.setBounds(25, 188, 113, 38);
        mainPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setForeground(new Color(0, 0, 0));
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        emailField.setBackground(new Color(255, 255, 255));
        emailField.setBounds(25, 237, 312, 38);
        mainPanel.add(emailField);
        emailField.setColumns(10);

        JLabel passLabel = new JLabel("Password");
        passLabel.setForeground(new Color(0, 128, 128));
        passLabel.setFont(new Font("Arial", Font.BOLD, 15));
        passLabel.setBounds(25, 286, 113, 38);
        mainPanel.add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.BOLD, 14));
        passwordField.setBackground(new Color(255, 255, 255));
        passwordField.setBounds(25, 335, 312, 38);
        mainPanel.add(passwordField);

        JButton loginButton = new JButton("Log in");
        loginButton.setForeground(new Color(0, 128, 128));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loginAction();
            }
        });
        loginButton.setFont(new Font("Arial", Font.BOLD, 15));
        loginButton.setBackground(new Color(255, 255, 255));
        loginButton.setBounds(25, 436, 149, 38);
        mainPanel.add(loginButton);

        JLabel lblNewLabel = new JLabel("Log In");
        lblNewLabel.setForeground(new Color(0, 128, 128));
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 35));
        lblNewLabel.setBounds(108, 32, 174, 38);
        mainPanel.add(lblNewLabel);

        JLabel loginAs = new JLabel("Log in As");
        loginAs.setForeground(new Color(0, 128, 128));
        loginAs.setFont(new Font("Arial", Font.BOLD, 15));
        loginAs.setBounds(25, 101, 113, 38);
        mainPanel.add(loginAs);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(0, 128, 128));
        leftPanel.setBounds(0, 0, 360, 522);
        frame.getContentPane().add(leftPanel);
        leftPanel.setLayout(null);

        frame.setVisible(true);

        String[] roles = {"Student", "Admin", "Instructor"};
        roleComboBox = new JComboBox<>(roles);
        roleComboBox.setBounds(25, 137, 312, 30);
        mainPanel.add(roleComboBox);
    }

    public void showLoginPage() {
        frame.setVisible(true);
    }

    private void loginAction() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String selectedRole = (String) roleComboBox.getSelectedItem();

        // Handle login based on the selected role
        Database db = new Database();
        switch (selectedRole.toLowerCase()) {
            case "student":
            case "admin":
            case "instructor":
                if (db.checkCredentials(email, password, selectedRole)) {
                    // If login is successful, direct to the homepage
                    frame.setVisible(false);
                    HomePg homePage = new HomePg(email, selectedRole);
                    homePage.getFrame().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid credentials");
                    clearFields();
                }
                break;
            default:
                JOptionPane.showMessageDialog(frame, "Invalid role selected");
        }
    }

    private void clearFields() {
        emailField.setText("");
        passwordField.setText("");
    }
}
