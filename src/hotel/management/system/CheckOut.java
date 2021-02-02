//10:57/24:13

package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class CheckOut extends JFrame implements ActionListener{
    Choice c1;
    JTextField t1;
    JButton b1,b2,b3;
    CheckOut()
    {
        JLabel l1 = new JLabel("Check-Out");
        l1.setBounds(100,20,100,30);
        l1.setForeground(Color.BLUE);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);
        
        JLabel l2 = new JLabel("Customer ID");
        l2.setBounds(30,80,100,30);
        add(l2);
        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet r = c.s.executeQuery("select * from customer");
            
            while(r.next()){
                c1.add(r.getString("number"));
            }
        }catch(Exception e){
            
        }
        c1.setBounds(150,85,185,30);
        add(c1);
        
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,130,100,30);
        add(l3);
        t1 = new JTextField();
        t1.setBounds(150,130,150,30);
        add(t1);
        
        b1 = new JButton("Checkout");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30,200,120,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(170,200,120,30);
        b2.addActionListener(this);
        add(b2);
        
      getContentPane().setBackground(Color.WHITE);
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
        Image i3 = i1.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        b3 = new JButton(i2); 
        b3.setBounds(310,85,20,20);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel j1 = new JLabel(i6);
        j1.setBounds(350,0,400,250);
        add(j1);
        
        setLayout(null);
        setBounds(500,200,800,300);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String id = c1.getSelectedItem();
            String room = t1.getText();
            String str = "delete from customer where number = '"+id+"'";
            String str2 = "update room set available = 'Available' where room_number = '"+room+"'";
            try{
                conn c = new conn();
                c.s.executeUpdate(str);
                c.s.executeUpdate(str2);
                JOptionPane.showMessageDialog(null,"CheckOut Done");
                new Reception().setVisible(true); 
                this.setVisible(false);
                
            }catch(Exception e){
                System.out.println(e);
            } 
               
            
        }
        else if (ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
        else if (ae.getSource()==b3){
            try{
            conn c = new conn();
            String id = c1.getSelectedItem();
            ResultSet r = c.s.executeQuery("select * from customer where number = '"+id+"'");
            while(r.next()){
                t1.setText(r.getString("room"));
        }}catch(Exception e){
            System.out.println(e);
        }
        }
    }
    public static void main(String[] args){
        new CheckOut().setVisible(true);
    }
    
}
