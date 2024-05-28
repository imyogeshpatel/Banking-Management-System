
package bms;
 
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;

public class Signuptwo extends JFrame implements ActionListener{
    

    JTextField pan,aadhar,statetf;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,income,occupation,education;
    String formno;
    
    Signuptwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM -PAGE 2");
        
        
        JLabel additionaldetails= new JLabel("PAGE 2:ADDITIONAL DETAILS");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);
        
       
        
        JLabel name= new JLabel("RELIGION:");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,400,30);
        add(name);
        
        String valReligion[]={"hindu","muslim","sikh","christian","other"};
        religion= new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        add(religion);
        
        
        
        
        JLabel fname= new JLabel("CATEGORY:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);
        
        String valcategory[]={"general","obc","sc","st","other"};
        category= new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        add(category);
        
   
        
        JLabel dob= new JLabel("INCOME:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);
        
        String incomecategory[]={"null","<1,50,000","<2,50,000","<5,00,000","upto 10 lac"};
        income= new JComboBox(incomecategory);
        income.setBounds(300,240,400,30);
        add(income);
        
      
        
        JLabel gender= new JLabel("EDUCATIONAL");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        
       
        JLabel email= new JLabel("QUALIFICATION:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);
        
        String ev[]={"non-grad","grad","pg","phd","others"};
        education= new JComboBox(ev);
        education.setBounds(300,315,400,30);
        add(education);
        
        
        
        JLabel ms= new JLabel("OCCUPATION:");
        ms.setFont(new Font("Raleway",Font.BOLD,20));
        ms.setBounds(100,390,200,30);
        add(ms);
        
        String ov[]={"salaried","self-emp","business","student","retired"};
        occupation= new JComboBox(ov);
        occupation.setBounds(300,390,400,30);
        add(occupation);
        
        
        
        JLabel address= new JLabel("PAN NUMBER:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,200,30);
        add(address);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,20));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel city= new JLabel("AADHAR NUMBER:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,200,30);
        add(city);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,20));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        
        
        JLabel state= new JLabel("SENIOR CITIZEN:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,200,30);
        add(state);
        
        syes= new JRadioButton("yes");
        syes.setBounds(300,540,100,30);
        add(syes);
        
        sno= new JRadioButton("no");
        sno.setBounds(450,540,100,30);
        add(sno);
        
        ButtonGroup msgroup= new ButtonGroup();
        msgroup.add(syes);
        msgroup.add(sno);
        
        
        
        JLabel pincode= new JLabel("EXISTING ACCOUNT:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);
        
        eyes= new JRadioButton("yes");
        eyes.setBounds(300,590,100,30);
        add(eyes);
        
        eno= new JRadioButton("no");
        eno.setBounds(450,590,100,30);
        add(eno);
        
        ButtonGroup emsgroup= new ButtonGroup();
        emsgroup.add(eyes);
        emsgroup.add(eno);
        
        
        
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
        
        String sreligion= (String)religion.getSelectedItem();
        String scategory= (String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if (syes.isSelected()){
        seniorcitizen="yes";}
        else if (sno.isSelected()){
        seniorcitizen="no";}
        
        
        String existingaccount=null;
        if (eyes.isSelected()){
        existingaccount="yes";}
        else if (eno.isSelected()){
        existingaccount="no";}
        
        String span= pan.getText();
        String saadhar=aadhar.getText();
      
        
        try{
            
                Conn c=new Conn();
                String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signupthree(formno).setVisible(true);
        }catch(Exception e){
            System.out.println(e);
        }
    
    }
    public static void main(String args[]){
        new Signuptwo("");
        
    
    
    }
    
}








