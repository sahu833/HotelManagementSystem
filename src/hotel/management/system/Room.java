
package hotel.management.system;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class Room extends JFrame implements ActionListener{
    JTable t1;
    JButton b1,b2;
    
    Room(){
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
        Image i3 = i1.getImage().getScaledInstance(600, 600,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l1 = new JLabel(i2);
       // l1.setBounds(500,0,600,600);  original
       l1.setBounds(500,70,600,350);
        add(l1);
        
        JLabel j1 = new JLabel("Room Number");
        j1.setBounds(10,10,100,20);
        add(j1);
        
        JLabel j2 = new JLabel("Availability");
        j2.setBounds(110,10,80,20);
        add(j2);
        
        JLabel j3 = new JLabel("Status");
        j3.setBounds(230,10,80,20);
        add(j3);
        
        JLabel j4 = new JLabel("Price");
        j4.setBounds(330,10,80,20);
        add(j4);
        
        JLabel j5 = new JLabel("Bed Type");
        j5.setBounds(410,10,60,20);
        add(j5);
        
        
        t1 = new JTable();
        t1.setBounds(0,40,500,400);
        add(t1);
        
        b1 = new JButton("Load Data");
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(100,460,120,30);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(250,460,120,30);
        add(b2);
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(450,200,1050,600);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                conn c = new conn();
                String str = "select * from room";
                ResultSet r = c.s.executeQuery(str);
                t1.setModel(DbUtils.resultSetToTableModel(r));
            }
            catch(Exception e){
                
            }
            
        }
        else if (ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
        
    }
    public static void main(String[] args){
        new Room().setVisible(true);
    }
    
}
