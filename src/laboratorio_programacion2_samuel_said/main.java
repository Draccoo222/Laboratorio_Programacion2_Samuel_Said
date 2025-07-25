/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio_programacion2_samuel_said;
import javax.swing.*;
import java.awt.*;
      
/**
 *
 * @author unwir
 */
public class main extends JFrame{
    
    public main(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel a = new JLabel();
        a.setText("HOLA MUNDO");
        
        add(a);
    }
    
    public static void main(String[] args){
        main b = new main();
        b.setVisible(true);
    } 
}
