package Mypack;
import java.awt.*; 
import java.sql.*; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.event.*;

public class FoodMenu extends Canvas {
   public void paint(Graphics g) {  
      
          Toolkit t=Toolkit.getDefaultToolkit();  
          Image i=t.getImage("C:\\JavaFullStackDevelopment\\stsProjects\\FoodPrj\\Pictures\\download.jpg");  
          g.drawImage(i,100,100,this);  
          
          Image j=t.getImage("C:\\JavaFullStackDevelopment\\stsProjects\\FoodPrj\\Pictures\\images.jpg");  
          g.drawImage(j,750,100,this);
            
          Image k=t.getImage("C:\\JavaFullStackDevelopment\\stsProjects\\FoodPrj\\Pictures\\images (1).jpg");  
          g.drawImage(k,425,425,this);
          
          Image l=t.getImage("C:\\JavaFullStackDevelopment\\stsProjects\\FoodPrj\\Pictures\\download (1).jpg");  
          g.drawImage(l,1050,425,this);
          
          
          
          Image m=t.getImage("C:\\\\JavaFullStackDevelopment\\\\stsProjects\\\\FoodPrj\\\\Pictures\\\\47441144161_0fe47eda18_c.jpg");  
          g.drawImage(m,1350,100,this);
          
          
      }
   
   		FoodMenu()
          {  
            
          JFrame f=new JFrame(" Food Menu ");  
              
          JLabel l=new JLabel(" MENU ");
          l.setFont(new Font("Serif", Font.BOLD, 40));
          l.setBounds(825,20,400,50);
          
          
     final JLabel l1= new JLabel("Chicken Biriyani");
      l1.setFont(new Font("Serif", Font.BOLD, 20));
          l1.setBounds(165,295,250,50);
          
          final JLabel l2= new JLabel("Mutton Biriyani");
          l2.setFont(new Font("Serif", Font.BOLD, 20));
              l2.setBounds(825,295,250,50);
          
          final JLabel l3= new JLabel("Plain Biriyani");
      l3.setFont(new Font("Serif", Font.BOLD, 20));
          l3.setBounds(1450,295,200,50);
          
          final JLabel l4= new JLabel("Chicken Fried Noodles");
      l4.setFont(new Font("Serif", Font.BOLD, 20));
          l4.setBounds(465,625,300,50);
          
          final JLabel l5= new JLabel("Chicken Fried Rice");
      l5.setFont(new Font("Serif", Font.BOLD, 20));
          l5.setBounds(1100,625,300,50);
          
         
          
          
          
          String quantity[]= {"0","1","2","3"};
          final JComboBox cb1=new JComboBox(quantity);
          JLabel c1=new JLabel("Quantity:  ");
          c1.setBounds(150,350,90,20);
          cb1.setBounds(220,350,90,20);
          f.add(c1);
          f.add(cb1);
          
          final JComboBox cb3=new JComboBox(quantity);
          JLabel c3=new JLabel("Quantity:  ");
          c3.setBounds(1400,350,90,20);
          cb3.setBounds(1475,350,90,20);
          f.add(c3);
          f.add(cb3);
          
          final JComboBox cb2=new JComboBox(quantity);
          JLabel c2=new JLabel("Quantity:  ");
          c2.setBounds(800,350,90,20);
          cb2.setBounds(875,350,90,20);
          f.add(c2);
          f.add(cb2);
          
          final JComboBox cb4=new JComboBox(quantity);
          JLabel c4=new JLabel("Quantity:  ");
          c4.setBounds(475,675,90,20);
          cb4.setBounds(550,675,90,20);
          f.add(c4);
          f.add(cb4);
          
         
          
          final JComboBox cb5=new JComboBox(quantity);
          JLabel c5=new JLabel("Quantity:  ");
          c5.setBounds(1100,675,90,20);
          cb5.setBounds(1175,675,90,20);
          f.add(c5);
          f.add(cb5);
          
         JButton b=new JButton("ORDER");
         b.setBounds(850,800,100,30);
         b.addActionListener(new ActionListener() {
             private String[] args;

			public void actionPerformed(ActionEvent e){
                
                try
                {
                  
                  Class.forName("com.mysql.jdbc.Driver");
                Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","");
                
              Statement stmt=c.createStatement();
                String sql="update bill set Quantity='"+cb1.getSelectedItem()+"' where Food_Name ='" + l1.getText()+"'";
                PreparedStatement preparedStmt = c.prepareStatement(sql);
                preparedStmt.executeUpdate();
                
               
                
                String sql2="update bill set Quantity='"+cb2.getSelectedItem()+"' where Food_Name ='" + l2.getText()+"'";
                PreparedStatement preparedStmt2 = c.prepareStatement(sql2);
                preparedStmt2.executeUpdate();
                
                String sql3="update bill set Quantity='"+cb3.getSelectedItem()+"' where Food_Name ='" + l3.getText()+"'";
                PreparedStatement preparedStmt3 = c.prepareStatement(sql3);
                preparedStmt3.executeUpdate();
                
                String sql4="update bill set Quantity='"+cb4.getSelectedItem()+"' where Food_Name ='" + l4.getText()+"'";
                PreparedStatement preparedStmt4 = c.prepareStatement(sql4);
                preparedStmt4.executeUpdate();
                
                String sql5="update bill set Quantity='"+cb5.getSelectedItem()+"' where Food_Name ='" + l5.getText()+"'";
                PreparedStatement preparedStmt5 = c.prepareStatement(sql5);
                preparedStmt5.executeUpdate();
                
                Bill.main(args);
                }
                
                
                catch (Exception e1)
                {
                  System.err.println("Got an exception! ");
                  System.err.println(e1.getMessage());
                }
              }
            });
         
          
          f.add(l);
          f.add(l1);
          f.add(l2);
          f.add(l3);


          f.add(l4);
        
          f.add(l5);
          f.add(b);
          f.add(this);
          
          
          f.setSize(2000,1000);  
          f.setVisible(true);
          
          
      }  
          
          public static void main(String[] args)
          {
        	  new FoodMenu();
          }

}