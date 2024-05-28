
package bms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    JButton deposit,withdrawl,mini,pinchange,fastcash,balanceq,exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);
        
        deposit = new JButton("DEPOSIT");
        deposit.setBounds(170,415,150,35);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("CASH WITHDRAWL");
        withdrawl.setBounds(355,415,150,35);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastcash = new JButton("FAST CASH");
        fastcash.setBounds(170,440,150,35);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
        mini = new JButton("MINI STATEMENT");
        mini.setBounds(355,450,150,35);
        mini.addActionListener(this);
        image.add(mini);
        
        pinchange = new JButton("PIN CHANGE");
        pinchange.setBounds(170,485,150,35);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        balanceq = new JButton("BALANCE ENQUIRY");
        balanceq.setBounds(355,485,150,35);
        balanceq.addActionListener(this);
        image.add(balanceq);
        
        exit = new JButton("EXIT");
        exit.setBounds(355,520,150,35);
        exit.addActionListener(this);
        image.add(exit);
        
        
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==exit){
            System.exit(0);
        } else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }
            
        
        
        
        
        
    }
    public static void main(String args[]){
        new Transactions("");
    }
    
}
