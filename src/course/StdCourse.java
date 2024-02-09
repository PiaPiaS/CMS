import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StdCourse {

    private JFrame frame;
    private JButton[] courseButtons;
    private JPanel panel;
    private JLabel label;
    private JLabel labelOne;

    public StdCourse() {
        frame = new JFrame();
        courseButtons = new JButton[5];
        panel = new JPanel();
        label = new JLabel();
        labelOne = new JLabel();
    }

    // Display all courses
    public void allCourses() {
        conn();
        frame.setLayout(null);

        panel.setBounds(100, 50, 600, 600);
        panel.setBackground(new Color(0, 255, 255));
        frame.setSize(800, 800);
        frame.setTitle("Courses");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(0, 255, 255));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(panel);

        JButton backButton = new JButton("Back");
        backButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        backButton.setBounds(550, 50, 100, 30);
        frame.add(backButton);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student student = new Student();
                student.student();
                student.setVisible(true);
                frame.setVisible(false);
            }
        });

        ImageIcon image = new ImageIcon("logo.png");
        frame.setIconImage(image.getImage());
    }

    // Display modules for a selected course
    public void displayModules(String courseName) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql:///connection", "root", "");
            Statement myStatement = conn.createStatement();
            ResultSet myData = myStatement.executeQuery("select * from " + courseName);
            
            StringBuilder allModules = new StringBuilder();

            while (myData.next()) {
                if (myData.getString("LEVEL").equals("")) {
                    allModules.append(myData.getString("Module_Code")).append(":").append(myData.getString("Module_Name")).append("<br>");
                } else {
                    allModules.append(myData.getString("LEVEL")).append("<br>").append(myData.getString("Module_Code")).append(":").append(myData.getString("Module_Name")).append("<br>");
                }
            }

            panel.removeAll();
            panel.setVisible(false);
            labelOne.setText("<html>" + allModules + "</html>");
            panel.add(labelOne);
            panel.setVisible(true);
            panel.setBounds(100, 50, 600, 600);
        } catch (Exception e) {
            System.out.println("Error \n" + e);
        }
    }

    // Connection to get the list of courses
    public void conn() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/courseMsystem");
            Statement myStatement = connection.createStatement();
            ResultSet myData = myStatement.executeQuery("select * from course");

            ArrayList<String> courseNames = new ArrayList<>();
            while (myData.next()) {
                courseNames.add(myData.getString("course_name"));
            }

            for (int i = 0; i < courseNames.size(); i++) {
                courseButtons[i] = new JButton();
                courseButtons[i].setText(courseNames.get(i));
                courseButtons[i].setFont(new Font("MV Boli", Font.BOLD, 20));
                String name = courseNames.get(i);
                courseButtons[i].addActionListener(e -> displayModules(name));
                panel.add(courseButtons[i]);
            }

        } catch (Exception e) {
            System.out.println("Error \n" + e);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    StdCourse window = new StdCourse();
                    window.allCourses();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
