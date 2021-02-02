//36/48:26 - 13/17
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
public class UpdateRoom extends JFrame implements ActionListener{
    JTextField t1,t2,t3;
    Choice c1;
    JButton b1,b2,b3;
    
    UpdateRoom(){
        
        JLabel l1 = new JLabel("Update Room Status");
        l1.setFont(new Font("Tahoma",Font.PLAIN,25));
        l1.setForeground(Color.BLUE);
        l1.setBounds(30,20,250,30);
        add(l1);
        
        JLabel l2 = new JLabel("Guest ID");
        l2.setBounds(30,80,120,20);
        add(l2);
        
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet r= c.s.executeQuery("select * from customer");
            while(r.next()){
                c1.add(r.getString("number"));
            }
        }
        catch(Exception e){
            
        }
        c1.setBounds(200,80,150,25);
        add(c1);
        
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,130,120,20);
        add(l3);
        t1 = new JTextField();
        t1.setBounds(200,130,150,25);
        add(t1);
        
        JLabel l4 = new JLabel("Availability");
        l4.setBounds(30,180,120,20);
        add(l4);
        t2 = new JTextField();
        t2.setBounds(200,180,150,25);
        add(t2);
        
        JLabel l5 = new JLabel("Clean Status");
        l5.setBounds(30,230,120,20);
        add(l5);
        t3 = new JTextField();
        t3.setBounds(200,230,150,25);
        add(t3);
        
        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        b1.setBounds(130,300,120,30);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(40,350,120,30);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.addActionListener(this);
        b3.setBounds(220,350,120,30);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/seventh.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel j1 = new JLabel(i2);
        j1.setBounds(400,40,500,300);
        add(j1);
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(300,200,980,450);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String room = null;
            String s1 = c1.getSelectedItem();
            conn c = new conn();
            try{
            ResultSet r = c.s.executeQuery("select * from customer where number ='"+s1+"' ");
            while(r.next()){
                t1.setText(r.getString("room"));
                room = r.getString("room");
            }
            
            ResultSet r2 = c.s.executeQuery("select * from room where room_number ='"+room+"' ");
            while(r2.next()){
                t2.setText(r2.getString("available"));
                t3.setText(r2.getString("clean_status"));
            }
            }catch(Exception e){
            
            }
        }
        else if (ae.getSource()==b2){
            try{
             conn c= new conn();
             String room = t1.getText();
             String available = t2.getText();
             String status = t3.getText();
             
             String str = "update room set available = '"+available+"', clean_status ='"+status+"' where room_number = '"+room+"' ";
             c.s.executeUpdate(str);
             JOptionPane.showMessageDialog(null,"Room Updated Successfully");
             new Reception().setVisible(true);
             this.setVisible(false);
            }
            catch(Exception e){
            }
            
        }
        else if (ae.getSource()==b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
        
    }
    
    public static void main(String[] args){
        new UpdateRoom().setVisible(true);
    }
    
}
