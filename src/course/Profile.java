package course;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Profile {

	
	JTextField userTextpr = new JTextField();
	JTextField userTextpr1 = new JTextField();
	JTextField userTextpr2 = new JTextField();
	JTextField userTextpr3 = new JTextField();
	JTextField userTextpr4 = new JTextField();
	JTextField userTextpr5 = new JTextField();

	JComboBox<?> combpr1 = new JComboBox<Object>();
	JComboBox<?> combpr2 = new JComboBox<Object>();
	void profdetail() {
		JFrame framepr = new JFrame("profile details");
		JLabel labelpr = new JLabel();
		
		
		JPanel panelpr = new JPanel();
		framepr.add(panelpr); 
	    panelpr.setLayout(null);
		framepr.getContentPane().setBackground(new Color(0,255,255));

		framepr.setTitle("profile details");
		framepr.setSize(1600,1200); // size of whole page 
		framepr.setResizable(true);
		framepr.setLayout(null);
		framepr.setVisible(true);
	    framepr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    panelpr.setBounds(200,40,1000,700);
	   // first
	    JLabel myLabelpr;
	    String myStringpr = 
	        "<html><p> Hi! My name is Niraj Lamichhane . I am Currently Studying at Herald"
	        + " College and Pursing my bachlor degree in Bsc(Hons) in Computing.  " +
	        "This is My Project(Course Mangement System) where I have mainly used the "
	        + "Concepts of OOP along with the java Swing frameWork and Collections"
	        + "Where there are  three main Character in my project Student, Instructor and Admin.</p></html>";
	    myLabelpr = new JLabel(myStringpr);
	    myLabelpr.setBounds(20,10,400,480);
	    myLabelpr.setFont(new Font("Verdana", Font.PLAIN, 20));
	    panelpr.add(myLabelpr);
	   // image 
	    ImageIcon firstpr = new ImageIcon("niraj1.jpg");
		JLabel labelpr4 = new JLabel(firstpr);
		labelpr4.setBounds(530,20,400,400);
		labelpr.add(labelpr4);
	    panelpr.add(labelpr4);
	    // Instructor details 
	       JLabel Userlabelpr2 =new JLabel("PERSONAL DETAILS:");
	       Userlabelpr2.setFont(new Font("Verdana", Font.PLAIN, 40));
	       Userlabelpr2.setBounds(200,20,500,40); // X and Y with heights
	       panelpr.add(Userlabelpr2);
	     // NAME  
	       JLabel Userlabelpr1 =new JLabel("NAME : NIRAJ LAMICHHANE.");
	       Userlabelpr1.setFont(new Font("Verdana", Font.PLAIN, 20));
	       Userlabelpr1.setBounds(150,410,500,40); // X and Y with heights
	       panelpr.add(Userlabelpr1);
	      // UN ID
	       JLabel Userlabelpr3 =new JLabel("UNIVERSITY ID : 2059514");
	       Userlabelpr3.setFont(new Font("Verdana", Font.PLAIN, 20));
	       Userlabelpr3.setBounds(150,440,500,40); // X and Y with heights
	       panelpr.add(Userlabelpr3);
	      // COLLEGE
	       JLabel Userlabelpr4 =new JLabel("COLLEGE : HERALD COLLEGE(Kathmandu, Naxal)");
	       Userlabelpr4.setFont(new Font("Verdana", Font.PLAIN, 20));
	       Userlabelpr4.setBounds(150,470,550,40); // X and Y with heights
	       panelpr.add(Userlabelpr4);
	      // EMAIL
	       JLabel Userlabelpr5 =new JLabel("EMAIL :lamichhaneniraj2058@gmail.com");
	       Userlabelpr5.setFont(new Font("Verdana", Font.PLAIN, 20));
	       Userlabelpr5.setBounds(150,500,500,40); // X and Y with heights
	       panelpr.add(Userlabelpr5);
	       
	       JLabel Userlabelpr6 =new JLabel("PHONE NUMBER : 9864055950");
	       Userlabelpr6.setFont(new Font("Verdana", Font.PLAIN, 20));
	       Userlabelpr6.setBounds(150,530,500,40); // X and Y with heights
	       panelpr.add(Userlabelpr6);
	       
	       JLabel Userlabelpr7=new JLabel("PROJECT : COURSE MANAGEMENT SYSTEM");
	       Userlabelpr7.setFont(new Font("Verdana", Font.PLAIN, 30));
	       Userlabelpr7.setBounds(100,580,700,40); // X and Y with heights
	       panelpr.add(Userlabelpr7);
		    // button for back
	        JButton buttonprb = new JButton("Back");
	        buttonprb.setFont(new Font("Verdana", Font.PLAIN, 16));
	        buttonprb.setBounds(50,50,100,30);
	        framepr.add(buttonprb);
	        buttonprb.addActionListener(new ActionListener() {
	            @Override
	        public void actionPerformed(ActionEvent e) { 
	            	CMS cms = new CMS();
	    			cms.Logincms();

	    			framepr.dispose();}

	        });
	        framepr.add(labelpr);
	        
	        
			// set color inside the border 
			panelpr.setOpaque(true); // we can only set color only if it is opaque
			panelpr.setBackground(new Color(244,212,124));
			framepr.add(panelpr);
	    	// for border 
			panelpr.setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10, Color.RED));
	        // to make all visible and should be kept at button only 
	        framepr.setVisible(true);//Make Frame Visible 
	        
		}

	public static void main(String[] args) {
		Profile pro = new Profile();
		
		pro.profdetail();
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}