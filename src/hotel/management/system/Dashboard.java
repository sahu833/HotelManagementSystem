//6:24/39.14
package hotel.management.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener{
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    
    Dashboard(){
        mb = new JMenuBar();
        add(mb);
        m1 = new JMenu("HOTEL MANAGEMENT");
        m1.setForeground(Color.RED);
        mb.add(m1);
        m2 = new JMenu("ADMIN");
        m2.setForeground(Color.BLUE);
        mb.add(m2);
        i1 = new JMenuItem("RECEPTION");
        i1.addActionListener(this);
        m1.add(i1);
        i2 = new JMenuItem("ADD EMPLOYEE");
        i2.addActionListener(this);
        m2.add(i2);
        i3 = new JMenuItem("ADD ROOMS");
        i3.addActionListener(this);
        m2.add(i3);
        i4 = new JMenuItem("ADD DRIVERS");
        i4.addActionListener(this);
        m2.add(i4);
        mb.setBounds(0,0,1950,30);
        
        ImageIcon i5 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
        Image i6 = i5.getImage().getScaledInstance(1700,870,Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel l1 = new JLabel(i7);
        l1.setBounds(0,0,1700,870);
        add(l1);
        JLabel l2 = new JLabel("THE TAJ GROUP WELCOMES YOU");
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("TAHOMA",Font.PLAIN,42));
        l2.setBounds(550,80,1000,50);
        l1.add(l2);
        setLayout(null);
        setBounds(0,0,1600,870);
        setVisible(true);
}
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("RECEPTION")){
            new Reception().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD EMPLOYEE"))
        {
            new AddEmployee().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD ROOMS"))
        {
            new AddRooms().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD DRIVERS"))
        {
            new AddDriver().setVisible(true);
        }
    }
public static void main(String[] args){
    new Dashboard().setVisible(true);
}
}


