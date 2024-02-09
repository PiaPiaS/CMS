package course;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class signInPg {
    JFrame frame;
    private JTextField usernameField;
    private JTextField emailField;
    private JPasswordField passwordField_1;
    private JPasswordField passwordField_2;
    private JComboBox<String> roleComboBox;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    signInPg window = new signInPg();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public signInPg() {
        initialize();
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
    	frame = new JFrame();
        frame.setBounds(100, 100, 791, 532);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Left Panel
        JPanel panel = new JPanel();
        panel.setBackground(new Color(64, 128, 128));
        panel.setBounds(0, 0, 296, 495);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        // Load the image using the class loader
//        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/week10/images/imgs.jpg"));
        JLabel imageLabel = new JLabel(new ImageIcon(signInPg.class.getResource("/CMS/images/imgs.jpg")));
        imageLabel.setBackground(new Color(255, 255, 255));
        imageLabel.setBounds(0, 0, 296, 495);
        panel.add(imageLabel);

        // Right Panel
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(285, 0, 492, 495);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JPanel info_panel = new JPanel();
        info_panel.setBackground(new Color(0, 128, 128));
        info_panel.setBounds(10, 0, 482, 495);
        panel_1.add(info_panel);
        info_panel.setLayout(null);

        JLabel emailLabel = new JLabel("Email: ");
        emailLabel.setBounds(33, 159, 90, 14);
        emailLabel.setForeground(new Color(255, 255, 255));
        emailLabel.setFont(new Font("Arial", Font.BOLD, 14));
        emailLabel.setBackground(new Color(255, 255, 255));
        info_panel.add(emailLabel);

        usernameField = new JTextField();
        usernameField.setBounds(123, 102, 317, 33);
        info_panel.add(usernameField);
        usernameField.setColumns(10);

        JLabel userNameLabel_1 = new JLabel("Username: ");
        userNameLabel_1.setBounds(33, 104, 90, 14);
        userNameLabel_1.setForeground(Color.WHITE);
        userNameLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
        userNameLabel_1.setBackground(Color.WHITE);
        info_panel.add(userNameLabel_1);

        emailField = new JTextField();
        emailField.setBounds(123, 157, 317, 33);
        emailField.setColumns(10);
        info_panel.add(emailField);

        passwordField_1 = new JPasswordField();
        passwordField_1.setBounds(123, 219, 317, 33);
        info_panel.add(passwordField_1);

        JLabel passwordLabel_1_1 = new JLabel("Password: ");
        passwordLabel_1_1.setBounds(33, 221, 90, 14);
        passwordLabel_1_1.setForeground(Color.WHITE);
        passwordLabel_1_1.setFont(new Font("Arial", Font.BOLD, 14));
        passwordLabel_1_1.setBackground(Color.WHITE);
        info_panel.add(passwordLabel_1_1);

        JButton SignUpBtn_1 = new JButton("Sign Up");
        SignUpBtn_1.setForeground(new Color(0, 128, 128));
        SignUpBtn_1.setBounds(36, 430, 117, 33);
        SignUpBtn_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                signUp();
            }
        });
        SignUpBtn_1.setFont(new Font("Arial", Font.BOLD, 14));
        SignUpBtn_1.setBackground(Color.WHITE);
        info_panel.add(SignUpBtn_1);

        passwordField_2 = new JPasswordField();
        passwordField_2.setBounds(184, 273, 256, 33);
        info_panel.add(passwordField_2);

        JLabel passwordVerifyField = new JLabel("Re-enter Password: ");
        passwordVerifyField.setForeground(Color.WHITE);
        passwordVerifyField.setFont(new Font("Arial", Font.BOLD, 14));
        passwordVerifyField.setBackground(Color.WHITE);
        passwordVerifyField.setBounds(33, 275, 141, 14);
        info_panel.add(passwordVerifyField);

        JLabel logQn = new JLabel("Already have an account?");
        logQn.setForeground(new Color(255, 255, 255));
        logQn.setFont(new Font("Arial", Font.BOLD, 13));
        logQn.setBounds(281, 394, 191, 25);
        info_panel.add(logQn);

        JButton logInBtn = new JButton("Log in");
        logInBtn.setForeground(new Color(0, 128, 128));
        logInBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openLoginPage();
            }
        });
        logInBtn.setFont(new Font("Arial", Font.BOLD, 14));
        logInBtn.setBackground(Color.WHITE);
        logInBtn.setBounds(323, 430, 117, 33);
        info_panel.add(logInBtn);

        JLabel signUpHeader = new JLabel("Sign Up");
        signUpHeader.setForeground(new Color(255, 255, 255));
        signUpHeader.setFont(new Font("Arial", Font.BOLD, 35));
        signUpHeader.setBackground(new Color(255, 255, 255));
        signUpHeader.setBounds(179, 11, 141, 41);
        info_panel.add(signUpHeader);

        JLabel lblUser = new JLabel("User: ");
        lblUser.setForeground(Color.WHITE);
        lblUser.setFont(new Font("Arial", Font.BOLD, 14));
        lblUser.setBackground(Color.WHITE);
        lblUser.setBounds(33, 328, 141, 14);
        info_panel.add(lblUser);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(0, 128, 128));
        leftPanel.setBounds(0, 0, 360, 522);
        frame.getContentPane().add(leftPanel);
        leftPanel.setLayout(null);

        frame.setVisible(true);

        String[] roles = {"Student", "Instructor"};
        roleComboBox = new JComboBox<>(roles);
        roleComboBox.setModel(new DefaultComboBoxModel(new String[] {"Student", "Instructor"}));
        roleComboBox.setBounds(89, 321, 351, 30);
        info_panel.add(roleComboBox);
    }

    private void openLoginPage() {
        frame.dispose(); // Close the current signup page
        LoginPage loginPage = new LoginPage();
        loginPage.showLoginPage();
    }
    private void signUp() {
        String username = usernameField.getText();
        String email = emailField.getText();
        char[] passwordChars = passwordField_1.getPassword();
        String password = new String(passwordChars);
        char[] verifyPasswordChars = passwordField_2.getPassword();
        String verifyPassword = new String(verifyPasswordChars);
        String role = roleComboBox.getSelectedItem().toString();

        try {
            validateInput(username, email, password, verifyPassword);

  
            Database db = new Database(); // Create an instance of the Database class


            // Insert user into the appropriate table based on the role
            switch (role.toLowerCase()) {
                case "student":
                    db.insertStudent(username, email, password);
                    break;
              
                case "instructor":
                    db.insertInstructor(username, email, password);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid role: " + role);
            }

            // If everything is successful, show a success message
            JOptionPane.showMessageDialog(frame, "Sign up successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (IllegalArgumentException | SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void validateInput(String username, String email, String password, String verifyPassword) {
        // Check if username, email, and passwords are not empty
        if (username.isEmpty() || email.isEmpty() || password.isEmpty() || verifyPassword.isEmpty()) {
            throw new IllegalArgumentException("All fields must be filled.");
        }

        // Check if passwords match
        if (!password.equals(verifyPassword)) {
            throw new IllegalArgumentException("Passwords do not match.");
        }

        // Check password criteria
        if (!isValidPassword(password)) {
            throw new IllegalArgumentException("Password must have at least 8 characters and contain both letters, numbers, and special characters.");
        }

        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email address.");
        }
    }

    private void clearFields() {
        usernameField.setText("");
        emailField.setText("");
        passwordField_1.setText("");
        passwordField_2.setText("");
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 8 && password.matches(".*[a-zA-Z].*") && password.matches(".*\\d.*") && password.matches(".*[_$@!].*");
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:gmail\\.com|yahoo\\.com|outlook\\.com)$";
        return email.matches(emailRegex);
    }
}

       
