
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JFrame implements ActionListener{
    JTextField t1,t2;
    JComboBox b1,b2,b3;
    JButton j1,j2;
    AddRooms(){
        JLabel l1 = new JLabel("Add Rooms");
        l1.setFont(new Font("Tahoma",Font.BOLD,18));
        l1.setBounds(150,20,110,20);
        add(l1);
        
        JLabel l2 = new JLabel("Room Number");
        l2.setFont(new Font("Tahoma",Font.PLAIN,16));
        l2.setBounds(60,80,120,30);
        add(l2);
        
        t1 = new JTextField();
        t1.setBounds(200,80,150,30);
        add(t1);
        
        JLabel avail = new JLabel("Available");
        avail.setFont(new Font("Tahoma",Font.PLAIN,16));
        avail.setBounds(60,130,120,30);
        add(avail);
        b1 = new JComboBox(new String[] {"Available","Occupied"});
        b1.setBounds(200,130,150,30);
        b1.setBackground(Color.WHITE);
        add(b1);
        
        
        JLabel clean = new JLabel("Cleaning Status");
        clean.setFont(new Font("Tahoma",Font.PLAIN,16));
        clean.setBounds(60,180,120,30);
        add(clean);
        b2 = new JComboBox(new String[] {"Cleaned","Dirty"});
        b2.setBounds(200,180,150,30);
        b2.setBackground(Color.WHITE);
        add(b2);
        
        JLabel price = new JLabel("Price");
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        price.setBounds(60,230,120,30);
        add(price);
        t2 = new JTextField();
        t2.setBounds(200,230,150,30);
        add(t2);
        
        JLabel type = new JLabel("Bed Type");
        type.setFont(new Font("Tahoma",Font.PLAIN,16));
        type.setBounds(60,280,120,30);
        add(type);
        b3 = new JComboBox(new String[] {"Single Bed","Double Bed"});
        b3.setBounds(200,280,150,30);
        b3.setBackground(Color.WHITE);
        add(b3);
        j1 = new JButton("Add Room");
        j1.setBounds(60,350,130,30);
        j1.addActionListener(this);
        j1.setBackground(Color.BLACK);
        j1.setForeground(Color.WHITE);
        add(j1);
        
        j2 = new JButton("Cancel");
        j2.setBounds(220,350,130,30);
        j2.addActionListener(this);
        j2.setBackground(Color.BLACK);
        j2.setForeground(Color.WHITE);
        add(j2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
        
        
        JLabel j3 =new JLabel(i1);
        j3.setBounds(400,30,500,350);
        add(j3);
        
        getContentPane().setBackground(Color.WHITE);
        
        setBounds(450,200,940,470);
        
        
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==j1)
        {
            String room = t1.getText();
            String avail = (String)b1.getSelectedItem();
            String status = (String)b2.getSelectedItem();
            String price = t2.getText();
            String type = (String)b3.getSelectedItem();
            conn c = new conn();
            try{
                String str = "INSERT INTO room values( '"+room+"', '"+avail+"', '"+status+"','"+price+"', '"+type+"')";
                c.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"New room Added");
                this.setVisible(false);
                }
            catch(Exception e){
                System.out.println(e);
                
            }
        }
        else if(ae.getSource()==j2)
        {
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddRooms();
    
    }
    
}
