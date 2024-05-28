
package bms;
 
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class Signupone extends JFrame implements ActionListener{
    
    long random;
    JTextField nametf,fnametf,dobtf,emailtf,addresstf,citytf,statetf,pintf;
    JButton next;
    JRadioButton male,female,married,unmarried;
    JDateChooser dateChooser;
    Signupone(){
        setLayout(null);
        
        Random ran= new Random();
        random=Math.abs(ran.nextLong()%9000L)+1000L;
        
        JLabel formno= new JLabel("APPLICATION FORM NO."+random);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personaldetails= new JLabel("PAGE 1");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personaldetails.setBounds(290,80,400,30);
        add(personaldetails);
        
       
        
        JLabel name= new JLabel("NAME:");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,400,30);
        add(name);
        
        nametf=new JTextField();
        nametf.setFont(new Font("Raleway",Font.BOLD,20));
        nametf.setBounds(300,140,400,30);
        add(nametf);
        
        JLabel fname= new JLabel("FATHERS NAME:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        fnametf=new JTextField();
        fnametf.setFont(new Font("Raleway",Font.BOLD,20));
        fnametf.setBounds(300,190,400,30);
        add(fnametf);
        
        JLabel dob= new JLabel("DATE OF BIRTH:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        add(dateChooser);
        
        
        JLabel gender= new JLabel("GENDER:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        male= new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        add(male);
        
        female= new JRadioButton("female");
        female.setBounds(450,290,120,30);
        add(female);
        
        ButtonGroup gendergroup= new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email= new JLabel("EMAIL ADDRESS:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        
        emailtf=new JTextField();
        emailtf.setFont(new Font("Raleway",Font.BOLD,20));
        emailtf.setBounds(300,340,400,30);
        add(emailtf);
        
        JLabel ms= new JLabel("MARITAL STATUS:");
        ms.setFont(new Font("Raleway",Font.BOLD,20));
        ms.setBounds(100,390,200,30);
        add(ms);
        
        married= new JRadioButton("married");
        married.setBounds(300,390,100,30);
        add(married);
        
        unmarried= new JRadioButton("unmarried");
        unmarried.setBounds(450,390,100,30);
        add(unmarried);
        
        ButtonGroup msgroup= new ButtonGroup();
        msgroup.add(married);
        msgroup.add(unmarried);
        
        JLabel address= new JLabel("ADDRESS:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        addresstf=new JTextField();
        addresstf.setFont(new Font("Raleway",Font.BOLD,20));
        addresstf.setBounds(300,440,400,30);
        add(addresstf);
        
        JLabel city= new JLabel("CITY:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        citytf=new JTextField();
        citytf.setFont(new Font("Raleway",Font.BOLD,20));
        citytf.setBounds(300,490,400,30);
        add(citytf);
        
        
        
        JLabel state= new JLabel("STATE:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        statetf=new JTextField();
        statetf.setFont(new Font("Raleway",Font.BOLD,20));
        statetf.setBounds(300,540,400,30);
        add(statetf);
        
        JLabel pincode= new JLabel("PINCODE:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        pintf=new JTextField();
        pintf.setFont(new Font("Raleway",Font.BOLD,20));
        pintf.setBounds(300,590,400,30);
        add(pintf);
        
        next= new JButton("Next");
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    
    
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;
        String name= nametf.getText();
        String fname= fnametf.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if (male.isSelected()){
        gender="Male";}
        else if (female.isSelected()){
        gender="Female";}
        
        String email=emailtf.getText();
        String ms=null;
        if (married.isSelected()){
        ms="Married";}
        else if (unmarried.isSelected()){
        ms="Unmarried";}
        String address= addresstf.getText();
        String city=citytf.getText();
        String state=statetf.getText();
        String pincode=pintf.getText();
        
        try{
            if (name.equals("")){
            JOptionPane.showMessageDialog(null,"name is required" );}
            else{
                Conn c=new Conn();
                String query="insert into signupone values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+ms+"','"+address+"','"+city+"','"+pincode+"','"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signuptwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    
    }
    public static void main(String args[]){
        new Signupone();
        
    
    
    }
    
}
