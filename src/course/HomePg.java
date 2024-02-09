package course;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class HomePg {

	private JFrame frame;
	public JFrame getFrame() {
	    return frame;
	}


    // Add constructor to accept email and role
   
    public HomePg(String email, String role) {
        initialize(email, role);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomePg window = new HomePg();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public HomePg() {
        initialize(null, null);
    }

	/**
	 * Initialize the contents of the frame.
	 * @param role 
	 * @param email 
	 */
	private void initialize(String email, String role) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0,0,0));
		frame.getContentPane().setLayout(null);
		
		JPanel leftpanel = new JPanel();
        leftpanel.setBounds(0, 0, 312, 700);
        Color leftPanelColor = new Color(7, 157, 120); // RGB values for #079D78
        leftpanel.setBackground(new Color(0, 128, 128));
        frame.getContentPane().add(leftpanel);
        leftpanel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("CMS");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        lblNewLabel.setBounds(107, 32, 104, 51);
        leftpanel.add(lblNewLabel);
        
        JPanel home_panel = new JPanel();
        home_panel.setBounds(10, 131, 292, 514);
        leftpanel.add(home_panel);
        home_panel.setLayout(null);
        
        JLabel tutor = new JLabel("New label");
        tutor.setIcon(new ImageIcon(HomePg.class.getResource("/CMS/images/training-icon1.png")));
        tutor.setBounds(22, 136, 32, 35);
        home_panel.add(tutor);
        
        JButton instructorButton = new JButton("Teachers");
        instructorButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        instructorButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        instructorButton.setForeground(new Color(0, 0, 0));
        instructorButton.setBackground(new Color(0, 128, 128));
        instructorButton.setBounds(64, 133, 186, 35);
        home_panel.add(instructorButton);
        
        JButton studentButton = new JButton("Students");
        studentButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        studentButton.setForeground(Color.BLACK);
        studentButton.setFont(new Font("Tahoma", Font.BOLD, 18));
        studentButton.setBackground(new Color(0, 128, 128));
        studentButton.setBounds(64, 210, 186, 35);
        home_panel.add(studentButton);
        
        JLabel std = new JLabel("");
        std.setIcon(new ImageIcon(HomePg.class.getResource("/CMS/images/graduation-cap0-icon.png")));
        std.setBounds(14, 213, 40, 35);
        home_panel.add(std);
        
        JLabel courseLabel = new JLabel("");
        courseLabel.setIcon(new ImageIcon(HomePg.class.getResource("/CMS/images/book-literature1-icon.png")));
        courseLabel.setBounds(22, 56, 32, 35);
        home_panel.add(courseLabel);
        
        JButton btnContact = new JButton("Contact");
        btnContact.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnContact.setForeground(Color.BLACK);
        btnContact.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnContact.setBackground(new Color(0, 128, 128));
        btnContact.setBounds(64, 352, 186, 35);
        home_panel.add(btnContact);
        
        JLabel std_1 = new JLabel("");
        std_1.setIcon(new ImageIcon(HomePg.class.getResource("/CMS/images/email-square1-icon.png")));
        std_1.setBounds(22, 352, 32, 35);
        home_panel.add(std_1);
        
        JButton logoutBtn = new JButton("Log Out");
        logoutBtn.setBackground(new Color(64, 128, 128));
        logoutBtn.setBounds(102, 443, 89, 23);
        home_panel.add(logoutBtn);
        
        JButton btnAdmin = new JButton("Admin");
        btnAdmin.setForeground(Color.BLACK);
        btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnAdmin.setBackground(new Color(0, 128, 128));
        btnAdmin.setBounds(64, 282, 186, 35);
        home_panel.add(btnAdmin);
        
        JLabel admin = new JLabel("");
        admin.setIcon(new ImageIcon(HomePg.class.getResource("/CMS/images/young-businessman1-icon.png")));
        admin.setBounds(22, 282, 32, 35);
        home_panel.add(admin);
        
        JComboBox<Object> comboBox = new JComboBox<Object>();
        comboBox.setBackground(new Color(0, 128, 128));
        comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
        comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"Courses", "BIT", "BIBM", "BCA"}));
        comboBox.setBounds(64, 56, 173, 35);
        home_panel.add(comboBox);
        
        JLabel home = new JLabel("New label");
        home.setBounds(39, 43, 28, 31);
        leftpanel.add(home);
        home.setIcon(new ImageIcon(HomePg.class.getResource("/CMS/images/categories-icon11.png")));
		
		JPanel right_panel = new JPanel();
		right_panel.setForeground(new Color(0, 128, 128));
		right_panel.setBackground(new Color(228, 228, 228));
		right_panel.setBounds(311, 0, 825, 700);
		frame.getContentPane().add(right_panel);
		frame.setBounds(100, 100, 1150, 792);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
