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
public class tablaBotones extends JPanel{
    botonsito[] aseintosVisuales = new botonsito[30];
  
    public tablaBotones(){
        
        setLayout(new GridLayout(6, 5));
        
        
        for (int i = 0; i < 30; i++) {
            botonsito b = new botonsito("Asiento " + i);
            aseintosVisuales[i] = b;
            b.setBackground(Color.green);
            int indice = i;
            b.setSize(100, 100);
            b.addActionListener(e -> {
            
            
            
            });
            
            
            add(b);
        }
        
    }
    
    public static void main (String[] args){
        tablaBotones tb = new tablaBotones();
        tb.setVisible(true);
     
    
    }
    
}
