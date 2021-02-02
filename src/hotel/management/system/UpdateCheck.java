
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCheck extends JFrame implements ActionListener{
    
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5;
    
    UpdateCheck(){
        
        JLabel l1 = new JLabel("Check-In Details");
        l1.setFont(new Font("Tahoma", Font.PLAIN,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(80,30,200,30);
        add(l1);
        
        
        JLabel l2 = new JLabel("Customer-ID");
        l2.setBounds(50,80,100,20);
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
        c1.setBounds(200,80,150,25);
        add(c1);
        
        JLabel l3 = new JLabel("Room Number");
        l3.setBounds(50,120,100,20);
        add(l3);
        t1= new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);
        
        JLabel l4 = new JLabel("Name");
        l4.setBounds(50,160,100,20);
        add(l4);
        t2= new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);
        
        JLabel l5 = new JLabel("Check-In");
        l5.setBounds(50,200,100,20);
        add(l5);
        t3= new JTextField();
        t3.setBounds(200,200,150,25);
        add(t3);
        
        JLabel l6 = new JLabel("Amount Paid");
        l6.setBounds(50,240,100,20);
        add(l6);
        t4= new JTextField();
        t4.setBounds(200,240,150,25);
        add(t4);
        
        JLabel l7 = new JLabel("Pending Amount");
        l7.setBounds(50,280,100,20);
        add(l7);
        t5= new JTextField();
        t5.setBounds(200,280,150,25);
        add(t5);
        
        b1 = new JButton("Check");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(30,340,100,30);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Update");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(150,340,100,30);
        b2.addActionListener(this);
        add(b2);
        
        b3 = new JButton("Back");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(270,340,100,30);
        b3.addActionListener(this);
        add(b3);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
        JLabel j1 = new JLabel(i1);
        j1.setBounds(400,50,500,300);
        add(j1);
        
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        setBounds(300,200,980,500);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                conn c = new conn();
                String id = c1.getSelectedItem();
                String room = null;
                String deposit = null;
                int amountPaid ;
                String price = null;
                String str = "select * from customer where number = '"+id+"'";
                ResultSet r = c.s.executeQuery(str);
                
                while(r.next()){
                    t1.setText(r.getString("room"));
                    t2.setText(r.getString("name"));
                    t3.setText(r.getString("CheckedIn"));
                    t4.setText(r.getString("deposit"));
                    room = r.getString("room");
                    deposit = r.getString("deposit");
                    
                }
                
                ResultSet r2 = c.s.executeQuery("select * from room where room_number='"+room+"'");
                while(r2.next()){
                    price = r2.getString("price");
                    amountPaid = Integer.parseInt(price) - Integer.parseInt(deposit);
                    t5.setText(Integer.toString(amountPaid));
                }
            }catch(Exception e){
                }
        }
        else if (ae.getSource()==b2){
            try{
                                conn c = new conn();
                                
                                String s1 = c1.getSelectedItem();
				String s2 = t1.getText(); //room_number;    
                                String s3 = t2.getText(); //name    
                                String s4 = t3.getText(); //status;    
                                String s5 = t4.getText(); //deposit    
				
                                c.s.executeUpdate("update customer set room = '"+s2+"', name = '"+s3+"', CheckedIn = '"+s4+"', deposit = '"+s5+"' where number = '"+s1+"'");
                                
                                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                                new Reception().setVisible(true);
                                setVisible(false);
                            }catch(Exception ee){
                                System.out.println(ee);
                            }	
        }
        else if (ae.getSource()==b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new UpdateCheck().setVisible(true);
    }
}
