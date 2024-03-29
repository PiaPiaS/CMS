package course;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AdminCourse {
    JTextField userTextat = new JTextField();
	JTextField userTextat1 = new JTextField();
	
	JFrame frameat3 = new JFrame("MANAGE COURSE:");
	
	JLabel label = new JLabel();
	JTable tableat = new JTable();
	static final String DB_URL = "jdbc:mysql://localhost/courseMsystem";
    static final String USERNAME = "root";
    static final String PASSWORD = "";
	
	void admincourse() {
		frameat3.getContentPane().setBackground(new Color(244,212,124));

		frameat3.setTitle("MANAGE COURSE: ");
		frameat3.setSize(650,650); // size of whole page 
		frameat3.setResizable(false);
		frameat3.setLayout(null);
		frameat3.setVisible(true);
	    frameat3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  
	    
	    JLabel Userlabelstd =new JLabel("Course   Details :");
	    Userlabelstd.setFont(new Font("Verdana", Font.PLAIN, 40));
	    Userlabelstd.setBounds(240,40,500,40); // X and Y with heights
	    frameat3.add(Userlabelstd);
 
	  
	    frameat3.setVisible(true);
	    
	    
	       // for COURSE id
	       JLabel Userlabelat1 =new JLabel("COURSE ID :");
	       Userlabelat1.setFont(new Font("Verdana", Font.PLAIN, 16));
	       Userlabelat1.setBounds(150,150,200,40); // X and Y with heights
	       frameat3.add(Userlabelat1);
	       
	       userTextat.setBounds(300,150,200,30);
	       frameat3.add(userTextat);

	       // for COURSE name
	       JLabel Userlabelat2 =new JLabel("COURSE NAME :");
	       Userlabelat2.setFont(new Font("Verdana", Font.PLAIN, 16));
	       Userlabelat2.setBounds(150,220,200,40); // X and Y with heights
	       frameat3.add(Userlabelat2);
	       
	       userTextat1.setBounds(300,220,200,30);
	       frameat3.add(userTextat1);
	    
	    // ADD BUTTONS:
	       
	       JButton buttonadad4 = new JButton("ADD COURSE");
	       buttonadad4.setFont(new Font("Verdana", Font.PLAIN, 16));
	       buttonadad4.setBounds(65,370,170,30);
	       frameat3.add(buttonadad4);
	       buttonadad4.addActionListener(new ActionListener() 
	        {
	        public void actionPerformed(ActionEvent e) {
	        	 
	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
//	                Connection connad=DriverManager.getConnection("jdbc:mysql://localhost:3306/connection","root","");
	                Connection connection= DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	              
	                PreparedStatement ps=connection.prepareStatement("insert into managecourse(id,coursename)values(?,?)");
	             
	                ps.setString(1, userTextat.getText());
	                ps.setString(2, userTextat1.getText());
	              
	                int x=ps.executeUpdate();
	                if (x>0) {
	                    System.out.println("Sucessfully isert");
	                }
	                else {
	                    System.out.println("Not");
	                }
	              }catch(Exception ee) {
	                  System.out.println(ee);
	              }
	         

	              }
	              
	          });
		   
		      
	      
	       
	       
	       
	    
	    //EDIT BUTTONS:
	       JButton buttonad5 = new JButton("UPDATE COURSE");
	       buttonad5.setFont(new Font("Verdana", Font.PLAIN, 16));
	       buttonad5.setBounds(350,370,190,30);
	       frameat3.add(buttonad5); 
	       buttonad5.addActionListener(new ActionListener() 
	       {
	       public void actionPerformed(ActionEvent e) {
	           try {
	               Class.forName("com.mysql.cj.jdbc.Driver");
	               Connection connection1= DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	               PreparedStatement ps=connection1.prepareStatement(" UPDATE managecourse SET id=?, coursename=? WHERE  id=?" );
	               
	  
	               ps.setString(1, userTextat.getText());
	               ps.setString(2, userTextat1.getText());
	               ps.setString(3, userTextat.getText());
	               
	               int x=ps.executeUpdate();
	               if (x>0) {
	                   System.out.println("Update  Successfully");
	               }
	               else {
	                   System.out.println("Not");
	               }
	             }catch(Exception ed) {
	                 System.out.println(ed);
	             }
	        

	             }

	         });
	       
	       
	    //DELETE BUTTON
	       JButton buttonad6 = new JButton("DELETE COURSE");
	       buttonad6.setFont(new Font("Verdana", Font.PLAIN, 16));
	       buttonad6.setBounds(65,430,170,30);
	       frameat3.add(buttonad6);
	       buttonad6.addActionListener(new ActionListener() 
	       {
	       public void actionPerformed(ActionEvent e) {
	    	
	           try {
	               Class.forName("com.mysql.cj.jdbc.Driver");
	               Connection connad3= DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
	               PreparedStatement ps=connad3.prepareStatement("DELETE FROM managecourse where id=?");
	               
	  
	               ps.setString(1, userTextat.getText());
	               
	               
	               int x=ps.executeUpdate();
	               if (x>0) {
	                   System.out.println("Delete Sucessfully");
	               }
	               else {
	                   System.out.println("Not");
	               }
	             }catch(Exception ee) {
	                 System.out.println(ee);
	             }
	       

	             }

	         });
	     
	    //CLEAR BUTTON
	       JButton buttonad7 = new JButton("CLEAR COURSE");
	       buttonad7.setFont(new Font("Verdana", Font.PLAIN, 16));
	       buttonad7.setBounds(350,430,190,30);
	     
	       frameat3.add(buttonad7);   
	       buttonad7.addActionListener(new ActionListener() {
	           @Override
	       public void actionPerformed(ActionEvent eer) { 
	        	   userTextat.setText("");
	        	   userTextat1.setText("");
	           }
	              

	       });
	       
	       
	       // BACK BUTTON
        JButton buttonadb = new JButton("Back Admin");
        buttonadb.setFont(new Font("Verdana", Font.PLAIN, 16));
        buttonadb.setBounds(20,40,170,40);
    
        frameat3.add(buttonadb);
        buttonadb.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) { 
           
    		Administration  ad = new Administration();
    		
			ad.Adminiad();
			ad.Tablead();
			frameat3.setVisible(false);
    		ad.setVisible(true);
    			
    			

    			}

        });
	    
	}

	public static void main(String[] args) {
		 AdminCourse ad = new  AdminCourse();
		 ad.admincourse();

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}