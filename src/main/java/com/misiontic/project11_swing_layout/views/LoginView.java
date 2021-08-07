/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.project11_swing_layout.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Ramon
 */
public class LoginView extends JPanel implements ActionListener{
    
    Image loginImage;
    JTextField username;
    JPasswordField password;
    JButton loginButton, clearButton, exitButton;
    GridBagConstraints constraints;
    
    public LoginView(){
        this.constraints = new GridBagConstraints();
        constraints.weighty = 1;
        constraints.weightx = 1;
        configPanel();
        initComponents();
    }
    
    private void configPanel(){
        setLayout(new GridBagLayout());
        //this.setBackground(Color.WHITE);
    }
    
    private void initComponents(){
      header();
      inputData();
      footer();
    }
    
    private void header(){
        JLabel description = new JLabel("Iniciar sesión");        
       constraints.gridx = 1;
       constraints.gridy = 0;
       constraints.gridwidth = 1; 
       constraints.gridheight = 1;
       constraints.insets = new Insets(40,40,0,0);
       constraints.anchor = GridBagConstraints.WEST;       
       this.add(description, constraints);
       constraints.insets = new Insets(0,0,0,0); 
       constraints.anchor = GridBagConstraints.CENTER;
     
       
      JLabel labelImg = new JLabel("");     
      ImageIcon img = new ImageIcon();
      img.setImage(this.cargarImagen("src/assets/Logo-Android.png", 150, 200));
      labelImg.setIcon(img);      
      constraints.gridx = 1;
      constraints.gridy = 1;
      constraints.gridwidth = 2; 
      constraints.gridheight = 1;
      constraints.anchor = GridBagConstraints.WEST;
      this.add(labelImg, constraints);
      constraints.anchor = GridBagConstraints.CENTER;
    }
    
    private void inputData(){
       JLabel labelUsername = new JLabel("User Name");       
       constraints.gridx = 0;
       constraints.gridy = 2;
       constraints.gridwidth = 1; 
       constraints.gridheight = 1;  
       constraints.insets = new Insets(0,0,0, 20);
       constraints.anchor = GridBagConstraints.EAST;       
       this.add(labelUsername, constraints);
       constraints.anchor = GridBagConstraints.CENTER;
       constraints.insets = new Insets(0,0,0, 0);
       
        
       
       username = new JTextField();
       username.setPreferredSize(new Dimension(120, 20));
       constraints.gridx = 1;
       constraints.gridy = 2;
       constraints.gridwidth = 1; 
       constraints.gridheight = 1;
       constraints.insets = new Insets(0,15,0, 0);
       constraints.anchor = GridBagConstraints.WEST;
       this.add(username, constraints);
       constraints.anchor = GridBagConstraints.CENTER;
       constraints.insets = new Insets(0,10,0, 0);
       
       JLabel labelPassword = new JLabel("Password");
       constraints.gridx = 0;
       constraints.gridy = 3;
       constraints.gridwidth = 1; 
       constraints.gridheight = 1;
       constraints.insets = new Insets(0,0,0, 20);       
       constraints.anchor = GridBagConstraints.EAST;
       this.add(labelPassword, constraints);
       constraints.anchor = GridBagConstraints.CENTER;
       constraints.insets = new Insets(0,0,0,0);
       
       password = new JPasswordField();       
       password.setPreferredSize(new Dimension(120, 20));
       constraints.gridx = 1;
       constraints.gridy = 3;
       constraints.gridwidth = 1; 
       constraints.gridheight = 1;
       constraints.insets = new Insets(0,15,0, 0);
       constraints.anchor = GridBagConstraints.WEST;
       this.add(password, constraints);
       constraints.anchor = GridBagConstraints.CENTER;
       constraints.insets = new Insets(0,0,0, 0);
    }
    
    private void footer(){
       loginButton = new JButton("Log in");
       loginButton.setPreferredSize(new Dimension(100, 25));
       constraints.gridx = 1;
       constraints.gridy = 4;
       constraints.gridwidth = 1; 
       constraints.gridheight = 1;
       constraints.insets = new Insets(0,24,0, 0);
       constraints.anchor = GridBagConstraints.WEST;
       loginButton.addActionListener(this);
       this.add(loginButton, constraints);
       constraints.anchor = GridBagConstraints.CENTER;
       constraints.insets = new Insets(0,0,0, 0);
       
       clearButton = new JButton("Clear"); 
       clearButton.setPreferredSize(new Dimension(100, 25));
       constraints.gridx = 1;
       constraints.gridy = 5;
       constraints.gridwidth = 1; 
       constraints.gridheight = 1;
       constraints.insets = new Insets(0,24,0, 0);
       constraints.anchor = GridBagConstraints.WEST;
       clearButton.addActionListener(this);
       this.add(clearButton, constraints);
       constraints.anchor = GridBagConstraints.CENTER;
       constraints.insets = new Insets(0,0,0, 0);

       
       exitButton = new JButton("Exit");
       exitButton.setPreferredSize(new Dimension(100, 25));
       constraints.gridx = 1;
       constraints.gridy = 6;
       constraints.gridwidth = 1; 
       constraints.gridheight = 1;
       constraints.insets = new Insets(0,24,40, 0);
       constraints.anchor = GridBagConstraints.WEST;
       exitButton.addActionListener(this);
       this.add(exitButton, constraints);
       constraints.anchor = GridBagConstraints.CENTER;
       constraints.insets = new Insets(0,0,0, 0);
    }
    
    private Image cargarImagen(String ruta, int newWidth, int newHeight){
       File imageLogin = new File(ruta);
        try{
           Image image = ImageIO.read(imageLogin);
           this.loginImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);           
        }
        catch(IOException e){
            System.out.println("error de lectura");
            JOptionPane.showMessageDialog(this, "Error de lectura de imagen");
        } 
        return this.loginImage;
    }
  
    private void borrar(){
        username.setText("");
        password.setText("");
    }
    
    private void entrar(){
        String user = username.getText();
        String pass = new String(this.password.getPassword());
        if(!user.equals("") && !pass.equals("")){          
          JOptionPane.showMessageDialog(this, "Bienvenido " + user); 
        }
        else{
           JOptionPane.showMessageDialog(this, "Debe diligenciar todos los campos");  
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {   
       Object clickedButton = e.getSource();       
       if(clickedButton == clearButton){
           borrar();
       }
       else if(clickedButton == exitButton){
           System.exit(0);
       }
       else{
           entrar();
       }
    }
}
