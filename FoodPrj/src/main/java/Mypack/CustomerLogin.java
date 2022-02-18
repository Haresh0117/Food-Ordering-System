package Mypack;

import java.awt.FlowLayout;


import java.sql.*;
import java.awt.Graphics;

import javax.swing.*;

import java.awt.event.*;

public class CustomerLogin
{
private String[] args;

CustomerLogin()
{
    JFrame f=new JFrame("Food Ordering System - Login Page");

    JLabel l1= new JLabel("User Name        :");
    l1.setBounds(50,50,100,30);

   final JTextField t1= new JTextField(20);
    t1.setBounds(150,50,200,30);
    l1.setLabelFor(t1);

    JButton b=new JButton(" Login "); 
    b.setBounds(150,150,95,30); 

    JLabel l2= new JLabel("Phone Number :");
    l2.setBounds(50,100,150,30);

    final JTextField t2= new JTextField();
    t2.setBounds(150,100,200,30);
    l2.setLabelFor(t2);



    f.add(l1); 
    f.add(t1);
    f.add(l2);
    f.add(t2);
    f.add(b); 
    f.setSize(500,500);
    f.setLayout(null);
    f.setVisible(true);

    b.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
    try {

        Class.forName("com.mysql.jdbc.Driver");
        Connection c= DriverManager.getConnection("jdbc:mysql://localhost:3306/food","root","");
        Statement stmt=c.createStatement();
        String sql="Select *  from username where username='"+t1.getText()+"' and Phone_Number='" + t2.getText()+"'";
        ResultSet rs=stmt.executeQuery(sql);
        if(rs.next())
        {
            FoodMenu.main(args);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Username/Password Error", "ERROR", JOptionPane.ERROR_MESSAGE);
            t1.setText(null);
            t2.setText(null);
            t1.requestFocusInWindow();
        }
    }
    catch(Exception e1)
    {
        e1.printStackTrace();
    }
}

});
}
public static void main(String[] args)
{
    new CustomerLogin();


}
}