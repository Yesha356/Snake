
import java.awt.Color;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author umesha
 */
public class main {
     public static void main(String[] args)
     { JFrame obj= new JFrame();
       gameplay Gameplay=new gameplay();
        obj.setBounds(10,10,905,700);
        obj.setBackground(Color.black);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(Gameplay);
        
        
     
     
     }
}
